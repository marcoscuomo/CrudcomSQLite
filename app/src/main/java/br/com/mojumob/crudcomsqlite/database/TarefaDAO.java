package br.com.mojumob.crudcomsqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.mojumob.crudcomsqlite.helper.Common;
import br.com.mojumob.crudcomsqlite.model.Tarefa;

public class TarefaDAO {

    private SQLiteDatabase escreve, le;

    public TarefaDAO(Context context) {

        BDHelper bdHelper = new BDHelper(context);
        escreve = bdHelper.getWritableDatabase();
        le = bdHelper.getReadableDatabase();

    }

    public boolean salvar(Tarefa tarefa){

        ContentValues cv = getContentValues(tarefa);


        try{
            escreve.insert(Common.TABELA_CONTATO, null, cv);
            Log.i("INSERT", "salvado com sucesso: " + tarefa.getNomeTarefa());
        }catch (Exception e){
            Log.i("INSERT", "salvado com ERRO: " + tarefa.getNomeTarefa());
            return false;
        }
        return true;
    }

    public boolean atualizar(Tarefa tarefa){

        ContentValues cv = getContentValues(tarefa);

        try{
            String[] args = {tarefa.getId().toString()};
            escreve.update(Common.TABELA_CONTATO, cv, "id=?", args);
            Log.i("BD Update", "Sucesso");
        }catch (Exception e){
            Log.i("BD Update", "Erro");
            return false;
        }


        return true;
    }

    public List<Tarefa> listar(){

        List<Tarefa> listaTarefas = new ArrayList<>();

        String sql = Common.QUERY_SQL_SELECT_ALL;
        Cursor c = le.rawQuery(sql, null);

        while(c.moveToNext()){

            Tarefa tarefa = new Tarefa();

            Long idTarefa          = c.getLong(c.getColumnIndex(Common.CAMPO_ID));
            String nomeTarefa      = c.getString(c.getColumnIndex(Common.CAMPO_NOME_TAREFA));
            String descricaoTarefa = c.getString(c.getColumnIndex(Common.CAMPO_DESCRICAO_TAREFA));
            String statusTarefa    = c.getString(c.getColumnIndex(Common.CAMPO_STATUS_TAREFA));

            tarefa.setId(idTarefa);
            tarefa.setNomeTarefa(nomeTarefa);
            tarefa.setDescricaoTarefa(descricaoTarefa);
            tarefa.setStatusTarefa(statusTarefa);
        }


        return listaTarefas;
    }

    @NonNull
    private ContentValues getContentValues(Tarefa tarefa) {
        //Crianco o Content Values
        ContentValues cv = new ContentValues();
        cv.put(Common.PUT_NOME_TAREFA, tarefa.getNomeTarefa());
        cv.put(Common.PUT_DESCRICAO_TAREFA, tarefa.getDescricaoTarefa());
        cv.put(Common.PUT_STATUS_TAREFA, tarefa.getStatusTarefa());
        return cv;
    }

}
