package com.common.commonutil.file;

import java.io.File;

public class FileType {

    public static String getFileType(File file) {
        if (null == file) {
            return "";
        }
        return getFileType(file.getName());
    }

    public static String getFileType(String fileName) {
        int separatorIndex = fileName.lastIndexOf(".");
        if (separatorIndex < 0) {
            return "";
        }
        return fileName.substring(separatorIndex + 1).toLowerCase();
    }

}