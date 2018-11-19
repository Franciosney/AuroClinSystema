/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.AmbienteMedicoDAO;
import DAO.PacienteDAO;
import DAO.ProntuarioDAO;
import br.auroClin.model.JoinBuscarExameEMarcar;
import br.auroClin.model.Paciente;
import br.auroClin.model.ProntuarioModelo;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Franciosney Souza
 */
public class prontuariosPorPacientesMedico extends javax.swing.JFrame {

    /**
     * Creates new form prontuariosPorPacientesMedico
     */
    
    
    
    
    
    public void buscarProntuarioAntigos(int id_marcarExame){
    
        
        ProntuarioDAO daop = new ProntuarioDAO();


        try {

            
            List<ProntuarioModelo> listaProntuario = daop.listaProntuarioAntigos(id_marcarExame);


            for(ProntuarioModelo objp: listaProntuario){

                jTextAreaDiagnostico.setText(objp.getDiagnostico());
                jTextAreaDiagnostico.setLineWrap(true);
                jTextAreaDiagnostico.setFont(new Font("Monospaced", 0, 20));
                jTextAreaDiagnostico.setEditable(false);
                jTextAreaDiagnostico.setBackground(new java.awt.Color(204, 204, 255));

                jTextAreaSintomas.setText(objp.getSintomas());
                jTextAreaSintomas.setLineWrap(true);
                jTextAreaSintomas.setFont(new Font("Monospaced", 0, 20));
                jTextAreaSintomas.setEditable(false);
                jTextAreaSintomas.setBackground(new java.awt.Color(204, 204, 255));

                jTextAreaDescricao.setText(objp.getDescricao());
                jTextAreaDescricao.setLineWrap(true);
                jTextAreaDescricao.setFont(new Font("Monospaced", 0, 20));
                jTextAreaDescricao.setEditable(false);
                jTextAreaDescricao.setBackground(new java.awt.Color(204, 204, 255));

                jTextAreaPrescricao.setText(objp.getPrescricao());
                jTextAreaPrescricao.setLineWrap(true);
                jTextAreaPrescricao.setFont(new Font("Monospaced", 0, 20));
                jTextAreaPrescricao.setEditable(false);
                jTextAreaPrescricao.setBackground(new java.awt.Color(204, 204, 255));
                
             

               


            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
            
            

       
    }
    
    
    
    
    
    
    
    
      
    public void buscarProntuario(int id_marcarExame){
    
        
        ProntuarioDAO daop = new ProntuarioDAO();


        try {

            
            List<ProntuarioModelo> listaProntuario = daop.listaProntuario(id_marcarExame);


            for(ProntuarioModelo objp: listaProntuario){

           
                              
                                
                          
                               
                                
                                jTextAreaDiagnostico.setText(objp.getDiagnostico());
                                jTextAreaDiagnostico.setEditable(false);
                                jTextAreaDiagnostico.setLineWrap(true);
                                jTextAreaDiagnostico.setBackground(new java.awt.Color(204, 204, 255));
                                
             jTextAreaSintomas.setText(objp.getSintomas());
             jTextAreaSintomas.setEditable(false);
             jTextAreaSintomas.setFont(new Font("Monospaced", 0, 20));
             jTextAreaSintomas.setLineWrap(true);
              jTextAreaSintomas.setBackground(new java.awt.Color(204, 204, 255));
 
             jTextAreaDescricao.setText(objp.getDescricao());
             jTextAreaDescricao.setLineWrap(true);
             jTextAreaDescricao.setFont(new Font("Monospaced", 0, 20));
             jTextAreaDescricao.setEditable(false);
              jTextAreaDescricao.setBackground(new java.awt.Color(204, 204, 255));
             
              jTextAreaPrescricao.setText(objp.getPrescricao());
              jTextAreaPrescricao.setLineWrap(true);
              jTextAreaPrescricao.setFont(new Font("Monospaced", 0, 20));
            jTextAreaPrescricao.setEditable(false);
            jTextAreaPrescricao.setBackground(new java.awt.Color(204, 204, 255));
              
      
               
           


            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
            
            

       
    }
    
    
    
    
    
    public void buscarHistoricoAntigo(String nomePaciente){
    
 
        try {
            
            
       
 
       // String data = jTextFieldData.getText();
            
            
       
              AmbienteMedicoDAO daor = new AmbienteMedicoDAO();
            
            List<JoinBuscarExameEMarcar> listaExames = daor.historicoAntigo(nomePaciente);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableHistoricoAntigo.getModel();
            modelo.setNumRows(0);

               int i = 0;
            for(JoinBuscarExameEMarcar ex: listaExames){

                  DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
       
modelo.addRow(new String[i]);

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(ex.getDataRealizar());  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");   

    
     
jTableHistoricoAntigo.setValueAt(ex.getId_marcarBuscar(), i, 0);
jTableHistoricoAntigo.setValueAt(formatoRetorno.format(date), i, 1);



//jTableExames.setValueAt(ex.getFormaRealizar(), i, 5);
    

            i++;
            
       
             
             
             
             
        }
                
    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
      
    
    }
    
    
    
    
    
    public void buscarPAcientes(){
    
    
           String nome = jTextFieldNomePaciente.getText();
        try {

            PacienteDAO daop = new PacienteDAO();
            List<Paciente> listaPaciente = daop.listarPacientePorNome(nome);

            DefaultTableModel modelo = (DefaultTableModel)jTablePaciente.getModel();
            modelo.setNumRows(0);

          

            int i = 0;
            for(Paciente objp: listaPaciente){
                modelo.addRow(new String[i]);
              
                 jTablePaciente.setValueAt(objp.getNome_paciente(), i, 0);
                 jTablePaciente.setValueAt(objp.getCpf(), i, 1);
               
           
                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
       

        
    
    }
    
    
    
    
    
    public void buscarHistorioRecente(String nomePaciente){
    
 
        try {
            
            
       
 
       // String data = jTextFieldData.getText();
            
            
       
            AmbienteMedicoDAO daor = new AmbienteMedicoDAO();
            
            List<JoinBuscarExameEMarcar> listaExames = daor.historicoRecente(nomePaciente);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableHistoricoRecente.getModel();
            modelo.setNumRows(0);
       
            
                  
  NumberFormat nf = NumberFormat.getCurrencyInstance(); 


               int i = 0;
            for(JoinBuscarExameEMarcar ex: listaExames){
                
                
       
                
        
                  DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
             
   
           
modelo.addRow(new String[i]);

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(ex.getDataRealizar());  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");   

    
     
jTableHistoricoRecente.setValueAt(ex.getId_marcarBuscar(), i, 0);
jTableHistoricoRecente.setValueAt(formatoRetorno.format(date), i, 1);



//jTableExames.setValueAt(ex.getFormaRealizar(), i, 5);
    

            i++;
            
       
             
             
             
             
        }
                
    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
      
    
    }
    
    
    
    
    
    
    
    
    public prontuariosPorPacientesMedico() {
        initComponents();
        
        
        
       JTableHeader headerClic = jTableHistoricoRecente.getTableHeader();   
    headerClic.setPreferredSize(new Dimension(0, 25)); 
   JTableHeader headerHist = jTableHistoricoRecente.getTableHeader();   
  
    headerHist.setFont(new Font("��������", Font.PLAIN, 14));
	headerClic.setPreferredSize(new Dimension(headerHist.getWidth(),25));  
      jTableHistoricoRecente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableHistoricoRecente.getColumnModel().getColumn(0).setPreferredWidth(40);
jTableHistoricoRecente.getColumnModel().getColumn(1).setPreferredWidth(122);
jTableHistoricoRecente.setRowHeight(23); 




 JTableHeader headerAntigo = jTableHistoricoAntigo.getTableHeader();   
    headerAntigo.setPreferredSize(new Dimension(0, 25)); 
   JTableHeader headerHistAntigo = jTableHistoricoAntigo.getTableHeader();   
  
    headerHistAntigo.setFont(new Font("��������", Font.PLAIN, 14));
	headerAntigo.setPreferredSize(new Dimension(headerHist.getWidth(),25));  
      jTableHistoricoAntigo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableHistoricoAntigo.getColumnModel().getColumn(0).setPreferredWidth(40);
jTableHistoricoAntigo.getColumnModel().getColumn(1).setPreferredWidth(122);
jTableHistoricoAntigo.setRowHeight(23); 
        

 
       JTableHeader headerPaciente = jTablePaciente.getTableHeader();   
    headerPaciente.setPreferredSize(new Dimension(0, 25)); 
   JTableHeader headerHisPacientet = jTablePaciente.getTableHeader();   
  
    headerHisPacientet.setFont(new Font("��������", Font.PLAIN, 14));
	headerHisPacientet.setPreferredSize(new Dimension(headerHist.getWidth(),25));  
      jTablePaciente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(300);
jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(200);
jTablePaciente.setRowHeight(23); 





        
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
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDiagnostico = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaSintomas = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaPrescricao = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableHistoricoRecente = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableHistoricoAntigo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButtonFechar1 = new javax.swing.JButton();
        jTextFieldNomePaciente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Diagnostico");

        jTextAreaDiagnostico.setColumns(20);
        jTextAreaDiagnostico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaDiagnostico.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDiagnostico);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Sintomas");

        jTextAreaSintomas.setColumns(20);
        jTextAreaSintomas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaSintomas.setRows(5);
        jScrollPane4.setViewportView(jTextAreaSintomas);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Descrição");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaDescricao.setRows(5);
        jScrollPane3.setViewportView(jTextAreaDescricao);

        jTextAreaPrescricao.setColumns(20);
        jTextAreaPrescricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaPrescricao.setRows(5);
        jScrollPane7.setViewportView(jTextAreaPrescricao);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Prescrição");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setText("Prontuário do Paciente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(240, 240, 240)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane7))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(240, 140, 750, 550);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Histórico Recente"));

        jTableHistoricoRecente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableHistoricoRecente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Data"
            }
        ));
        jTableHistoricoRecente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHistoricoRecenteMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTableHistoricoRecente);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Histórico Antigo"));

        jTableHistoricoAntigo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableHistoricoAntigo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Data"
            }
        ));
        jTableHistoricoAntigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHistoricoAntigoMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTableHistoricoAntigo);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 140, 220, 550);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonFechar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar1.setToolTipText("Fechar");
        jButtonFechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFechar1ActionPerformed(evt);
            }
        });

        jTextFieldNomePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomePacienteActionPerformed(evt);
            }
        });
        jTextFieldNomePaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomePacienteKeyPressed(evt);
            }
        });

        jButton1.setText("Buscar");

        jTablePaciente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Data"
            }
        ));
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTablePaciente);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Nome Para Busca");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel11.setText("Buscar Paciente no Sistema");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jButtonFechar1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonFechar1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 10, 980, 120);

        setSize(new java.awt.Dimension(1000, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFechar1ActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_jButtonFechar1ActionPerformed

    private void jTextFieldNomePacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomePacienteKeyPressed
        // TODO add your handling code here:
        
       buscarPAcientes();
        
    }//GEN-LAST:event_jTextFieldNomePacienteKeyPressed

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked
        // TODO add your handling code here:
        
        
        String nomePaciente = jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0).toString();
        buscarHistorioRecente(nomePaciente);
        buscarHistoricoAntigo(nomePaciente);
    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jTextFieldNomePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomePacienteActionPerformed

    private void jTableHistoricoRecenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistoricoRecenteMouseClicked
        // TODO add your handling code here:
        
        
         int id_marcarExame = Integer.parseInt(jTableHistoricoRecente.getValueAt(jTableHistoricoRecente.getSelectedRow(), 0).toString());
        buscarProntuario(id_marcarExame);
        
        
        
    }//GEN-LAST:event_jTableHistoricoRecenteMouseClicked

    private void jTableHistoricoAntigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistoricoAntigoMouseClicked
        // TODO add your handling code here:
        
        
          int id_marcarExame = Integer.parseInt(jTableHistoricoAntigo.getValueAt(jTableHistoricoAntigo.getSelectedRow(), 0).toString());
        buscarProntuarioAntigos(id_marcarExame);
        
        
        
        
    }//GEN-LAST:event_jTableHistoricoAntigoMouseClicked

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
            java.util.logging.Logger.getLogger(prontuariosPorPacientesMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(prontuariosPorPacientesMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(prontuariosPorPacientesMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prontuariosPorPacientesMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new prontuariosPorPacientesMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonFechar1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTableHistoricoAntigo;
    private javax.swing.JTable jTableHistoricoRecente;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextArea jTextAreaDiagnostico;
    private javax.swing.JTextArea jTextAreaPrescricao;
    private javax.swing.JTextArea jTextAreaSintomas;
    private javax.swing.JTextField jTextFieldNomePaciente;
    // End of variables declaration//GEN-END:variables
}
