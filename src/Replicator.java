/**
 * Created by Judit on 2016. 04. 23..
 */
public class Replicator implements Movable {
    private Floor position;
    private Direction direction;
    private boolean isauto;

    private static Replicator replicator;

    public static Replicator getInstance() {
        if (replicator == null) replicator = new Replicator();
        return replicator;
    }

    @Override
    public void step() { }

    @Override
    public void setPosition(Floor position) {
        this.position = position;
    }

    @Override
    public Floor getPosition() {
        return position;
    }

    public void die(){}

    public Direction getDirection()
    {
        return direction;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    public boolean isauto()
    {
        return isauto;
    }

    public void setIsauto(boolean isauto)
    {
        this.isauto = isauto;
    }
}
