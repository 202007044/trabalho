package LastTower.model;


import java.util.List;

public class Button extends Element {
    private final int width;
    private final int height;
    private final String text;
    private String text2="";
    private String bgColor;
    private final Position textPosition;
    private Command command;
    protected Boolean active = false;

    private final List<String> colors;
    private int colorIndex = 0;

    public Button(Position bPos, Command command, List<String> colors) {
        super(bPos, colors.get(0));
        this.command = command;
        this.colors = colors;
        this.width = 4;
        this.height = 4;
        this.text = " gh ";
        this.text2 = " ij ";
        this.bgColor = "#BA8C63";
        this.textPosition = new Position(bPos.getX(), bPos.getY()+1);
    }

    public Button(Position position, String text, Command command, List<String> colors) {
        super(position, colors.get(0));
        this.command = command;
        this.colors = colors;
        this.text = text;
        this.text2 = "";
        this.width = text.length();
        this.height = 1;
        this.bgColor = "#14213d";
        this.textPosition = position;
    }

    public Position getTextPosition() {
        return textPosition;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getText() {
        return text;
    }


    public boolean isHighlighted() {
        return this.color.equals(this.colors.get(1));
    }

    public void toneDown() {
        this.color = this.colors.get(0);
    }

    public void setCommand(Command command){this.command=command;}

    public String getBgColor() {
        return bgColor;
    }

    public void highlight() {
        this.color = this.colors.get(1);
    }

    public Command getCommand() {
        return command;
    }

    public String getText2() {
        return text2;
    }


    public boolean isActive() {
        return active;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

}
