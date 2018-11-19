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
public class finalizarMarcar {
    private int idMarcar;
    private int id_finalizarMarcar;
    private int id_dataMarcar;
    private int id_paciente;
    private int id_medico;
    private int id_caixa;
    private String situacao;
    private String formaPagamento;
    private String situacaoFila;
     private String retorno;

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }
     
     
    

    public int getIdMarcar() {
        return idMarcar;
    }

    public void setIdMarcar(int idMarcar) {
        this.idMarcar = idMarcar;
    }

  
    
    
    
    public String getSituacaoFila() {
        return situacaoFila;
    }

    public void setSituacaoFila(String situacaoFila) {
        this.situacaoFila = situacaoFila;
    }
    
    

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    

    
    public int getId_caixa() {
        return id_caixa;
    }

    public void setId_caixa(int id_caixa) {
        this.id_caixa = id_caixa;
    }
    
    
 


    

    public int getId_finalizarMarcar() {
        return id_finalizarMarcar;
    }

    public void setId_finalizarMarcar(int id_finalizarMarcar) {
        this.id_finalizarMarcar = id_finalizarMarcar;
    }

    public int getId_dataMarcar() {
        return id_dataMarcar;
    }

    public void setId_dataMarcar(int id_dataMarcar) {
        this.id_dataMarcar = id_dataMarcar;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }
    
    
    
    
    
    
    
}
