import game_engine.GameObject;
import game_engine.Component;
import game_engine.Vector2D;
import game_engine.Collider;

class Boundary implements Component {

    public GameObject parent;
    public Collider collider;
    public int boundaryUpper;
    public int boundaryLower;
    public int boundaryRight;
    public int boundaryLeft;

    public Boundary (GameObject parent, Collider collider,  int boundaryLower, int boundaryUpper, int boundaryLeft, int boundaryRight) {
        this.parent = parent;
        this.collider = collider;
        this.boundaryUpper = boundaryUpper;
        this.boundaryLower = boundaryLower;
        this.boundaryLeft = boundaryLeft;
        this.boundaryRight = boundaryRight;
    }

    public void update () {
        int radius = collider.radius;
        Vector2D position = this.parent.position;
        if (position.y + radius > boundaryUpper) {
            this.parent.position.y = boundaryUpper - radius;
        }
        else if (position.y - radius < boundaryLower) {
            this.parent.position.y = boundaryLower + radius;
        }

        if (position.x + radius > boundaryRight) {
            this.parent.position.x = boundaryRight - radius;
        }
        else if (position.x - radius < boundaryLeft) {
            this.parent.position.x = boundaryLeft + radius;
        }
    }

}