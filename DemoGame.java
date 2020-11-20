import java.util.Random;
import java.util.ArrayList;

class DemoGame {
    public static void main(String[] args) {
        
        int screenHeight = 720;
        int screenWidth = 1280;

        Scene scene = new Scene(screenWidth, screenHeight);
        Game game = new Game(screenWidth, screenHeight, scene);

        // Background game object
        GameObject background = new GameObject(screenWidth/2, screenHeight/2, 2, 2, 90);
        Sprite backgroundSprite = new Sprite(scene, background, "background.png");
        background.addComponent(backgroundSprite);
        scene.addGameObject(background);

        // Instatiate 10 Asteroid game objects
        Random rng = new Random();
        for (int i = 0; i < 10; i++) {
            GameObject asteroid = new Asteroid(scene, rng.nextInt(scene.windowWidth), 
                                                rng.nextInt(scene.windowHeight), 90,
                                                rng.nextInt(100)+50);
            scene.addGameObject(asteroid);
        }

        // Character game object
        GameObject character = new GameObject(screenWidth/2, screenHeight/2, 2, 2, 90);
        ArrayList<String> framePaths = new ArrayList<String> ();
        framePaths.add("player_idle_1.png");
        framePaths.add("player_idle_2.png");
        framePaths.add("player_idle_3.png");
        framePaths.add("player_idle_4.png");
        Animation characterSprite = new Animation(scene, character, framePaths, 15, true);
        PlayerController playerController = new PlayerController(scene, character, 100);
        PlayerCollider playerCollider = new PlayerCollider(scene, character, 8);
        character.addComponent(characterSprite);
        character.addComponent(playerController);
        character.addComponent(playerCollider);
        scene.addGameObject(character);

        // Start the game
        game.run();
    }
}