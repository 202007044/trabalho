package state;

import LastTower.Game;
import LastTower.controller.MapController;
import LastTower.controller.PlayingController;
import LastTower.gui.GUI;
import LastTower.gui.KeyBoardObserver;
import LastTower.gui.LanternaGUI;
import LastTower.gui.MouseObserver;
import LastTower.state.PlayingState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class PlayingStateTest {
    private PlayingState playingState;
    private Game game;
    private GUI gui;
    private PlayingController playingController;
    private MouseObserver mouseObserver;
    private KeyBoardObserver keyBoardObserver;
    private MapController mapController;

    @BeforeEach
    void setUp() throws IOException {
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(LanternaGUI.class);
        this.mouseObserver = Mockito.mock(MouseObserver.class);
        this.keyBoardObserver = Mockito.mock(KeyBoardObserver.class);
        this.mapController = Mockito.mock(MapController.class);
        this.playingState = new PlayingState(game, gui, 1);
        this.playingController = Mockito.mock(PlayingController.class);
        this.playingState.setPlayingController(playingController);
        Mockito.when(game.getMouseObserver()).thenReturn(mouseObserver);
        Mockito.when(game.getKeyBoardObserver()).thenReturn(keyBoardObserver);
        Mockito.when(playingController.getMapController()).thenReturn(mapController);
    }

    @Test
    void start() {
        playingState.start();
        Mockito.verify(mouseObserver, Mockito.times(1)).setListener(playingController);
        Mockito.verify(keyBoardObserver, Mockito.times(1)).setListener(playingController);
    }

    @Test
    void step() throws IOException {
        playingState.step(game, 1);
        Mockito.verify(playingController, Mockito.times(1)).step(game,1);
    }

    @Test
    void upLevel() throws IOException{
        playingState.setLevel(1);
        assertTrue(playingState.upLevel());
        playingState.setLevel(2);
        assertFalse(playingState.upLevel());
    }

    @Test
    void upRound() throws IOException{
        assertTrue(playingState.upRound());
        playingState.getMap().setRound(2);
        assertFalse(playingState.upRound());
    }

}
