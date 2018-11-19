/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.Medico;
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
public class MedicoDAO {
    
    
        private Connection conecta;
    
    public MedicoDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
     //------------------------------------------------------  cadastrar paciente 
    public void cadastrarMedico(Medico objm){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into medico(nomeMedico,cpf,crm,senha,especializacao,sexo,dataNascimento,dataCadastro,cidadeEstado,bairro,rua,email,celular)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, objm.getNomeMedico());
             stmt.setString(2, objm.getCpf());
             stmt.setString(3, objm.getCrm());
             stmt.setString(4, objm.getSenha());
             stmt.setString(5, objm.getEspecializacao());
             stmt.setString(6, objm.getSexo());
             stmt.setString(7, objm.getDataNascimento());
             stmt.setString(8, objm.getDataCadastro());
             stmt.setString(9, objm.getCidadeEstado());
             stmt.setString(10, objm.getBairro());
             stmt.setString(11, objm.getRua());
             stmt.setString(12, objm.getEmail());
             stmt.setString(13, objm.getCelular());

          
           
             
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
    
    
    
    
     public List<Medico> listarMedicoPorNome(String nome){
     
     List<Medico> lista = new ArrayList<Medico>();
     
         try {
              String cmsqlb = "SELECT * FROM medico WHERE nomeMedico LIKE ? ";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, '%'+nome+'%');
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Medico objm = new Medico();
                 objm.setId_medico(rs.getInt("id_medico"));
                  objm.setNomeMedico(rs.getString("nomeMedico"));
                  objm.setCpf(rs.getString("cpf"));
                  objm.setCrm(rs.getString("crm"));
                  objm.setEspecializacao(rs.getString("ESPECIALIZACAO"));
                  
                  
                  
             
                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
    
       
    
     public List<Medico> listarMedicos(){
     
     List<Medico> lista = new ArrayList<Medico>();
     
         try {
              String cmsqlb = "SELECT * FROM medico";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Medico objm = new Medico();
                 objm.setId_medico(rs.getInt("id_medico"));
                  objm.setNomeMedico(rs.getString("nomeMedico"));
                  objm.setCpf(rs.getString("cpf"));
                  objm.setCrm(rs.getString("crm"));
                  objm.setEspecializacao(rs.getString("ESPECIALIZACAO"));
                  
                  
                  
             
                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
    
       
    
       
    
     public List<Medico> listarUltimosMEdicos(){
     
     List<Medico> lista = new ArrayList<Medico>();
     
         try {
              String cmsqlb = "SELECT * FROM medico ORDER BY id_medico DESC LIMIT 5";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Medico objm = new Medico();
                 objm.setId_medico(rs.getInt("id_medico"));
                  objm.setNomeMedico(rs.getString("nomeMedico"));
                  objm.setEspecializacao(rs.getString("ESPECIALIZACAO"));
                  
                  
                  
             
                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
    
       
     
     
     
     
}
