/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.AbrirCaixaModel;
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
public class AbrirCaixaDAO {
    
    
     
      private Connection conecta;
    
    public AbrirCaixaDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
     
     public List<AbrirCaixaModel> listarIdStatosCaixa(){
     
     List<AbrirCaixaModel> lista = new ArrayList<AbrirCaixaModel>();
     
         try {
              String cmsqlb = "SELECT MAX(id_statos) as id_statos FROM abrircaixa";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 AbrirCaixaModel obc = new AbrirCaixaModel();
                 obc.setId_AbrirCAixa(rs.getInt("id_statos"));
         
                 lista.add(obc);
  
             }
        
             
         }catch (Exception e) {
             
              JOptionPane.showMessageDialog(null, "id"+e);
         }
              return  lista;
     
     }  
     
     
    
     
     
     
     public boolean validarCaixaAberto(String datadeAbrir){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "SELECT data_abrir FROM abrircaixa WHERE data_abrir =?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, datadeAbrir);
         
             
             ResultSet rs = stmt.executeQuery();
             
             if (rs.first()) {
                 
                 //fez login
                 
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }
     
     
     
     
    
    
}
