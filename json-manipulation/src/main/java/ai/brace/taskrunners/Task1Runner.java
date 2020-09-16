package ai.brace.taskrunners;

import ai.brace.services.TextFileReader;
import ai.brace.services.TextFileReaderImpl;

public class Task1Runner {

    public void runTask1(){
        TextFileReader reader = new TextFileReaderImpl();
        System.out.println(reader.readFile("resources/a1.json"));
    }
}
