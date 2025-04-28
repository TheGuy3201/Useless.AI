package useless.ai;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font; // make sure you add this import at the top too
import javafx.stage.Stage;

public class App extends Application {
    SendMsg Smsg = new SendMsg();
    RecMsg Rmsg = new RecMsg();

    VBox chatBox = new VBox(10);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Useless.Ai: Your Personal ChatBot");

        Pane pane = new Pane();
        pane.setPrefSize(650, 800);
        pane.setStyle("-fx-background-color: #1e1e1e;");

        HBox hbox = new HBox(50); // 50px spacing between the two
        hbox.setLayoutX(000); // Move it a little from the left
        hbox.setLayoutY(200); // Center vertically however you want

        // Center the items inside the HBox
        hbox.setPrefWidth(650); // Total width available
        hbox.setPrefHeight(400);
        hbox.setAlignment(Pos.CENTER);

         // 10px gap between labels
        chatBox.setAlignment(Pos.TOP_CENTER);
        chatBox.setLayoutX(100);
        chatBox.setLayoutY(0);

        hbox.getChildren().add(chatBox);

        Image image = new Image(getClass().getResourceAsStream("/useless/ai/img/Useless_AI.png"));

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(80);
        imageView.setLayoutX(100);
        imageView.setLayoutY(80);
        imageView.setPreserveRatio(true);

        pane.getChildren().add(imageView);

        Label WelcomeTXT = new Label("Talk to me about anything");
        WelcomeTXT.setLayoutX(200);
        WelcomeTXT.setLayoutY(83);
        WelcomeTXT.setPrefWidth(600);
        WelcomeTXT.setWrapText(false);
        WelcomeTXT.setFont(Font.loadFont(getClass().getResourceAsStream("/useless/ai/fonts/Lato.ttf"), 32.00));
        WelcomeTXT.setStyle("-fx-text-fill: #D9D9D9;");
        pane.getChildren().add(WelcomeTXT);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(chatBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefViewportWidth(450); // or whatever fits your layout
        scrollPane.setPrefViewportHeight(400);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        scrollPane.setPannable(true); // optional, allows click+drag scrolling

        // Place ScrollPane instead of just the HBox
        hbox.getChildren().add(scrollPane);

        pane.getChildren().add(hbox);

        TextArea inputZone = new TextArea();
        inputZone.setLayoutX(100);
        inputZone.setLayoutY(630);
        inputZone.setPrefWidth(400.00);
        inputZone.setPrefHeight(100.00);
        inputZone.setWrapText(true);
        inputZone.setPromptText("Enter Text Here");
        inputZone.setFont(Font.loadFont(getClass().getResourceAsStream("/useless/ai/fonts/Lato.ttf"), 18.00));
        inputZone.setStyle("-fx-control-inner-background: #B2B2B2; -fx-background-color: #B2B2B2; -fx-text-fill: #353535; -fx-border-color: #979797; -fx-border-width: 0px; -fx-border-radius: 2px; -fx-prompt-text-fill: #656565;");
        pane.getChildren().add(inputZone);

        Button sendBtn = new Button("Send");
        sendBtn.setLayoutX(510);
        sendBtn.setLayoutY(630);
        sendBtn.setPrefWidth(90.00);
        sendBtn.setPrefHeight(82.00);
        sendBtn.setWrapText(true);
        sendBtn.setDisable(false);
        sendBtn.setFont(Font.loadFont(getClass().getResourceAsStream("/useless/ai/fonts/Lato.ttf"), 24.00));
        sendBtn.setStyle("-fx-background-color: #2e2e2e; -fx-text-fill: #D9D9D9; -fx-border-color: #979797; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        sendBtn.setOnMousePressed(e -> setButtonBackground(sendBtn, "#232323"));
        sendBtn.setOnMouseReleased(e -> setButtonBackground(sendBtn, "#2e2e2e"));
        sendBtn.setOnAction(e -> {
            sendMessage(inputZone.getText());
            inputZone.clear();
        });
        
        pane.getChildren().add(sendBtn);
        
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void sendMessage(String text) 
    {
        //AudioClip sound = new AudioClip(getClass().getResource("/useless/ai/sfx/message_sent.mp3").toExternalForm());

        VBox messageRow = new VBox(40); 
        messageRow.setPrefWidth(400);
    
        Label userMsg = Smsg.generateTextBox(text);
        messageRow.getChildren().add(userMsg);
    
        Label botMsg = Rmsg.generateResponseLbl();
        HBox botMessageRow = new HBox(botMsg);
        botMessageRow.setPrefWidth(400);
        botMessageRow.setAlignment(Pos.CENTER_RIGHT);
    
        messageRow.getChildren().add(botMessageRow);
        chatBox.getChildren().add(messageRow);
        //sound.play();
    }
    

    private void setButtonBackground(Button btn, String color) 
    {
        btn.setBackground(new Background(new BackgroundFill(Color.web(color), new CornerRadii(4), null)));
    }
    
    public static void main(String[] args) { launch(args); }
}