package bootcamp.screens;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Timer;
import java.util.TimerTask;

public class SecondScreen extends Screen {

    private Rectangle rectangle;
    private Picture pressSpace;
    private Picture text1;
    private Picture text2;
    private Picture text3;
    private Picture text4;
    private Picture text5;
    private Picture text6;
    private Picture controls1;
    private Picture controls2;
    private static final int PADDING = 10;

    private boolean showPressSpaceBtn = true;

    Timer pressSpaceTimer = new Timer();
    TimerTask pressSpaceTask = new TimerTask() {
        @Override
        public void run() {
            intermittentPressSpaceButton();
        }
    };

    @Override
    public void init() {

        rectangle = new Rectangle(PADDING, PADDING, 1259, 895);
        rectangle.setColor(Color.BLACK);

        pressSpace = new Picture(475, 750, "2ndScreenPressSpace.png");

        text1 = new Picture(150, 75, "2ndScreentext1.png");
        text2 = new Picture(150, 150, "2ndScreentext2.png");
        text3 = new Picture(150, 200, "2ndScreentext3.png");
        text4 = new Picture(150, 250, "2ndScreentext4.png");
        text5 = new Picture(150, 300, "2ndScreentext5.png");
        text6 = new Picture(150, 375, "2ndScreentext6.png");
        controls1 = new Picture(180, 450, "keys.png");
        controls2 = new Picture(800, 450, "spacebar.png");

        pressSpaceTimer.scheduleAtFixedRate(pressSpaceTask, 500, 500);


        rectangle.fill();

        text1.draw();
        text2.draw();
        text3.draw();
        text4.draw();
        text5.draw();
        text6.draw();
        controls1.draw();
        controls2.draw();
    }

    private boolean intermittentPressSpaceButton() {
        if (showPressSpaceBtn) {
            pressSpace.draw();
            return showPressSpaceBtn = false;
        }
        pressSpace.delete();
        return showPressSpaceBtn = true;
    }

    @Override
    public void delete() {
        pressSpaceTimer.cancel();
        rectangle.delete();
        text1.delete();
        text2.delete();
        text3.delete();
        text4.delete();
        text5.delete();
        text6.delete();
        controls1.delete();
        controls2.delete();
        pressSpace.delete();

    }

}