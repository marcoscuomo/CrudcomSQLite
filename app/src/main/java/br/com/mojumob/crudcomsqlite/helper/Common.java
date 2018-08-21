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
    public static String TABELA_CONTATO = "tabela_contato";
    public static String CAMPOS_BD = "(id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa TEXT NOT NULL, descricao TEXT, status TEXT); ";
    public static String PUT_NOME_TAREFA = "nomeTarefa";
    public static String PUT_DESCRICAO_TAREFA = "descricaoTarefa";
    public static String PUT_STATUS_TAREFA = "statusTarefa";
}
