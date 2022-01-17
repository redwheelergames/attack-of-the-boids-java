import java.lang.Math;
import game_engine.GameObject;
import game_engine.Script;
import game_engine.Vector2D;

class PlayerController extends Script {

    public float speed;

    public PlayerController(GameObject parent, float speed) {
        super(parent);
        this.speed = speed;
    }

    public void update() { 
        double deltaTime = this.game.deltaTime;
        if (this.game.wasPressed.getKey("a")) {
            this.gameObject.transform.rotation +=  (int)Math.rint(360 * deltaTime);
        }
        if (this.game.wasPressed.getKey("d")) {
            this.gameObject.transform.rotation -= (int)Math.rint(360 * deltaTime);
        }
        if (this.game.wasPressed.getKey("w")) {
            Vector2D up = this.gameObject.transform.getForwardVector();
            Vector2D delta = up.scale(this.speed * deltaTime);
            this.gameObject.transform.position = this.gameObject.transform.position.add(delta);
        }
        if (this.game.wasPressed.getKey("s")) {
            Vector2D down = this.gameObject.transform.getForwardVector().scale(-1);
            Vector2D delta = down.scale(this.speed*3/4 * deltaTime);
            this.gameObject.transform.position = this.gameObject.transform.position.add(delta);
        }        
    }
}