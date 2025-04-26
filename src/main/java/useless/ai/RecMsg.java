package useless.ai;

import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class RecMsg {
    PauseTransition pause = new PauseTransition(Duration.seconds(3));
    private final String response = "Error 1901: Please try Useless.ai again later :(";
    private final int incrementRate = 40;
    private double rspPosY = 183.9517059326172;

    public Label generateResponseLbl()
    {
        Label ResponseTxt = new Label(getResponse());
        pause.setOnFinished(event -> {
            ResponseTxt.setLayoutX(174.99713134765625);
            setRspPosY(rspPosY + incrementRate);
            ResponseTxt.setLayoutY(rspPosY);
            ResponseTxt.setPrefWidth(140);
            ResponseTxt.setWrapText(true);
            ResponseTxt.setFont(Font.loadFont(getClass().getResourceAsStream("/useless/ai/fonts/Lato.ttf"), 16.00));
            ResponseTxt.setStyle("-fx-text-fill: #D9D9D9;");
        });
        pause.play();

        return ResponseTxt;
        
    }

    public String getResponse() {
        return response;
    }

    public double getRspPosY() {
        return rspPosY;
    }

    public void setRspPosY(double posY) {
        this.rspPosY = posY;
    }
}
