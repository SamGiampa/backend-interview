package ai.brace.services;

import ai.brace.model.TextFile;

import java.io.IOException;

public interface TextFileWriter {
    void createFile(TextFile textFile, String fileName) throws IOException;
}
