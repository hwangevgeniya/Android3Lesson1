package com.geektech.android3lesson1.ui.films_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.android3lesson1.data.models.Film;
import com.geektech.android3lesson1.databinding.FragmentFilmsBinding;
import com.geektech.android3lesson1.databinding.ItemFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {

    private List<Film> films = new ArrayList<>();
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding binding = ItemFilmBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new FilmsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    public Film getItem(int position) {
        return films.get(position);
    }

    public class FilmsViewHolder extends RecyclerView.ViewHolder{

        private ItemFilmBinding binding;

        public FilmsViewHolder(ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void onBind(Film film) {

            binding.title.setText(film.getTitle());
            binding.description.setText(film.getDescription());

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getAdapterPosition());
                }
            });
        }
    }
}
