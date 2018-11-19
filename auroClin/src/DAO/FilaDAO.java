/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.BuscarFicha;
import br.auroClin.model.FilaModelo;
import br.auroClin.model.InserirNafila;
import br.auroClin.model.finalizarMarcar;
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
public class FilaDAO {
    
    
    
      private Connection conecta;
    
    public FilaDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
    
    public List<FilaModelo> listarExames( String data){
     
     List<FilaModelo> lista = new ArrayList<FilaModelo>();
     
         try {
              String cmsqlb = "select marcarexame.id_marcarExame,\n" +
"exame.tipo_exame,\n" +
"paciente.nome_paciente,\n" +
"paciente.plano,\n" +
"fila.nFicha,\n" +
"fila.prioridade,\n" +
"medico.nomeMedico,\n" +
"marcarexame.situacaoFila\n" +
"from marcar\n" +
"\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on exame.id_exame = marcar.id_exame\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join fila on marcarexame.id_marcarExame = fila.id_marcarExame\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where marcar.dataAbrir = ?\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"select marcarexame.id_marcarExame,\n" +
"consulta.tipo_consulta,\n" +
"paciente.nome_paciente,\n" +
"paciente.plano,\n" +
"fila.nFicha,\n" +
"fila.prioridade,\n" +
"medico.nomeMedico,\n" +
"marcarexame.situacaoFila\n" +
"from marcar\n" +
"\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on consulta.id_consulta = marcar.id_consulta\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join fila on marcarexame.id_marcarExame = fila.id_marcarExame\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where marcar.dataFazer = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, data);
             stmt.setString(2, data);
       
            
              
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 FilaModelo ex = new FilaModelo();
                 ex.setIdMarcar(rs.getInt("id_marcarExame"));
                 ex.setNomePaciente(rs.getString("nome_paciente"));
                 ex.setNomeConsulta(rs.getString("tipo_exame"));
                 ex.setNumeroFicha(rs.getString("nFicha"));
                 ex.setPrioridade(rs.getString("prioridade"));
                 ex.setMedico(rs.getString("nomeMedico"));
                 ex.setSituacaoFila(rs.getString("situacaoFila"));
                 System.out.println(ex.getSituacaoFila());
              
        

                 lista.add(ex);
        
             }
        
             
         }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
    
    
    
    
    
    
    
    
    
     public List<FilaModelo> listarExamesMArcados( String data){
     
     List<FilaModelo> lista = new ArrayList<FilaModelo>();
     
         try {
              String cmsqlb = "SELECT marcarexame.id_marcarExame,\n" +
"paciente.nome_paciente,\n" +
"consulta.tipo_consulta,\n" +
"medico.nomeMedico,\n" +
"marcarexame.situacaoFila,\n" +
"marcarexame.retorno\n" +
"from marcar\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on marcar.id_consulta = consulta.id_consulta\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where dataFazer = ? and situacaoFila = ?\n" +
"union all\n" +
"SELECT \n" +
"marcarexame.id_marcarExame,\n" +
"paciente.nome_paciente,\n" +
"exame.tipo_exame,\n" +
"medico.nomeMedico,\n" +
"marcarexame.situacaoFila,\n" +
"marcarexame.retorno\n" +
"from marcar\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on marcar.id_exame = exame.id_exame\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where dataFazer = ? and situacaoFila = ?";
             // 1º Organizar o Comando SQL
             
             String BuscarEspera = "ESPERA";
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, data);
             stmt.setString(2, BuscarEspera);
             stmt.setString(3, data);
             stmt.setString(4, BuscarEspera);
       
            
              
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 FilaModelo ex = new FilaModelo();
                 ex.setIdMarcar(rs.getInt("id_marcarExame"));
                 ex.setNomePaciente(rs.getString("nome_paciente"));
                 ex.setNomeConsulta(rs.getString("tipo_consulta")); 
                 ex.setMedico(rs.getString("nomeMedico"));
                 ex.setSituacaoFila(rs.getString("situacaoFila"));
                 ex.setRetorno(rs.getString("retorno"));
                 

                 lista.add(ex);
        
             }
        
             
         }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
    
    
  
     
     
     
     public List<FilaModelo> listarExamesMArcadosNome(String nomePaciente,String nomeExame, String nomeMedico, String data){
     
     List<FilaModelo> lista = new ArrayList<FilaModelo>();
     
         try {
              String cmsqlb = "select marcarexame.id_marcarExame,marcarexame.situacaoFila,\n" +
"exame.tipo_exame,\n" +
"exame.valor_exame,\n" +
"paciente.nome_paciente,\n" +
"paciente.plano,\n" +
"medico.nomeMedico,\n" +
"marcarexame.retorno\n" +
"from marcar\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on marcar.id_exame = exame.id_exame\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where marcar.dataFazer = ? and situacaoFila = ? AND paciente.nome_paciente LIKE ? AND exame.tipo_exame LIKE ? AND medico.nomeMedico like ?\n" +
"union ALL\n" +
"select marcarexame.id_marcarExame,marcarexame.situacaoFila,\n" +
"consulta.tipo_consulta,\n" +
"consulta.valor_consulta,\n" +
"paciente.nome_paciente,\n" +
"paciente.plano,\n" +
"medico.nomeMedico,\n" +
"marcarexame.retorno\n" +
"from marcar\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on consulta.id_consulta = marcar.id_consulta\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where marcar.dataFazer = ? and situacaoFila = ? AND paciente.nome_paciente LIKE ? AND consulta.tipo_consulta LIKE ? AND medico.nomeMedico like ?";
             // 1º Organizar o Comando SQL
             
             String BuscarEspera = "ESPERA";
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, data);
             stmt.setString(2, BuscarEspera);
             stmt.setString(3, "%"+nomePaciente+"%");
              stmt.setString(4, "%"+nomeExame+"%");
               stmt.setString(5, "%"+nomeMedico+"%");
               stmt.setString(6, data);
             stmt.setString(7, BuscarEspera);
             stmt.setString(8, "%"+nomePaciente+"%");
              stmt.setString(9, "%"+nomeExame+"%");
               stmt.setString(10, "%"+nomeMedico+"%");
       
            
              
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 FilaModelo ex = new FilaModelo();
                 ex.setIdMarcar(rs.getInt("id_marcarExame"));
                 ex.setNomePaciente(rs.getString("nome_paciente"));
                 ex.setNomeConsulta(rs.getString("tipo_exame")); 
                 ex.setMedico(rs.getString("nomeMedico"));
                 ex.setSituacaoFila(rs.getString("situacaoFila"));
                 ex.setRetorno(rs.getString("retorno"));
       

                 lista.add(ex);
        
             }
        
             
         }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
   
     
     
     
     
      public List<FilaModelo> examesParClic(String data){
     
     List<FilaModelo> lista = new ArrayList<FilaModelo>();
     
         try {
              String cmsqlb = "select\n" +
"exame.tipo_exame,\n" +
"medico.nomeMedico\n" +
"from marcar\n" +
"inner join exame on exame.id_exame = marcar.id_exame\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where marcar.dataFazer = ?\n" +
"group by exame.tipo_exame,medico.nomeMedico\n" +
"having Count(exame.tipo_exame)>=1 \n" +
"union all\n" +
"select\n" +
"consulta.tipo_consulta,\n" +
"medico.nomeMedico\n" +
"from marcar\n" +
"inner join consulta on consulta.id_consulta = marcar.id_consulta\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where marcar.dataFazer = ?\n" +
"group by consulta.tipo_consulta,medico.nomeMedico\n" +
"having Count(consulta.tipo_consulta)>=1 ";
             // 1º Organizar o Comando SQL
             
       
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, data);
             stmt.setString(2, data);

             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 FilaModelo ex = new FilaModelo();
                 
                 ex.setNomeConsulta(rs.getString("tipo_exame"));
                 ex.setMedico(rs.getString("nomeMedico"));
                 
           
              
       

                 lista.add(ex);
        
             }
        
             
         }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
     
     
   
      
      
     
      public List<BuscarFicha> examesParFicha(String data, String exame, String nomeMedico){
          
     
     List<BuscarFicha> lista = new ArrayList<BuscarFicha>();
     
         try {
              String cmsqlb = "select \n" +
"exame.tipo_exame, \n" +
"fila.nFicha\n" +
"\n" +
"from marcar\n" +
"\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on exame.id_exame = marcar.id_exame\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join fila on marcarexame.id_marcarExame = fila.id_marcarExame\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where marcar.dataFazer = ? and exame.tipo_exame = ? AND medico.nomeMedico = ?";
             // 1º Organizar o Comando SQL
             
       
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, data);
             stmt.setString(2, exame);
             stmt.setString(3, nomeMedico);
   System.out.println("Teste");
             ResultSet rs = stmt.executeQuery();
              BuscarFicha ficha = new BuscarFicha();
             while (rs.next()) {
                
                 
                 ficha.setExame(rs.getString("tipo_exame"));
                 ficha.setFicha(rs.getString("nFicha"));
              
  
                
                    
                 lista.add(ficha);
        
             }
    
             
         }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
      
      
      
      
      
      
      
      
      public List<BuscarFicha> ConsultasParFicha(String data, String exame, String nomeMedico){
          
     
     List<BuscarFicha> lista = new ArrayList<BuscarFicha>();
     
         try {
              String cmsqlb = "select\n" +
"consulta.tipo_consulta,\n" +
"fila.nFicha\n" +
"from marcar\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on consulta.id_consulta = marcar.id_consulta\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join fila on marcarexame.id_marcarExame = fila.id_marcarExame\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where marcar.dataFazer = ? and consulta.tipo_consulta= ? AND medico.nomeMedico = ?";
             // 1º Organizar o Comando SQL
             
       
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, data);
             stmt.setString(2, exame);
             stmt.setString(3, nomeMedico);
   System.out.println("Teste");
             ResultSet rs = stmt.executeQuery();
              BuscarFicha ficha = new BuscarFicha();
             while (rs.next()) {
                
                 
                 ficha.setExame(rs.getString("tipo_consulta"));
                 ficha.setFicha(rs.getString("nFicha"));
              
  
                
                    
                 lista.add(ficha);
        
             }
    
             
         }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
      
      
      
       public void inserirnaFila(InserirNafila pfila){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into fila(nFicha,id_marcarExame)values(?,?)";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, pfila.getFicha());
             stmt.setInt(2, pfila.getId_exame());
         
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro ao cadastrar na Fila"+erro);
            throw new RuntimeException(erro);
            
        }
      
      
       }
       
       
       
        public void atualizarSituacaoNaFila(finalizarMarcar fmarcar){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "update marcarexame set situacaoFila = ? where id_marcarExame=?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, fmarcar.getSituacaoFila());
             stmt.setInt(2, fmarcar.getIdMarcar());
         
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro ao Edicat Consulta"+erro);
            throw new RuntimeException(erro);
            
        }
       
        }
        
        
        
         public boolean validarFila(int idMarcar, String situacao){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "SELECT situacaoFila FROM marcarexame WHERE id_marcarExame = ? and situacaoFila = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setInt(1, idMarcar);
             stmt.setString(2, situacao);
         
             
             ResultSet rs = stmt.executeQuery();
             
             if (rs.first()) {
                 
                 //fez login
                 
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }
     
        
   
         
         public boolean validareExameOuConsulta(String nomeExame){
     
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "select exame.tipo_exame\n" +
"from exame\n" +
"inner join marcar on marcar.id_exame = exame.id_exame\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"where exame.tipo_exame = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, nomeExame);
         
             
             ResultSet rs = stmt.executeQuery();
             
             if (rs.first()) {
                 
                 //fez login
                 
                 return true;
             } 
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
           return false;
     }
     
        
   
         
         
         
         
      public List<FilaModelo> buscarIdFila(int idMarcar){
     
     List<FilaModelo> lista = new ArrayList<FilaModelo>();
     
         try {
              String cmsqlb = "select fila.id_fila, fila.nFicha from fila\n" +
"inner join marcarexame on fila.id_marcarExame =  marcarexame.id_marcarExame\n" +
"where marcarexame.id_marcarExame = ?" +
"";
             // 1º Organizar o Comando SQL
             
       
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setInt(1, idMarcar);

             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 FilaModelo ex = new FilaModelo();
                 ex.setIdFila(rs.getInt("id_fila"));
                 ex.setPrioridade(rs.getString("nFicha"));
                 
                 
                 
           
              
       

                 lista.add(ex);
        
             }
        
             
         }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
     
         
         
         
      public void atualizarProridadeFila(int idFila, String prioridade){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = " update fila set nFicha = ? where id_fila= ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, prioridade);
             stmt.setInt(2, idFila);
         
             // 1º Executar Comando SQL
             stmt.execute();
             
             // 1º Fechar Coneção
             stmt.close();
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro ao Edicat Consulta"+erro);
            throw new RuntimeException(erro);
            
        }
       
        }   
      
      
      public List<FilaModelo> listarExamesPorCategoriasdoDia( String data, String nomeExame, String nomeMedico){
     
     List<FilaModelo> lista = new ArrayList<FilaModelo>();
     
         try {
              String cmsqlb = "select marcarexame.id_marcarExame,\n" +
"marcar.dataFazer,\n" +
"exame.tipo_exame,\n" +
"paciente.nome_paciente,\n" +
"paciente.plano,\n" +
"fila.nFicha,\n" +
"fila.prioridade,\n" +
"medico.nomeMedico,\n" +
"marcarexame.situacaoFila\n" +
"from marcar\n" +
"\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on exame.id_exame = marcar.id_exame\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join fila on marcarexame.id_marcarExame = fila.id_marcarExame\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where marcar.dataFazer = ?\n" +
"and exame.tipo_exame = ?\n" +
"and medico.nomeMedico = ?\n" +
"\n" +
"\n" +
"union ALL\n" +
"\n" +
"\n" +
"select marcarexame.id_marcarExame,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"paciente.nome_paciente,\n" +
"paciente.plano,\n" +
"fila.nFicha,\n" +
"fila.prioridade,\n" +
"medico.nomeMedico,\n" +
"marcarexame.situacaoFila\n" +
"from marcar\n" +
"\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on consulta.id_consulta = marcar.id_consulta\n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join fila on marcarexame.id_marcarExame = fila.id_marcarExame\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"where marcar.dataFazer = ?\n" +
"and consulta.tipo_consulta = ?\n" +
"and medico.nomeMedico = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, data);
             stmt.setString(2, nomeExame);
             stmt.setString(3, nomeMedico);
               stmt.setString(4, data);
             stmt.setString(5, nomeExame);
             stmt.setString(6, nomeMedico);
       
            
              
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 FilaModelo ex = new FilaModelo();
                 ex.setIdMarcar(rs.getInt("id_marcarExame"));
                 ex.setNomePaciente(rs.getString("nome_paciente"));
                 ex.setNomeConsulta(rs.getString("tipo_exame"));
                 ex.setNumeroFicha(rs.getString("nFicha"));
                 ex.setPrioridade(rs.getString("prioridade"));
                 ex.setMedico(rs.getString("nomeMedico"));
                 ex.setSituacaoFila(rs.getString("situacaoFila"));
                 System.out.println(ex.getSituacaoFila());
              
        

                 lista.add(ex);
        
             }
        
             
         }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
         }
              return  lista;
     
     }  
         
        
        
}





