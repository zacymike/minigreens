
public class Gap implements Element {
    @Override
    public void interact(Movable movable) {

    }

    @Override
    public void interact(Player player) {
        player.die();
    }

    @Override
    public void interact(Bullet bullet) {

    }

    public void interact(Box box) {
        box.destroy();
    }
}
