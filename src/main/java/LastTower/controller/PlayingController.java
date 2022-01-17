package LastTower.controller;


import LastTower.Game;
import LastTower.gui.GUI;
import LastTower.model.Button;
import LastTower.model.BuyTower;
import LastTower.model.Position;
import LastTower.model.Tower;
import LastTower.model.map.Map;
import LastTower.state.*;
import LastTower.state.listener.KeyBoardListener;
import LastTower.state.listener.MouseListener;
import LastTower.viewer.state.EndGameViewer;
import LastTower.viewer.state.LoadingLevelViewer;
import LastTower.viewer.state.PlayingViewer;
import LastTower.viewer.state.StateViewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

public class PlayingController extends GameController implements KeyBoardListener, MouseListener {
    private final GameState gameState;
    private MapController mapController;
    private final GUI gui;
    private final StateViewer playingViewer;
    private long endTime;

    public PlayingController(GameState gameState, GUI gui, Map map) {
        super(map);
        this.gameState = gameState;
        this.gui = gui;
        this.mapController = new MapController(gameState,gui,map);
        this.playingViewer = new PlayingViewer(gui, gameState.getButtons());
        this.endTime = 0;
        setPlayingController();
    }

    public void step(Game game, long time) throws IOException {
            mapController.step(game, time);
            playingViewer.draw();
            if (getModel().getMonsters().isEmpty()) {
                if(((PlayingState) gameState).upRound()){
                    getModel().setRound(getModel().getRound()+1);
                }
                else if (((PlayingState) gameState).upLevel()) {
                    LoadingLevelViewer loadingLevelViewer = new LoadingLevelViewer(gui, null, ((PlayingState) gameState).getLevel());
                    loadingLevelViewer.draw();
                } else {
                    EndGameViewer endGameViewer = new EndGameViewer(gui, null, true);
                    endGameViewer.draw();
                    changeState(new MenuState(this.gameState.getGame(), gui));
                }

            } else if (getModel().getCastle().getHealth() <= 0) {
                EndGameViewer endGameViewer = new EndGameViewer(gui, null, false);
                endGameViewer.draw();
                changeState(new MenuState(this.gameState.getGame(), gui));
            }
            checkButtons();
    }

    private void changeState(GameState gameState){
        this.gameState.changeState(gameState);
    }

    public void endGame(long time) throws IOException {

        if(time - this.endTime > 1500) {
            changeState(new MenuState(this.gameState.getGame(), gui));
        }
    }

    @Override
    public void keyPressed(GUI.ACTION action) {
        if (action == GUI.ACTION.QUIT){
            try {
                changeState(new PauseState(gameState.getGame(), this.gui, this.gameState));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public void click(Position position) {
        boolean buttonclicked = false;
        Position clickedPos = getRealPosition(position,gameState.getGame().getWidth(), gameState.getGame().getHeight());
        for (Button button:gameState.getButtons()){
            Position buttonPos = button.getPosition();
            if (buttonPosition(clickedPos, buttonPos, button.getWidth(), button.getHeight())){
                button.getCommand().execute();
                buttonclicked=true;
            }
        }
        if(!buttonclicked && !getModel().getBtowers().isEmpty()){
            if(!getModel().getPath().contains(clickedPos) && clickedPos.getX()<27 && clickedPos.getY()>1&& !getModel().getTowersposition().contains(clickedPos)){
                Tower tower = getModel().getlastBtowers();
                getModel().getBtowers().remove(tower);
                tower.setPosition(clickedPos);
                getModel().addTower(tower);
            }
        }
        else if(!getModel().getPath().contains(clickedPos) && clickedPos.getX()<27 && clickedPos.getY()>1&& getModel().getTowersposition().contains(clickedPos)){
            for(Tower tower : getModel().getTowers()){
                if(tower.getPosition().equals(clickedPos)){
                    getModel().getCastle().addCoins(tower.getPrice()/2);
                    getModel().getTowers().remove(tower);
                    break;
                }
            }
        }
    }


    @Override
    public void move(Position position) {
        Position currentPosition = getRealPosition(position,gameState.getGame().getWidth(), gameState.getGame().getHeight());
        for(Button button: gameState.getButtons()) {
            Position buttonPos = button.getPosition();
            if(buttonPosition(currentPosition, buttonPos, button.getWidth(), button.getHeight())) {
                button.highlight();
                continue;
            }
            if(button.isHighlighted())
                button.toneDown();
        }
    }

    public void checkButtons() {
        for(Button button: gameState.getButtons()) {
            if(!button.isActive()) continue;
            if (!button.getCommand().execute()) button.deactivate();
        }
    }


    public MapController getMapController() {
        return mapController;
    }

    public void setupModel(Map map) {
        this.mapController = new MapController(gameState,gui,map);
        this.setModel(map);
    }
    public boolean canBuy(int price){
        if(getModel().getCastle().getCoins()>=price){return true;}
        else{return false;}
    }
    public void Buy(int price,int type){
        getModel().getCastle().removeCoins(price);
        getModel().queueTower(new Tower(0,0,type));
    }
    private void setPlayingController() {
        for (Button button: this.gameState.getButtons()){
            if (!(button.getCommand() instanceof BuyTower)) continue;
            BuyTower buytower = (BuyTower) button.getCommand();
            buytower.setPlayingController(this);
        }
    }

}
