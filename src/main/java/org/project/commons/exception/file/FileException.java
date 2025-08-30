package org.project.commons.exception.file;

import org.project.commons.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class FileException extends BaseException {

    public FileException(String module, HttpStatus code, String msg) {
        super("file", code, msg);
    }
}
