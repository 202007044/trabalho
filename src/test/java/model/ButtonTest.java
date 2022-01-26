package model;

import LastTower.model.Button;
import LastTower.model.Command;
import LastTower.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ButtonTest {
    private Button button;
    class CommandStub implements Command{
        @Override
        public boolean execute(){return true;}
    }

    @BeforeEach
    void setUp(){
        List<String> colors = new ArrayList<>();
        colors.add("#000000");
        colors.add("#FFFFFF");
        CommandStub commandStub= new CommandStub();
        button = new Button(new Position(1,1),commandStub,colors);
    }

    @Test
    void activate(){
        button.activate();
        assertTrue(button.isActive());
    }
    @Test
    void highlight(){
        button.highlight();
        assertTrue(button.isHighlighted());
    }
    @Test
    void deactivate(){
        button.deactivate();
        assertFalse(button.isActive());
    }
    @Test
    void toneDown(){
        button.toneDown();
        assertFalse(button.isHighlighted());
    }
}
