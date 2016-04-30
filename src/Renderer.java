import java.util.Observable;
import java.util.Observer;

public class Renderer implements Observer {
    private static Renderer renderer;

    public static Renderer getInstance() {
        if (renderer == null) renderer = new Renderer();
        return renderer;
    }

    @Override
    public void update(Observable observable, Object o) {
        //rajzolj ujra
    }
}
