import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimelineDemo extends Application {
    @Override
    public void start(Stage stage) {
        StackPane pane = new StackPane();
        Text text = new Text(20, 50, "Programming is fun!");
        text.setFill(Color.RED);
        pane.getChildren().add(text);

        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(text.getText().length() != 0) {
                    text.setText("");
                } else {
                    text.setText("Programming is fun!");
                }
            }
        };

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(500), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE); // Loops forever, flashes text forever
        animation.play();

        text.setOnMouseClicked(mouseEvent -> {
            text.setFill(Color.BLUE);
        });

        Scene scene = new Scene(pane, 250, 250);
        stage.setTitle("Timeline Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


