/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.ConsultaDAO;
import DAO.MarcarDAO;
import DAO.MedicoDAO;
import br.auroClin.model.Consulta;
import br.auroClin.model.Marcar;
import br.auroClin.model.Medico;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Franciosney Souza
 */
public class DataConsulta extends javax.swing.JFrame {

    /**
     * Creates new form DataConsulta
     */
    
     public void buscaAvancadaConsultas(){
    
        
        String dataBusca = jTextFieldData.getText();
        String nomeExame = jTextFieldNomeExameBusca.getText();
        String nomeMedico = jTextFieldNomeMedicoBusca.getText();
        String forma = jTextFieldFormaBusca.getText();


   SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
          

            try {

                MarcarDAO dao = new MarcarDAO();
                List<Marcar> listadeDatas =  dao.listaDatasConsultasPorData(nomeExame, nomeMedico, dataBusca, forma);

                DefaultTableModel modelo = (DefaultTableModel)jTableDatasExames.getModel();
                modelo.setNumRows(0);

                int i = 0;
                for(Marcar obm: listadeDatas){
                    modelo.addRow(new String[i]);
                    
                    
                    
                  DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
             
    Date dt1 = df.parse (obm.getDataFazer());
        Date dt2 = df.parse (dataAtual);
   
    //if(dt2.after(dt1))
        if(dt2.after(dt1)) {
            System.err.println("Essa Data Ja passou "+obm.getDataFazer());
        } else{
        
        
        
        
        }
                    
                    
                    jTableDatasExames.setValueAt(obm.getId_marcar(), i, 0);

                    // Convertendo datas para jogar na tabela

                    String dataBancoVindo = obm.getDataFazer();
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = (Date)formatter.parse(dataBancoVindo);
                    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");

                    // Finalizanto e jogando na tabela
                   jTableDatasExames.setValueAt(obm.getNomeParaJoin(), i, 1);
jTableDatasExames.setValueAt(obm.getNomeMedico(), i, 2);
jTableDatasExames.setValueAt(formatoRetorno.format(date), i, 3);
jTableDatasExames.setValueAt(obm.getAgendar(), i, 4);

                    i++;

                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(rootPane, "Erro"+e);
            }

       
    
    }
    
public void CorTabela(){
   
          
jTableDatasExames.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    

  
     private final String CLASSSS = "AGENDA";
   
     @Override
    public JLabel getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, 
            int row, int column)
    {
        
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        
        Color c = Color.WHITE;
        
        Object testo = jTableDatasExames.getValueAt(row, 4);
     
         
          
          if (testo != null && CLASSSS.equals(testo.toString())){
         
         c = new java.awt.Color(255, 255, 51);
     
             
         }
        

                label.setBackground(c);
                 jTableDatasExames.setSelectionForeground(Color.RED);
                 
        
         return label;
    }

    
});
   
   }
     public void ultimosMedicosCadastradis(){
    
        
       
        try {

            MedicoDAO daom = new MedicoDAO();
            List<Medico> listaMedico = daom.listarUltimosMEdicos();

            DefaultTableModel modelo = (DefaultTableModel)jTableMedico.getModel();
            modelo.setNumRows(0);

          

            int i = 0;
            for(Medico objp: listaMedico){
                modelo.addRow(new String[i]);
                jTableMedico.setValueAt(objp.getId_medico(), i, 0);
                 jTableMedico.setValueAt(objp.getNomeMedico(), i, 1);
                 jTableMedico.setValueAt(objp.getEspecializacao(), i, 2);
            
                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
       

       
        
        
    
    
    }
    
    
    public void buscarMedico(){
    
    
        
           String nome = jTextFieldBuscaMedico.getText();
        try {

            MedicoDAO daom = new MedicoDAO();
            List<Medico> listaMedico = daom.listarMedicoPorNome(nome);

            DefaultTableModel modelo = (DefaultTableModel)jTableMedico.getModel();
            modelo.setNumRows(0);

          

            int i = 0;
            for(Medico objp: listaMedico){
                modelo.addRow(new String[i]);
                jTableMedico.setValueAt(objp.getId_medico(), i, 0);
                 jTableMedico.setValueAt(objp.getNomeMedico(), i, 1);
                 jTableMedico.setValueAt(objp.getEspecializacao(), i, 2);
            
                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
       
    }
    
    
    CadastrarConsulta cadConsulta;
    public DataConsulta() {
        initComponents();
        
   
           
 JTableHeader headerMarcados =  jTableDatasExames.getTableHeader();   
    headerMarcados .setPreferredSize(new Dimension(0, 25)); 
    headerMarcados .setFont(new Font("��������", Font.PLAIN, 14));
	headerMarcados .setPreferredSize(new Dimension(headerMarcados .getWidth(),25));
               jTableDatasExames.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableDatasExames.getColumnModel().getColumn(0).setPreferredWidth(60);
jTableDatasExames.getColumnModel().getColumn(1).setPreferredWidth(240);
jTableDatasExames.getColumnModel().getColumn(2).setPreferredWidth(260);
jTableDatasExames.getColumnModel().getColumn(3).setPreferredWidth(100);
jTableDatasExames.getColumnModel().getColumn(4).setPreferredWidth(96);
jTableDatasExames.setRowHeight(20);  
    

        
        
        
               jTextFieldIdMedico.setEditable(false);
                   jTextFieldNomeMedico.setEditable(false);
                    jTextFieldEspecializacaoMedico.setEditable(false); 
                    
                    
                           JTableHeader headerMedico =  jTableMedico.getTableHeader();   
    headerMedico.setPreferredSize(new Dimension(0, 25)); 
    headerMedico.setFont(new Font("��������", Font.PLAIN, 14));
	headerMedico.setPreferredSize(new Dimension(headerMedico.getWidth(),25));
                   jTableMedico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableMedico.getColumnModel().getColumn(0).setPreferredWidth(40);
jTableMedico.getColumnModel().getColumn(1).setPreferredWidth(270);
jTableMedico.getColumnModel().getColumn(2).setPreferredWidth(155);
jTableMedico.setRowHeight(20);  

       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonMinimizar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxConsultas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldIdConsulta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNomeConsulta = new javax.swing.JTextField();
        jTextFieldValorConsulta = new javax.swing.JTextField();
        jComboBoxTipodeConsulta = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDateChooserDataMarcar = new com.toedter.calendar.JDateChooser();
        jDateChooserDataFazer = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldIdMedico = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldNomeMedico = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldEspecializacaoMedico = new javax.swing.JTextField();
        jTextFieldBuscaMedico = new javax.swing.JTextField();
        jButtonBuscarPaciente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMedico = new javax.swing.JTable();
        jButtonSalvar1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDatasExames = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldFormaBusca = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldNomeExameBusca = new javax.swing.JTextField();
        jTextFieldNomeMedicoBusca = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextFieldData = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jButtonMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (1).png"))); // NOI18N
        jButtonMinimizar.setToolTipText("Minimizar");
        jButtonMinimizar.setName(""); // NOI18N
        jButtonMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMinimizar);
        jButtonMinimizar.setBounds(1250, 10, 50, 40);

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFechar);
        jButtonFechar.setBounds(1300, 10, 50, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("    DATAS DE CONSULTAS");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(470, 10, 380, 41);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data para Consultas"));

        jComboBoxConsultas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxConsultasItemStateChanged(evt);
            }
        });
        jComboBoxConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxConsultasActionPerformed(evt);
            }
        });

        jLabel3.setText("Selecione Uma Consulta");

        jTextFieldIdConsulta.setEnabled(false);

        jLabel6.setText("ID:");

        jTextFieldNomeConsulta.setEnabled(false);

        jTextFieldValorConsulta.setEnabled(false);

        jComboBoxTipodeConsulta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxTipodeConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Principal", "Agenda" }));
        jComboBoxTipodeConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipodeConsultaActionPerformed(evt);
            }
        });

        jLabel12.setText("Data para Realizar Consulta");

        jLabel13.setText("Forma:");

        jLabel20.setText("Data para Marcar Consulta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jComboBoxConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldIdConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNomeConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValorConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jDateChooserDataMarcar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jDateChooserDataFazer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipodeConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxConsultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldNomeConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldValorConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldIdConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserDataMarcar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserDataFazer, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTipodeConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione um Médico"));

        jLabel9.setText("ID:");

        jTextFieldIdMedico.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldIdMedico.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldIdMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdMedicoActionPerformed(evt);
            }
        });

        jLabel10.setText("NOME DO MÉDICO:");

        jTextFieldNomeMedico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldNomeMedico.setForeground(new java.awt.Color(0, 51, 102));

        jLabel16.setText("ESPECIALIZAÇÃO:");

        jTextFieldEspecializacaoMedico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldEspecializacaoMedico.setForeground(new java.awt.Color(0, 51, 102));

        jTextFieldBuscaMedico.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldBuscaMedico.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldBuscaMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaMedicoKeyPressed(evt);
            }
        });

        jButtonBuscarPaciente.setText("Buscar Médico");
        jButtonBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPacienteActionPerformed(evt);
            }
        });

        jTableMedico.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTableMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Especialização"
            }
        ));
        jTableMedico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMedicoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableMedico);

        jButtonSalvar1.setBackground(new java.awt.Color(153, 153, 255));
        jButtonSalvar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSalvar1.setText("SALVAR DATA NO SISTEMA");
        jButtonSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldIdMedico))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextFieldNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextFieldBuscaMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBuscarPaciente))
                            .addComponent(jTextFieldEspecializacaoMedico)
                            .addComponent(jButtonSalvar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldNomeMedico)
                    .addComponent(jTextFieldIdMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEspecializacaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldBuscaMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalvar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Exames Listados por Datas"));

        jTableDatasExames.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTableDatasExames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID ", "Consulta:", "Médico:", "Realização:", "Forma:"
            }
        ));
        jTableDatasExames.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableDatasExames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDatasExamesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableDatasExames);

        jButton1.setText("Buscar Exame");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel14.setText("DATA:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Relação de Datas Salvas no Sistema");

        jTextFieldFormaBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldFormaBuscaKeyPressed(evt);
            }
        });

        jLabel17.setText("FORMA:");

        jTextFieldNomeExameBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeExameBuscaKeyPressed(evt);
            }
        });

        jTextFieldNomeMedicoBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeMedicoBuscaKeyPressed(evt);
            }
        });

        jLabel18.setText("EXAME");

        jLabel19.setText("MÉDICO");

        jButton2.setText("Imprimir");

        jButton3.setText("Editar");

        jButton4.setText("Deleta");

        jTextFieldData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDataKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel18)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldNomeExameBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeMedicoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldFormaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(83, 83, 83)
                                .addComponent(jLabel14)
                                .addGap(188, 188, 188))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNomeExameBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldFormaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldNomeMedicoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(10, 70, 1330, 620);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/fundoConsulta.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1350, 700);

        setSize(new java.awt.Dimension(1350, 700));
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       
           
        try {
            
            ConsultaDAO daocon = new ConsultaDAO();
            List<Consulta> lista = daocon.BuscarConsultaParaComobox();
          
            for(Consulta objc: lista){
            
                jComboBoxConsultas.addItem(objc.getNomeConsulta());
             
            
            }
               jComboBoxConsultas.addItem("CADASTRAR NOVA CONSULTA");
        } catch (Exception e) {
        }
        
        
        
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
          // TODO add your handling code here:
        
              

 
CorTabela();
        

       
        ultimosMedicosCadastradis();
        
        
        
               SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
          
        
        
       
                ultimosMedicosCadastradis();

        try {
            
            MarcarDAO dao = new MarcarDAO();
            List<Marcar> listadeDatas =  dao.listaDatasConsultas();
            
            DefaultTableModel modelo = (DefaultTableModel)jTableDatasExames.getModel();
            modelo.setNumRows(0);
            
            
            
               int i = 0;
            for(Marcar obm: listadeDatas){
                
                
       
                
        
                  DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
             
    Date dt1 = df.parse (obm.getDataFazer());
        Date dt2 = df.parse (dataAtual);
   
    //if(dt2.after(dt1))
        if(dt2.after(dt1)) {
            System.err.println("Essa Data Ja passou "+obm.getDataFazer());
        } else {
           
modelo.addRow(new String[i]);
jTableDatasExames.setValueAt(obm.getId_marcar(), i, 0);

// Convertendo datas para jogar na tabela

  String dataBanco = obm.getDataFazer();
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(dataBanco);  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");    
    
    // Finalizanto e jogando na tabela
jTableDatasExames.setValueAt(obm.getNomeParaJoin(), i, 1);
jTableDatasExames.setValueAt(obm.getNomeMedico(), i, 2);
jTableDatasExames.setValueAt(formatoRetorno.format(date), i, 3);
jTableDatasExames.setValueAt(obm.getAgendar(), i, 4);



          
            i++;
            
            }
             
             
             
             
        }
                
    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_formWindowActivated

    private void jButtonSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvar1ActionPerformed
        // TODO add your handling code here:

        Date dataMarcar,dataRealizar = null;
        String dataBanco,dataMarcarBanco;
        
        dataMarcar = jDateChooserDataMarcar.getDate();
        dataRealizar = jDateChooserDataFazer.getDate();

        String tipoConsulta = (String) jComboBoxTipodeConsulta.getSelectedItem();
        
        String nomeMedico = jTextFieldNomeMedico.getText();
      
         

        if (dataRealizar == null) {

            JOptionPane.showMessageDialog(rootPane, "A data para realização a Consulta é Obrigatória!");

        }else if(dataMarcar == null){

            JOptionPane.showMessageDialog(rootPane, "A data para o paciente ir marcar a Consulta é Obrigatória!");

        }else if(nomeMedico.equals("")){

            JOptionPane.showMessageDialog(rootPane, "Selecione um Médico na tabela Abaixo");

        } 
 
         else{
            
            
            
            

            SimpleDateFormat farmatoData = new SimpleDateFormat("dd/MM/yyyy");
            dataBanco = farmatoData.format(dataRealizar);
            dataMarcarBanco = farmatoData.format(dataMarcar);

            Marcar objm = new Marcar();
            int idconsulta = Integer.parseInt(jTextFieldIdConsulta.getText());
            System.out.println(idconsulta);
            objm.setId_consulta(idconsulta);
            objm.setDataFazer(dataBanco);
            objm.setDataAbrir(dataMarcarBanco);
            objm.setAgendar(tipoConsulta);
            objm.setId_medico(Integer.parseInt(jTextFieldIdMedico.getText()));

            try {
                
                
                   SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
          
            
             DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
             
    Date dt1 = dataRealizar;
        Date dt2 = df.parse (dataAtual);
   
    //if(dt2.after(dt1))
        if(dt2.after(dt1)) {
        
            
             JOptionPane.showMessageDialog(rootPane, "A data para Realizar o Exame ja Passou, Escolha outra Data");
            
             jDateChooserDataFazer.setBackground(new java.awt.Color(255, 0, 0));
            
            
        } else {
          
               int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this, "Deseja Marcar esta Data?", "Title on Box", dialogButton);
if(dialogResult == 0) {
             
               MarcarDAO daomar = new MarcarDAO();
                daomar.cadastrarMarcar(objm);

                JOptionPane.showMessageDialog(null, "Data Inserida Com Sucesso!");

                jDateChooserDataFazer.setDate(null);
                jTextFieldIdMedico.setText("");
 jTextFieldNomeMedico.setText("");
 jTextFieldEspecializacaoMedico.setText("");
                jDateChooserDataMarcar.setDate(null);
               
                
}else{

 JOptionPane.showMessageDialog(null, "Você Não Marcou!");
 
 jTextFieldIdMedico.setText("");
 jTextFieldNomeMedico.setText("");
 jTextFieldEspecializacaoMedico.setText("");
 jDateChooserDataFazer.setDate(null);
   jDateChooserDataMarcar.setDate(null);

}
             
        }
                
                

              

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Erro ao Inserir Data!"+e);
            }

        }

    }//GEN-LAST:event_jButtonSalvar1ActionPerformed

    private void jTableMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMedicoMouseClicked
        // TODO add your handling code here:

        //---- Controlando Clique na tabela

        jTableMedico.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel
        jTableMedico.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {

                    //JOptionPane.showMessageDialog(null, "Você não Pode Editar! Não Insista");
                }
            }
        });
        // ---------- Fim

        jTextFieldIdMedico.setText(jTableMedico.getValueAt(jTableMedico.getSelectedRow(), 0).toString());
        jTextFieldNomeMedico.setText(jTableMedico.getValueAt(jTableMedico.getSelectedRow(), 1).toString());
        jTextFieldEspecializacaoMedico.setText(jTableMedico.getValueAt(jTableMedico.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_jTableMedicoMouseClicked

    private void jButtonBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPacienteActionPerformed
        // TODO add your handling code here:

        buscarMedico();
    }//GEN-LAST:event_jButtonBuscarPacienteActionPerformed

    private void jTextFieldBuscaMedicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaMedicoKeyPressed
        // TODO add your handling code here:
        buscarMedico();
    }//GEN-LAST:event_jTextFieldBuscaMedicoKeyPressed

    private void jTextFieldIdMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdMedicoActionPerformed

    private void jComboBoxTipodeConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipodeConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipodeConsultaActionPerformed

    private void jComboBoxConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxConsultasActionPerformed

    private void jComboBoxConsultasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxConsultasItemStateChanged
        // TODO add your handling code here:

        String nome = (String) jComboBoxConsultas.getSelectedItem();

        if (nome == "CADASTRAR NOVA CONSULTA") {

            if (cadConsulta == null) {

                cadConsulta = new CadastrarConsulta();
                cadConsulta.setLocationRelativeTo(null);
            }

            cadConsulta.setVisible(true);
            dispose();

        }

        try {

            ConsultaDAO daoc = new ConsultaDAO();
            List<Consulta> listaConsulta = daoc.listarConsultaPorNome(nome);

            NumberFormat nf = NumberFormat.getCurrencyInstance();

            for(Consulta obc: listaConsulta){
                jTextFieldIdConsulta.setText(String.valueOf(obc.getId_consulta()));
                jTextFieldNomeConsulta.setText(obc.getNomeConsulta());
                jTextFieldValorConsulta.setText(nf.format(obc.getValorConsulta()));

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro colocar exame na caixa"+e);
        }

    }//GEN-LAST:event_jComboBoxConsultasItemStateChanged

    private void jTableDatasExamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDatasExamesMouseClicked
        // TODO add your handling code here:

        jTableDatasExames.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel
        jTableDatasExames.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {

                    //JOptionPane.showMessageDialog(null, "Você não Pode Editar! Não Insista");
                }
            }
        });

    }//GEN-LAST:event_jTableDatasExamesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       buscaAvancadaConsultas();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldFormaBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFormaBuscaKeyPressed
        // TODO add your handling code here:

        buscaAvancadaConsultas();
    }//GEN-LAST:event_jTextFieldFormaBuscaKeyPressed

    private void jTextFieldNomeExameBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameBuscaKeyPressed
        // TODO add your handling code here:

       buscaAvancadaConsultas();

    }//GEN-LAST:event_jTextFieldNomeExameBuscaKeyPressed

    private void jTextFieldNomeMedicoBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeMedicoBuscaKeyPressed
        // TODO add your handling code here:

        buscaAvancadaConsultas();
    }//GEN-LAST:event_jTextFieldNomeMedicoBuscaKeyPressed

    private void jTextFieldDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDataKeyPressed
        // TODO add your handling code here:
       buscaAvancadaConsultas();
    }//GEN-LAST:event_jTextFieldDataKeyPressed

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
            java.util.logging.Logger.getLogger(DataConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonBuscarPaciente;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JButton jButtonSalvar1;
    private javax.swing.JComboBox<String> jComboBoxConsultas;
    private javax.swing.JComboBox<String> jComboBoxTipodeConsulta;
    private com.toedter.calendar.JDateChooser jDateChooserDataFazer;
    private com.toedter.calendar.JDateChooser jDateChooserDataMarcar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDatasExames;
    private javax.swing.JTable jTableMedico;
    private javax.swing.JTextField jTextFieldBuscaMedico;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldEspecializacaoMedico;
    private javax.swing.JTextField jTextFieldFormaBusca;
    private javax.swing.JTextField jTextFieldIdConsulta;
    private javax.swing.JTextField jTextFieldIdMedico;
    private javax.swing.JTextField jTextFieldNomeConsulta;
    private javax.swing.JTextField jTextFieldNomeExameBusca;
    private javax.swing.JTextField jTextFieldNomeMedico;
    private javax.swing.JTextField jTextFieldNomeMedicoBusca;
    private javax.swing.JTextField jTextFieldValorConsulta;
    // End of variables declaration//GEN-END:variables
}
