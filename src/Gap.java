
public class Gap implements Element {
    @Override
    public void interact(Movable movable) {

    }

    @Override
    public void interact(Player player) {
        Logger.enter(this.getClass(), "interact()", player.getClass());

        player.die();

        Logger.exit(this.getClass(), "interact()", player.getClass());
    }

    @Override
    public void interact(Bullet bullet) {
        Logger.enter(this.getClass(), "interact()", bullet.getClass());

        Logger.exit(this.getClass(), "interact()", bullet.getClass());
    }

    public void interact(Box box) {
        Logger.enter(this.getClass(), "interact()", box.getClass());

        box.destroy();

        Logger.exit(this.getClass(), "interact()", box.getClass());
    }
}
