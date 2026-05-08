/*
    Miranda Germain
    4/7/2023
    Exercise 15.12/15.13
    The purpose of this class is to display a message indicating whether the
    mouse is within the shape or outside the shape. Fade transition was added
    to the black rectangle to get a better feel for how animations work.
 */

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise12and13 extends Application {
    @Override
    public void start(Stage stage) {
        // Create new Pane
        Pane pane = new Pane();

        // Create Circle to add to the pane
        Circle circle = new Circle(100, 60, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // Create Rectangle to add to the pane
        Rectangle rectangle = new Rectangle(300, 30, 70, 70);
        rectangle.setStroke(Color.BLACK);

        Text text = new Text(); // Setting up based on mouse movement
        pane.getChildren().addAll(circle, rectangle, text); // Add Nodes

        // Create fade transition for rectangle
        FadeTransition ft = new FadeTransition(Duration.ONE, rectangle);

        // Event based on mouse location
        pane.setOnMouseMoved(mouseEvent -> {
            // If mouse is within the circle
            if(circle.contains(mouseEvent.getX(), mouseEvent.getY())) {
                text.setText("Mouse point is inside the circle");
            }
            // If mouse is within the rectangle
            else if (rectangle.contains(mouseEvent.getX(), mouseEvent.getY())) {
                text.setText("Mouse point is inside the rectangle");
                // Change color of text and transparency of rectangle
                // to be better legible (for fun)
                text.setFill(Color.GRAY);
                ft.setFromValue(1.0);
                ft.setToValue(.25);
                ft.play();
            } else {
                // Return text and rectangle back to default when mouse leaves
                // either shape
                text.setText(("Mouse point is outside the circle & rectangle"));
                text.setFill(Color.BLACK);
                ft.setFromValue(.25);
                ft.setToValue(1.0);
                ft.play();
            }

            // Set the text to "follow" the cursor
            text.setX(mouseEvent.getX());
            text.setY(mouseEvent.getY());
        });

        // Create the scene
        Scene scene = new Scene(pane, 600, 250);
        stage.setTitle("Circle Test"); // Set the Title
        stage.setScene(scene); // Set the Scene
        stage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}