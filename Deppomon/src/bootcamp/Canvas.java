package bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Canvas {

    private Rectangle canvas;
    public static final int rows = 90;
    public static final int cols = 150;
    public static final int CELLSIZE  = 10;
    public static final int PADDING = 10;

    public Canvas(){
        init();
    }

    public void init(){
        canvas = new Rectangle(PADDING,PADDING,1259,895);
        canvas.setColor(Color.WHITE);
        canvas.draw();
    }
}
