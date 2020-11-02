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
    private Canvas canvas;
    protected final int PX_SIZE = 1;
    protected double positionX;
    protected double positionY;

    protected Shape(Group parentScene) {
        initGroup();
        this.parentGroup = parentScene;
        parentScene.getChildren().addAll(canvas);
        positionX = 0;
        positionY = 0;
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

    private void setIntensity(double k) {
        try {
            gContext.setFill(new Color(color.getRed(),
                    color.getGreen(),
                    color.getBlue(),
                    color.getOpacity() * Math.abs(k)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void drawPixel(double x, double y) {
        // к пикселю добавляются добавочные координаты посиции фигуры(для перемещения)
        // и добавляются координаты центра экрана т.к. центр оси в центре эерана
        gContext.fillRect(x + positionX + GlobalConstants.SCREEN_WIDTH/2,
                positionY + GlobalConstants.SCREEN_HEIGHT/2 - y, PX_SIZE, PX_SIZE);
    }

    protected void drawPixel(double x, double y, double c) {
        setIntensity(c);
        drawPixel(x, y);
        setIntensity(1);
    }

    public void move(double x, double y) {
        positionX += x;
        positionY += y;
        clear();
        draw();
    }

    private void initGroup() {
        canvas = new Canvas(GlobalConstants.SCREEN_WIDTH, GlobalConstants.SCREEN_HEIGHT);
        gContext = canvas.getGraphicsContext2D();
        gContext.setFill(Color.RED);
        color = Color.RED;
    }
}
