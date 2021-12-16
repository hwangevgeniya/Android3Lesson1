package com.geektech.android3lesson1.data.remote;

import com.geektech.android3lesson1.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmsApi {

    @GET("/films")
    Call<List<Film>> getFilms();

    @GET("/films/{id}")
    Call<Film> getFilmById(
            @Path("id") String filmId
    );
}
