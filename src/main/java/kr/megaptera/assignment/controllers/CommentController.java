package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CommentService;
import kr.megaptera.assignment.dtos.comments.CommentCreateDTO;
import kr.megaptera.assignment.dtos.comments.CommentDetailDTO;
import kr.megaptera.assignment.dtos.comments.CommentUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController() {
        this.commentService = new CommentService();
    }

    @GetMapping
    public List<CommentDetailDTO> list(@RequestParam String postId) {
        return commentService.getCommentDTOs(postId);
    }

    @GetMapping("/{id}")
    public CommentDetailDTO detail(@PathVariable String id, @RequestParam String postId) {
        return commentService.getCommentDTO(id, postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDetailDTO create(@RequestParam String postId, @RequestBody CommentCreateDTO dto) {
        return commentService.createDTO(postId, dto);
    }

    @PatchMapping("/{id}")
    public CommentDetailDTO update(@PathVariable String id, @RequestParam String postId, @RequestBody CommentUpdateDTO dto) {
        return commentService.updateDTO(id, postId, dto);
    }

    @DeleteMapping("/{id}")
    public CommentDetailDTO delete(@PathVariable String id, @RequestParam String postId) {
        return commentService.deleteDTO(id, postId);
    }
}
