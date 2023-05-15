package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.MultiLineText;
import kr.megaptera.assignment.models.PostId;
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

    public CommentDto create(String postId, CommentCreateDto commentCreateDto) {
        Comment comment = new Comment(
                PostId.of(postId),
                commentCreateDto.getAuthor(),
                MultiLineText.of(commentCreateDto.getContent())
        );
        commentRepository.create(comment);
        return new CommentDto(comment);
    }

    public CommentDto update(String commentId, String postId, CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.find(commentId);
        comment.update(
                MultiLineText.of(commentUpdateDto.getContent())
        );

        return new CommentDto(comment);
    }

    public CommentDto delete(String commentId, String postId) {
        Comment comment = commentRepository.find(commentId);
        commentRepository.delete(commentId);
        return new CommentDto(comment);
    }
}
