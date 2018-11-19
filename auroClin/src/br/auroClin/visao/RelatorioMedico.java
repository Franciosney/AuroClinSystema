/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.RelatorioFluxoCaixaDAO;
import br.auroClin.model.Exame;
import br.auroClin.model.IreporterConsultas;
import br.auroClin.model.IrreporterRelatorioCaixa;
import br.auroClin.model.RelatorioFluxoCaixaModelo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Franciosney Souza
 */
public class RelatorioMedico extends javax.swing.JFrame {

    /**
     * Creates new form RelatorioLucro
     * @param tipo
     * @param data
     */
    
    
    
    
    
     public void listarFluxoDia(String tipo, String data){

     
 String medico = jTextField1.getText();
                    
    
        try {
            
            RelatorioFluxoCaixaDAO daof = new RelatorioFluxoCaixaDAO();
            List<RelatorioFluxoCaixaModelo> listaRelatorioFluxo = daof.relatoriosCaixaPorMrdicoLucro(tipo, data,medico);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableFluxo.getModel();
            modelo.setNumRows(0);
            
            
            NumberFormat format = NumberFormat.getCurrencyInstance();
          
int trazacoes = 0;
float soma = 0;
float totalLucro = 0;
float ValorMedico = 0;
float totalPago = 0;
float totalLucroSomado = 0; 
float somaLucro = 0;

            int i = 0;
            for(RelatorioFluxoCaixaModelo ex: listaRelatorioFluxo){
                
              trazacoes = trazacoes + 1;
              float valor = ex.getValor();
              soma = soma + valor;
   
              String servico = ex.getServico();
             
              
                //FluxodeCaixaDAO daov = new FluxodeCaixaDAO();
                // daov.listarExamesConsultasPorNome(servico);
              
                
                
                  RelatorioFluxoCaixaDAO daov = new RelatorioFluxoCaixaDAO();
                
            List<Exame> listaplanos = daov.listarExamesConsultasPorNome(servico);
     
                 for(Exame lm: listaplanos){
                     
                      float valorServico = ex.getValor();
                     float lucro = lm.getLucro();
                     float desconto = valorServico*lucro;
                     totalPago = totalPago + valorServico;
                     ValorMedico = valorServico - desconto;
                     
                     totalLucro = totalLucro + ValorMedico;
                     
                     
                     
                     
                     somaLucro = valorServico*lucro;
                     
                     totalLucroSomado = totalLucroSomado + somaLucro;
                     
                     
                     
                     
                 }
                 
                //jTextFieldLucro.setText(Float.toString(totalLucro));
                 
              
                /*
                
                    String dataBancoVindo = ex.getDataFazer();
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = (Date)formatter.parse(dataBancoVindo);
                    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");
                
                */
        
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = (Date)formatter.parse(ex.getDataVenda());
                SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");
                
                
                
modelo.addRow(new String[i]);
jTableFluxo.setValueAt(ex.getVendedor(), i, 0);
jTableFluxo.setValueAt(ex.getServico(), i, 1);
jTableFluxo.setValueAt(format.format(ex.getValorTotal()), i, 2);
jTableFluxo.setValueAt(format.format(ex.getValor()), i, 3);
jTableFluxo.setValueAt(format.format(ValorMedico), i, 4);
jTableFluxo.setValueAt(format.format(somaLucro), i, 5);
jTableFluxo.setValueAt(formatoRetorno.format(date), i, 6);
jTableFluxo.setValueAt(ex.getHoraVenda(), i, 7);
jTableFluxo.setValueAt(ex.getNomePaciente(), i, 8);


  
 

            i++;
         
            }
            
           
           jTextFieldTerceiro.setText(format.format(totalLucro));
           jTextField4.setText(format.format(totalPago));
           jTextFieldLucro.setText(format.format(totalLucroSomado));
            //System.out.println(soma);
           // jTextFieldBruto.setText(format.format(soma));
            //String somar = Integer.toString((int) soma);
           jTextFieldTranzacoes.setText(Integer.toString(trazacoes));
           //jTextFieldBruto.setText(somar);
            
        } catch (Exception e) {
        
        
        }
        
        
        }
    
    
    
    public RelatorioMedico() {
        initComponents();
        
        
         
         JTableHeader headerPaciente = jTableFluxo.getTableHeader();   
    headerPaciente.setPreferredSize(new Dimension(0, 25)); 
    headerPaciente.setFont(new Font("��������", Font.PLAIN, 14));
	headerPaciente.setPreferredSize(new Dimension(headerPaciente.getWidth(),25));
 jTableFluxo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableFluxo.getColumnModel().getColumn(0).setPreferredWidth(250);
jTableFluxo.getColumnModel().getColumn(1).setPreferredWidth(185);
jTableFluxo.getColumnModel().getColumn(2).setPreferredWidth(110);
jTableFluxo.getColumnModel().getColumn(3).setPreferredWidth(110);
jTableFluxo.getColumnModel().getColumn(4).setPreferredWidth(110);
jTableFluxo.getColumnModel().getColumn(5).setPreferredWidth(120);
jTableFluxo.getColumnModel().getColumn(6).setPreferredWidth(120);
jTableFluxo.getColumnModel().getColumn(7).setPreferredWidth(95);
jTableFluxo.getColumnModel().getColumn(8).setPreferredWidth(155);
jTableFluxo.getParent().setBackground(Color.WHITE);

jTableFluxo.setRowHeight(23); 
        
        
        
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFluxo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jMonthChooserMes = new com.toedter.calendar.JMonthChooser();
        jYearChooserAno = new com.toedter.calendar.JYearChooser();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextFieldTerceiro = new javax.swing.JTextField();
        jTextFieldTranzacoes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextFieldLucro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jTableFluxo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableFluxo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Médico", "Serviço", "Valor Total", "Valor Pago", "Terceiro", "Lucro", "Data venda", "OBS", "Beneficiario"
            }
        ));
        jScrollPane1.setViewportView(jTableFluxo);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 176, 1280, 290);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 0));
        jLabel2.setText("                  RELATÓRIO DO CAIXA");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(360, 10, 620, 41);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("RELATÓRIO POR DIA");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 68, 280, 102);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/lucroFundo.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 300, 150);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMonthChooserMes.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("RELATÓRIO POR MÊS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jMonthChooserMes, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jYearChooserAno, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jYearChooserAno, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMonthChooserMes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(300, 68, 320, 102);

        jButton5.setText("Imprimir Relatório Para Médico");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(650, 550, 640, 41);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("RELATÓRIO POR MÉDICO");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(630, 70, 660, 100);

        jTextFieldTerceiro.setBackground(new java.awt.Color(204, 204, 255));
        jTextFieldTerceiro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldTerceiro);
        jTextFieldTerceiro.setBounds(790, 480, 190, 50);
        jPanel1.add(jTextFieldTranzacoes);
        jTextFieldTranzacoes.setBounds(130, 480, 190, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("TRANZAÇÕES");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 500, 98, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("VALOR PAGO");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(350, 500, 93, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("TERCEIRO");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(680, 500, 75, 17);

        jTextField4.setBackground(new java.awt.Color(0, 255, 204));
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(460, 480, 190, 50);

        jTextFieldLucro.setBackground(new java.awt.Color(153, 255, 255));
        jTextFieldLucro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldLucro);
        jTextFieldLucro.setBounds(1100, 480, 190, 50);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("LUCRO");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(1010, 500, 49, 17);

        jButton6.setText("Imprimir Relatório de Lucro");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(10, 550, 630, 41);

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonFechar);
        jButtonFechar.setBounds(1240, 0, 60, 39);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1300, 600);

        setSize(new java.awt.Dimension(1300, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

         Date dataRealizar;
        dataRealizar = jDateChooser1.getDate();

        if (dataRealizar == null) {

            JOptionPane.showMessageDialog(rootPane, "Por Favor! Digite uma Data Para Busca!");

        }else{
        
            
                Date dataRealizarB = jDateChooser1.getDate();
          SimpleDateFormat farmato = new SimpleDateFormat("dd/MM/yyyy");
                       String dataBanco = farmato.format(dataRealizarB);
                       
                       System.out.println("------- 01"+dataBanco);
                       String tipo = "ATIVO";
                       
                       listarFluxoDia(tipo, dataBanco);
        
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        int month,year= 0;
          
 month = jMonthChooserMes.getMonth();
 year = jYearChooserAno.getYear();
 

 month = month + 01;

         String a = Integer.toString(month);
             String d = "/";
                String b = Integer.toString(year);
                     String c = a+d+b;
                           String dataBanco = c;
                           
                           String tipo = "ATIVO";
                           
                           listarFluxoDia(tipo, dataBanco);
                           
                           
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        
          
        String validar = jTextFieldTranzacoes.getText();
        
        if (validar.equals("")) {
            
        JOptionPane.showMessageDialog(rootPane, "Faça uma Busca para Imprimir!");
            
            
        }else{
        
        
            String tranzacoes = jTextFieldTranzacoes.getText();
        String somaTerceiro = jTextFieldTerceiro.getText();
        
        
         List lista = new ArrayList();
                
                for (int i = 0; i < jTableFluxo.getRowCount(); i++) {
            
                    IrreporterRelatorioCaixa relatorio = new IrreporterRelatorioCaixa(jTableFluxo.getValueAt(i, 0).toString(),jTableFluxo.getValueAt(i, 1).toString(),jTableFluxo.getValueAt(i, 2).toString(),jTableFluxo.getValueAt(i, 3).toString(),jTableFluxo.getValueAt(i, 4).toString(),jTableFluxo.getValueAt(i, 5).toString(),jTableFluxo.getValueAt(i, 6).toString(),jTableFluxo.getValueAt(i, 7).toString(),jTableFluxo.getValueAt(i, 8).toString(),tranzacoes,somaTerceiro);
                    lista.add(relatorio);
        }
        
                
               
                
 


          
             


             
               try {
                    
                      Map parametros = new HashMap();  
  parametros.put("Titulo", "Relatório de Consultas do dia "+"");
          JasperPrint print = JasperFillManager.fillReport("C:/Users/Franciosney Souza/Documents/NetBeansProjects/auroClin/RelatoriosProntos/RelatorioCaixa.jasper", 
                    parametros,new JRBeanCollectionDataSource(lista));
            
            JasperViewer  vj = new JasperViewer(print,false);
            vj.setVisible(true);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
   
   
        
        
        
        }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        
        
         

        
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        
        Date dataRealizar;
        dataRealizar = jDateChooser1.getDate();
  

        if (dataRealizar == null ) {

         
            int month,year= 0;
          
 month = jMonthChooserMes.getMonth();
 year = jYearChooserAno.getYear();
 

 month = month + 01;

         String a = Integer.toString(month);
             String d = "/";
                String b = Integer.toString(year);
                     String c = a+d+b;
                           String dataBanco = c;
                           
                           String tipo = "ATIVO";
                           
                           listarFluxoDia(tipo, dataBanco);
                           
            
            

        } else {
            
            Date dataRealizarB = jDateChooser1.getDate();
          SimpleDateFormat farmato = new SimpleDateFormat("dd/MM/yyyy");
                       String dataBanco = farmato.format(dataRealizarB);
                       
                       System.out.println("------- 01"+dataBanco);
                       String tipo = "ATIVO";
                       
                       listarFluxoDia(tipo, dataBanco);
           
        }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        
        
        String validar = jTextFieldTranzacoes.getText();
        
        if (validar.equals("")) {
            
        JOptionPane.showMessageDialog(rootPane, "Faça uma Busca para Imprimir!");
            
            
        }else{
        
            
            
        
        String tranzacoes = jTextFieldTranzacoes.getText();
        String somaLucro=  jTextFieldLucro.getText();
        
        
  
             List lista = new ArrayList();
                
                for (int i = 0; i < jTableFluxo.getRowCount(); i++) {
            
                    IrreporterRelatorioCaixa relatorio = new IrreporterRelatorioCaixa(jTableFluxo.getValueAt(i, 0).toString(),jTableFluxo.getValueAt(i, 1).toString(),jTableFluxo.getValueAt(i, 2).toString(),jTableFluxo.getValueAt(i, 3).toString(),jTableFluxo.getValueAt(i, 4).toString(),jTableFluxo.getValueAt(i, 5).toString(),jTableFluxo.getValueAt(i, 6).toString(),jTableFluxo.getValueAt(i, 7).toString(),jTableFluxo.getValueAt(i, 8).toString(),tranzacoes,somaLucro);
                    lista.add(relatorio);
        }
        
                

             
               try {
                    
             
            
               
                      Map parametros = new HashMap();  
  parametros.put("Titulo", "Relatório de Consultas do Mês 0"+somaLucro);
          JasperPrint print = JasperFillManager.fillReport("C:/Users/Franciosney Souza/Documents/NetBeansProjects/auroClin/RelatoriosProntos/relatorioLucro.jasper", 
                    parametros,new JRBeanCollectionDataSource(lista));
            
            JasperViewer  vj = new JasperViewer(print,false);
            vj.setVisible(true);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
   
   
            
            
            
        
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonFechar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooserMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFluxo;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldLucro;
    private javax.swing.JTextField jTextFieldTerceiro;
    private javax.swing.JTextField jTextFieldTranzacoes;
    private com.toedter.calendar.JYearChooser jYearChooserAno;
    // End of variables declaration//GEN-END:variables
}
