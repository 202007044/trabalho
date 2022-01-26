package model;


import LastTower.controller.PlayingController;
import LastTower.model.BuyTower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
public class BuyTowerTest {
    private BuyTower buyTower1;
    private BuyTower buyTower2;
    PlayingController playingController;
    PlayingController playingController2;

    @BeforeEach
    void setUp(){
        buyTower1 = new BuyTower(1,1);
        buyTower2 = new BuyTower(1,1);
        playingController = Mockito.mock(PlayingController.class);
        playingController2 = Mockito.mock(PlayingController.class);
        Mockito.when(playingController.canBuy(1)).thenReturn(true);
        Mockito.when(playingController2.canBuy(1)).thenReturn(false);
    }
    @Test
    void execute(){
        buyTower1.setPlayingController(playingController);
        buyTower2.setPlayingController(playingController2);
        assertTrue(buyTower1.execute());
        assertFalse(buyTower2.execute());
    }
}
