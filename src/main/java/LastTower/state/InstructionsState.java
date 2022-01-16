package LastTower.state;


import LastTower.Game;
import LastTower.controller.InstructionsController;
import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.model.MenuButtonCommand;
import LastTower.model.Position;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class InstructionsState extends GameState{

    private InstructionsController instructionsController;

    public InstructionsState(Game game, GUI gui) throws IOException {
        super(game, Arrays.asList());
        instructionsController = new InstructionsController(this,gui);
    }

    @Override
    public void start() {
        game.getKeyBoardObserver().setListener(instructionsController);
        game.getMouseObserver().setListener(instructionsController);
    }

    @Override
    public void step(Game game, long time) throws IOException {
      instructionsController.step();
    }

    public InstructionsController getInstructionsController() {
        return instructionsController;
    }

    public void setInstructionsController(InstructionsController instructionsController) {
        this.instructionsController = instructionsController;
    }
}
