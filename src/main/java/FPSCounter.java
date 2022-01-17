import game_engine.Script;
import game_engine.GameObject;
import game_engine.Text;

public class FPSCounter extends Script {

    public Text textComponent;

    public FPSCounter(GameObject parent) {
        super(parent);
    }

    @Override
    public void onSceneLoad() {
        this.textComponent = this.gameObject.getComponents(Text.class).get(0);
    }

    @Override
    public void update()  {
        double deltaTime = this.game.deltaTime;
        int fps = (int)(1 / deltaTime);
        this.textComponent.textValue = "FPS: " + Integer.toString(fps);
    }


}