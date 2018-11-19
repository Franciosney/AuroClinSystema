/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.Consulta;
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
public class ConsultaDAO {
    
    
      private Connection conecta;
    
    public ConsultaDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
     public void cadastrarConsulta(Consulta objconsult){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into consulta(tipo_consulta,valor_consulta,lucro)values(?,?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, objconsult.getNomeConsulta());
             stmt.setFloat(2, objconsult.getValorConsulta());
             stmt.setFloat(3, objconsult.getLucro());
         
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro ao cadastrar Consulta"+erro);
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
    
    }
    
    //-------------------------------------- fim cadastrar paciente
    
    
     public boolean validarConsulta(String nomeConsulta){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "select consulta.tipo_consulta from consulta where consulta.tipo_consulta=?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, nomeConsulta);
         
             
             ResultSet rs = stmt.executeQuery();
             
             if (rs.first()) {
                 
                 //fez login
                 
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }

     
     
     
     public List<Consulta> listarConsultas(){
     
     List<Consulta> lista = new ArrayList<Consulta>();
     
         try {
              String cmsqlb = "select consulta.id_consulta,consulta.tipo_consulta,consulta.valor_consulta,consulta.lucro from consulta";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                Consulta objc = new Consulta();
                 objc.setId_consulta(rs.getInt("id_consulta"));
                 objc.setNomeConsulta(rs.getString("consulta.tipo_consulta"));
                 objc.setValorConsulta(rs.getFloat("valor_consulta"));
                 objc.setLucro(rs.getFloat("lucro"));
                 lista.add(objc);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
     
     
     
      public List<Consulta> listarConsultaPorNome(String nome){
     
     List<Consulta> lista = new ArrayList<Consulta>();
     
         try {
              String cmsqlb = "SELECT * FROM consulta WHERE consulta.tipo_consulta LIKE ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, '%'+nome+'%');
          
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Consulta objc = new Consulta();
                 objc.setId_consulta(rs.getInt("id_consulta"));
                 objc.setNomeConsulta(rs.getString("tipo_consulta"));
                 objc.setValorConsulta(rs.getFloat("valor_consulta"));
                 objc.setLucro(rs.getFloat("lucro"));
                 lista.add(objc);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
    
       
       
       
       
     public void editarConsulta(Consulta objc){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "update consulta set tipo_consulta=?, valor_Consulta=?,consulta.lucro = ? where id_consulta=?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, objc.getNomeConsulta());
             stmt.setFloat(2, objc.getValorConsulta());
             stmt.setFloat(3, objc.getLucro());
             stmt.setInt(4, objc.getId_consulta());
         
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro ao Edicat Consulta"+erro);
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
    
    }
    
    //-------------------------------------- fim cadastrar paciente
    
     
     
     
     
     
      public List<Consulta> BuscarConsultaParaComobox(){
     
     List<Consulta> lista = new ArrayList<Consulta>();
     
         try {
              String cmsqlb = "select consulta.tipo_consulta from consulta";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Consulta objc = new Consulta();
                 objc.setNomeConsulta(rs.getString("tipo_consulta"));
                 lista.add(objc);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "erro"+e);
         }
              return  lista;
     
     }  
     
     
     
    
}
