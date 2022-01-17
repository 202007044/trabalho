package model;

import LastTower.model.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {
    private Monster monster1;
    private Monster monster2;
    private Monster monster3;

    @BeforeEach
    void setUp(){
        monster1 = new Monster(1,1,1);
        monster2 = new Monster(1,1,2);
        monster3 = new Monster(1,1,3);
    }

    @Test
    void constructor(){
        assertEquals("a",monster1.getApperance());
        assertEquals("b",monster2.getApperance());
        assertEquals("c",monster3.getApperance());

        assertEquals(1,monster1.getCoins());
        assertEquals(2,monster2.getCoins());
        assertEquals(3,monster3.getCoins());

        assertEquals(1,monster1.getDamage());
        assertEquals(2,monster2.getDamage());
        assertEquals(3,monster3.getDamage());

        assertEquals(1,monster1.getHealth());
        assertEquals(2,monster2.getHealth());
        assertEquals(3,monster3.getHealth());

        assertEquals("#FF0FF0",monster1.getColor());
        assertEquals("#450000",monster2.getColor());
        assertEquals("#301637",monster3.getColor());
    }

    @Test
    void hitHealth(){
        monster3.hitHealth(1);
        assertEquals(2,monster3.getHealth());
    }


}
