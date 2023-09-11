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
        List<Comment> comments = commentRepository.findAll(new PostId(postId));

        return comments.stream().map(comment -> new CommentDto(comment)).toList();
    }

    public CommentDto createComment(String postId, CommentCreateDto commentCreateDto) {
        Comment comment = new Comment(new PostId(postId), CommentId.generate(), commentCreateDto.getAuthor(), commentCreateDto.getContent());

        commentRepository.save(comment);

        return new CommentDto(comment);
    }

    public CommentDto updateComment(String id, CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.find(new CommentId(id));

        comment.update(commentUpdateDto.getContent());

        return new CommentDto(comment);
    }

    public CommentDto deleteComment(String id) {
        Comment comment = commentRepository.find(new CommentId(id));

        commentRepository.delete(new CommentId(id));

        return new CommentDto(comment);
    }
}
