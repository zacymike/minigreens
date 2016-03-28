
public class SGBlue extends SG
{
    private static SGBlue instance = new SGBlue();

    private SGBlue() { super(); }

    public static SGBlue getInstance()
    {
        return instance;
    }

    @Override
    public void interact(Movable movable) {}

    @Override
    public void interact(Player player)
    {
        SGYellow yellow = SGYellow.getInstance();
        Floor end = yellow.getEntry();
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
