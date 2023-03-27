package kr.megaptera.assignment.controllers;


import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.exceptions.PostNotPound;
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

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController() {
        commentService = new CommentService();
    }

    @GetMapping
    public List<CommentDto> list(@RequestParam("postId") String postId) {

        List<CommentDto> commentDtos = commentService.getCommentDto(postId);

        return commentDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(@RequestBody CommentDto reqCommentDto, @RequestParam("postId") String postId) {

        CommentDto commentDto = commentService.createComment(reqCommentDto, postId);

        return commentDto;
    }


    @PatchMapping("/{id}")
    public CommentDto update(
            @PathVariable("id") String id,
            @RequestParam("postId") String postId,
            @RequestBody CommentDto reqCommentDto
    ) {

        CommentDto commentDto = commentService.updateComment(id, reqCommentDto);

        return commentDto;

    }


    @DeleteMapping("/{id}")
    public CommentDto delete(@PathVariable("id") String id, @RequestParam("postId") String postId) {

        CommentDto commentDto = commentService.deleteComment(id);

        return commentDto;

    }

    @ExceptionHandler(PostNotPound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFound() {
        return "게시물을 찾을 수 없습니다.\n";
    }

}
