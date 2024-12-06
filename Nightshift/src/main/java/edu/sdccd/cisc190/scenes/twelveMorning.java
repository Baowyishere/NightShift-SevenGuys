package edu.sdccd.cisc190.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class twelveMorning {
    private final Scene scene;
    private int conviction = 0;   // Variable to track the conviction stat
    private int madness = 0;      // Variable to track the madness stat
    private final Text gameStatus;
    private final Text statsText;       // Text to display the stats

    // Declare buttons as instance variables to use them in different methods
    private final Button oneButton;
    private final Button twoButton;
    private final Button threeButton;
    private final Button continueButton;

    public twelveMorning(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("You've been sitting in your office, playing Brawl Stars, " +
                "ignoring any work because there’s nothing to do besides staring at the ceiling, " +
                "lights on and off, and looking at the animatronics on the SCAM.\nThe clock struck midnight." +
                "\nIn the background, the SCAM flashes statics.\nThat’s important, probably.\n" +
                "Looking closer, your eyes opened wide realizing the stage was missing a person.\n" +
                "Wait... is one of them gone?\nLooking closer, you noticed Chica was gone.\n" +
                "Weird, what should you do?");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Initialize buttons
        oneButton = new Button("Check the cameras (+1 conviction)");
        twoButton = new Button("Ignorance is bliss (+1 conviction, +1 madness)");
        threeButton = new Button("This place is crazy, leave");
        continueButton = new Button("Transition to 1 AM");

        // Set styles for the buttons
        oneButton.setStyle("-fx-font-size: 14px;");
        twoButton.setStyle("-fx-font-size: 14px;");
        threeButton.setStyle("-fx-font-size: 14px;");
        continueButton.setStyle("-fx-font-size: 14px;");

        // Set the continue button to be initially invisible
        continueButton.setVisible(false);

        // Button actions
        oneButton.setOnAction(e -> {
            conviction++;  // Increase conviction
            gameStatus.setText("You’ve decided to check the cameras, from the nearby halls to adjacent rooms from the main stage.\n" +
                    "You find no trace of the missing animatronic, but you were more worried about how the management would react hearing about one of their mascots just disappearing.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideOtherButtons();
        });

        twoButton.setOnAction(e -> {
            conviction++;  // Increase conviction
            madness++;     // Increase madness
            gameStatus.setText("Whatever! The pay wasn’t good in the first place! Besides, you got more important things to do, such as getting that victory in Brawl Stars!\n" +
                    "You got up from your chair and cheered, but it was a short victory as you noticed the animatronic right behind you. *SLASH*");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideOtherButtons();
        });

        threeButton.setOnAction(e -> {
            gameStatus.setText("This place is nuts!\nNo way you’re going to deal with something like this on a late evening, let alone on the FIRST HOUR.\n" +
                    "You prepare to ditch this job without a single care of what will happen next.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideOtherButtons();
        });

        // Action for continueButton to change to next scene
        continueButton.setOnAction(e -> primaryStage.setScene(new oneMorning(primaryStage).getScene()));

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add game status text to the top
        layout.setTop(gameStatus);

        // Add stats text below the game status text
        layout.setBottom(statsText);

        // Add buttons to the layout
        BorderPane.setAlignment(oneButton, javafx.geometry.Pos.CENTER);
        BorderPane.setAlignment(twoButton, javafx.geometry.Pos.CENTER);
        BorderPane.setAlignment(threeButton, javafx.geometry.Pos.CENTER);
        BorderPane.setAlignment(continueButton, javafx.geometry.Pos.CENTER);

        VBox buttonLayout = new VBox(10, oneButton, twoButton, threeButton, continueButton);
        layout.setCenter(buttonLayout);

        // Scene creation with appropriate size
        scene = new Scene(layout, 400, 400);  // Adjusted width for better appearance
    }

    // Method to update the stats text
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness);
    }

    // Helper method to hide the action buttons
    private void hideOtherButtons() {
        oneButton.setVisible(false);
        twoButton.setVisible(false);
        threeButton.setVisible(false);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
