package LastTower.viewer.state;

import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.viewer.element.ButtonViewer;

import java.io.IOException;
import java.util.List;

public class PlayingViewer extends StateViewer{

    public PlayingViewer(GUI gui, List<Button> buttons) {
        super(gui, buttons);
    }

    @Override
    public void draw() throws IOException {
        drawButtons(buttons, new ButtonViewer());
        gui.refresh();
    }
}
