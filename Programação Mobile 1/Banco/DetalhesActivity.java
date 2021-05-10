package com.example.cadastrocontatossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetalhesActivity extends AppCompatActivity {
    EditText editTextNome, editTextEmail,editTextTelefone;
    Button buttonConfirmarAlteracao;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        editTextNome = findViewById(R.id.editTextNomeDet);
        editTextEmail = findViewById(R.id.editTextEmailDet);
        editTextTelefone = findViewById(R.id.editTextTelefoneDet);
        buttonConfirmarAlteracao = findViewById(R.id.buttonConfirmarAlteracao);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        editTextNome.setText(bundle.getString("nome"));
        editTextEmail.setText(bundle.getString("email"));
        editTextTelefone.setText(bundle.getString("telefone"));

        buttonConfirmarAlteracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DtoContato dtoContato = new DtoContato();
                dtoContato.setId(id);
                dtoContato.setEmail(editTextEmail.getText().toString());
                dtoContato.setNome(editTextNome.getText().toString());
                dtoContato.setTelefone(editTextTelefone.getText().toString());

                DaoContato daoContato = new DaoContato(DetalhesActivity.this);
                try
                {
                    long linhasInseridas = daoContato.alterar(dtoContato);
                    if (linhasInseridas > 0) {
                        Toast.makeText(DetalhesActivity.this, "Alterado com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent main = new Intent(DetalhesActivity.this, MainActivity.class);
                        startActivity(main);
                    }
                    else{
                        Toast.makeText(DetalhesActivity.this, "Não foi possivel inserir. Motivo: MISTÉRIO TOTAL", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception ex){
                    Toast.makeText(DetalhesActivity.this, "Erro ao Alterar: " + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}