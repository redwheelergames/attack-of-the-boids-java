import game_engine.Vector2D;
import game_engine.GameObject;

public class FollowPlayer extends BoidBehavior {
    
    public double weight;
    private GameObject player;

    public FollowPlayer (GameObject parent, double weight) {
        super(parent);
        this.weight = weight;
    }

    @Override
    public void onSceneLoad() {
        this.player = this.game.sceneManager.getGroup("player").get(0);
    }

    public Vector2D getMove() {
        Vector2D playerPosition = this.player.transform.position;
        Vector2D boidPosition = this.gameObject.transform.position;
        return (playerPosition.subtract(boidPosition).normalized());
    }

    public double getWeight() {
        return this.weight;
    }
}