import org.example.Game;
import org.example.NotRegisteredExeption;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Game game = new Game();
        Player vasya = new Player(1, "Вася", 20);
        Player petya = new Player(2, "Петя", 25);
        game.register(vasya);
        game.register(petya);
        int actual = game.round("Вася", "Петя");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Game game = new Game();
        Player vasya = new Player(1, "Вася", 30);
        Player petya = new Player(2, "Петя", 25);
        game.register(vasya);
        game.register(petya);
        int actual = game.round("Вася", "Петя");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSDraw() {
        Game game = new Game();
        Player vasya = new Player(1, "Вася", 30);
        Player petya = new Player(2, "Петя", 30);
        game.register(vasya);
        game.register(petya);
        int actual = game.round("Вася", "Петя");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Game game = new Game();
        Player vasya = new Player(1, "Вася", 30);
        Player petya = new Player(2, "Петя", 30);
        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredExeption.class,
                () -> game.round("Илья", "Вася"));
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Game game = new Game();
        Player vasya = new Player(1, "Вася", 30);
        Player petya = new Player(2, "Петя", 30);
        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredExeption.class,
                () -> game.round("Петя", "Игорь"));
    }
}

