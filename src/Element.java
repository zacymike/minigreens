
public interface Element
{
    public void interact(Movable movable);
    public void interact(Player player);
    public void interact(Bullet bullet);
    public void interact(Box box);
    public void pickedUp(Player player);
    public void steppedOut(Player player);
    public void steppedOut(Box box);

}