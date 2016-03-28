
public class Door implements Element {
    private boolean opened;

    Door() { opened = false; }

    public void setState(boolean state) {
        this.opened = state;
    }

    @Override
    public void interact(Movable movable) {

    }

    @Override
    public void interact(Player player) {
        Direction dir = player.getDirection();
        Floor pos = player.getPosition();
        Floor newPos = pos.getNeighbour(dir);
        player.setPosition(newPos);
    }

    @Override
    public void interact(Bullet bullet) {

    }
}
