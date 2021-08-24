package com.example.recyclerviewestudo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<DTOFilme> arrayListFilme = new ArrayList<>();
    RecyclerView recyclerViewFilme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewFilme = findViewById(R.id.recyclerViewFilme);

        //É necessário criar um adapter para o array, só que dessa vez vamos usar nosso
        //adapter personalizado, para isso tem que criar uma classe MeuAdapter
        //ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayListFilme);
        //Em vez de usar o arrayAdapter, vamos usar o meuAdapter

        carregaFilmes();

        //Passando lista de filmes via construtor para o meu adapter
        MeuAdapter meuAdapter = new MeuAdapter(arrayListFilme);

        //Precisamos definir o layout que vai aparecer os itens, para isso precisa do setLayoutManager,
        //ele recebe como construtor o contexto main
        recyclerViewFilme.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //Definindo o Adapter
        recyclerViewFilme.setAdapter(meuAdapter);

        //O addOn espera receber 3 parametros, o contexto, o item é a interface que vai ser gerada
        recyclerViewFilme.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerViewFilme,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Pegando na lista de filmes o nome do filme
                        String nome = arrayListFilme.get(position).getTitulo();
                        Toast.makeText(MainActivity.this, "Nome: " + nome, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        //Pegando na lista de filmes a nota do filme
                        String nota = arrayListFilme.get(position).getNota();
                        Toast.makeText(MainActivity.this, "Nota: " + nota, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }));
    }
    //Definir os filmes, atribuindo valores via construtor
    //Para passar as imagens é necessário acessar a pasta drawnble
    //Ele espera receber um int para a imagem
    private void carregaFilmes(){
        DTOFilme filme = new DTOFilme("Um sonho de liberdade","1984","9.2","Drama",R.drawable.sonho);
        DTOFilme filme2 = new DTOFilme("O poderoso chefão","1972","9.1","Drama",R.drawable.chefao1);
        DTOFilme filme3 = new DTOFilme("O poderoso chefão 2","1974","9.0","Drama",R.drawable.chefao2);
        DTOFilme filme4 = new DTOFilme("Batman: O Cavaleiro das Trevas","2008","9.0","Aventura",R.drawable.batman);
        DTOFilme filme5 = new DTOFilme("12 Homens e uma Sentença","1957","8.9","Drama",R.drawable.sentenca);
        DTOFilme filme6 = new DTOFilme("A Lista de Schindler","1993","8.9","Drama",R.drawable.lista);

        //Adicionando filmes ao ArrayList
        arrayListFilme.add(filme);
        arrayListFilme.add(filme2);
        arrayListFilme.add(filme3);
        arrayListFilme.add(filme4);
        arrayListFilme.add(filme5);
        arrayListFilme.add(filme6);
    }
}