
public class Door implements Element {
    private boolean opened;

    Door() { opened = false; }

    public void setState(boolean state) {
        Logger.enter(this.getClass(), "setState()", null);

        this.opened = state; // should have separated open-close methods

        Logger.exit(this.getClass(), "setState()", null);
    }

    @Override
    public void interact(Movable movable) {

    }

    @Override
    public void interact(Player player) {
        Logger.enter(this.getClass(), "interact()", player.getClass());

        if (opened) {
            Direction dir = player.getDirection();
            Floor pos = player.getPosition();
            Floor newPos = pos.getNeighbour(dir);
            player.setPosition(newPos);
        }

        Logger.exit(this.getClass(), "interact()", player.getClass());
    }

    @Override
    public void interact(Bullet bullet)
    {
        Logger.enter(this.getClass(), "interact()", bullet.getClass());

        if(opened)
        {
            Floor doorpos = bullet.getPosition().getNeighbour(bullet.getDirection());
            bullet.setPosition(doorpos);
        }
        else
            bullet.destroy();

        Logger.exit(this.getClass(), "interact()", bullet.getClass());
    }

    @Override
    public void interact(Box box)
    {

    }

    @Override
    public void pickedUp()
    {

    }

    @Override
    public void steppedOut(Player player)
    {

    }

    @Override
    public void steppedOut(Box box)
    {

    }
}
