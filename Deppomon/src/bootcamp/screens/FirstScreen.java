package bootcamp.screens;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Timer;
import java.util.TimerTask;

import static bootcamp.Canvas.CELLSIZE;
import static bootcamp.Canvas.PADDING;

public class FirstScreen extends Screen {

    private Picture backgroundImage;
    private Picture johnnyPixel;
    private Picture press;
    private Picture space;
    private Picture toContinue;
private boolean showPressSpace = true;
    Timer pressSpaceToContinueTimer = new Timer();
    TimerTask pressSpaceToContinueTask = new TimerTask() {
        @Override
        public void run() {
            intermittentPressSpaceToContinue();

        }
    };
    @Override
    public void init() {

        backgroundImage = new Picture(PADDING, PADDING, "1stScreenDeppomontm.png");


        johnnyPixel = new Picture(940, 680, "johnnyPixel.png");
        johnnyPixel.grow(-78, -78);

        press = new Picture(50, 680, "Press-.png");
        space = new Picture(350, 680, "SPACE.png");
        toContinue = new Picture(650, 680, "to-continue-.png");

        backgroundImage.draw();
        johnnyPixel.draw();

        pressSpaceToContinueTimer.scheduleAtFixedRate(pressSpaceToContinueTask,0,500);



    }
private boolean intermittentPressSpaceToContinue(){
        if(showPressSpace){
            drawPressSpaceToContinue();
            return showPressSpace = false;
        }else {
            deletePressSpaceToContinue();
            return showPressSpace = true;
        }
}
    public void drawPressSpaceToContinue() {
        press.draw();
        space.draw();
        toContinue.draw();


    }
    public void deletePressSpaceToContinue(){
        press.delete();
        space.delete();
        toContinue.delete();

    }

    @Override
    public void delete() {
        pressSpaceToContinueTimer.cancel();
        backgroundImage.delete();
        johnnyPixel.delete();
        press.delete();
        space.delete();
        toContinue.delete();


    }
}
