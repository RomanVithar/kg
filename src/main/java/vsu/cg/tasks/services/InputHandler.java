package vsu.cg.tasks.services;

import javafx.scene.input.KeyCode;
import vsu.cg.tasks.engine.baseFigures.circle.Circle;
import vsu.cg.tasks.engine.decart.Axes;

public class InputHandler {
    public void camera(KeyCode key, Axes axes) {
        int dy = 0;
        int dx = 0;
        if (key == KeyCode.UP) {
            dy += 10;
        }
        if (key == KeyCode.DOWN) {
            dy -= 10;
        }
        if (key == KeyCode.LEFT) {
            dx += 10;
        }
        if (key == KeyCode.RIGHT) {
            dx -= 10;
        }
        if (dx + dy != 0) {
            axes.move(dx, dy);
        }
    }
}
