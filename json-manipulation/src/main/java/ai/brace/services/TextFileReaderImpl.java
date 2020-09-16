package ai.brace.services;

import ai.brace.model.TextFile;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextFileReaderImpl implements TextFileReader{
    @Override
    public TextFile readFile(Path filePath) throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(filePath);
        return gson.fromJson(reader,TextFile.class);
    }
}
