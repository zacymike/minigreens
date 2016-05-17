import java.util.HashMap;
import java.util.Map;

/**
 * Created by Judit on 2016. 04. 23..
 */
public abstract class Wormhole{
    private Map<Type, SG> sgs; /* a két csillagkapu tárolása */

    public Wormhole()
    {
        sgs = new HashMap<Type, SG>();
    }

    /* a paraméterként megadott típusú SG-t adja vissza */
    public SG getSG(Type type)
    {
        return sgs.get(type);
    }

    /* a paraméter páros szerint eltárol egy csillagkaput */
    public void setSG(Type type, SG sg)
    {
        if(sgs.get(type) == null)
            sgs.put(type, sg);
        else
            sgs.replace(type, sg);

    }
}
