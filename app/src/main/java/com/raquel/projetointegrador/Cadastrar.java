package com.raquel.projetointegrador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import kotlin.collections.UCollectionsKt;

public class Cadastrar extends AppCompatActivity {

    private Button cadastrar;
    private ImageView seta;
    private EditText senha;
    private TextView charcount, num;

    private String[] mensagens = {"Preencha todos os campos", "Cadastro efetuado com sucesso"};
    private EditText entrar_nome, entrar_email, entrar_telefone, entrar_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        getSupportActionBar().hide();

        entrar_nome=findViewById(R.id.entrar_nome);
        entrar_email=findViewById(R.id.entrar_email);
        entrar_telefone=findViewById(R.id.entrar_telefone);
        entrar_senha=findViewById(R.id.entrar_senha);

        cadastrar=findViewById(R.id.cadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = entrar_nome.getText().toString();
                String email = entrar_email.getText().toString();
                String telefone = entrar_telefone.getText().toString();
                String senha = entrar_senha.getText().toString();

                if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.RED);
                    snackbar.show();
                } else {
                    CadastrarUsuario(view);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TelaLogin();
                        }
                    },3000);
                }
            }
        });

        seta=findViewById(R.id.seta);
        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cadastrar.this, Login.class);
                startActivity(intent);
            }
        });

        senha = findViewById(R.id.entrar_senha);
        charcount = findViewById(R.id.cad_digitos);
        num = findViewById(R.id.cad_numeros);

        senha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String passworld = senha.getText().toString();
                validatepass(passworld);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void validatepass (String password){
        Pattern digit = Pattern.compile("[0-9]");

        if (!digit.matcher(password).find()){
            num.setTextColor(Color.RED);
        }
        else {
            num.setTextColor(Color.GREEN);
        }

        if (password.length()<8){
            charcount.setTextColor(Color.RED);
        }
        else {
            charcount.setTextColor(Color.GREEN);
        }
    }

    private void CadastrarUsuario (View view){
        String email = entrar_email.getText().toString();
        String senha = entrar_senha.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    SalvarDadosUsuario();

                    Snackbar snackbar = Snackbar.make(view, mensagens[1], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.GREEN);
                    snackbar.show();
                }else{
                    String erro = " ";
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException exception){
                        erro = "Senha fraca";
                    }catch (FirebaseAuthUserCollisionException exception){
                        erro = "Já existe um usuário com este email";
                    }catch (FirebaseAuthInvalidCredentialsException exception){
                        erro = "O email digitado é inválido";
                    }catch (Exception exception){
                        erro = "Erro ao cadastrar o usuário";
                    }
                    Snackbar snackbar = Snackbar.make(view, erro, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.RED);
                    snackbar.show();
                }
            }
        });
    }

    private void SalvarDadosUsuario(){
        String nome = entrar_nome.getText().toString();
        String telefone = entrar_telefone.getText().toString();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> usuarios = new HashMap<>();
        usuarios.put("nome", nome);
        usuarios.put("telefone", telefone);
        String usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuários").document(usuarioID);
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("db", "Sucesso ao salvar os dados");
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("db_error", "Erro ao salvar os dados" + e.toString());
            }
        });
    }

    private void TelaLogin(){
        Intent intent = new Intent(Cadastrar.this, Login.class);
        startActivity(intent);
        finish();
    }
}