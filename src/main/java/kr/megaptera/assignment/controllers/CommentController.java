package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.*;
import kr.megaptera.assignment.dtos.comment.*;
import kr.megaptera.assignment.exceptions.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentController {

    private CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    @GetMapping
    public List<CommentDto> commentList(
            @RequestParam String postId
    ) {
        List<CommentDto> commentDtos = commentService.getCommentDtos(postId);

        return commentDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(
            @RequestParam String postId,
            @RequestBody CommentCreateDto commentCreateDto
    ) {
        CommentDto commentDto = commentService.create(postId, commentCreateDto);
        return commentDto;
    }

    @PatchMapping("/{id}")
    public CommentDto update(
            @PathVariable String id,
            @RequestParam String postId,
            @RequestBody CommentUpdateDto commentUpdateDto
    ) {
        CommentDto update = commentService.update(id, postId, commentUpdateDto);
        return update;
    }

    @DeleteMapping("/{id}")
    public CommentDto delete(
            @PathVariable String id,
            @RequestParam String postId
    ) {
        CommentDto delete = commentService.delete(id, postId);
        return delete;
    }


    @ExceptionHandler(CommentNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String commentNotFound() {
        return "Comment Not Found...";
    }
}
