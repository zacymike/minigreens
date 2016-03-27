
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

    }

    @Override
    public void interact(Bullet bullet)
    {
        bullet.destroy();
    }

    public void destroy()
    {
        alive = false;
    }
}
