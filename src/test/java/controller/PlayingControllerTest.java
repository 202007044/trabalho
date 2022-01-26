package controller;


import LastTower.Game;
import LastTower.controller.MapController;
import LastTower.controller.MenuController;
import LastTower.controller.PlayingController;
import LastTower.gui.GUI;
import LastTower.gui.LanternaGUI;
import LastTower.model.*;
import LastTower.model.map.Map;
import LastTower.state.GameState;
import LastTower.state.MenuState;
import LastTower.state.PlayingState;
import LastTower.viewer.state.MenuViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import state.GameStateTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayingControllerTest {
    PlayingController playingController;
    PlayingState playingState;
    GUI gui;
    Game game;
    Map map;
    Castle castle;
    List<Tower> queueTowers;

    @BeforeEach
    void setUp() throws IOException{
        queueTowers = new ArrayList<>();
        castle = new Castle(1,1);
        game = Mockito.mock(Game.class);
        Mockito.when(game.getHeight()).thenReturn(1);
        Mockito.when(game.getWidth()).thenReturn(1);
        gui = Mockito.mock(GUI.class);
        map = Mockito.mock(Map.class);
        Mockito.when(map.getBtowers()).thenReturn(queueTowers);
        Mockito.when(map.getCastle()).thenReturn(castle);
        playingState  = new PlayingState(game,gui,1);
        playingController = new PlayingController(playingState,gui,map);
    }

    @Test
    void click() {
        List<Button> buttons = playingState.getButtons();
        Button button = buttons.get(buttons.size()-1);
        BuyTower command = Mockito.mock(BuyTower.class);
        button.setCommand(command);
        playingController.click(button.getPosition());
        Mockito.verify(command, Mockito.times(1)).execute();
    }

    @Test
    void move() {
        List<Button> buttons = playingState.getButtons();
        Button button = buttons.get(buttons.size() - 1);
        playingController.move(button.getPosition());
        Assertions.assertTrue(button.isHighlighted());
    }

    @Test
    void canBuy(){
        assertTrue(playingController.canBuy(5));
        castle.setCoins(1);
        assertFalse(playingController.canBuy(3));
    }

    @Test
    void Buy(){
        assertEquals(10,castle.getCoins());
        playingController.Buy(5,1);
        assertEquals(5,castle.getCoins());
    }

}
