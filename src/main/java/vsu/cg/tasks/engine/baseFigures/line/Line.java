package vsu.cg.tasks.engine.baseFigures.line;

import vsu.cg.tasks.engine.baseFigures.Drawer;
import vsu.cg.tasks.engine.baseFigures.Shape;

public class Line extends Shape implements Drawer {
    protected double x1;
    protected double x2;
    protected double y1;
    protected double y2;

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Line() {
        this(0, 0, 0, 0);
    }

    @Override
    public void draw() {
        int deltax, deltay, error, deltaerr, y, x, diry, dirx;
        deltax = (int) Math.abs(x2 - x1);
        deltay = (int) Math.abs(y2 - y1);
        error = 0;
        if(x2 <x1){
            double mem = x2;
            x2 = x1;
            x1 = mem;
            mem = y2;
            y2 = y1;
            y1 = mem;
        }
        if (deltax > deltay) {
            deltaerr = deltay + 1;
            y = (int) y1;
            diry = (int) (y2 - y1);
            if (diry > 0) {
                diry = PX_SIZE;
            }
            if (diry < 0) {
                diry = -PX_SIZE;
            }
            for (double x0 = x1; x0 < x2; x0+= PX_SIZE) {
                drawPixel(x0, y);
                error = error + deltaerr;
                if (error >= (deltax + 1)) {
                    y += diry;
                    error -= (deltax + 1);
                }
            }
        } else {
            deltaerr = deltax + 1;
            x = (int) x1;
            dirx = (int) (x2 - x1);
            if (dirx > 0) {
                dirx = PX_SIZE;
            }
            if (dirx < 0) {
                dirx = -PX_SIZE;
            }
            if(y2<y1){
                for (double y0 = y1; y0 > y2; y0-= PX_SIZE) {
                    drawPixel(x, y0);
                    error = error + deltaerr;
                    if (error >= (deltay + 1)) {
                        x += dirx;
                        error -= (deltay + 1);
                    }
                }
            }else {
                for (double y0 = y1; y0 < y2; y0+= PX_SIZE) {
                    drawPixel(x, y0);
                    error = error + deltaerr;
                    if (error >= (deltay + 1)) {
                        x += dirx;
                        error -= (deltay + 1);
                    }
                }
            }
        }
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }
}
