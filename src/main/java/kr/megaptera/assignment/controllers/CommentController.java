package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(){ this.commentService = new CommentService();}

    @GetMapping
    public List<CommentDto> list(@RequestParam String postId){
        List<CommentDto> commentDtos = commentService.getCommentDtos(postId);

        return commentDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  //HttpStatus : 201
    public CommentDto create(@RequestParam String postId,
                          @RequestBody CommentCreateDto commentCreateDto){
        CommentDto created = commentService.createComment(postId, commentCreateDto);

        return created;
    }

    @PatchMapping("{id}")
    public CommentDto update(@PathVariable String id,
                             @RequestParam String postId,
                             @RequestBody CommentUpdateDto commentUpdateDto){
        CommentDto updated = commentService.updateComment(id, postId, commentUpdateDto);

        return updated;
    }

    @DeleteMapping("{id}")
    public CommentDto delete(@PathVariable String id,
                          @RequestParam String postId){
        CommentDto deleted = commentService.deleteComment(id, postId);

        return deleted;
    }
}
