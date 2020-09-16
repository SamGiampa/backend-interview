package ai.brace.services;

import ai.brace.model.TextFile;

import java.io.FileReader;

public class TextFileReaderImpl implements TextFileReader{
    @Override
    public TextFile readFile(String filePath) {
        return gson.fromJson(new FileReader(filePath), TextFile.class)
    }
}
