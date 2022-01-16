package LastTower.viewer.element;


import LastTower.gui.GUI;
import LastTower.model.Button;

public class ButtonViewer implements ElementViewer<Button> {

    @Override
    public void drawElement(Button element, GUI gui) {
        gui.drawButton(element.getPosition(), element.getTextPosition(), element.getText(),element.getText2(),
                element.getBgColor(), element.getColor(), element.getWidth(), element.getHeight());
    }
}