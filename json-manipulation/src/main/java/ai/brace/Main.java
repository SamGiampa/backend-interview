package ai.brace;

import ai.brace.taskrunners.Task1Runner;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        Task1Runner task1Runner = new Task1Runner();
        try {
            task1Runner.runTask1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
