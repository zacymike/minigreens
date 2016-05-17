/**
 * Created by Judit on 2016. 04. 23..
 */
public class WormholeRG extends Wormhole{
    private static WormholeRG instance = new WormholeRG();

    private WormholeRG()
    {
        super();
        setSG(Type.RED, null);
        setSG(Type.GREEN, null);
    }

    public static WormholeRG getInstance()
    {
        if (instance == null) instance = new WormholeRG();
        return instance;
    }
}

