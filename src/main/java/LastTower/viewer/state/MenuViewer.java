package LastTower.viewer.state;


import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.model.Position;
import LastTower.viewer.element.ButtonViewer;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.List;

public class MenuViewer extends StateViewer{

    public MenuViewer(GUI gui, List<Button> buttons) {
        super(gui, buttons);
    }

    @Override
    public void draw() throws IOException {
        gui.clear();
        drawBackground("#14213d");
        drawText(new Position(13,3),"THE LAST TOWER", "#14213d", "#fca311");
        drawButtons(buttons, new ButtonViewer());
        gui.refresh();
    }
    private void drawText(Position position, String text, String backColor, String textColor) {
        gui.drawTitle(position, text, backColor, textColor);
    }
}

