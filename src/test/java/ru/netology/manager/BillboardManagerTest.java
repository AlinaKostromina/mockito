package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import static org.junit.jupiter.api.Assertions.*;


public class BillboardManagerTest {

    BillboardManager manager = new BillboardManager();

    private Movie first = new Movie("Bladshot");
    private Movie second = new Movie("Ahead");
    private Movie third = new Movie("HotelBelgrad");
    private Movie fourth = new Movie("Gentlemen");
    private Movie fifth = new Movie("InvisibleMan");
    private Movie sixth = new Movie("Trolls");
    private Movie seventh = new Movie("NumberOne");


    @Test
    void shouldShowSevenMovie() {
        BillboardManager manager = new BillboardManager(7);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);

        Movie[] expected = {seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = manager.getLastAdd();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowAllMovie() {
        BillboardManager manager = new BillboardManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);

        Movie[] expected = manager.getMovies();
        Movie[] actual = manager.getMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNothing() {
        BillboardManager manager = new BillboardManager(0);

        Movie[] actual = manager.getLastAdd();
        Movie [] expected = new Movie[0];
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowOverMax() { // больше фильмов, чем лимит
        BillboardManager manager = new BillboardManager(8);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);

        Movie[] expected = {seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = manager.getLastAdd();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowUnderMax() { // меньше фильмов, чем лимит
        BillboardManager manager = new BillboardManager(6);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Movie[] expected = manager.findAll();
        Movie[] actual = manager.getMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowSameMax() { // столько же, как лимит
        BillboardManager manager = new BillboardManager(7);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh};
        Movie[] actual = manager.getMovies();
        Assertions.assertArrayEquals(expected, actual);
    }
}


