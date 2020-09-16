package ai.brace.taskrunners;

import ai.brace.model.Text;
import ai.brace.model.TextFile;
import ai.brace.services.TextFileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Task2Runner {

    private TextFileReader _textFileReader;

    public Task2Runner(TextFileReader textFileReader) {
        _textFileReader = textFileReader;
    }

    public void runTask2() throws IOException {
        TextFile a1File = _textFileReader.readFile(TaskRunnerUtil.getPathForResource("a1.json"));
        TextFile a2File = _textFileReader.readFile(TaskRunnerUtil.getPathForResource("a2.json"));
        List<Text> textArray = a1File.getTextArray();
        textArray.addAll(a2File.getTextArray());
        Collections.sort(textArray);
        for (Text t : textArray) {
            System.out.println(t.getTextData());
        }

    }
}
