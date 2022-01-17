package LastTower.viewer.state;

import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.model.Position;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoadingLevelViewer extends StateViewer {
    private final int level;

    public LoadingLevelViewer(GUI gui, List<Button> buttons, int level) {
        super(gui, buttons);
        this.level = level;
    }

    @Override
    public void draw() throws IOException {
        gui.clear();
        loading();
        gui.refresh();
    }

    private void drawText(Position position, String text, String backColor, String textColor) {
        gui.drawTitle(position, text, backColor, textColor);
    }

    private void loading() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            drawText(new Position(16, 8), "LOADING...", "#000000", "#FFFFFF");
            int loading = 11;
            drawText(new Position(loading, 11), " ", "#00FF00", "#FFFFFF");
            loading++;

            int counter = 0;
            while (counter <= 100) {
                if (counter <= 10) {
                    drawText(new Position(loading - 3, 11), " " + counter + "%", "#00FF00", "#FFFFFF");
                } else {
                    drawText(new Position(loading - 4, 11), " " + counter+ "%", "#00FF00", "#FFFFFF");
                }

                TimeUnit.MILLISECONDS.sleep(100);

                counter += 6;
                loading++;
                gui.refresh();
            }

            drawText(new Position(loading - 4, 11), " " + 100 + "%", "#00FF00", "#FFFFFF");

            TimeUnit.MILLISECONDS.sleep(100);

            String text1 = "YOU HAVE ARRIVED TO THE";
            String text2 = "LEVEL " + level + "...";
            for(int i = 0; i < text1.length(); i++) {
                drawText(new Position(8 + i, 16), text1.charAt(i) + "", "#000000", "#FFFFFF");
                gui.refresh();
                TimeUnit.MILLISECONDS.sleep(30);
            }

            for(int i = 0; i < text2.length(); i++) {
                drawText(new Position(15 + i, 18), text2.charAt(i) + "", "#000000", "#FFFFFF");
                gui.refresh();
                TimeUnit.MILLISECONDS.sleep(30);
            }
            TimeUnit.MILLISECONDS.sleep(1500);

        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}


