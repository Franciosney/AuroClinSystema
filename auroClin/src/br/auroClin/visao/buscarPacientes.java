/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.FuncaoSistemaDAO;
import DAO.PacienteDAO;
import br.auroClin.model.Cidades;
import br.auroClin.model.Paciente;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Franciosney Souza
 */
public class buscarPacientes extends javax.swing.JFrame {

    /**
     * Creates new form buscarPacientes
     */
    
    
    
    
    
    public void buscarPAcientes(){
    
    
           String nome = jTextFieldNomePaciente.getText();
        try {

            PacienteDAO daop = new PacienteDAO();
            List<Paciente> listaPaciente = daop.listarTodosPacientesSemExecao();

            DefaultTableModel modelo = (DefaultTableModel)jTablePaciente.getModel();
            modelo.setNumRows(0);
int contPaciente = 0;
          

            int i = 0;
            for(Paciente objp: listaPaciente){
                modelo.addRow(new String[i]);
                 jTablePaciente.setValueAt(objp.getId_paciente(), i, 0);
                 jTablePaciente.setValueAt(objp.getNome_paciente(), i, 1);
                 jTablePaciente.setValueAt(objp.getCpf(), i, 2);
                 //jTablePaciente.setValueAt(objp.getDataNascimento(), i, 3);
                 jTablePaciente.setValueAt(objp.getPlano(), i, 3);
                 //jTablePaciente.setValueAt(objp.getDesconto(), i, 5);
                 
                 contPaciente = contPaciente+1;
           
                i++;

            }
            
            jTextFieldidQuantidadedePacientes.setText(Integer.toString(contPaciente)+" Pacientes");
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
       

        
    
    }
    
    
    
    
    
    public void buscarPAcientesPorNome(){
    
    
           String nome = jTextFieldNomePaciente.getText();
        try {

            PacienteDAO daop = new PacienteDAO();
            List<Paciente> listaPaciente = daop.listarPacientePorNome(nome);

            DefaultTableModel modelo = (DefaultTableModel)jTablePaciente.getModel();
            modelo.setNumRows(0);
int contPaciente = 0;
          

            int i = 0;
            for(Paciente objp: listaPaciente){
                modelo.addRow(new String[i]);
                 jTablePaciente.setValueAt(objp.getId_paciente(), i, 0);
                 jTablePaciente.setValueAt(objp.getNome_paciente(), i, 1);
                 jTablePaciente.setValueAt(objp.getCpf(), i, 2);
                 //jTablePaciente.setValueAt(objp.getDataNascimento(), i, 3);
                 jTablePaciente.setValueAt(objp.getPlano(), i, 3);
                 //jTablePaciente.setValueAt(objp.getDesconto(), i, 5);
                 
                 contPaciente = contPaciente+1;
           
                i++;

            }
            
            jTextFieldidQuantidadedePacientes.setText(Integer.toString(contPaciente)+" Pacientes");
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
       

        
    
    }
    
    
    
             
public void CidadesParaComobox(){

    
           
          
        try {
            
            FuncaoSistemaDAO daof = new FuncaoSistemaDAO();
            List<Cidades> lista = daof.listarCidades();
          
            for(Cidades op: lista){
            
                jComboBoxCidade.addItem(op.getNomeCidade());
             
            
            }
               
        } catch (Exception e) {
        }    
  

}
    
    
    
    
    
    
    
    
    
    public void buscarPAcientesCidade(){
    
    
           String cidade = (String) jComboBoxCidade.getSelectedItem();
           String bairro = jTextFieldNomBairro.getText();
          // System.out.println(letra);
        try {

            PacienteDAO daop = new PacienteDAO();
            List<Paciente> listaPaciente = daop.listarPacienteCidade(cidade,bairro);

            DefaultTableModel modelo = (DefaultTableModel)jTablePaciente.getModel();
            modelo.setNumRows(0);
int contPaciente = 0;
          

            int i = 0;
            for(Paciente objp: listaPaciente){
                modelo.addRow(new String[i]);
                 jTablePaciente.setValueAt(objp.getId_paciente(), i, 0);
                 jTablePaciente.setValueAt(objp.getNome_paciente(), i, 1);
                 jTablePaciente.setValueAt(objp.getCpf(), i, 2);
                 //jTablePaciente.setValueAt(objp.getDataNascimento(), i, 3);
                 jTablePaciente.setValueAt(objp.getPlano(), i, 3);
                 //jTablePaciente.setValueAt(objp.getDesconto(), i, 5);
                 
                 contPaciente = contPaciente+1;
           
                i++;

            }
            
            jTextFieldidQuantidadedePacientes.setText(Integer.toString(contPaciente)+" Pacientes");
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
       

        
    
    }
    
    
    public buscarPacientes() {
        initComponents();
        
        
                       
 JTableHeader headerPaciente = jTablePaciente.getTableHeader();   
    headerPaciente.setPreferredSize(new Dimension(0, 25)); 
    headerPaciente.setFont(new Font("��������", Font.PLAIN, 14));
	headerPaciente.setPreferredSize(new Dimension(headerPaciente.getWidth(),25));
 jTablePaciente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(50);
jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(400);
jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(130);
jTablePaciente.getColumnModel().getColumn(3).setPreferredWidth(170);

jTablePaciente.setRowHeight(20); 
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jButtonBuscarPaciente1 = new javax.swing.JButton();
        jTextFieldNomePaciente = new javax.swing.JTextField();
        jTextFieldidQuantidadedePacientes = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldNomBairro = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jComboBoxCidade = new javax.swing.JComboBox<>();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busca Avançada por Pacientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jTablePaciente.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Plano"
            }
        ));
        jTablePaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTablePaciente);

        jButtonBuscarPaciente1.setText("Buscar Todos");
        jButtonBuscarPaciente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPaciente1ActionPerformed(evt);
            }
        });

        jTextFieldNomePaciente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldNomePaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomePacienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNomePacienteKeyReleased(evt);
            }
        });

        jTextFieldidQuantidadedePacientes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Buscar por Nome:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Quantidade de Registros:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Buscar por Cidade");

        jTextFieldNomBairro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldNomBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomBairroKeyPressed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Buscar por Bairro");

        jComboBoxCidade.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBoxCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCidadeItemStateChanged(evt);
            }
        });

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jButtonBuscarPaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNomBairro)))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldidQuantidadedePacientes))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonBuscarPaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNomBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addGap(4, 4, 4)
                .addComponent(jTextFieldidQuantidadedePacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(800, 688));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked
        // TODO add your handling code here:

        //jTextFieldidQuantidadedePacientes.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0).toString());
        //jTextFieldNomeCurso.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 1).toString());

    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jButtonBuscarPaciente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPaciente1ActionPerformed
        // TODO add your handling code here:

        buscarPAcientes();
        
        //buscarCursos();
    }//GEN-LAST:event_jButtonBuscarPaciente1ActionPerformed

    private void jTextFieldNomePacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomePacienteKeyPressed
        // TODO add your handling code here:
buscarPAcientesPorNome();
        //buscarCursos();
    }//GEN-LAST:event_jTextFieldNomePacienteKeyPressed

    private void jTextFieldNomBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomBairroKeyPressed
        // TODO add your handling code here:
buscarPAcientesCidade();

    }//GEN-LAST:event_jTextFieldNomBairroKeyPressed

    private void jTextFieldNomePacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomePacienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomePacienteKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        CidadesParaComobox();
    }//GEN-LAST:event_formWindowActivated

    private void jComboBoxCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCidadeItemStateChanged
        // TODO add your handling code here:
        
        buscarPAcientesCidade();
    }//GEN-LAST:event_jComboBoxCidadeItemStateChanged

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(buscarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buscarPacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarPaciente1;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JComboBox<String> jComboBoxCidade;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextField jTextFieldNomBairro;
    private javax.swing.JTextField jTextFieldNomePaciente;
    private javax.swing.JTextField jTextFieldidQuantidadedePacientes;
    // End of variables declaration//GEN-END:variables
}
