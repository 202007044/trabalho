package LastTower.viewer.element;


import LastTower.gui.GUI;
import LastTower.model.Blast;
import LastTower.model.Tower;

public class TowerViewer implements ElementViewer<Tower> {
    @Override
    public void drawElement(Tower element, GUI gui) {
        gui.drawTower(element.getPosition(), element.getColor());
    }
}
