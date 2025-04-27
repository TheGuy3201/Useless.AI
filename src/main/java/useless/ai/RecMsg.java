package useless.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;


public class RecMsg 
{
    Random r = new Random();

    final ArrayList<String> errorMessages = new ArrayList<>(List.of(
    "Error 6549: We are experiencing some issues.",
    "Error 2593: Please wait a moment before retrying.",
    "Error 2029: Please be patient and try again.",
    "Error 2120: Service is unavailable at the moment.",
    "Error 3239: Oops! Something went wrong.",
    "Error 1956: Service is temporarily unavailable.",
    "Error 6506: Oops! Something went wrong.",
    "Error 8230: Service is unavailable at the moment.",
    "Error 4112: We're currently facing a problem.",
    "Error 8902: Unable to process your request right now.",
    "Error 3298: Unexpected error occurred, try again.",
    "Error 9909: Oops! Something went wrong.",
    "Error 1707: We're currently facing a problem.",
    "Error 7754: Please try again later.",
    "Error 8838: Temporary issue, please try again soon.",
    "Error 4969: Unable to process your request right now.",
    "Error 4821: Service interrupted. Please retry.",
    "Error 4369: Please bear with us and try again.",
    "Error 6468: We're working on resolving the issue.",
    "Error 1979: Service is temporarily unavailable."
    ));


    public Label generateResponseLbl() {
        Label responseTxt = new Label(errorMessages.get(r.nextInt(errorMessages.size())));
        responseTxt.setPrefWidth(140);
        responseTxt.setWrapText(true);
        responseTxt.setAlignment(Pos.TOP_RIGHT);
        responseTxt.setFont(Font.loadFont(getClass().getResourceAsStream("/useless/ai/fonts/Lato.ttf"), 16));
        responseTxt.setStyle("-fx-text-fill: #D9D9D9;");
        return responseTxt;
    }
    
}
