import java.util.Observable;

public class Door extends Observable implements Element {
    private boolean opened;

    Door() {
        opened = false;
        addObserver(Renderer.getInstance());
    }

    public void open() {
        Logger.enter(this.getClass(), "open()", null);

        this.opened = true;
        notifyObservers();

        Logger.exit(this.getClass(), "open()", null);
    }

    public void close() {
        Logger.enter(this.getClass(), "close()", null);

        this.opened = false;
        notifyObservers();

        Logger.exit(this.getClass(), "close()", null);
    }

    public boolean isOpened() {
        Logger.enter(this.getClass(), "isOpened()", null);
        Logger.exit(this.getClass(), "isOpened()", null);

        return opened;
    }

    @Override
    public void interact(Movable movable) {

    }

    @Override
    public void interact(Player player) {
        Logger.enter(this.getClass(), "interact()", player.getClass());

        if (opened) {
            player.setPosition(player.getPosition().getNeighbour(player.getDirection()));
        }

        Logger.exit(this.getClass(), "interact()", player.getClass());
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
        Logger.enter(this.getClass(), "interact()", bullet.getClass());

        if (opened) {
            bullet.setPosition(bullet.getPosition().getNeighbour(bullet.getDirection()));
        } else {
            bullet.destroy();
        }

        Logger.exit(this.getClass(), "interact()", bullet.getClass());
    }

    @Override
    public void interact(Box box)
    {
        Logger.enter(this.getClass(), "interact()", box.getClass());

        Logger.exit(this.getClass(), "interact()", box.getClass());
    }

    @Override
    public void pickedUp(Player player)
    {
        Logger.enter(this.getClass(), "pickedUp()", player.getClass());

        Logger.exit(this.getClass(), "pickedUp()", player.getClass());
    }

    @Override
    public void steppedOut(Player player)
    {
        Logger.enter(this.getClass(), "steppedOut()", player.getClass());

        Logger.exit(this.getClass(), "steppedOut()", player.getClass());
    }

    @Override
    public void steppedOut(Replicator repliactor)
    {

    }

    @Override
    public void steppedOut(Box box)
    {
        Logger.enter(this.getClass(), "steppedOut()", box.getClass());

        Logger.exit(this.getClass(), "steppedOut()", box.getClass());
    }
}
