import game_engine.Script;
import game_engine.GameObject;
import game_engine.Vector2D;
import game_engine.Transform;
import java.util.ArrayList;
import java.lang.Math;

public class BoidController extends Script {

    private ArrayList<BoidBehavior> behaviors;
    public float speed;
    public int maxRotation;

    public BoidController (GameObject parent, float speed, int maxRotation) { 
        super(parent);
        this.speed = speed;
        this.maxRotation = maxRotation;
    }

    @Override
    public void onSceneLoad() {
        this.behaviors = this.gameObject.getComponents(BoidBehavior.class);
    }

    @Override 
    public void update () {
        Vector2D move = new Vector2D(0, 0);
        double deltaTime = this.game.deltaTime;
        Transform transform = this.gameObject.transform;

        for (BoidBehavior behavior: this.behaviors) {
            move = move.add(behavior.getMove().scale(behavior.getWeight()));
        }
        int angle = (int)transform.getForwardVector().angleSigned(move); // Signed angle between current forward vector and move
        transform.rotation += Math.min(angle, this.maxRotation*deltaTime);
        Vector2D delta = transform.getForwardVector().scale(this.speed * deltaTime);
        transform.position = transform.position.add(delta);
    }
}