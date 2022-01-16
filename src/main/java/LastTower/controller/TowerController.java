package LastTower.controller;



import LastTower.Game;
import LastTower.model.Blast;
import LastTower.model.Monster;
import LastTower.model.Position;
import LastTower.model.Tower;
import LastTower.model.map.Map;

import java.io.IOException;
import java.util.List;

public class TowerController extends GameController{
    private final MapController mapController;
    private long lastShot;
    private long beginningGame;

    public TowerController(Map map, MapController mapController) {
        super(map);
        this.mapController = mapController;
        this.lastShot = 0;
        this.beginningGame = 0;
    }

    public void step(Game game, long time) throws IOException {
        if(this.lastShot == 0) this.lastShot = time;
        for (Tower tower : getModel().getTowers()) {
            if(tower.getBlast()==null){
                Position aim = chooseMonster(tower,getModel().getMonsters());
                if(aim!=tower.getPosition() && time-lastShot>1000){
                    shoot(tower,aim);
                    lastShot = time;
                }
            }
            else{
                updateBlast(tower);
            }
        }
    }


    public void shoot(Tower tower,Position monsterPos){
        double deltaX = monsterPos.getX()-tower.getPosition().getX();
        double deltaY = monsterPos.getY()-tower.getPosition().getY();
        Blast blast = new Blast(tower.getPosition().getX(),tower.getPosition().getY());
        blast.setDegree(Math.atan2(deltaY, deltaX));
        tower.setBlast(blast);

    }

    public Position chooseMonster(Tower tower, List<Monster> monsters) {
        for(Monster monster : monsters) {
            double dist = Math.sqrt(Math.pow(tower.getPosition().getX()-monster.getPosition().getX(),2)+Math.pow(tower.getPosition().getY()-monster.getPosition().getY(),2));
            if(dist<= tower.getRange()&&monster.isAlive()){
                return monster.getPosition();
            }

        }
        return tower.getPosition();
    }
    public void updateBlast(Tower tower){
        Blast blast = tower.getBlast();
        blast.setX(blast.getX()+Math.cos(blast.getDegree()));
        blast.setY(blast.getY()+Math.sin(blast.getDegree()));
        blast.setPosition(new Position((int)Math.floor(blast.getX()), (int)Math.floor(blast.getY())));
        tower.setBlast(blast);
    }
}