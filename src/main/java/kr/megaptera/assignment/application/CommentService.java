package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.comment.CommentCreateDto;
import kr.megaptera.assignment.dtos.comment.CommentDto;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;

public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService() {
        commentRepository = new CommentRepository();
    }

    public List<CommentDto> getCommentList(String postId) {
        return commentRepository.getCommentList(postId);
    }

    public CommentDto createComment(String postId, CommentCreateDto commentCreateDto) {
        return commentRepository.createComment(postId, commentCreateDto);
    }

    public CommentDto updateComment(String postId, String commentId, String content) {
        return commentRepository.updateComment(postId, commentId, content);
    }

    public CommentDto deleteComment(String postId, String commentId) {
        return commentRepository.deleteComment(postId, commentId);
    }
}
