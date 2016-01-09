package com.company.files;

/**
 * Created by Yevgen on 09.01.2016.
 */

// The second task of unit 6 homework
public class FileNotFoundException extends IndexOutOfBoundsException {
    private String fileName;

    public FileNotFoundException(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}


