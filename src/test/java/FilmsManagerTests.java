import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.FilmsManager;

class FilmsManagerTest {
    @Test
    void shouldAddFilmsAndFindAll() {
        FilmsManager manager = new FilmsManager();
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");
        String[] expected = {"Film 1", "Film 2", "Film 3"};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldFindLastFilmLimit() {
        FilmsManager manager = new FilmsManager();
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");
        String[] expected = {"Film 3", "Film 2", "Film 1"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldFindLastLimit() {
        FilmsManager manager = new FilmsManager();
        String[] films = {"Film 1", "Film 2", "Film 3", "Film 4", "Film 6", "Film 7"};
        for (String film : films) {
            manager.addFilm(film);
        }

        String[] expected = {"Film 7", "Film 6", "Film 4", "Film 3", "Film 2"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldFindLastUserLimit() {
        FilmsManager manager = new FilmsManager(3);
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");
        manager.addFilm("Film 4");

        String[] expected = {"Film 4", "Film 3", "Film 2"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldEmptyManager() {
        FilmsManager manager = new FilmsManager();
        Assertions.assertArrayEquals(new String[0], manager.findAll());
        Assertions.assertArrayEquals(new String[0], manager.findLast());
    }

    @Test
    void shouldHandleSingleFilm() {
        FilmsManager manager = new FilmsManager();
        manager.addFilm("Film 1");

        String[] expectedAll = {"Film 1"};
        String[] expectedLast = {"Film 1"};

        Assertions.assertArrayEquals(expectedAll, manager.findAll());
        Assertions.assertArrayEquals(expectedLast, manager.findLast());
    }

}


