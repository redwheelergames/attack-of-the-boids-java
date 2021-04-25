import game_engine.Game;
import game_engine.Component;

class Start implements Component {
    
    public Game game;
    
    public Start(Game game) {
        this.game = game;
    }

    public void update () {
        if (this.game.wasReleased.getKey("space")) {
            this.game.sceneManager.nextScene = new MainScene();
        }
    }
}