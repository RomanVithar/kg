package vsu.cg.tasks.engine.baseFigures.arch.arch_extends;

import vsu.cg.tasks.engine.baseFigures.arch.Arch;

public class ArchBresenham extends Arch {
    public ArchBresenham(double x1, double y1, double l, double h) {
        super(x1, y1, l, h);
    }

    @Override
    public void drawArch() {
        int x = 0;
        int y = (int) h;
        int aSqr = (int) (l * l);
        int bSqr = (int) (h * h);
        int delta = 4 * bSqr * ((x + 1) * (x + 1)) + aSqr * ((2 * y - 1) * (2 * y - 1)) - 4 * aSqr * bSqr;
        while (aSqr * (2 * y - 1) > 2 * bSqr * (x + 1)) {
            drawPixel(x1 + x, y1 - y);
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
            drawPixel(x1 + x, y1 - y);
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
}
