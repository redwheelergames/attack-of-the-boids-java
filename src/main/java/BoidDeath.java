import game_engine.*;
import java.util.ArrayList;
import java.util.Random;

class BoidDeath extends Component {

    public GameObject deathObject;

    public BoidDeath (GameObject parent) {
        super(parent);
        Random rng = new Random();
        this.deathObject = new GameObject (parent.game, false, 0, 0, 3, 3, rng.nextInt(360));
        ArrayList<String> framePaths = new ArrayList<String> ();
        framePaths.add("boid_death_1.png");
        framePaths.add("boid_death_2.png");
        framePaths.add("boid_death_3.png");
        framePaths.add("boid_death_4.png");
        framePaths.add("boid_death_5.png");
        framePaths.add("boid_death_6.png");
        framePaths.add("boid_death_7.png");
        new Animation(this.deathObject, framePaths, 5, false);
        this.game.sceneManager.addGameObject(this.deathObject);
    }

    public void kill () {
        this.gameObject.active = false;
        this.deathObject.transform.position = this.gameObject.transform.position;
        this.deathObject.active = true;
    }
}