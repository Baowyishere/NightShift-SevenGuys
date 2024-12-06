package edu.sdccd.cisc190.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class oneMorning {
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
    private final Button fiveButton;
    private final Button sixButton;
    private final Button continueButton;

    public oneMorning(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("All that excitement, and you’re still bored. " +
                "Back again scrolling through your phone, bored out of your mind, totally doing your job.\n" +
                "After the hour’s… quirky encounters? You’re pretty good. Did you have a choice?\n" +
                "No. Ironic, a game like this doesn’t give you the cho- anyways.\n" +
                "The manager of the place shoved a big old note right on the SCAM.\n" +
                "“Hello? Hello? I’m writing this like I’m speaking to you over the phone.\n" +
                "Imma need you to clean the bathrooms…” You panic over reading that part.\n" +
                "“Yes. Both of them. So good luck.”\n" +
                "Good luck? GOOD LUCK? WHAT. No way, does that imply… whatever.\n" +
                "Finishing the note, “note: if you don’t do this, I’ll terminate you.”\n" +
                "You don’t know what to say to that. So you’ll have to take care of that eventually.\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Initialize buttons
        oneButton = new Button("Actually do your job");
        twoButton = new Button("Procrastinating is nice...");
        threeButton = new Button("Hide under the tables (+1 conviction)");
        fourButton = new Button("Hide behind the arcade machines (+1 madness)");
        fiveButton = new Button("Run out (boom animatronic scares you outside but doesn’t catch you… yet adds madness)");
        sixButton = new Button("Look for other way out (leads you into a vent finding a news paper gaining conviction)");
        continueButton = new Button("Transition to 4 AM");

        // Set styles for the buttons
        oneButton.setStyle("-fx-font-size: 14px;");
        twoButton.setStyle("-fx-font-size: 14px;");
        threeButton.setStyle("-fx-font-size: 14px;");
        fourButton.setStyle("-fx-font-size: 14px;");
        fiveButton.setStyle("-fx-font-size: 14px;");
        sixButton.setStyle("-fx-font-size: 14px;");
        continueButton.setStyle("-fx-font-size: 14px;");

        // Set the continue button to be initially invisible
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
        continueButton.setVisible(false);

        // Button actions
        oneButton.setOnAction(e -> {
            gameStatus.setText("Good choice. Before heading off you check the cameras in case anything nefarious was going on… Nothing. Nice. You head off into the dining area but as you look onto the stage.\n" +
                    "Something was obviously wrong. Missing, for sure you knew. Ozzy and Daniel were gone.\n" +
                    "All you could see was the empty husk of Rumble’s body on stage.\n" +
                    "You hear stomping from the backstage of the establishment. It’s approaching.\n" +
                    "The dining area has an arcade nearby, chairs too.\n" +
                    "Hiding the arcade machine… would seem like a good idea but you’re not a fan of those cobwebs and lack of space.\n" +
                    "Under the tables seems nicer… and what is that… a piece of newspaper? Maybe the table would hold some information about this madness.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            threeButton.setVisible(true);
            fourButton.setVisible(true);
            hideOtherButtons();
        });

        twoButton.setOnAction(e -> {
            madness++;
            gameStatus.setText("Something, maybe you actually make it to the bathrooms. Who cares about what the note on the SCAM says anyways right?\n" +
                    "You looked around for anything interesting, not surprisingly finding some graffiti and doodles in some of the walls and covers.\n" +
                    "One catches your attention however:\n" +
                    "“Merry Jurrell is bitch ass mothe-”\n" +
                    "Hmm… maybe I shouldn’t read that. Uh anyways.\n" +
                    "Picked up some cleaning supplies, and wiped off any signs of the graffiti from the restroom. \n" +
                    "[Obtained 1 Madness]\n" +
                    "Leaving, you realize the doors are locked… from the outside. This night couldn’t get any worse- You’ll need to get out eventually.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            fiveButton.setVisible(true);
            sixButton.setVisible(true);
            hideOtherButtons();
        });

        threeButton.setOnAction(e -> {
            conviction++;
            gameStatus.setText("Quickly crawling under the table, you wait in silence as giant stops fill the room. Anxiously waiting, you grab the newspaper and read it.\n" +
                    "October 12, 20XX - DISAPPEARANCE NOTICES\n" +
                    "\tRecently, two security guards have been missing after working at Seven Guys. They were last seen going to their night shifts. \n" +
                    "After that fiasco you finally arrive in the bathrooms.\n" +
                    "Happens like “procrastinating is nice, choice”\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        fourButton.setOnAction(e -> {
            madness++;
            gameStatus.setText("SO MANY SPIDERS. The animatronic may have passed but your mind didn’t.\n" +
                    "After that fiasco you finally arrive in the bathrooms.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        fiveButton.setOnAction(e -> {
            madness++;
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        sixButton.setOnAction(e -> {
            conviction++;
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        // Action for continueButton to change to next scene
        continueButton.setOnAction(e -> primaryStage.setScene(new fourMorning(primaryStage).getScene()));

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add game status text to the top
        layout.setTop(gameStatus);

        // Add stats text below the game status text
        layout.setBottom(statsText);

        // Create a VBox to arrange buttons vertically
        VBox buttonBox = new VBox(10, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, continueButton);
        layout.setCenter(buttonBox);
        // Set the VBox containing buttons to the center of the BorderPane

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
    }

    private void hideMoreButtons() {
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
