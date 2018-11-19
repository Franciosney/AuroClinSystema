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
public class Caixa {
    
    private int id_caixa;
    private String horaVenda;
    private float valorVenda;
    private String statosVenda;
    private String id_convenio;

    public String getId_convenio() {
        return id_convenio;
    }

    public void setId_convenio(String id_convenio) {
        this.id_convenio = id_convenio;
    }
    
    

    public int getId_caixa() {
        return id_caixa;
    }

    public void setId_caixa(int id_caixa) {
        this.id_caixa = id_caixa;
    }

    public String getHoraVenda() {
        return horaVenda;
    }

    public void setHoraVenda(String horaVenda) {
        this.horaVenda = horaVenda;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getStatosVenda() {
        return statosVenda;
    }

    public void setStatosVenda(String statosVenda) {
        this.statosVenda = statosVenda;
    }
    
    
    
    
    
    
    
    
}
