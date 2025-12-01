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
        
        // Safe font loading with fallback
        Font customFont = null;
        try {
            customFont = Font.loadFont(getClass().getResourceAsStream("/useless/ai/fonts/Lato.ttf"), 16);
        } catch (Exception e) {
            System.out.println("Custom font not found in SendMsg, using default font");
        }
        
        if (customFont != null) {
            userResponseTxt.setFont(customFont);
        } else {
            userResponseTxt.setFont(Font.font("Arial", 16)); // Fallback to Arial
        }
        
        userResponseTxt.setStyle("-fx-text-fill: #D9D9D9;");
        return userResponseTxt;
    }    
}
