/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.Exame;
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
public class PacienteDAO {
    
    
        private Connection conecta;
    
    public PacienteDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
  //------------------------------------------------------  cadastrar paciente 
    public void cadastrarPaciente(Paciente objp){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into paciente(nome_paciente,rg,cpf,sexo,dataCadastro,dataNascimento,estadoCidade,bairro,rua,numero,complemento,id_plano,telefone,plano,atividade)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
             // 1º Organizar o Comando SQL
             String atividade = "ATIVO";
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, objp.getNome_paciente());
             stmt.setString(2, objp.getRg());
             stmt.setString(3, objp.getCpf());
             stmt.setString(4, objp.getSexo());
             stmt.setString(5, objp.getDataNascimento());
             stmt.setString(6, objp.getDataCadastro());
             stmt.setString(7, objp.getEstadoCidade());
             stmt.setString(8, objp.getBairro());
             stmt.setString(9, objp.getRua());
             stmt.setString(10, objp.getNumero());
             stmt.setString(11, objp.getComplemento());
             stmt.setInt(12, objp.getId_plano());
             stmt.setString(13, objp.getTelefone());
             stmt.setString(14, objp.getPlano());
             stmt.setString(15, atividade);

          
           
             
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
    
    
    
    
      
    
 
      public List<Paciente> listarPacientePorNome(String nome){
     
     List<Paciente> lista = new ArrayList<Paciente>();
     
         try {
              String cmsqlb = "SELECT paciente.id_paciente,paciente.nome_paciente,paciente.cpf,paciente.dataNascimento,planos.nomePlano,planos.desconto FROM Paciente \n" +
"inner join planos on paciente.id_plano = planos.id_plano\n" +
"WHERE nome_paciente LIKE ? and paciente.atividade = ?";
             // 1º Organizar o Comando SQL
              String atividade = "ATIVO";
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, '%'+nome+'%');
              stmt.setString(2, atividade);
              
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Paciente objp = new Paciente();
                objp.setId_paciente(rs.getInt("id_paciente"));
                  objp.setNome_paciente(rs.getString("nome_paciente"));
                  objp.setCpf(rs.getString("cpf"));
                  objp.setDataNascimento(rs.getString("dataNascimento"));
                  objp.setPlano(rs.getString("nomePlano"));
                  objp.setDesconto(rs.getFloat("desconto"));
                  
                  
             
                 lista.add(objp);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
    
      
      
      
      public List<Paciente> listarPacienteCidade(String cidade,String bairro){
     
     List<Paciente> lista = new ArrayList<Paciente>();
     
         try {
              String cmsqlb = "SELECT paciente.id_paciente,paciente.nome_paciente,paciente.cpf,paciente.dataNascimento,planos.nomePlano,planos.desconto FROM Paciente \n" +
"inner join planos on paciente.id_plano = planos.id_plano\n" +
"WHERE paciente.estadoCidade LIKE ? and paciente.bairro LIKE ? and paciente.atividade = ?";
             // 1º Organizar o Comando SQL
              String atividade = "ATIVO";
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, '%'+cidade+'%');
             stmt.setString(2, '%'+bairro+'%');
              stmt.setString(3, atividade);
              
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Paciente objp = new Paciente();
                objp.setId_paciente(rs.getInt("id_paciente"));
                  objp.setNome_paciente(rs.getString("nome_paciente"));
                  objp.setCpf(rs.getString("cpf"));
                  objp.setDataNascimento(rs.getString("dataNascimento"));
                  objp.setPlano(rs.getString("nomePlano"));
                  objp.setDesconto(rs.getFloat("desconto"));
                  
                  
             
                 lista.add(objp);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
      
      
      
      
      
       public List<Paciente> listarTodosPacientes(){
     
     List<Paciente> lista = new ArrayList<Paciente>();
     
         try {
              String cmsqlb = "SELECT paciente.id_paciente,paciente.nome_paciente,paciente.cpf,paciente.dataNascimento,planos.nomePlano,planos.desconto FROM Paciente \n" +
"inner join planos on paciente.id_plano = planos.id_plano\n" +
"where paciente.atividade = ? ORDER BY id_paciente DESC LIMIT 10 ";
             // 1º Organizar o Comando SQL
             
               String atividade = "ATIVO";
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, atividade);
             ResultSet rs = stmt.executeQuery();
              stmt.setString(1, atividade);
              
             while (rs.next()) {
                 Paciente objp = new Paciente();
                 objp.setId_paciente(rs.getInt("id_paciente"));
                  objp.setNome_paciente(rs.getString("nome_paciente"));
                  objp.setCpf(rs.getString("cpf"));
                  objp.setDataNascimento(rs.getString("dataNascimento"));
                  objp.setPlano(rs.getString("nomePlano"));
                  objp.setDesconto(rs.getFloat("desconto"));
                  
                  
             
                 lista.add(objp);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, " --------- Erro ao Buscar Consulta"+e);
         }
              return  lista;
     
     }  
    
       
     
       
       
       public List<Paciente> listarTodosPacientesSemExecao(){
     
     List<Paciente> lista = new ArrayList<Paciente>();
     
         try {
              String cmsqlb = "SELECT paciente.id_paciente,paciente.nome_paciente,paciente.cpf,paciente.dataNascimento,planos.nomePlano,planos.desconto FROM Paciente \n" +
"inner join planos on paciente.id_plano = planos.id_plano\n" +
"where paciente.atividade = ? ORDER BY paciente.nome_paciente";
             // 1º Organizar o Comando SQL
             
               String atividade = "ATIVO";
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, atividade);
             ResultSet rs = stmt.executeQuery();
              stmt.setString(1, atividade);
              
             while (rs.next()) {
                 Paciente objp = new Paciente();
                 objp.setId_paciente(rs.getInt("id_paciente"));
                  objp.setNome_paciente(rs.getString("nome_paciente"));
                  objp.setCpf(rs.getString("cpf"));
                  objp.setDataNascimento(rs.getString("dataNascimento"));
                  objp.setPlano(rs.getString("nomePlano"));
                  objp.setDesconto(rs.getFloat("desconto"));
                  
                  
             
                 lista.add(objp);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, " --------- Erro ao Buscar Consulta"+e);
         }
              return  lista;
     
     }  
    
       
       
       
    
    
       
        public List<Paciente> buscarPacienteParaEditar(String nome, String cpf, String cidade, String bairro,String dataNascimento,String plano){
     
     List<Paciente> lista = new ArrayList<Paciente>();
     
         try {
              String cmsqlb = "SELECT\n" +
"paciente.id_paciente, paciente.nome_paciente,\n" +
"paciente.sexo,\n" +
"paciente.dataNascimento,\n" +
"paciente.dataCadastro,\n" +
"paciente.bairro,\n" +
"paciente.rua, \n" +
"paciente.complemento, \n" +
"paciente.cpf, \n" +
"paciente.estadoCidade, \n" +
"paciente.rg, \n" +
"paciente.id_plano,\n" +
"paciente.telefone,\n" +
"planos.nomePlano\n" +
"from paciente\n" +
"inner join planos on planos.id_plano = paciente.id_plano\n" +
"WHERE paciente.nome_paciente like ? AND\n" +
"cpf like ? and dataNascimento like ? and estadoCidade like ? AND\n" +
"bairro like ? and nomePlano like ? and paciente.atividade = ? ";
             // 1º Organizar o Comando SQL
             
             String atividade = "ATIVO";
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             stmt.setString(1, '%'+nome+'%');
             stmt.setString(2, '%'+cpf+'%');
             stmt.setString(3, '%'+dataNascimento+'%');
             stmt.setString(4, '%'+cidade+'%');
             stmt.setString(5, '%'+bairro+'%');
             stmt.setString(6, '%'+plano+'%');
             
             
              stmt.setString(7, atividade);
             
             
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Paciente objp = new Paciente();
                 objp.setId_paciente(rs.getInt("id_paciente"));
                  objp.setNome_paciente(rs.getString("nome_paciente"));
                  objp.setCpf(rs.getString("cpf"));
                  objp.setDataNascimento(rs.getString("dataNascimento"));
                  objp.setEstadoCidade(rs.getString("estadoCidade"));
                   objp.setId_plano(rs.getInt("id_plano"));
                   objp.setBairro(rs.getString("bairro"));
                   objp.setPlano(rs.getString("nomePlano"));
                  
              
               
              
                  
                  
             
                 lista.add(objp);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
         }
              return  lista;
     
     }  
    
      
       
       
       
    
    
       
        public List<Paciente> buscarPacienteParaEditarParte2(int id_paciente){
     
     List<Paciente> lista = new ArrayList<Paciente>();
     
         try {
              String cmsqlb = "SELECT\n" +
"paciente.id_paciente, paciente.nome_paciente,\n" +
"paciente.sexo,\n" +
"paciente.dataNascimento,\n" +
"paciente.dataCadastro,\n" +
"paciente.bairro,\n" +
"paciente.rua, \n" +
"paciente.complemento, \n" +
"paciente.cpf, \n" +
"paciente.estadoCidade, \n" +
"paciente.rg, \n" +
"paciente.id_plano,\n" +
"paciente.telefone,\n" +
"paciente.numero,\n" +
"paciente.email,\n" +
"planos.nomePlano,\n" +
"paciente.celular\n" +
"from paciente\n" +
"inner join planos on planos.id_plano = paciente.id_plano\n" +
"WHERE paciente.id_paciente = ? and paciente.atividade = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              String atividade = "ATIVO";
              
             stmt.setInt(1, id_paciente);
             stmt.setString(2, atividade);
             
             
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Paciente objp = new Paciente();
                 objp.setId_paciente(rs.getInt("id_paciente"));
                  objp.setNome_paciente(rs.getString("nome_paciente"));
                  objp.setCpf(rs.getString("cpf"));
                  objp.setDataNascimento(rs.getString("dataNascimento"));
                  objp.setEstadoCidade(rs.getString("estadoCidade"));
                   objp.setId_plano(rs.getInt("id_plano"));
                   objp.setBairro(rs.getString("bairro"));
                   objp.setPlano(rs.getString("nomePlano"));
                   objp.setRg(rs.getString("rg"));
                   objp.setSexo(rs.getString("sexo"));
                   objp.setDataCadastro(rs.getString("dataCadastro"));
                   objp.setRua(rs.getString("rua"));
                   objp.setNumero(rs.getString("numero"));
                   objp.setComplemento(rs.getString("complemento"));
                   objp.setEmail(rs.getString("email"));
                   objp.setCelular(rs.getString("celular"));
                   objp.setTelefone(rs.getString("telefone"));
                   
                  
     

                 lista.add(objp);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta"+e);
         }
              return  lista;
     
     }  
    
      
       
       
       
       public void editarPaciente(Paciente objp){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "update paciente set \n" +
"nome_paciente = ?,\n" +
"rg = ?,\n" +
"cpf = ?,\n" +
"sexo = ?,\n" +
"dataNascimento = ?,\n" +
"dataCadastro = ?,\n" +
"id_plano = ?,\n" +
"estadoCidade = ?,\n" +
"bairro = ?,\n" +
"rua = ?,\n" +
"numero = ?,\n" +
"complemento = ?,\n" +
"email = ?,\n" +
"celular = ?,\n" +
"telefone = ?, \n" +
"plano = ? \n" +
"where id_paciente = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, objp.getNome_paciente());
             stmt.setString(2, objp.getRg());
             stmt.setString(3, objp.getCpf());
             stmt.setString(4, objp.getSexo());
             stmt.setString(5, objp.getDataNascimento());
             stmt.setString(6, objp.getDataCadastro());
             stmt.setInt(7, objp.getId_plano());
             stmt.setString(8, objp.getEstadoCidade());
             stmt.setString(9, objp.getBairro());
              stmt.setString(10, objp.getRua());
             stmt.setString(11, objp.getNumero());
             stmt.setString(12, objp.getComplemento());
             stmt.setString(13, objp.getEmail());
             stmt.setString(14, objp.getCelular());
             stmt.setString(15, objp.getTelefone());
             stmt.setString(16, objp.getPlano());
             stmt.setInt(17, objp.getId_paciente());
         
         
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
    
    
    
      
       public void excluirPaciente(Paciente objp){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "update paciente set atividade = ? where id_paciente = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, objp.getDesativar());
             stmt.setInt(2, objp.getId_paciente());
         
         
         
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
