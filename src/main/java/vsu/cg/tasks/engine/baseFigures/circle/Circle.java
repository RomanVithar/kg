package vsu.cg.tasks.engine.baseFigures.circle;

import vsu.cg.tasks.engine.baseFigures.Drawer;
import vsu.cg.tasks.engine.baseFigures.Shape;

public class Circle  extends Shape implements Drawer {
    protected double x1;
    protected double y1;
    protected double r;

    public Circle(double x1, double y1, double r) {
        this.x1 = x1;
        this.y1 = y1;
        this.r = r;
    }

    public Circle() {
        this(0, 0, 0);
    }

    @Override
    public void draw() {
        int x = 0;
        int y = (int)r;
        int delta = 1 - 2 * (int)r;
        int error = 0;
        while (y >= 0) {
            drawPixel(x1 + x, y1 + y);
            drawPixel(x1 + x, y1 - y);
            drawPixel(x1 - x, y1 + y);
            drawPixel(x1 - x, y1 - y);
            error = 2 * (delta + y) - 1;
            if ((delta < 0) && (error <= 0)){
                delta += 2 * ++x + 1;
                continue;
            }
            if ((delta > 0) && (error > 0)){
                delta -= 2 * --y + 1;
                continue;
            }
            delta +=2 * (++x - --y);
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

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}
