package LastTower.viewer.element;


import LastTower.gui.GUI;
import LastTower.model.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void drawElement(Monster element, GUI gui) {
            gui.drawMonster(element.getPosition(), element.getColor(),element.getApperance());
    }
}
