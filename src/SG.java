
public class SG implements Element
{
    private Floor entry;
    private Wall wall;
    private ShootType type;

    public SG() { entry = null; }

    public Floor getEntry() {
        Logger.enter(this.getClass(), "getEntry()", null);
        Logger.exit(this.getClass(), "getEntry()", null);

        return entry;
    }

    public void setEntry(Floor floor) {
        Logger.enter(this.getClass(), "setEntry()", floor.getClass());

        entry = floor;

        Logger.exit(this.getClass(), "setEntry()", floor.getClass());
    }

    public Wall getWall()
    {
        return wall;
    }

    public void setWall(Wall wall)
    {
        this.wall = wall;
    }

    public ShootType getType()
    {
        return type;
    }

    public void setType(ShootType type)
    {
        this.type = type;
    }

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

    }

    @Override
    public void interact(Box box)
    {

    }

    @Override
    public void pickedUp(Player player)
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
