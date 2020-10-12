package vsu.cg.tasks.engine.baseFigures;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import vsu.cg.tasks.engine.interfaces.LineDrawer;
import vsu.cg.tasks.engine.services.SimpleDrawObject;

public class Line extends SimpleDrawObject implements LineDrawer{
    protected double x1;
    protected double x2;
    protected double y1;
    protected double y2;
    protected GraphicsContext gContext;
    protected final int PXSIZE = 1;

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        Canvas canvas = new Canvas(10000,10000);
        gContext = canvas.getGraphicsContext2D();
        holst.getChildren().addAll(canvas);
    }

    public Line(){
        this(0,0,0,0);
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

    @Override
    public void drawLine() {

    }
    protected void drawPixel(double x, double y){
        gContext.fillRect(x,y,PXSIZE,PXSIZE);
    }
}
