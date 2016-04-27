
public class SGRed extends SG
{
    private static SGRed instance = new SGRed();

    private SGRed() { super(); }

    public static SGRed getInstance()
    {
        Logger.enter(SGRed.class, "getInstance()", null);
        Logger.exit(SGRed.class, "getInstance()", null);

        return instance;
    }

    @Override
    public void interact(Movable movable) {}

    @Override
    public void interact(Player player)
    {
        Logger.enter(this.getClass(), "interact()", player.getClass());

        Floor end = SGYellow.getInstance().getEntry();
        if(end != null) {
            player.setPosition(end);
        }

        Logger.exit(this.getClass(), "interact()", player.getClass());
    }

    @Override
    public void interact(Bullet bullet)
    {
        Logger.enter(this.getClass(), "interact()", bullet.getClass());

        Logger.exit(this.getClass(), "interact()", bullet.getClass());
    }

    @Override
    public void interact(Box box)
    {
        Logger.enter(this.getClass(), "interact()", box.getClass());

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

        Logger.exit(this.getClass(), "steppedOut()", player.getClass());
    }

    @Override
    public void steppedOut(Box box)
    {
        Logger.enter(this.getClass(), "steppedOut()", box.getClass());

        Logger.exit(this.getClass(), "steppedOut()", box.getClass());
    }
}
