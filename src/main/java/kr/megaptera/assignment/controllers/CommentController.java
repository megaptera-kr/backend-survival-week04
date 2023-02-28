package kr.megaptera.assignment.controllers;

import java.util.List;
import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
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

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 조회
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> list(@RequestParam String postId) {
        List<CommentDto> comments = commentService.findAll(postId);
        return comments;
    }

    // 댓글 작성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(@RequestParam String postId,
                                @RequestBody CommentCreateDto commentCreateDto) {
        CommentDto createdComment = commentService.create(postId, commentCreateDto);
        return createdComment;
    }

    // 댓글 수정
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto update(@RequestParam String postId,
                                @PathVariable String id,
                                @RequestBody CommentUpdateDto commentUpdateDto) {
        CommentDto updatedComment = commentService.update(postId, id, commentUpdateDto);
        return updatedComment;
    }

    // 댓글 삭제
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto delete(@RequestParam String postId,
                                @PathVariable String id) {
        CommentDto deletedComment = commentService.delete(postId, id);
        return deletedComment;
    }
}
