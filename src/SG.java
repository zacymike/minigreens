
public class SG implements Element
{
    private Floor entry;
    private Wall wall;
    private Type type;

    public SG(Type type)
    {
        this.type = type;
        entry = null;
    }

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

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
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
        switch(type)
        {
            case BLUE:
                if(entry == player.getPosition())
                    if(WormholeYB.getInstance().getSG(Type.YELLOW) != null)
                        player.setPosition(WormholeYB.getInstance().getSG(Type.YELLOW).getEntry());
                break;
            case YELLOW:
                if(entry == player.getPosition())
                    if(WormholeYB.getInstance().getSG(Type.BLUE) != null)
                        player.setPosition(WormholeYB.getInstance().getSG(Type.BLUE).getEntry());
                break;
            case RED:
                if(entry == player.getPosition())
                    if(WormholeRG.getInstance().getSG(Type.GREEN) != null)
                        player.setPosition(WormholeRG.getInstance().getSG(Type.GREEN).getEntry());
                break;
            case GREEN:
                if(entry == player.getPosition())
                    if(WormholeRG.getInstance().getSG(Type.RED) != null)
                        player.setPosition(WormholeRG.getInstance().getSG(Type.RED).getEntry());
                break;
        }
    }

    @Override
    public void interact(Replicator replicator)
    {
        switch(type)
        {
            case BLUE:
                if(entry == replicator.getPosition())
                    if(WormholeYB.getInstance().getSG(Type.YELLOW) != null)
                        replicator.setPosition(WormholeYB.getInstance().getSG(Type.YELLOW).getEntry());
                break;
            case YELLOW:
                if(entry == replicator.getPosition())
                    if(WormholeYB.getInstance().getSG(Type.BLUE) != null)
                        replicator.setPosition(WormholeYB.getInstance().getSG(Type.BLUE).getEntry());
                break;
            case RED:
                if(entry == replicator.getPosition())
                    if(WormholeRG.getInstance().getSG(Type.GREEN) != null)
                        replicator.setPosition(WormholeRG.getInstance().getSG(Type.GREEN).getEntry());
                break;
            case GREEN:
                if(entry == replicator.getPosition())
                    if(WormholeRG.getInstance().getSG(Type.RED) != null)
                        replicator.setPosition(WormholeRG.getInstance().getSG(Type.RED).getEntry());
                break;
        }
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
    public void steppedOut(Replicator repliactor)
    {

    }

    @Override
    public void steppedOut(Box box)
    {

    }
}
