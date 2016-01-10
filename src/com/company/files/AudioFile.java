package com.company.files;

/**
 * Created by Yevgen on 20.12.2015 as a part of the project "Unit6_Homework".
 */
public class AudioFile extends SimpleFile {
    public final static String AUDIO_FILE_TYPE = "Audio File Type";

    public AudioFile(String fileName) {
        super(fileName, AUDIO_FILE_TYPE);
    }
}
