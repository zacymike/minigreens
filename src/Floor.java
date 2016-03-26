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
        return neighbours.get(direction);
    }

    public Element getElement()
    {
        return element;
    }

    public void enter(Movable movable)
    {

    }

    public void exit(Movable movable)
    {

    }
}