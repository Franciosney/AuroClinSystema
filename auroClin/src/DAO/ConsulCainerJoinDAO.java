/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.BuscarCarneModel;
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
public class ConsulCainerJoinDAO {
    
       private Connection conecta;
    
    public ConsulCainerJoinDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
    
    
       
    
    public List<BuscarCarneModel> listarBusca(int idPaciente){
     
     List<BuscarCarneModel> lista = new ArrayList<BuscarCarneModel>();
     
         try {
              String cmsqlb = "select convenio.id_convenio,paciente.nome_paciente,abrircaixa.data_abrir,caixa.horaVenda,caixa.valorVenda\n" +
",convenio.numeroParcela,convenio.valorParcela, convenio.dataPagamento\n" +
" from paciente inner join convenio on paciente.id_paciente = convenio.id_paciente inner join caixa on convenio.id_caixa = caixa.id_caixa inner join abrircaixa on caixa.id_statos = abrircaixa.id_statos \n" +
" where paciente.id_paciente = ?";
             // 1º Organizar o Comando SQL
             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsqlb);
             stmt.setInt(1, idPaciente);
             
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 BuscarCarneModel objbusca = new BuscarCarneModel();
                 
                 objbusca.setId_convenio(rs.getInt("id_convenio"));
                 objbusca.setNomePaciente(rs.getString("nome_paciente"));
                 objbusca.setDataVenda(rs.getString("data_abrir"));
                 objbusca.setHoraVenda(rs.getString("horaVenda"));
                 objbusca.setValorVenda(rs.getFloat("valorVenda"));
                 objbusca.setNumeroParcela(rs.getInt("numeroParcela"));
                 objbusca.setValorPArcela(rs.getFloat("valorParcela"));
                 objbusca.setDataPagamento(rs.getString("dataPagamento"));
              
                 lista.add(objbusca);
                 
                 
             }
        
             
         }catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao buscar Join Carne"+e);
         }
              return  lista;
     
     }  
    
    
    
    
    
}
