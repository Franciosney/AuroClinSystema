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
public class CaixaDAO {
    
    
     
      private Connection conecta;
    
    public CaixaDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
     public void cadastrarAbrarCaixa(AbrirCaixaModel objcai){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into abrircaixa(data_abrir,data_fechar,ValorCaixa)values(?,?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, objcai.getDataAbrir());
              stmt.setString(2, objcai.getDataFechar());
              stmt.setDouble(3, objcai.getValorCaixa());
              
      
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
    
     
     
     public boolean validarCaixa(String datadeAbrir){
     
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
     
     
     
     
       public List<AbrirCaixaModel> listarIdAbrirCaixa(){
     
     List<AbrirCaixaModel> lista = new ArrayList<AbrirCaixaModel>();
     
         try {
              String cmsqlb = "SELECT data_abrir,data_fechar,MAX(id_statos) as id_statos FROM abrircaixa";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 AbrirCaixaModel objAbrir = new AbrirCaixaModel();
                 objAbrir.setId_AbrirCAixa(rs.getInt("id_statos"));
                 objAbrir.setDataAbrir(rs.getString("data_abrir"));
                 objAbrir.setDataFechar(rs.getString("data_fechar"));
                
             
                 lista.add(objAbrir);
  
             }
        
             
         }catch (Exception e) {
             
              JOptionPane.showMessageDialog(null, "id"+e);
         }
              return  lista;
     
     }  
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
   
}
