package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;

public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService() {
        commentRepository = new CommentRepository();
    }
    public List<CommentDto> getCommentDtos(String postId) {

        List<Comment> comments = commentRepository.findAll(PostId.of(postId));

        List<CommentDto> commentDtos = comments.stream()
                .map(comment -> new CommentDto(comment))
                .toList();

        return commentDtos;
    }

    public CommentDto createDto(String postId, CommentCreateDto commentCreateDto) {

        Comment comment = new Comment(
                PostId.of(postId),
                commentCreateDto.getAuthor(),
                commentCreateDto.getContent()
        );

        commentRepository.save(comment);

        return new CommentDto(comment);
    }

    public CommentDto updateDto(String postId, String id, CommentUpdateDto commentUpdateDto) {

        Comment comment = commentRepository.find(PostId.of(postId), CommentId.of(id));

        comment.update(commentUpdateDto.getContent());

        return new CommentDto(comment);
    }

    public CommentDto deleteDto(String postId, String id) {
        Comment comment = commentRepository.find(PostId.of(postId), CommentId.of(id));

        commentRepository.delete(comment.commentId());

        return new CommentDto(comment);
    }
}
