package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.comment.CommentCreateDto;
import kr.megaptera.assignment.dtos.comment.CommentDto;
import kr.megaptera.assignment.dtos.comment.CommentUpdateDto;
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
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController() {
        commentService = new CommentService();
    }

    @GetMapping
    public List<CommentDto> list(@RequestParam String postId) {
        return commentService.getCommentDtos(postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(@RequestParam String postId,
                             @RequestBody CommentCreateDto commentCreateDto
    ) {
        return commentService.createCommentDto(postId, commentCreateDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto update(@PathVariable String id,
                             @RequestParam String postId,
                             @RequestBody CommentUpdateDto commentUpdateDto
    ) {

        return commentService.updateCommentDto(id, postId, commentUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto delete(@PathVariable String id,
                             @RequestParam String postId
    ) {
        return commentService.deleteCommentDto(id, postId);
    }
}
