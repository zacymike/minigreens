import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by anthor on 2016.05.01..
 */
public class WindowFrame extends JFrame
{
    private JPanel panel;

    public WindowFrame(JPanel panel, Maze maze)
    {
        this.panel = panel;
        setSize(new Dimension(600, 600));
        setTitle("Minigreens");
        add(panel);
    }

    public void refreshMap()
    {
        panel.repaint();
    }
}
