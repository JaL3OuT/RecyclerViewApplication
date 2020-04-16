package com.example.recyclerviewapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
//Adapter
public class WordAdapter extends RecyclerView.Adapter<WordViewHolder>{
//Liste d'element
    LinkedList<String> words ;
//Constructeur de l'adapter
    WordAdapter(LinkedList<String> words){
        this.words = words ;
    }
    @NonNull
    @Override
    //implimentation de l'elemnt dans l 'adapter
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,
                parent, false);
       return new WordViewHolder(view);
    }

    @Override
    //Affectation des donnés de la liste a chaque élement par position
    public void onBindViewHolder(@NonNull final WordViewHolder holder, final int position) {
        //affectation de chaque element par position
        String mot = words.get(position);
        holder.word.setText(mot);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.word.setText(words.get(position)+" Clicked Item");
            }
        });
    }

    @Override
    public int getItemCount() {
        return words.size();
    }


}
