
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
    public void interact(Bullet bullet)
    {
        Logger.enter(this.getClass(), "interact()", bullet.getClass());

        Logger.exit(this.getClass(), "interact()", bullet.getClass());
    }
}
