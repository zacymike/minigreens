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

    public Floor getNeighbour(Direction direction) {return neighbours.get(direction);}

    public void setNeighbours(Direction dir, Floor floor) {neighbours.put(dir, floor);}

    public Element getElement() {return element;}

    public void enter(Player player)
    {
        if(element == null) {
            player.setPosition(this);
        } else {
            element.interact(player);
        }
    }

    public void enter(Replicator replicator)
    {
        if(element == null) {
            replicator.setPosition(this);
        } else {
            element.interact(replicator);
        }
    }

    public void enter(Bullet bullet)
    {
        if(element == null) {
            bullet.setPosition(this);
        } else {
            element.interact(bullet);
        }
    }

    public void exit(Movable movable) {}

    public void setElement(Element element) {
        this.element = element;

    }

}