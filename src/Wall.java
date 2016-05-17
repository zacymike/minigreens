import java.util.Observable;

public class Wall extends Observable implements Element
{
    private boolean isspecial;
    private SG sg;

    public Wall(boolean special)
    {
        isspecial = special;
        sg = null;
        addObserver(Renderer.getInstance());
    }

    public void setIsspecial(boolean isspecial)
    {
        this.isspecial = isspecial;
    }

    public boolean getIsSpecial()
    {
        return isspecial;
    }

    public void setSG(SG sg)
    {
        if(isspecial) {
            this.sg = sg;
        }
    }

    public SG getSG()
    {
        return sg;
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
    public void interact(Replicator replicator)
    {
        if(isspecial && sg != null)
        {
            sg.interact(replicator);
        }
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
        //Ha már van csillagkapu a falon azt kitörljük a megfelelő féregjáratból
        if(sg != null)
        {
            Type prevtype = sg.getType();
            switch(prevtype)
            {
                case BLUE:
                    WormholeYB.getInstance().setSG(Type.BLUE, null);
                    break;
                case YELLOW:
                    WormholeYB.getInstance().setSG(Type.YELLOW, null);
                    break;
                case RED:
                    WormholeRG.getInstance().setSG(Type.RED, null);
                    break;
                case GREEN:
                    WormholeRG.getInstance().setSG(Type.GREEN, null);
                    break;
            }
        }

        // Új csillagkapu inicializálása
        Type type = bullet.getType();
        sg = new SG(type);
        sg.setEntry(bullet.getPosition());
        sg.setWall(this);

        // Ha van már ilyen típusú csillagkapu a pályán azt letörljük a falról is,
        // és az új csillagkaput beállítjuk a megfelelő féregjárathoz.
        switch(type)
        {
            case BLUE:
                if(WormholeYB.getInstance().getSG(Type.BLUE) != null)
                    WormholeYB.getInstance().getSG(Type.BLUE).getWall().setSG(null);
                WormholeYB.getInstance().setSG(Type.BLUE, sg);
                break;
            case YELLOW:
                if(WormholeYB.getInstance().getSG(Type.YELLOW) != null)
                    WormholeYB.getInstance().getSG(Type.YELLOW).getWall().setSG(null);
                WormholeYB.getInstance().setSG(Type.YELLOW, sg);
                break;
            case RED:
                if(WormholeRG.getInstance().getSG(Type.RED) != null)
                    WormholeRG.getInstance().getSG(Type.RED).getWall().setSG(null);
                WormholeRG.getInstance().setSG(Type.RED, sg);
                break;
            case GREEN:
                if(WormholeRG.getInstance().getSG(Type.GREEN) != null)
                    WormholeRG.getInstance().getSG(Type.GREEN).getWall().setSG(null);
                WormholeRG.getInstance().setSG(Type.GREEN, sg);
                break;
        }

        // A lövedéket megsemmisítjük.
        bullet.destroy();
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
    public void steppedOut(Replicator repliactor)
    {

    }

    @Override
    public void steppedOut(Box box)
    {
        Logger.enter(this.getClass(), "steppedOut()", box.getClass());

        Logger.exit(this.getClass(), "steppedOut()", box.getClass());
    }
}
