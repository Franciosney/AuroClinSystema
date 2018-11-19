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
public class IrreporterRelatorioCaixa {
    
    
    private String medico;
    private String servico;
    private String precoTotal;
    private String valorPago;
    private String valorTerceiro;
    private String valorLucro;
    private String data;
    private String hora;
    private String beneficiario;
    private String tranzacoes;
    private String somaTerceiro;

    public IrreporterRelatorioCaixa(String medico, String servico, String precoTotal, String valorPago, String valorTerceiro, String valorLucro, String data, String hora, String beneficiario, String tranzacoes, String somaTerceiro) {
        this.medico = medico;
        this.servico = servico;
        this.precoTotal = precoTotal;
        this.valorPago = valorPago;
        this.valorTerceiro = valorTerceiro;
        this.valorLucro = valorLucro;
        this.data = data;
        this.hora = hora;
        this.beneficiario = beneficiario;
        this.tranzacoes = tranzacoes;
        this.somaTerceiro = somaTerceiro;
    }

    
    
    
    
    
    public String getTranzacoes() {
        return tranzacoes;
    }

    public void setTranzacoes(String tranzacoes) {
        this.tranzacoes = tranzacoes;
    }

    public String getSomaTerceiro() {
        return somaTerceiro;
    }

    public void setSomaTerceiro(String somaTerceiro) {
        this.somaTerceiro = somaTerceiro;
    }

 
    
    
    
    
    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(String precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getValorPago() {
        return valorPago;
    }

    public void setValorPago(String valorPago) {
        this.valorPago = valorPago;
    }

    public String getValorTerceiro() {
        return valorTerceiro;
    }

    public void setValorTerceiro(String valorTerceiro) {
        this.valorTerceiro = valorTerceiro;
    }

    public String getValorLucro() {
        return valorLucro;
    }

    public void setValorLucro(String valorLucro) {
        this.valorLucro = valorLucro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }
  

    
    
    
    
    
}
