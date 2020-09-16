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
        /*We don't use it much here - but the idea is that we could build tests where we pass in a mocked implementation of these services to facilitate testing*/

        /*The code in general is in need of testing - normal practice would be to write the services - writer and reader and test that they work as expected
            The rest of the code is sort of it's own integration test - but if not we would want to write integration tests using mocked interfaces that confirm the behavior of each task runner
            without having to touch or write any actual files (which in production might be too sensitive to interact with)
         */

        /* Before any tasks I wanted to understand the problem scope and try to see what my code would want to do long term - once it was clear
        we were operating on the TextFile and the Text Elements - I set right away to create my model for this problem. After that I knew I would be reading the files
        and I would be using GSON - at this point I had to go and quickly read a bit of GSON documentation as I hadn't used it before. After that I was able to create a reader class which went
        from files to Classes. After that I set about to do the logical algorithmic part of the code for each task.
         */

        //For this task it was relatively simple once we had our GSON reader service - we just read the file, ordered the lines using a custom comparator (only compare based on Id) and print
        Task1Runner task1Runner = new Task1Runner(reader);
        try {
            System.out.println("TASK 1 START -------------------");
            task1Runner.runTask1();
            System.out.println("TASK 1 END ---------------------\n");
        } catch (IOException e) {
            System.out.println("Exception in Task runner 1 - Failed to run task 1 :");
            e.printStackTrace();
        }

        //For this task - we start to see some of the same behavior repeated - an in a better solution I should move getPathForResource to a helper class (I actually just did this)
        //The sorting here isn't optimal - probably better to start with some sort of tree map which is automatically sort by key - but a List is sufficient for the small number.
        Task2Runner task2Runner = new Task2Runner(reader);
        try {
            System.out.println("TASK 2 START -------------------");
            task2Runner.runTask2();
            System.out.println("TASK 2 END ---------------------\n");
        } catch (IOException e) {
            System.out.println("Exception in Task runner 2 - Failed to run task 2 :");
            e.printStackTrace();
        }

        //Here we have a larger (relatively) sorting problem so we move to using the TreeMap - works well for this use case because it will iterate through in the natural key.
        Task3Runner task3Runner = new Task3Runner(reader);
        try {
            System.out.println("TASK 3 START -------------------");
            task3Runner.runTask3();
            System.out.println("TASK 3 END ---------------------\n");
        } catch (IOException e) {
            System.out.println("Exception in Task runner 3 - Failed to run task 3 :");
            e.printStackTrace();
        }

        //For task 4 we expand our usage from just the textData inside the TextFiles but to actually need a whole model of the TextFile itself - at this point I went through and refined my model / reader to handle dates well.
        //We also needed a writer for this task - and so a new service was added.
        Task4Runner task4Runner = new Task4Runner(reader, writer);
        try {
            System.out.println("TASK 4 START -------------------");
            task4Runner.runTask4();
            System.out.println("TASK 4 END ---------------------\n");
        } catch (IOException e) {
            System.out.println("Exception in Task runner 4 - Failed to run task 4 :");
            e.printStackTrace();
        }

        /*General To Dos:
        Testing as discussed above
        Fix some issues with time zone handling in TextFile writer
        Could order the text data in the merged file - though perhaps not required
         */

    }
}
