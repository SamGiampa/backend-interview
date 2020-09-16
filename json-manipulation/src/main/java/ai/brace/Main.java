package ai.brace;

import ai.brace.services.TextFileReader;
import ai.brace.services.TextFileReaderImpl;
import ai.brace.taskrunners.Task1Runner;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {

        TextFileReader reader = new TextFileReaderImpl(); //Pseudo Dependecy Injection for the purposes of demonstration
        Task1Runner task1Runner = new Task1Runner(reader);
        try {
            task1Runner.runTask1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
