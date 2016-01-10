package com.company.files;

import java.util.HashMap;

/**
 * Created by Yevgen on 20.12.2015.
 */
public class Directory extends SimpleFile {
    public final static String DIRECTORY_FILE_TYPE = "Directory File Type";

    private HashMap<String, SimpleFile> files;

    public HashMap<String, SimpleFile> getFiles() {
        return files;
    }

    public Directory(String fileName) {
        super(fileName, DIRECTORY_FILE_TYPE);

        files = new HashMap<>();
    }

    public void addFile(SimpleFile file) {
        files.put(file.getFileName(), file);
    }

    public SimpleFile getFileByName(String fileName) throws FileNotFoundException {
        SimpleFile simpleFile = files.get(fileName);

        if (simpleFile == null) {
            throw new FileNotFoundException(fileName);
        }

        return simpleFile;
    }
}
