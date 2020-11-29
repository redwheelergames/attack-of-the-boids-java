import game_engine.Vector2D;
import game_engine.GameObject;

public class FollowPlayer extends BoidBehavior {
    
    public double weight;
    public GameObject parent;
    private GameObject player;

    public FollowPlayer (GameObject parent, double weight) {
        this.parent = parent;
        this.weight = weight;
        this.player = this.parent.scene.getGroup("player").get(0);
    }

    public Vector2D getMove() {
        Vector2D playerPosition = this.player.position;
        Vector2D boidPosition = this.parent.position;
        return (playerPosition.subtract(boidPosition).normalized());
    }

    public double getWeight() {
        return this.weight;
    }
}