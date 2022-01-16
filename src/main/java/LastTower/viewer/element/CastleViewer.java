package LastTower.viewer.element;


import LastTower.gui.GUI;
import LastTower.model.Castle;

import static java.lang.Math.max;


public class CastleViewer implements ElementViewer<Castle> {
    @Override
    public void drawElement(Castle element, GUI gui) {
        gui.drawCastle(element.getPosition(), element.getColor());
        gui.drawHUD(max(element.getHealth(),0),element.getCoins());
    }
}
