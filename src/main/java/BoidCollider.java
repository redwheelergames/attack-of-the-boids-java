import game_engine.*;
import java.util.ArrayList;

class BoidCollider extends Collider {

    BoidDeath death;

    public BoidCollider (GameObject parent, int radius, BoidDeath death) {
        super(parent, radius);
        ArrayList<String> groupNames = new ArrayList<String> ();
        groupNames.add("player");
        groupNames.add("environment");
        groupNames.add("blaster");
        this.groups = groupNames;
        this.death = death;
    }

    public void onCollide(Collider collider, String group) {
        if (group == "environment") {
            Vector2D thisPosition = this.parent.position;
            Vector2D colliderPosition = collider.parent.position;

            Vector2D distanceVector = thisPosition.subtract(colliderPosition);
            double distance = distanceVector.magnitude();
            double newDistance = this.radius + collider.radius;

            double scaleFactor = (newDistance - distance)/distance; // determine how much the difference vector needs to be scaled by
            Vector2D translate = distanceVector.scale(scaleFactor);
            this.parent.position = this.parent.position.add(translate);
        }
        else if (group == "player" || group == "blaster") {
            this.death.kill();
            if (group == "player") {
                // Deal one damage to the player
                collider.parent.getComponents(Health.class).get(0).damage(1);
            }
        }
    }
}