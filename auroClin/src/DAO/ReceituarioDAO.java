/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.AbrirCaixaModel;
import br.auroClin.model.Receituario;
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
public class ReceituarioDAO {
    
    
    
      private Connection conecta;
    
    public ReceituarioDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
       public List<Receituario> listarIdReceituario(int id_marcarExame){
     
     List<Receituario> lista = new ArrayList<Receituario>();
     
         try {
              String cmsqlb = "select prontuario.id_prontuario from prontuario\n" +
"WHERE prontuario.id_marcarExame = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setInt(1, id_marcarExame);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Receituario objr = new Receituario();
                 objr.setId_prontuario(rs.getInt("id_prontuario"));
                
                
             
                 lista.add(objr);
  
             }
        
             
         }catch (Exception e) {
             
              JOptionPane.showMessageDialog(null, "id"+e);
         }
              return  lista;
     
     }  
       
       
    
    
       
    
       public List<Receituario> listarEnderecoPaciente(String nomePaciente){
     
     List<Receituario> lista = new ArrayList<Receituario>();
     
         try {
              String cmsqlb = "SELECT paciente.estadoCidade,paciente.bairro,paciente.rua,"
                      + "paciente.numero,paciente.complemento from paciente where paciente.nome_paciente = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, nomePaciente);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Receituario objr = new Receituario();
                 objr.setRua(rs.getString("rua"));
                 objr.setNumero(rs.getString("numero"));
                 objr.setBairro(rs.getString("bairro"));
                 objr.setEstado(rs.getString("estadoCidade"));
                
                
             
                 lista.add(objr);
  
             }
        
             
         }catch (Exception e) {
             
              JOptionPane.showMessageDialog(null, "id"+e);
         }
              return  lista;
     
     }  
       
       
    
    
    
       
       
    
}
