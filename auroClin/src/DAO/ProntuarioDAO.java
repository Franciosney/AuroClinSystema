/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.ControleLog;
import br.auroClin.model.JoinBuscarExameEMarcar;
import br.auroClin.model.ProntuarioModelo;
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
public class ProntuarioDAO {
    
    
      private Connection conecta;
    
    public ProntuarioDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
     //------------------------------------------------------  cadastrar paciente 
    public void cadastrarProntuario(ProntuarioModelo obje){
    //-----------------------------------------------------
        try {
          
            
            System.out.println(obje.getId_funcionario());
            
          String cmsql = "insert into prontuario(id_marcarExame,id_paciente,id_medico,id_funcionario,servico,data,diagnostico,sintomas,descricao,responsavel,prescricao)values(?,?,?,?,?,?,?,?,?,?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setInt(1, obje.getId_marcarExame());
             stmt.setInt(2, obje.getId_paciente());
             stmt.setInt(3, obje.getId_medico());
             stmt.setInt(4, obje.getId_funcionario());
             stmt.setString(5, obje.getServico());
             stmt.setString(6, obje.getData());
             stmt.setString(7, obje.getDiagnostico());
             stmt.setString(8, obje.getSintomas());
             stmt.setString(9, obje.getDescricao());
             stmt.setString(10, obje.getResponsavel());
             stmt.setString(11, obje.getPrescricao());

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
    
    //-------------------------------------- fim cadastrar paciente
    
    
    
    
    
    
    
    
     public List<JoinBuscarExameEMarcar> listaDatasExamesRetorno(String nomePaciente){
     
     List<JoinBuscarExameEMarcar> lista = new ArrayList<JoinBuscarExameEMarcar>();
     
         try {
              String cmsqlb = "SELECT * FROM \n" +
"(\n" +
"SELECT\n" +
"marcarExame.id_marcarExame,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"medico.nomeMedico\n" +
"FROM marcar\n" +
"inner JOIN consulta on  marcar.id_consulta = consulta.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar \n" +
"inner join paciente on paciente.id_paciente= marcarexame.id_paciente \n" +
"where paciente.nome_paciente LIKE ?) AS pass1\n" +
"UNION ALL \n" +
"SELECT * FROM \n" +
"(SELECT\n" +
"marcarExame.id_marcarExame,\n" +
"marcar.dataFazer,\n" +
"exame.tipo_exame,\n" +
"medico.nomeMedico\n" +
"FROM marcar\n" +
"inner JOIN exame on  marcar.id_exame = exame.id_exame\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar \n" +
"inner join paciente on paciente.id_paciente= marcarexame.id_paciente \n" +
"where paciente.nome_paciente LIKE ?) AS pass2\n" +
"UNION ALL \n" +
"SELECT * FROM \n" +
"(\n" +
"SELECT\n" +
"prontuario.id_prontuario,\n" +
"prontuario.data,\n" +
"prontuario.servico,\n" +
"medico.nomeMedico\n" +                     
"from prontuario\n" +
"inner join funcionario on funcionario.id_funcionario = prontuario.id_funcionario\n" +
"inner join paciente on paciente.id_paciente = prontuario.id_paciente\n" +
"inner join medico on medico.id_medico = prontuario.id_medico\n" +
"where paciente.nome_paciente LIKE ?) AS pass3\n" +
"";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+nomePaciente+'%');
              stmt.setString(2, '%'+nomePaciente+'%');
               stmt.setString(3, '%'+nomePaciente+'%');
           
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 JoinBuscarExameEMarcar objm = new JoinBuscarExameEMarcar();
                 objm.setId_marcarBuscar(rs.getInt("id_marcarExame"));
                 objm.setDataRealizar(rs.getString("dataFazer"));
                 objm.setExameRequerido(rs.getString("tipo_consulta"));
                 objm.setNomeMedico(rs.getString("nomeMedico"));
                 
          
                  
                   
             
                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    

     
       
     public List<ProntuarioModelo> listaMedicosDosServicos(int id_marcarExame,String nomePaciente){
     
     List<ProntuarioModelo> lista = new ArrayList<ProntuarioModelo>();
     
         try {
              String cmsqlb = "select medico.nomeMedico from marcar\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join marcarexame on marcarexame.id_marcar = marcar.id_marcar\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"where marcarexame.id_marcarExame = ? and paciente.nome_paciente = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setInt(1, id_marcarExame);
              stmt.setString(2, nomePaciente);
           
           
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 ProntuarioModelo objm = new ProntuarioModelo();
                 objm.setId_marcarExame(rs.getInt("id_marcarExame"));
                 objm.setData(rs.getString("dataFazer"));
                 objm.setServico(rs.getString("tipo_consulta"));
                 objm.setNomeMedico(rs.getString("nomeMedico"));
                 
          
                  
                   
             
                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
     
     
    
     public List<ProntuarioModelo> listaProntuario(int id_marcarExame){
     
     List<ProntuarioModelo> lista = new ArrayList<ProntuarioModelo>();
     
         System.out.println(id_marcarExame);
         try {
              String cmsqlb = "select \n" +
"prontuario.diagnostico,\n" +
"prontuario.sintomas, \n" +
"prontuario.descricao,\n" +
"prontuario.prescricao,\n" +
"prontuario.servico,\n" +
"prontuario.id_marcarExame,\n" +
"medico.nomeMedico \n" +
"from prontuario\n" +
"inner join marcarexame on marcarexame.id_marcarExame = prontuario.id_marcarExame \n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where marcarexame.id_marcarExame = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setInt(1, id_marcarExame);
        
           
             
             ResultSet rs = stmt.executeQuery();
              ProntuarioModelo objm = new ProntuarioModelo();
             if (rs.next()) {
                 
                 
                 objm.setDiagnostico(rs.getString("diagnostico"));
                 objm.setSintomas(rs.getString("sintomas"));
                 objm.setDescricao(rs.getString("descricao"));
                 objm.setNomeMedico(rs.getString("nomeMedico"));
                 objm.setServico(rs.getString("servico"));
                 objm.setId_marcarExame(rs.getInt("id_marcarExame"));
                 objm.setPrescricao(rs.getString("prescricao"));

                 lista.add(objm);
                 
             } else{
                 
                         objm.setDiagnostico("");
                 objm.setSintomas("");
                 objm.setDescricao("");
                 objm.setNomeMedico("");
                 

                 lista.add(objm);
             
             
             }
 
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
     
     
     public List<ProntuarioModelo> listaProntuarioAntigos(int id_prontuario){
     
     List<ProntuarioModelo> lista = new ArrayList<ProntuarioModelo>();
     
         try {
              String cmsqlb = "select prontuario.diagnostico, prontuario.sintomas, prontuario.descricao,medico.nomeMedico,prontuario.prescricao from prontuario\n" +
"inner join medico on medico.id_medico = prontuario.id_medico\n" +
"where prontuario.id_prontuario = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setInt(1, id_prontuario);
        
           
             
             ResultSet rs = stmt.executeQuery();
              ProntuarioModelo objm = new ProntuarioModelo();
             if (rs.next()) {
                 
                 
                 objm.setDiagnostico(rs.getString("diagnostico"));
                 objm.setSintomas(rs.getString("sintomas"));
                 objm.setDescricao(rs.getString("descricao"));
                 objm.setNomeMedico(rs.getString("nomeMedico"));
                 objm.setPrescricao(rs.getString("prescricao"));

                 lista.add(objm);
                 
             } else{
                 
                         objm.setDiagnostico("");
                 objm.setSintomas("");
                 objm.setDescricao("");
                 objm.setPrescricao("");
                 objm.setNomeMedico("");

                 lista.add(objm);
             
             
             }
 
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
     
     
     public boolean validarAntigo(int id_prontuario){
     
         try {
             String descricao = "ADM";
               // 1º passo Criar Comando SQL
            String cmsql = "select prontuario.id_prontuario from prontuario\n" +
"WHERE prontuario.id_prontuario = ? and prontuario.responsavel = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setInt(1, id_prontuario);
             stmt.setString(2, descricao);
           
             
             ResultSet rs = stmt.executeQuery();

             
             if (rs.first()) {

               
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }

  
     
     
     
     
     
      
     public boolean validarProntualAtual(int id_marcarExame){
     
         try {
           
             
               // 1º passo Criar Comando SQL
            String cmsql = "select prontuario.id_prontuario from prontuario\n" +
"WHERE prontuario.id_marcarExame = ? ";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setInt(1, id_marcarExame);
              
           
             
             ResultSet rs = stmt.executeQuery();

             
             if (rs.first()) {

               
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }

  
     
    
    
}
