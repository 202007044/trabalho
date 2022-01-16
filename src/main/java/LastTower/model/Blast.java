package LastTower.model;

import java.util.Objects;

public class Blast extends Element {
    private double x;
    private double y;
    private int speed;
    private int damage;
    private String appearence;
    private double degree;

    public Blast( double x, double y) {
        super(new Position((int)x, (int)y),"#FF0000");
        this.x=x;
        this.y=y;
        this.appearence="p";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getAppearence() {
        return appearence;
    }

    public void setAppearence(String appearence) {
        this.appearence = appearence;
    }

    public void updatePos(){
        this.x+=Math.cos(degree);
        this.y+=Math.sin(degree);
        setPosition(new Position((int)Math.floor(x), (int)Math.floor(y)));
    }

}
