import java.lang.Math;
import game_engine.*;

class MoveForward implements Component {

    public GameObject parent;
    public float speed;

    public MoveForward(GameObject parent, float speed) {
        this.parent = parent;
        this.speed = speed;
    }

    public void update() { 
        double deltaTime = this.parent.game.deltaTime;
        Vector2D forward = this.parent.getForwardVector();
        Vector2D delta = forward.scale(this.speed * deltaTime);
        this.parent.position = this.parent.position.add(delta);      
    }
}