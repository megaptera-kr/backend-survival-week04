package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommentController {

    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }
    @GetMapping("/comments?postId={postId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> list(@PathVariable String postId){
        return commentService.findCommentList(postId);
    }

    @PostMapping("/comments?postId={postId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(@PathVariable String postId,@RequestBody CommentCreateDto commentDto) {
        return commentService.createComment(postId, commentDto);
    }

    @PatchMapping("/comments/{id}?postId={postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id, @PathVariable String postId,@RequestBody CommentUpdateDto commentUpdateDto) {
        commentService.updateComment(postId,id,commentUpdateDto);
    }

    @DeleteMapping("/comments/{id}?postId={postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id, @PathVariable String postId) {
        commentService.deleteComment(id, postId);
    }
}
