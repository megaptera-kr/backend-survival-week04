package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.exceptions.CommentNotFound;
import kr.megaptera.assignment.models.dtos.CommentCreateDto;
import kr.megaptera.assignment.models.dtos.CommentDto;
import kr.megaptera.assignment.models.dtos.CommentUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

@RequestMapping("/comments")
@RestController
public class CommentController {

    private final CommentService commentService;

    // 생성자
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 해당 게시물의 전체 댓글 리스트 가져오기
    @GetMapping
    public List<CommentDto> listOfPost(
            @RequestParam("postId") String postId
    ) {
        return commentService.getComments(postId);
    }

    // 댓글 새로 작성하기
    @PostMapping
    public CommentDto create(
            @RequestParam("postId") String postId,
            @RequestBody CommentCreateDto commentCreateDto
    ) {
        return commentService.createComment(postId, commentCreateDto);
    }

    // 댓글 수정하기
    @PatchMapping("/{id}")
    public CommentDto update(
            @PathVariable String id,
            @RequestParam("postId") String postId,
            @RequestBody CommentUpdateDto commentUpdateDto
    ) {
        return commentService.updateComment(id, postId, commentUpdateDto);
    }

    // 댓글 삭제하기
    @DeleteMapping("/{id}")
    public CommentDto delete(
            @PathVariable String id,
            @RequestParam("postId") String postId
    ) {
        return commentService.deleteComment(id, postId);
    }

    // 원하는 댓글이 없는 경우 404 (빈 리스트 또는 404로 return 되도록)
    @ExceptionHandler(CommentNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String commentNotFound() {
        return "There's no comment you want to see.\n";
    }
}
