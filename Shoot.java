import java.lang.Math;
import java.util.LinkedList;
import game_engine.*;

class Shoot implements Component {

    public GameObject parent;
    public float speed;
    private LinkedList<GameObject> ammo;

    public Shoot(GameObject parent) {
        this.parent = parent;
        this.ammo = new LinkedList<GameObject> ();
        for (int i = 0; i < 10; i++) {
            GameObject blaster = new Blaster(this.parent.game, this.parent.scene);
            ammo.add(blaster);
            this.parent.scene.addGameObject(blaster, "blaster");
        }
    }

    public void update() { 
        if (this.parent.game.wasReleased.getKey("mouse1")) {
            GameObject blaster = this.ammo.pop();
            blaster.rotation = this.parent.rotation;
            blaster.position = this.parent.position;
            blaster.active = true;
            this.ammo.add(blaster);
        }      
    }
}