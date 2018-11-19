/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.AbrirCaixaModel;
import br.auroClin.model.Exame;
import br.auroClin.model.planoMODELO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Franciosney Souza
 */
public class planosDAO {
    
    
          private Connection conecta;
    
    public planosDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
     public void cadastrarPlano(planoMODELO objp){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into planos (nomePlano,desconto) values(?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, objp.getNomePlano());
              stmt.setFloat(2, objp.getDesconto());
                System.out.println("Teste "+objp.getNomePlano());
              
      
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro no banco de dados, contate o suporte técnico do sistema"+erro);
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
     }
    
     
     
     
     
     
      public List<planoMODELO> BuscarPlanosParaComobox(){
     
     List<planoMODELO> lista = new ArrayList<planoMODELO>();
     
         try {
              String cmsqlb = "SELECT * FROM planos";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 planoMODELO objc = new planoMODELO();
                 objc.setId_plano(rs.getInt("id_plano"));
                // objc.setNomePlano(rs.getString("nomePlano"));
                 lista.add(objc);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "erro"+e);
         }
              return  lista;
     
     }  
     
     
     
     
     
     
     
     public boolean validarplano(String nomePlano){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "SELECT planos.nomePlano FROM `planos` WHERE planos.nomePlano = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, nomePlano);
         
             
             ResultSet rs = stmt.executeQuery();
             
             if (rs.first()) {
                 
                 //fez login
                 
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }
     
     
     
     
     
     
     
     public void excluirPlano(planoMODELO objp){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "DELETE FROM `planos` WHERE planos.id_plano = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setInt(1, objp.getId_plano());
                System.out.println("Teste "+objp.getNomePlano());
              
      
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro no banco de dados, contate o suporte técnico do sistema"+erro);
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
     }
    
     
    
     
      public List<planoMODELO> listarPlanos(){
     
     List<planoMODELO> lista = new ArrayList<planoMODELO>();
     
         try {
              String cmsqlb = "select * from planos";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                planoMODELO objp = new planoMODELO();
                 objp.setId_plano(rs.getInt("id_plano"));
                 objp.setNomePlano(rs.getString("nomePlano"));
                 objp.setDesconto(rs.getFloat("desconto"));
                 lista.add(objp);
                 
                 
             }
        
             
         }catch (Exception e) {
         }
              return  lista;
     
     }  
    
    
   
      
      
        public void editarPlanos(String nomePlano,float valorDesconto, int idPlano){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "update planos set nomePlano = ?,desconto = ?  where id_plano = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, nomePlano);
             stmt.setFloat(2, valorDesconto);
             stmt.setInt(3, idPlano);
         
         
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro ao Efetuar Pagamento"+erro);
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
       
        }
        
        
        
        public void editarPlanosEmPacientes(String nomePlano, int idPlano){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "UPDATE paciente SET paciente.plano = ? WHERE paciente.id_plano = ?;";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, nomePlano);
             stmt.setInt(2, idPlano);
         
         
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro ao Efetuar Pagamento"+erro);
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
       
        }
    
    
}
