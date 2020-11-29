import game_engine.Component;
import game_engine.GameObject;
import game_engine.Text;

class UpdateHealth implements Component {

    public GameObject parent;
    public Text healthText;
    public Health playerHealth;
    public GameObject gameOver;
    public GameObject restart;

    public UpdateHealth (GameObject parent, Text healthText, Health playerHealth, GameObject gameOver, GameObject restart) {
        this.parent = parent;
        this.healthText = healthText;
        this.gameOver = gameOver;
        this.restart = restart;
        this.playerHealth = playerHealth;
    }

    public void update () {
        this.healthText.textValue = "Health: " + this.playerHealth.health;
        if (this.playerHealth.health <= 0) {
            this.gameOver.active = true;
            this.restart.active = true;
        }
    }
}