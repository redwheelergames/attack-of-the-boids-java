import game_engine.*;
import java.io.File;
import java.util.ArrayList;

class Boid extends GameObject {

    public Boid (Game game, Scene scene, double x, double y) {
        super(game, scene, true, x, y, 2, 2, 90);
        Sprite boidSprite = new Sprite(this, "alpha_boid_sprite.png");
        BoidBehavior followPlayer = new FollowPlayer(this, 25);
        this.addComponent(followPlayer);
        BoidBehavior avoidance = new Avoidance(this, 1, 25);
        this.addComponent(avoidance);
        BoidController boidController = new BoidController(this, 100, 5);
        Collider collider = new BoidCollider(this, 5);
        this.addComponent(collider);
        this.addComponent(boidSprite);
        this.addComponent(boidController);
    }
}