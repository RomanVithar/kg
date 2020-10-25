package vsu.cg.tasks.engine.baseFigures.ellipse.ellipse_extends;

import vsu.cg.tasks.engine.baseFigures.ellipse.Ellipse;

public class FillEllipse extends Ellipse {
    public FillEllipse(double x1, double y1, double a, double b) {
        super(x1, y1, a, b);
    }

    @Override
    public void drawEllipse() {
        for (double x = - a; x <=  a; x++) {
            for (double y = - b; y <=  b; y++) {
                if ((x / a)*(x / a) + (y / b)*(y / b) - 1 < 0.03) {
                    drawPixel(x1+x, y1+y);
                }
            }
        }
    }
}
