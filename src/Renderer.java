import com.sun.xml.internal.ws.db.DatabindingImpl;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Renderer extends JPanel implements Observer {
    private static Renderer renderer;
    private Floor[][] maze;
    private State gamestate;

    public static Renderer getInstance() {
        if (renderer == null) renderer = new Renderer();
        return renderer;
    }

    public void setMaze(Floor[][] maze)
    {
        this.maze = maze;
    }

    public  void setState(State gamestate)
    {
        this.gamestate = gamestate;
    }

    @Override
    public void update(Observable observable, Object o) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        setBackground(Color.BLACK);

        renderMaze(g);
        renderMovables(g);
    }

    public void render(State gamestate)
    {

    }

    public void renderMaze(Graphics g)
    {
        if(maze != null)
            for (int i = 0; i < maze.length; i++)
                for (int j = 0; j < maze[0].length; j++)
                    renderFloor(g, j*25, i*25);
    }

    public void renderFloor(Graphics g, int x, int y)
    {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 25, 25);
    }

    public void renderElement(Graphics g, int x, int y, Element element)
    {

    }

    public void renderMovables(Graphics g)
    {
        Floor colonel = Colonel.getInstance().getPosition();

        if(maze != null)
            for(int i = 0; i < maze.length; i++)
            {
                for (int j = 0; j < maze[0].length; j++)
                {
                    if(colonel == maze[i][j])
                    {
                        renderOneill(g, j*25, i*25);
                    }
                }
            }
    }

    public void renderOneill(Graphics g, int x, int y)
    {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, 20, 20);
    }

    public void renderJaffa(Graphics g, int x, int y)
    {
        g.setColor(Color.PINK);
        g.fillOval(x, y, 20, 20);
    }

    public void renderBullet(Graphics g, int x, int y, Bullet bullet)
    {
        g.setColor(Color.PINK);
        g.fillOval(x, y, 20, 20);
    }
}
