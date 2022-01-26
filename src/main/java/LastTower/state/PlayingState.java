package LastTower.state;



import LastTower.Game;
import LastTower.controller.PlayingController;
import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.model.BuyTower;
import LastTower.model.Position;
import LastTower.model.Tower;
import LastTower.model.map.Map;
import LastTower.model.map.MapLoader;

import java.io.IOException;
import java.util.Arrays;

public class PlayingState extends GameState {
    private int level;
    private final int maxLevel;
    private PlayingController playingController;
    private Map map;

    public PlayingState(Game game, GUI gui, int level) throws IOException {
        super(game, Arrays.asList(
                new Button(new Position(30,3),new BuyTower(5,1),Arrays.asList("#FF0000", "#FFFF00")),
                new Button(new Position(30,10),new BuyTower(7,2),Arrays.asList("#00FF00", "#FFFF00")),
                new Button(new Position(30,17),new BuyTower(10,3),Arrays.asList("#0000FF", "#FFFF00"))


        ));
        this.level = level;
        this.maxLevel = 2;
        this.map = new MapLoader(level).createMap(game.getWidth(), game.getHeight());
        this.playingController = new PlayingController(this, gui,map);

    }

    @Override
    public void start() {
        game.getKeyBoardObserver().setListener(playingController);
        game.getMouseObserver().setListener(playingController);
    }

    @Override
    public void step(Game game, long time) throws IOException {
        playingController.step(game, time);
    }

    public boolean upLevel() throws IOException {
        if(++level > maxLevel) return false;
        this.map = new MapLoader(level).createMap(game.getWidth(), game.getHeight());
        this.playingController.setupModel(map);
        return true;
    }
    public boolean upRound() throws IOException {
        if(getMap().getRound()+1 > map.getallMonsters().size()-1) return false;
        return true;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PlayingController getPlayingController() {
        return playingController;
    }

    public void setPlayingController(PlayingController playingController) {
        this.playingController = playingController;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
