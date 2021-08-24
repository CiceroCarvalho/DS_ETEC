package com.example.recyclerviewestudo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Vai herdar da classe Recycler View, onde o Adapter vai esperar um ViewHolder
public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.MeuViewHolder> {

    //Criando variavel global de lista de filmes = arrayListFilme
    //Atribuindo valor a esse arraylist através do que recebemos na main activity
    ArrayList<DTOFilme> arrayListFilme;
    public MeuAdapter(ArrayList<DTOFilme> arrayListFilme) {
        this.arrayListFilme = arrayListFilme;
    }
    //Pede para gerar 3 métodos Abstratos
    //O 1 Cria o ViewHolder
    //O 2 Faz a ligação
    //O 3 define o tamanho dos itens da lista

    @NonNull
    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //É necessário associar esse adapter aos componentes do nosso dto
        //Para isso vamos pegar uma View, usar a classe LayoutInflater.from, ai vai pedir o contexto
        //Para pegar o contexto usa a claase parent.getContext, ele vai retornar um objeto
        //Ai vamos usar o inflate para pegar esse objeto e associar com o nosso adapter xml
        //Por fim vão pedir um parent, e depois um false

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.meu_adapter,parent,false);

        //Essa classe vai retornar um ViewHolder, assim instanciamos a classe e passamos nosso item
        //Para o meuViewHolder
        return new MeuViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuAdapter.MeuViewHolder holder, int position) {
        //Associando itens ao ViewHolder
        //Acessamos a lista e pegamos o valor que esta na position
        //Que esta na posição que mandamos ele pegar através do get
        //A imagem precisa do setImageResource

        holder.textViewNota.setText(arrayListFilme.get(position).getNota());
        holder.textViewTitulo.setText(arrayListFilme.get(position).getTitulo());
        holder.textViewGenero.setText(arrayListFilme.get(position).getGenero());
        holder.textViewAno.setText(arrayListFilme.get(position).getAno());
        holder.imageViewFilme.setImageResource(arrayListFilme.get(position).getIdImagem());
    }

    @Override
    public int getItemCount() {
        //A quantidade que tiver no meu arrayList é a quantidade que vai ser retornada
        return arrayListFilme.size();
    }

    //Dentro da classe teremos uma classe interna que sera o ViewHolder
    //Essa classe herdara também do Recycler, só que dessa vez será o ViewHolder
    //Vai ser pedido para gerar um construtor

    public class MeuViewHolder extends RecyclerView.ViewHolder{
        //Declarando nossos componentes do dto
        TextView textViewTitulo, textViewNota, textViewGenero, textViewAno;
        ImageView imageViewFilme;

        //Esse meuViewHolder esta recebendo um itemView que seria o nosso itemLista
        public MeuViewHolder(@NonNull View itemView) {
            super(itemView);

            //Nessa classe não existe o findview, para isso temos que usar o itemview que
            //vai associar com nosso xml
            //Assim associamos nosso Dto ao itemview(que é o itemLista)
            textViewAno = itemView.findViewById(R.id.textViewAno);
            textViewGenero = itemView.findViewById(R.id.textViewGenero);
            textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
            textViewNota = itemView.findViewById(R.id.textViewNota);
            imageViewFilme = itemView.findViewById(R.id.imageViewFilme);
        }
    }
}
