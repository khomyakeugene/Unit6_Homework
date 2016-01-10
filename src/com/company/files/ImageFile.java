package com.company.files;

/**
 * Created by Yevgen on 20.12.2015.
 */
public class ImageFile extends SimpleFile {
    public final static String IMAGE_FILE_TYPE = "Image File Type";

    public ImageFile(String fileName) {
        super(fileName, IMAGE_FILE_TYPE);
    }
}
