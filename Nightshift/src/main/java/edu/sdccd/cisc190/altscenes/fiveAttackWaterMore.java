package edu.sdccd.cisc190.altscenes;

import edu.sdccd.cisc190.generalstuff.ExitGame;
import edu.sdccd.cisc190.generalstuff.MainMenu;
import edu.sdccd.cisc190.scenes.fiveMorning;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

public class fiveAttackWaterMore {
    private Scene scene;
    private int conviction; // Variable to track the conviction stat
    private int madness; // Variable to track the madness stat
    private final Text gameStatus;
    private final Text statsText;
    private final Button oneButton;
    private final Button twoButton;
    private final Button threeButton;
    private final Button fourButton;
    private final Button fiveButton;
    private final Button sixButton;
    private final Button sevenButton;
    private final Button eightButton;
    private final Button continueButton; // Text to display the stats

    public fiveAttackWaterMore(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("You know that you conserved your water usage, yet decided to attack with water. You wasted 10% of the water on Ozzy the Ostrich; although barely functioning, you’ve at least disabled his ability to move fast.\n" +
                "You got out of the backstage and into the party area.\n" +
                "At the party area, multiple rows of tables guide you to go past the party area to get you back to your office.\n" +
                "There are 3 choices you can go through…\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Initialize the buttons

        oneButton = new Button("Left");
        twoButton = new Button("Middle");
        threeButton = new Button("Right");
        fourButton = new Button("Attack with a water bottle (10% remaining)\n");
        fiveButton = new Button("Attack immediately");
        sixButton = new Button("Dodge attack");
        sevenButton = new Button("Continue");
        eightButton = new Button("Continue");
        continueButton = new Button("Transition to 6 AM");

        // Set initial visibility of some buttons
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
        sevenButton.setVisible(false);
        eightButton.setVisible(false);
        continueButton.setVisible(false);

        // Button actions
        oneButton.setOnAction(e -> {
            gameStatus.setText("You successfully dodged Daniel the Dog’s attack.\n" +
                    "After dodging Daniel the Dog’s attack, you counter-attacked it, by pulling down the banner from the ceiling and covering it on Daniel the Dog, preventing it from seeing.\n" +
                    "You made it past the party area, all you need to do is go back to the office.\n" +
                    "You turn right, and then another right, you spot him.\n" +
                    "The leader, Rumble the Racoon, is ready to beat you.\n" +
                    "You know you have the bottle, but he’d be smart, plus, you need to conserve your water usage.\n" +
                    "You and Rumble are ready to attack. What’s your first move?\n");
            updateStats();  // Update the stats text

            // Show the additional choice buttons

            // Hide the other buttons to focus on choices
            fourButton.setVisible(true);
            fiveButton.setVisible(true);
            sixButton.setVisible(true);
            hideOtherButtons();
        });

        twoButton.setOnAction(e -> {
            // Update game status text for the twoButton scenario
            gameStatus.setText("You were attacked…");
            updateStats();  // Update the stats text

            // Show the additional choice buttons
            // Hide the other buttons to focus on choices
            sevenButton.setVisible(true);
            hideOtherButtons();
        });

        // Action for the threeButton
        threeButton.setOnAction(e -> {
            gameStatus.setText("You were attacked…");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            sevenButton.setVisible(true);
            hideOtherButtons();
        });

        // Action for the fourButton
        fourButton.setOnAction(e -> {
            gameStatus.setText("An unexpected move, Rumble was splashed with water immediately and became un-functional.\n" +
                    "Furthermore, you used all of it, to ensure it remains done.\n" +
                    "You go back to your office, and lock the doors immediately, waiting till 6 AM.\n" +
                    "You wait… and wait… and wait… You still don’t know how you’re still alive, but you are. \n" +
                    "The possessed animatronics got you messed up, mentally and physically.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        // Action for the fiveButton
        fiveButton.setOnAction(e -> {
            gameStatus.setText("He noticed your selflessness.\n" +
                    "He counter-attacked with the final blow to you.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            sevenButton.setVisible(true);
            hideMoreButtons();
        });

        sixButton.setOnAction(e -> {
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            eightButton.setVisible(true);
            hideMoreButtons();
        });

        // Action for continueButton (transition to the next scene)
        sevenButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene()));
        eightButton.setOnAction(e -> primaryStage.setScene(new theFight(primaryStage).getScene()));
        continueButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene()));

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add game status text to the top
        layout.setTop(gameStatus);

        // Add stats text below the game status text
        layout.setBottom(statsText);

        // Create a VBox to arrange buttons vertically
        VBox buttonBox = new VBox(10);  // 10px spacing between buttons
        buttonBox.getChildren().addAll(oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, continueButton);

        // Set the VBox containing buttons to the center of the BorderPane
        layout.setCenter(buttonBox);

        // Scene creation with appropriate size
        scene = new Scene(layout, 400, 400);
    }

    // Method to update the stats text
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness);
    }

    // Hide the irrelevant buttons after the twoButton is pressed
    private void hideOtherButtons() {
        oneButton.setVisible(false);
        twoButton.setVisible(false);
        threeButton.setVisible(false);
        // Hide oneButton and continueButton as needed
    }

    // Hide additional buttons when a choice is made
    private void hideMoreButtons() {
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
