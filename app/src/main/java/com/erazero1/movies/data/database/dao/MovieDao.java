package com.erazero1.movies.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.erazero1.movies.model.Movie;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface MovieDao {
    @Query("select * from favourite_movies")
    LiveData<List<Movie>> getAllFavouriteMovies();

    @Query("select * from favourite_movies where id = :movieId")
    LiveData<Movie> getFavouriteMovie(int movieId);

    @Insert
    Completable insertMovie(Movie movie);

    @Query("delete from favourite_movies where id = :movieId")
    Completable removeMovie(int movieId);
}
