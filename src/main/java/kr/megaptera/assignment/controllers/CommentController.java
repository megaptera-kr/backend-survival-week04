package kr.megaptera.assignment.controllers;


import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.PostId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    @GetMapping()
    public List<Comment> getComments(@PathVariable("postId") String postId){
        return commentService.getComments(postId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Comment postComment(@PathVariable("postId") String postId
                             , @RequestBody String author
                             , @RequestParam("content") String content){
        return commentService.postComment(postId, author, content);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment patchComment(@PathVariable("id") String id
                              , @PathVariable("postId") String postId
                              , @RequestParam("content") String content){
        return commentService.patchComment(id, postId, content);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment deleteComment(@PathVariable("id") String id, @PathVariable("postId") String postId){
        return commentService.deleteComment(id, postId);
    }
}
