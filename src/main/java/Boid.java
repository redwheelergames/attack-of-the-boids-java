import game_engine.*;

class Boid extends GameObject {

    public Boid (Game game, Scene scene, double x, double y) {
        super(game, scene, true, x, y, 2, 2, 90);
        Sprite boidSprite = new Sprite(this, "alpha_boid_sprite.png");
        BoidBehavior followPlayer = new FollowPlayer(this, 25);
        this.addComponent(followPlayer);
        BoidBehavior avoidance = new Avoidance(this, 1, 25);
        this.addComponent(avoidance);
        BoidController boidController = new BoidController(this, 125, 90);
        BoidDeath boidDeath = new BoidDeath(this);
        this.addComponent(boidDeath);
        Collider collider = new BoidCollider(this, 5, boidDeath);
        this.addComponent(collider);
        this.addComponent(boidSprite);
        this.addComponent(boidController);
    }
}