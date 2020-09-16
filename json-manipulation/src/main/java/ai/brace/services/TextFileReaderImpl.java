package ai.brace.services;

import ai.brace.model.TextFile;
import com.google.gson.*;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class TextFileReaderImpl implements TextFileReader{
    @Override
    public TextFile readFile(Path filePath) throws IOException {
        //NOTE - This date parsing code is modified from solutions found on stack overflow - I had to learn how to create the custom parser

        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong()*1000);
            }
        });

        Gson gson = builder.create();

        Reader reader = Files.newBufferedReader(filePath);
        return gson.fromJson(reader,TextFile.class);
    }
}
