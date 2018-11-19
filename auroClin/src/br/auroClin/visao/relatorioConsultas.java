/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.relatoriosDao;
import DAO.retornoDAO;
import br.auroClin.model.IreporterConsultas;
import br.auroClin.model.relatorioExame;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Franciosney Souza
 */
public class relatorioConsultas extends javax.swing.JFrame {

    
    
     public void listarConsultasFazer(){

        Date dataRealizar = jDateChooser1.getDate();
          SimpleDateFormat farmato = new SimpleDateFormat("dd/MM/yyyy");
                       String dataBanco = farmato.format(dataRealizar);
                       
                       //JOptionPane.showMessageDialog(rootPane, dataBanco);
                       
                       jButton4.setText("");
                       jButton4.setText("Imprimir Relatório do Dia "+dataBanco+" ?");   
                       
    
        try {
            
            relatoriosDao daor = new relatoriosDao();
            List<relatorioExame> listaRelatorioExame = daor.listarRelatoriodeConsultas(dataBanco);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableRelatorioConsultas.getModel();
            modelo.setNumRows(0);
            
          


            int i = 0;
            for(relatorioExame ex: listaRelatorioExame){
                
                
                
                
                    String dataBancoVindo = ex.getDataFazer();
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = (Date)formatter.parse(dataBancoVindo);
                    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");
                
                
                
                
modelo.addRow(new String[i]);
jTableRelatorioConsultas.setValueAt(ex.getNomePAciente(), i, 0);
jTableRelatorioConsultas.setValueAt(ex.getNomeBusca(), i, 1);
 jTableRelatorioConsultas.setValueAt(formatoRetorno.format(date), i, 2);
 jTableRelatorioConsultas.setValueAt( String.format("Dr. %-30s", ex.getNomeMedico()), i, 3);
  jTableRelatorioConsultas.setValueAt(ex.getHorarios(), i, 4);
   jTableRelatorioConsultas.setValueAt(ex.getRetorno(), i, 5);
  
 

            i++;
            }
            
        } catch (Exception e) {}
        }
    
    
     
     
     
     public void listarConsultasFazerPorMes(){

       int month,year= 0;
          
 month = jMonthChooserMes.getMonth();
 year = jYearChooserAno.getYear();
 

 month = month + 01;

         String a = Integer.toString(month);
             String d = "/";
                String b = Integer.toString(year);
                     String c = a+d+b;
                           String dataBanco = c;
                           
                       jButton4.setText("Imprimir Relatório do Mês 0"+c+" ?");   

                   
                       
    
        try {
            
            relatoriosDao daor = new relatoriosDao();
            List<relatorioExame> listaRelatorioExame = daor.listarRelatoriodeConsultasPorMes(dataBanco);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableRelatorioConsultas.getModel();
            modelo.setNumRows(0);
            
          


            int i = 0;
            for(relatorioExame ex: listaRelatorioExame){
                
                
                
                
                    String dataBancoVindo = ex.getDataFazer();
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = (Date)formatter.parse(dataBancoVindo);
                    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");
                

                
modelo.addRow(new String[i]);
jTableRelatorioConsultas.setValueAt(ex.getNomePAciente(), i, 0);
jTableRelatorioConsultas.setValueAt(ex.getNomeBusca(), i, 1);
 jTableRelatorioConsultas.setValueAt(formatoRetorno.format(date), i, 2);
  jTableRelatorioConsultas.setValueAt( String.format("Dr. %-30s", ex.getNomeMedico()), i, 3);
    jTableRelatorioConsultas.setValueAt(ex.getHorarios(), i, 4);
    jTableRelatorioConsultas.setValueAt(ex.getRetorno(), i, 5);
 

            i++;
            }
            
        } catch (Exception e) {
        
        
        
        }
        }
    
     
     
     
       
   
    
    
    /**
     * Creates new form relatorioConsultas
     */
    public relatorioConsultas() {
        initComponents();
        
         
        jTextAreaFrase.setEditable(false);
       // jTableRelatorioExames.setFont(new Font("Serif", Font.PLAIN, 50));
         JTableHeader header = jTableRelatorioConsultas.getTableHeader();   
    header.setPreferredSize(new Dimension(0, 50)); 
    header.setFont(new Font("��������", Font.PLAIN, 14));
	header.setPreferredSize(new Dimension(header.getWidth(),40));
           
         jTableRelatorioConsultas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableRelatorioConsultas.getColumnModel().getColumn(0).setPreferredWidth(300);
jTableRelatorioConsultas.getColumnModel().getColumn(1).setPreferredWidth(180);
jTableRelatorioConsultas.getColumnModel().getColumn(2).setPreferredWidth(100);
jTableRelatorioConsultas.getColumnModel().getColumn(3).setPreferredWidth(200);
jTableRelatorioConsultas.getColumnModel().getColumn(4).setPreferredWidth(90);
jTableRelatorioConsultas.getColumnModel().getColumn(5).setPreferredWidth(100);

jTableRelatorioConsultas.setRowHeight(35); 
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaFrase = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jMonthChooserMes = new com.toedter.calendar.JMonthChooser();
        jYearChooserAno = new com.toedter.calendar.JYearChooser();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonMinimizar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRelatorioConsultas = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jTextFiedValidar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFiedValidarTabela = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("      PESQUISAS");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextAreaFrase.setColumns(20);
        jTextAreaFrase.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jTextAreaFrase.setRows(5);
        jTextAreaFrase.setText("   Aréa destinada para busca \nde todas as consultas marcados  \n   em suas respectivas datas.");
        jTextAreaFrase.setBorder(null);
        jScrollPane3.setViewportView(jTextAreaFrase);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Buscar Consulta Por Data");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Buscar Consultas Por Mês");

        jMonthChooserMes.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jMonthChooserMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jYearChooserAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jYearChooserAno, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jMonthChooserMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setText("Relatório Avançado");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 350, 640);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("           RELATÓRIO DE CONSULTAS MARCADA");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (1).png"))); // NOI18N
        jButtonMinimizar.setToolTipText("Minimizar");
        jButtonMinimizar.setName(""); // NOI18N
        jButtonMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizarActionPerformed(evt);
            }
        });

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jTableRelatorioConsultas.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTableRelatorioConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome do Paciente", "Consulta", "Data", "Horário", "Médico", "Receita"
            }
        ));
        jTableRelatorioConsultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableRelatorioConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRelatorioConsultasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRelatorioConsultas);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/icon01.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButtonMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))))
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(370, 60, 970, 590);
        getContentPane().add(jTextFiedValidar);
        jTextFiedValidar.setBounds(830, 10, 250, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/fundoRelatorioConsulta.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 90, 1350, 570);
        getContentPane().add(jTextFiedValidarTabela);
        jTextFiedValidarTabela.setBounds(580, 10, 190, 40);

        setSize(new java.awt.Dimension(1350, 660));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizarActionPerformed
        // TODO add your handling code here:
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizarActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

       jTextFiedValidar.setText("data");

        Date dataRealizar;
        dataRealizar = jDateChooser1.getDate();

        if (dataRealizar == null) {

            JOptionPane.showMessageDialog(rootPane, "Por Favor! Digite uma Data Para Busca!");

        } else {
            listarConsultasFazer();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        jTextFiedValidar.setText("mes");
       listarConsultasFazerPorMes();
      

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        List lista = new ArrayList();
                
                for (int i = 0; i < jTableRelatorioConsultas.getRowCount(); i++) {
            
                    IreporterConsultas consultas = new IreporterConsultas(jTableRelatorioConsultas.getValueAt(i, 0).toString(), jTableRelatorioConsultas.getValueAt(i, 1).toString(),jTableRelatorioConsultas.getValueAt(i, 2).toString(),jTableRelatorioConsultas.getValueAt(i, 3).toString(),jTableRelatorioConsultas.getValueAt(i, 4).toString(),jTableRelatorioConsultas.getValueAt(i, 5).toString());
                    lista.add(consultas);
        }
        
                
               
                
 


          
             
         
             
             if (jTextFiedValidar.getText().equals("mes")) {
             
             
             int month,year= 0;
             
             month = jMonthChooserMes.getMonth();
             year = jYearChooserAno.getYear();
             
             month = month + 01;
             
             String a = Integer.toString(month);
             String d = "/";
             String b = Integer.toString(year);
             String c = a+d+b;
             
              try {
                    
                      Map parametros = new HashMap();  
  parametros.put("Titulo", "Relatório de Consultas do Mês 0"+c);
          JasperPrint print = JasperFillManager.fillReport("C:/Users/Franciosney Souza/Documents/NetBeansProjects/auroClin/RelatoriosProntos/reportt.jasper", 
                    parametros,new JRBeanCollectionDataSource(lista));
            
            JasperViewer  vj = new JasperViewer(print,false);
            vj.setVisible(true);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
   
             }
             
             else if(jTextFiedValidar.getText().equals("data")){
             
             Date dataRealizar = jDateChooser1.getDate();
             SimpleDateFormat farmato = new SimpleDateFormat("dd/MM/yyyy");
             String dataJogar = farmato.format(dataRealizar);
             
               try {
                    
                      Map parametros = new HashMap();  
  parametros.put("Titulo", "Relatório de Consultas do dia "+dataJogar);
          JasperPrint print = JasperFillManager.fillReport("C:/Users/Franciosney Souza/Documents/NetBeansProjects/auroClin/RelatoriosProntos/reportt.jasper", 
                    parametros,new JRBeanCollectionDataSource(lista));
            
            JasperViewer  vj = new JasperViewer(print,false);
            vj.setVisible(true);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
   
             
             } 
    
             
             /*
             
             
             }
             
             /*
             PrinterJob job = PrinterJob.getPrinterJob();
             job.setPrintable(jTableRelatorioExames.getPrintable(PrintMode.FIT_WIDTH, null, null));
             job.setJobName("Nome do Trabalho de impressão");
             if (job.printDialog()) {
             try {
             job.print();
             } catch (PrinterException ex) {
             Logger.getLogger(relatoriosExameConsulta.class.getName()).log(Level.SEVERE, null, ex);
             }
             */
     
        

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTableRelatorioConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRelatorioConsultasMouseClicked
        // TODO add your handling code here:
   
        
        
    
    }//GEN-LAST:event_jTableRelatorioConsultasMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
         RelatorioAvancadoConsultas tela = new RelatorioAvancadoConsultas();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(relatorioConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(relatorioConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(relatorioConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(relatorioConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new relatorioConsultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonMinimizar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.toedter.calendar.JMonthChooser jMonthChooserMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableRelatorioConsultas;
    private javax.swing.JTextArea jTextAreaFrase;
    private javax.swing.JTextField jTextFiedValidar;
    private javax.swing.JTextField jTextFiedValidarTabela;
    private com.toedter.calendar.JYearChooser jYearChooserAno;
    // End of variables declaration//GEN-END:variables
}
