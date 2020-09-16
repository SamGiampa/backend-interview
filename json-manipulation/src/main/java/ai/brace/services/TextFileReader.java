package ai.brace.services;

import ai.brace.model.TextFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public interface TextFileReader {
    TextFile readFile(Path filePath) throws IOException;
}
