import game_engine.GameObject;
import game_engine.Script;
import game_engine.Vector2D;
import game_engine.Collider;

class Boundary extends Script {

    public Collider collider;
    public int boundaryUpper;
    public int boundaryLower;
    public int boundaryRight;
    public int boundaryLeft;

    public Boundary (GameObject parent, Collider collider,  int boundaryLower, int boundaryUpper, int boundaryLeft, int boundaryRight) {
        super(parent);
        this.collider = collider;
        this.boundaryUpper = boundaryUpper;
        this.boundaryLower = boundaryLower;
        this.boundaryLeft = boundaryLeft;
        this.boundaryRight = boundaryRight;
    }

    @Override
    public void update () {
        int radius = collider.radius;
        Vector2D position = this.gameObject.transform.position;
        if (position.y + radius > boundaryUpper) {
            position.y = boundaryUpper - radius;
        }
        else if (position.y - radius < boundaryLower) {
            position.y = boundaryLower + radius;
        }

        if (position.x + radius > boundaryRight) {
            position.x = boundaryRight - radius;
        }
        else if (position.x - radius < boundaryLeft) {
            position.x = boundaryLeft + radius;
        }
    }

}