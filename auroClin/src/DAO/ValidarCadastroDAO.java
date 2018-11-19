/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Franciosney Souza
 */
public class ValidarCadastroDAO {
    
    
    
     private Connection conecta;
    
    public ValidarCadastroDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
     public boolean validarPaciente(String cpf){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "select paciente.cpf from paciente WHERE cpf =?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, cpf);
             
             
             ResultSet rs = stmt.executeQuery();
             
             if (rs.first()) {
                 
                 //Paciente Existente
                 
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, e);
         }
     
         
           return false;
     }

    
     
     
      
     public boolean validarFuncionario(String cpf){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "select funcionario.cpf from funcionario WHERE cpf =?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, cpf);
             
             
             ResultSet rs = stmt.executeQuery();
             
             if (rs.first()) {
                 
                 //Paciente Existente
                 
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, e);
         }
     
         
           return false;
     }

    
     public boolean validarEnfermeiro(String cpf){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "select funcionario.cpf from funcionario WHERE cpf =?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, cpf);
             
             
             ResultSet rs = stmt.executeQuery();
             
             if (rs.first()) {
                 
                 //Paciente Existente
                 
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, e);
         }
     
         
           return false;
     }
     
     
     
     
     
     
     
     
       public boolean validarMedico(String cpf){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "select medico.cpf from medico WHERE cpf =?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, cpf);
             
             
             ResultSet rs = stmt.executeQuery();
             
             if (rs.first()) {
                 
                 //Paciente Existente
                 
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, e);
         }
     
         
           return false;
     }

    
    
     
     
     
     
     
     
     
     
     
     
    
}
