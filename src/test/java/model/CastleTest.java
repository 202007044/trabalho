package model;

import LastTower.model.Castle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CastleTest {
    private Castle castle;

    @BeforeEach
    void setUp(){
        castle = new Castle(1,1);
    }

    @Test
    void addCoins(){
        assertEquals(10,castle.getCoins());
        castle.addCoins(1);
        assertEquals(11,castle.getCoins());
    }
    @Test
    void removeCoins(){
        assertEquals(10,castle.getCoins());
        castle.removeCoins(1);
        assertEquals(9,castle.getCoins());
    }

    @Test
    void monterDamage(){

    }
}
