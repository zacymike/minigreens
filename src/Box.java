
public class Box implements Element
{
    private boolean alive;

    Box() { alive = true; }

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
    public void interact(Bullet bullet)
    {
        Logger.enter(this.getClass(), "interact()", bullet.getClass());

        bullet.destroy();

        Logger.exit(this.getClass(), "interact()", bullet.getClass());
    }

    public void destroy()
    {
        Logger.enter(this.getClass(), "destroy()", null);

        alive = false;

        Logger.exit(this.getClass(), "destroy()", null);
    }
}
