package LastTower.viewer.state;



import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.viewer.element.ButtonViewer;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.List;

public class PauseViewer extends StateViewer{

    public PauseViewer(GUI gui, List<Button> buttons) {
        super(gui, buttons);
    }

    public void draw() throws IOException {
        gui.clear();
        drawBackground("#14213d");
        drawButtons(buttons, new ButtonViewer());

        gui.refresh();
    }


}
