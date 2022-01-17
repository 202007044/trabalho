package model;

import LastTower.model.Tower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TowerTest {
    private Tower tower1;
    private Tower tower2;
    private Tower tower3;

    @BeforeEach
    void setUp(){
        tower1 = new Tower(1,1,1);
        tower2 = new Tower(1,1,2);
        tower3 = new Tower(1,1,3);
    }

    @Test
    void constructor() {
        assertEquals(1,tower1.getDamage());
        assertEquals(1,tower2.getDamage());
        assertEquals(2,tower3.getDamage());

        assertEquals(2,tower1.getRange());
        assertEquals(3,tower2.getRange());
        assertEquals(4,tower3.getRange());

        assertEquals(5,tower1.getPrice());
        assertEquals(7,tower2.getPrice());
        assertEquals(10,tower3.getPrice());

        assertEquals("#FF0000",tower1.getColor());
        assertEquals("#00FF00",tower2.getColor());
        assertEquals("#0000FF",tower3.getColor());
    }






}
