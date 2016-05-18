
public class Gap implements Element {
    @Override
    public void interact(Movable movable) {
        System.out.println("fuck"); // wtf? :D

    }

    @Override
    public void interact(Player player) {
        player.die();
    }

    @Override
    public void interact(Replicator replicator) {}

    @Override
    public void interact(Bullet bullet)
    {
        bullet.setPosition(bullet.getPosition().getNeighbour(bullet.getDirection()));
    }

    public void interact(Box box) {
        box.destroy();
    }

    @Override
    public void pickedUp(Player player) {}

    @Override
    public void steppedOut(Player player) {}

    @Override
    public void steppedOut(Replicator repliactor) {}

    @Override
    public void steppedOut(Box box) {}
}
