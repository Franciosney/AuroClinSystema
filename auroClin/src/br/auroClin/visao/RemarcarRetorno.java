/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.retornoDAO;
import br.auroClin.model.JoinBuscarExameEMarcar;
import br.auroClin.model.relatorioExame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Franciosney Souza
 */
public class RemarcarRetorno extends javax.swing.JFrame {

    /**
     * Creates new form RemarcarRetorno
     * @param nomeExame
     * @param id
     */
    
    
        
    
    public void buscarExamesConsultas(String nomeExame,int id){
    
        
             SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
          
        
        

        try {
            

       // String data = jTextFieldData.getText();
            
            
          retornoDAO daor = new retornoDAO();
            
            List<JoinBuscarExameEMarcar> listaExames = daor.BuscarExameConsultasMArcarRetorno(nomeExame,id);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableDatasConsultasExames.getModel();
            modelo.setNumRows(0);
       
            
                  
  NumberFormat nf = NumberFormat.getCurrencyInstance(); 


               int i = 0;
            for(JoinBuscarExameEMarcar ex: listaExames){
                
                
       
                
        
                  DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
             
    Date dt1 = df.parse (ex.getDataRealizar());
        Date dt2 = df.parse (dataAtual);
   
    //if(dt2.after(dt1))
        if(dt2.after(dt1)) {
            System.err.println("Essa Data Ja passou "+ex.getDataRealizar());
        } else {
           
modelo.addRow(new String[i]);

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(ex.getDataRealizar());  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");   

    
     
jTableDatasConsultasExames.setValueAt(ex.getId_marcarBuscar(), i, 0);
jTableDatasConsultasExames.setValueAt(ex.getExameRequerido(), i, 1);
jTableDatasConsultasExames.setValueAt(ex.getNomeMedico(), i, 2);
jTableDatasConsultasExames.setValueAt(formatoRetorno.format(date), i, 3);


    
   


          
            i++;
            
            }
             
             
             
             
        }
                
    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
      
    
    }
    
    
    
    
     
    public void retornoConsultasExamesBuscarMesNomePaciente(){
    

        
        int month,year= 0;  
                
 month = jMonthChooserMes.getMonth();
 year = jYearChooserAno.getYear();
 String nomePaciente = jTextFieldNomePaciente.getText();
 

 month = month + 01;

         String a = Integer.toString(month);
             String d = "/";
                String b = Integer.toString(year);
                     String c = a+d+b;
                           String dataBanco = c;
                           
        

        try {
            

       // String data = jTextFieldData.getText();
            
            
          retornoDAO daor = new retornoDAO();
            
            List<relatorioExame> listaExames = daor.retornoConsultasExamesNomePaciente(dataBanco,nomePaciente);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableRetorConsultasExamesMarcados.getModel();
            modelo.setNumRows(0);
       
            
                  
  NumberFormat nf = NumberFormat.getCurrencyInstance(); 


               int i = 0;
            for(relatorioExame ex: listaExames){
                
                
       
                
        
 
  
           
modelo.addRow(new String[i]);

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(ex.getDataFazer());  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");   

    
 jTableRetorConsultasExamesMarcados.setValueAt(ex.getId_retorno(), i, 0);   
jTableRetorConsultasExamesMarcados.setValueAt(ex.getId_marcar(), i, 1); 
jTableRetorConsultasExamesMarcados.setValueAt(ex.getNomePAciente(), i, 2);
jTableRetorConsultasExamesMarcados.setValueAt(ex.getNomeBusca(), i, 3);
jTableRetorConsultasExamesMarcados.setValueAt(ex.getNomeMedico(), i, 4);
jTableRetorConsultasExamesMarcados.setValueAt(formatoRetorno.format(date), i, 5);
jTableRetorConsultasExamesMarcados.setValueAt(ex.getSituacaoFila(), i, 6);

           
    
   


          
            i++;
            
      
             
             
             
             
        }
                
    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
      
    
    }
    
    
    
    
    
    
    public void retornoConsultasExames(){
    
        
             SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
       int mes,mesAtual;
        mes = cal.get(cal.MONTH);
        mesAtual = mes +1;
        
 
String mesString = Integer.toString(mesAtual);
     
    
        
        String a = Integer.toString(mesAtual);
             String d = "/";
                String b = Integer.toString(cal.get(cal.YEAR));
                     String dataBanco = a+d+b;
                       
        

        try {
            

       // String data = jTextFieldData.getText();
            
            
          retornoDAO daor = new retornoDAO();
            
            List<relatorioExame> listaExames = daor.retornoConsultasExamesRemarcar(dataBanco);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableRetorConsultasExamesMarcados.getModel();
            modelo.setNumRows(0);
       
            
                  
  NumberFormat nf = NumberFormat.getCurrencyInstance(); 


               int i = 0;
            for(relatorioExame ex: listaExames){
                
                
       
                
        
                  DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
             
    Date dt1 = df.parse (ex.getDataFazer());
        Date dt2 = df.parse (dataAtual);
   
    //if(dt2.after(dt1))
        if(dt2.after(dt1)) {
            System.err.println("Essa Data Ja passou "+ex.getDataFazer());
        } else {
           
modelo.addRow(new String[i]);

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(ex.getDataFazer());  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");   

    
     
    
 jTableRetorConsultasExamesMarcados.setValueAt(ex.getId_retorno(), i, 0);   
jTableRetorConsultasExamesMarcados.setValueAt(ex.getId_marcar(), i, 1); 
jTableRetorConsultasExamesMarcados.setValueAt(ex.getNomePAciente(), i, 2);
jTableRetorConsultasExamesMarcados.setValueAt(ex.getNomeBusca(), i, 3);
jTableRetorConsultasExamesMarcados.setValueAt(ex.getNomeMedico(), i, 4);
jTableRetorConsultasExamesMarcados.setValueAt(formatoRetorno.format(date), i, 5);
jTableRetorConsultasExamesMarcados.setValueAt(ex.getSituacaoFila(), i, 6);

//jTableRetorConsultasExamesMarcados.setValueAt(ex.getHorarios(), i, 4);

           
    
   


          
            i++;
            
            }
             
             
             
             
        }
                
    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
      
    
    }
    
    
    
    
    
    
    
    public RemarcarRetorno() {
        initComponents();
        
        
        

JTableHeader headerExames = jTableRetorConsultasExamesMarcados.getTableHeader();   
    headerExames.setPreferredSize(new Dimension(0, 25)); 
   headerExames.setFont(new Font("��������", Font.PLAIN, 14));
	headerExames.setPreferredSize(new Dimension(headerExames.getWidth(),25));
                        
                jTableRetorConsultasExamesMarcados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(0).setPreferredWidth(40);
jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(1).setPreferredWidth(40);
jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(2).setPreferredWidth(190);
jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(3).setPreferredWidth(200);
jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(4).setPreferredWidth(165);
jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(5).setPreferredWidth(90);
jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(6).setPreferredWidth(100);

jTableRetorConsultasExamesMarcados.setRowHeight(20); 
                
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTableRetorConsultasExamesMarcados = new javax.swing.JTable();
        jYearChooserAno = new com.toedter.calendar.JYearChooser();
        jMonthChooserMes = new com.toedter.calendar.JMonthChooser();
        jButton3 = new javax.swing.JButton();
        jTextFieldNomePaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDatasConsultasExames = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNomeExameConsulta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNovaData = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldIdMarcarMudar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldIdNovaData = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jTableRetorConsultasExamesMarcados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableRetorConsultasExamesMarcados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID-M", "ID-D", "Nome Paciente", "Exame/Consulta", "Médico", "Data Retorno", "Situação"
            }
        ));
        jTableRetorConsultasExamesMarcados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableRetorConsultasExamesMarcados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRetorConsultasExamesMarcadosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableRetorConsultasExamesMarcados);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 180, 830, 110);
        getContentPane().add(jYearChooserAno);
        jYearChooserAno.setBounds(540, 130, 160, 40);

        jMonthChooserMes.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        getContentPane().add(jMonthChooserMes);
        jMonthChooserMes.setBounds(410, 130, 280, 40);

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(700, 130, 140, 40);

        jTextFieldNomePaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomePacienteKeyPressed(evt);
            }
        });
        getContentPane().add(jTextFieldNomePaciente);
        jTextFieldNomePaciente.setBounds(10, 130, 400, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("DATAS DISPONIVEIS");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 300, 830, 30);

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Esta Ação sera Realizada Quando o Usuario Faltar o Retorno, Precisando Remarcar a Data");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 40, 590, 20);

        jLabel3.setText("Buscar Ano");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(550, 110, 220, 14);

        jLabel4.setText("Buscar Paciente");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 110, 260, 14);

        jLabel5.setText("Buscar Mês");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(430, 110, 220, 14);

        jTableDatasConsultasExames.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableDatasConsultasExames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Consulta/Exame", "Médico", "Data"
            }
        ));
        jTableDatasConsultasExames.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableDatasConsultasExames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDatasConsultasExamesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableDatasConsultasExames);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 400, 830, 120);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("              REMARCAR RETORNO");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(280, 10, 380, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("TABELA DE RETORNOS");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 70, 830, 30);
        getContentPane().add(jTextFieldNomeExameConsulta);
        jTextFieldNomeExameConsulta.setBounds(80, 360, 530, 30);

        jLabel8.setText("Consulta/Exame");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(150, 340, 100, 14);
        getContentPane().add(jTextFieldNovaData);
        jTextFieldNovaData.setBounds(690, 360, 150, 30);

        jLabel9.setText("   Nova Data");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(690, 340, 150, 14);
        getContentPane().add(jTextFieldIdMarcarMudar);
        jTextFieldIdMarcarMudar.setBounds(10, 360, 60, 30);

        jLabel10.setText("ID");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 340, 40, 14);
        getContentPane().add(jTextFieldIdNovaData);
        jTextFieldIdNovaData.setBounds(620, 360, 60, 30);

        jLabel11.setText("ID");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(640, 340, 30, 14);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/IconRetornarPronto.png"))); // NOI18N
        jButton1.setText("Renovar Retorno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(553, 540, 290, 40);

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFechar);
        jButtonFechar.setBounds(780, 0, 63, 39);

        setSize(new java.awt.Dimension(850, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        retornoConsultasExames();
    }//GEN-LAST:event_formWindowActivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        retornoConsultasExamesBuscarMesNomePaciente();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextFieldNomePacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomePacienteKeyPressed
        // TODO add your handling code here:
        
        retornoConsultasExamesBuscarMesNomePaciente();
    }//GEN-LAST:event_jTextFieldNomePacienteKeyPressed

    private void jTableDatasConsultasExamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDatasConsultasExamesMouseClicked
        // TODO add your handling code here:

        
         jTextFieldIdNovaData.setText(jTableDatasConsultasExames.getValueAt(jTableDatasConsultasExames.getSelectedRow(), 0).toString());
         jTextFieldNovaData.setText(jTableDatasConsultasExames.getValueAt(jTableDatasConsultasExames.getSelectedRow(), 3).toString());
        
        
        
        //---- Controlando Clique na tabela
/*
        jTableDatasConsultasExames.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel
        jTableDatasConsultasExames.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {

                    //JOptionPane.showMessageDialog(null, "Você não Pode Editar! Não Insista");
                }
            }
        });

        try {

            jTextField1IdRetorno.setText(jTableDatasConsultasExames.getValueAt(jTableDatasConsultasExames.getSelectedRow(), 0).toString());
            jTextFieldData.setText(jTableDatasConsultasExames.getValueAt(jTableDatasConsultasExames.getSelectedRow(), 3).toString());
            jTextFieldNomeExame.setBackground(new java.awt.Color(0, 255, 204));
            jTextField1IdRetorno.setBackground(new java.awt.Color(0, 255, 204));
            jTextFieldData.setBackground(new java.awt.Color(0, 255, 204));

        } catch (Exception e) {

        }

        
        */
        
    }//GEN-LAST:event_jTableDatasConsultasExamesMouseClicked

    private void jTableRetorConsultasExamesMarcadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRetorConsultasExamesMarcadosMouseClicked
        // TODO add your handling code here:
        
        
        
        
           String nomeExame =jTableRetorConsultasExamesMarcados.getValueAt(jTableRetorConsultasExamesMarcados.getSelectedRow(), 3).toString();
       // jTextFieldNomeExame.setText(nomeExame);
        int id =  Integer.parseInt(jTableRetorConsultasExamesMarcados.getValueAt(jTableRetorConsultasExamesMarcados.getSelectedRow(), 1).toString());
        buscarExamesConsultas(nomeExame,id);
        
        
        jTextFieldIdMarcarMudar.setText(jTableRetorConsultasExamesMarcados.getValueAt(jTableRetorConsultasExamesMarcados.getSelectedRow(), 0).toString());
        //jTextFieldIdNovaData.setText(Integer.toString(id));
        jTextFieldNomeExameConsulta.setText(nomeExame);
        
        
        
    }//GEN-LAST:event_jTableRetorConsultasExamesMarcadosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
     
         if (jTextFieldIdMarcarMudar.getText().equals("")) {
                
                 JOptionPane.showMessageDialog(rootPane, "Selecione um Retorno na Tabela Acima, Obrigado!");
                 jTableRetorConsultasExamesMarcados.setBorder(BorderFactory.createLineBorder(Color.red));
                
            } else if(jTextFieldIdNovaData.getText().equals("")){
            
                 JOptionPane.showMessageDialog(rootPane, "Selecione uma data para Retorno na Tabela Abaixo, Obrigado!");
                 jTableDatasConsultasExames.setBorder(BorderFactory.createLineBorder(Color.red));
            
            } else{
            
                
                  
        
        String validar = jTableRetorConsultasExamesMarcados.getValueAt(jTableRetorConsultasExamesMarcados.getSelectedRow(), 6).toString();
        
        
        if (validar.equals("FINALIZADO")) {
            
            JOptionPane.showMessageDialog(rootPane, "Esse Retorno já foi finalizado você não pode remarcalo, Obrigado!");
            
        }else{
            

              int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Você Deseja Remarcar Este Retorno?", "Title on Box", dialogButton);
            if(dialogResult == 0){
            
                 retornoDAO daor = new retornoDAO();
            
            int idMarcarexame = Integer.parseInt(jTextFieldIdMarcarMudar.getText());
            int idMarcar = Integer.parseInt(jTextFieldIdNovaData.getText());
            daor.CadastrarRemarcarRetorno(idMarcarexame, idMarcar);
            JOptionPane.showMessageDialog(rootPane, "Retorno Remarcado Com sucesso, Obrigado!");
            
            
            
            }else{
            
            JOptionPane.showMessageDialog(rootPane, "Você Não Marcou o Retorno, Obrigado!");
            jTextFieldIdMarcarMudar.setText("");
            jTextFieldNomeExameConsulta.setText("");
            jTextFieldIdNovaData.setText("");
            jTextFieldNovaData.setText("");
            
            }
            


        
        }
 
            }
        
      
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RemarcarRetorno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RemarcarRetorno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RemarcarRetorno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RemarcarRetorno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RemarcarRetorno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooserMes;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableDatasConsultasExames;
    private javax.swing.JTable jTableRetorConsultasExamesMarcados;
    private javax.swing.JTextField jTextFieldIdMarcarMudar;
    private javax.swing.JTextField jTextFieldIdNovaData;
    private javax.swing.JTextField jTextFieldNomeExameConsulta;
    private javax.swing.JTextField jTextFieldNomePaciente;
    private javax.swing.JTextField jTextFieldNovaData;
    private com.toedter.calendar.JYearChooser jYearChooserAno;
    // End of variables declaration//GEN-END:variables
}
