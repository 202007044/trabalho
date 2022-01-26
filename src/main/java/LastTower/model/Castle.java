package LastTower.model;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Objects;

public class Castle extends Element{
    private int health = 10;
    private int coins = 10;
    public Castle(int x, int y) {
        super(new Position(x,y),"#000000");
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoins() {
        return coins;
    }
    public void addCoins(int coins){this.coins+=coins;}

    public void setCoins(int coins) {
        this.coins = coins;
    }
    public void removeCoins(int coins) {
        this.coins -= coins;
    }

    public void monsterDamage(Monster monster){
        this.setHealth(getHealth()-monster.getDamage());
    }

}
