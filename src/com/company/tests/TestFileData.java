package com.company.tests;

import com.company.files.*;
import com.company.utils.Utils;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class TestFileData {
    public final static String TEXT_FILE_EXT = ".txt";
    public final static String AUDIO_FILE_EXT = ".aud";
    public final static String IMAGE_FILE_EXT = ".img";
    public final static String TEXT_DATA_MESSAGE = "Text data: {0}";
    public final static String FILE_DATA_MESSAGE = "File[{0}]: name - {1}, type - {2}";
    // --------------------------------------------------------------

    public static final String TEST_TEXT = "Test Text";
    public static final String TEST_DIRECTORY = "Test Directory";
    public final static String PLEASE_ENTER_FILENAME_TO_SEARCH_IT_IN_DIRECTORY =
            "Please, enter a filename to search it in directory \"{0}\" (or just type <Return> to stop):";
    public final static String FILE_WAS_FOUND_PATTERN = "File \"{0}\" was found";
    public final static String FILE_NOT_FOUND_PATTERN = "File \"{0}\" not found!";

    private SimpleFile simpleFile = null;
    private TextFile textFile = null;
    private AudioFile audioFile = null;
    private ImageFile imageFile = null;
    private Directory directory = null;
    private String testFilename;

    public String getTestFilename() {
        return testFilename;
    }

    public void setTestFilename(String testFilename) {
        this.testFilename = testFilename;
    }

    private void initFileData() {
        simpleFile = new SimpleFile(getTestFilename());
        textFile = new TextFile(getTestFilename() + TEXT_FILE_EXT, TEST_TEXT);
        audioFile = new AudioFile(getTestFilename() + AUDIO_FILE_EXT);
        imageFile = new ImageFile(getTestFilename() + IMAGE_FILE_EXT);
    }

    private void initDirectoryData() {
        directory = new Directory(TEST_DIRECTORY);

        directory.addFile(textFile);
        directory.addFile(imageFile);
        directory.addFile(audioFile);
    }

    private void showDirectoryData() {
        HashMap<String, SimpleFile> fileList = directory.getFiles();
        int commonCount = fileList.size();
        Object[] directoryData = fileList.values().toArray();

        for (int i=0; i < commonCount; i++)
            Utils.writeMessage(MessageFormat.format(FILE_DATA_MESSAGE, i,
                    ((SimpleFile)directoryData[i]).getFileName(),
                    ((SimpleFile)directoryData[i]).getFileType()));
        }

    public void demonstrateDirectoryData() {
        initDirectoryData();

        showFileSearch();

        showDirectoryData();
    }


    // The second task of unit 6 homework
    public void showFileSearch() {
        do {
            String fileName = Utils.readInputString(MessageFormat.format(PLEASE_ENTER_FILENAME_TO_SEARCH_IT_IN_DIRECTORY ,
                    directory.getFileName()));
            if (fileName.isEmpty()) break;

            try {
                SimpleFile simpleFile = directory.getFileByName(fileName);
                Utils.writeMessage(MessageFormat.format(FILE_WAS_FOUND_PATTERN, simpleFile.getFileName()));
            } catch (FileNotFoundException e) {
                Utils.writeMessage(MessageFormat.format(FILE_NOT_FOUND_PATTERN, e.getFileName()));
            }
        } while (true);
    }

    private void showFileData() {
        Utils.writeMessage(Utils.getClassNameMessage(simpleFile));
// ---------------

        Utils.writeMessage(Utils.getClassNameMessage(textFile));
        Utils.writeMessage(MessageFormat.format(TEXT_DATA_MESSAGE, textFile.getText()));

        Utils.writeMessage(Utils.getClassNameMessage(audioFile));
        Utils.writeMessage(Utils.getClassNameMessage(imageFile));

        // The first task of unit 6 homework
        Utils.inspectObjectProperties(textFile);
// ---------------
    }

    public void demonstrateFileData() throws IOException {
        initFileData();
        showFileData();
    }
// ----------------------------------------

    public void demonstrateData(String testFilename) throws IOException {
        setTestFilename(testFilename);
        
        demonstrateFileData();
        demonstrateDirectoryData();
    }
}
