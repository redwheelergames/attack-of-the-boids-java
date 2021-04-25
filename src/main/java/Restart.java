import game_engine.GameObject;
import game_engine.Component;

class Restart implements Component {
    
    public GameObject parent;
    
    public Restart(GameObject parent) {
        this.parent = parent;
    }

    public void update () {
        if (this.parent.game.wasReleased.getKey("space")) {
            this.parent.game.sceneManager.nextScene = new MainScene();
        }
    }
}