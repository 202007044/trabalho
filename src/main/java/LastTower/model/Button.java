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

    public Button(Position bPos, Position tPos, String text1,String text2, int width, int height, Command command, List<String> colors) {
        super(bPos, colors.get(0));
        this.command = command;
        this.colors = colors;
        this.width = width;
        this.height = height;
        this.text = text1;
        this.text2 = text2;
        this.bgColor = "#BA8C63";
        this.textPosition = tPos;
    }

    public Button(Position position, Command command, List<String> colors) {
        super(position, colors.get(0));
        this.command = command;
        this.colors = colors;
        this.text = "";
        this.text2 = "";
        this.width = 1;
        this.height = 1;
        this.bgColor = "#14213d";
        this.textPosition = position;
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

    public void changeColor() {
        this.colorIndex++;
        this.colorIndex= this.colorIndex % this.colors.size();
        this.color = this.colors.get(this.colorIndex);
    }

    public boolean isHighlighted() {
        return this.color.equals(this.colors.get(1));
    }

    public void toneDown() {
        this.color = this.colors.get(0);
    }


    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

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

    public void setText2(String text2) {
        this.text2 = text2;
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
