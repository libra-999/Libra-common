package org.project.commons.exception.file;

import org.springframework.http.HttpStatus;

public class FileSizeLimitExceededException extends FileException {

    public FileSizeLimitExceededException(String module, HttpStatus code, String msg) {
        super(module + "upload.exceed.maxSize", code, msg);
    }
}
