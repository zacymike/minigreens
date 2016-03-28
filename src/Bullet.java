
public class Bullet implements Movable
{
    private Floor position;
    private Direction direction;
    private Type type;
    private boolean alive;

    public Bullet(Floor pos, Direction dir, Type t)
    {
        position = pos;
        direction = dir;
        type = t;
    }

    @Override
    public void step()
    {
        Floor neighbour = position.getNeighbour(direction);
        if(neighbour != null)
        {
            neighbour.enter(this);
            if (alive)
                step();
        }
        else
        {
            destroy();
        }
    }

    @Override
    public void setPosition(Floor floor)
    {
        position = floor;
    }

    public Floor getPosition() { return position; }

    public Direction getDirection() { return direction; }

    public Type getType() { return type; }

    public void setType(Type type) { this.type = type; }

    public void destroy()
    {
        alive = false;
    }

}
