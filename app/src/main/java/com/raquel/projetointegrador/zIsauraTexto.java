package com.raquel.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class zIsauraTexto extends AppCompatActivity {

    private ImageView seta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zisaura_texto);

        getSupportActionBar().hide();

        seta=findViewById(R.id.seta);
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(zIsauraTexto.this, Principal.class);
                startActivity(intent);
            }
        });
    }
}