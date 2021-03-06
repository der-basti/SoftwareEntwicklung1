package sne.exercise.sheet08;

import StdLib.StdDraw;
import java.awt.Color;
import java.awt.Font;

/**
 * Schreiben Sie ein Programm, welches die folgenden Formen grafisch darstellt. 
 * Wählen Sie eine geeignete Abstraktion zur Vereinfachung der Zeichnung, 
 * z.B. können Sie ein Herz aus einer Verbindung von Rhombus und zwei Kreisen erstellen.
 * 
 * @author sne
 */
public class Task1 {

    public static void main(String[] foo) {

        StdDraw.setXscale(-10, 10);
        StdDraw.setYscale(-10, 10);

        // FIXME [sne] re-engineer karo und herz
        
        // xmin, xmax, ymin, ymax
        pik(); // -10,0 , 0,10
        karo(); // -10,0 , 0,-10
        herz(); // 0,10 , 0,10
        kreuz(); // 0,10 , 0,-10
        
        //quickAndDirty();
    }

    private static void quickAndDirty() {

        StdDraw.setFont(new Font("Arial", 300, 300));
        StdDraw.text(-5, 5, "♠");
        StdDraw.text(5, -5, "♣");
        StdDraw.setPenColor(Color.RED);
        StdDraw.text(5, 5, "♥");
        StdDraw.text(-5, -5, "♦");
    }

    protected static void pik() {

        // ground
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledRectangle(-5, 5, 2, 2);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledCircle(-7, 5, 2);
        StdDraw.filledCircle(-3, 5, 2);
        StdDraw.filledRectangle(-5, 7, 2, 1);

        // fliped herz
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledCircle(-6, 5.8, 1.3);
        StdDraw.filledCircle(-4, 5.8, 1.3);
        double[] x = {-7.2, -5, -2.7, -5};
        double[] y = {6, 6, 6, 9};
        StdDraw.filledPolygon(x, y);

        // 2x²-2xy+y²-1=0 | x <= 0
        // 2x²+2xy+y²-1=0 | x <= 0
        // y=|x|+sqrt(1-x²)
        // y=|x|-sqrt(1-x²)
    }

    protected static void karo() {
        
        /*double[] x = {-5, -8, -5, -2};
        double[] y = {-.5, -4, -7.5, -4};
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledPolygon(x, y);*/
        sne.exercise.sheet10.Task2.diamond(-5, -5, 6.5, 5.0);
    }

    protected static void herz() {

        /*StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(6.4, 7, 1.5);
        StdDraw.filledCircle(3.6, 7, 1.5);
        double[] x = {7.8, 5, 2.2, 5};
        double[] y = {6.6, 6.6, 6.6, 2};
        StdDraw.filledPolygon(x, y);*/
        
        double x = 5;
        double y = 5;
        double height = 6.5;
        double width = 5;
        StdDraw.setPenColor(Color.RED);
        
        sne.exercise.sheet10.Task2.diamond(x, y, height, width);
        
        double r = (Math.sqrt( (Math.pow(2, height/2) + Math.pow(2, width/2)) )) / 2;
        StdDraw.filledCircle(x - (width/4), y + (height / 4), r);
        
        StdDraw.filledCircle(x + (width/4), y + (height / 4), r);
    }

    protected static void kreuz() {
        
        // ground
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledRectangle(5, -5, 2, 2);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledCircle(7, -5, 2);
        StdDraw.filledCircle(3, -5, 2);
        StdDraw.filledRectangle(5, -3, 2, 1.5);
        
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledCircle(6, -4.3, 1.3);
        StdDraw.filledCircle(4, -4.3, 1.3);
        StdDraw.filledCircle(5, -2.3, 1.3);
    }
}
