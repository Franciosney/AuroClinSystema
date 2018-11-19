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
public class IreporterConsultas {
    
    private String nome;
     private String tipo;
     private String data;
     private String medico;
      private String hr;
      private String receita;

    public IreporterConsultas(String nome, String tipo, String data, String medico, String hr, String receita) {
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.medico = medico;
        this.hr = hr;
        this.receita = receita;
    }

  
      
    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

      
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }
     
     

      
}
