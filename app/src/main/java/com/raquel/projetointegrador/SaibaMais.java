package com.raquel.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SaibaMais extends AppCompatActivity {

    private ImageView seta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saiba_mais);

        getSupportActionBar().hide();

        seta=findViewById(R.id.seta);
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaibaMais.this, Principal.class);
                startActivity(intent);
            }
        });
    }
}