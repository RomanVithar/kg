package vsu.cg.tasks.engine.base_figures.ellipse;

import javafx.scene.Group;
import vsu.cg.tasks.engine.base_figures.Shape;

public class Ellipse extends Shape {
    protected double x1;
    protected double y1;
    protected double a;
    protected double b;


    public Ellipse(Group parentGroup, double x1, double y1, double a, double b) {
        super(parentGroup);
        this.x1 = x1;
        this.y1 = y1;
        this.a = a;
        this.b = b;
    }


    public Ellipse(Group parentGroup) {
        this(parentGroup, 0, 0, 0, 0);
    }

    public void draw() {
        int x = 0;
        int y = (int) b;
        int aSqr = (int) (a * a);
        int bSqr = (int) (b * b);
        int delta = 4 * bSqr * ((x + 1) * (x + 1)) + aSqr * ((2 * y - 1) * (2 * y - 1)) - 4 * aSqr * bSqr;
        while (aSqr * (2 * y - 1) > 2 * bSqr * (x + 1)) {
            drawPixel(x1 + x, y1 + y);
            drawPixel(x1 + x, y1 - y);
            drawPixel(x1 - x, y1 + y);
            drawPixel(x1 - x, y1 - y);
            if (delta < 0) {
                x++;
                delta += 4 * bSqr * (2 * x + 3);
            } else {
                x++;
                delta = delta - 8 * aSqr * (y - 1) + 4 * bSqr * (2 * x + 3);
                y--;
            }
        }
        delta = bSqr * ((2 * x + 1) * (2 * x + 1)) + 4 * aSqr * ((y + 1) * (y + 1)) - 4 * aSqr * bSqr;
        while (y + 1 != 0) {
            drawPixel(x1 + x, y1 + y);
            drawPixel(x1 + x, y1 - y);
            drawPixel(x1 - x, y1 + y);
            drawPixel(x1 - x, y1 - y);
            if (delta < 0) {
                y--;
                delta += 4 * aSqr * (2 * y + 3);
            } else {
                y--;
                delta = delta - 8 * bSqr * (x + 1) + 4 * aSqr * (2 * y + 3);
                x++;
            }
        }
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
