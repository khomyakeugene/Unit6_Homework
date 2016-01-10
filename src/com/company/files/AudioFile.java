package com.company.files;

import sun.audio.AudioData;

/**
 * Created by Yevgen on 20.12.2015.
 */
public class AudioFile extends SimpleFile {
    public final static String AUDIO_FILE_TYPE = "Audio File Type";

    AudioData audioData = null;

    public AudioFile(String fileName) {
        super(fileName, AUDIO_FILE_TYPE);
    }

    public AudioFile(String fileName, AudioData audioData) {
        this(fileName);

        setAudioData(audioData);
    }

    public AudioData getAudioData() {
        return audioData;
    }

    public void setAudioData(AudioData audioData) {
        this.audioData = audioData;
    }
}
