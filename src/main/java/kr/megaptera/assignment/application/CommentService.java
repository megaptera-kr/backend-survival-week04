package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentCreateDTO;
import kr.megaptera.assignment.dtos.CommentDTO;
import kr.megaptera.assignment.dtos.CommentUpdatedDTO;
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

    public List<CommentDTO> getCommentDots(String postId) {
        List<Comment> comments = commentRepository.findAll(PostId.of(postId));

        return comments.stream().map(CommentDTO::new).toList();
    }

    public CommentDTO createComment(String postId, CommentCreateDTO commentCreateDto) {
        Comment comment = new Comment(
                PostId.of(postId),
                commentCreateDto.getAuthor(),
                commentCreateDto.getContent()
        );

        commentRepository.save(comment);

        return new CommentDTO(comment);
    }

    public CommentDTO updateComment(String id, String postId,
                                    CommentUpdatedDTO commentUpdatedDto) {
        Comment comment = commentRepository.find(CommentId.of(id), PostId.of(postId));

        comment.update(commentUpdatedDto.getContent());

        return new CommentDTO(comment);
    }

    public CommentDTO deleteComment(String id, String postId) {
        Comment comment = commentRepository.find(CommentId.of(id), PostId.of(postId));

        commentRepository.delete(comment.id());

        return new CommentDTO(comment);
    }
}
