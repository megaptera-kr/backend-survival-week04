package kr.megaptera.assignment.exceptions;

public class ErrorResponse {
    private final String message;
    private final String code;

    private ErrorResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }

    private ErrorResponse(ErrorCode code) {
        this.message = code.getMessage();
        this.code = code.getCode();
    }

    public static ErrorResponse of(ErrorCode code) {
        return new ErrorResponse(code);
    }
}
