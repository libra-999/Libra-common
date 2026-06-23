package com.common.commonutil.file;

import cn.hutool.core.util.StrUtil;
import com.common.commonutil.constant.MimeTypeConstant;
import com.common.commonutil.constant.PatternConstant;

import java.util.Objects;

public class File {


    public static boolean isValidFilename(String filename) {
        return filename.matches(PatternConstant.FILENAME_PATTERN);
    }

    public static boolean isAllowDownload(String resource) {
        if (StrUtil.contains(resource, "..")) {
            return false;
        }
        return MimeTypeConstant.DEFAULT_ALLOWED_EXTENSION.contains(FileType.getFileType(resource));
    }

    // ex: https://file.tititsspa.org/office-HR/2029-12-22-zkxnjnkfsa.png ->  2029-12-22-zkxnjnkfsa.png
    public static String getName(String fileName) {
        if (Objects.isNull(fileName)) {
            return null;
        }
        int index = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));
        return fileName.substring(index + 1);
    }
}
