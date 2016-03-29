
public class Wall implements Element
{
    private boolean isspecial;
    private SG sg;

    public Wall(boolean special)
    {
        isspecial = special;
        sg = null;
    }

    public void setSG(SG sg)
    {
        if(isspecial)
            this.sg = sg;
    }

    @Override
    public void interact(Movable movable)
    {

    }

    @Override
    public void interact(Player player)
    {
        Logger.enter(this.getClass(), "interact()", player.getClass());

        if(isspecial && sg != null)
        {
            sg.interact(player);
        }

        Logger.exit(this.getClass(), "interact()", player.getClass());
    }

    @Override
    public void interact(Bullet bullet)
    {
        Logger.enter(this.getClass(), "interact()", bullet.getClass());

        if(isspecial) {
            createSG(bullet);
        }
        else {
            bullet.destroy();
        }

        Logger.exit(this.getClass(), "interact()", bullet.getClass());
    }

    private void createSG(Bullet bullet)
    {
        Floor bulletpos = bullet.getPosition();
        SGYellow yellowsg = SGYellow.getInstance();

        // Ha ezen a falon van SG akkor azt kitöröljük
        if(sg != null)
        {
            sg.setEntry(null);
        }

        switch (bullet.getType())
        {
            case BLUE:
                // Ha van más falon már kék SG akkor azt ki töröljük onnan
                if (SGBlue.getInstance().getEntry() != null)
                {
                    SGBlue.getInstance().getWall().setSG(null);
                }

                // Létrehozunk ezen a falon egy kék SGt
                sg = SGBlue.getInstance();
                sg.setEntry(bulletpos);
                sg.setWall(this);

                break;
            case YELLOW:
                // Ha van más falon már sárga SG akkor azt ki töröljük onnan
                if (SGYellow.getInstance().getEntry() != null)
                {
                    SGBlue.getInstance().getWall().setSG(null);
                }

                // Létrehozunk ezen a falon egy kék SGt
                sg = SGYellow.getInstance();
                sg.setEntry(bulletpos);
                sg.setWall(this);
                break;
        }
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
