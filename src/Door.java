
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

    }

    @Override
    public void interact(Bullet bullet) {

    }
}
