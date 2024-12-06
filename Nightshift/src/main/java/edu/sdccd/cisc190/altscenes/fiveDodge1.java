package edu.sdccd.cisc190.altscenes;


import edu.sdccd.cisc190.generalstuff.ExitGame;
import edu.sdccd.cisc190.scenes.fiveMorning;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class fiveDodge1 {
    private Scene scene;
    private int conviction; // Variable to track the conviction stat
    private int madness; // Variable to track the madness stat
    private final Text gameStatus;
    private final Text statsText;       // Text to display the stats


    // Declare buttons as instance variables to use them in different methods
    private final Button oneButton;
    private final Button twoButton;
    private final Button threeButton;
    private final Button fourButton;
    private final Button continueButton;


    public fiveDodge1(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("Splashing Ozzy the Ostrich with water, allowed him to be disabled, although realizing the amount of water you have, meant that you had to conserve the water, as you only have 25% remaining.\n" +
                "You ran to the main entrance/exit of the Seven Guys but realized something was wrong, the door wouldn’t budge.\n" +
                "This is bad, although you at least know there’s an alternative exit at the Kitchen, your journey is still not over.\n" +
                "You ran past the party area and you went straight to the Kitchen. There you see both Daniel the Dog and Rumble the Racoon.\n" +
                "They’re heading to you on both sides. You have the water, what are you going to do???\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");


        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");


        // Initialize buttons
        oneButton = new Button("Attack Daniel the Dog with water (25% remaining)");
        twoButton = new Button("Attack Rumble the Racoon with water (25% remaining)");
        threeButton = new Button("Dodge");
        fourButton = new Button("End 9 - Death");
        continueButton = new Button("Transition to 6 AM");


        // Set styles for the buttons
        oneButton.setStyle("-fx-font-size: 14px;");
        twoButton.setStyle("-fx-font-size: 14px;");
        threeButton.setStyle("-fx-font-size: 14px;");
        fourButton.setStyle("-fx-font-size: 14px;");
        continueButton.setStyle("-fx-font-size: 14px;");


        // Set the continue button to be initially invisible
        fourButton.setVisible(false);
        continueButton.setVisible(false);


        // Button actions
        oneButton.setOnAction(e -> {
            gameStatus.setText("You disabled Daniel the Dog, but Rumble the Racoon was able to attack you fully.");
            updateStats();  // Update the stats text


            // Show the continue button and hide other buttons
            fourButton.setVisible(true);
            hideOtherButtons();
        });


        twoButton.setOnAction(e -> {
            gameStatus.setText("You disabled Rumble the Racoon, but Daniel the Dog was able to attack you fully.");
            updateStats();  // Update the stats text


            // Show the continue button and hide other buttons
            fourButton.setVisible(true);
            hideOtherButtons();
        });


        threeButton.setOnAction(e -> {
            gameStatus.setText("You dodged their attack, went underneath the table, and rushed towards the door.\n" +
                    "You sense both Daniel the Dog and Rumble the Racoon and once you get to the door and open it, you do a 180 and splash water on them as your final ditch effort, and immediately close the door.\n" +
                    "It wasn’t even 6 AM yet, but you don’t care. You ran towards your car and drove away.");
            updateStats();  // Update the stats text


            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideOtherButtons();
        });
        // Action for continueButton to change to next scene
        fourButton.setOnAction(e -> primaryStage.setScene(new fiveAttackWater(primaryStage).getScene()));
        continueButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene()));


        // Create the BorderPane layout
        BorderPane layout = new BorderPane();


        // Add game status text to the top
        layout.setTop(gameStatus);


        // Add stats text below the game status text
        layout.setBottom(statsText);


        // Create a VBox to arrange buttons vertically
        VBox buttonBox = new VBox(10);  // 10px spacing between buttons
        buttonBox.getChildren().addAll(oneButton, twoButton, threeButton, continueButton);


        // Set the VBox containing buttons to the center of the BorderPane
        layout.setCenter(buttonBox);


        // Scene creation with appropriate size
        scene = new Scene(layout, 400, 400);
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
