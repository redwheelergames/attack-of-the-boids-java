import game_engine.Script;
import game_engine.Vector2D;
import game_engine.GameObject;

public abstract class BoidBehavior extends Script {
    BoidBehavior (GameObject parent) {
        super(parent);
    }
    public abstract Vector2D getMove();
    public abstract double getWeight();
}