package vsu.cg.tasks.engine.baseFigures;

import javafx.scene.paint.Color;

public class LineDDA extends Line {
    private final int PXSIZE = 5;

    public LineDDA(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void drawLine() {
        gContext.setFill(Color.RED);

        int countStep = (int) Math.round(Math.max(x2 - x1, y2 - y1));
        double dx = (x2-x1)/countStep;
        double dy = (y2-y1)/countStep;

        double x = Math.round(x1);
        double y = Math.round(y1);

        for(int i=0;i<countStep;i++){
            gContext.fillRect(Math.round(x),Math.round(y),PXSIZE,PXSIZE);
            x+=dx;
            y+=dy;
        }
    }
}
