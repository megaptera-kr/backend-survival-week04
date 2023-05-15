package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
import kr.megaptera.assignment.exceptions.CommentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    @GetMapping
    private List<CommentDto> list(@RequestParam String postId) {
        return commentService.comments(postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private CommentDto create(
        @RequestParam String postId,
        @RequestBody CommentCreateDto commentCreateDto
    ) {
        return commentService.create(postId, commentCreateDto);
    }

    @PatchMapping("/{id}")
    private CommentDto update(
        @PathVariable String id,
        @RequestParam String postId,
        @RequestBody CommentUpdateDto commentUpdateDto
    ) {
        return commentService.update(id, commentUpdateDto);
    }

    @DeleteMapping("/{id}")
    private CommentDto delete(
        @PathVariable String id,
        @RequestParam String postId
    ) {
        return commentService.delete(id, postId);
    }

    @ExceptionHandler(CommentNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String commentNotFound() {
        return "댓글을 찾을 수 없습니다.";
    }
}
