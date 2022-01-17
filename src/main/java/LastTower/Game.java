package LastTower;

import LastTower.gui.GUI;
import LastTower.gui.KeyBoardObserver;
import LastTower.gui.LanternaGUI;
import LastTower.gui.MouseObserver;
import LastTower.state.GameState;
import LastTower.state.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.System.exit;

public class Game {
    private final int width;
    private final int height;
    private final int fps;
    private final GUI gui;
    private GameState gameState;
    private final MouseObserver mouseObserver;
    private final KeyBoardObserver keyBoardObserver;

    private static Game singleton = null;

    private Game(int width, int height, int fps) throws IOException, URISyntaxException, FontFormatException {
        this.width = width;
        this.height = height;
        this.fps = fps;
        this.gui = new LanternaGUI(width,height);
        this.mouseObserver = new MouseObserver();
        this.keyBoardObserver = new KeyBoardObserver();
        this.gameState = new MenuState(this, gui);
    }

    public static Game getInstance() throws IOException, URISyntaxException, FontFormatException {
        if (singleton == null) {
            singleton = new Game(26, 26, 30);
        }
        return singleton;
    }

    public void start() throws IOException {
        int frameTime = 1000 / this.fps;
        gui.addMouseListener(mouseObserver);
        gui.addKeyBoardListener(keyBoardObserver);
        this.gameState.start();

        while (gameState != null && gui.isActive()){
            long startTime = System.currentTimeMillis();

            gameState.step(this, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("GAME-ERROR");
            }
        }

        gui.close();
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        if (gameState != null)
            this.gameState.start();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public KeyBoardObserver getKeyBoardObserver() {
        return keyBoardObserver;
    }

    public MouseObserver getMouseObserver() {
        return mouseObserver;
    }
}

class GameEntryPoint {

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        Game game = Game.getInstance();
        game.start();
    }

}
