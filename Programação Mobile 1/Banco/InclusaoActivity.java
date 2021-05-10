package com.example.cadastrocontatossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InclusaoActivity extends AppCompatActivity {
    EditText editTextNome, editTextEmail, editTextTelefone;
    Button buttonConfirmarInclusao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inclusao);

        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        buttonConfirmarInclusao = findViewById(R.id.buttonConfirmarInclusao);

        buttonConfirmarInclusao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DtoContato dtoContato = new DtoContato();
                dtoContato.setEmail(editTextEmail.getText().toString());
                dtoContato.setNome(editTextNome.getText().toString());
                dtoContato.setTelefone(editTextTelefone.getText().toString());

                DaoContato daoContato = new DaoContato(InclusaoActivity.this);
                try
                {
                    long linhasInseridas = daoContato.inserir(dtoContato);
                    if (linhasInseridas > 0) {
                        Toast.makeText(InclusaoActivity.this, "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent main = new Intent(InclusaoActivity.this, MainActivity.class);
                        startActivity(main);
                    }
                    else{
                        Toast.makeText(InclusaoActivity.this, "Não foi possivel inserir. Motivo: MISTÉRIO TOTAL", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception ex){
                    Toast.makeText(InclusaoActivity.this, "Erro ao Inserir: " + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}