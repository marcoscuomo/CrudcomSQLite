package br.com.mojumob.crudcomsqlite.model;

public class Tarefa {

    private String nomeTarefa;
    private String descricaoTarefa;
    private String statusTarefa;

    public Tarefa(String nomeTarefa, String descricaoTarefa, String statusTarefa) {
        this.nomeTarefa = nomeTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.statusTarefa = statusTarefa;
    }

    public Tarefa() {
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public String getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(String statusTarefa) {
        this.statusTarefa = statusTarefa;
    }
}
