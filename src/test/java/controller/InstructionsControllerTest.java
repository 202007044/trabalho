package controller;

import LastTower.Game;
import LastTower.controller.InstructionsController;
import LastTower.gui.GUI;
import LastTower.gui.LanternaGUI;
import LastTower.model.Button;
import LastTower.model.Command;
import LastTower.state.InstructionsState;
import LastTower.state.MenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

public class InstructionsControllerTest {
    InstructionsController instructionsController;
    InstructionsState instructionsState;
    Game game;
    GUI gui;
    MenuState menuState;
    @BeforeEach
    void setUp() throws IOException {
        game = Mockito.mock(Game.class);
        Mockito.when(game.getHeight()).thenReturn(1);
        Mockito.when(game.getWidth()).thenReturn(1);
        gui = Mockito.mock(LanternaGUI.class);
        instructionsState = Mockito.mock(InstructionsState.class);
        instructionsController = new InstructionsController(instructionsState,gui);
        Mockito.when(instructionsState.getGame()).thenReturn(game);
        menuState = new MenuState(game,gui);
    }
    @Test
    void step(){}
}
