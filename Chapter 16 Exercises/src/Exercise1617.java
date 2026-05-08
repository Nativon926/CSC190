/*
    Miranda Germain
    Exercise1617.java
    April 18, 2023

    This program displays text that the user can manipulate the
    color of using four different sliders for red, blue, green,
    and opacity.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise1617 extends Application {
    public void start(Stage primaryStage) {
        // Create text that displays "Show Colors" that will be
        // manipulated later
        Text text = new Text(65, 40, "Show Colors");
        Pane paneForText = new Pane(); // Create pane to hold text
        paneForText.getChildren().add(text);

        // Create a scrollbar that controls the red color amount
        // in the text
        ScrollBar slRed = new ScrollBar();
        Text txtRed = new Text("Red");
        HBox hBox1 = new HBox(50 - txtRed.getText().length());
        hBox1.getChildren().addAll(txtRed, slRed);

        // Create a scrollbar that controls the green color amount
        // in the text
        ScrollBar slGreen = new ScrollBar();
        Text txtGreen = new Text("Green");
        HBox hBox2 = new HBox(41 - txtGreen.getText().length());
        hBox2.getChildren().addAll(txtGreen, slGreen);

        // Create a scrollbar that controls the blue color amount
        // in the text
        ScrollBar slBlue = new ScrollBar();
        Text txtBlue = new Text("Blue");
        HBox hBox3 = new HBox(50 - txtGreen.getText().length());
        hBox3.getChildren().addAll(txtBlue, slBlue);

        // Create a scrollbar that controls the opacity amount
        // of the text
        ScrollBar slOpacity = new ScrollBar();
        // Set opacity to 50 so that when program is ran the text can be
        // seen.
        slOpacity.setValue(50);
        Text txtOpacity = new Text("Opacity");
        HBox hBox4 = new HBox(32 - txtGreen.getText().length());
        hBox4.getChildren().addAll(txtOpacity, slOpacity);

        // Create a vertical box to hold different scrollbars
        VBox scrollBarVBox = new VBox();
        scrollBarVBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);

        // Create borderpan to hold text and scroll bars
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForText);
        pane.setBottom(scrollBarVBox);

        // Add listener to the scrollbars in order to adjust the color of
        // the text appropriately
        slRed.valueProperty().addListener(ov -> {
            text.setFill(Color.color(slRed.getValue() / 100, slGreen.getValue() / 100,
                    slBlue.getValue() / 100, slOpacity.getValue() / 100));
        });

        slGreen.valueProperty().addListener(ov -> {
            text.setFill(Color.color(slRed.getValue() / 100, slGreen.getValue() / 100,
                    slBlue.getValue() / 100, slOpacity.getValue() / 100));
        });

        slBlue.valueProperty().addListener(ov -> {
            text.setFill(Color.color(slRed.getValue() / 100, slGreen.getValue() / 100,
                    slBlue.getValue() / 100, slOpacity.getValue() / 100));
        });

        slOpacity.valueProperty().addListener(ov -> {
            text.setFill(Color.color(slRed.getValue() / 100, slGreen.getValue() / 100,
                    slBlue.getValue() / 100, slOpacity.getValue() / 100));
        });

        // Create a scene
        Scene scene = new Scene(pane, 200, 170);
        primaryStage.setTitle("Slider Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
