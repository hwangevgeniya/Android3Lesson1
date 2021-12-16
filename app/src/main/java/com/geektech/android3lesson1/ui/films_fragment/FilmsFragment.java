package com.geektech.android3lesson1.ui.films_fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.geektech.android3lesson1.App;
import com.geektech.android3lesson1.R;
import com.geektech.android3lesson1.data.models.Film;
import com.geektech.android3lesson1.data.remote.FilmsCallback;
import com.geektech.android3lesson1.databinding.FragmentFilmsBinding;
import com.geektech.android3lesson1.ui.film_detail_fragment.FilmDetailFragment;

import java.util.List;

public class FilmsFragment extends Fragment {

    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;
//    private FragmentActivity myContext;

    public FilmsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new FilmsAdapter();

        //App.api.getFilms().enqueue();
        App.client.getFilms(new FilmsCallback() {
            @Override
            public void success(List<Film> films) {
                adapter.setFilms(films);
                binding.filmsRecycler.setAdapter(adapter);

            }

            @Override
            public void failure(String msg) {
                Log.e("TAG", "failure: " + msg);
            }
        });
        onFilmClick();

    }

    public void onFilmClick() {
/*        new AlertDialog.Builder(requireContext())
                .setTitle("Получить ID фильма")
                .setMessage("Получить ID фильма \" " + film.getTitle() + "\"?")
                .setNegativeButton("Нет", null)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        FilmDetailFragment detailFragment = new FilmDetailFragment();
                        FilmsFragment fragment1 = new FilmsFragment();

                        int fragmentManager = myContext.getSupportFragmentManager().beginTransaction()
                                //.replace(R.id.container, Fragment.instantiate(this, FilmDetailFragment.class.getName())).commit();
                                .show(detailFragment)
                                .hide(fragment1)
                                .commit();

                        adapter.getItem(position);

                    }
                }).show();*/
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host);
        adapter.setListener(new OnItemClickListener() {
            @Override
            public void onClick(int position) {
/*
                Film film = adapter.getItem(position);
                FilmDetailFragment detailFragment = new FilmDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putString("film_id", film.getId());
                detailFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().replace(R.id.nav_host, detailFragment);
*/
                Bundle bundle = new Bundle();
                Film film = adapter.getItem(position);
                bundle.putString("film_id", film.getId());
                navController.navigate(R.id.filmDetailFragment, bundle);
            }
        });
    }
}