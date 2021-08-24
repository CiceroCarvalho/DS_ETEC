package com.example.threadsestudo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonIniciar;
    TextView textViewCronometro;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonIniciar = findViewById(R.id.buttonIniciar);
        textViewCronometro = findViewById(R.id.textViewCronometro);
        progressBar = findViewById(R.id.progressBar);

        //Enquanto a Thread Principal tiver fazendo um processo, não sera
        //Possível realizar outras operações, como ticar um checkbox
        //Para isso é necessário criar uma thread
        //Para criar uma Thread, é necessário criar uma classe auxiliar

        buttonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chamando e Iniciando minha Thread
                //MinhaThreadInterna minhaThread = new MinhaThreadInterna();
                //minhaThread.start();

                //Chamando e Iniciando meu AsyncTask
                ExemploAsync exemploAsync = new ExemploAsync(progressBar);
                exemploAsync.execute();
            }
        });
    }

    //Como essa Thread só sera usada em uma activity
    //Pode criar ela como se fosse uma classe interna da MainActivity

    //Quando se manda uma Threada secundaria alterar algum elemento
    //Ele vai querer entrar na Thread Principal, pois é ela que comanda
    //As interfaces graficas, assim é necessário dar um jeito
    //Para a Thread secundaria entrar na principal


    public class MinhaThreadInterna extends Thread{
        //Essa classe auxiliar vai herdar da Classe Java Thread
        //Vamos reescrever o método run, que quando chamar a thread
        //Ele vai executar automaticamente esse processo

        @Override
        public void run() {
            //Log.d("Thread","Chamou a Thread"); O log.d ajuda a ver se esta em funcionamento
            super.run();
            for(int i = 0; i<1000; i++){
                //Para executar um processo na thread principal tem que utilizar
                //o método runOnUiThread, que espera receber um runnable

                //É necessário declarar a variavel i como final, pois não pode ser alterado
                int finalI = i;

                //A função sleep faz com que a thread durma por 1000milisegundos
                //Foi feito isso para vermos a contagem certa em segundos do 1 ao 60
                //Ele pede um Try Cat

                //3x60x1000 uma notação para definir os segundos mais facil
                //No caso seria 3 minutos o exemplo acima
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        textViewCronometro.setText(finalI +"");
                    }
                });
            }
        }
    }
}