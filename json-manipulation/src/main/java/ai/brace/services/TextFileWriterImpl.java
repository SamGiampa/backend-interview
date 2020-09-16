package ai.brace.services;

import ai.brace.model.TextFile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TextFileWriterImpl implements TextFileWriter {
    @Override
    public void createFile(TextFile textFile, String fileName) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        builder.setPrettyPrinting().create(); //This makes output easier to read
        Gson gson = builder.create();

        Writer writer = new FileWriter(fileName);
        gson.toJson(textFile, writer);
        writer.close();
    }
}
