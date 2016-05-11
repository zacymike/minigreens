import java.io.IOException;

/**
 * Created by anthor on 2016.05.11..
 */
public class App
{
    public static void main(String[] args)
    {
        try
        {
            Maze.getInstance().run();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
