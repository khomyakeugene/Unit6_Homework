package com.company.files;

import com.company.utils.Const;

import java.util.HashMap;

/**
 * Created by Yevgen on 20.12.2015.
 */
public class Directory extends SimpleFile {
    private HashMap<String, SimpleFile> files;

    public HashMap<String, SimpleFile> getFiles() {
        return files;
    }

    public Directory(String fileName) {
        super(fileName, Const.DIRECTORY_FILE_TYPE);

        files = new HashMap<String, SimpleFile>();
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
