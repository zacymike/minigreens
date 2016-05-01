import javax.swing.*;
import java.awt.*;

/**
 * Created by anthor on 2016.05.01..
 */
public class WindowFrame extends JFrame
{
    private JPanel panel;

    public WindowFrame(JPanel panel)
    {
        this.panel = panel;
        setSize(new Dimension(625, 625));
        setTitle("Minigreens");
        add(panel);
    }

    public void refreshMap()
    {
        panel.repaint();
    }
}
