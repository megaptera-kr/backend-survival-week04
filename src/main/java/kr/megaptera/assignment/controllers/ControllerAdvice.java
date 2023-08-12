package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.exceptions.ErrorResponse;
import kr.megaptera.assignment.exceptions.ParsingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static kr.megaptera.assignment.exceptions.ErrorCode.INVALID_INPUT_VALUE;

@RestControllerAdvice
public class ControllerAdvice {
    //    INVALID_INPUT_VALUE("올바른 입력값이 아닙니다", "COMMON-001",HttpStatus.BAD_REQUEST);
    @ExceptionHandler(ParsingException.class)
    public ResponseEntity<ErrorResponse> postIdParsingException(ParsingException e) {
        return new ResponseEntity<>(ErrorResponse.of(INVALID_INPUT_VALUE),
                                    INVALID_INPUT_VALUE.getStatus());
    }
}
