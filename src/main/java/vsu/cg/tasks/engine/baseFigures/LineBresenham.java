package vsu.cg.tasks.engine.baseFigures;

import javafx.scene.paint.Color;

public class LineBresenham extends Line{

    public LineBresenham(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void drawLine() {
        gContext.setFill(Color.RED);
        double deltax = Math.abs(x2 - x1);
        double deltay = Math.abs(y2 - y1);
        double error = 0d;
        double deltaerr = (deltay + 1) / (deltax + 1);
        double y = y1;
        double diry = y2 - y1;
        if (diry > 0) {
            diry = 1;
        }
        if (diry < 0){
            diry = -1;
        }
        for (double x=x1; x<x2;x++) {
            drawPixel(x,y);
            error=error + deltaerr;
            if (error >= 1.0) {
                y=y + diry;
                error=error - 1.0;
            }
        }
    }
}
