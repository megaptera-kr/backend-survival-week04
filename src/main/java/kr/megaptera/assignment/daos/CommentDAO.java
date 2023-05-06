package kr.megaptera.assignment.daos;

import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.request.RqCreateCommentDto;
import kr.megaptera.assignment.dtos.request.RqUpdateCommentDto;

import java.util.List;

public interface CommentDAO {
    List<CommentDto> getCommentListByPostId(int postId);

    CommentDto createComment(RqCreateCommentDto dto, int postId);

    CommentDto updateComment(RqUpdateCommentDto dto, int postId, int commentId);

    CommentDto deleteComment(int postId, int commentId);
}
