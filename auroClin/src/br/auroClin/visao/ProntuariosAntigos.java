/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.ConsultaDAO;
import DAO.ExameDAO;
import DAO.FuncionarioDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.ProntuarioDAO;
import br.auroClin.model.Consulta;
import br.auroClin.model.ControleLog;
import br.auroClin.model.Exame;
import br.auroClin.model.Funcionario;
import br.auroClin.model.Medico;
import br.auroClin.model.Paciente;
import br.auroClin.model.ProntuarioModelo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Franciosney Souza
 */
public class ProntuariosAntigos extends javax.swing.JFrame {

    /**
     * Creates new form ProntuariosAntigos
     */
    
    
    
    
    
    public void buscarPAcientes(){
    
    
           String nome = jTextFieldBuscarPaciente.getText();
        try {

            PacienteDAO daop = new PacienteDAO();
            List<Paciente> listaPaciente = daop.listarPacientePorNome(nome);

            DefaultTableModel modelo = (DefaultTableModel)jTablePaciente.getModel();
            modelo.setNumRows(0);

          

            int i = 0;
            for(Paciente objp: listaPaciente){
                modelo.addRow(new String[i]);
                 jTablePaciente.setValueAt(objp.getId_paciente(), i, 0);
                 jTablePaciente.setValueAt(objp.getNome_paciente(), i, 1);
                 jTablePaciente.setValueAt(objp.getCpf(), i, 2);
               
             
           
                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
    }
    
    
    
    
    
    public void buscarMedico(){
    
    
        
           String nome = jTextFieldBuscarMedico.getText();
        try {

            MedicoDAO daom = new MedicoDAO();
            List<Medico> listaMedico = daom.listarMedicoPorNome(nome);

            DefaultTableModel modelo = (DefaultTableModel)jTableHistorico1.getModel();
            modelo.setNumRows(0);

          

            int i = 0;
            for(Medico objp: listaMedico){
                modelo.addRow(new String[i]);
                jTableHistorico1.setValueAt(objp.getId_medico(), i, 0);
                 jTableHistorico1.setValueAt(objp.getNomeMedico(), i, 1);
                 jTableHistorico1.setValueAt(objp.getEspecializacao(), i, 2);
            
                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
       
    }
        
    
    
    
    
    public ProntuariosAntigos() {
        initComponents();
        
        
        
                     
 JTableHeader headerPaciente = jTablePaciente.getTableHeader();   
    headerPaciente.setPreferredSize(new Dimension(0, 25)); 
    headerPaciente.setFont(new Font("��������", Font.PLAIN, 14));
	headerPaciente.setPreferredSize(new Dimension(headerPaciente.getWidth(),25));
 jTablePaciente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(40);
jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(210);
jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(120);


jTablePaciente.setRowHeight(20); 

        
        
                     
 JTableHeader headerMedico = jTableHistorico1.getTableHeader();   
    headerMedico.setPreferredSize(new Dimension(0, 25)); 
    headerMedico.setFont(new Font("��������", Font.PLAIN, 14));
	headerMedico.setPreferredSize(new Dimension(headerMedico.getWidth(),25));
jTableHistorico1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableHistorico1.getColumnModel().getColumn(0).setPreferredWidth(40);
jTableHistorico1.getColumnModel().getColumn(1).setPreferredWidth(210);
jTableHistorico1.getColumnModel().getColumn(2).setPreferredWidth(120);
jTableHistorico1.setRowHeight(20); 

        
        jTextAreaDescricao.setLineWrap(true);
        jTextAreaDescricao.setMargin(new Insets(20, 20, 20, 20));
        jTextAreaSintomas.setLineWrap(true);
        jTextAreaSintomas.setMargin(new Insets(20, 20, 20, 20));
        jTextAreaDescricao.setFont(new Font("Monospaced", 0, 20));
        jTextAreaSintomas.setFont(new Font("Monospaced", 0, 20));

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldExames = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxExames = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxConsultas = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldBuscarPaciente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldBuscarMedico = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableHistorico1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldIdPaciente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldIdNomePaciente = new javax.swing.JTextField();
        jTextFieldNomeServico = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldIdDiagnostico = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaSintomas = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jTextFieldNomeMedico = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldidMedico = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButtonFechar1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Novo Prontuário"));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 2, true));

        jTextFieldExames.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldExames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldExamesActionPerformed(evt);
            }
        });
        jTextFieldExames.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldExamesKeyPressed(evt);
            }
        });

        jLabel11.setText("Serviço Selecionado");

        jComboBoxExames.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBoxExames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxExamesItemStateChanged(evt);
            }
        });

        jLabel14.setText("Selecione Um Exame");

        jComboBoxConsultas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBoxConsultas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxConsultasItemStateChanged(evt);
            }
        });

        jLabel15.setText("Selecione Uma Consulta");

        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("                    BUSCAR PACIENTE");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextFieldBuscarPaciente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldBuscarPaciente.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarPacienteActionPerformed(evt);
            }
        });
        jTextFieldBuscarPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarPacienteKeyPressed(evt);
            }
        });

        jButton1.setText("Buscar Paciente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTablePaciente.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF"
            }
        ));
        jTablePaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTablePaciente);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("       SELECIONE UM EXAME/CONSULTA");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setText("Selecione Uma Data");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("                SELECIONE UM MÉDICO");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextFieldBuscarMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarMedicoKeyPressed(evt);
            }
        });

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTableHistorico1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTableHistorico1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Médico", "DataCRM"
            }
        ));
        jTableHistorico1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableHistorico1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHistorico1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableHistorico1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxExames, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(157, 157, 157)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxConsultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldExames, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldBuscarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldExames, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxExames, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldBuscarMedico)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("                   PRONTUARIO MÉDICO ANTIGO");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Id - P");

        jTextFieldIdPaciente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldIdPaciente.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldIdPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdPacienteActionPerformed(evt);
            }
        });
        jTextFieldIdPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldIdPacienteKeyPressed(evt);
            }
        });

        jLabel7.setText("Nome do Paciente");

        jTextFieldIdNomePaciente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldIdNomePaciente.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldIdNomePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdNomePacienteActionPerformed(evt);
            }
        });
        jTextFieldIdNomePaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldIdNomePacienteKeyPressed(evt);
            }
        });

        jTextFieldNomeServico.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldNomeServico.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldNomeServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeServicoActionPerformed(evt);
            }
        });
        jTextFieldNomeServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeServicoKeyPressed(evt);
            }
        });

        jLabel8.setText("Serviço");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("DIAGNOSTICO");

        jTextFieldIdDiagnostico.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldIdDiagnostico.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldIdDiagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdDiagnosticoActionPerformed(evt);
            }
        });
        jTextFieldIdDiagnostico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldIdDiagnosticoKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("SINTOMAS");

        jTextAreaSintomas.setColumns(20);
        jTextAreaSintomas.setRows(5);
        jScrollPane2.setViewportView(jTextAreaSintomas);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("DESCRIÇÃO");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane4.setViewportView(jTextAreaDescricao);

        jTextFieldNomeMedico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("MÉDICO");

        jTextFieldidMedico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("ID");

        jButtonFechar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar1.setToolTipText("Fechar");
        jButtonFechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFechar1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/CadastrarProntuario.png"))); // NOI18N
        jButton2.setText("     CADASTRAR PRONTUÁRIO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFieldIdDiagnostico))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextFieldIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(219, 219, 219))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldIdNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeServico))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldidMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(255, 255, 255)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(545, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonFechar1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jButtonFechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(9, 9, 9)
                        .addComponent(jTextFieldIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTextFieldNomeServico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldIdNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldIdDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldidMedico)
                    .addComponent(jTextFieldNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 0, 1300, 700);

        setSize(new java.awt.Dimension(1300, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableHistorico1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistorico1MouseClicked
        // TODO add your handling code here:
        
      
        jTableHistorico1.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel
        jTableHistorico1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {

                }
            }
        });
        // ---------- Fim   
        

String nomeMedico = jTableHistorico1.getValueAt(jTableHistorico1.getSelectedRow(), 1).toString();
jTextFieldNomeMedico.setText(nomeMedico);
jTextFieldNomeMedico.setEnabled(false);
jTextFieldNomeMedico.setBorder(BorderFactory.createLineBorder(Color.blue));
jTextFieldidMedico.setText(jTableHistorico1.getValueAt(jTableHistorico1.getSelectedRow(), 0).toString());
jTextFieldidMedico.setEnabled(false);
jTextFieldidMedico.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        
    }//GEN-LAST:event_jTableHistorico1MouseClicked

    private void jTextFieldBuscarMedicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarMedicoKeyPressed
        // TODO add your handling code here:

        buscarMedico();

    }//GEN-LAST:event_jTextFieldBuscarMedicoKeyPressed

    private void jComboBoxConsultasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxConsultasItemStateChanged
        // TODO add your handling code here:

        String nome = (String) jComboBoxConsultas.getSelectedItem();

        jTextFieldExames.setText(nome);
        jTextFieldNomeServico.setText(nome);
        jTextFieldNomeServico.setEnabled(false);
        jTextFieldNomeServico.setBorder(BorderFactory.createLineBorder(Color.blue));
        jTextFieldExames.setBorder(BorderFactory.createLineBorder(Color.green));
        jComboBoxConsultas.setBorder(BorderFactory.createLineBorder(Color.green));

    }//GEN-LAST:event_jComboBoxConsultasItemStateChanged

    private void jComboBoxExamesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxExamesItemStateChanged
        // TODO add your handling code here:

        String nome = (String) jComboBoxExames.getSelectedItem();
        jTextFieldExames.setText(nome);
         jTextFieldNomeServico.setText(nome);
         jTextFieldNomeServico.setEnabled(false);
        jTextFieldNomeServico.setBorder(BorderFactory.createLineBorder(Color.blue));
        jTextFieldExames.setBorder(BorderFactory.createLineBorder(Color.blue));
        jComboBoxExames.setBorder(BorderFactory.createLineBorder(Color.blue));
    }//GEN-LAST:event_jComboBoxExamesItemStateChanged

    private void jTextFieldExamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldExamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldExamesActionPerformed

    private void jTextFieldExamesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldExamesKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldExamesKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        
        
           try {
            
            ExameDAO daoexCom = new ExameDAO();
            List<Exame> lista = daoexCom.BuscarExamesParaComobox();
          
            for(Exame ex: lista){
            
                jComboBoxExames.addItem(ex.getNomeExame());
            
            }
            
        } catch (Exception e) {
        }
           
           
           
              
        try {
            
            ConsultaDAO daocon = new ConsultaDAO();
            List<Consulta> lista = daocon.BuscarConsultaParaComobox();
          
            for(Consulta objc: lista){
            
                jComboBoxConsultas.addItem(objc.getNomeConsulta());
             
            
            }
               
        } catch (Exception e) {
        }
        
           
           
           
        
    }//GEN-LAST:event_formWindowActivated

    private void jTextFieldBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarPacienteActionPerformed

    private void jTextFieldBuscarPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarPacienteKeyPressed
        // TODO add your handling code here:

        buscarPAcientes();
    }//GEN-LAST:event_jTextFieldBuscarPacienteKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        buscarPAcientes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked
        // TODO add your handling code here:
       
        jTablePaciente.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel
        jTablePaciente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {

                }
            }
        });
        // ---------- Fim

String nomePaciente = jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 1).toString();

jTextFieldIdNomePaciente.setText(nomePaciente);
jTextFieldIdNomePaciente.setEnabled(false);
jTextFieldIdNomePaciente.setBorder(BorderFactory.createLineBorder(Color.blue));
jTextFieldIdPaciente.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0).toString());
jTextFieldIdPaciente.setEnabled(false);
jTextFieldIdPaciente.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        

    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jTextFieldIdPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdPacienteActionPerformed

    private void jTextFieldIdPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdPacienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdPacienteKeyPressed

    private void jTextFieldIdNomePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdNomePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdNomePacienteActionPerformed

    private void jTextFieldIdNomePacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdNomePacienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdNomePacienteKeyPressed

    private void jTextFieldNomeServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeServicoActionPerformed

    private void jTextFieldNomeServicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeServicoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeServicoKeyPressed

    private void jTextFieldIdDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdDiagnosticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdDiagnosticoActionPerformed

    private void jTextFieldIdDiagnosticoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdDiagnosticoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdDiagnosticoKeyPressed

    private void jDateChooser1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyPressed
        // TODO add your handling code here:
    
        
    }//GEN-LAST:event_jDateChooser1KeyPressed

    private void jButtonFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFechar1ActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        
    }//GEN-LAST:event_jButtonFechar1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        Date dataRealizar;
        dataRealizar = jDateChooser1.getDate();

        
        if (jTextFieldIdPaciente.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um Paciente na Tabela");
            jTablePaciente.setBorder(BorderFactory.createLineBorder(Color.red));
        } else if(jTextFieldidMedico.getText().equals("")){
        
        JOptionPane.showMessageDialog(rootPane, "Selecione um Médico na Tabela");
        jTableHistorico1.setBorder(BorderFactory.createLineBorder(Color.red));
        
        } else if (dataRealizar == null) {
          
              JOptionPane.showMessageDialog(rootPane, "Selecione uma Data ao Lado");
        jDateChooser1.setBorder(BorderFactory.createLineBorder(Color.red));
            
            
        } else if (jTextFieldIdDiagnostico.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Digite um Diagnóstico para o Paciente");
        jTextFieldIdDiagnostico.setBorder(BorderFactory.createLineBorder(Color.red));
            
        } else if(jTextAreaSintomas.getText().equals("")){
        
             JOptionPane.showMessageDialog(rootPane, "Digite os sitomas do Paciente");
        jTextAreaSintomas.setBorder(BorderFactory.createLineBorder(Color.red));
        
        } else if(jTextAreaDescricao.getText().equals("")){
        
         JOptionPane.showMessageDialog(rootPane, "Digite uma Descrição para o Caso do Paciente");
        jTextAreaDescricao.setBorder(BorderFactory.createLineBorder(Color.red));
        
        } else{
            
            

        
        
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
        
            

             
             
            
            ControleLog ct = new ControleLog();
         String nomePaciente = jTextFieldIdNomePaciente.getText();
             int id_funcionario = ct.getId_funcionario();
        
             FuncionarioDAO daof = new FuncionarioDAO();
             
             
              List<Funcionario> funcionario = daof.listarFuncionarioPorID(id_funcionario);
String nome = null;

            for(Funcionario objp: funcionario){
            
                
            nome = objp.getNomeFuncionario();
            }
            
            
             
        int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this, nome+" Você deseja cadastrar Este Prontuário sem Altorização do Médico Para " + nomePaciente, "Title on Box", dialogButton);
if(dialogResult == 0) {

       ProntuarioModelo objp = new ProntuarioModelo();
    ControleLog ctr = new ControleLog();
    objp.setId_funcionario(ctr.getId_funcionario());
    objp.setId_paciente(Integer.parseInt(jTextFieldIdPaciente.getText()));
    objp.setId_medico(Integer.parseInt(jTextFieldidMedico.getText()));
    Date dataRealizarr = jDateChooser1.getDate();
    SimpleDateFormat farmato = new SimpleDateFormat("dd/MM/yyyy");
    String dataBancoo = farmato.format(dataRealizarr);
    objp.setServico(jTextFieldNomeServico.getText());
    objp.setData(dataBancoo);
    objp.setDiagnostico(jTextFieldIdDiagnostico.getText());
    objp.setSintomas(jTextAreaSintomas.getText());
    objp.setDescricao(jTextAreaDescricao.getText());
    objp.setResponsavel("ADM");
    ProntuarioDAO daop = new ProntuarioDAO();
    daop.cadastrarProntuario(objp);


        
        JOptionPane.showMessageDialog(rootPane, "Prontuário Cadastrado Com Sucesso");
        jTextFieldIdPaciente.setText("");
    jTextFieldIdNomePaciente.setText("");
    jTextFieldNomeServico.setText("");
    jTextFieldIdDiagnostico.setText("");
    jTextAreaSintomas.setText("");
    jTextAreaDescricao.setText("");
    jTextFieldidMedico.setText("");
    jTextFieldNomeMedico.setText("");
    jTextFieldBuscarMedico.setText("");
    jTextFieldBuscarPaciente.setText("");
    jDateChooser1.setDate(null);

    
    
    
}else{

    JOptionPane.showMessageDialog(rootPane, "Cadastro de Prontuário Cancelado");
    jTextFieldIdPaciente.setText("");
    jTextFieldIdNomePaciente.setText("");
    jTextFieldNomeServico.setText("");
    jTextFieldIdDiagnostico.setText("");
    jTextAreaSintomas.setText("");
    jTextAreaSintomas.setText("");
    jTextFieldidMedico.setText("");
    jTextFieldNomeMedico.setText("");
    jTextFieldBuscarMedico.setText("");
    jTextFieldBuscarPaciente.setText("");
    jDateChooser1.setDate(null);

}
             
             
             
             
             
             
            
        }else{
            
            
                        JOptionPane.showMessageDialog(rootPane, "A data não é antiga, Por favor informe outra data!");
            
             jDateChooser1.setBackground(new java.awt.Color(255, 0, 0));
             
            
            
            
        }
                    
                } catch (Exception e) {
                }
            
            
            
            
            
            
            
            
            
          

        
        
        }
        

       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        buscarMedico();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ProntuariosAntigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProntuariosAntigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProntuariosAntigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProntuariosAntigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProntuariosAntigos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonFechar1;
    private javax.swing.JComboBox<String> jComboBoxConsultas;
    private javax.swing.JComboBox<String> jComboBoxExames;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableHistorico1;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextArea jTextAreaSintomas;
    private javax.swing.JTextField jTextFieldBuscarMedico;
    private javax.swing.JTextField jTextFieldBuscarPaciente;
    private javax.swing.JTextField jTextFieldExames;
    private javax.swing.JTextField jTextFieldIdDiagnostico;
    private javax.swing.JTextField jTextFieldIdNomePaciente;
    private javax.swing.JTextField jTextFieldIdPaciente;
    private javax.swing.JTextField jTextFieldNomeMedico;
    private javax.swing.JTextField jTextFieldNomeServico;
    private javax.swing.JTextField jTextFieldidMedico;
    // End of variables declaration//GEN-END:variables
}
