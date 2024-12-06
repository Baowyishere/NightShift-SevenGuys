package edu.sdccd.cisc190.altscenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class five1Morning {
    private Scene scene;
    private int conviction; // Variable to track the conviction stat
    private int madness; // Variable to track the madness stat
    private final Text gameStatus;
    private final Text statsText;       // Text to display the stats

    public five1Morning(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("You are tired of these loud noises; still unsure if it’s hallucinations or reality, you just want to turn the power back on.\n" +
                "You keep going to the eerie passageway, and then you see the Generator on the wall.\n" +
                "You rush towards it, and you decide to look at the problem that’s causing the problems of the generator itself.\n" +
                "It’s just a simple problem, you realize that it’s just turned off, so you just switch it back on, and the power turns back on.\n" +
                "You feel relieved. Turn back, you see Mika the Monkey, standing still, getting ready to attack you.\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        // Button actions
        Button oneButton = new Button("Attack with a water bottle (50% remaining)");
        conviction++;
        oneButton.setStyle("-fx-font-size: 14px;");
        oneButton.setOnAction(e -> gameStatus.setText(""));
        oneButton.setOnAction(e -> primaryStage.setScene(new fiveAttackWater(primaryStage).getScene()));

        Button twoButton = new Button("Dodge attack");
        madness++;
        twoButton.setStyle("-fx-font-size: 14px;");
        twoButton.setOnAction(e -> primaryStage.setScene(new fiveDodge(primaryStage).getScene()));

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add game status text to the top
        layout.setTop(gameStatus);

        // Add stats text below the game status text
        layout.setBottom(statsText);

        // Create a VBox to arrange buttons vertically
        VBox buttonBox = new VBox(10);  // 10px spacing between buttons
        buttonBox.getChildren().addAll(oneButton, twoButton);

        // Set the VBox containing buttons to the center of the BorderPane
        layout.setCenter(buttonBox);

        // Scene creation with appropriate size
        scene = new Scene(layout, 400, 400);
    }

    // Method to update the stats text
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
