package state;

import LastTower.Game;
import LastTower.controller.InstructionsController;
import LastTower.gui.GUI;
import LastTower.gui.KeyBoardObserver;
import LastTower.gui.LanternaGUI;
import LastTower.gui.MouseObserver;
import LastTower.state.InstructionsState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class InstructionStateTest {
    private Game game;
    private GUI gui;
    private InstructionsState instructionsState;
    private MouseObserver mouseObserver;
    private KeyBoardObserver keyBoardObserver;
    private InstructionsController instructionsController;

    @BeforeEach
    void setUp() throws IOException {
        game = Mockito.mock(Game.class);
        gui = Mockito.mock(LanternaGUI.class);
        mouseObserver = Mockito.mock(MouseObserver.class);
        keyBoardObserver = Mockito.mock(KeyBoardObserver.class);
        instructionsState = new InstructionsState(game,gui);
        instructionsController = Mockito.mock(InstructionsController.class);
        instructionsState.setInstructionsController(instructionsController);
        Mockito.when(game.getMouseObserver()).thenReturn(mouseObserver);
        Mockito.when(game.getKeyBoardObserver()).thenReturn(keyBoardObserver);
    }

    @Test
    void start(){
        instructionsState.start();
        Mockito.verify(keyBoardObserver, Mockito.times(1)).setListener(instructionsController);
    }

    @Test
    void step() throws IOException{
        instructionsState.step(game,1);
        Mockito.verify(instructionsController, Mockito.times(1)).step();
    }

}
