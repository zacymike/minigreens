import com.sun.xml.internal.ws.db.DatabindingImpl;
import sun.plugin2.util.ColorUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class Renderer extends JPanel implements Observer{
    private static Renderer renderer;
    private Floor[][] maze;
    private State gamestate;
    private MenuOptions menustate = MenuOptions.MAPS;
    private static int width = 600;
    private static int height = 600;
    private static int fontsize = 60;
    private static int menucols = 4;
    private static int menurows = 2;
    private static int selectedmap = 0;

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

    public void setMenustate(MenuOptions menustate)
    {
        this.menustate = menustate;
    }

    public void setMenuMapsDimension(int rows, int cols)
    {
        menurows = rows;
        menucols = cols;
    }

    public void setSelectedMap(int id)
    {
        selectedmap = id;
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
        render(g);
    }

    public void render(Graphics g)
    {
        switch(gamestate)
        {

            case MENU:
                /**
                 * Háttér rajzolás
                 */
                g.setColor(new Color(41, 40, 51));
                g.fillRect(0, 0, width, height);

                /**
                 * Menüpontok rajzolása
                 */
                g.setFont(new Font("Arial", Font.BOLD, fontsize));
                switch(menustate)
                {

                    case MAPS:
                        g.setColor(new Color(209, 197, 86));
                        g.drawString("MAPS", width/2 - (fontsize*2), height/2 - fontsize);
                        g.setColor(new Color(209, 87, 70));
                        g.drawString("EXIT", width/2 - (fontsize*2), height/2 + fontsize);
                        break;
                    case EXIT:
                        g.setColor(new Color(209, 87, 70));
                        g.drawString("MAPS", width/2 - (fontsize*2), height/2 - fontsize);
                        g.setColor(new Color(209, 197, 86));
                        g.drawString("EXIT", width/2 - (fontsize*2), height/2 + fontsize);
                        break;
                }

                break;
            case MAPS:
                /**
                 * Háttér rajzolás
                 */
                g.setColor(new Color(41, 40, 51));
                g.fillRect(0, 0, width, height);

                /**
                 * Maps felirat rajzolása
                 */
                g.setColor(new Color(209, 87, 70));
                g.setFont(new Font("Arial", Font.PLAIN, fontsize));
                g.drawString("MAPS", width/2 - (fontsize*2), 100);

                /**
                 * Map ikonok kirajzolása
                 */
                int paddingx= 25;
                int paddingy= 250;
                for(int i = 0; i < menurows; i++)
                {
                    for(int j = 0; j < menucols; j++)
                    {
                        if(i*menucols+j == selectedmap)
                            g.setColor(new Color(209, 197, 86));
                        else
                            g.setColor(new Color(209, 87, 70));
                        g.drawRect(paddingx + j*150, paddingy + i*150, 100, 100);
                        g.setColor(Color.BLACK);
                        g.drawString(String.format("%d", i*menucols+j+1),paddingx + j*150 + 25, paddingy + i*150 + 60);
                    }
                }

                break;
            case GAME:
                renderMaze(g);
                renderMovables(g);
                break;
        }
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
