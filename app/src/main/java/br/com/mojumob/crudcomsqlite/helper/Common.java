package br.com.mojumob.crudcomsqlite.helper;

public class Common {

    public static String FEITO = "Feito";
    public static String A_FAZER = "A fazer";
    public static String FAZENDO = "Fazendo";
    public static int A_FAZER_POSITION = 0;
    public static int FAZENDO_POSITION = 1;
    public static int FEITO_POSITION = 2;
    public static String INTENT_TAREFA_SELECIONADA = "intent tarefa selecionada";
    public static int VERSION_BD = 1;
    public static String NOME_BD = "bdcontato";
    public static String TABELA_TAREFA = "tabela_tarefa";
    public static String CAMPO_ID = "id";
    public static String CAMPO_NOME_TAREFA = "tarefa";
    public static String CAMPO_DESCRICAO_TAREFA = "descricao";
    public static String CAMPO_STATUS_TAREFA = "status";
    public static String PUT_NOME_TAREFA = "nomeTarefa";
    public static String PUT_DESCRICAO_TAREFA = "descricaoTarefa";
    public static String PUT_STATUS_TAREFA = "statusTarefa";
    public static String QUERY_SQL_SELECT_ALL = "SELECT * FROM " + TABELA_TAREFA + " ;";
    public static String CAMPOS_BD = "(" + CAMPO_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CAMPO_NOME_TAREFA +" TEXT NOT NULL, "+ CAMPO_DESCRICAO_TAREFA +" TEXT, "+
            CAMPO_STATUS_TAREFA +" TEXT); ";

}
