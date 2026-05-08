/*
    Miranda Germain
    April 25, 2023
    Exercise17_11

    This program has a GUI that allows the user to split a file
    into a user-defined number of files
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;

public class Exercise17_11 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Create a borderpane
        BorderPane borderPane = new BorderPane();

        // Create instructions for the GUI app
        Text instructions = new Text(20, 0,
                "If you split a file named temp.txt into 3 smaller files,\n" +
                        "the three smaller files are temp.txt.1, " +
                        "temp.txt.2, and temp.txt.3.");
        borderPane.setTop(instructions); // Set instructions to top of pane.

        // Create a vertical box for different textfields
        VBox paneForTextField = new VBox();

        // Create a borderpane for file name field
        BorderPane fileNamePane = new BorderPane();
        fileNamePane.setLeft(new Label("Enter a file:")); //Set label left
        TextField fileNameField = new TextField(""); // Create textfield
        fileNamePane.setRight(fileNameField); // Set textfield right
        // Add filename pane to vbox
        paneForTextField.getChildren().add(fileNamePane);

        // Create borderpane for number of files textfield
        BorderPane numFilesPane = new BorderPane();
        numFilesPane.setLeft(new Label
                ("Specify the number of smaller files:")); // Set label to left
        TextField numFilesField = new TextField(""); // Create textfield
        numFilesPane.setRight(numFilesField); // Set textfield to right
        // Add numfiles pane to vbox
        paneForTextField.getChildren().add(numFilesPane);

        // Create a Button to control start of program
        BorderPane btnPane = new BorderPane(); // Button BorderPane
        Button startBtn = new Button("Start"); // Create Start Button
        btnPane.setCenter(startBtn); // Set button in the center of pane
        borderPane.setBottom(btnPane);// Set button pane to bottom of main pane

        // Set textfield vbox to main borderpane
        borderPane.setCenter(paneForTextField);

        // Set action when start button is clicked
        startBtn.setOnAction(e -> {
            try {
                // Create buffered input stream using user-defined file
                BufferedInputStream input = new BufferedInputStream
                        (new FileInputStream(fileNameField.getText()));
                // Get number of pieces from numFiles textfield
                int numberOfPieces = Integer.parseInt(numFilesField.getText());

                // Print file size information to the console
                System.out.println("File size: " + input.available()
                        + "bytes");
                // Save filesize in order to split later
                long fileSize = input.available();
                // Split file size into user-defined number of pieces
                int splitFileSize = (int)Math.ceil(1.0 * fileSize / numberOfPieces);

                // For loop that keeps creating pieces of the file until all
                // file pieces have been created
                for(int i = 1; i <= numberOfPieces; i++) {
                    // Create a file with the number of which file it is
                    // appended to end of name
                    BufferedOutputStream output = new BufferedOutputStream
                            (new FileOutputStream(new File
                                    (fileNameField.getText()) + "." + i));

                    int value;
                    int count = 0;

                    // This writes bytes to the individual files until
                    // the necessary byte size is reached
                    while(count++ < splitFileSize &&
                            (value = input.read()) != -1) {
                        output.write(value);
                    }
                    output.close(); // Close output stream
                }
                input.close(); // Close input stream
            }
            // Catch file not found exception and print to console
            catch(FileNotFoundException ex) {
                System.out.println("File does not exist");
            }
            // Catch IOexception and print to console
            catch(IOException ex) {
                System.out.println("Input/Output Exception thrown");
            }
        });

        // Create a scene to hold main borderpane
        Scene scene = new Scene(borderPane, 335, 100);
        stage.setTitle("Exercise 17_11"); // Set stage title
        stage.setScene(scene); // Set stage scene
        stage.show(); // Display stage
    }

    public static void main(String[] args) throws IOException {
        launch(args); // Launch GUI
    }
}