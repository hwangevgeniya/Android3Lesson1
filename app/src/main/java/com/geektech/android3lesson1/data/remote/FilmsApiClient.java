package com.geektech.android3lesson1.data.remote;

import com.geektech.android3lesson1.App;
import com.geektech.android3lesson1.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsApiClient {

    public void getFilms(FilmsCallback filmsCallback) {
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    filmsCallback.success(response.body());
                } else {
                    filmsCallback.failure(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                filmsCallback.failure(t.getLocalizedMessage());
            }
        });
    }

    public void getFilmById(String filmId, FilmCallback callback) {
        App.api.getFilmById(filmId).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                callback.failure(t.getLocalizedMessage());

            }
        });
    }


}
