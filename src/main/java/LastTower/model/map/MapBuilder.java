package LastTower.model.map;


import LastTower.model.Castle;
import LastTower.model.Monster;
import LastTower.model.Position;
import LastTower.model.Tower;

import java.util.ArrayList;
import java.util.List;

public abstract class MapBuilder {

    public Map createMap(int width, int height) {
        Map map = new Map();
        map.setCastle(createCastle());
        map.setPath(createPath());
        map.setMonsters(createMonsters());
        map.setTowers(new ArrayList<Tower>());
        return map;
    }

    protected abstract Castle createCastle();

    protected abstract List<Position> createPath();

    protected abstract List<List<Monster>> createMonsters();

    protected abstract List<Tower> createTower();
}








