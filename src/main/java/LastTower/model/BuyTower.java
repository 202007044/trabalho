package LastTower.model;

import LastTower.controller.PlayingController;
import LastTower.state.PlayingState;

public class BuyTower implements Command{
    protected PlayingController playingController;
    protected int price;
    protected int type;
    public BuyTower(int price,int type) {
        this.price=price;
        this.type=type;
    }

    @Override
    public boolean execute() {
        if(!playingController.canBuy(price)){return false;}
        else{
            playingController.Buy(price,type);
            return true;
        }
    }

    public void setPlayingController(PlayingController playingController) {
        this.playingController = playingController;
    }

}
