package LastTower.controller;


import LastTower.model.map.Map;

public abstract class GameController extends Controller<Map> {
    public GameController(Map map) { super(map); }
}
