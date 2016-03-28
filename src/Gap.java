
public class Gap implements Element {
    @Override
    public void interact(Movable movable) {

    }

    @Override
    public void interact(Player player) {
        player.die();
    }

    @Override
    public void interact(Bullet bullet)
    {
        Floor gappos = bullet.getPosition().getNeighbour(bullet.getDirection());
        bullet.setPosition(gappos);
    }

    public void interact(Box box) {
        box.destroy();
    }

    @Override
    public void pickedUp()
    {

    }

    @Override
    public void steppedOut(Player player)
    {

    }

    @Override
    public void steppedOut(Box box)
    {

    }
}
