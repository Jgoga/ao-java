package physics;

import com.artemis.Component;

import java.io.Serializable;
import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;

public class AOPhysics extends Component implements Serializable {

    public final static float MAX_VELOCITY = Float.MAX_VALUE;
    public final static float WALKING_VELOCITY = 170.0f;

    public Deque<Movement> intentions = new ConcurrentLinkedDeque<Movement>();

    public AOPhysics() {
    }

    public Optional<Movement> getMovementIntention() {
        return Optional.ofNullable(intentions.isEmpty() ? null : intentions.getLast());
    }

    public void addIntention(Movement movement) {
        intentions.add(movement);
    }

    public void removeIntention(Movement movement) {
        intentions.remove(movement);
    }

    public enum Movement {
        UP,
        DOWN,
        RIGHT,
        LEFT;

        Movement() {
        }
    }

}
