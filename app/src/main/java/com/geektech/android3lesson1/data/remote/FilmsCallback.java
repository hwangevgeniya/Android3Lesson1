package com.geektech.android3lesson1.data.remote;

import com.geektech.android3lesson1.data.models.Film;

import java.util.List;

public interface FilmsCallback {

    void success(List<Film> films);
    void failure(String msg);

}
