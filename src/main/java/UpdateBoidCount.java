import game_engine.Script;
import game_engine.GameObject;
import game_engine.Text;

class UpdateBoidCount extends Script {

    public Text boidCountText;
    public GameObject winUI;
    public GameObject restartUI;

    public UpdateBoidCount (GameObject parent, Text boidCountText, GameObject winUI, GameObject restartUI) {
        super(parent);
        this.boidCountText = boidCountText;
        this.winUI = winUI;
        this.restartUI = restartUI;
    }

    @Override
    public void update () {
        int boidCount = this.game.sceneManager.getGroup("boid").size();
        this.boidCountText.textValue = "Boids Remaining: " + boidCount;
        if (boidCount <= 0) {
            this.winUI.active = true;
            this.restartUI.active = true;
        }
    }
}