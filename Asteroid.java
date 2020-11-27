import game_engine.*;

class Asteroid extends GameObject {

    public Asteroid (Game game, double x, double y, int rotation) {
        super(game, true, x, y, 2, 2, rotation);
        Sprite sprite = new Sprite(this, "asteroid_sprite_1.png");
        Collider collider = new Collider(this, sprite.sprite.getWidth());
        this.addComponent(sprite);
        this.addComponent(collider);
    }
}