/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auroclin;

import JDBC.FabricaConecao;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Franciosney Souza
 */
public class AuroClin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
           try {
            
             JOptionPane.showMessageDialog(null, "Testando Conexão");
            Connection con = new FabricaConecao().conecta();
             JOptionPane.showMessageDialog(null, "Esta Conectado");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Testando Conexão"+e);
        }
        
        
        
    }
    
}
