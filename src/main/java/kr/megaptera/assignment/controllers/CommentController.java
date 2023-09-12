package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dto.CommentDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RequestMapping("/comments")
@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();

    }

    @GetMapping
    public List<CommentDto> getList(@RequestParam String postId) {
        List<CommentDto> commentDtos = commentService.getCommentDto(postId);
        return commentDtos;
    }

    @PostMapping
    public CommentDto create(@RequestBody CommentDto commentDto,
                       @RequestParam String postId) {
        CommentDto created = commentService.createComment(commentDto, postId);

        return created;
    }

    @PatchMapping("/{id}")
    public CommentDto update(@RequestBody CommentDto commentDto,
                       @PathVariable String id) {
        CommentDto updated = commentService.updateComment(commentDto, id);
        return updated;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        commentService.deleteComment(id);
    }
}
