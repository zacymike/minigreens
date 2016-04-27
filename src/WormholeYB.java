/**
 * Created by Judit on 2016. 04. 23..
 */
public class WormholeYB {
    private static WormholeYB instance = new WormholeYB();

   // private WormholeRG() { super();}

    public static WormholeYB getInstance()
    {
        Logger.enter(WormholeYB.class, "getInstance()", null);
        Logger.exit(WormholeYB.class, "getInstance()", null);

        return instance;
    }
}
