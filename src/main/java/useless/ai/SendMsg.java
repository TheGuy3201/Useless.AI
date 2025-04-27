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

    public Label generateTextBox(String text)
    {
        Label UserResponseTxt = new Label(getMsgText());
        UserResponseTxt.setLayoutY(MessageHelper.getIncrementRate());
        UserResponseTxt.setWrapText(true);
        UserResponseTxt.setAlignment(Pos.TOP_RIGHT);
        UserResponseTxt.setFont(Font.loadFont(getClass().getResourceAsStream("/useless/ai/fonts/Lato.ttf"), 14.00));
        UserResponseTxt.setStyle("-fx-text-fill: #D9D9D9;");

        return UserResponseTxt;
    }
}
