import game_engine.Component;
import game_engine.GameObject;

class Health implements Component {

    public GameObject parent;
    public int health;

    public Health (GameObject parent, int health) {
        this.parent = parent;
        this.health = health;
    }

    // reduce the game object's health by damage and return the new health value
    public int damage (int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.parent.active = false;
        }
        return this.health;
    }

    public void update () {}
}