package com.example.opet.appmaster;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private List<ItemLista> lista;
    private EditText editLivro;
    private EditText editAutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference(mAuth.getCurrentUser().getUid());
        lista = new ArrayList<>();

        editLivro = findViewById(R.id.editLivro);
        editAutor = findViewById(R.id.editAutor);


    }

    public void salvarItemLista(View view){
        String livro = editLivro.getText().toString();
        String autor = editAutor.getText().toString();

        lista.add(new ItemLista(livro,autor));
        mDatabase.setValue(lista);
        Toast.makeText(MainActivity.this,"Cadastro realizado com sucesso!",Toast.LENGTH_SHORT).show();

    }

    public void consultarLista(View view){
        callActivity(ListaActivity.class);
    }

    private void callActivity(Class newActivity) {
        Intent newIntent = new Intent(MainActivity.this,newActivity);
        startActivity(newIntent);
        finish();
    }
}