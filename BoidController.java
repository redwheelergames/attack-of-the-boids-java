import game_engine.Component;
import game_engine.GameObject;
import game_engine.Vector2D;
import java.util.ArrayList;
import java.lang.Math;

public class BoidController implements Component {

    private ArrayList<BoidBehavior> behaviors;
    public float speed;
    public int maxRotation;
    public GameObject parent;

    public BoidController (GameObject parent, float speed, int maxRotation) { 
        this.speed = speed;
        this.maxRotation = maxRotation;
        this.parent = parent;
        this.behaviors = parent.getComponents(BoidBehavior.class);
    }

    public void update () {
        Vector2D move = new Vector2D(0, 0);
        double deltaTime = this.parent.game.deltaTime;
        for (BoidBehavior behavior: this.behaviors) {
            move = move.add(behavior.getMove().scale(behavior.getWeight()));
        }
        int angle = (int)this.parent.getForwardVector().angleSigned(move); // Signed angle between current forward vector and move
        this.parent.rotation += Math.min(angle, this.maxRotation*deltaTime);
        Vector2D delta = this.parent.getForwardVector().scale(this.speed * deltaTime);
        this.parent.position = this.parent.position.add(delta);
    }
}