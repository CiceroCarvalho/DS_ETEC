package com.example.quizdetecnologia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizTec5Activity extends AppCompatActivity {
    TextView TextViewUsuario;
    Button ButtonResponder5;
    CheckBox CheckBoxHeartland;
    CheckBox CheckBoxScorpion;
    CheckBox CheckBoxBlackMirror;
    CheckBox CheckBoxTheCrown;
    String nome = "";
    int qtdErros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_tec5);

        TextViewUsuario = findViewById(R.id.TextViewUsuario);
        ButtonResponder5 = findViewById(R.id.ButtonResponder5);
        CheckBoxHeartland = findViewById(R.id.CheckBoxHeartland);
        CheckBoxScorpion = findViewById(R.id.checkBoxScorpion);
        CheckBoxBlackMirror = findViewById(R.id.CheckBoxBlackMirror);
        CheckBoxTheCrown = findViewById(R.id.CheckBoxTheCrown);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome", nome);
        qtdErros = bundle.getInt("qtdErros", qtdErros);

        if(!nome.equals(""))
        {
            TextViewUsuario.setText(" " + nome);
        }

        ButtonResponder5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(CheckBoxHeartland.isChecked()==false && CheckBoxTheCrown.isChecked()==false
                && CheckBoxScorpion.isChecked() && CheckBoxBlackMirror.isChecked())
                {
                    Toast.makeText(QuizTec5Activity.this, "Acertou!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuizTec5Activity.this, QuizTecResultadoActivity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtdErros);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(QuizTec5Activity.this, "Errou!", Toast.LENGTH_SHORT).show();
                    qtdErros++;
                    Intent intent = new Intent(QuizTec5Activity.this, QuizTecResultadoActivity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtdErros);
                    startActivity(intent);
                }
            }
        });
    }
}