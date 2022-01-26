package state;

import LastTower.Game;
import LastTower.controller.MenuController;
import LastTower.gui.GUI;
import LastTower.gui.LanternaGUI;
import LastTower.gui.MouseObserver;
import LastTower.state.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuStateTest {
 private Game game;
 private GUI gui;
 private MenuState menuState;
 private MouseObserver mouseObserver;
 private MenuController menuController;

 @BeforeEach
 void setUp() throws IOException {
  game = Mockito.mock(Game.class);
  gui = Mockito.mock(LanternaGUI.class);
  mouseObserver = Mockito.mock(MouseObserver.class);
  menuState = new MenuState(game, gui);
  menuController = Mockito.mock(MenuController.class);
  menuState.setMenuController(menuController);
  Mockito.when(game.getMouseObserver()).thenReturn(mouseObserver);
 }

 @Test
 void start(){
  menuState.start();
  Mockito.verify(mouseObserver, Mockito.times(1)).setListener(menuController);
 }

 @Test
 void step() throws IOException{
  menuState.step(game,1);
  Mockito.verify(menuController, Mockito.times(1)).step();
 }

}
