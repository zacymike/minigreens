
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

        door.setState(true);

        Logger.exit(this.getClass(), "interact()", player.getClass());
    }

    @Override
    public void interact(Bullet bullet) { bullet.destroy(); }

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
        Logger.enter(this.getClass(), "interact()", box.getClass());

        Logger.exit(this.getClass(), "interact()", box.getClass());
    }
}
