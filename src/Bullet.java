
public class Bullet implements Movable
{
    private Floor position;
    private Direction direction;
    private Type type;
    private boolean alive;

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

    public void destroy()
    {
        alive = false;
    }

}
