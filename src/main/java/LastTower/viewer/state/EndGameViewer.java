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

            if (won){
                gui.drawRectangle(gui.createTextGraphics(), "#14213d", 15, 5, new Position(13, 10));
                gui.drawTitle(new Position(15, 12), "m YOU WON m", "#14213d", "#D4AF37");}
            else {
                gui.drawRectangle(gui.createTextGraphics(), "#14213d", 16, 5, new Position(13, 10));
                gui.drawTitle(new Position(15, 12), "l YOU LOST l", "#14213d", "#FFFFFF");}
            gui.refresh();
            TimeUnit.MILLISECONDS.sleep(3000);
        }catch (Exception e){
            gui.drawTitle(new Position(15, 12), "ERROR", "#000000", "#FF0000");
        }
    }
}
