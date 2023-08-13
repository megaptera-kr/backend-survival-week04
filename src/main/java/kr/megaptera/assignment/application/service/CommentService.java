package kr.megaptera.assignment.application.service;

import kr.megaptera.assignment.application.domain.Comment;
import kr.megaptera.assignment.application.domain.CommentId;
import kr.megaptera.assignment.application.domain.PostId;
import kr.megaptera.assignment.dtos.CommentCreateRequestDTO;
import kr.megaptera.assignment.dtos.CommentCreateResponseDTO;
import kr.megaptera.assignment.dtos.CommentDeleteResponseDTO;
import kr.megaptera.assignment.dtos.CommentGetResponseDTO;
import kr.megaptera.assignment.dtos.CommentUpdateRequestDTO;
import kr.megaptera.assignment.dtos.CommentUpdateResponseDTO;
import kr.megaptera.assignment.exceptions.CommentNotFoundException;
import kr.megaptera.assignment.repositories.CommentRepository;
import kr.megaptera.assignment.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public List<CommentGetResponseDTO> list(String postId) {
        List<Comment> comments =
                commentRepository.findAll().stream()
                        .filter(comment -> comment.getPostId().equals(PostId.of(postId))).toList();
        return comments.stream().map(CommentGetResponseDTO::from).toList();
    }

    public CommentCreateResponseDTO create(String id,
                                           CommentCreateRequestDTO requestDTO) {
        PostId postId = PostId.of(id);
        postRepository.exists(postId);
        Comment comment = commentRepository.save(requestDTO.toEntity());
        comment.setPostId(PostId.copy(postId));

        return CommentCreateResponseDTO.from(comment);
    }

    public CommentUpdateResponseDTO update(String commentIdStr,
                                           String postIdStr,
                                           CommentUpdateRequestDTO requestDTO) {
        CommentId commentId = CommentId.of(commentIdStr);
        PostId postId = PostId.of(postIdStr);
        postRepository.exists(postId);
        Comment comment = commentRepository.findById(commentId);

        if (!comment.getPostId().equals(postId)) {
            throw new CommentNotFoundException();
        }

        comment.update(requestDTO);
        return CommentUpdateResponseDTO.from(comment);
    }

    public CommentDeleteResponseDTO delete(String commentIdStr,
                                           String postIdStr) {
        CommentId commentId = CommentId.of(commentIdStr);
        PostId postId = PostId.of(postIdStr);
        postRepository.findById(postId);
        Comment comment = commentRepository.findById(commentId);

        if (!comment.getPostId().equals(postId)) {
            throw new CommentNotFoundException();
        }

        Comment deletedComment = commentRepository.delete(commentId);
        return CommentDeleteResponseDTO.from(deletedComment);
    }

}
