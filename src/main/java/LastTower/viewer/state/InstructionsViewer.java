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
import java.util.Arrays;
import java.util.List;

public class InstructionsViewer extends StateViewer {

    public InstructionsViewer(GUI gui, List<Button> buttons) {
        super(gui, buttons);
    }

    @Override
    public void draw() throws IOException {
        gui.clear();
        drawBackground("#14213d");
        drawText(new Position(13,2),"INSTRUCTIONS", "#14213d", "#FFFFFF");
        drawText(new Position(8,5),"WAVES OF MONSTERS WILL", "#14213d", "#FFFFFF");
        drawText(new Position(8,7),"TRY TO ENTER THE REIGN.", "#14213d", "#FFFFFF");
        drawText(new Position(7,9),"LEFT CLICK", "#14213d", "#fca311");
        drawText(new Position(18,9),"ON THE SHOP ON", "#14213d", "#FFFFFF");
        drawText(new Position(6,11),"THE RIGHT TO BUY TOWERS AND", "#14213d", "#FFFFFF");
        drawText(new Position(7,13),"LEFT CLICK", "#14213d", "#fca311");
        drawText(new Position(18,13),"IN A FREE SPACE", "#14213d", "#FFFFFF");
        drawText(new Position(6,15),"TO PLACE THE DEFENDING TOWER.", "#14213d", "#FFFFFF");
        drawText(new Position(9,17),"ESC", "#14213d", "#fca311");
        drawText(new Position(13,17),"TO PAUSE THE GAME.", "#14213d", "#FFFFFF");
        drawText(new Position(17,20),"GL HF", "#14213d", "#e0fc11");
        drawText(new Position(13,22),"ESC", "#14213d", "#fca311");
        drawText(new Position(17,22),"TO RETURN", "#14213d", "#fca311");
        drawButtons(buttons, new ButtonViewer());
        gui.refresh();
}
    private void drawText(Position position, String text, String backColor, String textColor) {
        gui.drawTitle(position, text, backColor, textColor);
    }

}


