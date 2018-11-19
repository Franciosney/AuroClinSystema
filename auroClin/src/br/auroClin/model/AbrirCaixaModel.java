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
public class AbrirCaixaModel {
    
      private int id_AbrirCAixa;
    private String dataAbrir;
    private String dataFechar;
    private int id_statos;
    private double valorCaixa;
    private double valorCartao;

    public double getValorCartao() {
        return valorCartao;
    }

    public void setValorCartao(double valorCartao) {
        this.valorCartao = valorCartao;
    }

    public int getId_statos() {
        return id_statos;
    }

    public void setId_statos(int id_statos) {
        this.id_statos = id_statos;
    }

    public double getValorCaixa() {
        return valorCaixa;
    }

    public void setValorCaixa(double valorCaixa) {
        this.valorCaixa = valorCaixa;
    }
    
    

    public int getId_AbrirCAixa() {
        return id_AbrirCAixa;
    }

    public void setId_AbrirCAixa(int id_AbrirCAixa) {
        this.id_AbrirCAixa = id_AbrirCAixa;
    }

    public String getDataAbrir() {
        return dataAbrir;
    }

    public void setDataAbrir(String dataAbrir) {
        this.dataAbrir = dataAbrir;
    }

    public String getDataFechar() {
        return dataFechar;
    }

    public void setDataFechar(String dataFechar) {
        this.dataFechar = dataFechar;
    }
    
    
    
}
