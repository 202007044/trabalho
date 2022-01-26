package LastTower.controller;

import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.model.Position;
import LastTower.state.GameState;
import LastTower.state.listener.*;
import LastTower.viewer.state.MenuViewer;
import LastTower.viewer.state.StateViewer;


import java.io.IOException;

public class MenuController implements MouseListener{
    private final GameState gameState;
    private final StateViewer menuViewer;

    public MenuController(GameState gameState, GUI gui){
        this.gameState = gameState;
        this.menuViewer = new MenuViewer(gui, gameState.getButtons());
        this.gameState.getButtons().get(0).highlight();
    }

    public void step() throws IOException {
        menuViewer.draw();
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
