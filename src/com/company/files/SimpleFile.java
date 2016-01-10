package com.company.files;

import com.company.utils.SelfDescribingObject;

/**
 * Created by Yevgen on 20.12.2015.
 */

// Use <SelfDescribingObject> as a part of task of homework of Unit 6
public class SimpleFile extends SelfDescribingObject {
    public final static String UNKNOWN_FILE_TYPE = "Undefined File Type";

    private String fileName;
    private String fileType = UNKNOWN_FILE_TYPE;

    public SimpleFile(String fileName) {
        setFileName(fileName);
    }

    public SimpleFile(String fileName, String fileType) {
        setFileName(fileName);
        setFileType(fileType);
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
