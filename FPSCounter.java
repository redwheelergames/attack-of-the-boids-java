import game_engine.Component;
import game_engine.GameObject;
import game_engine.Text;

public class FPSCounter implements Component {

    public GameObject parent;
    public Text textComponent;

    public FPSCounter(GameObject parent) {
        this.parent = parent;
        this.textComponent = this.parent.getComponent(Text.class);
    }

    public void update()  {
        double deltaTime = this.parent.game.deltaTime;
        int fps = (int)(1 / deltaTime);
        this.textComponent.textValue = "FPS: " + Integer.toString(fps);
    }


}