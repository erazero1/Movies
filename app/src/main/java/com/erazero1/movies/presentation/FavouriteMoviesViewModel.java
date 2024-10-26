package com.erazero1.movies.presentation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.erazero1.movies.data.database.MovieDatabase;
import com.erazero1.movies.data.database.dao.MovieDao;
import com.erazero1.movies.model.Movie;

import java.util.List;

public class FavouriteMoviesViewModel extends AndroidViewModel {
    private final MovieDao movieDao;

    public LiveData<List<Movie>> getMovies() {
        return movieDao.getAllFavouriteMovies();
    }

    public FavouriteMoviesViewModel(@NonNull Application application) {
        super(application);
        movieDao = MovieDatabase.getInstance(application).movieDao();
    }
}
