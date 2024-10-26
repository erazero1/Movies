package com.erazero1.movies.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.erazero1.movies.R;
import com.erazero1.movies.model.Movie;
import com.erazero1.movies.presentation.adapters.MoviesAdapter;
import com.erazero1.movies.presentation.interfaces.OnMovieClickListener;

import java.util.List;

public class FavouriteMoviesActivity extends AppCompatActivity {
    private static final String EXTRA_MOVIE = "movie";
    private FavouriteMoviesViewModel viewModel;
    private RecyclerView recyclerView;
    private MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_movies);
        viewModel = new ViewModelProvider(this).get(FavouriteMoviesViewModel.class);

        initViews();

        adapter = new MoviesAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        initListeners();
        initObservers();
    }

    private void initViews(){
        recyclerView = findViewById(R.id.recyclerViewFavouriteMovies);
    }

    private void initListeners(){
        adapter.setOnMovieClickListener(new OnMovieClickListener() {
            @Override
            public void onMovieClick(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(FavouriteMoviesActivity.this, movie);
                startActivity(intent);
            }
        });
    }

    private void initObservers(){
        viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                adapter.setMovies(movies);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public static Intent newIntent(Context context){
        return new Intent(context, FavouriteMoviesActivity.class);
    }
}
