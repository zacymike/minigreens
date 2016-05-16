import java.util.ArrayList;
import java.util.Stack;

public class Scale implements Element
{
    private Door door;
    private int limit;
    private int current_w;
    private Stack<Box> boxes;

    public Scale(Door door)
    {
        this.door = door;
        boxes = new Stack<>();
    }

    @Override
    public void interact(Movable movable) {}

    @Override
    public void interact(Player player)
    {
        Logger.enter(this.getClass(), "interact()", player.getClass());

        // jatekos ralep, suly hozzaadodik a szamlalohoz, ha van nala doboz, akkor annak is
        player.setPosition(player.getPosition().getNeighbour(player.getDirection()));
        current_w += player.getWeight();
        if (player.getBox() != null) current_w += player.getBox().getWeight();

        // ha a sulykorlatot atlepjuk, az ajto kinyilik
        if(current_w >= limit) door.open();

        Logger.exit(this.getClass(), "interact()", player.getClass());
    }

    @Override
    public void interact(Bullet bullet)
    {
        Logger.enter(this.getClass(), "interact()", bullet.getClass());

        bullet.destroy();

        Logger.exit(this.getClass(), "interact()", bullet.getClass());
    }

    @Override
    public void interact(Box box)
    {
        Logger.enter(this.getClass(), "interact()", box.getClass());

        // doboz hozzaadasa a veremhez, sulyanak hozzaadasa a szamlalohoz
        boxes.push(box);
        current_w += box.getWeight();

        // ha a sulykorlatot atlepjuk, az ajto kinyilik
        if(current_w >= limit) {
            door.open();
        }

        Logger.exit(this.getClass(), "interact()", box.getClass());
    }

    @Override
    public void pickedUp(Player player)
    {
        Logger.enter(this.getClass(), "pickedUp()", player.getClass());

        // ha nincs rajta doboz, nem tortenik semmi
        if (boxes.size() != 0) {
            // ha van, akkor a player felveszi a dobozt, sulyat levonjuk a szamlalobol
            player.setBox(boxes.pop());
            current_w -= player.getBox().getWeight();

            // ha sulykorlat ala csokken a szamlalo, az ajto bezarul (ha nyitva volt)
            if (door.isOpened() && (limit > current_w)) {
                door.close();
            }
        }

        Logger.exit(this.getClass(), "pickedUp()", player.getClass());
    }

    @Override
    public void steppedOut(Player player)
    {
        Logger.enter(this.getClass(), "steppedOut()", player.getClass());

        // player sulyanak levonasa (ha van nala doboz, annak is)
        // ha sulykorlat ala kerulunk, bezarjuk az ajtot (ha nyitva volt)
        current_w -= player.getWeight();
        if (player.getBox() != null) current_w -= player.getBox().getWeight();
        if(door.isOpened() && (limit > current_w)) {
            door.close();
        }

        Logger.exit(this.getClass(), "steppedOut()", player.getClass());
    }

    @Override
    public void steppedOut(Box box)
    {
        Logger.enter(this.getClass(), "steppedOut()", box.getClass());

        Logger.exit(this.getClass(), "steppedOut()", box.getClass());
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public Door getDoor() {
        return door;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCurrent_w() {
        return current_w;
    }
}
