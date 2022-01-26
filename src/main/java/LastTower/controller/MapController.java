package LastTower.controller;

import LastTower.Game;
import LastTower.gui.GUI;
import LastTower.model.Castle;
import LastTower.model.Monster;
import LastTower.model.Position;
import LastTower.model.Tower;
import LastTower.model.map.Map;
import LastTower.state.GameState;
import LastTower.viewer.MapViewer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MapController extends GameController {
    private final GameState gameState;
    private final MapViewer mapViewer;
    private final MonsterController monsterController;
    private final TowerController towerController;


    public MapController(GameState gameState, GUI gui, Map map) {
        super(map);
        this.gameState = gameState;
        this.mapViewer = new MapViewer(gui, map);
        this.monsterController = new MonsterController(map,this);
        this.towerController = new TowerController(map,this);

    }

    @Override
    public void step(Game game, long time) throws IOException {
        monsterController.step(game, time);
        towerController.step(game,time);
        monsterDamage();
        towerBlast();
        mapViewer.draw();
    }


    public void monsterDamage(){
        List<Monster> monsters = getModel().getMonsters();
        Castle castle = getModel().getCastle();
        Iterator<Monster> it = monsters.iterator();
        while (it.hasNext()) {
            Monster monster = it.next();
            if(monster.getPosition().equals(castle.getPosition())){
                castle.monsterDamage(monster);
                it.remove();
            }
        }
    }
    public void towerBlast() {
        if(getModel().getTowers()!=null){
            List<Monster> monsters = getModel().getMonsters();
            List<Tower> towers = getModel().getTowers();
            Castle castle = getModel().getCastle();
            for (Tower tower : towers) {
                if(tower.getBlast()!=null){
                    if (tower.getBlast().getPosition().getX()<0||tower.getBlast().getPosition().getX()>26||tower.getBlast().getPosition().getY()<0||tower.getBlast().getPosition().getY()>26){
                        tower.setBlast(null);
                        continue;
                    }
                    Iterator<Monster> it = monsters.iterator();
                    while(it.hasNext()) {
                        Monster monster = it.next();
                        if (tower.getBlast().getPosition().equals(monster.getPosition())) {
                            tower.setBlast(null);
                            monster.hitHealth(tower.getDamage());
                            if (monster.getHealth() <= 0) {
                                castle.addCoins(monster.getCoins());
                                it.remove();
                            }
                            break;
                        }
                    }
                }
            }

        }
    }
}
