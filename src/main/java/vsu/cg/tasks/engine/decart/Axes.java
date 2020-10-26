package vsu.cg.tasks.engine.decart;

import javafx.scene.paint.Color;
import vsu.cg.tasks.engine.baseFigures.Drawer;
import vsu.cg.tasks.engine.baseFigures.Shape;
import vsu.cg.tasks.services.GlobalConstants;

public class Axes extends Shape implements Drawer {
    @Override
    public void draw() {
        setColor(Color.WHITE);
        for (int i = 0; i < GlobalConstants.SCREEN_HEIGHT; i++) {
            drawPixel(GlobalConstants.SCREEN_WIDTH / 2, i);
            drawPixel(GlobalConstants.SCREEN_WIDTH / 2+1, i);
        }
        for (int i = 0; i < GlobalConstants.SCREEN_WIDTH; i++) {
            drawPixel(i, GlobalConstants.SCREEN_HEIGHT / 2);
            drawPixel(i, GlobalConstants.SCREEN_HEIGHT / 2+1);
        }
    }
}
