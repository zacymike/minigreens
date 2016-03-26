package minigreens;

public class Player implements Movable
{
    private Floor position;
    private Direction direction;
    private int numofZPM;
    private Element element;

    public Player(){}
    public void die(){}
    public void step(){}
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
}
