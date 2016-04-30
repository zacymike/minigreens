/**
 * Created by Judit on 2016. 04. 23..
 */
public class Colonel extends Player {
    private static Colonel colonel;

    public static Colonel getInstance() {
        if ( colonel == null ) colonel = new Colonel();
        return colonel;
    }

    public void reset()
    {
        colonel = null;
    }

    @Override
    void autoZPM() {
        Maze.generateZPM();
    }
}
