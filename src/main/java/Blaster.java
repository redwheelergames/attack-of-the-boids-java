import game_engine.*;

class Blaster extends GameObject {

    public Blaster (Game game, Scene scene) {
        super(game, scene, false, 0, 0, 2, 2, 90);
        Sprite blasterSprite = new Sprite(this, "projectile.png");
        MoveForward moveForward = new MoveForward(this, 750);
        Collider blasterCollider = new BlasterCollider(this, 4);
        this.addComponent(blasterSprite);
        this.addComponent(moveForward);
        this.addComponent(blasterCollider);
    }
}