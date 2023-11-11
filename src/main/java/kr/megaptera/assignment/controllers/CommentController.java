package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    @GetMapping
    public List<CommentDto> list(@RequestParam("postId") String postId) {
        return commentService.getCommentDtos(postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(@RequestParam("postId") String postId, @RequestBody CommentDto commentDto) {
        return commentService.createCommentDto(postId, commentDto);
    }

    @PatchMapping("/{id}")
    public CommentDto update(@PathVariable("id") String commentId, @RequestBody CommentDto commentDto) {
        return commentService.updateCommentDto(commentId, commentDto);
    }

    @DeleteMapping("{id}")
    public CommentDto delete(@PathVariable("id") String commentId) {
        return commentService.delete(commentId);
    }

}
