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
public class retornoModelo {
    
    private int id_paciente;
    private int id_marcar;
    private String retorno;
    private int idMarcado;

    public int getIdMarcado() {
        return idMarcado;
    }

    public void setIdMarcado(int idMarcado) {
        this.idMarcado = idMarcado;
    }
    
    
    

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_marcar() {
        return id_marcar;
    }

    public void setId_marcar(int id_marcar) {
        this.id_marcar = id_marcar;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }
    
    
    
    
}
