import game_engine.Script;
import game_engine.GameObject;

class Start extends Script {
    
    public Start(GameObject parent) {
        super(parent);
    }

    @Override
    public void update () {
        if (this.game.wasReleased.getKey("space")) {
            this.game.sceneManager.nextScene = new MainScene();
        }
    }
}