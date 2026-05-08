/*
    Miranda Germain
    4/7/2023
    Exercise1518.java

    This class displays a rectangle. You can point the mouse inside the
    rectangle and drag the rectangle wherever the mouse goes. The mouse
    point becomes the center of the rectangle.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise1518 extends Application {
    @Override
    public void start(Stage stage) {
        // Create the pane
        Pane pane = new Pane();

        // Create the rectangle
        Rectangle rectangle = new Rectangle(100, 60, 100, 40);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);

        // Add rectangle to the pane
        pane.getChildren().add(rectangle);

        // Create mouse event where center of rectangle will follow cursor
        pane.setOnMouseDragged(e-> {
            if(rectangle.contains(e.getX(),e.getY())) {
                rectangle.setX(e.getX() - (rectangle.getWidth() / 2));
                rectangle.setY(e.getY() - (rectangle.getHeight() / 2));
            }
        });

        // Title the stage
        stage.setTitle("Move a rectangle using mouse");
        stage.setScene(new Scene(pane, 500, 500)); // Set Scene
        stage.show(); // Show stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}
