/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.Enfermeiro;
import br.auroClin.model.Funcionario;
import br.auroClin.model.Medico;
import br.auroClin.model.Paciente;
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
public class FuncionariosDAO {
    
    
     
     
      private Connection conecta;
    
    public FuncionariosDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
       
     public List<Enfermeiro> listarFuncionarios(String nome,String funcao, String cpf){
     
     List<Enfermeiro> lista = new ArrayList<Enfermeiro>();
     
         try {
              String cmsqlb = "SELECT * FROM funcionario WHERE nomeFuncionario LIKE ? and funcao like ? and cpf like ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, '%'+nome+'%');
             stmt.setString(2, '%'+funcao+'%');
             stmt.setString(3, '%'+cpf+'%');
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Enfermeiro obje = new Enfermeiro();
                 obje.setId_enfermeiro(rs.getInt("id_funcionario"));
                  obje.setNomeEnfermeiro(rs.getString("nomeFuncionario"));
                  obje.setCpf(rs.getString("cpf"));
                  obje.setFuncao(rs.getString("funcao"));
                
                  
                  
                  
             
                 lista.add(obje);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
               JOptionPane.showMessageDialog(null,e);
         }
              return  lista;
     
     }  
    
    
    
     
     
     
        public List<Funcionario> buscarFuncionario(int id_funcionario){
     
     List<Funcionario> lista = new ArrayList<Funcionario>();
     
         try {
              String cmsqlb = "SELECT * from funcionario WHERE funcionario.id_funcionario = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
          
              
             stmt.setInt(1, id_funcionario);
             
             
             
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Funcionario objf = new Funcionario();
                 objf.setNomeFuncionario(rs.getString("nomeFuncionario"));
                 objf.setCpfFuncionario(rs.getString("cpf"));
                 objf.setSenhaFuncionario(rs.getString("senha"));
                 objf.setFuncaoFuncionario(rs.getString("funcao"));
                 objf.setSexoFuncionario(rs.getString("sexo"));
                 objf.setBairro(rs.getString("bairro"));
                 objf.setCelular(rs.getString("telefone"));
                 objf.setCidadeEstado(rs.getString("estadoCidade"));
                 objf.setDataCadastro(rs.getString("dataCadastro"));
                 objf.setDataNascimento(rs.getString("dataNascimento"));
                 objf.setId_funcionario(rs.getInt("id_funcionario"));
                 objf.setRua(rs.getString("rua"));
                 objf.setCelular(rs.getString("telefone"));

                  
     

                 lista.add(objf);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta"+e);
         }
              return  lista;
     
     }  
    
      
     
        
         public void editarFuncionario(Funcionario objf){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "update funcionario set\n" +
"funcao = ?,\n" +
"sexo = ?,\n" +
"bairro = ?,\n" +
"telefone = ?,\n" +
"senha = ?,\n" +
"estadoCidade = ?,\n" +
"rua = ?,\n" +
"dataNascimento = ?,\n" +
"dataCadastro = ?,\n" +
"nomeFuncionario = ?,\n" +
"cpf = ?\n" +
"where id_funcionario = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, objf.getFuncaoFuncionario());
             stmt.setString(2, objf.getSexoFuncionario());
             stmt.setString(3, objf.getBairro());
             stmt.setString(4, objf.getTelefone());
             stmt.setString(5, objf.getSenhaFuncionario());
             stmt.setString(6, objf.getCidadeEstado());
             stmt.setString(7, objf.getRua());
             stmt.setString(8, objf.getDataNascimento());
             stmt.setString(9, objf.getDataCadastro());
             stmt.setString(10, objf.getNomeFuncionario());
             stmt.setString(11, objf.getCpfFuncionario());
             stmt.setInt(12, objf.getId_funcionario());
             
             
         
         
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
     
     
         
         
           
       
     public List<Medico> listarMedicos(String nome, String cpf){
     
     List<Medico> lista = new ArrayList<Medico>();
     
         try {
              String cmsqlb = "SELECT * FROM medico WHERE nomeMedico LIKE ? and cpf like ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, '%'+nome+'%');
             stmt.setString(2, '%'+cpf+'%');
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Medico objm = new Medico();
                 objm.setId_medico(rs.getInt("id_medico"));
                  objm.setNomeMedico(rs.getString("nomeMedico"));
                  objm.setCpf(rs.getString("cpf"));
                  objm.setEspecializacao(rs.getString("especializacao"));
                
                  
                  
                  
             
                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
               JOptionPane.showMessageDialog(null,e);
         }
              return  lista;
     
     }  
    
    
    
         
            
       
     public List<Medico> listarMedicosPorId(int id_medico){
     
     List<Medico> lista = new ArrayList<Medico>();
     
         try {
              String cmsqlb = "SELECT * FROM medico WHERE id_medico = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setInt(1, id_medico);
            
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Medico objm = new Medico();
                 objm.setId_medico(rs.getInt("id_medico"));
                  objm.setNomeMedico(rs.getString("nomeMedico"));
                  objm.setCpf(rs.getString("cpf"));
                  objm.setCrm(rs.getString("crm"));
                  objm.setSenha(rs.getString("senha"));
                  objm.setCpf(rs.getString("cpf"));
                  objm.setEspecializacao(rs.getString("especializacao"));
                  objm.setSexo(rs.getString("sexo"));
                  objm.setDataNascimento(rs.getString("dataNascimento"));
                  objm.setDataCadastro(rs.getString("dataCadastro"));
                  objm.setCidadeEstado(rs.getString("cidadeEstado"));
                  objm.setBairro(rs.getString("bairro"));
                  objm.setRua(rs.getString("rua"));
                  objm.setEmail(rs.getString("email"));

                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
               JOptionPane.showMessageDialog(null,e);
         }
              return  lista;
     
     }  
         
         
     
     
         public void editarMedico(Medico objf){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "update medico set\n" +
"nomeMedico = ?,\n" +
"cpf = ?,\n" +
"crm = ?,\n" +
"senha = ?,\n" +
"especializacao = ?,\n" +
"sexo = ?,\n" +
"dataNascimento = ?,\n" +
"dataCadastro = ?,\n" +
"cidadeEstado = ?,\n" +
"bairro = ?,\n" +
"rua = ?,\n" +
"email = ?\n" +
"where id_medico = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, objf.getNomeMedico());
             stmt.setString(2, objf.getCpf());
             stmt.setString(3, objf.getCrm());
             stmt.setString(4, objf.getSenha());
             stmt.setString(5, objf.getEspecializacao());
             stmt.setString(6, objf.getSexo());
             stmt.setString(7, objf.getDataNascimento());
             stmt.setString(8, objf.getDataCadastro());
             stmt.setString(9, objf.getDataCadastro());
             stmt.setString(10, objf.getCidadeEstado());
             stmt.setString(11, objf.getBairro());
             stmt.setString(12, objf.getEmail());
             stmt.setInt(13, objf.getId_medico());
             
             
         
         
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
     
     
     
    
    
}
