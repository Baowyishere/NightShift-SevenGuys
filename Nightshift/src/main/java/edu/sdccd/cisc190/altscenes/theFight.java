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

public class theFight {
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
    private final Button nineButton;
    private final Button continueButton; // Text to display the stats

    public theFight(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("He wanted you to attack first, but Rumble decided to attack first, and you correctly dodged his attack.\n" +
                "You know it’s a real fight. You arm yourself again. What’s your next move?");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Initialize the buttons

        oneButton = new Button("Attack");
        twoButton = new Button("Dodge");
        threeButton = new Button("Attack");
        fourButton = new Button("Dodge");
        fiveButton = new Button("Leg");
        sixButton = new Button("Arm");
        sevenButton = new Button("Pour the entire water bottle");
        eightButton = new Button("End him");
        nineButton = new Button("Endings");
        continueButton = new Button("Transition to 6 AM");

        // Set initial visibility of some buttons
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
        sevenButton.setVisible(false);
        eightButton.setVisible(false);
        nineButton.setVisible(false);
        continueButton.setVisible(false);

        // Button actions
        oneButton.setOnAction(e -> {
            gameStatus.setText("He knows you’re going to attack, and he counter-attacked it.");
            updateStats();  // Update the stats text

            // Show the additional choice buttons

            // Hide the other buttons to focus on choices
            continueButton.setVisible(true);
            hideOtherButtons();
        });

        twoButton.setOnAction(e -> {
            // Update game status text for the twoButton scenario
            gameStatus.setText("He thinks you’re going to attack, but you decide to dodge, giving more separation between you and Rumble.\n" +
                    "Your next move?");
            updateStats();  // Update the stats text

            // Show the additional choice buttons
            // Hide the other buttons to focus on choices
            threeButton.setVisible(true);
            fourButton.setVisible(true);
            hideOtherButtons();
        });

        // Action for the threeButton
        threeButton.setOnAction(e -> {
            gameStatus.setText("Rumble now thinks you’re going to dodge.\n" +
                    "So he rushes towards you, but you attack him by landing a punch on his jaw.\n" +
                    "Bits of pieces fell off him.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            fiveButton.setVisible(true);
            sixButton.setVisible(true);
            hideMoreButtons();
        });

        // Action for the fourButton
        fourButton.setOnAction(e -> {
            gameStatus.setText("You dodged, and he knows it. He attacked you after you dodged.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        // Action for the fiveButton
        fiveButton.setOnAction(e -> {
            gameStatus.setText("You know that the arm was a bad option as he was still standing, so you attacked the legs to trip him over.\n" +
                    "He loses his balance and trips over. He’s on the ground, and now, what are you going to do now?");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            sevenButton.setVisible(true);
            eightButton.setVisible(true);
            hideEvenMoreButtons();
        });

        sixButton.setOnAction(e -> {
            gameStatus.setText("You were ready to attack the arm. Be he got a hold of you, and with that right arm, he attacked you.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideEvenMoreButtons();
        });

        sevenButton.setOnAction(e -> {
            gameStatus.setText("You poured water on him, and he became disabled. He no longer works.\n" +
                    "After your effort, you decide to go back to the office and lock it until 6 AM.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            nineButton.setVisible(true);
            hideMostButtons();
        });

        eightButton.setOnAction(e -> {
            gameStatus.setText("You tried to end him by stomping on him, but once again, it’s the arm, he counter-attacks you.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            nineButton.setVisible(true);
            hideMostButtons();
        });

        // Action for continueButton (transition to the next scene)
        nineButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene()));
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
        // Hide oneButton and continueButton as needed
    }

    // Hide additional buttons when a choice is made
    private void hideMoreButtons() {
        threeButton.setVisible(false);
        fourButton.setVisible(false);
    }

    private void hideEvenMoreButtons() {
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
    }

    private void hideMostButtons() {
        sevenButton.setVisible(false);
        eightButton.setVisible(false);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
