package br.com.mojumob.crudcomsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import br.com.mojumob.crudcomsqlite.adapter.AdapterTarefa;
import br.com.mojumob.crudcomsqlite.model.Tarefa;

public class MainActivity extends AppCompatActivity {

    //Atributos
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private AdapterTarefa adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializações
        recyclerView = findViewById(R.id.recyclerViewTarefas);
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



    }

    private void configuraRecyclerView() {
        /*Configurando o RecyclerView*/
        //Adapter
        adapter = new AdapterTarefa(MainActivity.this, listaTarefas);

        //Configurações gerais do RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }


}
