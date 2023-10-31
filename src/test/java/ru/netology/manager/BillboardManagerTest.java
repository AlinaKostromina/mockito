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
    private int movieLimit = 5;

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
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNothing() {
        BillboardManager manager = new BillboardManager(0);

        Movie[] actual = manager.findLast();
        Movie [] expected = new Movie[0];
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowOverLimitWithDefaultNumber() { // больше фильмов, чем лимит, с дефолтным значением
        BillboardManager manager = new BillboardManager();

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh };
        Movie[] actual = manager.findAll();
        Assertions.assertEquals(expected, actual);
    }
}


