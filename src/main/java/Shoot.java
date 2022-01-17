import java.util.LinkedList;
import game_engine.GameObject;
import game_engine.Script;

class Shoot extends Script {

    public float speed;
    private LinkedList<GameObject> ammo;

    public Shoot(GameObject parent) {
        super(parent);
        this.ammo = new LinkedList<GameObject> ();
        for (int i = 0; i < 10; i++) {
            GameObject blaster = new Blaster(this.game);
            ammo.add(blaster);
            this.game.sceneManager.addGameObject(blaster, "blaster");
        }
    }

    @Override
    public void update() { 
        if (this.game.wasReleased.getKey("mouse1")) {
            GameObject blaster = this.ammo.pop();
            blaster.transform.rotation = this.gameObject.transform.rotation;
            blaster.transform.position = this.gameObject.transform.position;
            blaster.active = true;
            this.ammo.add(blaster);
        }      
    }
}