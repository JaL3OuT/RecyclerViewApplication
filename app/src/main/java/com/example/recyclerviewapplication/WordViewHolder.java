package com.example.recyclerviewapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class WordViewHolder extends RecyclerView.ViewHolder {
    TextView word ;
    ImageView image ;
    WordViewHolder(@NonNull View itemView) {
        super(itemView);
        word = itemView.findViewById(R.id.textWord);
        image = itemView.findViewById(R.id.image);
    }
}
