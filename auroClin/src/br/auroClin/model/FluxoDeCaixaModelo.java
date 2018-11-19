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
public class FluxoDeCaixaModelo {
    
     
    private int id_venda;
    private String dataVenda;
    private String nomePaciente;
    private String servico;
    private double preco;
    private String dataRelizarServico;
    private String plano;
    private double desconto;
    private double DescontoIndividual;
    private double valorTotal;
    private String situacao;
    private String formaPagamento;
     private float valorVenda;

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
     
    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public double getDescontoIndividual() {
        return DescontoIndividual;
    }

    public void setDescontoIndividual(double DescontoIndividual) {
        this.DescontoIndividual = DescontoIndividual;
    }

    
    
    
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    
    

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }
    
    

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDataRelizarServico() {
        return dataRelizarServico;
    }

    public void setDataRelizarServico(String dataRelizarServico) {
        this.dataRelizarServico = dataRelizarServico;
    }
    
    
    

    
}
