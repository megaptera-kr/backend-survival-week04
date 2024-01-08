package kr.megaptera.assignment.daos.comment;

import kr.megaptera.assignment.dtos.comment.CommentDto;

import java.util.List;

public interface CommentDAO {
    List<CommentDto> findAll(String postId);

    CommentDto find(String id, String postId);

    void save(String postId, CommentDto commentDto);

    void delete(String postId, CommentDto commentDto);
}
