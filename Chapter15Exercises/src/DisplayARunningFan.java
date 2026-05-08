/*
    Miranda Germain
    4/7/2023
    Exercise1528.java

    This program displays a running fan. It has a pause button to
    stop the spinning, a resume button to start the spinning again,
    a reverse button to reverse the fan's direction. The speed
    up button makes the spinning faster until a certain max
    increment reach and a slow down button makes it slower until a
    certain min value is reached.

 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DisplayARunningFan extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Create HBox for formatting with buttons side by side
        HBox hBox = new HBox(5);
        Button btPause = new Button("Pause");
        Button btResume = new Button ("Resume");
        Button btReverse = new Button("Reverse");
        Button btIncSpeed = new Button("Increase Speed");
        Button btDecSpeed = new Button("Decrease Speed");
        hBox.setAlignment(Pos.CENTER);

        // Add buttons to the hBoc
        hBox.getChildren().addAll(btResume, btPause, btReverse, btIncSpeed, btDecSpeed);

        // Create a border pane and add hBox to the bottom
        BorderPane bPane = new BorderPane();
        bPane.setBottom(hBox);

        // Create a fan pane in the center, holds the fan
        FanPane fanPane = new FanPane();
        bPane.setCenter(fanPane);

        // Create animation for spinning fan
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(100), e -> fanPane.move()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        // Give Buttons their functions
        btPause.setOnAction(e -> animation.pause());
        btResume.setOnAction(e -> animation.play());
        btReverse.setOnAction(e -> fanPane.reverse());
        btIncSpeed.setOnAction(e -> fanPane.increase());
        btDecSpeed.setOnAction(e -> fanPane.decrease());

        // Create the scene
        Scene scene = new Scene(bPane, 300, 230);
        stage.setTitle("Moving Fan"); // Set the name
        stage.setScene(scene); // Set the scene
        stage.show(); // display

        // Bind fan pane width & height to the scene's width & height
        scene.widthProperty().addListener(e -> fanPane.setW(scene.getWidth()));
        scene.heightProperty().addListener(e -> fanPane.setH(scene.getHeight()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class FanPane extends Pane {
    private double w = 200; // Width of Fanpane
    private double h = 200; // Height of Fanpane
    private double radius = Math.min(w, h) * 0.45;

    private Arc arc[] = new Arc[4]; // Individual fan blades
    private double startAngle = 30; // First fanblade angle
    // Create outer circle
    private Circle circle = new Circle(w/2, h/2, radius);

    public FanPane() {
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        getChildren().add(circle);

        // Create the 4 fan blades with the appropriate degree
        for(int i = 0; i < 4; i++) {
            arc[i] = new Arc(w/2,h/2, radius * 0.9, radius * 0.9, startAngle + i*90, 35);
            arc[i].setFill(Color.RED);
            arc[i].setType(ArcType.ROUND);
            getChildren().addAll(arc[i]);
        }

        getChildren().add(message); // Add message about speed to fanPane
    }

    // This methods sets the values for the Circle and the individual arcs
    public void setValues() {
        radius = Math.min(w, h) * .45;
        circle.setRadius(radius);
        circle.setCenterX(w/2);
        circle.setCenterY(h/2);

        for(int i =0; i <4; i++) {
            arc[i].setRadiusX(radius * 0.9); // 0.9 so less than outer circle
            arc[i].setRadiusY(radius * 0.9);
            arc[i].setCenterX(w/2); // Set arc's center to the pane's center
            arc[i].setCenterY(h/2);
            arc[i].setStartAngle(startAngle + i*90); // Assures correct spacing
        }
    }

    private double increment = 5; // Fan Speed, increment of degree
    // Message for informing user about fan speed max & min
    Text message = new Text(5, 10, "");

    // This method increases the starting angle by the increment
    public void move() {
        setStartAngle(startAngle + increment);
    }

    // This method allows the fan speed in be increased as
    // long as the speed is below the fan's max speed
    // Absolute value accounts for reversed increments
    public void increase() {
        if(Math.abs(increment) < 40) {
            message.setText(""); // "Remove" message
            increment *= 2; // increase speed
        }
        else {
            message.setText("Max Speed Reached");
        }
    }

    // This method decreases the fan's speed as
    // long as the speed is still above the minimum speed
    public void decrease() {
        if (Math.abs(increment) > 5) {
            message.setText("");
            increment /= 2;
        }
        else {
            message.setText("Lowest Speed Reached");
        }
    }

    // Sets the starting angle
    public void setStartAngle(double angle) {
        this.startAngle = angle;
        setValues();
    }

    // Reverses the fan's direction by multiply the increment
    // by negative 1
    public void reverse() {
        increment *= -1;
    }

    // Set width
    public void setW(double w) {
        this.w = w;
        setValues();
    }

    // Set Height
    public void setH(double h) {
        this.h = h;
        setValues();
    }
}
