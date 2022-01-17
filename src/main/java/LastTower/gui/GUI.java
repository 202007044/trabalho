package LastTower.gui;

import LastTower.model.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.List;


public interface GUI {

    enum ACTION {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        SHOP,
        QUIT
    }

    TextGraphics createTextGraphics();

    int getWidth();

    int getHeight();

    void drawRectangle(TextGraphics textGraphics, String color, int width, int height, Position pos);

    void drawBackground(TextGraphics textGraphics, String color);

    void clear() throws IOException;

    void refresh() throws IOException;

    void close() throws IOException;

    void addMouseListener(MouseObserver obs);

    void addKeyBoardListener(KeyBoardObserver obs);

    boolean isActive();

    void drawCastle(Position position, String color);

    void drawTower(Position position, String color);

    void drawPath(Position position);

    void drawBlast(Position position, String elementColor, String character, List<Position> path);

    void drawButton(Position bPos, Position tPos, String text,String text2, String bgColor, String textColor, int width, int height);

    void drawMonster(Position position, String color,String apperance);

    void drawTitle(Position position, String text, String color, String colorText);
    void drawHUD(int Health,int Coins);

    void setbackgroundColor(String color);


}
