import game_engine.*;
import java.util.Random;
import java.util.ArrayList;

class MainScene extends Scene {

    public void load (Game game) {

        // Background game object
        GameObject background = new GameObject(game, this, true, game.windowWidth/2, game.windowHeight/2, 2, 2, 90);
        Sprite backgroundSprite = new Sprite(background, "background.png");
        background.addComponent(backgroundSprite);
        this.addGameObject(background);

        // Instatiate 10 Asteroid game objects
        Random rng = new Random();
        for (int i = 0; i < 25; i++) {
            GameObject asteroid = new Asteroid(game, this, rng.nextInt(game.windowWidth), 
                                                rng.nextInt(game.windowHeight), 
                                                rng.nextInt(360));
            this.addGameObject(asteroid, "environment");
        }

        // Character game object
        GameObject character = new GameObject(game, this, true, game.windowWidth/2, 30, 2, 2, 90);
        ArrayList<String> framePaths = new ArrayList<String> ();
        framePaths.add("player_idle_1.png");
        framePaths.add("player_idle_2.png");
        framePaths.add("player_idle_3.png");
        framePaths.add("player_idle_4.png");
        Animation characterSprite = new Animation(character, framePaths, 15, true);
        PlayerController playerController = new PlayerController(character, 200);
        Health playerHealth = new Health(character, 5);
        character.addComponent(playerHealth);
        PlayerCollider playerCollider = new PlayerCollider(character, 12);
        playerCollider.groups.add("boid");
        playerCollider.groups.add("environment");
        Boundary playerBoundary = new Boundary(character, playerCollider, 0, game.windowHeight, 0, game.windowWidth);
        Shoot playerShoot = new Shoot(character);
        character.addComponent(playerShoot);
        character.addComponent(playerBoundary);
        character.addComponent(characterSprite);
        character.addComponent(playerController);
        character.addComponent(playerCollider);
        this.addGameObject(character, "player");

        int boidCount = 50;
        // Instatiate 10 Boid game objects
        for (int i = 0; i < boidCount; i++) {
            GameObject boid = new Boid(game, this, rng.nextInt(game.windowWidth), 
                                                game.windowHeight + 10);
            boid.getComponents(FollowPlayer.class).get(0).player = character;
            this.addGameObject(boid, "boid");
        }
        
        // Controls UI element
        GameObject controlsUI = new GameObject(game, this, true, 5, game.windowHeight-15, 1, 1, 90);
        Text controls = new Text(controlsUI, "CONTROLS: W-FORWARD S-BACK A-TURN LEFT D-TURN RIGHT LEFT CLICK-SHOOT", 20, "VT323-Regular.ttf");
        controlsUI.addComponent(controls);
        this.addGameObject(controlsUI);

        // Game Over
        GameObject gameOverUI = new GameObject(game, this, false, game.windowWidth/2-275, game.windowHeight/2, 1, 1, 90);
        Text gameOverText = new Text(gameOverUI, "GAME OVER", 150, "VT323-Regular.ttf");
        gameOverUI.addComponent(gameOverText);
        this.addGameObject(gameOverUI);

        // Win UI
        GameObject winUI = new GameObject(game, this, false, game.windowWidth/2-245, game.windowHeight/2, 1, 1, 90);
        Text winText = new Text(winUI, "YOU WIN!", 150, "VT323-Regular.ttf");
        winUI.addComponent(winText);
        this.addGameObject(winUI);

        // Restart gameObject
        GameObject restartUI = new GameObject(game, this, false, game.windowWidth/2-225, game.windowHeight/2 + 45, 1, 1, 90);
        Text restartText = new Text(restartUI, "PRESS SPACE TO RESTART", 50, "VT323-Regular.ttf");
        Restart restart = new Restart(restartUI);
        restartUI.addComponent(restart);
        restartUI.addComponent(restartText);
        this.addGameObject(restartUI);

        // Player Health UI element
        GameObject healthUI = new GameObject(game, this, true, game.windowWidth/2 - 25, 25, 0, 0, 90);
        Text healthText = new Text(healthUI, "Player Health: 5", 30, "VT323-Regular.ttf");
        UpdateHealth updateHealth = new UpdateHealth(healthUI, healthText, playerHealth, gameOverUI, restartUI);
        healthUI.addComponent(updateHealth);
        healthUI.addComponent(healthText);
        this.addGameObject(healthUI);

        // Boid count UI element
        GameObject boidCountUI = new GameObject(game, this, true, game.windowWidth - 300, 25, 1, 1, 90);
        Text boidCountText = new Text(boidCountUI, "", 30, "VT323-Regular.ttf");
        boidCountUI.addComponent(boidCountText);
        UpdateBoidCount updateBoidCount = new UpdateBoidCount(boidCountUI, boidCountText, winUI, restartUI);
        boidCountUI.addComponent(updateBoidCount);
        this.addGameObject(boidCountUI);

        // FPS counter object
        GameObject fpsCounter = new GameObject(game, this, true, 15, 20, 1, 1, 90);
        Text text = new Text(fpsCounter, "0", 20, "VT323-Regular.ttf");
        fpsCounter.addComponent(text);
        FPSCounter fps = new FPSCounter(fpsCounter);
        fpsCounter.addComponent(fps);
        this.addGameObject(fpsCounter);
    }
}