package kr.megaptera.assignment.application;

import kr.megaptera.assignment.domain.comment.Comment;
import kr.megaptera.assignment.domain.comment.CommentId;
import kr.megaptera.assignment.domain.post.MultilineText;
import kr.megaptera.assignment.domain.post.PostId;
import kr.megaptera.assignment.dtos.comment.CommentCreateDto;
import kr.megaptera.assignment.dtos.comment.CommentDto;
import kr.megaptera.assignment.dtos.comment.CommentUpdateDto;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;

public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService() {
        commentRepository = new CommentRepository();
    }

    public List<CommentDto> getCommentDtos(String postId) {
        List<Comment> comments = commentRepository.findAll(PostId.of(postId));

        return comments.stream().map(comment -> new CommentDto(comment)).toList();
    }

    public CommentDto createCommentDto(String postId, CommentCreateDto commentCreateDto) {
        Comment comment = new Comment(
                commentCreateDto.getAuthor(),
                MultilineText.of(commentCreateDto.getContent())
        );

        commentRepository.save(PostId.of(postId), comment);

        return new CommentDto(comment);
    }

    public CommentDto updateCommentDto(String id, String postId, CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.find(CommentId.of(id), PostId.of(postId));

        comment.update(MultilineText.of(commentUpdateDto.getContent()));

        return new CommentDto(comment);
    }

    public CommentDto deleteCommentDto(String id, String postId) {
        Comment comment = commentRepository.find(CommentId.of(id), PostId.of(postId));

        commentRepository.delete(PostId.of(postId), comment);

        return new CommentDto(comment);
    }
}
