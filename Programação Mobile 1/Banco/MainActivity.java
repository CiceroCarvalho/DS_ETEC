package com.example.cadastrocontatossqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonAdicionarNovo;
    ListView listviewContato;
    ArrayList<DtoContato> arrayListContato;
    EditText editTextPesquisaNome;

    DaoContato daoContato = new DaoContato(MainActivity.this);
    DtoContato contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdicionarNovo = findViewById(R.id.buttonAdicionarNovo);
        listviewContato = findViewById(R.id.listviewContato);
        editTextPesquisaNome = findViewById(R.id.editTextPesquisaNome);

        listviewContato.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int posicao, long id) {
                contato = arrayListContato.get(posicao);
                registerForContextMenu(listviewContato);
                return false;
            }
        });

        editTextPesquisaNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                arrayListContato = daoContato.consultarPorNome(s.toString());
                atualizarListView();
            }
        });

        buttonAdicionarNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inclusao = new Intent(MainActivity.this, InclusaoActivity.class);
                startActivity(inclusao);
            }
        });

        arrayListContato = daoContato.consultarTodos();

        atualizarListView();

    }

    private void atualizarListView() {
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayListContato);
        listviewContato.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Ligar");
        menu.add(0,1,1,"Detalhes / Alterar");
        menu.add(0,2,2,"Excluir");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==0)
        {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+contato.getTelefone()));
            startActivity(intent);
        }
        else if(item.getItemId()==1)
        {
            Intent intent = new Intent(MainActivity.this,DetalhesActivity.class);
            intent.putExtra("id",contato.getId());
            intent.putExtra("nome",contato.getNome());
            intent.putExtra("email",contato.getEmail());
            intent.putExtra("telefone",contato.getTelefone());
            startActivity(intent);
        }
        else{
            excluir();
        }

        return super.onContextItemSelected(item);
    }

    private void excluir() {
        AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
        msg.setMessage("Confirma a exclusão?");
        msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int deletados = daoContato.excluir(contato);
                if(deletados>0){
                    Toast.makeText(MainActivity.this, "Excluído com sucesso!", Toast.LENGTH_SHORT).show();
                    arrayListContato = daoContato.consultarTodos();
                    atualizarListView();
                }
                else{
                    Toast.makeText(MainActivity.this, "Erro ao Excluir!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        msg.setNegativeButton("Não", null);
        msg.show();
    }
}