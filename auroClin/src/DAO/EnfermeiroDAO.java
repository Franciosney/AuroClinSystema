/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.Enfermeiro;
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
public class EnfermeiroDAO {
    
    
        private Connection conecta;
    
    public EnfermeiroDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
     //------------------------------------------------------  cadastrar paciente 
    public void cadastrarEnfermeiro(Enfermeiro obje){
    //-----------------------------------------------------
        try {
          
            
          String cmsql = "insert into funcionario(nomeFuncionario,cpf,funcao,sexo,dataNascimento,dataCadastro,estadoCidade,bairro,rua,telefone,senha)values(?,?,?,?,?,?,?,?,?,?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, obje.getNomeEnfermeiro());
             stmt.setString(2, obje.getCpf());
             stmt.setString(3, obje.getFuncao());
             stmt.setString(4, obje.getSexo());
             stmt.setString(5, obje.getDataNascimento());
             stmt.setString(6, obje.getDataCadastro());
             stmt.setString(7, obje.getCidadeEstado());
             stmt.setString(8, obje.getBairro());
             stmt.setString(9, obje.getRua());
             stmt.setString(10, obje.getTelefone());
             stmt.setString(11, obje.getSenha());
           
             
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
    
    
        
     public List<Enfermeiro> listarFuncionarioPorNome(String nome,String busca01,String busca02){
     
     List<Enfermeiro> lista = new ArrayList<Enfermeiro>();
     
         try {
              String cmsqlb = "SELECT * FROM funcionario WHERE nomeFuncionario LIKE ? and funcao = ? OR funcao = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, '%'+nome+'%');
             stmt.setString(2, busca01);
             stmt.setString(3, busca02);
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
    
     
     
     
     
      public List<Enfermeiro> listarFuncionariosEnfermeiros(String busca01,String busca02){
     
     List<Enfermeiro> lista = new ArrayList<Enfermeiro>();
     
         try {
              String cmsqlb = "SELECT * FROM funcionario WHERE funcao = ? OR funcao = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, busca01);
             stmt.setString(2, busca02);
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
    
     
     
    
    
}

    
    


