import game_engine.*;

class PlayerCollider extends Collider {

    public Health playerHealth;

    public PlayerCollider (GameObject parent, int radius) {
        super(parent, radius);
        this.playerHealth = this.gameObject.getComponents(Health.class).get(0);
    }

    @Override
    public void onCollide(Collider collider, String group) {
        if (group == "environment") {
            Vector2D thisPosition = this.gameObject.transform.position;
            Vector2D colliderPosition = collider.gameObject.transform.position;

            Vector2D distanceVector = thisPosition.subtract(colliderPosition);
            double distance = distanceVector.magnitude();
            double newDistance = this.radius + collider.radius;

            double scaleFactor = (newDistance - distance)/distance; // determine how much the difference vector needs to be scaled by
            Vector2D translate = distanceVector.scale(scaleFactor);
            this.gameObject.transform.position = this.gameObject.transform.position.add(translate);
        }
    }
}