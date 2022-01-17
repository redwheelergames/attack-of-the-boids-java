import game_engine.GameObject;
import game_engine.Script;

class Restart extends Script {
    
    public GameObject parent;
    
    public Restart(GameObject parent) {
        super(parent);
    }

    @Override
    public void update () {
        if (this.game.wasReleased.getKey("space")) {
            this.game.sceneManager.nextScene = new MainScene();
        }
    }
}