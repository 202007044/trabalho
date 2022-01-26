package controller;

import LastTower.Game;
import LastTower.controller.InstructionsController;
import LastTower.controller.MapController;
import LastTower.controller.MonsterController;
import LastTower.gui.GUI;
import LastTower.gui.LanternaGUI;
import LastTower.model.Button;
import LastTower.model.Command;
import LastTower.model.Monster;
import LastTower.model.Position;
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

public class MonsterControllerTest {
    Map map;
    MapController mapController;
    MonsterController monsterController;
    Monster monster;
    List<Position> path;
    @BeforeEach
    void setUp() throws IOException {
        path = new ArrayList<>();
        path.add(new Position(1,0));
        path.add(new Position(1,1));
        monster = new Monster(0,0,1);
        map = Mockito.mock(Map.class);
        mapController = Mockito.mock(MapController.class);
        monsterController = new MonsterController(map,mapController);
        Mockito.when(map.getPath()).thenReturn(path);
    }

    @Test
    void moveMonster(){
        monsterController.moveMonster(monster);
        assertTrue(monster.getPosition().equals(new Position(1,0)));
        monsterController.moveMonster(monster);
        assertTrue(monster.getPosition().equals(new Position(1,1)));

    }
}
