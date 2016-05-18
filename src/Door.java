import java.util.Observable;

public class Door extends Observable implements Element {
    private boolean opened;

    Door() {
        opened = false;
        addObserver(Renderer.getInstance());
    }

    public void open() {
        this.opened = true;
        notifyObservers();
    }

    public void close() {
        this.opened = false;
        notifyObservers();
    }

    public boolean isOpened() {
        return opened;
    }

    @Override
    public void interact(Movable movable) {

    }

    @Override
    public void interact(Player player) {
        if (opened) {
            player.setPosition(player.getPosition().getNeighbour(player.getDirection()));
        }
    }

    @Override
    public void interact(Replicator replicator)
    {
        if (opened) {
            replicator.setPosition(replicator.getPosition().getNeighbour(replicator.getDirection()));
        }
    }

    @Override
    public void interact(Bullet bullet)
    {
        if (opened) {
            bullet.setPosition(bullet.getPosition().getNeighbour(bullet.getDirection()));
        } else {
            bullet.destroy();
        }
    }

    @Override
    public void interact(Box box) {}

    @Override
    public void pickedUp(Player player) {}

    @Override
    public void steppedOut(Player player) {}

    @Override
    public void steppedOut(Replicator repliactor) {}

    @Override
    public void steppedOut(Box box) {}
}
