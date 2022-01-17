import game_engine.Vector2D;
import game_engine.GameObject;
import java.util.ArrayList;

public class Avoidance extends BoidBehavior {

    public double weight;
    public double avoidanceRadius;
    
    public Avoidance (GameObject parent, double weight, double radius) {
        super(parent);
        this.avoidanceRadius = radius;
        this.weight = weight;
    }

    @Override
    public Vector2D getMove() {
        Vector2D boidPosition = this.gameObject.transform.position;
        ArrayList<GameObject> boids = this.game.sceneManager.getGroup("boid");
        Vector2D move = new Vector2D (0, 0);
        for (GameObject boid: boids) {
            Vector2D neighborPosition = boid.transform.position;
            Vector2D distance = boidPosition.subtract(neighborPosition);
            if (distance.magnitude() < this.avoidanceRadius) {
                move = move.add(distance);
            }
        }
        return move;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}