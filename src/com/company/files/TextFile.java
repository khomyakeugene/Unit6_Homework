package com.company.files;

/**
 * Created by Yevgen on 20.12.2015.
 */
public class TextFile extends SimpleFile {
    public final static String TEXT_FILE_TYPE = "Text File Type";

    private String text;

    public TextFile(String fileName) {
        super(fileName, TEXT_FILE_TYPE);
    }

    public TextFile(String fileName, String text) {
        this(fileName);

        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
