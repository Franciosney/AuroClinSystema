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
public class joinBuscarConsultaMarcar {
    
     private int id_marcarBuscar;
    private String ConsultaRequerido;
    private String dataRealizar;
    private String horario;
    private float valorConsulta;

    
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getId_marcarBuscar() {
        return id_marcarBuscar;
    }

    public void setId_marcarBuscar(int id_marcarBuscar) {
        this.id_marcarBuscar = id_marcarBuscar;
    }

    public String getConsultaRequerido() {
        return ConsultaRequerido;
    }

    public void setConsultaRequerido(String ConsultaRequerido) {
        this.ConsultaRequerido = ConsultaRequerido;
    }

    public String getDataRealizar() {
        return dataRealizar;
    }

    public void setDataRealizar(String dataRealizar) {
        this.dataRealizar = dataRealizar;
    }

    public float getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(float valorConsulta) {
        this.valorConsulta = valorConsulta;
    }
    
    
    
    
}
