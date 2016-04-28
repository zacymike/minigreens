/**
 * Created by Judit on 2016. 04. 23..
 */
public class Jaffa extends Player {
    private static Jaffa jaffa;

    public static Jaffa getInstance() {
        if ( jaffa == null ) jaffa = new Jaffa();
        return jaffa;
    }

    public void reset()
    {
        jaffa = null;
    }
}
