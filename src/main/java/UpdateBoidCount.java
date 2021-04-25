import game_engine.Component;
import game_engine.GameObject;
import game_engine.Text;

class UpdateBoidCount implements Component {

    public GameObject parent;
    public Text boidCountText;
    public GameObject winUI;
    public GameObject restartUI;

    public UpdateBoidCount (GameObject parent, Text boidCountText, GameObject winUI, GameObject restartUI) {
        this.parent = parent;
        this.boidCountText = boidCountText;
        this.winUI = winUI;
        this.restartUI = restartUI;
    }

    public void update () {
        int boidCount = this.parent.game.sceneManager.getGroup("boid").size();
        this.boidCountText.textValue = "Boids Remaining: " + boidCount;
        if (boidCount <= 0) {
            this.winUI.active = true;
            this.restartUI.active = true;
        }
    }
}