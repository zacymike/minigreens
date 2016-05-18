import java.util.Observable;

public class ZPM extends Observable implements Element {
    ZPM() { addObserver(Renderer.getInstance()); }

    @Override
    public void interact(Movable movable) {

    }

    @Override
    public void interact(Player player) {}

    @Override
    public void interact(Replicator replicator) {}

    @Override
    public void interact(Box box) {}

    @Override
    public void interact(Bullet bullet) {bullet.destroy();}

    @Override
    public void pickedUp(Player player) {
        player.addZPM();
        player.getPosition().getNeighbour(player.getDirection()).setElement(null);
        notifyObservers();
    }

    @Override
    public void steppedOut(Player player) {}

    @Override
    public void steppedOut(Replicator repliactor)
    {}

    @Override
    public void steppedOut(Box box) {}
}
