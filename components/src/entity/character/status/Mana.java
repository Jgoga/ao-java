package entity.character.status;

import com.artemis.Component;

import java.io.Serializable;

public class Mana extends Component implements Serializable {

    public int min;
    public int max;

    public Mana() {
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
