package kr.megaptera.assignment.application;

import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.models.dtos.CommentCreateDto;
import kr.megaptera.assignment.models.dtos.CommentDto;
import kr.megaptera.assignment.models.dtos.CommentUpdateDto;
import kr.megaptera.assignment.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    // 생성자
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // 해당 게시물의 전체 댓글 리스트 가져오기
    public List<CommentDto> getComments(String postId) {
        return commentRepository.findAllByPost(postId)
                .stream().map(CommentDto::new).toList();
    }

    // 댓글 새로 작성하기
    public CommentDto createComment(String postId, CommentCreateDto commentCreateDto) {
        Comment comment = new Comment(PostId.of(postId), commentCreateDto);
        return new CommentDto(commentRepository.save(postId, comment));
    }

    // 댓글 수정하기
    public CommentDto updateComment(String id, String postId, CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.find(id, postId);
        comment.updateComment(commentUpdateDto);
        return new CommentDto(commentRepository.save(postId, comment));
    }

    // 댓글 삭제하기
    public CommentDto deleteComment(String id, String postId) {
        return new CommentDto(commentRepository.delete(id, postId));
    }
}
