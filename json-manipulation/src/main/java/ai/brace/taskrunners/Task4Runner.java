package ai.brace.taskrunners;

import ai.brace.model.Text;
import ai.brace.model.TextFile;
import ai.brace.services.TextFileReader;
import ai.brace.services.TextFileWriter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Task4Runner {

    private TextFileReader _textFileReader;
    private TextFileWriter _textFileWriter;

    public Task4Runner(TextFileReader textFileReader, TextFileWriter textFileWriter) {
        _textFileReader = textFileReader;
        _textFileWriter = textFileWriter;
    }

    public void runTask4() throws IOException {
        TextFile a1File = _textFileReader.readFile(getPathForResource("a1.json"));
        TextFile a2File = _textFileReader.readFile(getPathForResource("a2.json"));
        TextFile mergedFile = mergeTwoTextFiles(a1File,a2File);
        _textFileWriter.createFile(mergedFile,"output.json");
    }

    //This method only handles two files - best case it should handle many files but that would be a bit more code - maybe I will add later
    private TextFile mergeTwoTextFiles(TextFile textFile1, TextFile textFile2){
        TextFile newestFile = textFile1;
        TextFile olderFile = textFile2;
        if(textFile1.getLastModified() < textFile2.getLastModified()){
            newestFile = textFile2;
            olderFile = textFile1;
        }
        //We avoid reflection or some other process here which would iterate through fields of the class - not the best practice
        TextFile mergedFile = new TextFile();
        mergedFile.setAuthor(newestFile.getAuthor() == null ? olderFile.getAuthor() : newestFile.getAuthor());
        mergedFile.setLanguage(newestFile.getLanguage() == null ? olderFile.getLanguage() : newestFile.getLanguage());
        mergedFile.setLastModified(newestFile.getLastModified() == null ? olderFile.getLastModified() : newestFile.getLastModified());
        mergedFile.setReleaseDate(newestFile.getReleaseDate() == null ? olderFile.getReleaseDate() : newestFile.getReleaseDate());
        mergedFile.setTitle(newestFile.getTitle() == null ? olderFile.getTitle() : newestFile.getTitle());
        mergedFile.setTranslator(newestFile.getTranslator() == null ? olderFile.getTranslator() : newestFile.getTranslator());
        mergedFile.setVersion(newestFile.getVersion() == null ? olderFile.getVersion() : newestFile.getVersion());
        mergedFile.setTextArray(olderFile.getTextArray());
        mergedFile.getTextArray().addAll(newestFile.getTextArray());
        mergedFile.setUuid(java.util.UUID.randomUUID().toString()); //Maybe TextData class should handle uuid field as UUID class - will take a look after tests working like this
        return mergedFile;
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
