import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import game_engine.*;

class DemoGame {
    public static void main(String[] args) {
        
        int screenHeight = 720;
        int screenWidth = 1280;

        Game game = new Game(screenWidth, screenHeight);
        Scene titleScreen = new Scene();
        Scene mainScene = new Scene();
        titleScreen.addTransition("start", mainScene);

        // Background game object
        GameObject backgroundTitle = new GameObject(game, titleScreen, true, screenWidth/2, screenHeight/2, 2, 2, 90);
        Sprite backgroundTitleSprite = new Sprite(backgroundTitle, "background.png");
        backgroundTitle.addComponent(backgroundTitleSprite);
        titleScreen.addGameObject(backgroundTitle);

        GameObject startObject = new GameObject(game, titleScreen, true, screenWidth/2 - 150, screenHeight/2, 0, 0, 90);
        Text startText = new Text(startObject, "PRESS SPACE TO START", 40, "VT323-Regular.ttf");
        Start start = new Start(game);
        startObject.addComponent(start);
        startObject.addComponent(startText);
        titleScreen.addGameObject(startObject);

        GameObject title = new GameObject(game, titleScreen, true, screenWidth/2, screenHeight-200, 2, 2, 90);
        Sprite titleSprite = new Sprite(title, "title.png");
        title.addComponent(titleSprite);
        titleScreen.addGameObject(title);

        // Background game object
        GameObject background = new GameObject(game, mainScene, true, screenWidth/2, screenHeight/2, 2, 2, 90);
        Sprite backgroundSprite = new Sprite(background, "background.png");
        background.addComponent(backgroundSprite);
        mainScene.addGameObject(background);

        // Instatiate 10 Asteroid game objects
        Random rng = new Random();
        for (int i = 0; i < 25; i++) {
            GameObject asteroid = new Asteroid(game, mainScene, rng.nextInt(game.windowWidth), 
                                                rng.nextInt(game.windowHeight), 
                                                rng.nextInt(360));
            mainScene.addGameObject(asteroid, "environment");
        }

        // Character game object
        GameObject character = new GameObject(game, mainScene, true, screenWidth/2, screenHeight/2, 2, 2, 90);
        ArrayList<String> framePaths = new ArrayList<String> ();
        framePaths.add("player_idle_1.png");
        framePaths.add("player_idle_2.png");
        framePaths.add("player_idle_3.png");
        framePaths.add("player_idle_4.png");
        Animation characterSprite = new Animation(character, framePaths, 15, true);
        PlayerController playerController = new PlayerController(character, 200);
        PlayerCollider playerCollider = new PlayerCollider(character, 12);
        character.addComponent(characterSprite);
        character.addComponent(playerController);
        character.addComponent(playerCollider);
        mainScene.addGameObject(character, "player");

        // Instatiate 10 Boid game objects
        for (int i = 0; i < 1000; i++) {
            GameObject boid = new Boid(game, mainScene, rng.nextInt(game.windowWidth), 
                                                rng.nextInt(game.windowHeight));
            mainScene.addGameObject(boid, "boid");
        }

        // FPS counter object
        GameObject fpsCounter = new GameObject(game, mainScene, true, 15, 20, 1, 1, 90);
        Text text = new Text(fpsCounter, "0", 30, "VT323-Regular.ttf");
        fpsCounter.addComponent(text);
        FPSCounter fps = new FPSCounter(fpsCounter);
        fpsCounter.addComponent(fps);
        mainScene.addGameObject(fpsCounter);
        game.setScene(titleScreen);

        // Start the game
        game.run();
    }
}