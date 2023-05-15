package kr.megaptera.assignment.application;

import kr.megaptera.assignment.controllerDtos.CommentDto;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.MultilineText;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;

public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService() {
        this.commentRepository = new CommentRepository();
    }

    public List<CommentDto> getCommentDtos(String postId) {
        List<Comment> comments = commentRepository.findAll(PostId.of(postId));
        return comments.stream().map(comment -> new CommentDto(comment)).toList();
    }

    public CommentDto createComment(String postId, CommentDto commentDto) {
        Comment comment = new Comment(
                PostId.of(postId),
                commentDto.getAuthor(),
                MultilineText.of(commentDto.getContent())
        );
        commentRepository.save(PostId.of(postId), comment);
        return new CommentDto(comment);
    }

    public CommentDto updateComment(String postId, CommentDto commentDto) {
        Comment comment = new Comment(
                CommentId.of(commentDto.getId()),
                PostId.of(postId),
                commentDto.getAuthor(),
                MultilineText.of(commentDto.getContent())
        );
        commentRepository.update(PostId.of(postId), comment);
        return new CommentDto(comment);
    }

    public CommentDto deleteComment(String id, String postId) {
        Comment comment = commentRepository.delete(CommentId.of(id), PostId.of(postId));
        return new CommentDto(comment);
    }
}
