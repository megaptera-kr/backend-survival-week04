package kr.megaptera.assignment.controllers;

import java.util.List;
import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CreateCommentRequest;
import kr.megaptera.assignment.dtos.CreateCommentResponse;
import kr.megaptera.assignment.dtos.DeleteCommentResponse;
import kr.megaptera.assignment.dtos.GetCommentListResponse;
import kr.megaptera.assignment.dtos.UpdateCommentRequest;
import kr.megaptera.assignment.dtos.UpdateCommentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin("http://localhost:8000")
@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCommentResponse createComment(@RequestParam Long postId,
            @RequestBody CreateCommentRequest request) {
        return commentService.createComment(request.toComment(postId));
    }

    @GetMapping
    public List<GetCommentListResponse> getCommentList(@RequestParam Long postId) {
        return commentService.getCommentList(postId);
    }

    @PatchMapping("/{id}")
    public UpdateCommentResponse updateComment(@PathVariable Long id, @RequestParam Long postId,
            @RequestBody UpdateCommentRequest request) {
        return commentService.updateComment(id, postId, request);
    }

    @DeleteMapping("/{id}")
    public DeleteCommentResponse deleteComment(@PathVariable Long id, @RequestParam Long postId) {
        return commentService.deleteComment(id, postId);
    }
}
