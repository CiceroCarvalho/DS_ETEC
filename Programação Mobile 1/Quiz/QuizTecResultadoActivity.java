package com.example.quizdetecnologia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuizTecResultadoActivity extends AppCompatActivity {
    TextView TextViewUsuario;
    TextView TextViewResultado;
    Button ButtonReiniciar;
    RadioButton RadioButtonRuby1;
    RadioButton RadioButtonSteveJobs1;
    CheckBox CheckBoxApple1;
    CheckBox CheckBoxAmazon1;
    CheckBox CheckBoxMicrosoft1;
    RadioButton RadioButtonCalifornia1;
    CheckBox CheckBoxScorpion1;
    CheckBox CheckBoxBlackMirror1;
    String nome = "";
    int qtdErros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_tec_resultado);

        TextViewUsuario = findViewById(R.id.TextViewUsuario);
        TextViewResultado = findViewById(R.id.TextViewResultado);
        ButtonReiniciar = findViewById(R.id.ButtonReiniciar);
        RadioButtonRuby1 = findViewById(R.id.RadioButtonRuby1);
        RadioButtonSteveJobs1 = findViewById(R.id.RadioButtonSteveJobs1);
        CheckBoxApple1 = findViewById(R.id.CheckBoxApple1);
        CheckBoxAmazon1 = findViewById(R.id.CheckBoxAmazon1);
        CheckBoxMicrosoft1 = findViewById(R.id.CheckBoxMicrosoft1);
        RadioButtonCalifornia1 = findViewById(R.id.RadioButtonCalifornia1);
        CheckBoxScorpion1 = findViewById(R.id.CheckBoxScorpion1);
        CheckBoxBlackMirror1 = findViewById(R.id.CheckBoxBlackMirror1);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        if(!nome.equals(""))
        {
            TextViewUsuario.setText(" " + nome);
        }

        if(qtdErros == 0)
        {
            TextViewResultado.setText("Parabéns! " + nome + " Você acertou todas as questões!");
        }
        else if(qtdErros == 1){
            TextViewResultado.setText("Que Pena! " + nome + " Você errou " + qtdErros + " questão!");
        }
        else{
            TextViewResultado.setText("Que Pena! " + nome + " Você errou " + qtdErros + " questões!");
        }

        RadioButtonRuby1.setChecked(true);
        RadioButtonSteveJobs1.setChecked(true);
        CheckBoxApple1.setChecked(true);
        CheckBoxAmazon1.setChecked(true);
        CheckBoxMicrosoft1.setChecked(true);
        RadioButtonCalifornia1.setChecked(true);
        CheckBoxScorpion1.setChecked(true);
        CheckBoxBlackMirror1.setChecked(true);

        ButtonReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuizTecResultadoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}