package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
import kr.megaptera.assignment.models.Author;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.MultilineText;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService() {
        this.commentRepository = new CommentRepository();
    }

    public List<CommentDto> comments(String postId) {
        List<Comment> comments = commentRepository.findAll(postId);
        return comments.stream().map(CommentDto::new).toList();
    }

    public CommentDto create(String postId, CommentCreateDto commentCreateDto) {
        Comment comment = new Comment(
            PostId.of(postId),
            Author.of(commentCreateDto.getAuthor()),
            MultilineText.of(commentCreateDto.getContent())
        );

        commentRepository.save(comment);
        return new CommentDto(comment);
    }

    public CommentDto update(String commentId, CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.findComment(commentId);
        comment.update(commentUpdateDto.getContent());
        commentRepository.update(comment);
        return new CommentDto(comment);
    }

    public CommentDto delete(String commentId, String postId) {
        Comment comment = commentRepository.findComment(commentId);
        commentRepository.delete(comment);
        return new CommentDto(comment);
    }
}
