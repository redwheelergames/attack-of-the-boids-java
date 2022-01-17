import game_engine.*;

class BlasterCollider extends Collider {

    public BlasterCollider (GameObject parent, int radius) {
        super(parent, radius);
        this.groups.add("boid");
        this.groups.add("environment");
    }

    @Override
    public void onCollide(Collider collider, String group) {
        if (group == "environment") {
            this.gameObject.active = false;
        }
        else if (group == "boid") {
            this.gameObject.active = false;
            collider.gameObject.getComponents(BoidDeath.class).get(0).kill();
        }
    }
}