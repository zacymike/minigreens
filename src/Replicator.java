import java.util.Observable;

/**
 * Created by Judit on 2016. 04. 23..
 */
public class Replicator extends Observable implements Movable {
    private Floor position;
    private Direction direction;
    private boolean isauto;

    private static Replicator replicator;

    Replicator() {
        addObserver(Renderer.getInstance());
    }

    public static Replicator getInstance() {
        if (replicator == null) replicator = new Replicator();
        return replicator;
    }

    @Override
    public void step() {
        Floor neighbour = position.getNeighbour(direction);
        if (position.getElement() != null) position.getElement().steppedOut(this);
        if(neighbour != null) {
            neighbour.enter(this);
        }
        setChanged();
        notifyObservers("step");
    }

    @Override
    public void setPosition(Floor position) {
        this.position = position;
        notifyObservers();
    }

    @Override
    public Floor getPosition() {
        return position;
    }

    public void die()
    {
        position = null;
        setChanged();
        notifyObservers();
    }

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
