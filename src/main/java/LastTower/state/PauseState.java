package LastTower.state;

import LastTower.Game;
import LastTower.controller.PauseController;
import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.model.MenuButtonCommand;
import LastTower.model.Position;

import java.io.IOException;
import java.util.Arrays;

public class PauseState extends GameState {
    private PauseController pauseController;

    public PauseState(Game game, GUI gui, GameState previousState) throws IOException {
        super(game, Arrays.asList(
                new Button(new Position(17,7),"RESUME",
                        new MenuButtonCommand(previousState), Arrays.asList("#FFFFFF", "#FFFF00")),
                new Button(new Position(14,14), "EXIT TO MENU",
                        new MenuButtonCommand(new MenuState(game,gui)), Arrays.asList("#FFFFFF", "#FFFF00"))
        ));

        pauseController = new PauseController(this, gui);
    }

    @Override
    public void start() {
        game.getKeyBoardObserver().setListener(pauseController);
        game.getMouseObserver().setListener(pauseController);
    }

    @Override
    public void step(Game game, long time) throws IOException {
        this.pauseController.step();
    }

    public PauseController getPauseController() {
        return pauseController;
    }

    public void setPauseController(PauseController pauseController) {
        this.pauseController = pauseController;
    }
}
