package model.map;

import LastTower.model.Castle;
import LastTower.model.map.Map;
import LastTower.model.map.MapLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class MapBuilderTest {
    MapLoader mapLoader;
    Map map;

    @BeforeEach
     void setUp() throws IOException {
            mapLoader = new MapLoader(1);
            map = mapLoader.createMap(1,1);
    }

    @Test
    void createCastle() {
        Castle castle = new Castle(2, 0);
        assertEquals(map.getCastle().getCoins(), castle.getCoins());
        assertEquals(map.getCastle().getPosition(), castle.getPosition());
        assertEquals(map.getCastle().getHealth(), castle.getHealth());
        assertEquals(map.getCastle().getColor(), castle.getColor());
    }
    @Test
    void createPath(){
        assertEquals(68,map.getPath().size());
    }
    @Test
    void createMonsters(){
        assertEquals(2,map.getallMonsters().size());
        assertEquals(7,map.getallMonsters().get(0).size());
        assertEquals(5,map.getallMonsters().get(1).size());

    }
    @Test
    void createColor(){
        assertEquals(map.getColor(),"008013");
    }

}
