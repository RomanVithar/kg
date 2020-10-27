package vsu.cg.tasks.engine.baseFigures.line.line_extends;

import javafx.scene.Group;
import vsu.cg.tasks.engine.baseFigures.line.Line;

public class LineWu extends Line {
    public LineWu(Group parentGroup, double x1, double y1, double x2, double y2) {
        super(parentGroup, x1, y1, x2, y2);
    }

    @Override
    public void draw() {
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
            gradient = dy / dx * PX_SIZE;
            intery = y1 + gradient;
            for (double x = x1; x < x2; x += PX_SIZE) {
                drawPixel(x, (int) intery, 1 - (intery % 1));
                drawPixel(x, (int) (intery) + PX_SIZE, (intery % 1));
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
            gradient = dx / dy * PX_SIZE;
            intery = x1 + gradient;
            for (double y = y1; y < y2; y += PX_SIZE) {
                drawPixel((int) intery, y, 1 - (intery % 1));
                drawPixel((int) (intery) + PX_SIZE, y, (intery % 1));
                intery += gradient;
            }
        }
    }
}
