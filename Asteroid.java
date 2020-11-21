import game_engine.*;

class Asteroid extends GameObject {

    public Asteroid (Game game, double x, double y, int rotation, int speed) {
        super(game, x, y, 2, 2, rotation);
        Sprite sprite = new Sprite(this, "asteroid_sprite_1.png");
        AsteroidController controller = new AsteroidController(this, 3, speed);
        Collider collider = new Collider(this, sprite.sprite.getWidth());
        this.addComponent(sprite);
        this.addComponent(controller);
        this.addComponent(collider);
    }
}