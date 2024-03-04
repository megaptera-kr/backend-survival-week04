package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    public CommentController() {
        commentService = new CommentService();
    }

    @GetMapping
    public List<CommentDto> list(@RequestParam String postId) {
        List<CommentDto> commentDtos = commentService.getCommentDtos(postId);
        return commentDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto post(@RequestParam String postId, @RequestBody CommentCreateDto commentCreateDto) {
        CommentDto created = commentService.createComment(postId, commentCreateDto);
        return created;
    }

    @PatchMapping("/{id}")
    public CommentDto update(@PathVariable String id,
                             @RequestParam String postId,
                             @RequestBody CommentUpdateDto commentUpdateDto) {
        CommentDto updated = commentService.updateComment(id, postId, commentUpdateDto);
        return updated;
    }

    @DeleteMapping("/{id}")
    public CommentDto delete(@PathVariable String id, @RequestParam String postId) {
        CommentDto deleted = commentService.deleteComment(id, postId);
        return deleted;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String commentNotFound() {
        return "댓글을 찾을 수 없습니다.";
    }
}
