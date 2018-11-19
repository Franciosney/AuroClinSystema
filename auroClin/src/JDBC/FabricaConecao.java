/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Franciosney Souza
 */
public class FabricaConecao {
    
     public Connection conecta(){
    
        try {
            //return DriverManager.getConnection("jdbc:mysql://192.168.11.17/auroclin","auroClin","qwe123");
             return DriverManager.getConnection("jdbc:mysql://localhost/auroclin","root","");
                    } catch (SQLException ex) {
                        
              JOptionPane.showMessageDialog(null, "Ligue o Servidor ou Conecte-se a Rede!");          
            throw new RuntimeException(ex);
            
        }
    }
    
    
}
