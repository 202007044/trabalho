package state;
import LastTower.Game;
import LastTower.model.Button;
import LastTower.model.Position;
import LastTower.state.GameState;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameStateTest {
    private GameState gameState;
    private GameState gameState2;
    private List<Button> buttons;
    private Game game;

    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        buttons = new ArrayList<>();
        gameState = new GameState(game, buttons) {
            @Override
            public void start() {}
            @Override
            public void step(Game game, long time) throws IOException {}
        };
        gameState2 = Mockito.mock(GameState.class);
    }
    @Test
    void changeState(){
        gameState.changeState(gameState2);
        Mockito.verify(game,Mockito.times(1)).setGameState(gameState2);
    }
}
