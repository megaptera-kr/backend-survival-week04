package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.comments.CommentDto;
import kr.megaptera.assignment.dtos.comments.CreateCommentDto;
import kr.megaptera.assignment.dtos.comments.UpdateCommentDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
@CrossOrigin
public class CommentController {
    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    // 댓글 조회
    @GetMapping("")
    public List<CommentDto> getComment(@RequestParam("postId") String postId) {
        return this.commentService.getCommentDtos(postId);
    }

    // 댓글 작성
    @PostMapping("")
    public CommentDto postComment(@RequestParam("postId") String postId, @RequestBody CreateCommentDto createCommentDto) {
        return this.commentService.createComment(postId, createCommentDto.getAuthor(), createCommentDto.getContent());
    }

    // 댓글 수정
    @PatchMapping("/{id}")
    public CommentDto patchComment(@PathVariable("id") String commentId, @RequestParam("postId") String postId, @RequestBody UpdateCommentDto updateCommentDto) {
        return this.commentService.updateComment(commentId, postId, updateCommentDto.getContent());
    }

    // 댓글 삭제
    @DeleteMapping("/{id}")
    public CommentDto deleteComment(@PathVariable("id") String commentId, @RequestParam("postId") String postId) {
        return this.commentService.removeComment(commentId, postId);
    }

}
