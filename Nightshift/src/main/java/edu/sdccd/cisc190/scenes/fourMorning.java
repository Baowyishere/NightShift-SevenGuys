package edu.sdccd.cisc190.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class fourMorning {
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
    private final Button sevenButton;
    private final Button eightButton;
    private final Button nineButton;
    private final Button continueButton;

    public fourMorning(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("Back in your room, SCAM, running in the back.\n" +
                "With your better judgment, you close the doors, leaving to drain you of your precious power.\n" +
                "But safe… for now. You wanna go home? You didn’t sign up for this. Killer animatronics. How original.\n" +
                "\n" +
                "Now being aware of the dangers that await.\n" +
                "You’re… paranoid. What dangers await you? What lies ahead? More text? More ways to die?\n" +
                "You seem to need a well-deserved break, so you decide to go to the kitchen and check on any foods to eat while at it. " +
                "\nSomehow the walk there was peaceful enough.\n" +
                "Any pizza? Any drinks? Anything to fuel up to at least make me calm. However, more noises come your way while you try to reach for some food.\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Initialize buttons
        oneButton = new Button("Kitchen time");
        twoButton = new Button("Investigate");
        threeButton = new Button("Bottle of water");
        fourButton = new Button("Cold Pizza");
        fiveButton = new Button("Rotten Cheese");
        sixButton = new Button("Investigate");
        sevenButton = new Button("Go Back");
        eightButton = new Button("Investigate");
        nineButton = new Button("Go Back");
        continueButton = new Button("Transition to 5 AM");

        // Set styles for the buttons
        oneButton.setStyle("-fx-font-size: 14px;");
        twoButton.setStyle("-fx-font-size: 14px;");
        threeButton.setStyle("-fx-font-size: 14px;");
        fourButton.setStyle("-fx-font-size: 14px;");
        fiveButton.setStyle("-fx-font-size: 14px;");
        sixButton.setStyle("-fx-font-size: 14px;");
        sevenButton.setStyle("-fx-font-size: 14px;");
        eightButton.setStyle("-fx-font-size: 14px;");
        nineButton.setStyle("-fx-font-size: 14px;");
        continueButton.setStyle("-fx-font-size: 14px;");

        // Set the continue button to be initially invisible
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
            gameStatus.setText("Deciding that the noise is just some random object that is DEFINITELY not part of the noise from the restroom earlier, a need to go to the kitchen seems like the most reasonable choice for you and your break.\n" +
                    "\n" +
                    "You check on the fridge, the fridge contains a bottle of water, cold left-over pizzas, and some rotten cheese. \n" +
                    "\n" +
                    "What’s your poison?\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            threeButton.setVisible(true);
            fourButton.setVisible(true);
            fiveButton.setVisible(true);
            hideOtherButtons();
        });

        twoButton.setOnAction(e -> {
            gameStatus.setText("You go out to the party area, just empty tables, where party hats are just sitting there.\n" +
                    "You realize the sound was just some more fallen objects (coincidence).\n" +
                    "This object was just a Janitor Cart left at the party area just falling over, unfortunately, the Janitor Cart was full of water, so you have no choice but to clean the water up.\n" +
                    "Using the mop from the Janitor Cart that was also fallen, you use the water, to at least clean the entirety of the Party Area floor, because you’re a good worker.\n" +
                    "Thinking that you just did an outstanding job cleaning the floor of the Party Area, you should go back to the office. Having the best time of your life…\n" +
                    "You hear something. The worst part is that you see IT moving. It looks like… Ozzy the Ostrich\n" +
                    "Are you seeing animatronics moving? You want to go back to your office, but in times like this, you must go for an investigation…\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            eightButton.setVisible(true);
            nineButton.setVisible(true);
            hideOtherButtons();
        });

        threeButton.setOnAction(e -> {
            gameStatus.setText("You were thirsty and you drank a lot of water, you saved some for later.\n" +
                    "After your break, you decide it’s best to go back to your office.\n" +
                    "However, once again you hear a noise, while you’re exiting the Kitchen. The fridge, where you originally got the food, was somehow, mysteriously open.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            sixButton.setVisible(true);
            sevenButton.setVisible(true);
            hideMoreButtons();
        });

        fourButton.setOnAction(e -> {
            gameStatus.setText("You warm it up in a microwave, it tastes pretty good, and you restore a lot of energy.\n" +
                    "After your break, you decide it’s best to go back to your office.\n" +
                    "However, once again you hear a noise, while you’re exiting the Kitchen. The fridge, where you originally got the food, was somehow, mysteriously open.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            sixButton.setVisible(true);
            sevenButton.setVisible(true);
            hideMoreButtons();
        });

        fiveButton.setOnAction(e -> {
            gameStatus.setText("IDK why you decided to eat it, but you took one bite, and don’t have the appetizer anymore.\n" +
                    "After your break, you decide it’s best to go back to your office.\n" +
                    "However, once again you hear a noise, while you’re exiting the Kitchen. The fridge, where you originally got the food, was somehow, mysteriously open.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            sixButton.setVisible(true);
            sevenButton.setVisible(true);
            hideMoreButtons();
        });

        sixButton.setOnAction(e -> {
            gameStatus.setText("You slowly approach the kitchen.\n" +
                    "That’s weird, something is eating the food in the fridge.\n" +
                    "Further inspection, it looks like… Rumble the Racoon, you’re not sure though.\n" +
                    "You accidentally stepped on some broken glass, which was still a mess from the kitchen; that thing suddenly closed the fridge and ran.\n" +
                    "It quickly exits the kitchen, but you run for that thing.\n" +
                    "However, it was just gone, you don’t know what it is, all you know is that it resembled Rumble the Racoon.\n" +
                    "Thinking about Rumble the Racoon, you go backstage, verifying the clause of mysterious things happening.\n" +
                    "Seeing all the animatronics in position Daniel the Dog, Mika the Monkey, Ozzy the Ostrich, even Rumble the Racoon, which you swore was in the kitchen earlier.\n" +
                    "You feel like you’re hallucinating, you’re mentally just not well.\n" +
                    "So much so, that even if the energy was enough to calm you down, this was just on another level.\n" +
                    "But you plan to just walk back to the office…\n" +
                    "Bam\n" +
                    "The power went off\n" +
                    "All the energy for nothing, you feel demotivated. But you have your final objective, to turn that power back on. You go backstage.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideEvenMoreButtons();
        });

        sevenButton.setOnAction(e -> {
            gameStatus.setText("While there, you think about the events you’ve witnessed, but one thing, one thing you think about a lot, is the animatronics; you’re not sure if you’re hallucinating or it’s for real, but it makes you think so much.\n" +
                    "You decide to check on your cameras, to give yourself a breather to at least see if everything is indeed normal or not.\n" +
                    "Upon seeing the cameras, everything seems normal…\n" +
                    "Bam\n" +
                    "You realize that the power just went off, fully. There’s only one way to fix it.\n" +
                    "You look at the map, realizing that no place leads to the electrical area, but the obvious place where it would be located is backstage.\n" +
                    "You have no choice, but to go there.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideEvenMoreButtons();
        });

        eightButton.setOnAction(e -> {
            gameStatus.setText("Ozzy the Ostrich moving wasn’t something to be expected from.\n" +
                    "To be fair, it was moving fast, so it could be just something else; but you doubt it.\n" +
                    "You go backstage, seeing that every robot remains in position, Rumble the Racoon, Daniel the Dog, Mika the Monkey, even Ozzy the Ostrich, who you swore was moving earlier, was set in position.\n" +
                    "Mentally, you’re just not okay.\n" +
                    "You feel like you’re seeing hallucinations, but refuse to believe that some lousy animatronics would just suddenly move without being visibly seen.\n" +
                    "However, as you assume that everything is normal, you attempt to go back to the office, and bam, the power goes off.\n" +
                    "You instantly turn to the animatronics, who are at least in their positions yet still skeptical of them.\n" +
                    "Since the power is off, you have no choice but to go backstage. Now, being further displaced from the office, you sometimes just wonder about the layout of this building.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        nineButton.setOnAction(e -> {
            gameStatus.setText("You go back to your office, and just before you do, bam, the power goes off, and now that must mean one thing, to turn the power back on.\n" +
                    "You don’t know if these animatronics are moving, but right now, the focus is just putting back the power on, and going straight back to the office.\n" +
                    "Simple.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        // Action for continueButton to change to next scene
        continueButton.setOnAction(e -> primaryStage.setScene(new fiveMorning(primaryStage).getScene()));

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add game status text to the top
        layout.setTop(gameStatus);

        // Add stats text below the game status text
        layout.setBottom(statsText);

        // Create a VBox to arrange buttons vertically
        VBox buttonBox = new VBox(10);  // 10px spacing between buttons
        buttonBox.getChildren().addAll(oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, continueButton);

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
    }

    private void hideMoreButtons() {
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        eightButton.setVisible(false);
        nineButton.setVisible(false);

    }

    private void hideEvenMoreButtons() {
        sixButton.setVisible(false);
        sevenButton.setVisible(false);
    }

        // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
