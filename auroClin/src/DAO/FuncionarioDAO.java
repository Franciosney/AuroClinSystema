/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
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
public class FuncionarioDAO {
    
    
        private Connection conecta;
    
    public FuncionarioDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
     //------------------------------------------------------  cadastrar paciente 
    public void cadastrarFuncionario(Funcionario objf){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into funcionario(nomeFuncionario,cpf,funcao,sexo,dataNascimento,dataCadastro,estadoCidade,bairro,rua,telefone,senha)values(?,?,?,?,?,?,?,?,?,?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, objf.getNomeFuncionario());
             stmt.setString(2, objf.getCpfFuncionario());
             stmt.setString(3, objf.getFuncaoFuncionario());
             stmt.setString(4, objf.getSexoFuncionario());
             stmt.setString(5, objf.getDataNascimento());
             stmt.setString(6, objf.getDataCadastro());
             stmt.setString(7, objf.getCidadeEstado());
             stmt.setString(8, objf.getBairro());
             stmt.setString(9, objf.getRua());
             stmt.setString(10, objf.getTelefone());
             stmt.setString(11, objf.getSenhaFuncionario());

          
           
             
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
    
    
       
     public List<Funcionario> listarFuncionarioPorNome(String nome){
     
     List<Funcionario> lista = new ArrayList<Funcionario>();
     
         try {
              String cmsqlb = "SELECT * FROM funcionario WHERE nomeFuncionario LIKE ? ";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, '%'+nome+'%');
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Funcionario objf = new Funcionario();
                 objf.setId_funcionario(rs.getInt("id_funcionario"));
                  objf.setNomeFuncionario(rs.getString("nomeFuncionario"));
                  objf.setCpfFuncionario(rs.getString("cpf"));
                  objf.setFuncaoFuncionario(rs.getString("funcao"));
                
                  
                  
                  
             
                 lista.add(objf);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
    
    
    
     
      public List<Funcionario> listarFuncionarios(){
     
     List<Funcionario> lista = new ArrayList<Funcionario>();
     
         try {
              String cmsqlb = "SELECT * FROM funcionario";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Funcionario objf = new Funcionario();
                 objf.setId_funcionario(rs.getInt("id_funcionario"));
                  objf.setNomeFuncionario(rs.getString("nomeFuncionario"));
                  objf.setCpfFuncionario(rs.getString("cpf"));
                  objf.setFuncaoFuncionario(rs.getString("funcao"));
                
                  
                  
                  
             
                 lista.add(objf);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
    
      
      
     public List<Funcionario> listarFuncionarioPorID(int id_funcionario){
     
     List<Funcionario> lista = new ArrayList<Funcionario>();
     
         try {
              String cmsqlb = "SELECT * FROM funcionario WHERE id_funcionario = ? ";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setInt(1, id_funcionario);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Funcionario objf = new Funcionario();
              
                  objf.setNomeFuncionario(rs.getString("nomeFuncionario"));
 
                 lista.add(objf);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
      
      
     
     
}
