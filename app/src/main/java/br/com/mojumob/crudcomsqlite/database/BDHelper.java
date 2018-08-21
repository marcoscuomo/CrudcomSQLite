package br.com.mojumob.crudcomsqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.com.mojumob.crudcomsqlite.helper.Common;

public class BDHelper extends SQLiteOpenHelper {

    //Construtor
    public BDHelper(Context context) {
        super(context, Common.NOME_BD, null, Common.VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Query de criacao da tabela de contatos
        String sql = "CREATE TABLE IF NOT EXISTS " + Common.TABELA_CONTATO + Common.CAMPOS_BD;

        try{
            db.execSQL(sql);
            Log.i("INFO DB", "Tabela " + Common.TABELA_CONTATO + " criada com sucesso!");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
