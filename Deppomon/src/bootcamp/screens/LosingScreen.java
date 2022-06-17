package bootcamp.screens;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LosingScreen extends Screen{

    private Picture backGround;
    private Picture tryAgain;
    private Picture controls2;
    private int countdown = 3;
    private boolean canMoveToNextScreen = false;
    private boolean showPlayAgain = true;

    Timer playAgainTimer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            intermittentPlayAgain();
        }
    });

    Timer countdownTimer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            countdownAction();
        }
    });

    private static final int PADDING = 10;

    @Override
    public void init() {

        backGround = new Picture(PADDING,PADDING,"youLost.png");
        controls2 = new Picture(465, 560, "spacebar.png");
        controls2.grow(-50,-50);
        tryAgain = new Picture(385, 550, "tryAgain.png");

        backGround.draw();

        playAgainTimer.start();
        countdownTimer.start();
    }

    @Override
    public void delete() {
        backGround.delete();
        tryAgain.delete();
        controls2.delete();
        playAgainTimer.stop();
    }

    private boolean countdownAction(){
        while(countdown != 0) {
            countdown--;
            return false;
        }
        countdown = 3;
        countdownTimer.stop();
        return canMoveToNextScreen = true;
    }

    public boolean getCanMoveToNextScreen(){
        return canMoveToNextScreen;
    }

    private boolean intermittentPlayAgain() {
        if (showPlayAgain) {
            tryAgain.draw();
            controls2.draw();
            return showPlayAgain = false;
        }
        tryAgain.delete();
        controls2.delete();
        return showPlayAgain = true;
    }

}
