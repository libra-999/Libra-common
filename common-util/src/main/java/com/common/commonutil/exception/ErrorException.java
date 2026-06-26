package com.common.commonutil.exception;


import com.common.commonutil.constant.ErrorConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = false)
public class ErrorException extends RuntimeException {

    private HttpStatus status;
    public String errorConstant;
    public String msg;

    public ErrorException(HttpStatus status, String msg) {
        super(msg);
        this.status = status;
        this.errorConstant = ErrorConstant.UNKNOWN;

    }
}
