package kr.megaptera.assignment.application;

import java.util.List;
import kr.megaptera.assignment.domains.Comment;
import kr.megaptera.assignment.domains.CommentId;
import kr.megaptera.assignment.domains.PostId;
import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
import kr.megaptera.assignment.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentDto> findAll(String postId) {
        List<Comment> comments = commentRepository.findAll(PostId.of(postId));
        return comments.stream()
                .map(comment -> new CommentDto(comment))
                .toList();
    }

    public CommentDto create(String postId, CommentCreateDto commentCreateDto) {
        Comment newComment = new Comment(postId, commentCreateDto);
        commentRepository.save(newComment);
        return new CommentDto(newComment);
    }

    public CommentDto update(String postId, String id, CommentUpdateDto commentUpdateDto) {
        Comment comment = findCommentById(postId, id);
        comment.update(commentUpdateDto);
        return new CommentDto(comment);
    }

    public CommentDto delete(String postId, String id) {
        Comment comment = findCommentById(postId, id);
        commentRepository.delete(comment);
        return new CommentDto(comment);
    }

    public Comment findCommentById(String postId, String id) {
        return commentRepository.findById(PostId.of(postId), CommentId.of(id));
    }
}
