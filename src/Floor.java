import java.util.Map;

public class Floor
{
    private Map<Direction, Floor> neighbours;
    private Element element;

    public Floor()
    {
        element = null;
    }

    public Floor getNeighbour(Direction direction)
    {
        Logger.enter(this.getClass(), "getNeighbour()", direction.getClass());
        Logger.exit(this.getClass(), "getNeighbour()", direction.getClass());

        return neighbours.get(direction);
    }

    public Element getElement()
    {
        Logger.enter(this.getClass(), "getElement()", null);
        Logger.exit(this.getClass(), "getElement()", null);

        return element;
    }

    public void enter(Movable movable)
    {
        Logger.enter(this.getClass(), "enter()", movable.getClass());

        if(element == null) {
            movable.setPosition(this);
        } else {
            element.interact(movable);
        }

        Logger.exit(this.getClass(), "enter()", movable.getClass());
    }

    public void exit(Movable movable)
    {
        Logger.enter(this.getClass(), "exit()", movable.getClass());

        Logger.exit(this.getClass(), "exit()", movable.getClass());
    }
}