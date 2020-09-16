package ai.brace.taskrunners;

import ai.brace.model.TextFile;
import ai.brace.services.TextFileReader;
import ai.brace.services.TextFileReaderImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task1Runner {

    public void runTask1() throws IOException {
        TextFileReader reader = new TextFileReaderImpl();
        TextFile a1File = reader.readFile(getPathForResource("a1.json"));
        System.out.println(a1File);
    }

    public static Path getPathForResource(final String path)
    {
        try
        {
            return Paths.get(ClassLoader.getSystemResource(path).toURI());
        }
        catch (URISyntaxException e)
        {
            throw new RuntimeException(e);
        }
    }
}
