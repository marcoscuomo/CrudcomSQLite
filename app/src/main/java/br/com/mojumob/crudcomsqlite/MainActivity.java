package br.com.mojumob.crudcomsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;
import br.com.mojumob.crudcomsqlite.adapter.AdapterTarefa;
import br.com.mojumob.crudcomsqlite.helper.Common;
import br.com.mojumob.crudcomsqlite.helper.RecyclerItemClickListener;
import br.com.mojumob.crudcomsqlite.model.Tarefa;

public class MainActivity extends AppCompatActivity {

    //Atributos
    private RecyclerView recyclerViewTarefas;
    private FloatingActionButton fab;
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private AdapterTarefa adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializações
        recyclerViewTarefas = findViewById(R.id.recyclerViewTarefas);
        fab          = findViewById(R.id.fab);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Configurando evento de clique no FAB
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddTarefaActivity.class));
            }
        });

        //Criando lista para teste

        Tarefa tarefa1 = new Tarefa("Fazer compras", "Fazer compras no mercado", "A fazer");
        Tarefa tarefa2 = new Tarefa("Ir a escola", "Pegar comprovate de escolaridade", "Fazendo");
        Tarefa tarefa3 = new Tarefa("Passear com o cachorro", "Levar o billy para passear", "Feito");
        listaTarefas.add(tarefa1);
        listaTarefas.add(tarefa2);
        listaTarefas.add(tarefa3);


        configuraRecyclerView();

        //Configurando evento de clique no Recycler View
        recyclerViewTarefas.addOnItemTouchListener(new RecyclerItemClickListener(
                MainActivity.this, recyclerViewTarefas,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Atualizar uma tarefa
                        Tarefa tarefaSelecioanda = listaTarefas.get(position);
                        Intent intent = new Intent(MainActivity.this, AddTarefaActivity.class);
                        intent.putExtra(Common.INTENT_TAREFA_SELECIONADA, tarefaSelecioanda);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                        //Excluir um atarefa

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));



    }

    private void configuraRecyclerView() {
        /*Configurando o RecyclerView*/
        //Adapter
        adapter = new AdapterTarefa(MainActivity.this, listaTarefas);

        //Configurações gerais do RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerViewTarefas.setLayoutManager(layoutManager);
        recyclerViewTarefas.setHasFixedSize(true);
        recyclerViewTarefas.setAdapter(adapter);
    }


}
