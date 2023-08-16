package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
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

    public CommentController(){
        commentService = new CommentService();
    }


    @GetMapping
    public List<CommentDto> detail(@RequestParam String postId) {
        List<CommentDto> commentDtos = commentService.getCommentDtos(postId);
        return commentDtos;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(@RequestParam String postId, @RequestBody CommentCreateDto commentCreateDto) {
        CommentDto created = commentService.createComment(postId, commentCreateDto);

        return created;

    }

    @PatchMapping("/{id}")
    public CommentDto update(@PathVariable String id, @RequestParam String postId, @RequestBody CommentUpdateDto commentUpdateDto){
        CommentDto update = commentService.updateComment(id, postId, commentUpdateDto);

        return update;
    }

    @DeleteMapping("/{id}")
    public CommentDto delete(@PathVariable String id, @RequestParam String postId){
        CommentDto commentDto = commentService.deleteComment(id, postId);

        return commentDto;
    }


    @ExceptionHandler(PostNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String CommentNotFound() {
        return "댓글을 찾을 수 없습니다";
    }

}
