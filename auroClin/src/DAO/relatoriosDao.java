/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.buscarComprovanteImprimir;
import br.auroClin.model.joinBuscarConsultaMarcar;
import br.auroClin.model.relatorioExame;
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
public class relatoriosDao {
    
    private Connection conecta;
    
    public relatoriosDao(){
    this.conecta = new FabricaConecao().conecta();
    }
   
    
      
    
     
    
     
     
     public List<relatorioExame> listarRelatoriodeExames(String dataBanco){
     
     List<relatorioExame> lista = new ArrayList<relatorioExame>();
     
         try {
              String cmsqlb = "select\n" +
"paciente.nome_paciente,\n" +
"exame.tipo_exame,\n" +
"marcar.dataFazer,\n" +
"medico.nomeMedico,\n" +
"marcar.agendar,\n" +
"marcarexame.retorno\n" +
"from paciente\n" +
"inner join marcarexame on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on exame.id_exame = marcar.id_exame\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"where marcar.dataFazer = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, dataBanco);
             
             ResultSet rs = stmt.executeQuery();
             
            boolean existe = false;
        
             while (rs.next()) {
                 
                 existe = true;
                 relatorioExame ob = new relatorioExame();
                 ob.setNomePAciente(rs.getString("nome_paciente"));
                 System.out.println(ob.getNomePAciente());
                 ob.setDataFazer(rs.getString("dataFazer"));
                 ob.setNomeBusca(rs.getString("tipo_exame"));
                 ob.setNomeMedico(rs.getString("nomeMedico"));
                 ob.setHorarios(rs.getString("agendar"));
                 ob.setRetorno(rs.getString("retorno"));
       
                 lista.add(ob);
                 
           
                 
             }
             
             if (!existe) {
 JOptionPane.showMessageDialog(null,
 "Nenhum Exame Encontrado Para Esta Data.",
 "Homesoft Soluções Avisa!",
 JOptionPane.WARNING_MESSAGE);
             }
             
             
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
     
     
     
     
     
     
     
     public List<relatorioExame> listarRelatoriodeExamesPorMes(String dataBanco){
     
     List<relatorioExame> lista = new ArrayList<relatorioExame>();
     
         try {
              String cmsqlb = "select\n" +
"paciente.nome_paciente,\n" +
"exame.tipo_exame,\n" +
"marcar.dataFazer,\n" +
"medico.nomeMedico,\n" +
"marcar.agendar,\n" +
"marcarexame.retorno\n" +
"from paciente\n" +
"inner join marcarexame on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on exame.id_exame = marcar.id_exame\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"where marcar.dataFazer like ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
         
              stmt.setString(1, '%'+dataBanco);
          
                
             ResultSet rs = stmt.executeQuery();
             
             boolean existe = false;
     
     
             while (rs.next()) {
           existe = true;
                 relatorioExame ob = new relatorioExame();
                 ob.setNomePAciente(rs.getString("nome_paciente"));
      
                 ob.setDataFazer(rs.getString("dataFazer"));
                 ob.setNomeBusca(rs.getString("tipo_exame"));
                 ob.setNomeMedico(rs.getString("nomeMedico"));
                 ob.setHorarios(rs.getString("agendar"));
                 ob.setRetorno(rs.getString("retorno"));
                 lista.add(ob);
         
             }
             
             
   if (!existe) {
 JOptionPane.showMessageDialog(null,
 "Nenhum Exame Encontrado Para Este Mês.",
 "Homesoft Soluções Avisa!",
 JOptionPane.WARNING_MESSAGE);
}
             
             
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
         
              return  lista;
           
              
           
     
     }  
     
     
     
     
     
     
     
     public List<relatorioExame> listarRelatoriodeExamesPorPAciente(String nomePaciente){
     
     List<relatorioExame> lista = new ArrayList<relatorioExame>();
     
         try {
              String cmsqlb = "select\n" +
"paciente.nome_paciente,\n" +
"exame.tipo_exame,\n" +
"marcar.dataFazer,\n" +
"medico.nomeMedico,\n" +
"marcar.agendar,\n" +
"marcarexame.retorno\n" +
"from paciente\n" +
"inner join marcarexame on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on exame.id_exame = marcar.id_exame\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"where paciente.nome_paciente like ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
         
              stmt.setString(1, '%'+nomePaciente+'%');
             
               
             ResultSet rs = stmt.executeQuery();
             
      
                 
                 
             while (rs.next()) {
                 relatorioExame ob = new relatorioExame();
                 ob.setNomePAciente(rs.getString("nome_paciente"));
            
                 System.out.println(ob.getNomePAciente());
                 ob.setDataFazer(rs.getString("dataFazer"));
                 ob.setNomeBusca(rs.getString("tipo_exame"));
                 ob.setNomeMedico(rs.getString("nomeMedico"));
                 ob.setHorarios(rs.getString("agendar"));
                 ob.setRetorno(rs.getString("retorno"));
                 lista.add(ob);
                 
          
             
              
               
                 
             }
             
             
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta");
         }
              return  lista;
     
     }  
     
     
     
     //----------------------------- Consultas
     
     
      
     public List<relatorioExame> listarRelatoriodeConsultas(String dataBanco){
     
     List<relatorioExame> lista = new ArrayList<relatorioExame>();
 
         try {
              String cmsqlb = "select\n" +
"paciente.nome_paciente,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"medico.nomeMedico,\n" +
"marcar.agendar,\n" +
"marcarexame.retorno\n" +
"from paciente\n" +
"inner join marcarexame on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on consulta.id_consulta = marcar.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico          \n" +
"where dataFazer = ? ";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, dataBanco);
         
             ResultSet rs = stmt.executeQuery();
             
            boolean existe = false;
        
             while (rs.next()) {
                 
                 existe = true;
                 relatorioExame ob = new relatorioExame();
                 ob.setNomePAciente(rs.getString("nome_paciente"));
                 System.out.println(ob.getNomePAciente());
                 ob.setDataFazer(rs.getString("dataFazer"));
                 ob.setNomeBusca(rs.getString("tipo_consulta"));
                 ob.setNomeMedico(rs.getString("nomeMedico"));
                 ob.setHorarios(rs.getString("agendar"));
                 ob.setRetorno(rs.getString("retorno"));
       
                 lista.add(ob);
                 
           
                 
             }
             
             if (!existe) {
 JOptionPane.showMessageDialog(null,
 "Nenhuma Consulta Encontrada Para Esta Data.",
 "Homesoft Soluções Avisa!",
 JOptionPane.WARNING_MESSAGE);
             }
             
             
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
     
     
     
     
     
     
     
     public List<relatorioExame> listarRelatoriodeConsultasPorMes(String dataBanco){
     
     List<relatorioExame> lista = new ArrayList<relatorioExame>();
     
         try {
              String cmsqlb = "select\n" +
"paciente.nome_paciente,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"medico.nomeMedico,\n" +
"marcar.agendar,\n" +
"marcarexame.retorno\n" +
"from paciente\n" +
"inner join marcarexame on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on consulta.id_consulta = marcar.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"where dataFazer like ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
         
              stmt.setString(1, '%'+dataBanco);
          
                
             ResultSet rs = stmt.executeQuery();
             
             boolean existe = false;
                    
                    
                    
     
             while (rs.next()) {
           existe = true;
                 relatorioExame ob = new relatorioExame();
                 ob.setNomePAciente(rs.getString("nome_paciente"));
                 System.out.println(ob.getNomePAciente());
                 ob.setDataFazer(rs.getString("dataFazer"));
                 ob.setNomeBusca(rs.getString("tipo_consulta"));
                 ob.setNomeMedico(rs.getString("nomeMedico"));
                 ob.setHorarios(rs.getString("agendar"));
                 ob.setRetorno(rs.getString("retorno"));
                 lista.add(ob);
         
             }
             
             
   if (!existe) {
 JOptionPane.showMessageDialog(null,
 "Nenhuma Consulta Encontrada Para Este Mês.",
 "Homesoft Soluções Avisa!",
 JOptionPane.WARNING_MESSAGE);
}
             
             
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
         
              return  lista;
           
              
           
     
     }  
     
     
     
     
     
     public List<relatorioExame> listarRelatoriodeConsultaPorPAciente(String nomePaciente){
     
     List<relatorioExame> lista = new ArrayList<relatorioExame>();
     
         try {
              String cmsqlb = "select\n" +
"paciente.nome_paciente,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"medico.nomeMedico,\n" +
"marcar.agendar,\n" +
"marcarexame.retorno\n" +
"from paciente \n" +
"inner join marcarexame on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on consulta.id_consulta = marcar.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"where nome_paciente LIKE ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
         
              stmt.setString(1, '%'+nomePaciente+'%');
           
               
             ResultSet rs = stmt.executeQuery();
             
      
                 
                 
             while (rs.next()) {
                 relatorioExame ob = new relatorioExame();
                 ob.setNomePAciente(rs.getString("nome_paciente"));
                 System.out.println(ob.getNomePAciente());
                 ob.setDataFazer(rs.getString("dataFazer"));
                 ob.setNomeBusca(rs.getString("tipo_consulta"));
                 ob.setNomeMedico(rs.getString("nomeMedico"));
                 ob.setHorarios(rs.getString("agendar"));
                 ob.setRetorno(rs.getString("retorno"));
                 lista.add(ob);
                 
          
             
              
               
                 
             }
             
             
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
     
     
     
     
     
     
      public List<relatorioExame> listarConsultaPorMedico(String nomeMedico, String tipoConsulta,String data, String hora,String paciente){
     
     List<relatorioExame> lista = new ArrayList<relatorioExame>();
     
         try {
              String cmsqlb = "select\n" +
"paciente.nome_paciente,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"consulta.valor_consulta,\n" +
"medico.nomeMedico,\n" +
"marcar.agendar,\n" +
"marcarexame.retorno,\n" +
"planos.nomePlano,\n" +
"planos.desconto\n" +
"from paciente\n" +
"inner join marcarexame on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on consulta.id_consulta = marcar.id_consulta\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join planos on planos.id_plano = paciente.id_plano\n" +
"where medico.nomeMedico LIKE ? AND\n" +
"consulta.tipo_consulta LIKE ?\n" +
"AND dataFazer LIKE ?\n" +
"AND marcarexame.retorno LIKE ?\n" +
"AND paciente.nome_paciente LIKE ?";
             // 1º Organizar o Comando SQL
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
                     stmt.setString(1, '%'+nomeMedico+'%');
              stmt.setString(2, '%'+tipoConsulta+'%');
              stmt.setString(3, '%'+data+'%');
              stmt.setString(4, '%'+hora+'%');
              stmt.setString(5, '%'+paciente+'%');
       
    
            
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
   
               relatorioExame ob = new relatorioExame();
                  ob.setNomePAciente(rs.getString("nome_paciente"));
                 ob.setDataFazer(rs.getString("dataFazer"));
                 ob.setNomeBusca(rs.getString("tipo_consulta"));
                 ob.setNomeMedico(rs.getString("nomeMedico"));
                 ob.setHorarios(rs.getString("agendar"));
                 ob.setRetorno(rs.getString("retorno"));
                 ob.setValorExame(rs.getFloat("valor_consulta"));
                 ob.setPlano(rs.getString("nomePlano"));
                 ob.setDesc(rs.getString("desconto"));
                 
                 lista.add(ob);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao buscar Join"+e);
         }
              return  lista;
     
     }  
    
     
     
      
        public List<relatorioExame> listarExamesPorMedico(String nomeMedico, String tipoExame,String data, String hora,String nomeCliente){
     
            System.out.println(nomeMedico);
            
     List<relatorioExame> lista = new ArrayList<relatorioExame>();
     
         try {
              String cmsqlb = "select\n" +
"paciente.nome_paciente,\n" +
"marcar.dataFazer,\n" +
"exame.tipo_exame,\n" +
"exame.valor_exame,\n" +
"medico.nomeMedico,\n" +
"marcar.agendar,\n" +
"marcarexame.retorno,\n" +
"planos.nomePlano,\n" +
"planos.desconto\n" +
"from paciente\n" +
"inner join marcarexame on marcarexame.id_paciente = paciente.id_paciente\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on exame.id_exame = marcar.id_exame\n" +
"inner join medico on medico.id_medico = marcar.id_medico\n" +
"inner join planos on planos.id_plano = paciente.id_plano\n" +
"where medico.nomeMedico LIKE ? AND\n" +
"exame.tipo_exame LIKE ?\n" +
"AND dataFazer LIKE ?\n" +
"AND marcarexame.retorno LIKE ?"+
"AND paciente.nome_paciente LIKE ?";
              
             // 1º Organizar o Comando SQL
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, '%'+nomeMedico+'%');
              stmt.setString(2, '%'+tipoExame+'%');
              stmt.setString(3, '%'+data+'%');
              stmt.setString(4, '%'+hora+'%');
              stmt.setString(5, '%'+nomeCliente+'%');
            
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
   
               relatorioExame ob = new relatorioExame();
                 ob.setNomePAciente(rs.getString("nome_paciente"));
                 ob.setDataFazer(rs.getString("dataFazer"));
                 ob.setNomeBusca(rs.getString("tipo_exame"));
                 ob.setNomeMedico(rs.getString("nomeMedico"));
                 ob.setHorarios(rs.getString("agendar"));
                 ob.setRetorno(rs.getString("retorno"));
                 ob.setValorExame(rs.getFloat("valor_exame"));
                 ob.setPlano(rs.getString("nomePlano"));
                 ob.setDesc(rs.getString("desconto"));
                 System.out.println(ob.getNomePAciente());
                 lista.add(ob);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, " Esse -> Erro ao buscar Join"+e);
         }
              return  lista;
     
     }  
    
   
        
        
        
          public List<buscarComprovanteImprimir> imprimirComprovanteSegundaVia(String nomePAciente, String nomeExame, String data){
     
     List<buscarComprovanteImprimir> lista = new ArrayList<buscarComprovanteImprimir>();
     
         try {
              String cmsqlb = "select\n" +
"paciente.nome_paciente,\n" +
"planos.nomePlano,\n" +
"planos.desconto,\n" +
"marcar.dataFazer,\n" +
"exame.tipo_exame,\n" +
"exame.valor_exame,\n" +
"medico.nomeMedico,\n" +
"marcarexame.retorno,\n" +
"marcar.agendar,\n" +
"paciente.cpf\n" +                     
"from medico \n" +
"inner join marcar on medico.id_medico = marcar.id_medico \n" +
"inner join exame on exame.id_exame = marcar.id_exame\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join paciente on paciente.id_paciente = marcarexame.id_paciente\n" +
"inner join planos on planos.id_plano = paciente.id_plano\n" +
"where paciente.nome_paciente like ? and exame.tipo_exame like ? and marcar.dataFazer like ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, nomePAciente);
              stmt.setString(2, nomeExame);
              stmt.setString(3, data);
             
             ResultSet rs = stmt.executeQuery();
             
            boolean existe = false;
        
             while (rs.next()) {
                 
                 existe = true;
                 buscarComprovanteImprimir ob = new buscarComprovanteImprimir();
                 ob.setPaciente(rs.getString("nome_paciente"));
                 ob.setData(rs.getString("dataFazer"));
                 ob.setNomeExame(rs.getString("tipo_exame"));
                 ob.setMedico(rs.getString("nomeMedico"));
                 ob.setForma(rs.getString("agendar"));
                 ob.setRetorno(rs.getString("retorno"));
                 ob.setPlano(rs.getString("nomePlano"));
                 ob.setPorcentagem(rs.getString("desconto"));
                 ob.setCpf(rs.getString("cpf"));
                 ob.setValor(rs.getFloat("valor_exame"));
       
                 lista.add(ob);
                 
           
                 
             }
             
             if (!existe) {
 JOptionPane.showMessageDialog(null,
 "Nenhum Exame Encontrado Para Esta Data.",
 "Homesoft Soluções Avisa!",
 JOptionPane.WARNING_MESSAGE);
             }
             
             
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
     
        
        
      
  
          public List<buscarComprovanteImprimir> imprimirComprovanteSegundaViaConsulta(String nomePAciente, String nomeExame, String data){
     
     List<buscarComprovanteImprimir> lista = new ArrayList<buscarComprovanteImprimir>();
     
         try {
              String cmsqlb = "select\n" +
"paciente.nome_paciente,\n" +
"planos.nomePlano,\n" +
"planos.desconto,\n" +
"marcar.dataFazer,\n" +
"consulta.tipo_consulta,\n" +
"consulta.valor_consulta,\n" +
"medico.nomeMedico,\n" +
"marcarexame.retorno,\n" +
"marcar.agendar,\n" +
"paciente.cpf                  \n" +
"from medico\n" +
"inner join marcar on medico.id_medico = marcar.id_medico\n" +
"inner join consulta on consulta.id_consulta = marcar.id_consulta\n" +
"inner join marcarexame on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join paciente on paciente.id_paciente = marcarexame.id_paciente\n" +
"inner join planos on planos.id_plano = paciente.id_plano\n" +
"where paciente.nome_paciente like ? and consulta.tipo_consulta like ? and marcar.dataFazer like ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, nomePAciente);
              stmt.setString(2, nomeExame);
              stmt.setString(3, data);
             
             ResultSet rs = stmt.executeQuery();
             
            boolean existe = false;
        
             while (rs.next()) {
                 
                 existe = true;
                 buscarComprovanteImprimir ob = new buscarComprovanteImprimir();
                 ob.setPaciente(rs.getString("nome_paciente"));
                 ob.setData(rs.getString("dataFazer"));
                 ob.setNomeExame(rs.getString("tipo_consulta"));
                 ob.setMedico(rs.getString("nomeMedico"));
                 ob.setForma(rs.getString("agendar"));
                 ob.setRetorno(rs.getString("retorno"));
                 ob.setPlano(rs.getString("nomePlano"));
                 ob.setPorcentagem(rs.getString("desconto"));
                 ob.setCpf(rs.getString("cpf"));
                 ob.setValor(rs.getFloat("valor_consulta"));
       
                 lista.add(ob);
                 
           
                 
             }
             
             if (!existe) {
 JOptionPane.showMessageDialog(null,
 "Nenhum Exame Encontrado Para Esta Data.",
 "Homesoft Soluções Avisa!",
 JOptionPane.WARNING_MESSAGE);
             }
             
             
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
     
        
          
          
          
     
}
