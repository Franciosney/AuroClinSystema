/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.FilaModelo;
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
public class AmbienteMedicoDAO {
    
    
     
      private Connection conecta;
    
    public AmbienteMedicoDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
     public List<FilaModelo> Atendimentos( String data,String nomeMedico){
     
     List<FilaModelo> lista = new ArrayList<FilaModelo>();
     
         try {
              String cmsqlb = "select marcarexame.id_marcarExame,\n" +
"exame.tipo_exame,\n" +
"paciente.nome_paciente,\n" +
"marcarexame.situacaoFila,\n" +
"marcarexame.retorno,\n" +
"fila.nFicha\n" +
"from marcar\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"inner join exame on exame.id_exame = marcar.id_exame\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join fila on marcarexame.id_marcarExame = fila.id_marcarExame\n" +
"where marcar.dataFazer = ? and medico.nomeMedico = ?\n" +
"union ALL\n" +
"select marcarexame.id_marcarExame,\n" +
"consulta.tipo_consulta,\n" +
"paciente.nome_paciente,\n" +
"marcarexame.situacaoFila,\n" +
"marcarexame.retorno,\n" +
"fila.nFicha\n" +
"from marcar\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"inner join consulta on consulta.id_consulta = marcar.id_consulta\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join fila on marcarexame.id_marcarExame = fila.id_marcarExame\n" +
"where marcar.dataFazer = ? and medico.nomeMedico = ?" +
"";
             // 1º Organizar o Comando SQL
             
            
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, data);
             stmt.setString(2, nomeMedico);
              stmt.setString(3, data);
             stmt.setString(4, nomeMedico);
       
            
              
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 FilaModelo ex = new FilaModelo();
                 ex.setIdMarcar(rs.getInt("id_marcarExame"));
                   ex.setNomeConsulta(rs.getString("tipo_exame")); 
                 ex.setNomePaciente(rs.getString("nome_paciente"));
                 ex.setNumeroFicha(rs.getString("nFicha"));
                 ex.setSituacaoFila(rs.getString("situacaoFila"));
                 ex.setRetorno(rs.getString("retorno"));
       
                 System.out.println("Entrou");

                 lista.add(ex);
        
             }
        System.out.println("Não Entrou");
             
         }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
     
      
     
     public List<JoinBuscarExameEMarcar> historicoRecente(String nomePaciente){
     
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
"where paciente.nome_paciente LIKE ?) AS pass2\n";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+nomePaciente+'%');
              stmt.setString(2, '%'+nomePaciente+'%');
             
           
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 JoinBuscarExameEMarcar objm = new JoinBuscarExameEMarcar();
                 objm.setId_marcarBuscar(rs.getInt("id_marcarExame"));
                 objm.setDataRealizar(rs.getString("dataFazer"));
         
          

                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
     
     
     
        
     public List<JoinBuscarExameEMarcar> historicoAntigo(String nomePaciente){
     
     List<JoinBuscarExameEMarcar> lista = new ArrayList<JoinBuscarExameEMarcar>();
     
         try {
              String cmsqlb = "SELECT\n" +
"prontuario.id_prontuario,\n" +
"prontuario.data,\n" +
"prontuario.servico,\n" +
"medico.nomeMedico\n" +                     
"from prontuario\n" +
"inner join funcionario on funcionario.id_funcionario = prontuario.id_funcionario\n" +
"inner join paciente on paciente.id_paciente = prontuario.id_paciente\n" +
"inner join medico on medico.id_medico = prontuario.id_medico\n" +
"where paciente.nome_paciente LIKE ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+nomePaciente+'%');

             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 JoinBuscarExameEMarcar objm = new JoinBuscarExameEMarcar();
                 objm.setId_marcarBuscar(rs.getInt("id_prontuario"));
                 objm.setDataRealizar(rs.getString("data"));
          

                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
     
     
     
    
     public List<ProntuarioModelo> listaProntuarioRecente(int id_marcarExame){
     
     List<ProntuarioModelo> lista = new ArrayList<ProntuarioModelo>();
     
         System.out.println(" ---------------- "+id_marcarExame);
         try {
              String cmsqlb = "select \n" +
"prontuario.diagnostico,\n" +
"prontuario.sintomas, \n" +
"prontuario.descricao,\n" +
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

                 lista.add(objm);
                 
             } else{
                 
                         objm.setDiagnostico("");
                 objm.setSintomas("");
                 objm.setDescricao("");

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
              String cmsqlb = "select prontuario.diagnostico, prontuario.sintomas, prontuario.descricao,medico.nomeMedico from prontuario\n" +
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

                 lista.add(objm);
                 
             } else{
                 
                         objm.setDiagnostico("");
                 objm.setSintomas("");
                 objm.setDescricao("");

                 lista.add(objm);
             
             
             }
 
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
     
     
    
    
}
