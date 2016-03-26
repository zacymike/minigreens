
public abstract class SG implements Element
{
    private Floor neighbour;

    public void setNeighbour(Floor floor)
    {
        neighbour = floor;
    }

    public Floor getNeighbour()
    {
        return neighbour;
    }
  
}
