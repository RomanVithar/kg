package vsu.cg.tasks.engine.baseFigures;

public class LineWu extends Line {
    public LineWu(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void drawLine() {
        double dx, dy, gradient, intery;
        /*
        TODO допилить алгоритм чтобы нормально везде рисовал
         */
        if (x2 < x1) {
            double mem;
            mem = x2;
            x2 = x1;
            x1 = mem;
            mem = y1;
            y1 = y2;
            y2 = mem;
        }
        dx = x2 - x1;
        dy = y2 - y1;
        if (Math.abs(dx) > Math.abs(dy)) {
            gradient = dy / dx * PXSIZE;
            intery = y1 + gradient;
            for (double x = x1; x < x2; x += PXSIZE) {
                drawPixel(x, (int) intery, 1 - (intery % 1));
                drawPixel(x, (int) (intery) + PXSIZE, (intery % 1));
                intery += gradient;
            }
        } else {
            gradient = dx / dy * PXSIZE;
            intery = x1 + gradient;
            if(y1>y2){
                for (double y = y2; y > y1; y -= PXSIZE) {
                    drawPixel((int) intery, y, 1 - (intery % 1));
                    drawPixel((int) (intery) + PXSIZE, y, (intery % 1));
                    intery += gradient;
                }
            }else {
                for (double y = y1; y < y2; y += PXSIZE) {
                    drawPixel((int) intery, y, 1 - (intery % 1));
                    drawPixel((int) (intery) + PXSIZE, y, (intery % 1));
                    intery += gradient;
                }
            }
        }
    }
}
