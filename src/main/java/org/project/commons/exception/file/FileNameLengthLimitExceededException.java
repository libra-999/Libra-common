package org.project.commons.exception.file;

import org.springframework.http.HttpStatus;

public class FileNameLengthLimitExceededException extends FileException {

    public FileNameLengthLimitExceededException(String module, HttpStatus code, String msg) {
        super(module + "upload.filename.exceed.length", code, msg);
    }
}
