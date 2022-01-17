import game_engine.*;
import java.util.Random;
import java.util.ArrayList;

class MainScene extends Scene {

    public void load (Game game) {

        // Background game object
        GameObject background = new GameObject(game, true, game.windowWidth/2, game.windowHeight/2, 2, 2, 90);
        new Sprite(background, "background.png");
        game.sceneManager.addGameObject(background);

        // Instatiate 10 Asteroid game objects
        Random rng = new Random();
        for (int i = 0; i < 25; i++) {
            GameObject asteroid = new Asteroid(game, rng.nextInt(game.windowWidth), 
                                                rng.nextInt(game.windowHeight), 
                                                rng.nextInt(360));
            game.sceneManager.addGameObject(asteroid, "environment");
        }

        // Character game object
        GameObject character = new GameObject(game, true, game.windowWidth/2, 30, 2, 2, 90);
        ArrayList<String> framePaths = new ArrayList<String> ();
        framePaths.add("player_idle_1.png");
        framePaths.add("player_idle_2.png");
        framePaths.add("player_idle_3.png");
        framePaths.add("player_idle_4.png");
        new Animation(character, framePaths, 15, true);
        new PlayerController(character, 200);
        Health playerHealth = new Health(character, 5);
        PlayerCollider playerCollider = new PlayerCollider(character, 12);
        playerCollider.groups.add("boid");
        playerCollider.groups.add("environment");
        new Boundary(character, playerCollider, 0, game.windowHeight, 0, game.windowWidth);
        new Shoot(character);
        game.sceneManager.addGameObject(character, "player");

        int boidCount = 250;
        // Instatiate 10 Boid game objects
        for (int i = 0; i < boidCount; i++) {
            GameObject boid = new Boid(game, rng.nextInt(game.windowWidth), 
                                                game.windowHeight + 10);
            game.sceneManager.addGameObject(boid, "boid");
        }
        
        // Controls UI element
        GameObject controlsUI = new GameObject(game, true, game.windowWidth/2, game.windowHeight-15, 1, 1, 90);
        new Text(controlsUI, "CONTROLS: W-FORWARD S-BACK A-TURN LEFT D-TURN RIGHT LEFT CLICK-SHOOT", 20, "VT323-Regular.ttf");
        game.sceneManager.addGameObject(controlsUI);

        // Game Over
        GameObject gameOverUI = new GameObject(game, false, game.windowWidth/2, game.windowHeight/2, 1, 1, 90);
        new Text(gameOverUI, "GAME OVER", 150, "VT323-Regular.ttf");
        game.sceneManager.addGameObject(gameOverUI);

        // Win UI
        GameObject winUI = new GameObject(game, false, game.windowWidth/2, game.windowHeight/2, 1, 1, 90);
        new Text(winUI, "YOU WIN!", 150, "VT323-Regular.ttf");
        game.sceneManager.addGameObject(winUI);

        // Restart gameObject
        GameObject restartUI = new GameObject(game, false, game.windowWidth/2, 200, 1, 1, 90);
        new Text(restartUI, "PRESS SPACE TO RESTART", 50, "VT323-Regular.ttf");
        new Restart(restartUI);
        game.sceneManager.addGameObject(restartUI);

        // Player Health UI element
        GameObject healthUI = new GameObject(game, true, game.windowWidth/2, 30, 1, 1, 90);
        Text healthText = new Text(healthUI, "Player Health: 5", 30, "VT323-Regular.ttf");
        new UpdateHealth(healthUI, healthText, playerHealth, gameOverUI, restartUI);
        game.sceneManager.addGameObject(healthUI);

        // Boid count UI element
        GameObject boidCountUI = new GameObject(game, true, game.windowWidth - 135, 30, 1, 1, 90);
        Text boidCountText = new Text(boidCountUI, "", 30, "VT323-Regular.ttf");
        new UpdateBoidCount(boidCountUI, boidCountText, winUI, restartUI);
        game.sceneManager.addGameObject(boidCountUI);

        // FPS counter object
        GameObject fpsCounter = new GameObject(game, true, 35, 30, 1, 1, 90);
        new Text(fpsCounter, "0", 20, "VT323-Regular.ttf");
        new FPSCounter(fpsCounter);
        game.sceneManager.addGameObject(fpsCounter);
    }
}