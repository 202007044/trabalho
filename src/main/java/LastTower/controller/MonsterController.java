package LastTower.controller;



import LastTower.Game;
import LastTower.model.Monster;
import LastTower.model.Position;
import LastTower.model.map.Map;

import java.io.IOException;

public class MonsterController extends GameController{
    private final MapController mapController;
    private long lastMovement;
    private long beginningGame;

    public MonsterController(Map map, MapController mapController) {
        super(map);

        this.mapController = mapController;
        this.lastMovement = 0;
        this.beginningGame = 0;
    }

    @Override
    public void step(Game game, long time) throws IOException {
        if(this.beginningGame == 0) this.beginningGame = time;
        if (time - lastMovement > 250) {
            for (Monster monster : getModel().getMonsters()) {
                moveMonster(monster);
                this.lastMovement = time;
            }
        }
    }


    private void moveMonster(Monster monster) {
            if(getModel().getPath().contains(monster.getPosition())==false){
                monster.setPosition(new Position(monster.getPosition().getX()+1,monster.getPosition().getY()));
            }
            else if(monster.getPosition()==getModel().getPath().get(getModel().getPath().size()-1)){
            }
            else{
                int index = getModel().getPath().indexOf(monster.getPosition());
                monster.setPosition(getModel().getPath().get(index+1));
            }
    }



}
