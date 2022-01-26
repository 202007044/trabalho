package controller;


import LastTower.Game;
import LastTower.controller.MapController;
import LastTower.controller.MenuController;
import LastTower.gui.GUI;
import LastTower.gui.LanternaGUI;
import LastTower.model.*;
import LastTower.model.map.Map;
import LastTower.state.GameState;
import LastTower.state.MenuState;
import LastTower.viewer.state.MenuViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MapControllerTest {
    MapController mapController;
    GameState gameState;
    GUI gui;
    Map map;
    Castle castle;
    List<Monster> monsters;
    List<Tower> towers;

    @BeforeEach
    void setUp() throws IOException{
        towers = new ArrayList<>();
        monsters = new ArrayList<>();
        castle =  new Castle(1,1);
        gameState = Mockito.mock(GameState.class);
        gui = Mockito.mock(GUI.class);
        map = Mockito.mock(Map.class);
        Mockito.when(map.getCastle()).thenReturn(castle);
        Mockito.when(map.getMonsters()).thenReturn(monsters);
        Mockito.when(map.getTowers()).thenReturn(towers);
        mapController = new MapController(gameState,gui,map);
    }
    @Test
    void monsterDamage(){
        assertEquals(10,castle.getHealth());
        monsters.add(new Monster(0,0,1));
        mapController.monsterDamage();
        assertEquals(10,castle.getHealth());
        monsters.add(new Monster(1,1,1));
        mapController.monsterDamage();
        assertEquals(9,castle.getHealth());
    }
    @Test
    void towerBlast(){
        Tower tower = new Tower(2,2,3);
        tower.setBlast(new Blast(1,1));
        Monster monster = new Monster(1,1,1);
        monsters.add(monster);
        towers.add(tower);
        assertEquals(10,castle.getCoins());
        assertNotNull(tower.getBlast());
        assertTrue(monsters.contains(monster));
        mapController.towerBlast();
        assertFalse(monsters.contains(monster));
        assertNull(tower.getBlast());
        assertEquals(11,castle.getCoins());
    }
}

