/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.model;

/**
 *
 * @author Franciosney Souza
 */
public class relatorioExame {
    
    
    
     private int id_marcar;
     private int id_retorno;
     private String nomeBusca;
     private String dataFazer;
     private String nomePAciente;
     private String nomeMedico;
     private String horarios;
     private String retorno;
     private String situacaoFila;
     private float valorExame;
     private String plano;
     private String desc;

     
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

     
     
    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public float getValorExame() {
        return valorExame;
    }

    public void setValorExame(float valorExame) {
        this.valorExame = valorExame;
    }
   
    public int getId_marcar() {
        return id_marcar;
    }

    public void setId_marcar(int id_marcar) {
        this.id_marcar = id_marcar;
    }

    public int getId_retorno() {
        return id_retorno;
    }

    public void setId_retorno(int id_retorno) {
        this.id_retorno = id_retorno;
    }

    public String getSituacaoFila() {
        return situacaoFila;
    }

    public void setSituacaoFila(String situacaoFila) {
        this.situacaoFila = situacaoFila;
    }
     
     
     

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }
     
     

    public String getNomeBusca() {
        return nomeBusca;
    }

    public void setNomeBusca(String nomeBusca) {
        this.nomeBusca = nomeBusca;
    }

    public String getDataFazer() {
        return dataFazer;
    }

    public void setDataFazer(String dataFazer) {
        this.dataFazer = dataFazer;
    }

    public String getNomePAciente() {
        return nomePAciente;
    }

    public void setNomePAciente(String nomePAciente) {
        this.nomePAciente = nomePAciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }
     
     
    
    
    
}
