/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.ConsultaDAO;
import DAO.ExameDAO;
import DAO.MarcarDAO;
import DAO.MedicoDAO;
import br.auroClin.model.Consulta;
import br.auroClin.model.Exame;
import br.auroClin.model.Marcar;
import br.auroClin.model.Medico;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
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
public class DataExames extends javax.swing.JFrame {

    /**
     * Creates new form DataExames
     */
    
      public void buscaAvancadaExa(){
    
        
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
                List<Marcar> listadeDatas =  dao.listaDatasExamesPorData(dataBusca, nomeExame, nomeMedico, forma);

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
        
        
        }
                    
                  

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
    
    public DataExames() {
        initComponents();
    
        
           URL url = this.getClass().getResource("/br/auroClin/imagens/homesoft.png");
Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
this.setIconImage(imagemTitulo);
        
 JTableHeader headerMarcados =  jTableDatasExames.getTableHeader();   
    headerMarcados .setPreferredSize(new Dimension(0, 25)); 
    headerMarcados .setFont(new Font("��������", Font.PLAIN, 14));
	headerMarcados .setPreferredSize(new Dimension(headerMarcados .getWidth(),25));
               jTableDatasExames.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableDatasExames.getColumnModel().getColumn(0).setPreferredWidth(60);
jTableDatasExames.getColumnModel().getColumn(1).setPreferredWidth(220);
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
jTableMedico.getColumnModel().getColumn(2).setPreferredWidth(190);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldIdMedico = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldNomeMedico = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldEspecializacaoMedico = new javax.swing.JTextField();
        jTextFieldBuscaMedico = new javax.swing.JTextField();
        jButtonBuscarPaciente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMedico = new javax.swing.JTable();
        jButtonSalvar1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jComboBoxConsultas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldIdExame = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNomeExameConcerto = new javax.swing.JTextField();
        jTextFieldValorExameConcerto = new javax.swing.JTextField();
        jComboBoxTipodeConsulta = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooserDataRealizar = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonFechar = new javax.swing.JButton();
        jButtonMinimizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
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
                                .addGap(38, 38, 38)
                                .addComponent(jLabel18)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldNomeExameBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione um Médico"));

        jLabel8.setText("ID:");

        jTextFieldIdMedico.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldIdMedico.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldIdMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdMedicoActionPerformed(evt);
            }
        });

        jLabel9.setText("Nome Médico:");

        jTextFieldNomeMedico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldNomeMedico.setForeground(new java.awt.Color(0, 51, 102));

        jLabel16.setText("Especialização:");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextFieldIdMedico))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addComponent(jButtonSalvar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldEspecializacaoMedico)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextFieldBuscaMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldNomeMedico)
                    .addComponent(jTextFieldIdMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEspecializacaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldBuscaMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Data para Consultas"));

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

        jLabel4.setText("Selecione um Exame");

        jTextFieldIdExame.setEnabled(false);

        jLabel7.setText("ID:");

        jTextFieldNomeExameConcerto.setEnabled(false);

        jTextFieldValorExameConcerto.setEnabled(false);

        jComboBoxTipodeConsulta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxTipodeConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Principal", "Agenda" }));
        jComboBoxTipodeConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipodeConsultaActionPerformed(evt);
            }
        });

        jLabel20.setText("Data para Realizar  Exame");

        jLabel21.setText("Forma:");

        jLabel10.setText("Exame:");

        jLabel22.setText("Data para Marcar Exame");

        jLabel12.setText("Valor:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jComboBoxConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIdExame, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNomeExameConcerto)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextFieldValorExameConcerto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooserDataRealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipodeConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdExame, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeExameConcerto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorExameConcerto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxTipodeConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jDateChooserDataRealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 60, 1330, 620);

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFechar);
        jButtonFechar.setBounds(1300, 0, 50, 40);

        jButtonMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (1).png"))); // NOI18N
        jButtonMinimizar.setToolTipText("Minimizar");
        jButtonMinimizar.setName(""); // NOI18N
        jButtonMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMinimizar);
        jButtonMinimizar.setBounds(1250, 0, 50, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("      DATAS DE EXAMES");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(500, 10, 380, 41);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/FundoFormPaciente.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1350, 700);

        setSize(new java.awt.Dimension(1350, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizarActionPerformed
        // TODO add your handling code here:
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        try {
            
            ExameDAO daoexCom = new ExameDAO();
            List<Exame> lista = daoexCom.BuscarExamesParaComobox();
          
            for(Exame ex: lista){
            
                jComboBoxConsultas.addItem(ex.getNomeExame());
            
            }
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButtonSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvar1ActionPerformed
        // TODO add your handling code here:
        
        // Date teste = (Date) jSpinner1.getValue();
      
         //SimpleDateFormat farmato = new SimpleDateFormat("HH:mm");
                       //String dataBancoHora = farmato.format(teste);

        

        Date dataMarcar,dataRealizar = null;
        String dataBanco,dataMarcarBanco;

        dataRealizar = jDateChooserDataRealizar.getDate();
        dataMarcar = jDateChooser1.getDate();
        String tipoConsulta = (String) jComboBoxTipodeConsulta.getSelectedItem();
        String nomeMedico = jTextFieldNomeMedico.getText();
         

        if (dataRealizar == null) {

            JOptionPane.showMessageDialog(rootPane, "A data para realização o Exame é Obrigatória!");

        }else if(dataMarcar == null){

            JOptionPane.showMessageDialog(rootPane, "A data para o paciente ir marcar o Exame é Obrigatória!");

        }else if(nomeMedico.equals("")){

            JOptionPane.showMessageDialog(rootPane, "Selecione um Médico na tabela Abaixo");

        } 
        
        
        
        else{

            
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
            
             jDateChooserDataRealizar.setBackground(new java.awt.Color(255, 0, 0));
            
            
        } else {
   
            
              int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this, "Deseja Marcar esta Data?", "Title on Box", dialogButton);
if(dialogResult == 0) {

 SimpleDateFormat farmatoData = new SimpleDateFormat("dd/MM/yyyy");
            dataBanco = farmatoData.format(dataRealizar);

            dataMarcarBanco = farmatoData.format(dataMarcar);

            Marcar objm = new Marcar();
            int idexame = Integer.parseInt(jTextFieldIdExame.getText());
         
            objm.setId_exame(idexame);
            objm.setDataFazer(dataBanco);
            objm.setDataAbrir(dataMarcarBanco);
            objm.setAgendar(tipoConsulta);
            //objm.setHorario(dataBancoHora);
            
            objm.setId_medico(Integer.parseInt(jTextFieldIdMedico.getText()));
            
            

            try {

                MarcarDAO daomar = new MarcarDAO();
                daomar.cadastrarMarcar(objm);

                JOptionPane.showMessageDialog(null, "Data Inserida Com Sucesso!");
jTextFieldIdMedico.setText("");
 jTextFieldNomeMedico.setText("");
 jTextFieldEspecializacaoMedico.setText("");
                jDateChooserDataRealizar.setDate(null);
                jDateChooser1.setDate(null);

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Erro ao Inserir Data!"+e);
            }

} else{

 JOptionPane.showMessageDialog(null, "Você Não Marcou!");
 
 jTextFieldIdMedico.setText("");
 jTextFieldNomeMedico.setText("");
 jTextFieldEspecializacaoMedico.setText("");

}
     
        }
            
            
        } catch (Exception e) {
        }
           
   
        }

    }//GEN-LAST:event_jButtonSalvar1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        
               SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
          
        
        
        CorTabela();
                ultimosMedicosCadastradis();

        try {
            
            MarcarDAO dao = new MarcarDAO();
            List<Marcar> listadeDatas =  dao.listaDatasExames();
            
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

    private void jTextFieldIdMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdMedicoActionPerformed

    private void jTextFieldBuscaMedicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaMedicoKeyPressed
        // TODO add your handling code here:
buscarMedico();
       
    }//GEN-LAST:event_jTextFieldBuscaMedicoKeyPressed

    private void jButtonBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPacienteActionPerformed
        // TODO add your handling code here:

     buscarMedico();

    }//GEN-LAST:event_jButtonBuscarPacienteActionPerformed

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

    private void jTextFieldDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDataKeyPressed
        // TODO add your handling code here:
        buscaAvancadaExa();
    }//GEN-LAST:event_jTextFieldDataKeyPressed

    private void jTextFieldNomeMedicoBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeMedicoBuscaKeyPressed
        // TODO add your handling code here:

        buscaAvancadaExa();
    }//GEN-LAST:event_jTextFieldNomeMedicoBuscaKeyPressed

    private void jTextFieldNomeExameBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameBuscaKeyPressed
        // TODO add your handling code here:

        buscaAvancadaExa();

    }//GEN-LAST:event_jTextFieldNomeExameBuscaKeyPressed

    private void jTextFieldFormaBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFormaBuscaKeyPressed
        // TODO add your handling code here:

        buscaAvancadaExa();
    }//GEN-LAST:event_jTextFieldFormaBuscaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        buscaAvancadaExa();

    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void jComboBoxConsultasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxConsultasItemStateChanged
        // TODO add your handling code here:

        String nome = (String) jComboBoxConsultas.getSelectedItem();

        

        try {

            ExameDAO daoe = new ExameDAO();
            List<Exame> listaExames = daoe.listarExamesPorNome(nome);

            NumberFormat nf = NumberFormat.getCurrencyInstance();

            for(Exame obc: listaExames){
                jTextFieldIdExame.setText(String.valueOf(obc.getId_exame()));
                jTextFieldNomeExameConcerto.setText(obc.getNomeExame());
                jTextFieldValorExameConcerto.setText(nf.format(obc.getValorExame()));

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro colocar exame na caixa"+e);
        }
    }//GEN-LAST:event_jComboBoxConsultasItemStateChanged

    private void jComboBoxConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxConsultasActionPerformed

    private void jComboBoxTipodeConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipodeConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipodeConsultaActionPerformed

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
            java.util.logging.Logger.getLogger(DataExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataExames().setVisible(true);
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
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooserDataRealizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDatasExames;
    private javax.swing.JTable jTableMedico;
    private javax.swing.JTextField jTextFieldBuscaMedico;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldEspecializacaoMedico;
    private javax.swing.JTextField jTextFieldFormaBusca;
    private javax.swing.JTextField jTextFieldIdExame;
    private javax.swing.JTextField jTextFieldIdMedico;
    private javax.swing.JTextField jTextFieldNomeExameBusca;
    private javax.swing.JTextField jTextFieldNomeExameConcerto;
    private javax.swing.JTextField jTextFieldNomeMedico;
    private javax.swing.JTextField jTextFieldNomeMedicoBusca;
    private javax.swing.JTextField jTextFieldValorExameConcerto;
    // End of variables declaration//GEN-END:variables
}
