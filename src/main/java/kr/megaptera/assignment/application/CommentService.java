package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentCreateRequestDto;
import kr.megaptera.assignment.dtos.CommentEditRequestDto;
import kr.megaptera.assignment.dtos.CommentResponseDto;
import kr.megaptera.assignment.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
  private final CommentRepository commentRepository;

  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public List<CommentResponseDto> getComments(String postId) {
    return commentRepository.getComments(postId);
  }

  public CommentResponseDto addComment(String postId,
                                       CommentCreateRequestDto commentCreateRequestDto) {
    return commentRepository.addComment(postId, commentCreateRequestDto);
  }

  public CommentResponseDto editComment(String id, String postId,
                                        CommentEditRequestDto commentEditRequestDto) {
    if (!commentRepository.checkExists(id)) {
      return null;
    }
    return commentRepository.editComment(id, postId, commentEditRequestDto);
  }

  public CommentResponseDto deleteComment(String id) {
    if (!commentRepository.checkExists(id)) {
      return null;
    }
    return commentRepository.deleteComment(id);
  }
}
