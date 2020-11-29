import game_engine.*;

class TitleScene extends Scene {

    public void load (Game game) {
        // Background game object
        GameObject backgroundTitle = new GameObject(game, this, true, game.windowWidth/2, game.windowHeight/2, 2, 2, 90);
        Sprite backgroundTitleSprite = new Sprite(backgroundTitle, "background.png");
        backgroundTitle.addComponent(backgroundTitleSprite);
        this.addGameObject(backgroundTitle);

        GameObject startObject = new GameObject(game, this, true, game.windowWidth/2 - 150, game.windowHeight/2, 0, 0, 90);
        Text startText = new Text(startObject, "PRESS SPACE TO START", 40, "VT323-Regular.ttf");
        Start start = new Start(game);
        startObject.addComponent(start);
        startObject.addComponent(startText);
        this.addGameObject(startObject);

        GameObject title = new GameObject(game, this, true, game.windowWidth/2, game.windowHeight-200, 2, 2, 90);
        Sprite titleSprite = new Sprite(title, "title.png");
        title.addComponent(titleSprite);
        this.addGameObject(title);
    }
}