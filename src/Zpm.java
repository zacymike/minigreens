
public class Zpm implements Element
{
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
}