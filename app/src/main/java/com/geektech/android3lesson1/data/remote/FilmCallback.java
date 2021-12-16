package com.geektech.android3lesson1.data.remote;

import com.geektech.android3lesson1.data.models.Film;

public interface FilmCallback {
    void success(Film film);

    void failure(String message);
}
