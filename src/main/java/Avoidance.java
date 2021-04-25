import game_engine.Vector2D;
import game_engine.GameObject;
import java.util.ArrayList;

public class Avoidance extends BoidBehavior {

    public double weight;
    public double avoidanceRadius;
    public GameObject parent;
    
    public Avoidance (GameObject parent, double weight, double radius) {
        this.avoidanceRadius = radius;
        this.parent = parent;
        this.weight = weight;
    }

    public Vector2D getMove() {
        Vector2D boidPosition = this.parent.position;
        ArrayList<GameObject> boids = this.parent.game.sceneManager.getGroup("boid");
        Vector2D move = new Vector2D (0, 0);
        for (GameObject boid: boids) {
            Vector2D neighborPosition = boid.position;
            Vector2D distance = this.parent.position.subtract(neighborPosition);
            if (distance.magnitude() < this.avoidanceRadius) {
                move = move.add(distance);
            }
        }
        return move;
    }

    public double getWeight() {
        return this.weight;
    }
}