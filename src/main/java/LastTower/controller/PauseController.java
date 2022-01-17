package LastTower.controller;


import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.model.Position;
import LastTower.state.GameState;
import LastTower.state.listener.KeyBoardListener;
import LastTower.state.listener.MouseListener;
import LastTower.viewer.state.PauseViewer;
import LastTower.viewer.state.StateViewer;

import java.io.IOException;

public class PauseController implements MouseListener {
    private final GameState gameState;
    private final StateViewer pauseViewer;

    public PauseController(GameState gameState, GUI gui){
        this.gameState = gameState;
        this.pauseViewer = new PauseViewer(gui, gameState.getButtons());
        gameState.getButtons().get(0).highlight();
    }

    public void step() throws IOException {
        pauseViewer.draw();
    }

    @Override
    public void click(Position position) {
        Position clickedPos = getRealPosition(position,gameState.getGame().getWidth(), gameState.getGame().getHeight());
        for (Button button:gameState.getButtons()){
            Position buttonPos = button.getPosition();
            if (buttonPosition(clickedPos, buttonPos, button.getWidth(), button.getHeight())){
                button.getCommand().execute();
            }
        }
    }



    @Override
    public void move(Position position) {
        Position currentPosition = getRealPosition(position,gameState.getGame().getWidth(), gameState.getGame().getHeight());
        for(Button button: gameState.getButtons()) {
            Position buttonPos = button.getPosition();
            if(buttonPosition(currentPosition, buttonPos, button.getWidth(), button.getHeight())) {
                button.highlight();
                continue;
            }
            if(button.isHighlighted())
                button.toneDown();
        }
    }
}
