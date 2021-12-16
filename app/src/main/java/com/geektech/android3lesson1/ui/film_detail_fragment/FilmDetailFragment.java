package com.geektech.android3lesson1.ui.film_detail_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.android3lesson1.App;
import com.geektech.android3lesson1.data.models.Film;
import com.geektech.android3lesson1.data.remote.FilmCallback;
import com.geektech.android3lesson1.databinding.FragmentFilmDetailBinding;


public class FilmDetailFragment extends Fragment {

    private FragmentFilmDetailBinding binding;
    Film film;
    private String filmId;


    public FilmDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //binding.tvFilmId.setText();

        if (getArguments() != null) {
            filmId = getArguments().getString("film_id");
        } else {
            Log.e("TAG", "onViewCreated: film id is null");
        }
        setFilmData();
        /*App.client.getFilms(new FilmsCallback() {
            @Override
            public void success(List<Film> films) {
//                binding.tvFilmId.setText((CharSequence) films.get(Integer.parseInt(film.getId())));

                binding.tvFilmId.setText();
            }

            @Override
            public void failure(String msg) {
                Log.e("TAG", "failure: " + msg);
            }
        });*/
    }

    private void setFilmData() {
        App.client.getFilmById(filmId, new FilmCallback() {
            @Override
            public void success(Film film) {
                binding.tvFilmId.setText(film.getTitle());
            }

            @Override
            public void failure(String message) {

            }
        });
    }
}