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

public class fiveAttackWater {
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
    private final Button continueButton; // Text to display the stats

    public fiveAttackWater(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("You attacked Mika the Monkey by splashing water.\n" +
                "It was effective, but you wasted 25% of the water and realized you have to conserve it.\n" +
                "You closed the door, trapping Mika the Monkey in the electrical room, while leaving the animatronic broken.\n" +
                "You now know it’s reality and by this time, your objective is to run back to the office.\n" +
                "However, you see Ozzy the Ostrich running towards you, and he’s running towards you fast.\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Initialize the buttons

        oneButton = new Button("Attack with water (25% remaining)");
        twoButton = new Button("Dodge attack");
        threeButton = new Button("Left");
        fourButton = new Button("Middle");
        fiveButton = new Button("Right");
        sixButton = new Button("Continue");
        sevenButton = new Button("Endings");
        continueButton = new Button("Transition to 6 AM");

        // Set initial visibility of some buttons
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
        sevenButton.setVisible(false);
        continueButton.setVisible(false);

        // Button actions
        oneButton.setOnAction(e -> {
            // Update game status text for the twoButton scenario
            updateStats();  // Update the stats text

            // Show the additional choice buttons

            // Hide the other buttons to focus on choices
            sixButton.setVisible(true);
            hideOtherButtons();
        });

        twoButton.setOnAction(e -> {
            // Update game status text for the twoButton scenario
            gameStatus.setText("You slid under Ozzy the Ostrich and you ran as fast as you could, making your way out of the backstage and into the party area.\n" +
                    "However, he’s chasing after you.\n" +
                    "You see the party area and you see 3 rows that determine where you should go past.\n");
            updateStats();  // Update the stats text

            // Show the additional choice buttons
            threeButton.setVisible(true);
            fourButton.setVisible(true);
            fiveButton.setVisible(true);

            // Hide the other buttons to focus on choices
            hideOtherButtons();
        });

        // Action for the threeButton
        threeButton.setOnAction(e -> {
            gameStatus.setText("You successfully dodged Daniel the Dog’s attack. But Ozzy the Ostrich caught up to you.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        // Action for the fourButton
        fourButton.setOnAction(e -> {
            gameStatus.setText("You were attacked…");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            sevenButton.setVisible(true);
            hideMoreButtons();
        });

        // Action for the fiveButton
        fiveButton.setOnAction(e -> {
            gameStatus.setText("You successfully dodged Daniel the Dog’s attack and narrowly avoided Ozzy the Ostrich, as he’s catching up to you.\n" +
                    "Both Daniel the Dog and Ozzy the Ostrich are chasing after you, and you realize that the office would leave you trapped.\n" +
                    "So the best effort is to go to the kitchen and go to the alternative exit.\n" +
                    "You go to the kitchen, and storm to the exit.\n" +
                    "Both Daniel the Dog and Ozzy the Ostrich were narrowing in, and you used your water bottle to splash them.\n" +
                    "You closed the door. It wasn’t 6 AM, but it didn't matter. You drove away.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        // Action for continueButton (transition to the next scene)
        sixButton.setOnAction(e -> primaryStage.setScene(new fiveAttackWaterMore(primaryStage).getScene()));
        sevenButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene()));
        continueButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene()));

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add game status text to the top
        layout.setTop(gameStatus);

        // Add stats text below the game status text
        layout.setBottom(statsText);

        // Create a VBox to arrange buttons vertically
        VBox buttonBox = new VBox(10);  // 10px spacing between buttons
        buttonBox.getChildren().addAll(oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, continueButton);

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
        fiveButton.setVisible(false);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
