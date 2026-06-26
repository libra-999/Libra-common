package com.common.commonutil.constant;

import java.util.List;

public class MimeTypeConstant {

    public static final String IMAGE_PNG = "image/png";
    public static final String IMAGE_JPG = "image/jpg";
    public static final String IMAGE_JPEG = "image/jpeg";
    public static final String IMAGE_BMP = "image/bmp";
    public static final String IMAGE_GIF = "image/gif";
    public static final List<String> IMAGE_EXTENSION = List.of("gif", "jpg", "jpeg", "png", "webp", "avif");
    public static final List<String> MEDIA_EXTENSION = List.of("swf", "flv", "mp3", "wav", "wma", "wmv", "mid", "avi", "mpg", "asf", "rm", "rmvb");
    public static final List<String> VIDEO_EXTENSION = List.of("mp4", "avi", "rmvb", "mkv", "mov");
    public static final List<String> FILE_EXTENSION = List.of("txt", "pdf", "word", "csv", "xlsx", "json");
    public static final List<String> DEFAULT_ALLOWED_EXTENSION = List.of("bmp", "gif", "jpg", "jpeg", "png", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "html", "htm", "txt", "rar", "zip", "gz", "bz2", "mp4", "avi", "rmvb", "pdf");

    public static String getExtension(String prefix) {
        return switch (prefix) {
            case IMAGE_PNG -> "png";
            case IMAGE_JPG -> "jpg";
            case IMAGE_JPEG -> "jpeg";
            case IMAGE_BMP -> "bmp";
            case IMAGE_GIF -> "gif";
            default -> "";
        };
    }

}
