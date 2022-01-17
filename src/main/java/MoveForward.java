import game_engine.*;

class MoveForward extends Script {

    public float speed;

    public MoveForward(GameObject parent, float speed) {
        super(parent);
        this.speed = speed;
    }

    @Override
    public void update() { 
        double deltaTime = this.game.deltaTime;
        Vector2D forward = this.gameObject.transform.getForwardVector();
        Vector2D delta = forward.scale(this.speed * deltaTime);
        this.gameObject.transform.position = this.gameObject.transform.position.add(delta);      
    }
}