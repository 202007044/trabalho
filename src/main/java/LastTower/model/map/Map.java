package LastTower.model.map;


import LastTower.model.*;

import java.util.*;

public class Map {
    private int round = 0;
    private List<List<Monster>> monsters;
    private List<Tower> towers;
    private List<Position> path;
    public List<Tower> btowers;
    private Castle castle;
    public Map(){
        this.btowers= new ArrayList<Tower>(){};
        this.towers= new ArrayList<Tower>(){};
    }

    public List<Monster> getMonsters() {
        return monsters.get(round);
    }
    public List<List<Monster>> getallMonsters() {
        return monsters;
    }


    public void setMonsters(List<List<Monster>> monsters) {
        this.monsters = monsters;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public List<Position> getTowersposition(){
        List<Position> tpos = new ArrayList<Position>();
        for(Tower tower:towers){
         tpos.add(tower.getPosition());
        }
        return tpos;
    }

    public void setTowers(List<Tower>towers) {
        this.towers=towers;
    }

    public List<Position> getPath() {
        return path;
    }

    public void setPath(List<Position> path) {
        this.path = path;
    }

    public Castle getCastle() {
        return castle;
    }

    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    public void addTower(Tower tower){towers.add(tower);}
    public void queueTower(Tower tower){btowers.add(tower);}

    public List<Tower> getBtowers() {
        return btowers;
    }
    public Tower getlastBtowers() {
        return btowers.get(btowers.size()-1);
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map that = (Map) o;
        return Objects.equals(monsters, that.monsters) && Objects.equals(path, that.path) && Objects.equals(towers, that.towers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monsters, towers, path);
    }
}
