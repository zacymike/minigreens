import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Floor
{
    private Map<Direction, Floor> neighbours;
    private Element element;

    public Floor()
    {
        element = null;
        neighbours = new HashMap<Direction, Floor>();
    }

    public Floor getNeighbour(Direction direction)
    {
        Logger.enter(this.getClass(), "getNeighbour()", direction.getClass());
        Logger.exit(this.getClass(), "getNeighbour()", direction.getClass());

        return neighbours.get(direction);
    }

    public void setNeighbours(Direction dir, Floor floor)
    {
        Logger.enter(this.getClass(), "setNeighbour()", floor.getClass());

        neighbours.put(dir, floor);

        Logger.exit(this.getClass(), "setNeighbour()", floor.getClass());
    }

    public Element getElement()
    {
        Logger.enter(this.getClass(), "getElement()", null);
        Logger.exit(this.getClass(), "getElement()", null);

        return element;
    }

    public void enter(Player player)
    {
        Logger.enter(this.getClass(), "enter()", player.getClass());

        if(element == null) {
            player.setPosition(this);
        } else {
            element.interact(player);
        }

        Logger.exit(this.getClass(), "enter()", player.getClass());
    }

    public void enter(Bullet bullet)
    {
        Logger.enter(this.getClass(), "enter()", bullet.getClass());

        if(element == null) {
            bullet.setPosition(this);
        } else {
            element.interact(bullet);
        }

        Logger.exit(this.getClass(), "enter()", bullet.getClass());
    }

    public void exit(Movable movable)
    {
        Logger.enter(this.getClass(), "exit()", movable.getClass());

        Logger.exit(this.getClass(), "exit()", movable.getClass());
    }

    public void setElement(Element element) {
        Logger.enter(this.getClass(), "setElement()", (element != null) ? element.getClass() : null);

        this.element = element;

        Logger.exit(this.getClass(), "setElement()", (element != null) ? element.getClass() : null);
    }

}