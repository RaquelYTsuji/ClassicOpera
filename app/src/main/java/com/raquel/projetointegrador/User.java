package com.raquel.projetointegrador;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class User extends AppCompatActivity {

    private ImageView seta;
    private ImageView home;
    private ImageView busca;
    private ImageView pessoa;

    private TextView user_nome, user_email, user_telefone;
    private Button deslogar;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        getSupportActionBar().hide();

        user_nome=findViewById(R.id.user_nome);
        user_email=findViewById(R.id.user_email);
        user_telefone=findViewById(R.id.user_telefone);

        seta=findViewById(R.id.seta);
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User.this, Principal.class);
                startActivity(intent);
            }
        });

        home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User.this, Principal.class);
                startActivity(intent);
            }
        });

        busca=findViewById(R.id.busca);
        busca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User.this, Pesquisa.class);
                startActivity(intent);
            }
        });

        pessoa=findViewById(R.id.seuperfil);
        pessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User.this, User.class);
                startActivity(intent);
            }
        });

        deslogar=findViewById(R.id.deslogar);
        deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(User.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    protected void onStart(){
        super.onStart();

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        String usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuários").document(usuarioID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (value != null){
                    user_nome.setText(value.getString("nome"));
                    user_email.setText(email);
                    user_telefone.setText(value.getString("telefone"));
                }
            }
        });
    }
}