package useless.ai;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    SendMsg Smsg = new SendMsg();
    RecMsg Rmsg = new RecMsg();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Useless.Ai: Your Personal ChatBot");

        Pane pane = new Pane();
        pane.setPrefSize(650, 800);
        pane.setStyle("-fx-background-color: #1e1e1e;");

        VBox vbox = new VBox(10); // 10px gap between labels
        vbox.setLayoutX(200);
        vbox.setLayoutY(200);
        vbox.setPrefWidth(600);


        Image image = new Image(getClass().getResourceAsStream("/useless/ai/img/Useless_AI.png"));

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(80);
        imageView.setLayoutX(180);
        imageView.setLayoutY(83);
        imageView.setPreserveRatio(true);

        pane.getChildren().add(imageView);


        Label WelcomeTXT = new Label("Talk to me about anything");
        WelcomeTXT.setLayoutX(280);
        WelcomeTXT.setLayoutY(83);
        WelcomeTXT.setPrefWidth(162);
        WelcomeTXT.setWrapText(true);
        WelcomeTXT.setFont(Font.loadFont(getClass().getResourceAsStream("/useless/ai/fonts/Lato.ttf"), 24.00));
        WelcomeTXT.setStyle("-fx-text-fill: #D9D9D9;");
        pane.getChildren().add(WelcomeTXT);

        pane.getChildren().add(vbox);


        TextArea inputZone = new TextArea("");
        inputZone.setLayoutX(169.98);
        inputZone.setLayoutY(429.99);
        inputZone.setPrefWidth(314.00);
        inputZone.setWrapText(true);
        inputZone.setPromptText("Enter Text Here");
        inputZone.setFont(Font.loadFont(getClass().getResourceAsStream("/useless/ai/fonts/Lato.ttf"), 16.00));
        inputZone.setStyle("-fx-control-inner-background: #B2B2B2; -fx-background-color: #B2B2B2; -fx-text-fill: #353535; -fx-border-color: #979797; -fx-border-width: 0px; -fx-border-radius: 2px; -fx-prompt-text-fill: #656565;");
        pane.getChildren().add(inputZone);

        Button sendBtn = new Button("Send");
        sendBtn.setLayoutX(504.90);
        sendBtn.setLayoutY(426.00);
        sendBtn.setPrefWidth(90.00);
        sendBtn.setPrefHeight(82.00);
        sendBtn.setWrapText(true);
        sendBtn.setDisable(false);
        sendBtn.setFont(Font.loadFont(getClass().getResourceAsStream("/useless/ai/fonts/Lato.ttf"), 24.00));
        sendBtn.setStyle("-fx-background-color: #2e2e2e; -fx-text-fill: #D9D9D9; -fx-border-color: #979797; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        sendBtn.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { sendBtn.setBackground(new Background(new BackgroundFill(Color.web("#232323"), new CornerRadii(4.00), null))); });
        sendBtn.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { sendBtn.setBackground(new Background(new BackgroundFill(Color.web("#2e2e2e"), new CornerRadii(4.00), null))); });

        sendBtn.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { Smsg.setMsgText(inputZone.getText());  
                                                                inputZone.clear();
                                                                vbox.getChildren().add(Smsg.generateTextBox(Smsg.getMsgText()));
                                                                vbox.getChildren().add(Rmsg.generateResponseLbl());
                                                                    });

        pane.getChildren().add(sendBtn);
        

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}