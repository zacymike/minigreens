
public class Scale implements Element
{
    private Door door;

    @Override
    public void interact(Movable movable)
    {

    }

    @Override
    public void interact(Player player)
    {
        Logger.enter(this.getClass(), "interact()", player.getClass());

        door.open();

        Logger.exit(this.getClass(), "interact()", player.getClass());
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

        door.open();

        Logger.exit(this.getClass(), "interact()", box.getClass());
    }

    @Override
    public void pickedUp()
    {
        Logger.enter(this.getClass(), "pickedUp()", null);

        Logger.exit(this.getClass(), "pickedUp()", null);
    }

    @Override
    public void steppedOut(Player player)
    {
        Logger.enter(this.getClass(), "steppedOut()", player.getClass());

        door.close();

        Logger.exit(this.getClass(), "steppedOut()", player.getClass());
    }

    @Override
    public void steppedOut(Box box)
    {
        Logger.enter(this.getClass(), "steppedOut()", box.getClass());

        door.close();

        Logger.exit(this.getClass(), "steppedOut()", box.getClass());
    }
}
