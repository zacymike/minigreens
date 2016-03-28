
public class SGYellow extends SG
{
    private static SGYellow instance = new SGYellow();

    private SGYellow() { super(); }

    public static SGYellow getInstance()
    {
        return instance;
    }

    @Override
    public void interact(Movable movable) {}

    @Override
    public void interact(Player player)
    {
        SGBlue blue = SGBlue.getInstance();
        Floor end = blue.getEntry();
        if(end != null)
            player.setPosition(end);
    }

    @Override
    public void interact(Bullet bullet)
    {

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
