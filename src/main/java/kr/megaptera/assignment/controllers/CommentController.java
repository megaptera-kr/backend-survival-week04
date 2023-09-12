package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.dto.CommentDto;
import kr.megaptera.assignment.model.PostId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        List<CommentDto> commentDto = commentService.getCommentDto(postId);
        return commentDto;
    }

    @PostMapping
    public CommentDto create(@RequestBody CommentDto commentDto,
                       @RequestParam PostId postId) {
        CommentDto created = commentService.createComment(commentDto, postId);

        return created;
    }

    @PutMapping("/{id}")
    public void update() {

    }

    @DeleteMapping("/{id}")
    public void delete() {

    }
}
