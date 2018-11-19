
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.JoinBuscarExameEMarcar;
import br.auroClin.model.joinBuscarConsultaMarcar;
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
public class JoinDAO {
    
      private Connection conecta;
    
    public JoinDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
   
    
    
    public List<JoinBuscarExameEMarcar> listarExames(){
     
     List<JoinBuscarExameEMarcar> lista = new ArrayList<JoinBuscarExameEMarcar>();
     
         try {
              String cmsqlb = "select marcar.id_marcar, \n" +
"exame.tipo_exame,\n" +
"exame.valor_exame,\n" +
"marcar.dataFazer,\n" +
"exame.valor_exame,\n" +
"marcar.agendar,\n" +
"medico.nomeMedico\n" +
"\n" +
"from exame\n" +
"inner join marcar on exame.id_exame = marcar.id_exame \n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"ORDER BY id_marcar DESC LIMIT 20";
             // 1º Organizar o Comando SQL
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 JoinBuscarExameEMarcar objoin = new JoinBuscarExameEMarcar();
                 
                 objoin.setId_marcarBuscar(rs.getInt("marcar.id_marcar"));
                 objoin.setExameRequerido(rs.getString("exame.tipo_exame"));
                 objoin.setDataRealizar(rs.getString("marcar.dataFazer"));
                 objoin.setValorExame(rs.getFloat("exame.valor_exame"));
                  objoin.setFormaRealizar(rs.getString("agendar"));
                  objoin.setNomeMedico(rs.getString("nomeMedico"));
              
                 
                 
                 lista.add(objoin);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao buscar Join"+e);
         }
              return  lista;
     
     }  
    
    
    
    
    
    
     
    public List<JoinBuscarExameEMarcar> listarExamesPorNomeParaMarcar(String nome){
     
     List<JoinBuscarExameEMarcar> lista = new ArrayList<JoinBuscarExameEMarcar>();
     
         try {
              String cmsqlb = "select marcar.id_marcar, exame.tipo_exame,exame.valor_exame, marcar.dataFazer, exame.valor_exame from exame inner join marcar on exame.id_exame = marcar.id_exame where exame.tipo_exame LIKE ?";
             // 1º Organizar o Comando SQL
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+nome+'%');
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 JoinBuscarExameEMarcar objoin = new JoinBuscarExameEMarcar();
                 
                 objoin.setId_marcarBuscar(rs.getInt("marcar.id_marcar"));
                 objoin.setExameRequerido(rs.getString("exame.tipo_exame"));
                 objoin.setDataRealizar(rs.getString("marcar.dataFazer"));
                 objoin.setValorExame(rs.getFloat("exame.valor_exame"));
                 
                 lista.add(objoin);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao buscar Join"+e);
         }
              return  lista;
     
     }  
    
    
    
    
    
    
     
     
    public List<JoinBuscarExameEMarcar> listarExamesMarcadosPorNome( String dataBuscar){
     
     List<JoinBuscarExameEMarcar> lista = new ArrayList<JoinBuscarExameEMarcar>();
     
         try {
              String cmsqlb = "select marcar.id_marcar, exame.tipo_exame, marcar.dataFazer, exame.valor_exame from exame inner join marcar on exame.id_exame = marcar.id_exame where marcar.dataFazer=?";
             // 1º Organizar o Comando SQL
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, dataBuscar);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 JoinBuscarExameEMarcar objoin = new JoinBuscarExameEMarcar();
                 
                 objoin.setId_marcarBuscar(rs.getInt("marcar.id_marcar"));
                 objoin.setExameRequerido(rs.getString("exame.tipo_exame"));
                 objoin.setDataRealizar(rs.getString("marcar.dataFazer"));
                 objoin.setValorExame(rs.getFloat("exame.valor_exame"));
                 
                 lista.add(objoin);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao buscar Join"+e);
         }
              return  lista;
     
     }  
    
    
    
     
     
     
     
     
      
    public List<joinBuscarConsultaMarcar> listarConsultas(){
     
     List<joinBuscarConsultaMarcar> lista = new ArrayList<joinBuscarConsultaMarcar>();
     
         try {
              String cmsqlb = "select marcar.id_marcar, marcar.horarios, consulta.tipo_consulta,consulta.valor_consulta, marcar.dataFazer\n" +
"                     from consulta\n" +
"inner join marcar on consulta.id_consulta = marcar.id_consulta ORDER BY id_marcar DESC LIMIT 5";
             // 1º Organizar o Comando SQL
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 joinBuscarConsultaMarcar objoin = new joinBuscarConsultaMarcar();
                 
                 objoin.setId_marcarBuscar(rs.getInt("marcar.id_marcar"));
                 objoin.setConsultaRequerido(rs.getString("consulta.tipo_consulta"));
                 objoin.setDataRealizar(rs.getString("marcar.dataFazer"));
                 objoin.setValorConsulta(rs.getFloat("consulta.valor_consulta"));
                 objoin.setHorario(rs.getString("horarios"));
                 lista.add(objoin);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao buscar Join"+e);
         }
              return  lista;
     
     }  
    
     
    
    
    
    
    
     public List<joinBuscarConsultaMarcar> listarConsultasPorNomeParaMarcar(String nome){
     
     List<joinBuscarConsultaMarcar> lista = new ArrayList<joinBuscarConsultaMarcar>();
     
         try {
              String cmsqlb = "select marcar.id_marcar, consulta.tipo_consulta,consulta.valor_consulta, marcar.dataFazer, consulta.valor_consulta from consulta inner join"
                      + " marcar on consulta.id_consulta = marcar.id_consulta where consulta.tipo_consulta LIKE ?";
             // 1º Organizar o Comando SQL
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+nome+'%');
            
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 
                 
                 joinBuscarConsultaMarcar objoin = new joinBuscarConsultaMarcar();
                 
                 objoin.setId_marcarBuscar(rs.getInt("marcar.id_marcar"));
                 objoin.setConsultaRequerido(rs.getString("consulta.tipo_consulta"));
                 objoin.setDataRealizar(rs.getString("marcar.dataFazer"));
                 objoin.setValorConsulta(rs.getFloat("consulta.valor_consulta"));
                 
                 lista.add(objoin);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao buscar Join"+e);
         }
              return  lista;
     
     }  
    

     public List<joinBuscarConsultaMarcar> listartESTE(String nome, String data){
     
     List<joinBuscarConsultaMarcar> lista = new ArrayList<joinBuscarConsultaMarcar>();
     
         try {
              String cmsqlb = "select marcar.id_marcar, consulta.tipo_consulta,consulta.valor_consulta, marcar.dataFazer, marcar.horarios from consulta inner join"
                      + " marcar on consulta.id_consulta = marcar.id_consulta where consulta.tipo_consulta LIKE ? and marcar.dataFazer like ?";
             // 1º Organizar o Comando SQL
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+nome+'%');
              stmt.setString(2, '%'+data+'%');
            
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 
                 
                 joinBuscarConsultaMarcar objoin = new joinBuscarConsultaMarcar();
                 
                 objoin.setId_marcarBuscar(rs.getInt("marcar.id_marcar"));
                 objoin.setConsultaRequerido(rs.getString("consulta.tipo_consulta"));
                 objoin.setDataRealizar(rs.getString("marcar.dataFazer"));
                  objoin.setHorario(rs.getString("horarios"));
                 objoin.setValorConsulta(rs.getFloat("consulta.valor_consulta"));
                 
                 lista.add(objoin);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao buscar Join"+e);
         }
              return  lista;
     
     }  
    
     
    
   
    
    public List<joinBuscarConsultaMarcar> listartESTEXAMES(String nome, String data){
     
     List<joinBuscarConsultaMarcar> lista = new ArrayList<joinBuscarConsultaMarcar>();
     
         try {
              String cmsqlb = "select marcar.id_marcar, \n" +
"exame.tipo_exame,\n" +
"exame.valor_exame,\n" +
"marcar.dataFazer, \n" +
"marcar.horarios \n" +
"from exame inner join\n" +
"marcar on exame.id_exame = marcar.id_exame\n" +
"where exame.tipo_exame LIKE ? and marcar.dataFazer LIKE ?";
             // 1º Organizar o Comando SQL
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+nome+'%');
              stmt.setString(2, '%'+data+'%');
            
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 
                 
                 joinBuscarConsultaMarcar objoin = new joinBuscarConsultaMarcar();
                 
                 objoin.setId_marcarBuscar(rs.getInt("marcar.id_marcar"));
                 objoin.setConsultaRequerido(rs.getString("exame.tipo_exame"));
                 objoin.setDataRealizar(rs.getString("marcar.dataFazer"));
                  objoin.setHorario(rs.getString("horarios"));
                 objoin.setValorConsulta(rs.getFloat("exame.valor_exame"));
                 
                 lista.add(objoin);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao buscar Join"+e);
         }
              return  lista;
     
     }  
    
    
    
}
