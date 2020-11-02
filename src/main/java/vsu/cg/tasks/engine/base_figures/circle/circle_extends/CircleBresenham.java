package vsu.cg.tasks.engine.base_figures.circle.circle_extends;

import javafx.scene.Group;
import vsu.cg.tasks.engine.base_figures.circle.Circle;

public class CircleBresenham extends Circle {

    public CircleBresenham(Group parentGroup, double x1, double y1, double r) {
        super(parentGroup,x1, y1, r);
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
}