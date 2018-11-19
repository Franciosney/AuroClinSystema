/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.finalizarMarcar;
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
public class finalizarMarcarDAO {
    
     private Connection conecta;
    
    public finalizarMarcarDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
    
    
    
     public void efetivarCadastroExame(finalizarMarcar objf){
    //-----------------------------------------------------
        try {
          
            System.out.println(objf.getRetorno());
                  
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into marcarExame(id_marcar,id_paciente,id_caixa,situacao,formaPagamento,situacaoFila,retorno)values(?,?,?,?,?,?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setInt(1, objf.getId_dataMarcar());
             stmt.setInt(2, objf.getId_paciente());
               stmt.setInt(3, objf.getId_caixa());
               stmt.setString(4, objf.getSituacao());
               stmt.setString(5, objf.getFormaPagamento());
               stmt.setString(6, objf.getSituacaoFila());
               stmt.setString(7, objf.getRetorno());
                 
          
         
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
    
   
     
     public List<finalizarMarcar> listarId(){
     
     List<finalizarMarcar> lista = new ArrayList<finalizarMarcar>();
     
         try {
              String cmsqlb = "SELECT MAX(id_marcarExame) as id_marcarExame FROM marcarExame";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
        
          
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                  finalizarMarcar obfm = new finalizarMarcar();
                 obfm.setId_finalizarMarcar(rs.getInt("id_marcarExame"));
                 
                 lista.add(obfm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
    
       
       
             
    
}
