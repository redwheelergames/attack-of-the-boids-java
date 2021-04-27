import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import game_engine.*;

public class AttackOfTheBoids {

    public static void main(String[] args) {
        Game game = new Game(1280, 720);
        Scene titleScene = new TitleScene();

        game.sceneManager.nextScene = titleScene;
        // Start the game
        game.run();
    }
}