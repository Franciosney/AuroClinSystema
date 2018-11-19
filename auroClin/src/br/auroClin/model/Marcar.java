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
public class Marcar {
    
    private int id_marcar;
    private String dataAbrir;
    private String dataFazer;
    private String NomeParaJoin;
    private String agendar;
    private int id_exame;
    private int id_consulta;
     private String horario;
     private int id_medico;
     private String nomeMedico;
     private float valorExame;

     
    public float getValorExame() {
        return valorExame;
    }

    public void setValorExame(float valorExame) {
        this.valorExame = valorExame;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }
     
     

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }
     
     

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
     
     

    public String getNomeParaJoin() {
        return NomeParaJoin;
    }

    public void setNomeParaJoin(String NomeParaJoin) {
        this.NomeParaJoin = NomeParaJoin;
    }
    
    
    public String getDataAbrir() {
        return dataAbrir;
    }

    public void setDataAbrir(String dataAbrir) {
        this.dataAbrir = dataAbrir;
    }

    
    
    
    public int getId_marcar() {
        return id_marcar;
    }

    public void setId_marcar(int id_marcar) {
        this.id_marcar = id_marcar;
    }

 

    public String getDataFazer() {
        return dataFazer;
    }

    public void setDataFazer(String dataFazer) {
        this.dataFazer = dataFazer;
    }

    public String getAgendar() {
        return agendar;
    }

    public void setAgendar(String agendar) {
        this.agendar = agendar;
    }

    public int getId_exame() {
        return id_exame;
    }

    public void setId_exame(int id_exame) {
        this.id_exame = id_exame;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }
    
    
    
    
    
    
}
