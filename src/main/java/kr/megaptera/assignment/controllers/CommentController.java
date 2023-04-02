package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.CommentCreateDTO;
import kr.megaptera.assignment.dtos.CommentDTO;
import kr.megaptera.assignment.exceptions.CommentNotFound;
import kr.megaptera.assignment.dtos.CommentUpdatedDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentController {
    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    @GetMapping
    public List<CommentDTO> list(@RequestParam String postId) {
        return commentService.getCommentDots(postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDTO create(@RequestParam String postId, @RequestBody CommentCreateDTO commentCreateDto) {
        return commentService.createComment(postId, commentCreateDto);
    }

    @PatchMapping("/{id}")
    public CommentDTO update(@PathVariable String id, @RequestParam String postId, @RequestBody CommentUpdatedDTO commentUpdatedDto) {
        return commentService.updateComment(id, postId, commentUpdatedDto);
    }

    @DeleteMapping("/{id}")
    public CommentDTO delete(@PathVariable String id, @RequestParam String postId) {
        return commentService.deleteComment(id, postId);
    }

    @ExceptionHandler(CommentNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFound() {
        return "댓글을 찾을 수 없습니다.";
    }
}
