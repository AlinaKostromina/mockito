package ru.netology.manager;
import ru.netology.domain.Movie;

//https://otvet.mail.ru/question/229882561

public class BillboardManager {

    private Movie[] movies = new Movie[0];
    private int countMovies = 5;


    // пустой конструктор
    public BillboardManager() {
    }

    public BillboardManager(int countMovies) {
        this.countMovies = countMovies;
    }

    public Movie[] getMovies() {
        return movies;
    }


    //добавление фильма в конец массива
    public void add(Movie movie) {

        Movie[] tmp = new Movie[movies.length + 1];

        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[movies.length] = movie;
        movies = tmp;
    }

    //отображение фильмов в порядке добавления
//    public void findAll() {
//        getMovies();
//    }

    //отображение  фильмов в обратном порядке
    public Movie[] getLastAdd() {
        int moviesLength = movies.length;
        if (moviesLength < countMovies) {
            countMovies = moviesLength;
        }
        Movie[] customFilm = new Movie[countMovies];
        for (int i = 0; i < customFilm.length; i++) {
            int result = moviesLength - i - 1;
            customFilm[i] = movies[result];

        }
        return customFilm;
    }
}
