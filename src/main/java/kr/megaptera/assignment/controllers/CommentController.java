package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.controllerDtos.CommentDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    @GetMapping
    public List<CommentDto> list(@RequestParam String postId) {
        List<CommentDto> commentDtos = commentService.getCommentDtos(postId);
        return commentDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(
            @RequestParam String postId,
            @RequestBody CommentDto commentDto
    ) {
        CommentDto comment = commentService.createComment(postId, commentDto);
        return comment;
    }

    @PatchMapping("/{id}")
    public CommentDto update(
            @PathVariable("id") String id,
            @RequestParam String postId,
            @RequestBody CommentDto commentDto
    ) {
        return commentService.updateComment(postId, commentDto);
    }

    @DeleteMapping("/{id}")
    public CommentDto delete(
            @PathVariable("id") String id,
            @RequestParam String postId
    ) {
        return commentService.deleteComment(id, postId);
    }
}
