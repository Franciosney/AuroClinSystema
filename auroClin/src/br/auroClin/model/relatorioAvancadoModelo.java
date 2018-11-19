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
public class relatorioAvancadoModelo {
    
    
    private String medico;
    private String exameConsulta;
    private String valor;
    private String plano;
    private String desconto;
    private String data;
    private String cliente;
    private String receita;

    public relatorioAvancadoModelo(String medico, String exameConsulta, String valor, String plano, String desconto, String data, String cliente, String receita) {
        this.medico = medico;
        this.exameConsulta = exameConsulta;
        this.valor = valor;
        this.plano = plano;
        this.desconto = desconto;
        this.data = data;
        this.cliente = cliente;
        this.receita = receita;
    }

    
    
    
    
    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getExameConsulta() {
        return exameConsulta;
    }

    public void setExameConsulta(String exameConsulta) {
        this.exameConsulta = exameConsulta;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }
    
    
    
    
    
    
    
    
}
