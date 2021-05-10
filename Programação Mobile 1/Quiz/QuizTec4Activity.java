package com.example.quizdetecnologia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizTec4Activity extends AppCompatActivity {
    TextView TextViewUsuario;
    RadioButton RadioButtonCalifornia;
    Button ButtonResponder4;
    String nome = "";
    int qtdErros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_tec4);

        TextViewUsuario = findViewById(R.id.TextViewUsuario);
        RadioButtonCalifornia = findViewById(R.id.RadioButtonCalifornia);
        ButtonResponder4 = findViewById(R.id.ButtonResponder4);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        if(!nome.equals(""))
        {
            TextViewUsuario.setText(" " + nome);
        }

        ButtonResponder4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(RadioButtonCalifornia.isChecked())
                {
                    Toast.makeText(QuizTec4Activity.this, "Acertou!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuizTec4Activity.this, QuizTec5Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtdErros);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(QuizTec4Activity.this, "Errou!", Toast.LENGTH_SHORT).show();
                    qtdErros++;
                    Intent intent = new Intent(QuizTec4Activity.this, QuizTec5Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtdErros);
                    startActivity(intent);
                }
            }
        });
    }
}