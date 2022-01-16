package LastTower.controller;



import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.model.Position;
import LastTower.state.GameState;
import LastTower.state.MenuState;
import LastTower.state.listener.KeyBoardListener;
import LastTower.state.listener.MouseListener;
import LastTower.viewer.state.InstructionsViewer;
import LastTower.viewer.state.StateViewer;

import java.io.IOException;

public class InstructionsController implements KeyBoardListener, MouseListener {
    private final GameState gameState;
    private final GUI gui;
    private final StateViewer instructionsViewer;

    public InstructionsController (GameState gameState, GUI gui){
        this.gameState = gameState;
        this.gui = gui;
        this.instructionsViewer = new InstructionsViewer(gui, gameState.getButtons());
    }

    public void step() throws IOException {
        instructionsViewer.draw();
    }



    @Override
    public void keyPressed(GUI.ACTION action) {
        if(action == GUI.ACTION.QUIT){
            try{
            gameState.changeState(new MenuState(gameState.getGame(),this.gui));}
            catch (IOException e) {
                e.printStackTrace();
            }
        }
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
