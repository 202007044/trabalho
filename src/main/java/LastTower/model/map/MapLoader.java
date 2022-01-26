package LastTower.model.map;
import LastTower.model.Castle;
import LastTower.model.Monster;
import LastTower.model.Position;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapLoader extends MapBuilder {
    List<Position> path;
    List<List<Monster>> monsters;
    String color;

    Castle castle;
    public MapLoader(int level) throws IOException {
        path =new ArrayList<>();
        monsters = new ArrayList<>();

        File file = new File("src\\main\\resources\\maps\\map"+level+".txt");
        Scanner myReader = new Scanner(file);
        color = myReader.nextLine();
        int pathnumber = myReader.nextInt();
        while (pathnumber!=0) {
            pathnumber--;
            path.add(new Position(myReader.nextInt(), myReader.nextInt()));
        }
        int roundnum = myReader.nextInt();
        while (roundnum!=0) {
            roundnum--;
            List<Monster> roundmonsters = new ArrayList<>();
            int monsternum = myReader.nextInt();
            while(monsternum!=0){
                monsternum--;
                roundmonsters.add(new Monster(myReader.nextInt(),myReader.nextInt(),myReader.nextInt()));
            }
            monsters.add(roundmonsters);
        }
        castle = new Castle(path.get(path.size()-1).getX(),path.get(path.size()-1).getY());
        myReader.close();
    }


    @Override
    protected Castle createCastle() {return castle;}

    @Override
    protected List<Position> createPath() {
     return path;
    }

    @Override
    protected List<List<Monster>> createMonsters() {
        return monsters;
    }

    @Override
    protected String createColor() {
        return color;
    }
}






