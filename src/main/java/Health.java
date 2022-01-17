import game_engine.Component;
import game_engine.GameObject;

class Health extends Component {

    public int health;

    public Health (GameObject parent, int health) {
        super(parent);
        this.health = health;
    }

    // reduce the game object's health by damage and return the new health value
    public int damage (int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.gameObject.active = false;
        }
        return this.health;
    }
}