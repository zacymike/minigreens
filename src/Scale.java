
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
        door.setState(true);
    }

    @Override
    public void interact(Bullet bullet)
    {

    }
}
