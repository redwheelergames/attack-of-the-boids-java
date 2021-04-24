import java.lang.Math;
import game_engine.*;

class PlayerController implements Component {

    public GameObject parent;
    public float speed;
    private GameObject ammo;

    public PlayerController(GameObject parent, float speed) {
        this.parent = parent;
        this.speed = speed;
        this.ammo = new Blaster(this.parent.game, this.parent.scene);
        this.parent.scene.addGameObject(this.ammo);
    }

    public void update() { 
        double deltaTime = this.parent.game.deltaTime;
        if (this.parent.game.wasPressed.getKey("a")) {
            this.parent.rotation +=  (int)Math.rint(360 * deltaTime);
        }
        if (this.parent.game.wasPressed.getKey("d")) {
            this.parent.rotation -= (int)Math.rint(360 * deltaTime);
        }
        if (this.parent.game.wasPressed.getKey("w")) {
            Vector2D up = this.parent.getForwardVector();
            Vector2D delta = up.scale(this.speed * deltaTime);
            this.parent.position = this.parent.position.add(delta);
        }
        if (this.parent.game.wasPressed.getKey("s")) {
            Vector2D down = this.parent.getForwardVector().scale(-1);
            Vector2D delta = down.scale(this.speed*3/4 * deltaTime);
            this.parent.position = this.parent.position.add(delta);
        }        
    }
}