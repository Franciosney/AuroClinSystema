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
public class ControleLog {
    
    static private int id_funcionario;
    static private String nomeFuncionario;
    static private int id_medico;
    static private String nomeMedico;

    public static String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public static void setNomeFuncionario(String nomeFuncionario) {
        ControleLog.nomeFuncionario = nomeFuncionario;
    }

    public static int getId_medico() {
        return id_medico;
    }

    public static void setId_medico(int id_medico) {
        ControleLog.id_medico = id_medico;
    }

    public static String getNomeMedico() {
        return nomeMedico;
    }

    public static void setNomeMedico(String nomeMedico) {
        ControleLog.nomeMedico = nomeMedico;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
    
    
    
}
