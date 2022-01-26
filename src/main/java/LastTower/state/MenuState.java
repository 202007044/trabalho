package LastTower.state;

import LastTower.Game;
import LastTower.controller.MenuController;
import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.model.MenuButtonCommand;
import LastTower.model.Position;

import java.io.IOException;
import java.util.Arrays;

public class MenuState extends GameState {
    private MenuController menuController;

    public MenuState(Game game, GUI gui) throws IOException {
        super(game, Arrays.asList(
                new Button(new Position(18,7),
                            "PLAY",new MenuButtonCommand(new PlayingState(game,gui,1)),Arrays.asList("#e5e5e5", "#FFFF00")),
                new Button(new Position(14, 14),
                            "INSTRUCTIONS",new MenuButtonCommand(new InstructionsState(game,gui)),Arrays.asList("#e5e5e5", "#FFFF00")),
                new Button(new Position(18,21),
                            "EXIT", new MenuButtonCommand(null), Arrays.asList("#e5e5e5", "#FFFF00"))
        ));

        menuController = new MenuController(this, gui);
    }

    @Override
    public void start() {
        game.getMouseObserver().setListener(menuController);
    }

    @Override
    public void step(Game game, long time) throws IOException {
        this.menuController.step();
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
}
