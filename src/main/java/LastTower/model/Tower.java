package LastTower.model;

import java.util.List;
import java.util.Objects;

public class Tower extends  Element{
    protected int type;
    protected int damage;
    protected int price;
    protected double range;
    private Blast blast;

    public Tower(int x, int y,int type) {
        super(new Position(x,y), "#FFFFFF");
        if(type==1){
            this.damage =1;
            this.range = 2;
            this.price = 5;
            this.setColor("#FF0000");
        }
        else if(type==2){
            this.damage =1;
            this.range = 3;
            this.price = 7;
            this.setColor("#00FF00");
        }
        else if(type==3){
            this.damage =2;
            this.range = 4;
            this.price = 10;
            this.setColor("#0000FF");
        }
        else{
            this.damage = 1;
            this.range = 2;
            this.setColor("#FFFFFF");
        }
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }


    public Blast getBlast() {
        return blast;
    }

    public void setBlast(Blast blast) {
        this.blast = blast;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
