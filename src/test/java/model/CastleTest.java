package model;

import LastTower.model.Castle;
import LastTower.model.Element;
import LastTower.model.Monster;
import LastTower.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CastleTest {
    private Castle castle;
    class MonsterStub extends Monster{
        MonsterStub(){
            super(1,1,1);
        }
        @Override
        public int getDamage() {
            return 5;
        }
    }


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
    void monsterDamage(){
        assertEquals(10,castle.getHealth());
        MonsterStub stub = new MonsterStub();
        castle.monsterDamage(stub);
         assertEquals(5,castle.getHealth());
    }
}
