

public class Player implements Movable
{
    private Floor position;
    private Direction direction;
    private int numofZPM;
    private Box box;
    private boolean alive;

    public Player()
    {
        numofZPM = 0;
        box = null;
        direction = Direction.NORTH;
        position = null;
        alive = true;
    }

    public void die()
    {
        Logger.enter(this.getClass(), "die()", null);
        alive = false;
        Logger.exit(this.getClass(), "die()", null);
    }

    public void setBox(Box box) {
        Logger.enter(this.getClass(), "setBox()", box.getClass());

        this.box = box;

        Logger.exit(this.getClass(), "setBox()", box.getClass());
    }

    public void addZPM() {
        Logger.enter(this.getClass(), "addZPM()", null);

        numofZPM++;

        Logger.exit(this.getClass(), "addZPM()", null);
    }

    @Override
    public void step() {
        Logger.enter(this.getClass(), "step()", null);

        Floor neighbour = position.getNeighbour(direction);
        if(neighbour != null) {
            neighbour.enter(this);
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

    public void turn(TurnDirection dir)
    {
        Logger.enter(this.getClass(), "turn()", dir.getClass());

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

        Logger.exit(this.getClass(), "turn()", dir.getClass());
    }

    public void pickUp() {
        Logger.enter(this.getClass(), "pickUp()", null);

        Element element = position.getNeighbour(direction).getElement();
        if ( element != null ) {
            element.pickedUp(this);
        }

        Logger.exit(this.getClass(), "pickUp()", null);
    }

    public void putDown() {
        Logger.enter(this.getClass(), "putDown()", null);

        // ha nincs nala semmi, nem csinal semmit
        if (box != null) {
            Element e = position.getNeighbour(direction).getElement();
            if (e != null) {
                e.interact(box);
            } else {
                position.getNeighbour(direction).setElement(box);
            }
        }

        Logger.exit(this.getClass(), "putDown()", null);
    }

    public Direction getDirection() {
        Logger.enter(this.getClass(), "getDirection()", null);
        Logger.exit(this.getClass(), "getDirection()", null);

        return direction;
    }

    @Override
    public Floor getPosition() {
        Logger.enter(this.getClass(), "getPosition()", null);
        Logger.exit(this.getClass(), "getPosition()", null);

        return position;
    }

    public void shoot(Type type) {
        Logger.enter(this.getClass(), "shoot()", type.getClass());

        Bullet bullet = new Bullet(position, direction, type);
        bullet.step();

        Logger.exit(this.getClass(), "shoot()", type.getClass());
    }
}
