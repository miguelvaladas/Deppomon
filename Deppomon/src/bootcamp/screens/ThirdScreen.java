package bootcamp.screens;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static bootcamp.Canvas.PADDING;
import static bootcamp.Game.chosenPlayer;

public class  ThirdScreen extends Screen {

    private Rectangle backgroundImage;
    private Picture playerPicture;
    Picture chosenJohnnyPicture;
    private Picture questionMark;
    private Picture mainMessage;
    private boolean canMoveToNextScreen = false;
    private boolean userStartedCarousel = false;

    private Picture[] picturesArray = {new Picture(450, 100, "3rdScreenDeppGRAY.png"), new Picture(450, 100, "3rdScreenEdwardGRAY.png"), new Picture(450, 100, "3rdScreenJackSparrowGRAY.jpg")};

    javax.swing.Timer carouselTimer = new javax.swing.Timer(125, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            playCarousel();
        }
    });

    private int index = 0;

    private int maxPicSwitches = 15;
    private int picSwitchCounter = 0;


    @Override
    public void init() {

        backgroundImage = new Rectangle(PADDING, PADDING, 1259, 895);
        backgroundImage.setColor(Color.BLACK);
        backgroundImage.fill();

        playerPicture = new Picture(450, 100, "3rdScreenTemplate4BLACK.png");

        questionMark = new Picture(600, 300, "3rdScreenQuestionMarkNoBackground.png");
        questionMark.grow(130, 150);
        mainMessage = new Picture(300, 600, "3rdScreenMainMessage.png");

        playerPicture.draw();
        questionMark.draw();
        mainMessage.draw();
    }

    @Override
    public void delete() {
        mainMessage.delete();
        chosenJohnnyPicture.delete();
    }

    public void playJohnnyCarousel() {

        userStartedCarousel = true;
        carouselTimer.start();
    }

    private void playCarousel(){
        if (playerPicture != null) {
            playerPicture.delete();
            playerPicture = null;
        }

        if (questionMark != null) {
            questionMark.delete();
            questionMark = null;
        }

        if (index == 3) {
            index = 0;
        }
        playerPicture = picturesArray[index];
        playerPicture.draw();
        picSwitchCounter++;
        index++;

        if (picSwitchCounter == maxPicSwitches) {
            playerPicture.delete();
            carouselTimer.stop();
            drawCorrectJohnny();
            canMoveToNextScreen = true;
            picSwitchCounter = 0;
        }

    }

    public void drawCorrectJohnny() {
        if (chosenPlayer.equals("JackSparrow")) {
            chosenJohnnyPicture = new Picture(450, 100, "3rdScreenJackSparrowPixel.png");
            chosenJohnnyPicture.draw();
        }
        if (chosenPlayer.equals("EdwardScissors")) {
            chosenJohnnyPicture = new Picture(450, 100, "3rdScreenEdwardCOLOR.png");
            chosenJohnnyPicture.draw();
        }
        if (chosenPlayer.equals("JohnnyDepp")) {
            chosenJohnnyPicture = new Picture(450, 100, "3rdScreenDeppCOLOR.png");
            chosenJohnnyPicture.draw();
        }
    }

    public boolean getCanMoveToNextScreen() {
        return canMoveToNextScreen;
    }

    public boolean getUserStartedCarousel() {
        return userStartedCarousel;
    }

    public void setUserStartedCarousel(boolean trueOrFalse){
        userStartedCarousel = trueOrFalse;
    }
    public void setCanMoveToNextScreen(boolean trueOrFalse){
        canMoveToNextScreen = trueOrFalse;
    }
}
