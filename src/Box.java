
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
    public void interact(Player player) {}

    @Override
    public void interact(Replicator replicator) {}

    @Override
    public void interact(Bullet bullet) {bullet.destroy();}

    @Override
    public void interact(Box box) {}

    @Override
    public void pickedUp(Player player)
    {
        player.setBox(this);
        player.getPosition().getNeighbour(player.getDirection()).setElement(null);
    }

    @Override
    public void steppedOut(Player player) {}

    @Override
    public void steppedOut(Replicator repliactor) {}

    @Override
    public void steppedOut(Box box) {}

    public void destroy()
    {
        alive = false;
        notifyObservers();
    }
}
