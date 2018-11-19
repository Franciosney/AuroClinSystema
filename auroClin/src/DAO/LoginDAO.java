/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.ControleLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Franciosney Souza
 */
public class LoginDAO {
    
    
        private Connection conecta;
    
    public LoginDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
     public boolean FazerLogin(String cpf,String senha){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "select funcionario.id_funcionario, funcionario.cpf, funcionario.senha from funcionario where cpf =? and senha=?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, cpf);
             stmt.setString(2, senha);
             
             ResultSet rs = stmt.executeQuery();
             
             ControleLog c = new ControleLog();
        
             
             if (rs.first()) {
                 
                 c.setId_funcionario(rs.getInt("id_funcionario"));
              
            
                 
                 //fez login
               
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }

  
     
     
     
     
     
     
     
       public boolean FazerMedico(String cpf,String senha){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "select medico.nomeMedico,medico.id_medico, medico.cpf, medico.senha from medico where cpf =? and senha=?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, cpf);
             stmt.setString(2, senha);
             
             ResultSet rs = stmt.executeQuery();
             
            
             
             if (rs.first()) {
                 
                 ControleLog.setNomeMedico(rs.getString("nomeMedico"));
                 ControleLog.setId_medico(rs.getInt("id_medico"));
                 
             
                 
                 
                 //fez login
                 
                 return true;
             } 
             
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }

     
     
     
     
     
     
     
     
     
     
     
     
     
    
}
