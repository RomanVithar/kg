package vsu.cg.tasks.engine.build_on_figures;

import javafx.scene.Group;
import vsu.cg.tasks.engine.base_figures.Draw;
import vsu.cg.tasks.engine.base_figures.Shape;

import java.util.List;

public class BuildFigures implements Draw {
    private Group parentGroup;
    private List<Shape> shapeList;

    public BuildFigures(Group parentGroup, List<Shape> shapeList) {
        this.parentGroup = parentGroup;
        this.shapeList = shapeList;
    }

    @Override
    public void draw() {

    }
}
