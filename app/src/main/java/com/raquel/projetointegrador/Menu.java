package com.raquel.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    private ImageView menu;
    private ImageView home;
    private ImageView busca;
    private ImageView pessoa;
    private ImageView genero;
    private ImageView saibamais;
    private ImageView sobreempresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().hide();

        menu=findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Principal.class);
                startActivity(intent);
            }
        });

        home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Principal.class);
                startActivity(intent);
            }
        });

        busca=findViewById(R.id.busca);
        busca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Pesquisa.class);
                startActivity(intent);
            }
        });

        pessoa=findViewById(R.id.seuperfil);
        pessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, User.class);
                startActivity(intent);
            }
        });

        genero=findViewById(R.id.livro2);
        genero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Genero.class);
                startActivity(intent);
            }
        });

        saibamais=findViewById(R.id.soma);
        saibamais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, SaibaMais.class);
                startActivity(intent);
            }
        });

        sobreempresa=findViewById(R.id.empresa);
        sobreempresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, SobreEmpresa.class);
                startActivity(intent);
            }
        });
    }
}