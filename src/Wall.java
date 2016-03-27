
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
        {

        }
        else
        {
            bullet.destroy();
        }
    }
}
