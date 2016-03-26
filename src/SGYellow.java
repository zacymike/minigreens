
public class SGYellow extends SG
{
    private static SGYellow instance = new SGYellow();

    private SGYellow() {}

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
        Floor end = blue.getNeighbour();
        if(end != null)
            player.setPosition(end);
    }
}
