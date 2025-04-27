package useless.ai;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class SendMsg {
    private String msgText;

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public Label generateTextBox(String text) {
        Label userResponseTxt = new Label(text);
        userResponseTxt.setWrapText(true);
        userResponseTxt.setAlignment(Pos.TOP_RIGHT);
        userResponseTxt.setFont(Font.loadFont(getClass().getResourceAsStream("/useless/ai/fonts/Lato.ttf"), 16));
        userResponseTxt.setStyle("-fx-text-fill: #D9D9D9;");
        return userResponseTxt;
    }    
}
