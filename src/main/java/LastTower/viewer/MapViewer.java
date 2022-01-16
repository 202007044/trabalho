package LastTower.viewer;



import LastTower.gui.GUI;
import LastTower.model.Blast;
import LastTower.model.Element;
import LastTower.model.Position;
import LastTower.model.Tower;
import LastTower.model.map.Map;
import LastTower.viewer.element.CastleViewer;
import LastTower.viewer.element.ElementViewer;
import LastTower.viewer.element.MonsterViewer;
import LastTower.viewer.element.TowerViewer;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.List;

public class MapViewer {
    private final GUI gui;
    private final Map map;
    private TextGraphics textGraphics ;


    public MapViewer(GUI gui, Map map) {
        this.gui = gui;
        this.map = map;
        textGraphics= gui.createTextGraphics();
    }

    public void draw() throws IOException {
        gui.clear();
        gui.drawBackground(textGraphics,"#008013");
        for(Position pos : map.getPath()){
            gui.drawPath(pos);
        }
        for(Tower tower : this.map.getTowers()){
            if(tower.getBlast()!=null) {
                gui.drawBlast(tower.getBlast().getPosition(), tower.getColor(), tower.getBlast().getAppearence(), map.getPath());
            }
        }
        drawElements(this.map.getTowers(), new TowerViewer());
        drawElements(this.map.getMonsters(), new MonsterViewer());
        drawElement(this.map.getCastle(), new CastleViewer());
        gui.drawTitle(new Position(15,25),"ROUND: "+ (map.getRound()+1),"#008013","#FFFFFF");
        gui.refresh();
    }

    private <T extends Element> void drawElements(List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(element, viewer);
    }

    private <T extends Element> void drawElement(T element, ElementViewer<T> viewer) {
        viewer.drawElement(element, gui);
    }




}
