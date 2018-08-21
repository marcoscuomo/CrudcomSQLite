package br.com.mojumob.crudcomsqlite.model;

import java.io.Serializable;

public class Tarefa implements Serializable {

    private String nomeTarefa;
    private String descricaoTarefa;
    private String statusTarefa;
    private Long id;


    public Tarefa(String nomeTarefa, String descricaoTarefa, String statusTarefa) {
        this.nomeTarefa = nomeTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.statusTarefa = statusTarefa;
    }

    public Tarefa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
