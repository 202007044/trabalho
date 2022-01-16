package LastTower.viewer.element;

import LastTower.gui.GUI;
import LastTower.model.Element;

public interface ElementViewer<T extends Element> {
    void drawElement(T element, GUI gui);
}


