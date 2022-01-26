package LastTower.model;

import java.util.Objects;

public class Blast extends Element {
    private double x;
    private double y;
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getAppearence() {
        return appearence;
    }



}
