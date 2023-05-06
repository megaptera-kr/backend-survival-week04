package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.request.RqCreateCommentDto;
import kr.megaptera.assignment.dtos.request.RqUpdateCommentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/comments")
@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping()
    public ResponseEntity<List<CommentDto>> getCommentByPostId(@RequestParam("postId") int postId) {
        return commentService.getCommentByPostId(postId);
    }

    @PostMapping()
    public ResponseEntity<CommentDto> createComment(@RequestBody RqCreateCommentDto dto,
                                                    @RequestParam("postId") int postId) {
        return commentService.createComment(dto, postId);
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody RqUpdateCommentDto dto,
                                                    @PathVariable("commentId") int commentId,
                                                    @RequestParam("postId") int postId) {
        return commentService.updateComment(dto, postId, commentId);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<CommentDto> deleteComment(@PathVariable("commentId") int commentId,
                                                    @RequestParam("postId") int postId) {
        return commentService.deleteComment(postId, commentId);
    }
}
