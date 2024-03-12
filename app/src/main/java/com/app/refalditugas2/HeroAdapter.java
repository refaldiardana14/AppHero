package com.app.refalditugas2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.refalditugas2.databinding.ListHeroBinding;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private final List<Hero> heroList;

    public HeroAdapter(List<Hero> heroList) {
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListHeroBinding binding = ListHeroBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroAdapter.ViewHolder holder, int position) {
        Hero hero = heroList.get(position);
        holder.binding.nama.setText(hero.getNama());
        holder.binding.role.setText(hero.getRole());

        @SuppressLint("DiscouragedApi")
        int resourceId = holder.itemView.getContext()
                .getResources()
                .getIdentifier(hero.getFoto(), "drawable", holder.itemView.getContext().getPackageName());

        holder.binding.foto.setImageResource(resourceId);

        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), DetailHeroActivity.class);
            i.putExtra("nama", hero.getNama());
            i.putExtra("role", hero.getRole());
            i.putExtra("foto", resourceId);
            v.getContext().startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ListHeroBinding binding;
        public ViewHolder(@NonNull ListHeroBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
