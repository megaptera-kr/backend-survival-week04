package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
import kr.megaptera.assignment.exceptions.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    private ResponseEntity find(@RequestParam String postId) {
        var comments = commentService.findByPost(postId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping
    private ResponseEntity add(@RequestParam String postId, @RequestBody CommentCreateDto requestBody) {
        var comment = commentService.add(postId, requestBody);
        return ResponseEntity.created(URI.create("/comments/" + comment.getId())).body(comment);
    }

    @PatchMapping("/{commentId}")
    private ResponseEntity update(
            @PathVariable String commentId,
            @RequestParam String postId,
            @RequestBody CommentUpdateDto reqBody) throws CommentNotFoundException {

        // TODO : (dh) will be check exist post?
        var comment = commentService.update(commentId, reqBody);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/{commentId}")
    private ResponseEntity delete(@PathVariable String commentId) throws CommentNotFoundException {
        var comment = commentService.remove(commentId);
        return ResponseEntity.ok(comment);
    }

    @ExceptionHandler(CommentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void commentNotFound() {
    }
}
