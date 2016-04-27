import java.util.ArrayList;

public class Scale implements Element
{
    private Door door;
    private int limit;
    private int current_w;
    private ArrayList<Weight> weights;

    public Scale(Door door)
    {
        this.door = door;
    }

    @Override
    public void interact(Movable movable) {}

    @Override
    public void interact(Player player)
    {
        Logger.enter(this.getClass(), "interact()", player.getClass());

        // ha van doboz a merlegen (nyitva az ajto), akkor az ezredes nem tud ralepni
        if (!door.isOpened()) {
            door.open();
            player.setPosition(player.getPosition().getNeighbour(player.getDirection()));
        }

        Logger.exit(this.getClass(), "interact()", player.getClass());
    }

    @Override
    public void interact(Bullet bullet)
    {
        Logger.enter(this.getClass(), "interact()", bullet.getClass());

        bullet.destroy();

        Logger.exit(this.getClass(), "interact()", bullet.getClass());
    }

    @Override
    public void interact(Box box)
    {
        Logger.enter(this.getClass(), "interact()", box.getClass());

        door.open();

        Logger.exit(this.getClass(), "interact()", box.getClass());
    }

    @Override
    public void pickedUp(Player player)
    {
        Logger.enter(this.getClass(), "pickedUp()", player.getClass());

        Logger.exit(this.getClass(), "pickedUp()", player.getClass());
    }

    @Override
    public void steppedOut(Player player)
    {
        Logger.enter(this.getClass(), "steppedOut()", player.getClass());

        door.close();

        Logger.exit(this.getClass(), "steppedOut()", player.getClass());
    }

    @Override
    public void steppedOut(Box box)
    {
        Logger.enter(this.getClass(), "steppedOut()", box.getClass());

        door.close();

        Logger.exit(this.getClass(), "steppedOut()", box.getClass());
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public Door getDoor() {
        return door;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCurrent_w() {
        return current_w;
    }

    public void addCurrentw(int s){
        this.current_w += s;
    }
}
