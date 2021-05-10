package com.example.quizdetecnologia;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizTec1Activity extends AppCompatActivity {

    TextView TextViewUsuario;
    String nome = "";
    Button ButtonResponder;
    RadioButton RadioButtonRuby;
    int qtdErros = 0;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_tec1);

        TextViewUsuario = findViewById(R.id.TextViewUsuario);
        ButtonResponder = findViewById(R.id.ButtonResponder);
        RadioButtonRuby = findViewById(R.id.RadioButtonRuby);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");

        if(!nome.equals(""))
        {
            TextViewUsuario.setText(" " + nome);
        }

        ButtonResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(RadioButtonRuby.isChecked())
                {
                    Toast.makeText(QuizTec1Activity.this, "Acertou!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuizTec1Activity.this, QuizTec2Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtdErros);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(QuizTec1Activity.this, "Errou!", Toast.LENGTH_SHORT).show();
                    qtdErros++;
                    Intent intent = new Intent(QuizTec1Activity.this, QuizTec2Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtdErros);
                    startActivity(intent);
                }
            }
        });
    }
}