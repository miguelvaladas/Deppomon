package bootcamp.screens;

import bootcamp.player.JackSparrow;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static bootcamp.Canvas.PADDING;
import static bootcamp.Game.chosenPlayer;

public class FourthScreen extends Screen {

    private Picture johnnyAmber;
    private Picture jackAmber;
    private Picture edwardAmber;
    private static final int PADDING = 10;

    @Override
    public void init() {

        switch (chosenPlayer) {
            case "JackSparrow":
                jackAmber = new Picture(PADDING, PADDING, "4thScreenJackVSAmber.png");
                jackAmber.draw();
                break;

            case "EdwardScissors":
                edwardAmber = new Picture(PADDING, PADDING, "4thScreenEdwardVSAmber.png");
                edwardAmber.draw();
                break;

            case "JohnnyDepp":
                johnnyAmber = new Picture(PADDING, PADDING, "4thScreenJohnnyVSAmber.png");
                johnnyAmber.draw();
        }
    }

    @Override
    public void delete() {

        switch (chosenPlayer) {
            case "JackSparrow":
                jackAmber.delete();
                break;

            case "EdwardScissors":
                edwardAmber.delete();
                break;

            case "JohnnyDepp":
                johnnyAmber.delete();

        }
    }
}