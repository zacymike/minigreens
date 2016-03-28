
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
    
    public void createSG(){}

    @Override
    public void interact(Movable movable)
    {

    }

    @Override
    public void interact(Player player)
    {
        if(isspecial && sg != null)
        {
            sg.interact(player);
        }
    }

    @Override
    public void interact(Bullet bullet)
    {
        if(isspecial)
            CreateSG(bullet);
        else
            bullet.destroy();
    }

    private void CreateSG(Bullet bullet)
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

                }

                // Létrehozunk ezen a falon egy kék SGt
                sg = SGBlue.getInstance();
                sg.setEntry(bulletpos);

                break;
            case YELLOW:
                // Ha van más falon már sárga SG akkor azt ki töröljük onnan
                if (SGYellow.getInstance().getEntry() != null)
                {

                }

                // Létrehozunk ezen a falon egy kék SGt
                sg = SGYellow.getInstance();
                sg.setEntry(bulletpos);
                break;
        }
    }

    @Override
    public void interact(Box box)
    {

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
