package model.map;

import LastTower.model.Tower;
import LastTower.model.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    private Map map;

    @BeforeEach
    void setUp(){
        map = new Map();
    }
    @Test
    void addTower(){
        Tower tower = new Tower(1,1,1);
        assertFalse(map.getTowers().contains(tower));
        map.addTower(tower);
        assertTrue(map.getTowers().contains(tower));
    }
    @Test
    void queueTower(){
        Tower tower = new Tower(1,1,1);
        assertFalse(map.getBtowers().contains(tower));
        map.queueTower(tower);
        assertTrue(map.getBtowers().contains(tower));
    }

}
