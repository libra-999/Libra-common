package com.common.util;

import cn.hutool.core.lang.Assert;
import com.common.commonutil.constant.MimeTypeConstant;
import com.common.commonutil.constant.ContentTypeConstant;
import com.common.commonutil.file.FileType;
import com.common.commonutil.file.File;
import org.junit.jupiter.api.Test;

public class FileTest {

    private static final String TEST_URl =  "https://file.tititsspa.org/office-HR/2029-12-22-zkxnjnkfsa.png";

    @Test
    public void FileNameCheck (){

        String filename = File.getName(TEST_URl);
        Assert.isTrue(!filename.startsWith(ContentTypeConstant.HTTPS) || !filename.startsWith(ContentTypeConstant.HTTP), "==> getName Method is wrong logic!");
    }

    @Test
    public void validImageFile(){
        String fileName = File.getName(TEST_URl);
        String mimeFileName = FileType.getFileType(fileName);
        Assert.isTrue(MimeTypeConstant.IMAGE_EXTENSION.contains(mimeFileName),"==> File: " + fileName + " is invalid in " + MimeTypeConstant.IMAGE_EXTENSION );
    }
}
