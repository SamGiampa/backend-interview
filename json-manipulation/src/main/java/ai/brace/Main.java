package ai.brace;

import ai.brace.services.TextFileReader;
import ai.brace.services.TextFileReaderImpl;
import ai.brace.taskrunners.Task1Runner;
import ai.brace.taskrunners.Task2Runner;
import ai.brace.taskrunners.Task3Runner;

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
            System.out.println("Exception in Task runner 1 - Failed to run task 1 :");
            e.printStackTrace();
        }

        Task2Runner task2Runner = new Task2Runner(reader);
        try {
            task2Runner.runTask2();
        } catch (IOException e) {
            System.out.println("Exception in Task runner 2 - Failed to run task 2 :");
            e.printStackTrace();
        }

        Task3Runner task3Runner = new Task3Runner(reader);
        try {
            task3Runner.runTask3();
        } catch (IOException e) {
            System.out.println("Exception in Task runner 3 - Failed to run task 3 :");
            e.printStackTrace();
        }
    }
}
