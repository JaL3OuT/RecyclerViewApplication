package com.example.recyclerviewapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    //initialisation de la liste des Mots
    private final LinkedList<String> mWordList = new LinkedList<>();
    RecyclerView recyclerView ;
    WordAdapter wordAdapter  ;
    FloatingActionButton fab ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Création de la lisye des Mots
        for (int i = 0; i <5; i++) {
            mWordList.addLast("Word " + i);
        }
        //initialisation de l'adapter
        wordAdapter = new WordAdapter(mWordList);
        //initialisation de recyclerView
        recyclerView = findViewById(R.id.recycler);
        //affectation de l'adapter au recyclerView
        recyclerView.setAdapter(wordAdapter);
        //Ajoute de dividerDecotetion
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this , DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,true));
        //initialisation de button d'ajout d'element
        fab=findViewById(R.id.fab);
        //Ajout de click
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = mWordList.size();
                //ajout de l'element au dernier index
                mWordList.addLast("Word "+ count);
                // notifier l(adapter de l'element ajouter
                wordAdapter.notifyItemInserted(count);
                //fait un scroll vers le dernier element ajouter
                recyclerView.smoothScrollToPosition(count);
            }
        });
    }
}
