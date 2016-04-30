import java.util.Observable;

/**
 * Created by Judit on 2016. 04. 23..
 */
public class Weight extends Observable {
    protected int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) { this.weight = weight; }
}
