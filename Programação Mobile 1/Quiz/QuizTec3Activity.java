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

public class QuizTec3Activity extends AppCompatActivity {

    TextView TextViewUsuario;
    String nome = "";
    Button ButtonResponder3;
    CheckBox CheckBoxFacebook;
    CheckBox CheckBoxApple;
    CheckBox CheckBoxTencent;
    CheckBox CheckBoxAmazon;
    CheckBox CheckBoxMicrosoft;
    int qtdErros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_tec3);

        TextViewUsuario = findViewById(R.id.TextViewUsuario);
        ButtonResponder3 = findViewById(R.id.ButtonResponder3);
        CheckBoxFacebook = findViewById(R.id.CheckBoxFacebook);
        CheckBoxApple = findViewById(R.id.checkBoxApple);
        CheckBoxTencent = findViewById(R.id.CheckBoxTencent);
        CheckBoxAmazon = findViewById(R.id.CheckBoxAmazon);
        CheckBoxMicrosoft = findViewById(R.id.CheckBoxMicrosoft);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtdErros = bundle.getInt("qtdErros");

        if(!nome.equals(""))
        {
            TextViewUsuario.setText(" " + nome);
        }

        ButtonResponder3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(CheckBoxAmazon.isChecked() && CheckBoxMicrosoft.isChecked() && CheckBoxApple.isChecked()
                && CheckBoxTencent.isChecked()==false && CheckBoxFacebook.isChecked()==false)
                {
                    Toast.makeText(QuizTec3Activity.this, "Acertou!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuizTec3Activity.this, QuizTec4Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtdErros);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(QuizTec3Activity.this, "Errou!", Toast.LENGTH_SHORT).show();
                    qtdErros++;
                    Intent intent = new Intent(QuizTec3Activity.this, QuizTec4Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtdErros);
                    startActivity(intent);
                }
            }
        });
    }
}