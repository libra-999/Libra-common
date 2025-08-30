package org.project.commons.exception.base;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.project.commons.enums.ErrorType;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {

    private ErrorType errorType;
    private HttpStatus httpStatus;
    private String module;
    private Object[] args;

    public BaseException(String module, HttpStatus status, String message, Object[] args) {
        super(message);
        this.module = module;
        this.httpStatus = status;
        this.errorType = ErrorType.UNKNOWN_ERROR;
        this.args = args;
    }

    public BaseException(String module, HttpStatus status, String message) {
        this(module, status, message, null);
    }

    public BaseException(HttpStatus status, String message) {
        this(null, status, message, null);
    }

    public BaseException(HttpStatus status) {
        this(null, status, null, null);
    }
}
