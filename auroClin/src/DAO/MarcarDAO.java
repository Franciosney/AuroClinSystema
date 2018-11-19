/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.JoinBuscarExameEMarcar;
import br.auroClin.model.Marcar;
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
public class MarcarDAO {
    
       private Connection conecta;
    
    public MarcarDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
     public void cadastrarMarcar(Marcar objmar){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into marcar(dataAbrir,dataFazer,agendar,id_exame,id_consulta,horarios,id_medico)values(?,?,?,?,?,?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, objmar.getDataAbrir());
             stmt.setString(2, objmar.getDataFazer());
             stmt.setString(3, objmar.getAgendar());
             stmt.setInt(4, objmar.getId_exame());
             stmt.setInt(5, objmar.getId_consulta());
             stmt.setString(6, objmar.getHorario());
             stmt.setInt(7, objmar.getId_medico());
             System.out.println(objmar.getId_medico());
         
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro ao cadastrar Data Marcar Exame"+erro);
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
    
    }
    
    //-------------------------------------- fim cadastrar paciente
    
    
    
     
     
     
       
     public List<Marcar> listaDatasConsultas(){
     
     List<Marcar> lista = new ArrayList<Marcar>();
     
         try {
              String cmsqlb = "SELECT marcar.id_marcar,marcar.dataFazer,consulta.tipo_consulta, marcar.agendar,marcar.horarios,medico.nomeMedico,consulta.valor_consulta FROM marcar\n" +
"inner JOIN consulta on  marcar.id_consulta = consulta.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"ORDER BY consulta.tipo_consulta,id_marcar DESC LIMIT 100 ";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Marcar objm = new Marcar();

                  objm.setId_marcar(rs.getInt("id_marcar"));
                 objm.setDataFazer(rs.getString("dataFazer"));
                 objm.setNomeParaJoin(rs.getString("tipo_consulta"));
                  objm.setAgendar(rs.getString("agendar"));
                  objm.setNomeMedico(rs.getString("nomeMedico"));
                  objm.setValorExame(rs.getFloat("valor_consulta"));
                   
                  
                  
                  
             
                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
    
     
     
     public boolean ValidarCadastroDeExamesRepetido(int idMarcar, int idPaciente){
         
         System.out.println(idMarcar);
         System.out.println(idPaciente);
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "select marcar.dataFazer from marcar\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join paciente on paciente.id_paciente = marcarexame.id_paciente\n" +
"where paciente.id_paciente = ? and marcarexame.id_marcar = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setInt(1, idPaciente);
             stmt.setInt(2, idMarcar);
             
            
             
             ResultSet rs = stmt.executeQuery();
             
             
        
             
             if (rs.first()) {

                 //fez login
               
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }

    
    
     
     
     
     
     
     
     
     public List<Marcar> listaDatasConsultasPorData(String nomeExame,String nomeMedico,String data, String forma){
     
     List<Marcar> lista = new ArrayList<Marcar>();
     
         try {
              String cmsqlb = "SELECT marcar.id_marcar,marcar.dataFazer,consulta.tipo_consulta, marcar.agendar,marcar.horarios,medico.nomeMedico FROM marcar\n" +
"inner JOIN consulta on  marcar.id_consulta = consulta.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"where consulta.tipo_consulta like ? and medico.nomeMedico like ? and marcar.dataFazer like ? and marcar.agendar like ?    ORDER BY consulta.tipo_consulta";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
         stmt.setString(1, '%'+nomeExame+'%');
              stmt.setString(2, '%'+nomeMedico+'%');
              stmt.setString(3, '%'+data+'%');
              stmt.setString(4, '%'+forma+'%');
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Marcar objm = new Marcar();
                  objm.setId_marcar(rs.getInt("id_marcar"));
                 objm.setDataFazer(rs.getString("dataFazer"));
                 objm.setNomeParaJoin(rs.getString("consulta.tipo_consulta"));
                  objm.setAgendar(rs.getString("agendar"));
                  objm.setNomeMedico(rs.getString("nomeMedico"));
                 
          
          
                  
                  
                  
             
                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
     
     
     
     
     
     
     public List<Marcar> listaDatasExames(){
     
     List<Marcar> lista = new ArrayList<Marcar>();
     
         try {
              String cmsqlb = "SELECT marcar.id_marcar,marcar.dataFazer,exame.tipo_exame, marcar.agendar,marcar.horarios,medico.nomeMedico,exame.valor_exame FROM marcar \n" +
"inner JOIN exame on  marcar.id_exame = exame.id_exame\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"ORDER BY exame.tipo_exame,id_marcar DESC LIMIT 100 ";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Marcar objm = new Marcar();
                 objm.setId_marcar(rs.getInt("id_marcar"));
                 objm.setDataFazer(rs.getString("dataFazer"));
                 objm.setNomeParaJoin(rs.getString("tipo_exame"));
                  objm.setAgendar(rs.getString("agendar"));
                  objm.setNomeMedico(rs.getString("nomeMedico"));
                  objm.setValorExame(rs.getFloat("valor_exame"));
          
                  
                  
                  
             
                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
    
      
     
     public List<JoinBuscarExameEMarcar> listaDatasExamesNomeMedicoForma(String nomeExame,String nomeMedico,String data,String forma){
     
     List<JoinBuscarExameEMarcar> lista = new ArrayList<JoinBuscarExameEMarcar>();
     
         try {
              String cmsqlb = "SELECT marcar.id_marcar,marcar.dataFazer,exame.tipo_exame, marcar.agendar,marcar.horarios,medico.nomeMedico FROM marcar \n" +
"inner JOIN exame on  marcar.id_exame = exame.id_exame\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"where exame.tipo_exame like ? and medico.nomeMedico like ? and marcar.dataFazer like ? and marcar.agendar like ?    ORDER BY exame.tipo_exame";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+nomeExame+'%');
              stmt.setString(2, '%'+nomeMedico+'%');
              stmt.setString(3, '%'+data+'%');
              stmt.setString(4, '%'+forma+'%');
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 JoinBuscarExameEMarcar objm = new JoinBuscarExameEMarcar();
                 objm.setId_marcarBuscar(rs.getInt("id_marcar"));
                 objm.setDataRealizar(rs.getString("dataFazer"));
                 objm.setExameRequerido(rs.getString("tipo_exame"));
                  objm.setFormaRealizar(rs.getString("agendar"));
                  objm.setNomeMedico(rs.getString("nomeMedico"));
          
                  
                  
                  
             
                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
     
     
     
     
     
     
     
     public List<Marcar> listaDatasExamesPorData(String dataBuscar,String nomeExame,String nomeMedico, String agendar){
     
     List<Marcar> lista = new ArrayList<Marcar>();
     
         try {
              String cmsqlb = "SELECT marcar.id_marcar,\n" +
"marcar.dataFazer,exame.tipo_exame, \n" +
"marcar.agendar ,\n" +
"medico.nomeMedico\n" +
"FROM marcar \n" +
"inner JOIN exame on  marcar.id_exame = exame.id_exame\n" +
"inner JOIN medico on  medico.id_medico = marcar.id_medico\n" +
"where marcar.dataFazer like ? \n" +
"and exame.tipo_exame like ?\n" +
"and medico.nomeMedico LIKE ?\n" +
"and marcar.agendar LIKE ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+dataBuscar+'%');
              stmt.setString(2, '%'+nomeExame+'%');
              stmt.setString(3, '%'+nomeMedico+'%');
              stmt.setString(4, '%'+agendar+'%');
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Marcar objm = new Marcar();
                 objm.setId_marcar(rs.getInt("id_marcar"));
                 objm.setDataFazer(rs.getString("dataFazer"));
                 objm.setNomeParaJoin(rs.getString("tipo_exame"));
                  objm.setAgendar(rs.getString("agendar"));
                  objm.setNomeMedico(rs.getString("nomeMedico"));
           
                  
                  
                  
             
                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
     
     
     
     
     
     
     
     
     
     
}
