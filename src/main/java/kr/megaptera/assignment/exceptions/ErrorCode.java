package kr.megaptera.assignment.exceptions;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    INVALID_INPUT_VALUE("올바른 입력값이 아닙니다", "COMMON-001", HttpStatus.BAD_REQUEST),

    POST_NOT_FOUND("해당 게시글은 존재하지 않습니다", "POST-001", HttpStatus.NOT_FOUND),

    DUPLICATE_COMMENT_ID("중복된 댓글이 이미 존재합니다", "COMMENT-001", HttpStatus.BAD_REQUEST),
    COMMENT_NOT_FOUND("해당 댓글은 존재하지 않습니다", "COMMENT-002", HttpStatus.NOT_FOUND);

    private final String message;
    private final String code;
    private final HttpStatus status;

    ErrorCode(String message, String code, HttpStatus status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
