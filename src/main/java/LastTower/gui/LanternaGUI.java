package LastTower.gui;

import LastTower.model.Position;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class LanternaGUI implements GUI {
    private final TerminalScreen screen;
    private final int width;
    private final int height;

    public LanternaGUI(int width, int height) throws IOException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
        addCloseScreenListener();
        this.height=height;
        this.width=width;
    }

    public LanternaGUI(TerminalScreen screen) {
        this.screen = screen;
        this.width = 10;
        this.height = 10;
    }

    public TerminalScreen createScreen(Terminal terminal) throws IOException {
        final TerminalScreen terminalScreen;
        terminalScreen = new TerminalScreen(terminal);
        terminalScreen.setCursorPosition(null);
        terminalScreen.startScreen();
        terminalScreen.doResizeIfNecessary();
        return terminalScreen;
    }

    public Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width*3/2, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);

        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    public AWTTerminalFontConfiguration loadFont() throws FontFormatException, IOException {
        File fontFile = new File("src/main/resources/fonts/THELASTTOWERFINAL.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 26);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    @Override
    public boolean isActive() {
        return ((AWTTerminalFrame) screen.getTerminal()).isDisplayable();
    }

    @Override
    public void drawCastle(Position position, String color) {
        for(int i = -2;i<23;i++){
            drawText( screen.newTextGraphics(), new Position(position.getX()+i, position.getY()+1), "u", color);
        }
        drawText( screen.newTextGraphics(), new Position(position.getX()-1, position.getY()+1), "t", color);
        drawText( screen.newTextGraphics(), new Position(position.getX()+1, position.getY()+1), "v", color);
        drawText( screen.newTextGraphics(), new Position(position.getX()-1, position.getY()+1), "t", color);
        drawText( screen.newTextGraphics(), new Position(position.getX()-1, position.getY()), "q", color);
        drawText( screen.newTextGraphics(), new Position(position.getX()+1, position.getY()), "s", color);

    }

    @Override
    public void drawTower(Position position, String color) {
        drawText( screen.newTextGraphics(), position, "k", color);
    }


    @Override
    public void drawPath(Position position) {
        TextGraphics s =screen.newTextGraphics();
        s.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        s.putString(position.getX(),position.getY()," ");
    }


    @Override
    public void drawBlast(Position position, String elementColor, String character, List<Position> path) {
        TextGraphics textGraphics = screen.newTextGraphics();
        if (path.contains(position)) {
            textGraphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        }
        else {
            textGraphics.setBackgroundColor(TextColor.Factory.fromString("#008013"));
        }
        textGraphics.setForegroundColor(TextColor.Factory.fromString(elementColor));
            textGraphics.enableModifiers(SGR.BOLD);
            textGraphics.putString(position.getX(),position.getY(),character);
    }


    @Override
    public void drawButton(Position bPos, Position tPos, String text,String text2, String bgColor, String textColor, int width, int height){
        TextGraphics textGraphics=screen.newTextGraphics();
        drawRectangle(textGraphics, bgColor, width, height, bPos);
        drawText(textGraphics, tPos, text, textColor);
        if(text2!="")drawText(textGraphics, new Position(tPos.getX(), tPos.getY()+1), text2, textColor);

    }


    @Override
    public void drawMonster(Position position, String color,String apperance) {
        drawText( screen.newTextGraphics(), position,apperance , color);

    }
    @Override
    public void drawShop(Position position, String color) {
        drawText( screen.newTextGraphics(), position, "S", color);
    }

    @Override
    public void drawTitle(Position position, String text, String color, String colorText) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        drawText(textGraphics, position, text,colorText);
    }

    public void addMouseListener(MouseObserver obs) {
        ((AWTTerminalFrame) screen.getTerminal()).getComponent(0).addMouseListener(obs);
        ((AWTTerminalFrame) screen.getTerminal()).getComponent(0).addMouseMotionListener(obs);
    }

    public void addKeyBoardListener(KeyBoardObserver obs) {
        ((AWTTerminalFrame) screen.getTerminal()).getComponent(0).addKeyListener(obs);
    }


    private void addCloseScreenListener(){
        ((AWTTerminalFrame) screen.getTerminal()).addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                ((AWTTerminalFrame) screen.getTerminal()).dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public TextGraphics createTextGraphics() {
        return screen.newTextGraphics();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void drawRectangle(TextGraphics textGraphics, String color, int width, int height, Position pos){
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(pos.getX(), pos.getY()), new TerminalSize(width, height), ' ');
    }

    @Override
    public void drawBackground(TextGraphics textGraphics, String color) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(39, 26), ' ');
    }

    private void drawText(TextGraphics textGraphics, Position position, String text, String color) {
        if(text=="a"||text=="b"||text=="c"||text=="d"){textGraphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));}
        if(text=="k"||text=="v"||text=="t"||text=="u"||text=="q"||text=="s"){textGraphics.setBackgroundColor(TextColor.Factory.fromString("#008013"));}
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(),position.getY(),text);
    }
    @Override
    public void drawHUD(int health, int coins){
        TextGraphics textGraphics = createTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#008013"));
        drawText(textGraphics, new Position(0,this.height-1), String.valueOf(health),"#FF0000");
        drawText(textGraphics, new Position(10,this.height-1), "$"+String.valueOf(coins),"#FFFF00");
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#caa472"));
        textGraphics.fillRectangle(new TerminalPosition(25, 0), new TerminalSize(this.width, this.height), ' ');
        drawText(textGraphics, new Position(27,8),"A:1 R:2 $5","#EFC88B");
        drawText(textGraphics, new Position(27,15),"A:1 R:3 $7","#EFC88B");
        drawText(textGraphics, new Position(27,22),"A:2 R:4 $10","#EFC88B");
    }



    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}