/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.Marcar;
import br.auroClin.model.testeIr;
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
public class TesteIreport {
    
      private Connection conecta;
    
    public TesteIreport(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    public ResultSet rs;
    
     
     public List<testeIr> listaMarcar(){
     
     List<testeIr> lista = new ArrayList<testeIr>();
     
         try {
              String cmsqlb = "select * from marcar";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             rs = stmt.executeQuery();
             
           
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
    
     
    
    
    
}
