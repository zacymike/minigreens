/**
 * Created by Judit on 2016. 04. 23..
 */
public class WormholeYB extends Wormhole {
    private static WormholeYB instance = new WormholeYB();

    private WormholeYB()
    {
        super();
        setSG(Type.BLUE, null);
        setSG(Type.YELLOW, null);
    }

    public static WormholeYB getInstance()
    {
        if (instance == null) instance = new WormholeYB();
        return instance;
    }
}
