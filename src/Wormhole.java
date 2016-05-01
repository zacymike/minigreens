import java.util.Map;

/**
 * Created by Judit on 2016. 04. 23..
 */
public abstract class Wormhole{
    private Map<Type, SG> sgs; /* a két csillagkapu tárolása */

    /* a paraméterként megadott típusú SG-t adja vissza */
   // public SG getSG(Type type){}

    /* a paraméter páros szerint eltárol egy csillagkaput */
    public void setSG(Type type, SG sg){}
}
