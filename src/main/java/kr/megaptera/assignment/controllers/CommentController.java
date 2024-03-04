package kr.megaptera.assignment.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {
    private final ObjectMapper objectMapper;
    private final CommentService commentService;

    public CommentController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.commentService = new CommentService();
    }

    @GetMapping()
    public List<CommentDto> getComments(@PathVariable("postId") String postId){
        return commentService.getComments(postId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto postComment(@PathVariable("postId") String postId
                             , @RequestBody CommentDto commentDto){
        return commentService.postComment(postId, commentDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto patchComment(@PathVariable("id") String id
                              , @PathVariable("postId") String postId
                              , @RequestBody CommentDto commentDto){
        return commentService.patchComment(id, postId, commentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto deleteComment(@PathVariable("id") String id, @PathVariable("postId") String postId){
        return commentService.deleteComment(id, postId);
    }
}
