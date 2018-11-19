/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.Consulta;
import br.auroClin.model.Exame;
import br.auroClin.model.RelatorioFluxoCaixaModelo;
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
public class RelatorioFluxoCaixaDAO {
    
    
     
      private Connection conecta;
    
    public RelatorioFluxoCaixaDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
     public List<RelatorioFluxoCaixaModelo> relatoriosDoDia(String dataAtual){
     
     List<RelatorioFluxoCaixaModelo> lista = new ArrayList<RelatorioFluxoCaixaModelo>();
      System.out.println(dataAtual);  
     String ativo = "ATIVO";
         try {
              String cmsqlb = "select\n" +
"abrircaixa.data_abrir,\n" +
"venda.horaVenda,exame.tipo_exame,\n" +
"venda.valorVenda,\n" +
"venda.cancelar,\n" +
"venda.formaPagamento,\n" +
"funcionario.nomeFuncionario\n" +
"from venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame\n" +
"inner join abrircaixa on marcarexame.id_caixa =abrircaixa.id_statos\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on marcar.id_exame = exame.id_exame\n" +
"inner join funcionario on venda.id_funcionario = funcionario.id_funcionario\n" +
"where venda.Cancelar = ? AND abrircaixa.data_abrir = ?\n" +
"\n" +
"union all \n" +
"select\n" +
"abrircaixa.data_abrir,\n" +
"venda.horaVenda,\n" +
"consulta.tipo_consulta,\n" +
"venda.valorVenda,\n" +
"venda.cancelar,\n" +
"venda.formaPagamento,\n" +
"funcionario.nomeFuncionario\n" +
"from venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame\n" +
"inner join abrircaixa on marcarexame.id_caixa =abrircaixa.id_statos\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on marcar.id_consulta = consulta.id_consulta\n" +
"inner join funcionario on venda.id_funcionario = funcionario.id_funcionario\n" +
"where venda.Cancelar = ? AND abrircaixa.data_abrir = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, ativo);
             stmt.setString(2, dataAtual);
             stmt.setString(3, ativo);
             stmt.setString(4, dataAtual);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                RelatorioFluxoCaixaModelo objc = new RelatorioFluxoCaixaModelo();
                 objc.setServico(rs.getString("tipo_exame"));
                 objc.setValor(rs.getFloat("valorVenda"));
                 objc.setPagamento(rs.getString("formaPagamento"));
                 objc.setVendedor(rs.getString("nomeFuncionario"));
                 objc.setDataVenda(rs.getString("data_abrir"));
                 objc.setHoraVenda(rs.getString("horaVenda"));
                 objc.setCancelar(rs.getString("cancelar"));
                 System.out.println(objc.getServico());  
                 lista.add(objc);
                 
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
    
    
      
    public List<Exame> listarExamesConsultasPorNome(String nome){
     
     List<Exame> lista = new ArrayList<Exame>();
     
         try {
              String cmsqlb = "SELECT exame.lucro FROM exame WHERE exame.tipo_exame LIKE ?\n" +
"UNION all \n" +
"SELECT consulta.lucro FROM consulta WHERE consulta.tipo_consulta LIKE ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setString(1, nome);
              stmt.setString(2, nome);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Exame ex = new Exame();
            
                 ex.setLucro(rs.getFloat("lucro"));
                 lista.add(ex);
                 
                 
             }
        
             
         }catch (Exception e) {
         }
              return  lista;
     
     }  
      
   

    
    
     public List<RelatorioFluxoCaixaModelo> relatoriosCaixaPorData(String tipo, String dataAtual){
     
     List<RelatorioFluxoCaixaModelo> lista = new ArrayList<RelatorioFluxoCaixaModelo>();
      System.out.println(dataAtual);  
    
         try {
              String cmsqlb = "select\n" +
"abrircaixa.data_abrir,\n" +
"venda.horaVenda,exame.tipo_exame,\n" +
"venda.valorVenda,\n" +
"venda.cancelar,\n" +
"venda.formaPagamento,\n" +
"funcionario.nomeFuncionario\n" +
"from venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame\n" +
"inner join abrircaixa on marcarexame.id_caixa =abrircaixa.id_statos\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on marcar.id_exame = exame.id_exame\n" +
"inner join funcionario on venda.id_funcionario = funcionario.id_funcionario\n" +
"where venda.Cancelar = ? AND abrircaixa.data_abrir = ?\n" +
"\n" +
"union all \n" +
"select\n" +
"abrircaixa.data_abrir,\n" +
"venda.horaVenda,\n" +
"consulta.tipo_consulta,\n" +
"venda.valorVenda,\n" +
"venda.cancelar,\n" +
"venda.formaPagamento,\n" +
"funcionario.nomeFuncionario\n" +
"from venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame\n" +
"inner join abrircaixa on marcarexame.id_caixa =abrircaixa.id_statos\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on marcar.id_consulta = consulta.id_consulta\n" +
"inner join funcionario on venda.id_funcionario = funcionario.id_funcionario\n" +
"where venda.Cancelar = ? AND abrircaixa.data_abrir = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, tipo);
             stmt.setString(2, dataAtual);
             stmt.setString(3, tipo);
             stmt.setString(4, dataAtual);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                RelatorioFluxoCaixaModelo objc = new RelatorioFluxoCaixaModelo();
                 objc.setServico(rs.getString("tipo_exame"));
                 objc.setValor(rs.getFloat("valorVenda"));
                 objc.setPagamento(rs.getString("formaPagamento"));
                 objc.setVendedor(rs.getString("nomeFuncionario"));
                 objc.setDataVenda(rs.getString("data_abrir"));
                 objc.setHoraVenda(rs.getString("horaVenda"));
                 objc.setCancelar(rs.getString("cancelar"));
                 System.out.println(objc.getServico());  
                 lista.add(objc);
                 
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
    

     
     
     
     public List<RelatorioFluxoCaixaModelo> relatoriosCartao(String tipo, String dataAtual,String formaPaga){
     
     List<RelatorioFluxoCaixaModelo> lista = new ArrayList<RelatorioFluxoCaixaModelo>();
      System.out.println(dataAtual);  
    
         try {
              String cmsqlb = "select\n" +
"abrircaixa.data_abrir,\n" +
"venda.horaVenda,exame.tipo_exame,\n" +
"venda.valorVenda,\n" +
"venda.cancelar,\n" +
"venda.formaPagamento,\n" +
"funcionario.nomeFuncionario\n" +
"from venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame\n" +
"inner join abrircaixa on marcarexame.id_caixa =abrircaixa.id_statos\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on marcar.id_exame = exame.id_exame\n" +
"inner join funcionario on venda.id_funcionario = funcionario.id_funcionario\n" +
"where venda.Cancelar = ? AND abrircaixa.data_abrir like ? and venda.formaPagamento != ?\n" +
"\n" +
"union all \n" +
"select\n" +
"abrircaixa.data_abrir,\n" +
"venda.horaVenda,\n" +
"consulta.tipo_consulta,\n" +
"venda.valorVenda,\n" +
"venda.cancelar,\n" +
"venda.formaPagamento,\n" +
"funcionario.nomeFuncionario\n" +
"from venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame\n" +
"inner join abrircaixa on marcarexame.id_caixa =abrircaixa.id_statos\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on marcar.id_consulta = consulta.id_consulta\n" +
"inner join funcionario on venda.id_funcionario = funcionario.id_funcionario\n" +
"where venda.Cancelar = ? AND abrircaixa.data_abrir like ? and venda.formaPagamento != ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, tipo);
             stmt.setString(2, '%'+dataAtual+'%');
             stmt.setString(3, formaPaga);
             stmt.setString(4, tipo);
             stmt.setString(5, '%'+dataAtual+'%');
             stmt.setString(6, formaPaga);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                RelatorioFluxoCaixaModelo objc = new RelatorioFluxoCaixaModelo();
                 objc.setServico(rs.getString("tipo_exame"));
                 objc.setValor(rs.getFloat("valorVenda"));
                 objc.setPagamento(rs.getString("formaPagamento"));
                 objc.setVendedor(rs.getString("nomeFuncionario"));
                 objc.setDataVenda(rs.getString("data_abrir"));
                 objc.setHoraVenda(rs.getString("horaVenda"));
                 objc.setCancelar(rs.getString("cancelar"));
                 System.out.println(objc.getServico());  
                 lista.add(objc);
                 
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
    

     
     
     
     
       
     
     public List<RelatorioFluxoCaixaModelo> relatoriosDinheiro(String tipo, String dataAtual,String formaPaga){
     
     List<RelatorioFluxoCaixaModelo> lista = new ArrayList<RelatorioFluxoCaixaModelo>();
      System.out.println(dataAtual);  
    
         try {
              String cmsqlb = "select\n" +
"abrircaixa.data_abrir,\n" +
"venda.horaVenda,exame.tipo_exame,\n" +
"venda.valorVenda,\n" +
"venda.cancelar,\n" +
"venda.formaPagamento,\n" +
"funcionario.nomeFuncionario\n" +
"from venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame\n" +
"inner join abrircaixa on marcarexame.id_caixa =abrircaixa.id_statos\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on marcar.id_exame = exame.id_exame\n" +
"inner join funcionario on venda.id_funcionario = funcionario.id_funcionario\n" +
"where venda.Cancelar = ? AND abrircaixa.data_abrir like ? and venda.formaPagamento = ?\n" +
"\n" +
"union all \n" +
"select\n" +
"abrircaixa.data_abrir,\n" +
"venda.horaVenda,\n" +
"consulta.tipo_consulta,\n" +
"venda.valorVenda,\n" +
"venda.cancelar,\n" +
"venda.formaPagamento,\n" +
"funcionario.nomeFuncionario\n" +
"from venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame\n" +
"inner join abrircaixa on marcarexame.id_caixa =abrircaixa.id_statos\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on marcar.id_consulta = consulta.id_consulta\n" +
"inner join funcionario on venda.id_funcionario = funcionario.id_funcionario\n" +
"where venda.Cancelar = ? AND abrircaixa.data_abrir like ? and venda.formaPagamento = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, tipo);
             stmt.setString(2, '%'+dataAtual+'%');
             stmt.setString(3, formaPaga);
             stmt.setString(4, tipo);
             stmt.setString(5, '%'+dataAtual+'%');
             stmt.setString(6, formaPaga);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                RelatorioFluxoCaixaModelo objc = new RelatorioFluxoCaixaModelo();
                 objc.setServico(rs.getString("tipo_exame"));
                 objc.setValor(rs.getFloat("valorVenda"));
                 objc.setPagamento(rs.getString("formaPagamento"));
                 objc.setVendedor(rs.getString("nomeFuncionario"));
                 objc.setDataVenda(rs.getString("data_abrir"));
                 objc.setHoraVenda(rs.getString("horaVenda"));
                 objc.setCancelar(rs.getString("cancelar"));
                 System.out.println(objc.getServico());  
                 lista.add(objc);
                 
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
    

     
     

     
     
     
     
     
     public List<RelatorioFluxoCaixaModelo> relatoriosCaixaPorMrdicoLucro(String tipo, String dataAtual,String medico){
     
     List<RelatorioFluxoCaixaModelo> lista = new ArrayList<RelatorioFluxoCaixaModelo>();
 
    
         try {
              String cmsqlb = "select\n" +
"abrircaixa.data_abrir,\n" +
"venda.horaVenda,exame.tipo_exame,exame.valor_exame,\n" +
"venda.valorVenda,\n" +
"venda.cancelar,\n" +
"venda.formaPagamento,\n" +
"funcionario.nomeFuncionario,\n" +
"medico.nomeMedico,\n" +
"paciente.nome_paciente\n" +
"from venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame\n" +
"inner join abrircaixa on marcarexame.id_caixa =abrircaixa.id_statos\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on marcar.id_exame = exame.id_exame\n" +
"inner join funcionario on venda.id_funcionario = funcionario.id_funcionario\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"inner join paciente on paciente.id_paciente = marcarexame.id_paciente\n" +
"where venda.Cancelar = ? AND abrircaixa.data_abrir like ? and medico.nomeMedico like ?\n" +
"\n" +
"union all\n" +
"select\n" +
"abrircaixa.data_abrir,\n" +
"venda.horaVenda,\n" +
"consulta.tipo_consulta,consulta.valor_consulta,\n" +
"venda.valorVenda,\n" +
"venda.cancelar,\n" +
"venda.formaPagamento,\n" +
"funcionario.nomeFuncionario,\n" +
"medico.nomeMedico,\n" +
"paciente.nome_paciente\n" +
"from venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame\n" +
"inner join abrircaixa on marcarexame.id_caixa =abrircaixa.id_statos\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on marcar.id_consulta = consulta.id_consulta\n" +
"inner join funcionario on venda.id_funcionario = funcionario.id_funcionario\n" +
"inner join medico on marcar.id_medico = medico.id_medico\n" +
"inner join paciente on paciente.id_paciente = marcarexame.id_paciente\n" +
"where venda.Cancelar = ? AND abrircaixa.data_abrir like ? and medico.nomeMedico like ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, tipo);
             stmt.setString(2, '%'+dataAtual+'%');
             stmt.setString(3, '%'+medico+'%');
             stmt.setString(4, tipo);
             stmt.setString(5, '%'+dataAtual+'%');
             stmt.setString(6, '%'+medico+'%');
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                RelatorioFluxoCaixaModelo objc = new RelatorioFluxoCaixaModelo();
                 objc.setServico(rs.getString("tipo_exame"));
                 objc.setValor(rs.getFloat("valorVenda"));
                 objc.setPagamento(rs.getString("formaPagamento"));
                 objc.setVendedor(rs.getString("nomeMedico"));
                 objc.setDataVenda(rs.getString("data_abrir"));
                 objc.setHoraVenda(rs.getString("horaVenda"));
                 objc.setCancelar(rs.getString("cancelar"));
                 objc.setValorTotal(rs.getFloat("valor_exame"));
                 objc.setNomePaciente(rs.getString("nome_paciente"));
               
                 lista.add(objc);
                 
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
    

     
     
     
     
     

     public List<RelatorioFluxoCaixaModelo> relatoriosCaixaPorMes(String tipo, String mesBuscar){
     
     List<RelatorioFluxoCaixaModelo> lista = new ArrayList<RelatorioFluxoCaixaModelo>();
      System.out.println(mesBuscar);  
    
         try {
              String cmsqlb = "SELECT * FROM \n" +
" (\n" +
"select\n" +
"abrircaixa.data_abrir,\n" +
"venda.horaVenda,exame.tipo_exame,\n" +
"venda.valorVenda,\n" +
"venda.cancelar,\n" +
"venda.formaPagamento,\n" +
"funcionario.nomeFuncionario\n" +
"from venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame\n" +
"inner join abrircaixa on marcarexame.id_caixa =abrircaixa.id_statos\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join exame on marcar.id_exame = exame.id_exame\n" +
"inner join funcionario on venda.id_funcionario = funcionario.id_funcionario\n" +
"where venda.Cancelar = ? AND abrircaixa.data_abrir LIKE ? order by  abrircaixa.data_abrir) AS pass1\n" +
"UNION ALL \n" +
"SELECT * FROM \n" +
"  (select\n" +
"abrircaixa.data_abrir,\n" +
"venda.horaVenda,\n" +
"consulta.tipo_consulta,\n" +
"venda.valorVenda,\n" +
"venda.cancelar,\n" +
"venda.formaPagamento,\n" +
"funcionario.nomeFuncionario\n" +
"from venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame\n" +
"inner join abrircaixa on marcarexame.id_caixa =abrircaixa.id_statos\n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar\n" +
"inner join consulta on marcar.id_consulta = consulta.id_consulta\n" +
"inner join funcionario on venda.id_funcionario = funcionario.id_funcionario\n" +
"where venda.Cancelar = ? AND abrircaixa.data_abrir LIKE ? order by  abrircaixa.data_abrir) AS pass2\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, tipo);
             stmt.setString(2, '%'+mesBuscar);
             stmt.setString(3, tipo);
             stmt.setString(4, '%'+mesBuscar);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                RelatorioFluxoCaixaModelo objc = new RelatorioFluxoCaixaModelo();
                 objc.setServico(rs.getString("tipo_exame"));
                 objc.setValor(rs.getFloat("valorVenda"));
                 objc.setPagamento(rs.getString("formaPagamento"));
                 objc.setVendedor(rs.getString("nomeFuncionario"));
                 objc.setDataVenda(rs.getString("data_abrir"));
                 objc.setHoraVenda(rs.getString("horaVenda"));
                 objc.setCancelar(rs.getString("cancelar"));
                 System.out.println(objc.getServico());  
                 lista.add(objc);
                 
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta"+e);
         }
              return  lista;
     
     }  
    
    
    
}
