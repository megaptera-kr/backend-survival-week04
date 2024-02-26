package kr.megaptera.assignment.controllers;


import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.PostId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    @GetMapping
    public List<Comment> getComments(@PathVariable("postId") String postId){
        return commentService.getComments(postId);
    }
}
