package com.example.threadsestudo;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

//AsyncTask é uma outra forma que podemos usar para iniciar uma thread
//O Async também tem mais outras coisas legais, como progressbar
public class ExemploAsync extends AsyncTask {
    //Essa classe herda da Classe AsyncTask
    //Possui um método abstrato

    //Só vai executar essa classe se tiver um progressbar
    ProgressBar progressBar;
    ExemploAsync(ProgressBar progressBar){
        this.progressBar = progressBar;
    }

    //Chama esse método antes de iniciar o Async
    //Definindo o progressBar como Visivel
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        //Esse método executa as coisas em background
        //Ele que vai criar uma thread e vai fazer o que esta dentro desse método

        for(int i = 0; i<=10; i++){
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
            Log.d("Async","chamou async");

            //Criando vetor de objeto para o meu i, para passar para o onProgressUpdate
            Object[] valor = {i};
            onProgressUpdate(valor);
        }
        return null;
    }

    //Essa classe já acessa a Thread principal, por isso não da erro
    @Override
    protected void onProgressUpdate(Object[] values) {
        //Esse método vai atualizar minha progressBar
        //Ele espera receber um vetor de objeto
        super.onProgressUpdate(values);

        //Definindo o ProgressBar como Vísivel


        //Para definir o progresso do progressBar ele espera receber um int
        //Como o values é um objeto é necessario fazer um cast para
        //Afirmar que o que vamos receber é um int mesmo
        progressBar.setProgress((Integer) values[0]);
    }

    //Esse método é executado após as operações do Async
    //Zerando ProgressBar e definindo como Invisible
    @Override
    protected void onPostExecute(Object o) {
        progressBar.setProgress(0);
        progressBar.setVisibility(View.INVISIBLE);
        super.onPostExecute(o);
    }
}
