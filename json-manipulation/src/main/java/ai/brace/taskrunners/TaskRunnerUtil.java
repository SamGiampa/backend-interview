package ai.brace.taskrunners;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskRunnerUtil {

    //Composition used to get this method available to each task runner - We could have created a base TaskRunner and had each other Runner extend it.
    //If we were going to continue on with more tasks - and create a sort of TaskBuilder / TaskRunnerRunner architecture then that would be a good solution.
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
