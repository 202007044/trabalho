package state;

import LastTower.Game;
import LastTower.controller.InstructionsController;
import LastTower.controller.PauseController;
import LastTower.gui.GUI;
import LastTower.gui.LanternaGUI;
import LastTower.gui.MouseObserver;
import LastTower.state.GameState;
import LastTower.state.PauseState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PauseStateTest {
    private Game game;
    private GUI gui;
    private PauseState pauseState;
    private GameState previousState;
    private MouseObserver mouseObserver;
    private PauseController pauseController;

    @BeforeEach
    void setUp() throws IOException {
        game = Mockito.mock(Game.class);
        gui = Mockito.mock(LanternaGUI.class);
        mouseObserver = Mockito.mock(MouseObserver.class);
        previousState = Mockito.mock(GameState.class);
        pauseState = new PauseState(game,gui,previousState);
        pauseController = Mockito.mock(PauseController.class);
        pauseState.setPauseController(pauseController);
        Mockito.when(game.getMouseObserver()).thenReturn(mouseObserver);
    }

    @Test
    void start(){
        pauseState.start();
        Mockito.verify(mouseObserver, Mockito.times(1)).setListener(pauseController);
    }

    @Test
    void step() throws IOException{
        pauseState.step(game,1);
        Mockito.verify(pauseController, Mockito.times(1)).step();
    }
}
