
public class Box extends Weight implements Element
{
    private boolean alive;

    Box() {
        alive = true;
        addObserver(Renderer.getInstance());
    }

    @Override
    public void interact(Movable movable)
    {

    }

    @Override
    public void interact(Player player)
    {
        Logger.enter(this.getClass(), "interact()", player.getClass());

        Logger.exit(this.getClass(), "interact()", player.getClass());
    }

    @Override
    public void interact(Replicator replicator)
    {

    }

    @Override
    public void interact(Bullet bullet)
    {
        Logger.enter(this.getClass(), "interact()", bullet.getClass());

        bullet.destroy();

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

        player.setBox(this);
        player.getPosition().getNeighbour(player.getDirection()).setElement(null);

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

    public void destroy()
    {
        Logger.enter(this.getClass(), "destroy()", null);

        alive = false;
        notifyObservers();

        Logger.exit(this.getClass(), "destroy()", null);
    }
}
