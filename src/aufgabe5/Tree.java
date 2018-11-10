package aufgabe5;

import java.awt.*;

public class Tree {


    static void tree(double x, double y,double w, double gamma){
        if( w >= 1) {

            double delta = Math.toRadians(Math.random()*100);  // Degrees to Radiant
            //double delta = Math.toRadians(30);
            double s = w * Math.sin(gamma);
            double c = w * Math.cos(gamma);
            double v = w * Math.sin(delta);
            double u = w * Math.cos(delta);

            // Berechnung von Punkten
            Point A = new Point(x, y);
            Point B = new Point(x + c, y + s);
            Point C = new Point(x + c - s, y + s + c);
            Point D = new Point(x - s, y + c);
            Point E = new Point(x - s + u * Math.cos(gamma + delta), y + c + u * Math.sin(gamma + delta));
            if(w < 10) {
                StdDraw.setPenColor(StdDraw.GREEN);
                StdDraw.line(A.x, A.y, D.x, D.y);
                StdDraw.line(B.x, B.y, C.x, C.y);
            } else {
                StdDraw.setPenColor(Color.RED);
                StdDraw.line(A.x, A.y, D.x, D.y);
                StdDraw.line(B.x, B.y, C.x, C.y);
            }
            tree(D.x, D.y, u, gamma + delta);
            tree(E.x, E.y, v, gamma + delta - Math.toRadians(90));



        }
    }

    public static void main(String[] args) {
        StdDraw.setXscale(-1000, 1000);
        StdDraw.setYscale(-50, +1000);
        tree(0.0, 0.0, 100.0, Math.toRadians(0));

    }
}
