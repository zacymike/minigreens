
public abstract class SG implements Element
{
    private Floor entry;
    private Wall wall;

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
}
