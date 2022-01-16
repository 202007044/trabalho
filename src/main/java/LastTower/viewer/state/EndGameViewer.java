package LastTower.viewer.state;

import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.model.Position;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EndGameViewer extends StateViewer {
    private final boolean won;

    public EndGameViewer(GUI gui, List<Button> buttons, boolean won) {
        super(gui, buttons);
        this.won = won;
    }

    @Override
    public void draw() throws IOException{
        try {
            gui.drawRectangle(gui.createTextGraphics(), "#000000", 16, 5, new Position(13, 10));
            if (won){gui.drawTitle(new Position(15, 12), "m YOU WON m", "#000000", "#FFFFFF");}
            else {gui.drawTitle(new Position(15, 12), "l YOU LOST l", "#000000", "#FFFFFF");}
            gui.refresh();
            TimeUnit.MILLISECONDS.sleep(3000);
        }catch (Exception e){
            gui.drawTitle(new Position(7, 12), "YOU LOST o", "#000000", "#FFFFFF");
        }
    }
}
