package controller;

import LastTower.Game;
import LastTower.controller.InstructionsController;
import LastTower.controller.MapController;
import LastTower.controller.MonsterController;
import LastTower.controller.TowerController;
import LastTower.gui.GUI;
import LastTower.gui.LanternaGUI;
import LastTower.model.*;
import LastTower.model.map.Map;
import LastTower.state.InstructionsState;
import LastTower.state.MenuState;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class TowerControllerTest {
    Tower tower;
    TowerController towerController;
    Map map;
    MapController mapController;
    List<Monster> monsters = new ArrayList<>();
    @BeforeEach
    void setUp() throws IOException{
        tower = new Tower(0,0,1);
        map = Mockito.mock(Map.class);
        mapController = Mockito.mock(MapController.class);
        towerController = new TowerController(map,mapController);
    }

    @Test
    void shoot(){
        assertNull(tower.getBlast());
        towerController.shoot(tower,new Position(1,1));
        assertNotNull(tower.getBlast());
        assertEquals(Math.PI/4,tower.getBlast().getDegree());
    }
    @Test
    void chooseMonster(){
        monsters.add(new Monster(1,1,1));
        monsters.add(new Monster(50,50,1));
        Position aim = towerController.chooseMonster(tower,monsters);
        assertEquals(aim,new Position(1,1));
    }

    @Test
    void updateBlast(){
        towerController.shoot(tower,new Position(1,1));
        Position firstpos = tower.getBlast().getPosition();
        assertTrue(new Position(0,0).equals(firstpos));
        towerController.updateBlast(tower);
        towerController.updateBlast(tower);
        Position secondpos = tower.getBlast().getPosition();
        assertTrue(new Position(1,1).equals(secondpos));
    }
}

