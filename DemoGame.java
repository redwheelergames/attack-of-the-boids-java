import java.util.Random;
import java.util.ArrayList;
import game_engine.*;

class DemoGame {
    public static void main(String[] args) {
        
        int screenHeight = 720;
        int screenWidth = 1280;

        Game game = new Game(screenWidth, screenHeight);
        Scene mainScene = new Scene();
        
        // Background game object
        GameObject background = new GameObject(game, screenWidth/2, screenHeight/2, 2, 2, 90);
        Sprite backgroundSprite = new Sprite(background, "background.png");
        background.addComponent(backgroundSprite);
        mainScene.addGameObject(background);

        // Instatiate 10 Asteroid game objects
        Random rng = new Random();
        for (int i = 0; i < 10; i++) {
            GameObject asteroid = new Asteroid(game, rng.nextInt(game.windowWidth), 
                                                rng.nextInt(game.windowHeight), 90,
                                                rng.nextInt(100)+50);
            mainScene.addGameObject(asteroid);
        }

        // Character game object
        GameObject character = new GameObject(game, screenWidth/2, screenHeight/2, 2, 2, 90);
        ArrayList<String> framePaths = new ArrayList<String> ();
        framePaths.add("player_idle_1.png");
        framePaths.add("player_idle_2.png");
        framePaths.add("player_idle_3.png");
        framePaths.add("player_idle_4.png");
        Animation characterSprite = new Animation(character, framePaths, 15, true);
        PlayerController playerController = new PlayerController(character, 100);
        PlayerCollider playerCollider = new PlayerCollider(character, 8);
        character.addComponent(characterSprite);
        character.addComponent(playerController);
        character.addComponent(playerCollider);
        mainScene.addGameObject(character);

        game.setScene(mainScene);
        // Start the game
        game.run();
    }
}