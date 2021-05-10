package com.example.quizdetecnologia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText EditTextNome;
    Button ButtonIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditTextNome = findViewById(R.id.EditTextNome);
        ButtonIniciar = findViewById(R.id.ButtonIniciar);

        ButtonIniciar.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, QuizTec1Activity.class);
            intent.putExtra("nome",EditTextNome.getText().toString());
            startActivity(intent);

        });
    }
}