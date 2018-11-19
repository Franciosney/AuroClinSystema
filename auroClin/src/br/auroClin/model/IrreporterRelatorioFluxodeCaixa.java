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
public class IrreporterRelatorioFluxodeCaixa {
    
    private String servico;
    private String valorPago;
    private String formaPaga;
    private String vendedor;
    private String dataVenda;
    private String hora;
    private String obs;
    private String bruto;

    
    
    public IrreporterRelatorioFluxodeCaixa(String servico, String valorPago, String formaPaga, String vendedor, String dataVenda, String hora, String obs, String bruto) {
        this.servico = servico;
        this.valorPago = valorPago;
        this.formaPaga = formaPaga;
        this.vendedor = vendedor;
        this.dataVenda = dataVenda;
        this.hora = hora;
        this.obs = obs;
        this.bruto = bruto;
    }

    
    public String getBruto() {
        return bruto;
    }

    public void setBruto(String bruto) {
        this.bruto = bruto;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getValorPago() {
        return valorPago;
    }

    public void setValorPago(String valorPago) {
        this.valorPago = valorPago;
    }

    public String getFormaPaga() {
        return formaPaga;
    }

    public void setFormaPaga(String formaPaga) {
        this.formaPaga = formaPaga;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
    
    
    
    
    
    
    
}
