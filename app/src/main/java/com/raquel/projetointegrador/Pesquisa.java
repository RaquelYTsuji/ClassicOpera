package com.raquel.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.raquel.projetointegrador.databinding.ActivityMainBinding;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Collection;

public class Pesquisa extends AppCompatActivity {

    private ImageView seta;

    private ArrayList<LivroLista> livroLista;
    private RecyclerView recycler;
    private LivroAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        getSupportActionBar().hide();

        Lista();
        buildRecyclerView();
        
        EditText pesquisa = findViewById(R.id.pesquisa);
        pesquisa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

        seta=findViewById(R.id.seta);
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pesquisa.this, Principal.class);
                startActivity(intent);
            }
        });
    }

    private void Lista(){
        livroLista = new ArrayList<>();

        livroLista.add(new LivroLista(R.drawable.escravaisaura, "A Escrava Isaura", "Bernardo Guimarães"));
        livroLista.add(new LivroLista(R.drawable.moreninha, "A Moreninha", "Joaquim Manuel de Macedo"));
        livroLista.add(new LivroLista(R.drawable.cronicasdenarnia, "As Crônicas de Nárnia", "C. S. Lewis"));
        livroLista.add(new LivroLista(R.drawable.contos, "Irmãos Grimm: O Enigma", "Irmãos Grimm"));
        livroLista.add(new LivroLista(R.drawable.contos, "Irmãos Grimm: O lobo e a Raposa", "Irmãos Grimm"));
        livroLista.add(new LivroLista(R.drawable.domcasmurro, "Dom Casmurro", "Machado de Assis"));
        livroLista.add(new LivroLista(R.drawable.iracema, "Iracema", "José de Alencar"));
        livroLista.add(new LivroLista(R.drawable.memoriasdebrascubas, "Memórias Póstumas de Brás Cubas", "Machado de Assis"));
        livroLista.add(new LivroLista(R.drawable.diarioannefrank, "O Diário de Anne Frank", "Anne Frank"));
        livroLista.add(new LivroLista(R.drawable.escaravelhododiabo, "O Escaravelho do Diabo", "Lúcia Machado de Almeida"));
        livroLista.add(new LivroLista(R.drawable.magicodeoz, "O Mágico de Oz", "L. Frank Baum"));
        livroLista.add(new LivroLista(R.drawable.misteriosocasodestyles, "O Misterioso Caso de Styles", "Agatha Cristie"));
    }

    private void buildRecyclerView(){
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new LivroAdapter(livroLista);

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
    }

    private void filter(String text){
        ArrayList<LivroLista> filteredList = new ArrayList<>();
        for(LivroLista item : livroLista){
            if (item.getTitulo().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
            adapter.setFilteredList(filteredList);
    }
}