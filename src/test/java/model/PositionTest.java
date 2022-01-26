package model;
import LastTower.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PositionTest {
    private Position position;

    @BeforeEach
    void setUp(){
     position = new Position(1,1);
    }

    @Test
    void equals(){
        assertTrue(position.equals(new Position(1,1)));
    }

}
