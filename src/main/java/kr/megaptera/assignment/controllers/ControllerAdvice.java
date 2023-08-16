package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.exceptions.CommentDuplicateException;
import kr.megaptera.assignment.exceptions.CommentNotFoundException;
import kr.megaptera.assignment.exceptions.ErrorResponse;
import kr.megaptera.assignment.exceptions.ParsingException;
import kr.megaptera.assignment.exceptions.PostNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static kr.megaptera.assignment.exceptions.ErrorCode.COMMENT_NOT_FOUND;
import static kr.megaptera.assignment.exceptions.ErrorCode.DUPLICATE_COMMENT_ID;
import static kr.megaptera.assignment.exceptions.ErrorCode.INVALID_INPUT_VALUE;
import static kr.megaptera.assignment.exceptions.ErrorCode.POST_NOT_FOUND;

@RestControllerAdvice
public class ControllerAdvice {
    //    INVALID_INPUT_VALUE("올바른 입력값이 아닙니다", "COMMON-001",HttpStatus.BAD_REQUEST);
    @ExceptionHandler(ParsingException.class)
    public ResponseEntity<ErrorResponse> postIdParsingException() {
        return new ResponseEntity<>(ErrorResponse.of(INVALID_INPUT_VALUE),
                                    INVALID_INPUT_VALUE.getStatus());
    }

//    POST_NOT_FOUND_BY_POST_ID("해당 게시글은 존재하지 않습니다", "POST-001",HttpStatus.BAD_REQUEST);
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorResponse> postIdNotFoundException() {
        return new ResponseEntity<>(ErrorResponse.of(POST_NOT_FOUND),
                POST_NOT_FOUND.getStatus());
    }

//    DUPLICATE_COMMENT_ID("중복된 댓글이 이미 존재합니다", "COMMENT-001",HttpStatus.BAD_REQUEST);
    @ExceptionHandler(CommentDuplicateException.class)
    public ResponseEntity<ErrorResponse> commentIdDuplicateException() {
        return new ResponseEntity<>(ErrorResponse.of(DUPLICATE_COMMENT_ID),
                DUPLICATE_COMMENT_ID.getStatus());
    }

    //    COMMENT_NOT_FOUND("중복된 댓글이 이미 존재합니다", "COMMENT-002",HttpStatus.NOT_FOUND);
    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<ErrorResponse> commentNotFoundException() {
        return new ResponseEntity<>(ErrorResponse.of(COMMENT_NOT_FOUND),
                COMMENT_NOT_FOUND.getStatus());
    }

}
