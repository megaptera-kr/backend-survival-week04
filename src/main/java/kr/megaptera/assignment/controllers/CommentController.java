package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.comment.CommentCreateDto;
import kr.megaptera.assignment.dtos.comment.CommentResponseDto;
import kr.megaptera.assignment.dtos.comment.CommentUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/comments")
@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentResponseDto> listComment() {
        return commentService.list();
    }

    @GetMapping("/{id}")
    public CommentResponseDto getComment(@PathVariable String id) {
        return commentService.get(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponseDto createComment(@RequestBody CommentCreateDto CommentCreateDto) {
        return commentService.create(CommentCreateDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CommentResponseDto patchComments(@PathVariable String id, @RequestBody CommentUpdateDto CommentUpdateDto) {
        return commentService.update(id,CommentUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CommentResponseDto deleteComment(@PathVariable String id) {
        return commentService.delete(id);
    }
}
