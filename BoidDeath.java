import game_engine.*;
import java.util.ArrayList;
import java.util.Random;

class BoidDeath implements Component {

    public GameObject parent;
    public GameObject deathObject;

    public BoidDeath (GameObject parent) {
        this.parent = parent;
        Random rng = new Random();
        this.deathObject = new GameObject (parent.game, parent.scene, false, 0, 0, 3, 3, rng.nextInt(360));
        ArrayList<String> framePaths = new ArrayList<String> ();
        framePaths.add("boid_death_1.png");
        framePaths.add("boid_death_2.png");
        framePaths.add("boid_death_3.png");
        framePaths.add("boid_death_4.png");
        framePaths.add("boid_death_5.png");
        framePaths.add("boid_death_6.png");
        framePaths.add("boid_death_7.png");
        Animation deathAnimation = new Animation(this.deathObject, framePaths, 5, false);
        this.deathObject.addComponent(deathAnimation);
        this.parent.scene.addGameObject(this.deathObject);
    }

    public void kill () {
        this.parent.active = false;
        this.deathObject.position = this.parent.position;
        this.deathObject.active = true;
    }
    
    public void update () {}
}