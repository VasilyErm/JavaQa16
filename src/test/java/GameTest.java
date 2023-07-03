import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testWinPlayer1() {
        Player ivan = new Player(1, "Иван", 10);
        Player oleg = new Player(2, "Олег", 7);
        Game game = new Game();

        game.register(ivan);
        game.register(oleg);

        int actual = game.round("Иван", "Олег");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWinPlayer2() {
        Player ivan = new Player(1, "Иван", 8);
        Player oleg = new Player(2, "Олег", 12);
        Game game = new Game();

        game.register(ivan);
        game.register(oleg);

        int actual = game.round("Иван", "Олег");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDraw() {
        Player ivan = new Player(1, "Иван", 9);
        Player oleg = new Player(2, "Олег", 9);
        Game game = new Game();

        game.register(ivan);
        game.register(oleg);

        int actual = game.round("Иван", "Олег");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayer1NotExist() {
        Player ivan = new Player(1, "Иван", 9);
        Player oleg = new Player(2, "Олег", 9);
        Game game = new Game();

        game.register(ivan);
        game.register(oleg);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Иван", "Степан"));
    }

    @Test
    public void testPlayer2NotExist() {
        Player ivan = new Player(1, "Иван", 9);
        Player oleg = new Player(2, "Олег", 9);
        Game game = new Game();

        game.register(ivan);
        game.register(oleg);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Юрий", "Олег"));
    }

    @Test
    public void testAllPlayerNotExist() {
        Player ivan = new Player(1, "Иван", 9);
        Player oleg = new Player(2, "Олег", 9);
        Game game = new Game();

        game.register(ivan);
        game.register(oleg);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Юрий", "Степан"));
    }
}