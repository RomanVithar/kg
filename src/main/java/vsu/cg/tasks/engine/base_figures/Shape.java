package vsu.cg.tasks.engine.base_figures;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import vsu.cg.tasks.services.GlobalConstants;

public class Shape implements Draw {
    protected Group parentGroup;
    private GraphicsContext gContext;
    private Color color;
    protected Canvas canvas;
    protected final int PX_SIZE = 1;
    protected double positionX;
    protected double positionY;
    protected boolean isMarkRec;

    protected Shape(Group parentScene) {
        initGroup();
        this.parentGroup = parentScene;
        parentScene.getChildren().addAll(canvas);
        positionX = 0;
        positionY = 0;
        isMarkRec = false;
        color = Color.RED;
    }

    public void draw() {
    }

    public void clear() {
        parentGroup.getChildren().removeAll(canvas);
        initGroup();
        parentGroup.getChildren().addAll(canvas);
    }

    public void setColor(Color color) {
        this.color = color;
        gContext.setFill(this.color);
    }

    protected void drawPixel(double x, double y) {
        // к пикселю добавляются добавочные координаты посиции фигуры(для перемещения)
        // и добавляются координаты центра экрана т.к. центр оси в центре эерана
        gContext.fillRect(x + positionX + GlobalConstants.SCREEN_WIDTH/2,
                positionY + GlobalConstants.SCREEN_HEIGHT/2 - y, PX_SIZE, PX_SIZE);
    }

    public void move(double x, double y) {
        positionX += x;
        positionY += y;
        clear();
        draw();
    }

    protected void initGroup() {
        canvas = new Canvas(GlobalConstants.SCREEN_WIDTH, GlobalConstants.SCREEN_HEIGHT);
        gContext = canvas.getGraphicsContext2D();
        gContext.setFill(color);
    }

    public boolean isMarkRec(){
        return isMarkRec;
    }

    public void setMarkRec(boolean markRec) {
        isMarkRec = markRec;
    }
}
