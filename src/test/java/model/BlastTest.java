package model;
import LastTower.model.Blast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BlastTest {
    private Blast blast;

    @BeforeEach
    void setUp(){
        blast = new Blast(1,1);
    }

    @Test
    void appearence(){
        assertEquals("p",blast.getAppearence());
    }
}
