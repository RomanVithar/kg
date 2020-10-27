package vsu.cg.tasks.engine.decart;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import vsu.cg.tasks.engine.baseFigures.Shape;
import vsu.cg.tasks.services.GlobalConstants;

public class Axes extends Shape {
    public Axes(Group parentGroup) {
        super(parentGroup);
    }

    @Override
    public void draw() {
        setColor(Color.WHITE);
        if (Math.abs(positionX) < GlobalConstants.SCREEN_WIDTH / 2) {
            for (int i = 0; i < GlobalConstants.SCREEN_HEIGHT; i++) {
                drawPixel(GlobalConstants.SCREEN_WIDTH / 2 + positionX, i);
                drawPixel(GlobalConstants.SCREEN_WIDTH / 2 + positionX + 1, i);
            }
        }
        if (Math.abs(positionY) < GlobalConstants.SCREEN_HEIGHT / 2) {
            for (int i = 0; i < GlobalConstants.SCREEN_WIDTH; i++) {
                drawPixel(i, GlobalConstants.SCREEN_HEIGHT / 2 + positionY);
                drawPixel(i, GlobalConstants.SCREEN_HEIGHT / 2 + 1 + positionY);
            }
        }
    }

    @Override
    protected void drawPixel(double x, double y) {
        super.drawPixel(x-positionX, y-positionY);
    }
}
