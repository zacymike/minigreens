public abstract class Player extends Weight implements Movable
{
    private Floor position;
    private Direction direction;
    private int numofZPM;
    private Box box;
    private boolean alive;
    private Bullet bullet;

    public Player()
    {
        numofZPM = 0;
        box = null;
        direction = Direction.NORTH;
        position = null;
        alive = true;
        weight = 0;
        bullet = null;

        addObserver(Renderer.getInstance());
    }

    public void die()
    {
        alive = false;
        position = null;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public Box getBox()
    {
        return box;
    }

    public void addZPM() {
        numofZPM++;
        if (( numofZPM % 4 ) == 0 ) autoZPM();
    }

    @Override
    public void step() {
        Floor neighbour = position.getNeighbour(direction);
        if (position.getElement() != null) position.getElement().steppedOut(this);
        if(neighbour != null) {
            neighbour.enter(this);
        }
        setChanged();
        notifyObservers("step");
    }

    @Override
    public void setPosition(Floor floor)
    {
        position = floor;
        notifyObservers();
    }

    public void pickUp() {
        Element element = position.getNeighbour(direction).getElement();
        if ( element != null ) {
            element.pickedUp(this);
        }
    }

    public void putDown() {
        // ha nincs nala semmi, nem csinal semmit
        if (box != null) {
            Element e = position.getNeighbour(direction).getElement();
            if (e != null) {
                e.interact(box);
            } else {
                position.getNeighbour(direction).setElement(box);
            }
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir)
    {
        direction = dir;
    }

    @Override
    public Floor getPosition() {
        return position;
    }

    public void shoot(Type type) {
        AudioSFX.playSound("shoot", false);
        Bullet bullet = new Bullet(position, direction, type);
        bullet.step();
    }

    // ez azert kell, hogy ha palyaleirobol le lehessen tarolni
    public void addBullet(Bullet bullet) { this.bullet = bullet; }

    public Bullet getBullet()
    {
        return bullet;
    }

    public void setBullet(Bullet bullet)
    {
        this.bullet = bullet;
    }

    public int getNumofZPM()
    {
        return numofZPM;
    }

    abstract void autoZPM();
}
