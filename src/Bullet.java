
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
        Logger.enter(this.getClass(), "step()", null);

        Floor neighbour = position.getNeighbour(direction);
        if(neighbour != null) {
            neighbour.enter(this);
            if (alive) {
                step();
            }
        } else {
            destroy();
        }

        Logger.exit(this.getClass(), "step()", null);
    }

    @Override
    public void setPosition(Floor floor)
    {
        Logger.enter(this.getClass(), "setPosition()", floor.getClass());

        position = floor;

        Logger.exit(this.getClass(), "setPosition()", floor.getClass());
    }

    public Floor getPosition() {
        Logger.enter(this.getClass(), "getPosition()", null);
        Logger.exit(this.getClass(), "getPosition()", null);

        return position;
    }

    public Direction getDirection() {
        Logger.enter(this.getClass(), "getDirection()", null);
        Logger.exit(this.getClass(), "getDirection()", null);

        return direction;
    }

    public Type getType() {
        Logger.enter(this.getClass(), "getType()", null);
        Logger.exit(this.getClass(), "getType()", null);

        return type;
    }

    public void setType(Type type) {
        Logger.enter(this.getClass(), "setType()", type.getClass());

        this.type = type;

        Logger.exit(this.getClass(), "setType()", type.getClass());
    }

    public void destroy() {
        Logger.enter(this.getClass(), "destroy()", null);

        alive = false;

        Logger.exit(this.getClass(), "destroy()", null);
    }

}
