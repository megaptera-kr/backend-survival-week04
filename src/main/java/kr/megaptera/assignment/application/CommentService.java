package kr.megaptera.assignment.application;

import kr.megaptera.assignment.daos.comment.CommentDAO;
import kr.megaptera.assignment.daos.comment.CommentMapDAO;
import kr.megaptera.assignment.dtos.comment.CommentCreateDto;
import kr.megaptera.assignment.dtos.comment.CommentDto;
import kr.megaptera.assignment.dtos.comment.CommentUpdateDto;

import java.util.List;
import java.util.UUID;

public class CommentService {

    private final CommentDAO commentDAO;

    public CommentService() {
        commentDAO = new CommentMapDAO();
    }

    public List<CommentDto> getCommentDtos(String postId) {
        return commentDAO.findAll(postId);
    }

    public CommentDto createCommentDto(String postId, CommentCreateDto commentCreateDto) {
        CommentDto commentDto = new CommentDto(
                generateId(),
                commentCreateDto.getAuthor(),
                commentCreateDto.getContent()
        );

        commentDAO.save(postId, commentDto);

        return commentDto;
    }

    public CommentDto updateCommentDto(String id, String postId, CommentUpdateDto commentUpdateDto) {
        CommentDto commentDto = commentDAO.find(id, postId);

        commentDto.setContent(commentUpdateDto.getContent());

        return commentDto;
    }

    public CommentDto deleteCommentDto(String id, String postId) {
        CommentDto commentDto = commentDAO.find(id, postId);

        commentDAO.delete(postId, commentDto);

        return commentDto;
    }

    private String generateId() {
        // TODO: TSID 도입
        return UUID.randomUUID().toString();
    }
}
