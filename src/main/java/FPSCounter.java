import game_engine.Component;
import game_engine.GameObject;
import game_engine.Text;

public class FPSCounter implements Component {

    public GameObject parent;
    public Text textComponent;

    public FPSCounter(GameObject parent) {
        this.parent = parent;
        this.textComponent = this.parent.getComponents(Text.class).get(0);
    }

    public void update()  {
        double deltaTime = this.parent.game.deltaTime;
        int fps = (int)(1 / deltaTime);
        this.textComponent.textValue = "FPS: " + Integer.toString(fps);
    }


}