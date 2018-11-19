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
public class imprimirComprovanteModelo {
    
    private String paciente;
    private String cpf;
    private String nomeExame;
    private String data;
    private String forma;
    private String valor;
    private String plano;
    private String desc;
    private String porcentagem;
    private String medico;
    private String receita;

    
    
    
    public imprimirComprovanteModelo(String paciente, String cpf, String nomeExame, String data, String forma, String valor, String plano, String desc, String porcentagem, String medico, String receita) {
        this.paciente = paciente;
        this.cpf = cpf;
        this.nomeExame = nomeExame;
        this.data = data;
        this.forma = forma;
        this.valor = valor;
        this.plano = plano;
        this.desc = desc;
        this.porcentagem = porcentagem;
        this.medico = medico;
        this.receita = receita;
    }
    
    

 

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    
    
    
    
    
    
    
    
    public String getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(String porcentagem) {
        this.porcentagem = porcentagem;
    }

    
    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    


    
    
    
    

    public imprimirComprovanteModelo(String paciente) {
        this.paciente = paciente;
    }

   
    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

 
    
}
