package entity.character.status;

import com.artemis.Component;

import java.io.Serializable;

public class Hungry extends Component implements Serializable {

    public int min;
    public int max;

    public Hungry() {
    }

}
