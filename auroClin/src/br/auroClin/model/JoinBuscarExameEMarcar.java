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
public class JoinBuscarExameEMarcar {
    
    
    private int id_marcarBuscar;
    private String ExameRequerido;
    private String dataRealizar;
    private float valorExame;
    private String formaRealizar;
    private String nomeMedico;
    private String retorno;

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }
    
    
    

    public String getFormaRealizar() {
        return formaRealizar;
    }

    public void setFormaRealizar(String formaRealizar) {
        this.formaRealizar = formaRealizar;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }
    

     
     
   
     
    public int getId_marcarBuscar() {
        return id_marcarBuscar;
    }

    public void setId_marcarBuscar(int id_marcarBuscar) {
        this.id_marcarBuscar = id_marcarBuscar;
    }

    public String getExameRequerido() {
        return ExameRequerido;
    }

    public void setExameRequerido(String ExameRequerido) {
        this.ExameRequerido = ExameRequerido;
    }

    public String getDataRealizar() {
        return dataRealizar;
    }

    public void setDataRealizar(String dataRealizar) {
        this.dataRealizar = dataRealizar;
    }

    public float getValorExame() {
        return valorExame;
    }

    public void setValorExame(float valorExame) {
        this.valorExame = valorExame;
    }
    
    
    
    
}
