package com.example.quizdetecnologia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizTec2Activity extends AppCompatActivity {
    TextView TextViewUsuario;
    String nome = "";
    Button ButtonResponder2;
    RadioButton RadioButtonSteveJobs;
    int qtdErros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_tec2);

        TextViewUsuario = findViewById(R.id.TextViewUsuario);
        ButtonResponder2 = findViewById(R.id.ButtonResponder2);
        RadioButtonSteveJobs = findViewById(R.id.RadioButtonSteveJobs);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        if(!nome.equals(""))
        {
            TextViewUsuario.setText(" " + nome);
        }

        ButtonResponder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(RadioButtonSteveJobs.isChecked())
                {
                    Toast.makeText(QuizTec2Activity.this, "Acertou!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuizTec2Activity.this, QuizTec3Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtdErros);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(QuizTec2Activity.this, "Errou!", Toast.LENGTH_SHORT).show();
                    qtdErros++;
                    Intent intent = new Intent(QuizTec2Activity.this, QuizTec3Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtdErros);
                    startActivity(intent);
                }
            }
        });
    }
}