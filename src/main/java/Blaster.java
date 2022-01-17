import game_engine.*;

class Blaster extends GameObject {

    public Blaster (Game game) {
        super(game, false, 0, 0, 2, 2, 90);
        new Sprite(this, "projectile.png");
        new MoveForward(this, 750);
        new BlasterCollider(this, 4);
    }
}