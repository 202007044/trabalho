package LastTower.model;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Monster extends Element{
    protected boolean alive=true;
    protected int type;
    protected String apperance;
    protected int damage;
    protected int health;
    protected int coins;
    protected int speed;

    public Monster(int x, int y,int type) {
        super(new Position(x,y),"#000000");
        if(type==1){
            this.damage =1;
            this.health = 1;
            this.coins=1;
            this.speed=1;
            this.apperance="a";
            this.setColor("#FF0FF0");
        }
        else if(type==2){
            this.damage =2;
            this.health = 2;
            this.coins=1;
            this.speed=1;
            this.apperance="b";
            this.setColor("#450000");
        }
        else if(type==3){
            this.damage =3;
            this.health = 3;
            this.coins=1;
            this.speed=1;
            this.apperance="c";
            this.setColor("#301637");
        }

    }


    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getApperance() {
        return apperance;
    }

    public void setApperance(String apperance) {
        this.apperance = apperance;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
