/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.AbrirCaixaModel;
import br.auroClin.model.Caixa;
import br.auroClin.model.Convenio;
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
public class ParcelasDAO {
    
    
        private Connection conecta;
    
    public ParcelasDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    //------------------------------------------------------  cadastrar paciente 
    public void cadastrarConvenio(Convenio objcon){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
                  String cmsql = "insert into convenio(numeroParcela,valorParcela,dataPagamento,id_caixa,id_paciente)values(?,?,?,?,?);";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setInt(1, objcon.getNumeroParcelas());
             stmt.setFloat(2, objcon.getValorParcela());
             stmt.setString(3, objcon.getDataPagamentoParcela());
             stmt.setInt(4, objcon.getId_caixa());
             stmt.setInt(5, objcon.getId_paciente());
       
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
    
    
    
    
     public void cadastrarCaixaConvenio(Caixa objcai){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
                  String cmsql = "insert into caixa(valorVenda,horaVenda,StatusVenda,id_statos)values(?,?,?,?);";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setFloat(1, objcai.getValorVenda());
             stmt.setString(2, objcai.getHoraVenda());
             stmt.setString(3, objcai.getStatosVenda());
             stmt.setInt(4, objcai.getId_caixa());
       
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
    
    
     //listar Exames
     
     public List<Caixa> listarIdCaixa(){
     
     List<Caixa> lista = new ArrayList<Caixa>();
     
         try {
              String cmsqlb = "SELECT MAX(id_caixa) as id_caixa FROM caixa";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Caixa obc = new Caixa();
                 obc.setId_caixa(rs.getInt("id_caixa"));
                 lista.add(obc);
  
             }
        
             
         }catch (Exception e) {
             
              JOptionPane.showMessageDialog(null, "id"+e);
         }
              return  lista;
     
     }  
    
    
     
       public List<AbrirCaixaModel> listarIdAbrirCaixa(){
     
     List<AbrirCaixaModel> lista = new ArrayList<AbrirCaixaModel>();
     
         try {
              String cmsqlb = "SELECT MAX(id_statos) as id_statos FROM abrircaixa";
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 AbrirCaixaModel objAbrir = new AbrirCaixaModel();
                 objAbrir.setId_AbrirCAixa(rs.getInt("id_statos"));
                 lista.add(objAbrir);
  
             }
        
             
         }catch (Exception e) {
             
              JOptionPane.showMessageDialog(null, "id"+e);
         }
              return  lista;
     
     }  
    
     
     
    
    
}
