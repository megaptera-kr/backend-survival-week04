package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.comment.*;
import kr.megaptera.assignment.model.comment.*;
import kr.megaptera.assignment.model.post.*;
import kr.megaptera.assignment.repositories.*;

import java.util.*;

public class CommentService {

    private CommentRepository commentRepository;

    public CommentService() {
        this.commentRepository = new CommentRepository();
    }

    public List<CommentDto> getCommentDtos(String postId) {
        List<Comment> comments = commentRepository.findAll(postId);

        return comments.stream().map(CommentDto::new).toList();
    }

    public CommentDto create(String postId, CommentCreateDto commentCreateDto) {
        Comment comment = new Comment(
                commentCreateDto.getAuthor(),
                commentCreateDto.getContent(),
                PostId.of(postId)
        );

        commentRepository.save(comment);

        return new CommentDto(comment);
    }

    public CommentDto update(String commentId, String postId, CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.find(CommentId.of(commentId), PostId.of(postId));
        comment.update(commentUpdateDto.getContent());
        return new CommentDto(comment);
    }

    public CommentDto delete(String commentId, String postId) {

        Comment comment = commentRepository.find(CommentId.of(commentId), PostId.of(postId));

        commentRepository.delete(comment.id());
        return new CommentDto(comment);
    }
}
