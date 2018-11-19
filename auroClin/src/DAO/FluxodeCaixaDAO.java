/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.AbrirCaixaModel;
import br.auroClin.model.Exame;
import br.auroClin.model.FluxoDeCaixaModelo;
import br.auroClin.model.formaPagamentoBuscar;
import br.auroClin.model.ValorCaixaModel;
import br.auroClin.model.finalizarMarcar;
import br.auroClin.model.planoMODELO;
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
public class FluxodeCaixaDAO {
    
       private Connection conecta;
    
    public FluxodeCaixaDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    public List<FluxoDeCaixaModelo> listarCaixa( String data){
     
        String SituacaoFila = "FINALIZADO";
        
     List<FluxoDeCaixaModelo> lista = new ArrayList<FluxoDeCaixaModelo>();
     
         try {
              String cmsqlb = "select \n" +
"\n" +
"marcarexame.id_marcarExame,\n" +
"abrircaixa.data_abrir, \n" +
"marcar.dataFazer, \n" +
"marcarexame.formaPagamento, \n" +
"consulta.tipo_consulta, \n" +
"consulta.valor_consulta, \n" +
"paciente.nome_paciente,\n" +
"paciente.plano,\n" +
"situacao" +
"\n" +
"from abrircaixa \n" +
"inner join marcarexame on abrircaixa.id_statos = marcarexame.id_caixa \n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar \n" +
"inner join consulta on consulta.id_consulta = marcar.id_consulta \n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente \n" +
"\n" +
"where data_abrir = ? and marcarexame.situacaoFila = ?" +
"\n" +
"UNION ALL \n" +
"\n" +
"select marcarexame.id_marcarExame,\n" +
"abrircaixa.data_abrir, \n" +
"marcar.dataFazer, \n" +
"marcarexame.formaPagamento,  \n" +
"exame.tipo_exame, \n" +
"exame.valor_exame, \n" +
"paciente.nome_paciente,\n" +
"paciente.plano,\n" +
"situacao" +
"\n" +
"from abrircaixa \n" +
"inner join marcarexame on abrircaixa.id_statos = marcarexame.id_caixa \n" +
"inner join marcar on marcar.id_marcar = marcarexame.id_marcar \n" +
"inner join exame on exame.id_exame = marcar.id_exame \n" +
"inner join paciente on marcarexame.id_paciente = paciente.id_paciente\n" +
"\n" +
"where data_abrir = ? and marcarexame.situacaoFila = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, data);
             stmt.setString(2, SituacaoFila);
             stmt.setString(3, data);
             stmt.setString(4, SituacaoFila);
              float soma = 0; 
              double desconto = 0; 
              double valorCobrar = 0;
              double registrosDescontos = 0;
              double valorTotal = 0;
              
            
              
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 FluxoDeCaixaModelo ex = new FluxoDeCaixaModelo();
                 ex.setId_venda(rs.getInt("id_marcarExame"));
                 ex.setDataVenda(rs.getString("data_abrir"));
                 ex.setNomePaciente(rs.getString("nome_paciente"));
                 ex.setServico(rs.getString("tipo_consulta"));
                 ex.setFormaPagamento(rs.getString("formaPagamento"));
                 ex.setValorVenda(rs.getFloat("valor_consulta"));
                 //System.out.println("Valor"+ex.getValorVenda());
               
                 ex.setDataRelizarServico(rs.getString("dataFazer"));
                 ex.setPlano(rs.getString("plano"));
                  ex.setSituacao(rs.getString("situacao"));
                                      

                 lista.add(ex);
                   
                 
                 /*
                   
                     double valorVindo = rs.getFloat("valor_consulta");
                     desconto = valorVindo * 0.3;
                     valorCobrar = valorVindo - desconto;
 
                     valorTotal = valorTotal + valorVindo;
                     ex.setValorTotal(valorTotal);

                   
                   if (rs.getString("plano").equals("SIM")) {
                       
                        ex.setPreco(valorCobrar);
                  
                    
                        registrosDescontos = registrosDescontos + desconto;
                        ex.setDesconto(registrosDescontos);
                          ex.setDescontoIndividual(desconto);
                     
                 } else {
                   
                        ex.setPreco(valorVindo);
                        ex.setDesconto(registrosDescontos);
         
                   
                   }
                  */
             
                 
             }
        
             
         }catch (Exception e) {
         }
              return  lista;
     
     }  
    
    
    
    
    public List<ValorCaixaModel> valorCaixa( String data){
     
     List<ValorCaixaModel> lista = new ArrayList<ValorCaixaModel>();
     
         try {
              String cmsqlb = "select abrirCaixa.ValorCaixa,abrirCaixa.valorCartao from abrirCaixa where data_abrir = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setString(1, data);
     
             
            
              
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 ValorCaixaModel ex = new ValorCaixaModel();
                 ex.setValorCaixa(rs.getFloat("ValorCaixa"));
                 ex.setValorCartao(rs.getFloat("valorCartao"));
              
                 lista.add(ex);
                   
             }
        
             
         }catch (Exception e) {
         }
              return  lista;
     
     }  
    
    
    
    
    
    
     public List<FluxoDeCaixaModelo> validarPagamento(int idVenda, String situacao){
     
     List<FluxoDeCaixaModelo> lista = new ArrayList<FluxoDeCaixaModelo>();
     
         try {
              String cmsqlb = "select marcarexame.situacao from marcarexame where id_marcarExame = ? and marcarexame.situacao = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
              stmt.setInt(1, idVenda);
              stmt.setString(2, situacao);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 FluxoDeCaixaModelo ex = new FluxoDeCaixaModelo();
                 ex.setSituacao(rs.getString("situacao"));
                 
                 
                 
                 lista.add(ex);
                 
                 
             }
        
             
         }catch (Exception e) {
         }
              return  lista;
     
     }  
    
    
    
     
     
     
     
     
     
     public List<AbrirCaixaModel> buscarCaixaParaPagamento(String datadeAbrir){
        List<AbrirCaixaModel> lista = new ArrayList<AbrirCaixaModel>();
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "SELECT id_statos,data_abrir,ValorCaixa,valorCartao FROM abrircaixa WHERE data_abrir =?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, datadeAbrir);
         
             
              ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 AbrirCaixaModel ex = new AbrirCaixaModel();
                 ex.setValorCaixa(rs.getDouble("ValorCaixa"));
                 ex.setId_AbrirCAixa(rs.getInt("id_statos"));
                 ex.setValorCartao(rs.getDouble("valorCartao"));
                
                 
                 
                 
                 lista.add(ex);
                 
                 
             }
             
             
             
         } catch (Exception e) {
             
             
         }
     
         
         return  lista;
     }
     
     
     
     
     
     
     
     
      
     public List<formaPagamentoBuscar> buscarFormaPagamentoCancelar(int idVendaPCancelar){
        List<formaPagamentoBuscar> lista = new ArrayList<formaPagamentoBuscar>();
        
         System.out.println(idVendaPCancelar);
         try {
             
               // 1º passo Criar Comando SQL
            String cmsql = "SELECT formaPagamento FROM venda WHERE venda.id_marcarExame = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setInt(1, idVendaPCancelar);
       
         
             
              ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 formaPagamentoBuscar ex = new formaPagamentoBuscar();
                 ex.setFormaPagamento(rs.getString("formaPagamento"));
                
                
               
                 
                 
                 lista.add(ex);
                 
                 
             }
             
             
             
         } catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, e);
             
             
         }
              return  lista;
     
     
}
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
       public void pagamentoFaturas(double valorVenda, int idCaixa){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "update abrircaixa set ValorCaixa = ? where id_statos = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setDouble(1, valorVenda);
             stmt.setFloat(2, idCaixa);
         
         
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
  
       
       
      
       
       
       
       
       
       
       public void validarMarcarComoPAGO(String situacao,String formaPagameto, int idMarcar){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "update marcarexame set situacao = ?,formaPagamento = ?  where id_marcarExame = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, situacao);
             stmt.setString(2, formaPagameto );
             stmt.setInt(3, idMarcar);
         
         
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
       
       
       
       
       
         public void pagamentoCartao(double valorVenda, int idCaixa){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "update abrircaixa set valorCartao = ? where id_statos = ?";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setDouble(1, valorVenda);
             stmt.setFloat(2, idCaixa);
         
         
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
  
       
       
         
         
         
      public List<planoMODELO> BuscarPlanosValidar(){
     
     List<planoMODELO> lista = new ArrayList<planoMODELO>();
     
         try {
              String cmsqlb = "SELECT * FROM planos";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 planoMODELO objc = new planoMODELO();
                 objc.setNomePlano(rs.getString("nomePlano"));
                 objc.setDesconto(rs.getFloat("desconto"));
                 lista.add(objc);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "erro"+e);
         }
              return  lista;
     
     }  
     
     
     
       
       
}
