package useless.ai;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class SendMsg {
    private String msgText;
    private double msgPosY = 226;
    private final int incrementRate = 20;

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public Label generateTextBox(String text)
    {
        Label UserResponseTxt = new Label(getMsgText());
        //UserResponseTxt.setLayoutX(384);
        setMsgPosY(msgPosY + incrementRate);
        UserResponseTxt.setLayoutY(getMsgPosY());
        //UserResponseTxt.setPrefWidth(106);
        UserResponseTxt.setWrapText(true);
        UserResponseTxt.setAlignment(Pos.CENTER_RIGHT);
        UserResponseTxt.setFont(Font.loadFont(getClass().getResourceAsStream("/useless/ai/fonts/Lato.ttf"), 14.00));
        UserResponseTxt.setStyle("-fx-text-fill: #D9D9D9;");
        return UserResponseTxt;
    }

    public double getMsgPosY() {
        return msgPosY;
    }

    public void setMsgPosY(double posY) {
        this.msgPosY = posY;
    }
}
