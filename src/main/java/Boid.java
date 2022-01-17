import game_engine.*;

class Boid extends GameObject {

    public Boid (Game game, double x, double y) {
        super(game, true, x, y, 2, 2, 90);
        new Sprite(this, "alpha_boid_sprite.png");
        new FollowPlayer(this, 25);
        new Avoidance(this, 1, 25);
        new BoidController(this, 125, 90);
        BoidDeath boidDeath = new BoidDeath(this);
        new BoidCollider(this, 5, boidDeath);
    }
}