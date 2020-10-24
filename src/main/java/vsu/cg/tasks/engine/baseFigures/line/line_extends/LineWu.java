package vsu.cg.tasks.engine.baseFigures.line.line_extends;

import vsu.cg.tasks.engine.baseFigures.line.Line;

public class LineWu extends Line {
    public LineWu(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void drawLine() {
        double dx, dy, gradient, intery;
        dx = x2 - x1;
        dy = y2 - y1;
        if (Math.abs(dy) < Math.abs(dx)) {
            if (x2 < x1) {
                double mem = x2;
                x2 = x1;
                x1 = mem;
                mem = y2;
                y2 = y1;
                y1 = mem;
            }
            gradient =dy / dx * PXSIZE;
            intery = y1 + gradient;
            for (double x = x1; x < x2; x += PXSIZE) {
                drawPixel(x, (int) intery, 1 - (intery % 1));
                drawPixel(x, (int) (intery) + PXSIZE, (intery % 1));
                intery += gradient;
            }
        } else {
            if (y2 < y1) {
                double mem = x2;
                x2 = x1;
                x1 = mem;
                mem = y2;
                y2 = y1;
                y1 = mem;
            }
            gradient = dx / dy * PXSIZE;
            intery = x1 + gradient;
            for (double y = y1; y < y2; y += PXSIZE) {
                drawPixel((int) intery, y, 1 - (intery % 1));
                drawPixel((int) (intery) + PXSIZE, y, (intery % 1));
                intery += gradient;
            }
        }
    }
}
