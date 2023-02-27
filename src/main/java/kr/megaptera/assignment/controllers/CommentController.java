package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public List<CommentDto> getCommentDtos(@RequestParam String postId) {
        List<CommentDto> commentDtos = commentService.getCommentDtos(postId);
        return commentDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto addCommentDto(@RequestParam String postId, @RequestBody CommentDto commentDto) {
        CommentDto createdCommentDto = commentService.addCommentDto(postId, commentDto);
        return createdCommentDto;
    }

    @PatchMapping("/{id}")
    public CommentDto updateCommentDto(@PathVariable String id, @RequestParam String postId,
                                       @RequestBody CommentDto commentDto) {
        CommentDto updatedCommentDto = commentService.updateCommentDto(id, postId, commentDto);
        return updatedCommentDto;
    }

    @DeleteMapping("/{id}")
    public CommentDto removeCommentDto(@PathVariable String id) {
        CommentDto deletedCommentDto = commentService.removeCommentDto(id);
        return deletedCommentDto;
    }

}
