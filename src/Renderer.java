import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Renderer extends JPanel implements Observer{
    private static Renderer renderer;
    private static HashMap<String, Image> textures;
    private Floor[][] maze;
    private State gamestate;
    private MenuOptions menustate = MenuOptions.MAPS;
    private static int width = 630;
    private static int height = 630;
    private static final int cellsize = 30;
    private static int fontsize = 60;
    private static int menucols = 4;
    private static int menurows = 2;
    private static int selectedmap = 0;

    private Renderer()
    {
        setPreferredSize(new Dimension(width, height));

        textures = new HashMap<>();
        textures.put("floor", new ImageIcon(getClass().getResource("floor.png")).getImage());
        textures.put("colonelup", new ImageIcon(getClass().getResource("colonelup.png")).getImage());
        textures.put("coloneldown", new ImageIcon(getClass().getResource("coloneldown.png")).getImage());
        textures.put("colonelleft", new ImageIcon(getClass().getResource("colonelleft.png")).getImage());
        textures.put("colonelright", new ImageIcon(getClass().getResource("colonelright.png")).getImage());
        textures.put("jaffaup", new ImageIcon(getClass().getResource("jaffaup.png")).getImage());
        textures.put("jaffadown", new ImageIcon(getClass().getResource("jaffadown.png")).getImage());
        textures.put("jaffaleft", new ImageIcon(getClass().getResource("jaffaleft.png")).getImage());
        textures.put("jaffaright", new ImageIcon(getClass().getResource("jaffaright.png")).getImage());
        textures.put("replicator", new ImageIcon(getClass().getResource("replicator.png")).getImage());
        textures.put("gap", new ImageIcon(getClass().getResource("gap.png")).getImage());
        textures.put("dooropen", new ImageIcon(getClass().getResource("dooropen.png")).getImage());
        textures.put("doorclose", new ImageIcon(getClass().getResource("doorclosed.png")).getImage());
        textures.put("scale", new ImageIcon(getClass().getResource("scale.png")).getImage());
        textures.put("wall", new ImageIcon(getClass().getResource("wall.png")).getImage());
        textures.put("wallspecial", new ImageIcon(getClass().getResource("wallspecial.png")).getImage());
        textures.put("sgblue", new ImageIcon(getClass().getResource("sgblue.png")).getImage());
        textures.put("sgyellow", new ImageIcon(getClass().getResource("sgyellow.png")).getImage());
        textures.put("sgred", new ImageIcon(getClass().getResource("sgred.png")).getImage());
        textures.put("sggreen", new ImageIcon(getClass().getResource("sggreen.png")).getImage());
        textures.put("box", new ImageIcon(getClass().getResource("box.png")).getImage());
        textures.put("zpm", new ImageIcon(getClass().getResource("zpm.png")).getImage());
    }

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
                    renderFloor(g, j*cellsize, i*cellsize);
    }

    public void renderFloor(Graphics g, int x, int y)
    {
        g.drawImage(textures.get("floor"), x, y, null);
        if(maze[y/cellsize][x/cellsize].getElement() != null)
            renderElement(g, x, y, maze[y/cellsize][x/cellsize].getElement());
    }

    public void renderElement(Graphics g, int x, int y, Element element)
    {
        /**
         * Doboz kirajzolása
         */
        if (element instanceof Box)
            g.drawImage(textures.get("box"), x, y, null);
        /**
         * Ajtó kirajzolása
         */
        else if (element instanceof Door)
        {
            // Nyitott ajtó
            if(((Door) element).isOpened())
                g.drawImage(textures.get("dooropen"), x, y, null);
            // Zárt ajtó
            else
                g.drawImage(textures.get("doorclose"), x, y, null);
        }
        /**
         * Szakadék kirajzolása
         */
        else if (element instanceof Gap)
        {
            g.drawImage(textures.get("gap"), x, y, null);
        }
        /**
         * Mérleg kirajzolása
         */
        else if (element instanceof Scale)
        {
            g.drawImage(textures.get("scale"), x, y, null);
        }
        /**
         * Fal és csillagkapu kirajzolása
         */
        else if (element instanceof Wall)
        {
            // Speciális fal
            if(((Wall) element).getIsSpecial())
            {
                g.drawImage(textures.get("wallspecial"), x, y, null);

                // Van csillagkapu a falon
                if(((Wall)element).getSG() != null)
                {
                    switch (((Wall) element).getSG().getType())
                    {
                        case BLUE:
                            g.drawImage(textures.get("sgblue"), x, y, null);
                            break;
                        case YELLOW:
                            g.drawImage(textures.get("sgyellow"), x, y, null);
                            break;
                        case RED:
                            g.drawImage(textures.get("sgred"), x, y, null);
                            break;
                        case GREEN:
                            g.drawImage(textures.get("sggreen"), x, y, null);
                            break;
                    }
                }
            }
            // Sima fal
            else
            {
                g.drawImage(textures.get("wall"), x, y, null);
            }
        }
        /**
         * ZPM kirajzolása
         */
        else if (element instanceof ZPM)
        {
            g.drawImage(textures.get("zpm"), x, y, null);
        }
    }

    public void renderMovables(Graphics g)
    {
        Floor colonel = Colonel.getInstance().getPosition();
        Floor jaffa = Jaffa.getInstance().getPosition();
        Floor replicator = Replicator.getInstance().getPosition();

        if(maze != null)
            for(int i = 0; i < maze.length; i++)
            {
                for (int j = 0; j < maze[0].length; j++)
                {
                    if(colonel == maze[i][j])
                    {
                        renderOneill(g, j*cellsize, i*cellsize);
                    }
                    if(jaffa == maze[i][j])
                    {
                        renderJaffa(g, j*cellsize, i*cellsize);
                    }
                    if(replicator == maze[i][j])
                    {
                        renderReplicator(g, j*cellsize, i*cellsize);
                    }
                }
            }
    }

    public void renderOneill(Graphics g, int x, int y)
    {
        // Colonel iránya szerinti kép kirajzolása
        switch (Colonel.getInstance().getDirection())
        {
            case NORTH:
                g.drawImage(textures.get("colonelup"), x, y, null);
                break;
            case EAST:
                g.drawImage(textures.get("colonelright"), x, y, null);
                break;
            case SOUTH:
                g.drawImage(textures.get("coloneldown"), x, y, null);
                break;
            case WEST:
                g.drawImage(textures.get("colonelleft"), x, y, null);
                break;
        }
    }

    public void renderJaffa(Graphics g, int x, int y)
    {
        // Jaffa iránya szerinti kép kirajzolása
        switch (Jaffa.getInstance().getDirection())
        {
            case NORTH:
                g.drawImage(textures.get("jaffaup"), x, y, null);
                break;
            case EAST:
                g.drawImage(textures.get("jaffaright"), x, y, null);
                break;
            case SOUTH:
                g.drawImage(textures.get("jaffadown"), x, y, null);
                break;
            case WEST:
                g.drawImage(textures.get("jaffaleft"), x, y, null);
                break;
        }
    }

    public void renderBullet(Graphics g, int x, int y, Bullet bullet)
    {
        g.setColor(Color.PINK);
        g.fillOval(x, y, 20, 20);
    }

    public void renderReplicator(Graphics g, int x, int y)
    {
        g.drawImage(textures.get("replicator"), x, y, null);
    }
}
