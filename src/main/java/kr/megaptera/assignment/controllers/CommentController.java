package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
import org.springframework.http.HttpStatus;
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
    private List<CommentDto> getComments(@RequestParam("postId") String postId) {
        return commentService.findAll(postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private CommentDto createComment(@RequestParam("postId") String postId, @RequestBody CommentCreateDto commentCreateDto) {
        return commentService.create(postId, commentCreateDto);
    }

    @PatchMapping("/{id}")
    private CommentDto updateComment(@PathVariable("id") String commentId, @RequestParam("postId") String postId, @RequestBody CommentUpdateDto commentUpdateDto) {
        return commentService.update(commentId, postId, commentUpdateDto);
    }
}
