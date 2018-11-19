/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.JoinBuscarExameEMarcar;
import br.auroClin.model.Marcar;
import br.auroClin.model.relatorioExame;
import br.auroClin.model.retornoExamesConsultas;
import br.auroClin.model.retornoModelo;

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
public class retornoDAO {
    
      private Connection conecta;
    
    public retornoDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
     public void cadastrarRetorno(retornoModelo objr){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into retorno(id_marcar,id_paciente,retorno,id_marcado)values(?,?,?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setInt(1, objr.getId_marcar());
             stmt.setInt(2, objr.getId_paciente());
             stmt.setString(3, objr.getRetorno());
             stmt.setInt(4, objr.getIdMarcado());
             
            
         
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
    
    
    
    
     public void cadastrarConsulta(retornoExamesConsultas obr){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into retorno(tipo_consulta,valor_consulta)values(?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
           //  stmt.setString(1, objconsult.getNomeConsulta());
             //stmt.setFloat(2, objconsult.getValorConsulta());
         
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro ao cadastrar Consulta"+erro);
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
    
    }
    
    
    
    
     public List<JoinBuscarExameEMarcar> listaDatasExamesRetorno(String nomePaciente){
     
     List<JoinBuscarExameEMarcar> lista = new ArrayList<JoinBuscarExameEMarcar>();
     
         try {
              String cmsqlb = "SELECT \n" +
"marcar.id_marcar,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"marcar.agendar\n" +
",marcar.agendar,\n" +
"medico.nomeMedico,\n" +
"paciente.nome_paciente,\n" +
"marcarexame.retorno\n" +
"FROM marcar\n" +
"inner JOIN consulta on  marcar.id_consulta = consulta.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar \n" +
"inner join paciente on paciente.id_paciente= marcarexame.id_paciente WHERE\n" +
"paciente.nome_paciente like ?" +
"UNION ALL\n" +
"\n" +
"SELECT \n" +
"marcar.id_marcar,\n" +
"marcar.dataFazer,\n" +
"exame.tipo_exame,\n" +
"marcar.agendar\n" +
",marcar.agendar,\n" +
"medico.nomeMedico,\n" +
"paciente.nome_paciente,\n" +
"marcarexame.retorno\n" +
"FROM marcar\n" +
"inner JOIN exame on  marcar.id_exame = exame.id_exame\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar \n" +
"inner join paciente on paciente.id_paciente= marcarexame.id_paciente WHERE\n" +
"paciente.nome_paciente like ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+nomePaciente+'%');
              stmt.setString(2, '%'+nomePaciente+'%');
           
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 JoinBuscarExameEMarcar objm = new JoinBuscarExameEMarcar();
                 objm.setId_marcarBuscar(rs.getInt("id_marcar"));
                 objm.setDataRealizar(rs.getString("dataFazer"));
                 objm.setExameRequerido(rs.getString("tipo_consulta"));
                  objm.setFormaRealizar(rs.getString("agendar"));
                  objm.setNomeMedico(rs.getString("nomeMedico"));
                  objm.setRetorno(rs.getString("retorno"));
          
                  
                   
             
                 lista.add(objm);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Buscar Consulta");
             JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
     
     
    
     public boolean ValidarRetorno(int idExame){
         
         
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "select  \n" +
"marcar.dataFazer \n" +
"from marcar\n" +
"inner join exame on exame.id_exame = marcar.id_exame\n" +
"where id_marcar = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setInt(1, idExame);
             
             
            
             
             ResultSet rs = stmt.executeQuery();
             
             
        
             
             if (rs.first()) {

                 //fez login
               
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }

    
    
     
     
     
     
     public List<JoinBuscarExameEMarcar> BuscarExameConsultasMArcarRetorno(String nomeExame,int id){
     
     List<JoinBuscarExameEMarcar> lista = new ArrayList<JoinBuscarExameEMarcar>();
     
     
     System.out.println(nomeExame);
     System.out.println(id);
     
     
         try {
              String cmsqlb = "SELECT marcar.id_marcar,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"marcar.agendar,\n" +
"medico.nomeMedico \n" +
"FROM marcar\n" +
"inner JOIN consulta on  marcar.id_consulta = consulta.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"where consulta.tipo_consulta like ? and  marcar.id_marcar <> ?\n" +
"UNION all \n" +
"\n" +
"\n" +
"SELECT marcar.id_marcar,\n" +
"marcar.dataFazer,\n" +
"exame.tipo_exame,\n" +
"marcar.agendar ,\n" +
"medico.nomeMedico\n" +
"FROM marcar \n" +
"inner JOIN exame on  marcar.id_exame = exame.id_exame\n" +
"inner JOIN medico on  medico.id_medico = marcar.id_medico\n" +
"where exame.tipo_exame like ? and  marcar.id_marcar <> ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+nomeExame+'%');
               stmt.setInt(2, id);
              stmt.setString(3, '%'+nomeExame+'%');
              stmt.setInt(4, id);
            
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 JoinBuscarExameEMarcar objm = new JoinBuscarExameEMarcar();
                 objm.setId_marcarBuscar(rs.getInt("id_marcar"));
                 objm.setDataRealizar(rs.getString("dataFazer"));
                 objm.setExameRequerido(rs.getString("tipo_consulta"));
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
    
     
     
  
     
     
     
     
     
       
     
     public List<JoinBuscarExameEMarcar> BuscarExameConsultasMArcarRetornoPorData(String dataBuscar,String nomeExameConsulta,int idMarcado){
     
     List<JoinBuscarExameEMarcar> lista = new ArrayList<JoinBuscarExameEMarcar>();
     
         try {
             
             
             String cmsqlb = "SELECT marcar.id_marcar,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"marcar.agendar,\n" +
"medico.nomeMedico\n" +
"FROM marcar\n" +
"inner JOIN consulta on  marcar.id_consulta = consulta.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"where  marcar.id_marcar <> ? and consulta.tipo_consulta like ? and marcar.dataFazer like ?\n" +
"\n" +
"union all\n" +
"\n" +
"SELECT marcar.id_marcar,\n" +
"marcar.dataFazer,\n" +
"exame.tipo_exame,\n" +
"marcar.agendar ,\n" +
"medico.nomeMedico\n" +
"FROM marcar\n" +
"inner JOIN exame on  marcar.id_exame = exame.id_exame\n" +
"inner JOIN medico on  medico.id_medico = marcar.id_medico\n" +
"where  marcar.id_marcar <> ? and exame.tipo_exame like ? and marcar.dataFazer like ?";

            
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setInt(1, idMarcado);
              stmt.setString(2, '%'+nomeExameConsulta+'%');
              stmt.setString(3, '%'+dataBuscar+'%');
              stmt.setInt(4, idMarcado);
              stmt.setString(5, '%'+nomeExameConsulta+'%');
              stmt.setString(6, '%'+dataBuscar+'%');
            
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 JoinBuscarExameEMarcar objm = new JoinBuscarExameEMarcar();
                 objm.setId_marcarBuscar(rs.getInt("id_marcar"));
                 objm.setDataRealizar(rs.getString("dataFazer"));
                 objm.setExameRequerido(rs.getString("tipo_consulta"));
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
    
     
     
     
     
     
      
     public List<relatorioExame> retornoConsultasExames(String dataBanco){
    
     List<relatorioExame> lista = new ArrayList<relatorioExame>();
 
         try {
              String cmsqlb = "SELECT\n" +
"marcar.id_marcar,\n" +
"marcar.dataFazer,\n" +
"exame.tipo_exame,\n" +
"marcar.agendar\n" +
",marcar.agendar,\n" +
"medico.nomeMedico,\n" +
"paciente.nome_paciente,\n" +
"marcarexame.retorno\n" +
"FROM marcar\n" +
"inner JOIN exame on  marcar.id_exame = exame.id_exame\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join paciente on paciente.id_paciente= marcarexame.id_paciente \n" +
"where marcar.dataFazer like ? and marcarexame.retorno = ?\n" +
"UNION ALL\n" +
"SELECT\n" +
"marcar.id_marcar,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"marcar.agendar\n" +
",marcar.agendar,\n" +
"medico.nomeMedico,\n" +
"paciente.nome_paciente,\n" +
"marcarexame.retorno\n" +
"FROM marcar\n" +
"inner JOIN consulta on  consulta.id_consulta = marcar.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join paciente on paciente.id_paciente= marcarexame.id_paciente \n" +
"where marcar.dataFazer like ? and marcarexame.retorno = ?";
             // 1º Organizar o Comando SQL
             
             
              String retorno = "RETORNO";
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, '%'+dataBanco+'%');
              stmt.setString(2, retorno);
               stmt.setString(3, '%'+dataBanco+'%');
              stmt.setString(4, retorno);
             ResultSet rs = stmt.executeQuery();
             
            boolean existe = false;
        
             while (rs.next()) {
                 
                 existe = true;
                 relatorioExame ob = new relatorioExame();
                 ob.setNomePAciente(rs.getString("nome_paciente"));
           
                 ob.setDataFazer(rs.getString("dataFazer"));
                 ob.setNomeBusca(rs.getString("tipo_exame"));
                 ob.setNomeMedico(rs.getString("nomeMedico"));
                 ob.setHorarios(rs.getString("retorno"));
       
                 lista.add(ob);
                 
           
                 
             }
             
           
             
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
     
     
     
     
     
     
     
     
      
     public List<relatorioExame> retornoConsultasExamesNomePaciente(String dataBanco,String NomePaciente){
    
     List<relatorioExame> lista = new ArrayList<relatorioExame>();
 
         try {
              String cmsqlb = "SELECT\n" +
"marcarexame.id_marcarExame,\n" +
"marcar.id_marcar,\n" +
"marcar.dataFazer,\n" +
"exame.tipo_exame,\n" +
"marcar.agendar\n" +
",marcar.agendar,\n" +
"medico.nomeMedico,\n" +
"paciente.nome_paciente,\n" +
"marcarexame.retorno,\n" +
"marcarexame.situacaoFila\n" +
"FROM marcar\n" +
"inner JOIN exame on  marcar.id_exame = exame.id_exame\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join paciente on paciente.id_paciente= marcarexame.id_paciente \n" +
"where marcar.dataFazer like ? and marcarexame.retorno = ? and paciente.nome_paciente like ?\n" +
"UNION ALL\n" +
"SELECT\n" +
"marcarexame.id_marcarExame,\n" +
"marcar.id_marcar,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"marcar.agendar\n" +
",marcar.agendar,\n" +
"medico.nomeMedico,\n" +
"paciente.nome_paciente,\n" +
"marcarexame.retorno,\n" +
"marcarexame.situacaoFila\n" +
"FROM marcar\n" +
"inner JOIN consulta on  consulta.id_consulta = marcar.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar \n" +
"inner join paciente on paciente.id_paciente= marcarexame.id_paciente \n" +
"where marcar.dataFazer like ? and marcarexame.retorno = ? and paciente.nome_paciente like ?";
             // 1º Organizar o Comando SQL
             
             
              String retorno = "RETORNO";
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, '%'+dataBanco+'%');
              stmt.setString(2, retorno);
              stmt.setString(3, '%'+NomePaciente+'%');
                stmt.setString(4, '%'+dataBanco+'%');
              stmt.setString(5, retorno);
              stmt.setString(6, '%'+NomePaciente+'%');
               
             ResultSet rs = stmt.executeQuery();
             
            boolean existe = false;
        
             while (rs.next()) {
                 
                 existe = true;
                 relatorioExame ob = new relatorioExame();
                 ob.setId_marcar(rs.getInt("id_marcar"));
                 ob.setId_retorno(rs.getInt("id_marcarExame"));
                 ob.setNomePAciente(rs.getString("nome_paciente"));
                 ob.setDataFazer(rs.getString("dataFazer"));
                 ob.setNomeBusca(rs.getString("tipo_exame"));
                 ob.setNomeMedico(rs.getString("nomeMedico"));
                 ob.setHorarios(rs.getString("retorno"));
                 ob.setSituacaoFila(rs.getString("situacaoFila"));
       
                 lista.add(ob);
                 
           
                 
             }
             
           
             
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
     
     
     
     
     
     
      public List<relatorioExame> retornoConsultasExamesRemarcar(String dataBanco){
    
     List<relatorioExame> lista = new ArrayList<relatorioExame>();
 
         try {
              String cmsqlb = "SELECT\n" +
"marcarexame.id_marcarExame,\n" +
"marcar.id_marcar,\n" +
"marcar.dataFazer,\n" +
"exame.tipo_exame,\n" +
"marcar.agendar\n" +
",marcar.agendar,\n" +
"medico.nomeMedico,\n" +
"paciente.nome_paciente,\n" +
"marcarexame.retorno,\n" +
"marcarexame.situacaoFila\n" +
"FROM marcar\n" +
"inner JOIN exame on  marcar.id_exame = exame.id_exame\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join paciente on paciente.id_paciente= marcarexame.id_paciente \n" +
"where marcar.dataFazer like ? and marcarexame.retorno = ? \n" +
"UNION ALL\n" +
"SELECT\n" +
"marcarexame.id_marcarExame,\n" +
"marcar.id_marcar,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"marcar.agendar\n" +
",marcar.agendar,\n" +
"medico.nomeMedico,\n" +
"paciente.nome_paciente,\n" +
"marcarexame.retorno,\n" +
"marcarexame.situacaoFila\n" +
"FROM marcar\n" +
"inner JOIN consulta on  consulta.id_consulta = marcar.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar \n" +
"inner join paciente on paciente.id_paciente= marcarexame.id_paciente \n" +
"where marcar.dataFazer like ? and marcarexame.retorno = ?";
             // 1º Organizar o Comando SQL
             
             
              String retorno = "RETORNO";
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, '%'+dataBanco+'%');
              stmt.setString(2, retorno);
               stmt.setString(3, '%'+dataBanco+'%');
              stmt.setString(4, retorno);
             ResultSet rs = stmt.executeQuery();
             
            boolean existe = false;
        
             while (rs.next()) {
                 
                 existe = true;
                 relatorioExame ob = new relatorioExame();
                 ob.setId_marcar(rs.getInt("id_marcar"));
                ob.setId_retorno(rs.getInt("id_marcarExame"));
                 ob.setNomePAciente(rs.getString("nome_paciente"));
                 ob.setDataFazer(rs.getString("dataFazer"));
                 ob.setNomeBusca(rs.getString("tipo_exame"));
                 ob.setNomeMedico(rs.getString("nomeMedico"));
                 ob.setHorarios(rs.getString("retorno"));
                 ob.setSituacaoFila(rs.getString("situacaoFila"));
       
                 lista.add(ob);
                 
           
                 
             }
             
           
             
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
     
     
      public void CadastrarRemarcarRetorno(int idMarcarexame, int idMarcar){
    //-----------------------------------------------------
        try {
          
            System.out.println(idMarcarexame);
            System.out.println(idMarcar);
            
            // 1º passo Criar Comando SQL
            String cmsql = "update marcarexame set marcarexame.id_marcar = ? where marcarexame.id_marcarExame = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setFloat(1, idMarcar);
             stmt.setDouble(2, idMarcarexame);
             
         
         
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro ao Efetuar Pagamento"+erro);
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
     

}
  
     
     
}
