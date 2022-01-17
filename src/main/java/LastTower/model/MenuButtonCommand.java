package LastTower.model;

import LastTower.state.GameState;

import static java.lang.System.exit;

public class MenuButtonCommand implements Command{
    private final GameState nextState;

    public MenuButtonCommand(GameState nextState) {
        this.nextState = nextState;
    }

    @Override
    public boolean execute() {
        if (nextState!=null){nextState.changeState(nextState);}
        else{exit(0);}
        return true;
    }
}
