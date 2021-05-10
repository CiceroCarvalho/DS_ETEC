package com.example.ciclovidaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonIniciar, buttonParar;
    TextView textViewTempo;
    CountDownTimer countDown;
    long tempoRestante;
    EditText editText;

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "Chamou o onResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "Chamou o onPause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "Chamou o onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countDown.cancel();
        Toast.makeText(MainActivity.this, "Chamou o onStop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "Chamou o onDestroy",Toast.LENGTH_SHORT).show();
        SharedPreferences preferences = getSharedPreferences("minhaShared",0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("meuTexto",editText.getText().toString() + "");
        editor.commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "Chamou o onRestart",Toast.LENGTH_SHORT).show();

        countDown = new CountDownTimer(tempoRestante, 1000) {
            @Override
            public void onTick(long tempoRestante) {
                textViewTempo.setText("" + tempoRestante/1000);

            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Voltando ao Jogo...",Toast.LENGTH_SHORT).show();
            }
        };
        countDown.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonIniciar = findViewById(R.id.buttonIniciar);
        buttonParar = findViewById(R.id.buttonParar);
        textViewTempo = findViewById(R.id.textViewTempo);
        editText = findViewById(R.id.editText);

        Toast.makeText(MainActivity.this, "Chamou o onCreate",Toast.LENGTH_SHORT).show();

        SharedPreferences preferences = getSharedPreferences("minhaShared",0);
        String meuTexto = preferences.getString("meuTexto","Texto não encontrado");
        editText.setText(meuTexto);

        countDown = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long TempoRestante) {
                textViewTempo.setText("" + TempoRestante/1000);
                MainActivity.this.tempoRestante = TempoRestante;
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Voltando ao Jogo...",Toast.LENGTH_SHORT).show();
            }
        };

        buttonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDown.start();
            }
        });

        buttonParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDown.cancel();
            }
        });
    }
}