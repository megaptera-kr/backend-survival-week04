package kr.megaptera.assignment.exceptions;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    INVALID_INPUT_VALUE("올바른 입력값이 아닙니다", "COMMON-001", HttpStatus.BAD_REQUEST);

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
