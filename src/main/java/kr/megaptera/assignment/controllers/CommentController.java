package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.comment.CommentCreateDto;
import kr.megaptera.assignment.dtos.comment.CommentDto;
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

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin("*")
public class CommentController {

    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    // 댓글 조회
    @GetMapping()
    public List<CommentDto> getCommentList(@RequestParam String postId) {
        return commentService.getCommentList(postId);
    }

    // 댓글 작성
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto createComment(@RequestParam String postId,
                                    @RequestBody CommentCreateDto commentCreateDto) {
        return commentService.createComment(postId, commentCreateDto);
    }

    // 댓글 수정
    @PatchMapping("/{commentId}")
    public CommentDto updateComment(@RequestParam String postId,
                                    @PathVariable String commentId,
                                    @RequestBody String content) {
        return commentService.updateComment(postId, commentId, content);
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public CommentDto deleteComment(@RequestParam String postId,
                                    @PathVariable String commentId) {
        return commentService.deleteComment(postId, commentId);
    }
}
