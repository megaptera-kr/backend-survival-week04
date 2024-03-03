package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
import kr.megaptera.assignment.exceptions.CommentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentController {
    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    @GetMapping
    public List<CommentDto> list(@RequestParam String postId) {
        return commentService.getCommentDots(postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(@RequestParam String postId,
                             @RequestBody CommentCreateDto commentCreateDto) {
        return commentService
                .createComment(postId, commentCreateDto);
    }

    @PatchMapping("/{id}")
    public CommentDto update(
            @PathVariable String id,
            @RequestParam String postId,
            @RequestBody CommentUpdateDto commentUpdatedDto
    ) {
        return commentService
                .updateComment(id, postId, commentUpdatedDto);
    }

    @DeleteMapping("/{id}")
    public CommentDto delete(
            @PathVariable String id,
            @RequestParam String postId
    ) {
        return commentService.deleteComment(id, postId);
    }

    @ExceptionHandler(CommentNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFound() { return "Not found comments."; }
}
