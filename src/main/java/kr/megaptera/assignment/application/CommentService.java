package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.comments.CommentCreateDTO;
import kr.megaptera.assignment.dtos.comments.CommentDetailDTO;
import kr.megaptera.assignment.dtos.comments.CommentUpdateDTO;
import kr.megaptera.assignment.exceptions.CommentNotFoundException;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.CommentId;
import kr.megaptera.assignment.models.MultiLineText;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService() {
        this.commentRepository = new CommentRepository();
    }

    public List<CommentDetailDTO> getCommentDTOs(String postId) {
        return commentRepository.findAll(PostId.of(postId)).stream().map(Comment::toCommentDetailDTO).toList();
    }

    public CommentDetailDTO getCommentDTO(String id, String postIdString) {
        PostId postId = PostId.of(postIdString);
        CommentId commentId = CommentId.of(id);
        Comment comment = commentRepository.find(postId, commentId);
        if (comment == null) {
            throw new CommentNotFoundException(postId, commentId);
        }
        return comment.toCommentDetailDTO();
    }

    public CommentDetailDTO updateDTO(String id, String postIdString, CommentUpdateDTO dto) {
        PostId postId = PostId.of(postIdString);
        CommentId commentId = CommentId.of(id);
        Comment comment = commentRepository.find(postId, commentId);
        comment.update(MultiLineText.of(dto.content()));
        commentRepository.save(comment);
        return comment.toCommentDetailDTO();
    }

    public CommentDetailDTO createDTO(String postIdString, CommentCreateDTO dto) {
        PostId postId = PostId.of(postIdString);
        Comment comment = Comment.create(postId, dto);
        commentRepository.save(comment);
        return comment.toCommentDetailDTO();
    }

    public CommentDetailDTO deleteDTO(String id, String postIdString) {
        PostId postId = PostId.of(postIdString);
        CommentId commentId = CommentId.of(id);
        Comment comment = commentRepository.find(postId, CommentId.of(id));
        commentRepository.delete(postId, commentId);
        return comment.toCommentDetailDTO();
    }
}
