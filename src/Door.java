
public class Door implements Element {
    private boolean state;

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public void interact(Movable movable) {

    }

    @Override
    public void interact(Player player) {

    }

    @Override
    public void interact(Box box) {

    }

    @Override
    public void pickedUp() {

    }

    @Override
    public void SteppedOut(Player player) {

    }

    @Override
    public void SteppedOut(Box box) {

    }
}
