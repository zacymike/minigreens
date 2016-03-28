
public class ZPM implements Element {
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
    public void interact(Bullet bullet)
    {
        bullet.destroy();
    }

    @Override
    public void pickedUp() {

    }

    @Override
    public void steppedOut(Player player) {

    }

    @Override
    public void steppedOut(Box box) {

    }
}
