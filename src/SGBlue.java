
public class SGBlue extends SG
{
    private static SGBlue instance = new SGBlue();

    private SGBlue() {}

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
        Floor end = yellow.getNeighbour();
        if(end != null)
            player.setPosition(end);
    }
}
