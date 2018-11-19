/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.FabricaConecao;
import br.auroClin.model.VendaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Franciosney Souza
 */
public class VendaDAO {
    
    
      private Connection conecta;
    
    public VendaDAO(){
    this.conecta = new FabricaConecao().conecta();
    }
    
    
    
    
    
    
     public void cadastrarVenda(VendaModel objv){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "insert into venda(valorVenda,horaVenda,formaPagamento,id_funcionario,id_marcarExame,tipodeCartao,cancelar)values(?,?,?,?,?,?,?)";
             // 1º Organizar o Comando SQL
           
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setFloat(1, objv.getValorVenda());
              stmt.setString(2, objv.getHoraVenda());
              stmt.setString(3, objv.getFormaPagamento());
              stmt.setInt(4, objv.getId_funcionario());
              stmt.setInt(5, objv.getId_marcar());
              stmt.setString(6, objv.getTipoCartao());
              stmt.setString(7, objv.getCancelar());
            
              
      
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
    
     /*
    
     
     public void deletarRegistrodeVenda(int idDeleteJoin){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "DELETE venda FROM venda\n" +
"inner join marcarexame on marcarexame.id_marcarExame = venda.id_marcarExame where \n" +
"marcarexame.id_marcarExame = ?";
            
             // 1º Organizar o Comando SQL
            // 1º Executar Comando SQL
            
            try (PreparedStatement stmt = conecta.prepareStatement(cmsql)) {
                stmt.setInt(1, idDeleteJoin);
                // 1º Executar Comando SQL
                stmt.execute();
                // 1º Fechar Coneção
            }
             
             
             
        } catch (Exception erro) {
            
             JOptionPane.showMessageDialog(null, "Erro no banco de dados, contate o suporte técnico do sistema"+erro);
            throw new RuntimeException(erro);
            
        }
        
        //-------------------------------------------------
     }
    
     
    
     */
     
     
     
     
    
       public void CancelarPagamento(String Cancelar,int idFuncionario, int idCancelar){
    //-----------------------------------------------------
        try {
          
            
            // 1º passo Criar Comando SQL
            String cmsql = "update venda set Cancelar = ?,id_funcionarioCancelou = ? where id_marcarExame = ?";

             // 1º Organizar o Comando SQL
             
             PreparedStatement stmt = conecta.prepareStatement(cmsql);
             stmt.setString(1, Cancelar);
              stmt.setInt(2, idFuncionario);
             stmt.setInt(3, idCancelar);
         
         
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
