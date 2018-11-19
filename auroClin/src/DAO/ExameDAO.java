/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.Exame;

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
public class ExameDAO {
    
       private Connection conecta;
    
    public ExameDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
     public void cadastrarExame(Exame obje){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into exame(tipo_exame,valor_exame,lucro)values(?,?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, obje.getNomeExame());
             stmt.setFloat(2, obje.getValorExame());
             stmt.setFloat(3, obje.getLucro());
         
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro ao cadastrar Exame"+erro);
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
    
    }
    
    //-------------------------------------- fim cadastrar paciente
    
    
    
    
    //listar Exames
     
     public List<Exame> listarExames(){
     
     List<Exame> lista = new ArrayList<Exame>();
     
         try {
              String cmsqlb = "select * from exame";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Exame ex = new Exame();
                 ex.setId_exame(rs.getInt("id_exame"));
                 ex.setNomeExame(rs.getString("tipo_exame"));
                 ex.setValorExame(rs.getFloat("valor_exame"));
                 ex.setLucro(rs.getFloat("lucro"));
                 lista.add(ex);
                 
                 
             }
        
             
         }catch (Exception e) {
         }
              return  lista;
     
     }  
    
    
    
    
     
     
     
     
     
     
         //Validar Exames
     
     public boolean validarExame(String nomeExame){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "SELECT exame.valor_exame FROM exame WHERE exame.tipo_exame =?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, nomeExame);
         
             
             ResultSet rs = stmt.executeQuery();
             
             if (rs.first()) {
                 
                 //fez login
                 
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }

     
     
     
     
     
       public void editarExame(Exame obje){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "update exame set tipo_exame=?, valor_exame=? , lucro = ? where id_exame=?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, obje.getNomeExame());
             stmt.setFloat(2, obje.getValorExame());
             stmt.setFloat(3, obje.getLucro());
             stmt.setInt(4, obje.getId_exame());
         
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro ao cadastrar Exame"+erro);
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
    
    }
    
    //-------------------------------------- fim cadastrar paciente
    
   
     
     
     
       
       
       
       
       //listar Exames
     
     public List<Exame> listarExamesPorNome(String nome){
     
     List<Exame> lista = new ArrayList<Exame>();
     
         try {
              String cmsqlb = "SELECT * FROM exame WHERE exame.tipo_exame LIKE ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+nome+'%');
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Exame ex = new Exame();
                 ex.setId_exame(rs.getInt("id_exame"));
                 ex.setNomeExame(rs.getString("tipo_exame"));
                 ex.setValorExame(rs.getFloat("valor_exame"));
                 ex.setLucro(rs.getFloat("lucro"));
                 lista.add(ex);
                 
                 
             }
        
             
         }catch (Exception e) {
         }
              return  lista;
     
     }  
    
       
       
       
       
     
     
     
     
     
      public List<Exame> BuscarExamesParaComobox(){
     
     List<Exame> lista = new ArrayList<Exame>();
     
         try {
              String cmsqlb = "select exame.tipo_exame from exame";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Exame ex = new Exame();
                 ex.setNomeExame(rs.getString("tipo_exame"));
                 lista.add(ex);
                 
                 
             }
        
             
         }catch (Exception e) {
         }
              return  lista;
     
     }  
     
     
     
     
     
     
     
     
     
     
     
     
    
}
