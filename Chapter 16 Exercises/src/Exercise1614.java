/*
    Miranda Germain
    Exercise1614.java
    April 18, 2023

    This class displays text that the user can manipulate the font name,
    size, weight, and posture of using comboboxes and checkboxes
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;


public class Exercise1614 extends Application {

    private double paneWidth = 480; // Width of pane
    private double paneHeight = 250; // Height of Pane

    // Create the label with the text that will be manipulated by user
    private Label label = new Label("Programming is fun");
    // Create a combobox to hold font names
    private ComboBox<String> cboFontName = new ComboBox<>();
    // Create a ComboBox to hold font sizes
    private ComboBox<Integer> cboFontSize = new ComboBox<>();
    // Create as check box for bold selection
    private CheckBox chkBold = new CheckBox("Bold");
    // Create a checkbox for italic selection
    private CheckBox chkItalic = new CheckBox("Italic");

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane(); // Create borderPane
        pane.setCenter(label); // Add label to center of borderPane

        // Create a list of all available font faces and add
        // those to the comboBox for font names
        List<String> fontNames = Font.getFamilies();
        cboFontName.getItems().addAll(fontNames);
        // Set default value to first selection
        cboFontName.setValue(fontNames.get(0));

        // Add numbers 1 to 100 to the Font Size Combo Box
        for(int i = 1; i<=100; i++) {
            cboFontSize.getItems().add(i);
        }
        // Set default value to first selection
        cboFontSize.setValue(1);

        // Create hBox to hold combo Boxes
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("font Name"), cboFontName, new Label("Font Size"), cboFontSize);
        hBox.setAlignment(Pos.CENTER);
        pane.setTop(hBox);

        // Create hBox to hold Checkboxes
        HBox hBox2 = new HBox(10);
        hBox2.getChildren().addAll(chkBold, chkItalic);
        hBox2.setAlignment(Pos.CENTER);
        pane.setBottom(hBox2);

        // When a choice is selected for combobox & checkbox selections
        // call setFont method
        cboFontName.setOnAction(e -> setFont());
        cboFontSize.setOnAction(e -> setFont());
        chkBold.setOnAction(e -> setFont());
        chkItalic.setOnAction(e -> setFont());

        // Create the Scene
        Scene scene = new Scene(pane, paneWidth, paneHeight);
        stage.setTitle("Exercise16_14");
        stage.setScene(scene);
        stage.show();
    }

    // This method sets the fonts weight, posture, face, and size
    // according to the user selections
    private void setFont() {
        // Set Font weight according to if bold box is checked or not
        FontWeight weight;
        if(chkBold.isSelected()) {
            weight = FontWeight.BOLD;
        }
        else {
            weight = FontWeight.NORMAL;
        }

        // Set font posture according to if italic box is checked or not
        FontPosture posture;
        if (chkItalic.isSelected()) {
            posture = FontPosture.ITALIC;
        }
        else {
            posture = FontPosture.REGULAR;
        }

        // Set the label with the appropriate user chosen values
        label.setFont(Font.font(cboFontName.getValue(), weight, posture,
                cboFontSize.getValue()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
