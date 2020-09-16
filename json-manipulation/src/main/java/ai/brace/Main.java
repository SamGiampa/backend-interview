package ai.brace;

import ai.brace.services.TextFileReader;
import ai.brace.services.TextFileReaderImpl;
import ai.brace.services.TextFileWriter;
import ai.brace.services.TextFileWriterImpl;
import ai.brace.taskrunners.Task1Runner;
import ai.brace.taskrunners.Task2Runner;
import ai.brace.taskrunners.Task3Runner;
import ai.brace.taskrunners.Task4Runner;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {

        //Pseudo Dependecy Injection for the purposes of demonstration
        TextFileReader reader = new TextFileReaderImpl();
        TextFileWriter writer = new TextFileWriterImpl();

        Task1Runner task1Runner = new Task1Runner(reader);
        try {
            System.out.println("TASK 1 START -------------------");
            task1Runner.runTask1();
            System.out.println("TASK 1 END ---------------------\n");
        } catch (IOException e) {
            System.out.println("Exception in Task runner 1 - Failed to run task 1 :");
            e.printStackTrace();
        }

        Task2Runner task2Runner = new Task2Runner(reader);
        try {
            System.out.println("TASK 2 START -------------------");
            task2Runner.runTask2();
            System.out.println("TASK 2 END ---------------------\n");
        } catch (IOException e) {
            System.out.println("Exception in Task runner 2 - Failed to run task 2 :");
            e.printStackTrace();
        }

        Task3Runner task3Runner = new Task3Runner(reader);
        try {
            System.out.println("TASK 3 START -------------------");
            task3Runner.runTask3();
            System.out.println("TASK 3 END ---------------------\n");
        } catch (IOException e) {
            System.out.println("Exception in Task runner 3 - Failed to run task 3 :");
            e.printStackTrace();
        }

        Task4Runner task4Runner = new Task4Runner(reader, writer);
        try {
            System.out.println("TASK 4 START -------------------");
            task4Runner.runTask4();
            System.out.println("TASK 4 END ---------------------\n");
        } catch (IOException e) {
            System.out.println("Exception in Task runner 4 - Failed to run task 4 :");
            e.printStackTrace();
        }
    }
}
