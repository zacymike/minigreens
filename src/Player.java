

public class Player implements Movable
{
    private Floor position;
    private Direction direction;
    private int numofZPM;
    private Element element;

    public Player()
    {
        numofZPM = 0;
        element = null;
    }

    public void die()
    {

    }

    @Override
    public void step()
    {
        Floor neighbour = position.getNeighbour(direction);
        if(neighbour != null)
        {
            neighbour.enter(this);
        }
    }

    @Override
    public void setPosition(Floor floor)
    {
        position = floor;
    }

    public void turn(TurnDirection dir)
    {
        switch(direction)
        {
            case NORTH: if(dir == TurnDirection.LEFT) direction = Direction.WEST; else direction = Direction.EAST;
                break;
            case EAST: if(dir == TurnDirection.LEFT) direction = Direction.NORTH; else direction = Direction.SOUTH;
                break;
            case SOUTH: if(dir == TurnDirection.LEFT) direction = Direction.EAST; else direction = Direction.WEST;
                break;
            case WEST: if(dir == TurnDirection.LEFT) direction = Direction.SOUTH; else direction = Direction.NORTH;
                break;
        }
    }
    public void pickUp(){}
    public void putDown(){}
    public Direction getDirection() { return direction; }

    @Override
    public Floor getPosition() {
        return position;
    }
}
