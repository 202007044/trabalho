package model;
import LastTower.state.GameState;
import LastTower.state.PauseState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import LastTower.model.MenuButtonCommand;
import org.mockito.Mockito;


public class MenuButtonCommandTest {
    private MenuButtonCommand menuButtonCommand;
    private GameState gameState;
    @BeforeEach
    void setUp(){
        gameState = Mockito.mock(PauseState.class);
        menuButtonCommand = new MenuButtonCommand(gameState);
    }
    @Test
    void execute() {
        assertTrue(menuButtonCommand.execute());
        Mockito.verify(gameState, Mockito.times(1)).changeState(gameState);
    }
}
