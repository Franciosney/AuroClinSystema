/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.Cidades;
import br.auroClin.model.ControleLog;
import br.auroClin.model.Especializacoes;
import br.auroClin.model.Funcionario;
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
public class FuncaoSistemaDAO {
    
    
    
    
        private Connection conecta;
    
    public FuncaoSistemaDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
     //------------------------------------------------------  cadastrar paciente 
    public void cadastrarCidade(String cidade){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into cidade(cidade)values(?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, cidade);

             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro no banco de dados, contate o suporte técnico do sistema");
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
    
    }
    
    //-------------------------------------- fim cadastrar paciente
    
    
    
    
    
     //------------------------------------------------------  cadastrar paciente 
    public void cadastrareEspecializacao(String especializacao){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into especializacao(especializacao)values(?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, especializacao);

             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro no banco de dados, contate o suporte técnico do sistema");
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
    
    }
    
    //-------------------------------------- fim cadastrar paciente
    
    
    
    
    
    
     
     public List<Cidades> listarCidades(){
     
     List<Cidades> lista = new ArrayList<Cidades>();
     
         try {
              String cmsqlb = "SELECT * FROM cidade ";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Cidades objf = new Cidades();
                 objf.setId_cidade(rs.getString("id_cidade"));
                  objf.setNomeCidade(rs.getString("cidade"));
            
                
                  
                  
                  
             
                 lista.add(objf);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
     
     
     
     
     
      
     public List<Especializacoes> listarEspecializacao(){
     
     List<Especializacoes> lista = new ArrayList<Especializacoes>();
     
         try {
              String cmsqlb = "SELECT * FROM especializacao ";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Especializacoes objf = new Especializacoes();
                 objf.setId_especializacao(rs.getString("id_especializacao"));
                  objf.setEspecializacao(rs.getString("especializacao"));
            
                
                  
                  
                  
             
                 lista.add(objf);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
     
     
    
     public boolean validarCidade(String nomeCidade){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "select * from cidade where cidade =?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, nomeCidade);
          
             
             ResultSet rs = stmt.executeQuery();
             
             ControleLog c = new ControleLog();
        
             
             if (rs.first()) {
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }

  
     
     
      public boolean validarEspecializacao(String especializacao){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "select * from especializacao where especializacao =?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, especializacao);
          
             
             ResultSet rs = stmt.executeQuery();
             
    
        
             
             if (rs.first()) {
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }
     
     
    
    
}
