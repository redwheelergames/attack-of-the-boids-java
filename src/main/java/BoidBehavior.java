import game_engine.Component;
import game_engine.Vector2D;

public abstract class BoidBehavior implements Component {
    public abstract Vector2D getMove();
    public abstract double getWeight();
    public void update() {}
}