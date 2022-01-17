import game_engine.*;

class TitleScene extends Scene {

    @Override
    public void load (Game game) {
        
        // Background game object
        GameObject backgroundTitle = new GameObject(game, true, game.windowWidth/2, game.windowHeight/2, 2, 2, 90);
        new Sprite(backgroundTitle, "background.png");
        game.sceneManager.addGameObject(backgroundTitle);

        GameObject startObject = new GameObject(game, true, game.windowWidth/2, 200, 1, 1, 90);
        new Text(startObject, "PRESS SPACE TO START", 40, "VT323-Regular.ttf");
        new Start(startObject);
        game.sceneManager.addGameObject(startObject);

        GameObject title = new GameObject(game, true, game.windowWidth/2, game.windowHeight/2, 2, 2, 90);
        new Sprite(title, "title.png");
        game.sceneManager.addGameObject(title);
    }
}