package vsu.cg.tasks.engine.assets;

import javafx.scene.Group;

public class SimpleDrawObject implements DrawObject{
    protected Group holst;

    public SimpleDrawObject() {
        holst = new Group();
    }

    public void putOnGroup(Group group) {
        group.getChildren().addAll(holst);
    }
}
