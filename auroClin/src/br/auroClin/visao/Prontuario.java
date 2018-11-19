/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.ConsultaDAO;
import DAO.ExameDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.ProntuarioDAO;
import DAO.retornoDAO;
import br.auroClin.model.Consulta;
import br.auroClin.model.Exame;
import br.auroClin.model.JoinBuscarExameEMarcar;
import br.auroClin.model.Medico;
import br.auroClin.model.Paciente;
import br.auroClin.model.ProntuarioModelo;

import java.awt.Color;
import static java.awt.Color.RED;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.springframework.util.StringUtils;

/**
 *
 * @author Franciosney Souza
 */
public class Prontuario extends javax.swing.JFrame {

    /**
     * Creates new form Prontuario
     * @param id_marcarExame
     */
    
    
      
    public void buscarProntuario(int id_marcarExame){
    
        
        ProntuarioDAO daop = new ProntuarioDAO();
        
        
           if (daop.validarAntigo(id_marcarExame)) {
            

               
               
        try {

            
            List<ProntuarioModelo> listaProntuario = daop.listaProntuarioAntigos(id_marcarExame);


            for(ProntuarioModelo objp: listaProntuario){

                                jTextFieldIdDiagnostico.setText(objp.getDiagnostico());
                                jTextFieldIdDiagnostico.setEnabled(false);
             jTextAreaSintomas.setText(objp.getSintomas());
             jTextAreaSintomas.setEnabled(false);
             jTextAreaDescricao.setFont(new Font("Monospaced", 0, 20));
             jTextAreaDescricao.setText(objp.getDescricao());
             jTextAreaDescricao.setEnabled(false);
              jTextAreaSintomas.setFont(new Font("Monospaced", 0, 20));
             


            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
               
               
        
    
            
        } else if(daop.validarProntualAtual(id_marcarExame)){
        


        try {

            
            List<ProntuarioModelo> listaProntuario = daop.listaProntuario(id_marcarExame);


            for(ProntuarioModelo objp: listaProntuario){

                                jTextFieldIdDiagnostico.setText(objp.getDiagnostico());
                                jTextFieldIdDiagnostico.setEnabled(false);
             jTextAreaSintomas.setText(objp.getSintomas());
             jTextAreaSintomas.setEnabled(false);
             jTextAreaDescricao.setText(objp.getDescricao());
             jTextAreaDescricao.setFont(new Font("Monospaced", 0, 20));
             jTextAreaDescricao.setEnabled(false);
               jTextAreaSintomas.setFont(new Font("Monospaced", 0, 20));
            


            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
            
            
            
            
        }else{
        
            

        try {

            
         
jTextFieldIdDiagnostico.setText("");
                      jTextFieldIdDiagnostico.setEnabled(true);
     
             jTextAreaSintomas.setText("");
             jTextAreaSintomas.setEnabled(true);
          
             jTextAreaDescricao.setText("");
              jTextAreaDescricao.setEnabled(true);
           
             jTextFieldMedico.setEnabled(false);
jTextAreaDescricao.setFont(new Font("Monospaced", 0, 20));
        
               jTextAreaSintomas.setFont(new Font("Monospaced", 0, 20));
            

      
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
       
                 
        
        }
        
        
        
        
        
        
        
        
       
       
    }
        
    
    
    public void buscarExamePorNomeData(String nomePaciente){
    
 
        try {
            
            
       
 
       // String data = jTextFieldData.getText();
            
            
       
            ProntuarioDAO daor = new ProntuarioDAO();
            
            List<JoinBuscarExameEMarcar> listaExames = daor.listaDatasExamesRetorno(nomePaciente);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableHistorico.getModel();
            modelo.setNumRows(0);
       
            
                  
  NumberFormat nf = NumberFormat.getCurrencyInstance(); 


               int i = 0;
            for(JoinBuscarExameEMarcar ex: listaExames){
                
                
       
                
        
                  DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
             
   
           
modelo.addRow(new String[i]);

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(ex.getDataRealizar());  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");   

    
     
jTableHistorico.setValueAt(ex.getId_marcarBuscar(), i, 0);
jTableHistorico.setValueAt(formatoRetorno.format(date), i, 1);
jTableHistorico.setValueAt(ex.getExameRequerido(), i, 2);
jTableHistorico.setValueAt(ex.getNomeMedico(), i, 3);



//jTableExames.setValueAt(ex.getFormaRealizar(), i, 5);
    

            i++;
            
       
             
             
             
             
        }
                
    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
      
    
    }
    
    
    
    
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
    
    
    
    public Prontuario() {
        initComponents();
        
        
        
                        
                 
 JTableHeader headerPaciente = jTablePaciente.getTableHeader();   
    headerPaciente.setPreferredSize(new Dimension(0, 25)); 
    headerPaciente.setFont(new Font("��������", Font.PLAIN, 14));
	headerPaciente.setPreferredSize(new Dimension(headerPaciente.getWidth(),25));
 jTablePaciente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(40);
jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(200);
jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(126);


jTablePaciente.setRowHeight(20); 


              
 JTableHeader headerHistorico = jTableHistorico.getTableHeader();   
    headerHistorico.setPreferredSize(new Dimension(0, 25)); 
    headerHistorico.setFont(new Font("��������", Font.PLAIN, 14));
	headerHistorico.setPreferredSize(new Dimension(headerHistorico.getWidth(),25));
jTableHistorico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableHistorico.getColumnModel().getColumn(0).setPreferredWidth(40);
jTableHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
jTableHistorico.getColumnModel().getColumn(2).setPreferredWidth(228);
jTableHistorico.getColumnModel().getColumn(3).setPreferredWidth(180);

jTableHistorico.setRowHeight(20); 
                
        jTextFieldBuscarHistorico.setEnabled(false);
        jTextFieldIdPaciente.setEditable(false);
        jTextFieldIdNomePaciente.setEditable(false);
        jTextFieldNomeExame.setEditable(false);
        jTextFieldData.setEditable(false);
      
        
        jTextAreaDescricao.setLineWrap(true);
        jTextAreaDescricao.setMargin(new Insets(20, 20, 20, 20));

        jTextAreaSintomas.setLineWrap(true);
        jTextAreaSintomas.setMargin(new Insets(20, 20, 20, 20));

        jTextFieldIdDiagnostico.setEnabled(false);
        jTextAreaSintomas.setEnabled(false);
        jTextAreaDescricao.setEnabled(false);
         



        
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jTextFieldBuscarPaciente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorico = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldBuscarHistorico = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldIdPaciente = new javax.swing.JTextField();
        jTextFieldNomeExame = new javax.swing.JTextField();
        jTextFieldIdNomePaciente = new javax.swing.JTextField();
        jTextFieldData = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextFieldIdPR = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldIdDiagnostico = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaSintomas = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldMedico = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBoxFonteTamanho = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jComboBoxFonte = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBoxFonteTamanho1 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jComboBoxFonte1 = new javax.swing.JComboBox<>();
        jButtonFechar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Prontuários Médico"));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("                       PRONTUARIO MÉDICO");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("               BUSCAR PACIENTE");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableHistorico.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTableHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Data", "Consulta / Exame", "Título 4"
            }
        ));
        jTableHistorico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHistoricoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableHistoricoMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHistorico);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("         HISTÓRICO DO PACIENTE");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextFieldBuscarHistorico.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldBuscarHistorico.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldBuscarHistorico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldBuscarHistorico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarHistoricoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldBuscarHistorico)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBuscarHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextFieldIdPaciente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        jTextFieldNomeExame.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldNomeExame.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldNomeExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeExameActionPerformed(evt);
            }
        });
        jTextFieldNomeExame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeExameKeyPressed(evt);
            }
        });

        jTextFieldIdNomePaciente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        jTextFieldData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldData.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataActionPerformed(evt);
            }
        });
        jTextFieldData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDataKeyPressed(evt);
            }
        });

        jLabel1.setText("Id - P");

        jLabel5.setText("Nome do Paciente");

        jLabel6.setText("Serviço");

        jLabel7.setText("Data");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/CadastrarProntuario.png"))); // NOI18N
        jButton2.setText("        Novo Prontuário");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextFieldIdPR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldIdPR.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldIdPR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdPRActionPerformed(evt);
            }
        });
        jTextFieldIdPR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldIdPRKeyPressed(evt);
            }
        });

        jLabel16.setText("Id - PR");

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

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("DIAGNOSTICO");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("SINTOMAS");

        jTextAreaSintomas.setColumns(20);
        jTextAreaSintomas.setRows(5);
        jScrollPane2.setViewportView(jTextAreaSintomas);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("DESCRIÇÃO MÉDICA");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane4.setViewportView(jTextAreaDescricao);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("MÉDICO");

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "White", "Black", "Red", "Orange", "Yellow", "Green", "Blue", "Gray", "Gold" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jComboBoxFonteTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "12", "14", "16", "18", "24" }));
        jComboBoxFonteTamanho.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxFonteTamanhoItemStateChanged(evt);
            }
        });

        jButton4.setText("Aplicar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBoxFonte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bold", "Italic", "Normal" }));
        jComboBoxFonte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxFonteItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxFonte, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jComboBoxFonteTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(285, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFonte)
                    .addComponent(jComboBox1)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jComboBoxFonteTamanho, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "White", "Black", "Red", "Orange", "Yellow", "Green", "Blue", "Gray", "Gold" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jComboBoxFonteTamanho1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "12", "14", "16", "18", "24" }));
        jComboBoxFonteTamanho1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxFonteTamanho1ItemStateChanged(evt);
            }
        });

        jButton5.setText("Aplicar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBoxFonte1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bold", "Italic", "Normal" }));
        jComboBoxFonte1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxFonte1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxFonte1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jComboBoxFonteTamanho1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(342, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFonte1)
                    .addComponent(jComboBox2)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jComboBoxFonteTamanho1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextFieldIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIdPR, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIdNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldData))
                    .addComponent(jTextFieldIdDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))
                    .addComponent(jTextFieldMedico, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel16))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdPR, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldIdDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(7, 7, 7)
                .addComponent(jTextFieldMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButtonFechar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar1.setToolTipText("Fechar");
        jButtonFechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFechar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonFechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jButtonFechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1300, 700);

        setSize(new java.awt.Dimension(1300, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
String id_paciente = jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0).toString();
        buscarExamePorNomeData(nomePaciente);

jTextFieldBuscarHistorico.setText(nomePaciente);
jTextFieldIdNomePaciente.setText(nomePaciente);
jTextFieldIdNomePaciente.setEnabled(false);
jTextFieldIdPaciente.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0).toString());
jTextFieldIdPaciente.setEnabled(false);

    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jTextFieldBuscarPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarPacienteKeyPressed
        // TODO add your handling code here:

        buscarPAcientes();
    }//GEN-LAST:event_jTextFieldBuscarPacienteKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        buscarPAcientes();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistoricoMouseClicked
        // TODO add your handling code here:

        
        
       jTableHistorico.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel
        jTableHistorico.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {

                }
            }
        });
        // ---------- Fim   
        
        
        
        int id_idmarcarExame = Integer.parseInt(jTableHistorico.getValueAt(jTableHistorico.getSelectedRow(), 0).toString());
        String nome = jTableHistorico.getValueAt(jTableHistorico.getSelectedRow(), 1).toString();
        jTextFieldIdPR.setText(jTableHistorico.getValueAt(jTableHistorico.getSelectedRow(), 0).toString());
         jTextFieldIdPR.setEnabled(false);
         jTextFieldNomeExame.setText(jTableHistorico.getValueAt(jTableHistorico.getSelectedRow(), 2).toString());
         jTextFieldNomeExame.setEnabled(false);
         jTextFieldData.setText(jTableHistorico.getValueAt(jTableHistorico.getSelectedRow(), 1).toString());
         jTextFieldData.setEnabled(false);
         jTextFieldMedico.setText(jTableHistorico.getValueAt(jTableHistorico.getSelectedRow(), 3).toString());
        
             jTextFieldMedico.setEnabled(false);
         buscarProntuario(id_idmarcarExame);
        
    
    }//GEN-LAST:event_jTableHistoricoMouseClicked

    private void jTextFieldIdPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdPacienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdPacienteKeyPressed

    private void jTextFieldBuscarHistoricoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarHistoricoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarHistoricoKeyPressed

    private void jTextFieldIdPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdPacienteActionPerformed

    private void jButtonFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFechar1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFechar1ActionPerformed

    private void jTextFieldNomeExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeExameActionPerformed

    private void jTextFieldNomeExameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeExameKeyPressed

    private void jTextFieldIdNomePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdNomePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdNomePacienteActionPerformed

    private void jTextFieldIdNomePacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdNomePacienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdNomePacienteKeyPressed

    private void jTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataActionPerformed

    private void jTextFieldDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDataKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataKeyPressed

    private void jTextFieldBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarPacienteActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
    
    }//GEN-LAST:event_formWindowActivated

    private void jTextFieldIdPRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdPRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdPRActionPerformed

    private void jTextFieldIdPRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdPRKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdPRKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    
        
         
     if(jTextFieldIdNomePaciente.getText().equals("")){
    
        
   JOptionPane.showMessageDialog(rootPane, "Pesquise um Paciente na Tabela ao Lado, Obrigado!");
        jTablePaciente.setBorder(BorderFactory.createLineBorder(Color.red));
    
        
    
    }else if(jTextFieldNomeExame.getText().equals("")){
    
        
   JOptionPane.showMessageDialog(rootPane, "Selecione uma Opção no Histórico do Paciente, Obrigado!");
        jTableHistorico.setBorder(BorderFactory.createLineBorder(Color.red));
    
        
    
    }else{
    
    
        
        
    if (jTextFieldIdDiagnostico.getText().equals("")) {
        
        JOptionPane.showMessageDialog(rootPane, "O campo Diagnostico é Obrigatório, Obrigado!");
        jTextFieldIdDiagnostico.setBorder(BorderFactory.createLineBorder(Color.red));
        
    } else if(jTextAreaSintomas.getText().equals("")){
     JOptionPane.showMessageDialog(rootPane, "O campo Sintomas é Obrigatório, Obrigado!");
        jTextAreaSintomas.setBorder(BorderFactory.createLineBorder(Color.red));
    
    }else if(jTextAreaDescricao.getText().equals("")){
    
        
   JOptionPane.showMessageDialog(rootPane, "O Campo Descrição é Obrigatório, Obrigado!");
        jTextAreaDescricao.setBorder(BorderFactory.createLineBorder(Color.red));
    
        
    
    }else{
    
    
        
   
        int idValidar = Integer.parseInt(jTextFieldIdPR.getText());
        
          ProntuarioDAO daop = new ProntuarioDAO();
            

if(daop.validarProntualAtual(idValidar)){

    JOptionPane.showMessageDialog(rootPane, "Esse Prontuario Já Foi Cadastrado, Obrigado!");

}else   if (daop.validarAntigo(idValidar)) {


JOptionPane.showMessageDialog(rootPane, "Esse Prontuario Já Foi Cadastrado Como Antigo , Obrigado!");

}else{
    

          
        int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this,"Você deseja cadastrar Este Prontuário sem Altorização do Médico Para ", "Title on Box", dialogButton);
if(dialogResult == 0) {

      ProntuarioModelo objp = new ProntuarioModelo();
        objp.setId_marcarExame(Integer.parseInt(jTextFieldIdPR.getText()));
        objp.setId_paciente(Integer.parseInt(jTextFieldIdPaciente.getText()));
        objp.setDiagnostico(jTextFieldIdDiagnostico.getText());
        objp.setSintomas(jTextAreaSintomas.getText());
        objp.setDescricao(jTextAreaDescricao.getText());
        objp.setServico(jTextFieldNomeExame.getText());
        
        
        daop.cadastrarProntuario(objp);

        
         
        JOptionPane.showMessageDialog(rootPane, "Prontuário Cadastrado Com Sucesso");
        jTextFieldIdPaciente.setText("");
    jTextFieldIdNomePaciente.setText("");
    jTextFieldNomeExame.setText("");
    jTextFieldIdDiagnostico.setText("");
    jTextAreaSintomas.setText("");
    jTextAreaDescricao.setText("");
    jTextFieldMedico.setText("");
    jTextFieldBuscarPaciente.setText("");
    jTextFieldIdPR.setText("");
    jTextFieldData.setText("");
    jTextFieldNomeExame.setText("");
   
        

}else{

   JOptionPane.showMessageDialog(rootPane, "Você Cancelou");
   jTextFieldIdDiagnostico.setText("");
   jTextAreaSintomas.setText("");
   jTextAreaDescricao.setText("");

}      
}
    }
    }
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldIdDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdDiagnosticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdDiagnosticoActionPerformed

    private void jTextFieldIdDiagnosticoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdDiagnosticoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdDiagnosticoKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
       








        

       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
         
       
        String cor  = (String) jComboBox1.getSelectedItem();
        
        String texto = jTextAreaSintomas.getText();
        String fMaiuscula = StringUtils.capitalize(texto);
        jTextAreaSintomas.setText(fMaiuscula);
        
        
        if (cor.equals("Red")){
            
            jTextAreaSintomas.setForeground(Color.RED);
        }else if(cor.equals("White")){
        
        jTextAreaSintomas.setForeground(Color.WHITE);
        
        }else if(cor.equals("White")){
        
        jTextAreaSintomas.setForeground(Color.WHITE);
        
        }else if(cor.equals("Black")){
        
        jTextAreaSintomas.setForeground(Color.BLACK);
        
        }else if(cor.equals("Orange")){
        
        jTextAreaSintomas.setForeground(Color.ORANGE);
        
        }else if(cor.equals("Yellow")){
        
        jTextAreaSintomas.setForeground(Color.yellow);
        
        }else if(cor.equals("Green")){
        
        jTextAreaSintomas.setForeground(Color.GREEN);
        
        }else if(cor.equals("Blue")){
        
        jTextAreaSintomas.setForeground(Color.BLUE);
        
        }else if(cor.equals("Gray")){
        
        jTextAreaSintomas.setForeground(Color.GRAY);
        
        }
        

        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBoxFonteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxFonteItemStateChanged
        // TODO add your handling code here:
       
         int tamanho  = Integer.parseInt((String) jComboBoxFonteTamanho.getSelectedItem());
         
          String fonte  = ((String) jComboBoxFonte.getSelectedItem());
     
          if (fonte.equals("Bold")) {
            
              jTextAreaSintomas.setFont(new Font("Serif", Font.BOLD, tamanho));
              
        }else if(fonte.equals("Italic")){
          
          jTextAreaSintomas.setFont(new Font("Italic", Font.ITALIC, tamanho));
          
          
          }else{
        
        jTextAreaSintomas.setFont(new Font("Monospaced", 0, tamanho));
        
        }
          
    }//GEN-LAST:event_jComboBoxFonteItemStateChanged

    private void jComboBoxFonteTamanhoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxFonteTamanhoItemStateChanged
        // TODO add your handling code here:
        
        
             int tamanho  = Integer.parseInt((String) jComboBoxFonteTamanho.getSelectedItem());
         
          
     jTextAreaSintomas.setFont(new Font("Monospaced", 0, tamanho));
        
        
    }//GEN-LAST:event_jComboBoxFonteTamanhoItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBoxFonteTamanho1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxFonteTamanho1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFonteTamanho1ItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBoxFonte1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxFonte1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFonte1ItemStateChanged

    private void jTableHistoricoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistoricoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableHistoricoMouseEntered

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
            java.util.logging.Logger.getLogger(Prontuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prontuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prontuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prontuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prontuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonFechar1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBoxFonte;
    private javax.swing.JComboBox<String> jComboBoxFonte1;
    private javax.swing.JComboBox<String> jComboBoxFonteTamanho;
    private javax.swing.JComboBox<String> jComboBoxFonteTamanho1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableHistorico;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextArea jTextAreaSintomas;
    private javax.swing.JTextField jTextFieldBuscarHistorico;
    private javax.swing.JTextField jTextFieldBuscarPaciente;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldIdDiagnostico;
    private javax.swing.JTextField jTextFieldIdNomePaciente;
    private javax.swing.JTextField jTextFieldIdPR;
    private javax.swing.JTextField jTextFieldIdPaciente;
    private javax.swing.JTextField jTextFieldMedico;
    private javax.swing.JTextField jTextFieldNomeExame;
    // End of variables declaration//GEN-END:variables
}
