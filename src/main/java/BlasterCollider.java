import game_engine.*;

class BlasterCollider extends Collider {

    public BlasterCollider (GameObject parent, int radius) {
        super(parent, radius);
        this.groups.add("boid");
        this.groups.add("environment");
    }

    public void onCollide(Collider collider, String group) {
        if (group == "environment") {
            this.parent.active = false;
        }
        else if (group == "boid") {
            this.parent.active = false;
            collider.parent.getComponents(BoidDeath.class).get(0).kill();
        }
    }
}