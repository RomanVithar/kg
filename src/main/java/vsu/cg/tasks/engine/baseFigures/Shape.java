package vsu.cg.tasks.engine.baseFigures;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import vsu.cg.tasks.services.GlobalConstants;

public class Shape implements DrawObject {
    protected Group holst;
    protected GraphicsContext gContext;
    protected Color color;
    protected final int PX_SIZE = 1;

    public Shape() {
        holst = new Group();
        Canvas canvas = new Canvas(GlobalConstants.SCREEN_WIDTH, GlobalConstants.SCREEN_HEIGHT);
        gContext = canvas.getGraphicsContext2D();
        holst.getChildren().addAll(canvas);
        gContext.setFill(Color.RED);
        color = Color.RED;
    }

    public void setColor(Color color) {
        this.color = color;
        gContext.setFill(this.color);
    }

    protected void setIntensity(double k) {
        try {
            gContext.setFill(new Color(color.getRed(),
                    color.getGreen(),
                    color.getBlue(),
                    color.getOpacity() * Math.abs(k)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void putOnGroup(Group group) {
        group.getChildren().addAll(holst);
    }

    protected void drawPixel(double x, double y) {
        gContext.fillRect(x, y, PX_SIZE, PX_SIZE);
    }

    protected void drawPixel(double x, double y, double c) {
        setIntensity(c);
        gContext.fillRect(x, y, PX_SIZE, PX_SIZE);
        setIntensity(1);
    }
}
