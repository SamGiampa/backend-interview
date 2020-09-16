package ai.brace.taskrunners;

import ai.brace.model.Text;
import ai.brace.model.TextFile;
import ai.brace.services.TextFileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Task3Runner {

    private TextFileReader _textFileReader;

    public Task3Runner(TextFileReader textFileReader) {
        _textFileReader = textFileReader;
    }

    public void runTask3() throws IOException {
        TextFile a1File = _textFileReader.readFile(getPathForResource("a1.json"));
        TextFile a2File = _textFileReader.readFile(getPathForResource("a2.json"));
        List<Text> textArray = a1File.getTextArray();
        textArray.addAll(a2File.getTextArray());
        TreeMap<String,Integer> wordMap = new TreeMap<>();
        for (Text t : textArray) {
            String[] wordsInTextData = t.getTextData().split(" ");
            for( String s : wordsInTextData){
                wordMap.put(s, wordMap.getOrDefault(s, 0) + 1);
            }
        }
        for(Map.Entry<String,Integer> wordCount : wordMap.entrySet()){
            System.out.println("(" + wordCount.getKey() + ") : " + wordCount.getValue());
        }

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
