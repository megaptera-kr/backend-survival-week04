package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService() {
        commentRepository = new CommentRepository();
    }

    public List<CommentDto> findAll(String postId) {
        List<Comment> comments = commentRepository.findAll(postId);
        return comments.stream().map(comment -> new CommentDto(comment)).toList();
    }
}
