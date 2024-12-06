package edu.sdccd.cisc190.generalstuff;

import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class MainMenu {
    private final Scene scene;
    private int conviction; // stat for conviction
    private int madness;   // stat for madness

    public MainMenu(Stage primaryStage) {
        conviction = 0;  // Initial conviction
        madness = 0;     // Initial madness

        // Create the buttons
        Button startButton = new Button("Unlock the door");

        // Create the description text
        String descriptionText = "You’re the new guy working in Seven Guys, a local burger shop that on the outside, is a fun and exciting place to eat at, filled with yummy food and a huge-ass party stage with cool party rooms, and of course, the main attraction: The High Fives. But behind closed doors, a different story appears.\n" +
                "\n" +
                "Debts haven't been paid, the kitchen has violated a bunch of health codes and laws, and signs of the animatronics… moving on their own, like they’re being controlled by spirits.\n" +
                "\n" +
                "Maybe they’re linked to the disappearing workers lately… But hey! with the new “Security Computer Auto Machine” (or S.C.A.M for short), they’re able to make sure everything is A-Ok!\n" +
                "\n" +
                "Standing in front of the Burger-plex. You realize you were never given a key to the place. “Lazy managers” you murmured as a note was plastered onto the back entrance. “Yeah we totally forgot to give you the key, it'll be under the rock!”Groaning you grab the key from under the rock and prepare to open the door. Suddenly, the unexplainable urge to do nothing was filling your mind. “Is this a tutorial?” (Pick the options presented to make your choice, choose wisely, well in this case you only have one but, you know, don’t fall too deep~)";

        // Create a TextFlow for the description text
        TextFlow description = new TextFlow();
        for (String paragraph : descriptionText.split("\n\n")) {
            Text text = new Text(paragraph + "\n\n");  // Add line breaks to preserve paragraph structure
            description.getChildren().add(text);
        }

        // Bind the font size of description text to the window size, with limits
        description.styleProperty().bind(Bindings.createStringBinding(() -> {
            double fontSize = Math.max(primaryStage.getWidth() / 50, 12); // Scale based on width, minimum 12
            fontSize = Math.min(fontSize, 24); // Cap the font size to a maximum of 24
            return "-fx-font-size: " + fontSize + "px;";
        }, primaryStage.widthProperty()));

        // Action for unlocking the door: Increase conviction and madness, then transition to PreLude scene
        startButton.setOnAction(e -> {
            conviction += 1;  // Increase conviction
            madness += 1;     // Increase madness

            // Pass conviction and madness to PreLude when transitioning
            PreLude preludeScene = new PreLude(primaryStage, conviction, madness);
            primaryStage.setScene(preludeScene.getScene());
        });

        // Create a text element to display stats
        Text stats = new Text("Conviction: " + conviction + " | Madness: " + madness);

        // Bind the font size of stats text to the window size
        stats.fontProperty().bind(Bindings.createObjectBinding(() ->
                Font.font(Math.max(primaryStage.getWidth() / 50, 14)), primaryStage.widthProperty()));

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Set the description text at the top of the layout
        layout.setTop(description);

        // Set the buttons in the center region
        VBox buttonLayout = new VBox(10, startButton);
        layout.setCenter(buttonLayout);

        // Set stats at the bottom of the layout
        layout.setBottom(stats);

        // Align buttons to center within the center region
        BorderPane.setAlignment(buttonLayout, javafx.geometry.Pos.CENTER);

        // Create the scene with the BorderPane layout and fixed size of 1024x768
        scene = new Scene(layout, 1024, 768);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}