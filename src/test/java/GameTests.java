import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTests {
    Game game = new Game();
    Player player = new Player(1, "Nikolay", 100);
    Player player1 = new Player(2, "Vitaliy", 50);
    Player player2 = new Player(3, "Kirill", 200);
    Player player3 = new Player(4, "Konstantin", 100);

    @BeforeEach
    public void setup() {
        game.register(player);
        game.register(player1);
        game.register(player3);
    }

    @Test
    public void roundFailed() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Nikolay", "Kirill");
        });
    }

    @Test
    public void roundDraw() {
        int expected = 0;
        int actual = game.round("Nikolay", "Konstantin");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWin1() {
        int expected = 1;
        int actual = game.round("Nikolay", "Vitaliy");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWin2() {
        int expected = 2;
        int actual = game.round("Vitaliy", "Konstantin");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundBothFailed() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Volodya", "Kirill");
        });
    }
}
