package kr.megaptera.assignment.application;

import kr.megaptera.assignment.daos.CommentDAO;
import kr.megaptera.assignment.daos.CommentListDAO;
import kr.megaptera.assignment.dtos.CommentDto;
import kr.megaptera.assignment.dtos.request.RqCreateCommentDto;
import kr.megaptera.assignment.dtos.request.RqUpdateCommentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentDAO commentDAO;

    public CommentService() {
        this.commentDAO = new CommentListDAO();
    }

    public ResponseEntity<List<CommentDto>> getCommentByPostId(int postId) {
        List<CommentDto> commentDtoList = commentDAO.getCommentListByPostId(postId);
        return new ResponseEntity<>(commentDtoList, HttpStatus.OK);
    }

    public ResponseEntity<CommentDto> createComment(RqCreateCommentDto dto, int postId) {
        CommentDto commentDto = commentDAO.createComment(dto, postId);
        return new ResponseEntity<>(commentDto, HttpStatus.CREATED);
    }

    public ResponseEntity<CommentDto> updateComment(RqUpdateCommentDto dto, int postId, int commentId) {
        CommentDto commentDto = commentDAO.updateComment(dto, postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    public ResponseEntity<CommentDto> deleteComment(int postId, int commentId) {
        CommentDto commentDto = commentDAO.deleteComment(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }
}
