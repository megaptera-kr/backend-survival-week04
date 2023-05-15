package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CommentCreateDto;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.CommentUpdateDto;
import kr.megaptera.assignment.models.Comment;
import kr.megaptera.assignment.repositories.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService() {
        this.commentRepository = new CommentRepository();
    }

    public List<CommentDto> findCommentList(String postId) {
        //postId 가 같은 리스트 출력
        return commentRepository.findByPostId(postId).stream().map(comment -> new CommentDto(comment)).collect(Collectors.toList());
    }

    public CommentDto createComment(String postId, CommentCreateDto commentCreateDto) {
        Comment comment = commentCreateDto.toCommentModel(commentCreateDto);
        commentRepository.save(postId,comment);
        return new CommentDto(comment);
    }

    public void updateComment(String postId, String commentId,CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.findComment(postId, commentId);
        comment.update(commentUpdateDto);
    }

    public void deleteComment(String commentId, String postId) {
        commentRepository.delete(postId,commentId);
    }

}
