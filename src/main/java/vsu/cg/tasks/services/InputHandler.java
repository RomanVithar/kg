package vsu.cg.tasks.services;

import javafx.scene.input.KeyCode;
import vsu.cg.tasks.engine.base_figures.Shape;

import java.util.List;

// обработчик в для перемещения по экрану
public class InputHandler {

    public void camera(KeyCode key, List<Shape> shapeList) {
        int dy = 0;
        int dx = 0;
        if (key == KeyCode.UP) {
            dy += GlobalConstants.CAMERA_SPEED;
        }
        if (key == KeyCode.DOWN) {
            dy -= GlobalConstants.CAMERA_SPEED;
        }
        if (key == KeyCode.LEFT) {
            dx += GlobalConstants.CAMERA_SPEED;
        }
        if (key == KeyCode.RIGHT) {
            dx -= GlobalConstants.CAMERA_SPEED;
        }
        if (dx + dy != 0) {
            for(Shape shape: shapeList) {
                shape.move(dx, dy);
            }
        }
    }
}
