package com.erazero1.movies.data.retrofit;

import com.erazero1.movies.model.MovieResponse;
import com.erazero1.movies.model.reviews.ReviewResponse;
import com.erazero1.movies.model.trailers.TrailerResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService{
//    @GET("movie?token=MVYAX27-EE0MBBR-Q2XPVSE-YZ5BBYS&rating.kp=8-10&sortField=votes.kp&sortType=-1&limit=5")

    @GET("movie?token=MVYAX27-EE0MBBR-Q2XPVSE-YZ5BBYS&rating.kp=4-10&sortField=votes.kp&sortType=-1&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie/{id}?token=MVYAX27-EE0MBBR-Q2XPVSE-YZ5BBYS&selectFields=videos&notNullFields=videos.trailers.url")
    Single<TrailerResponse> loadTrailers(@Path("id") int id);

    @GET("review?token=MVYAX27-EE0MBBR-Q2XPVSE-YZ5BBYS&limit=20")
    Single<ReviewResponse> loadReviews(@Query("movieId") int id, @Query("page") int page);
}
