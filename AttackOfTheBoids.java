import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import game_engine.*;

class AttackOfTheBoids {

    public static void main(String[] args) {
        Game game = new Game(1280, 720);
        Scene titleScene = new TitleScene();
        Scene mainScene = new MainScene();
        Scene mainScene2 = new MainScene();
        titleScene.addTransition("start", mainScene);
        mainScene.addTransition("restart", mainScene2);
        mainScene2.addTransition("restart", mainScene);
        game.setScene(titleScene);
        // Start the game
        game.run();
    }
}