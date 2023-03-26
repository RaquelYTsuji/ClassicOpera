package com.raquel.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {

    private ImageView menu;
    private ImageView home;
    private ImageView busca;
    private ImageView pessoa;

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        getSupportActionBar().hide();



        menu = findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this, Menu.class);
                startActivity(intent);
            }
        });

        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this, Principal.class);
                startActivity(intent);
            }
        });

        busca = findViewById(R.id.busca);
        busca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this, Pesquisa.class);
                startActivity(intent);
            }
        });

        pessoa = findViewById(R.id.seuperfil);
        pessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this, User.class);
                startActivity(intent);
            }
        });
    }
}