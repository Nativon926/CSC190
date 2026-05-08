/*
    Miranda Germain
    Exercise1603.java
    April 18, 2023

    The purpose of this class is to display a traffic light where the user
    can choose which color is displayed by selecting different radio buttons.
    Only one color can display at once.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise1603 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Create Borderpane to hold other panes
        BorderPane borderPane = new BorderPane();
        // Create traffic light pane
        TrafficLightPane trafficLightPane = new TrafficLightPane();
        // Set traffic light pane to center of borderpane
        borderPane.setCenter(trafficLightPane);

        HBox hBox = new HBox(20); // Create hBox
        hBox.setPadding(new Insets(5, 5, 5, 5)); // Set padding of hBox

        // Create red choice button
        RadioButton rbRed = new RadioButton("Red");
        // Create yellow choice button
        RadioButton rbYellow = new RadioButton("Yellow");
        // Create green choice button
        RadioButton rbGreen = new RadioButton("Green");
        // Add buttons in order to hBox
        hBox.getChildren().addAll(rbRed, rbGreen, rbYellow);
        borderPane.setBottom(hBox); // Set buttons to bottom of borderPane

        // Create a toggle group so only one choice can be chosen at a time
        // Add the three buttons to the group
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbYellow.setToggleGroup(group);

        // When red button is selected call trafficLightPane's red method
        rbRed.setOnAction(e -> {
            if(rbRed.isSelected()) {
                trafficLightPane.red();
            }
        });

        // When green button is selected call trafficLightPane's green method
        rbGreen.setOnAction(e -> {
            if(rbGreen.isSelected()) {
                trafficLightPane.green();
            }
        });

        // When yellow button is selected call trafficLightPane's yellow method
        rbYellow.setOnAction(e -> {
            if(rbYellow.isSelected()) {
                trafficLightPane.yellow();
            }
        });

        // Create a Scene
        Scene scene = new Scene(borderPane, 300, 300);
        // Set Stage Title
        stage.setTitle("Traffic Light");
        // Set the scene
        stage.setScene(scene);
        // Display stage
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

// TrafficLightPane is a pane for a traffic light consisting of
// a rectangle and three circles.
class TrafficLightPane extends Pane {
    private double w = 270; // Width of TrafficLightPane
    private double h = 150; // Height of TrafficLightPane

    private Rectangle rectangle = new Rectangle(w/2, h/2, 40, 120);

    // Create the Circle objects for individual lights
    private Circle light1 = new Circle(rectangle.getX() + 20, rectangle.getY() + 20,
            Math.min(rectangle.getWidth(), rectangle.getHeight()) * 0.35);
    private Circle light2 = new Circle(rectangle.getX() + 20, rectangle.getY() + 60,
            Math.min(rectangle.getWidth(), rectangle.getHeight()) * 0.35);
    private Circle light3 = new Circle(rectangle.getX() + 20, rectangle.getY() + 100,
            Math.min(rectangle.getWidth(), rectangle.getHeight()) * 0.35);

    // Default constructor of TrafficLightPane that sets default colors
    // And adds the rectangle and lights to the TrafficLightPane
    public TrafficLightPane() {
        // Set the default color of lights to be white with a
        // black outline
        light1.setStroke(Color.BLACK);
        light2.setStroke(Color.BLACK);
        light3.setStroke(Color.BLACK);
        light1.setFill(Color.WHITE);
        light2.setFill(Color.WHITE);
        light3.setFill(Color.WHITE);

        // Set default color of rectangle to be filled white
        // with a black outline
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);

        // Add the rectangle and three lights to the trafficlightpane
        getChildren().addAll(rectangle, light1,light2,light3);
    }

    // Sets every light white except for the bottom light to green
    public void green() {
        light1.setFill(Color.WHITE);
        light2.setFill(Color.WHITE);
        light3.setFill(Color.GREEN);
    }

    // Sets every light white except for the middle to yellow
    public void yellow() {
        light1.setFill(Color.WHITE);
        light2.setFill(Color.YELLOW);
        light3.setFill(Color.WHITE);
    }

    // Sets every light white except for top light to red
    public void red() {
        light1.setFill(Color.RED);
        light2.setFill(Color.WHITE);
        light3.setFill(Color.WHITE);
    }
}