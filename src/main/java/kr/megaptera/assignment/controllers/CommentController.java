package kr.megaptera.assignment.controllers;

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

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController() {
        commentService = new CommentService();
    }

    /*
        댓글 조회
    */
    @GetMapping("")
    public List<CommentDto> list(@RequestParam String postId) {
        List<CommentDto> commentDtos = commentService.getCommentDtos(postId);
        return commentDtos;
    }

    /*
        댓글 작성
    */
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(@RequestParam String postId,
                             @RequestBody CommentCreateDto commentCreateDto) {
        CommentDto comment = commentService.createDto(postId, commentCreateDto);
        return comment;
    }

    /*
        댓글 수정
    */
    @PatchMapping("/{id}")
    public CommentDto update(
            @RequestParam String postId,
            @PathVariable String id,
            @RequestBody CommentUpdateDto commentUpdateDto) {
        CommentDto comment = commentService.updateDto(postId, id, commentUpdateDto);
        return comment;
    }

    /*
        댓글 삭제
    */
    @DeleteMapping("/{id}")
    public CommentDto delete(@RequestParam String postId,
                          @PathVariable String id) {
        CommentDto commentDto = commentService.deleteDto(postId, id);
        return commentDto;
    }
}
