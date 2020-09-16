package ai.brace.services;

import ai.brace.model.TextFile;

public interface TextFileReader {
    TextFile readFile(String filePath);
}
