package vsu.cg.tasks.engine.baseFigures.circle.circle_extends;

import vsu.cg.tasks.engine.baseFigures.circle.Circle;

public class CircleWu extends Circle {
    public CircleWu(double x1, double y1, double r) {
        super(x1, y1, r);
    }

    @Override
    public void drawCircle() {
        int x = 0;
        int y = (int) r;
        int delta = PX_SIZE - 2 * (int) r;
        int error = 0;
        while (y >= 0) {
            System.out.println(delta / (2 * r) % 1);
            drawPixel(x1 + x, y1 + y, (delta / (2 * r)) % 1);
            drawPixel(x1 + x, y1 - y, (delta / (2 * r)) % 1);
            drawPixel(x1 - x, y1 + y, (delta / (2 * r)) % 1);
            drawPixel(x1 - x, y1 - y, (delta / (2 * r)) % 1);

            drawPixel(x1 + x + PX_SIZE, y1 + y + PX_SIZE, 1 - Math.abs(delta / (2 * r)) % 1);
            drawPixel(x1 + x + PX_SIZE, y1 - y - PX_SIZE, 1 - Math.abs(delta / (2 * r)) % 1);
            drawPixel(x1 - x - PX_SIZE, y1 + y + PX_SIZE, 1 - Math.abs(delta / (2 * r)) % 1);
            drawPixel(x1 - x - PX_SIZE, y1 - y - PX_SIZE, 1 - Math.abs(delta / (2 * r)) % 1);

            error = 2 * (delta + y) - PX_SIZE;
            if ((delta < 0) && (error <= 0)) {
                x+=PX_SIZE;
                delta += 2 * x + 1;
                continue;
            }
            if ((delta > 0) && (error > 0)) {
                y-=PX_SIZE;
                delta -= 2 * y + 1;
                continue;
            }
            x+=PX_SIZE;
            y-=PX_SIZE;
            delta += 2 * (x - y);
        }
    }
}
