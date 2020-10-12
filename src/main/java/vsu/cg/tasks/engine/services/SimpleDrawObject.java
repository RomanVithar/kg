package vsu.cg.tasks.engine.services;

import javafx.scene.Group;
import vsu.cg.tasks.engine.interfaces.DrawObject;

public class SimpleDrawObject implements DrawObject {
    protected Group holst;

    public SimpleDrawObject() {
        holst = new Group();

    }

    public void putOnGroup(Group group) {
        group.getChildren().addAll(holst);
    }
}
