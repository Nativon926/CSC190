import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimateRisingFlag extends Application {

    @Override
    public void start(Stage stage){
        Pane pane = new Pane();
        ImageView imageView = new ImageView("C:\\Program Files\\SUNY FLCC\\SPRING 2023\\CSC 190\\JAVFX 14\\DisplayThreeCards\\DisplayThreeCards\\image\\us.gif");
        pane.getChildren().add(imageView);

        PathTransition pt = new PathTransition(Duration.millis(10000),
                new Line(100, 200, 100, 0), imageView);
        pt.setCycleCount(Animation.INDEFINITE);
        Text play = new Text(100, 100, "Play");
        play.setOnMouseClicked(e -> {
            pt.play();
        });

        Text stop = new Text(150, 100, "Stop");
        pane.getChildren().addAll(play,stop);
        stop.setOnMouseClicked(e -> {
            pt.pause();
        });

        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("Rising Animation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}