/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import Controler.ValidarCampos;
import DAO.ConsultaDAO;
import DAO.ExameDAO;

import br.auroClin.model.Consulta;
import br.auroClin.model.Exame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Franciosney Souza
 */
public class CadastrarConsulta extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarConsulta
     */
    
    public void buscarConsultaPorNome(){
    
    
          String nome = jTextFieldBusca.getText();
        try {

            ConsultaDAO daocs = new ConsultaDAO();
            List<Consulta> listaConsulta = daocs.listarConsultaPorNome(nome);

            DefaultTableModel modelo = (DefaultTableModel)jTableConsulta.getModel();
            modelo.setNumRows(0);

            NumberFormat nf = NumberFormat.getCurrencyInstance();
            NumberFormat nfporcentagem = NumberFormat.getPercentInstance();

            int i = 0;
            for(Consulta objc: listaConsulta){
                modelo.addRow(new String[i]);
                jTableConsulta.setValueAt(objc.getId_consulta(), i, 0);
                jTableConsulta.setValueAt(objc.getNomeConsulta(), i, 1);
                jTableConsulta.setValueAt(nf.format(objc.getValorConsulta()), i, 2);
                jTableConsulta.setValueAt(nfporcentagem.format(objc.getLucro()), i, 3);
                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
       
        
    
    
    
    }
    
      public void listarConsulta(){
    
        try {
            
              ConsultaDAO daocos = new ConsultaDAO();
            List<Consulta> listaConsulta = daocos.listarConsultas();
            
            DefaultTableModel modelo = (DefaultTableModel)jTableConsulta.getModel();
            modelo.setNumRows(0);
            
            NumberFormat nf = NumberFormat.getCurrencyInstance();  
            NumberFormat nfporcentagem = NumberFormat.getPercentInstance();


            int i = 0;
            for(Consulta cons: listaConsulta){
modelo.addRow(new String[i]);
jTableConsulta.setValueAt(cons.getId_consulta(), i, 0);
jTableConsulta.setValueAt(cons.getNomeConsulta(), i, 1);
jTableConsulta.setValueAt(nf.format(cons.getValorConsulta()), i, 2);
jTableConsulta.setValueAt(nfporcentagem.format(cons.getLucro()), i, 3);
            i++;
            }
            
        } catch (Exception e) {}
        }
    
    
    
    
    
    
    public CadastrarConsulta() {
        initComponents();
        
       JFrame frame = new JFrame();
frame.setTitle("Cadastro de Consultas");
        
          jTextFieldNomeConsulta.setDocument(new ValidarCampos());
         jTextFieldNomeConsultaeEditable.setDocument(new ValidarCampos());
         jTextFieldBusca.setDocument(new ValidarCampos());
        
             URL url = this.getClass().getResource("/br/auroClin/imagens/homesoft.png");
Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
this.setIconImage(imagemTitulo);




 DecimalFormat decimal = new DecimalFormat("#,###,###.00");
         NumberFormatter numFormatter = new NumberFormatter(decimal);
         numFormatter.setFormat(decimal);
         numFormatter.setAllowsInvalid(false);
         DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatter);
         jFormattedTextFieldPrecoConsulta.setFormatterFactory(dfFactory);
         jFormattedTextFieldPorcentagem.setFormatterFactory(dfFactory);
          

         
           JTableHeader header = jTableConsulta.getTableHeader();   
    header.setPreferredSize(new Dimension(0, 50)); 

    	header.setFont(new Font("��������", Font.PLAIN, 14));
	header.setPreferredSize(new Dimension(header.getWidth(),40));
    

        
         jTableConsulta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableConsulta.getColumnModel().getColumn(0).setPreferredWidth(40);
jTableConsulta.getColumnModel().getColumn(1).setPreferredWidth(200);
jTableConsulta.getColumnModel().getColumn(2).setPreferredWidth(80);
jTableConsulta.getColumnModel().getColumn(3).setPreferredWidth(65);
jTableConsulta.setRowHeight(35); 
         
         
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldNomeConsulta = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButtonSalvarConsulta = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldPrecoConsulta = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextFieldPorcentagem = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jButtonBotaoPesquisarConsulta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jFormattedTextFieldPrecoConsultaEditable = new javax.swing.JFormattedTextField();
        jButtonEditaConsulta = new javax.swing.JButton();
        jTextFieldNomeConsultaeEditable = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextFieldPrecoConsultaEditable1 = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButtonMinimizar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Relação de Consultas Realizadas Pela Auro Clin"));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldNomeConsulta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNomeConsulta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNomeConsultaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNomeConsultaFocusLost(evt);
            }
        });
        jTextFieldNomeConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeConsultaActionPerformed(evt);
            }
        });
        jTextFieldNomeConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeConsultaKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Valor R$:");

        jButtonSalvarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/salvarB.png"))); // NOI18N
        jButtonSalvarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarConsultaActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Salvar");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nome da Consulta:");

        jFormattedTextFieldPrecoConsulta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldPrecoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldPrecoConsultaActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Atenção! Ative as letras Maiúsculas");

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Exemplo: 33,44 / 1.244,25");

        jFormattedTextFieldPorcentagem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldPorcentagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldPorcentagemActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Lucro em %");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGap(112, 112, 112)
                .addComponent(jLabel8)
                .addContainerGap(305, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldNomeConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldPrecoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel6)
                        .addGap(155, 155, 155)
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldPorcentagem, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel6)
                        .addComponent(jLabel23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSalvarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldNomeConsulta)
                    .addComponent(jFormattedTextFieldPorcentagem)
                    .addComponent(jFormattedTextFieldPrecoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar/Editar Exames"));

        jTextFieldBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaKeyPressed(evt);
            }
        });

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome do Exame:", "Valor R$:", "Lucro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConsulta);

        jButtonBotaoPesquisarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/buscar.png"))); // NOI18N
        jButtonBotaoPesquisarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBotaoPesquisarConsultaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Digite o Nome do Exame:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Buscar Exame");

        jTextFieldId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldId.setEnabled(false);
        jTextFieldId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIdFocusLost(evt);
            }
        });
        jTextFieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdActionPerformed(evt);
            }
        });
        jTextFieldId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIdKeyTyped(evt);
            }
        });

        jFormattedTextFieldPrecoConsultaEditable.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldPrecoConsultaEditable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldPrecoConsultaEditableActionPerformed(evt);
            }
        });

        jButtonEditaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/editar.png"))); // NOI18N
        jButtonEditaConsulta.setText("   Editar");
        jButtonEditaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditaConsultaActionPerformed(evt);
            }
        });

        jTextFieldNomeConsultaeEditable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNomeConsultaeEditable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNomeConsultaeEditableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNomeConsultaeEditableFocusLost(evt);
            }
        });
        jTextFieldNomeConsultaeEditable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeConsultaeEditableActionPerformed(evt);
            }
        });
        jTextFieldNomeConsultaeEditable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeConsultaeEditableKeyTyped(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Atenção! Ative as letras Maiúsculas");

        jFormattedTextFieldPrecoConsultaEditable1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldPrecoConsultaEditable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldPrecoConsultaEditable1ActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Editar Lucro: 35,5 %");

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("Editar Preço:");

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Editar Nome:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldBusca)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonBotaoPesquisarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                    .addComponent(jTextFieldId)
                                    .addComponent(jButtonEditaConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNomeConsultaeEditable)
                                    .addComponent(jFormattedTextFieldPrecoConsultaEditable1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jFormattedTextFieldPrecoConsultaEditable)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(jLabel11)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonBotaoPesquisarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jTextFieldBusca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeConsultaeEditable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldPrecoConsultaEditable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldPrecoConsultaEditable1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditaConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(60, 80, 740, 600);
        jPanel3.getAccessibleContext().setAccessibleName("");

        jButtonMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (1).png"))); // NOI18N
        jButtonMinimizar.setToolTipText("Minimizar");
        jButtonMinimizar.setName(""); // NOI18N
        jButtonMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMinimizar);
        jButtonMinimizar.setBounds(750, 0, 50, 40);

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFechar);
        jButtonFechar.setBounds(800, 0, 50, 40);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("     Cadastrar ou Editar Consultas   ");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 30, 500, 41);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/fundoConsulta.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(5, 2, 850, 700);

        setSize(new java.awt.Dimension(850, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeConsultaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeConsultaFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldNomeConsultaFocusGained

    private void jTextFieldNomeConsultaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeConsultaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeConsultaFocusLost

    private void jTextFieldNomeConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeConsultaActionPerformed

    private void jTextFieldNomeConsultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeConsultaKeyTyped
        // TODO add your handling code here:
/*
        int numeroCaracteres = 40;
        if (jTextFieldNomeExame.getText().length() > numeroCaracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Texto muito grande! Abrevie Algumas Palavras");
        } */
    }//GEN-LAST:event_jTextFieldNomeConsultaKeyTyped

    private void jButtonSalvarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarConsultaActionPerformed

        // TODO add your handling code here:

        if (jTextFieldNomeConsulta.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Preecha o Nome da Consulta!");

        } else if (jFormattedTextFieldPrecoConsulta.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Preencha o Valor da Consulta!");

        } else{
            float valor = 0; 
            try {
                
                  valor = NumberFormat.getInstance().parse(jFormattedTextFieldPorcentagem.getText()).floatValue();
                
                
            } catch (Exception e) {
            }
            
             

           float valorLimite = 100;
           
           if (valor > valorLimite) {
        
             JOptionPane.showMessageDialog(rootPane, "Digite um valor em Porcentagem de 0 a 100, Obrigado");
       jFormattedTextFieldPorcentagem.setBorder(BorderFactory.createLineBorder(Color.red));
    } else{
           
             
            

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Você tem Certeza que Deseja Cadastrar uma Nova Consulta?","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                // Saving code here

                String nomeConsulta;

                nomeConsulta = jTextFieldNomeConsulta.getText();

                ConsultaDAO daocons = new ConsultaDAO();

                if (daocons.validarConsulta(nomeConsulta)) {

                    JOptionPane.showMessageDialog(null, "Exame Existente");
                    jTextFieldNomeConsulta.setText("");
                    jFormattedTextFieldPrecoConsulta.setText(null);
                    jFormattedTextFieldPorcentagem.setText("0");

                } else {

                    try {

                        Consulta objcons = new Consulta();
                        objcons.setNomeConsulta(jTextFieldNomeConsulta.getText());
                        float teste = NumberFormat.getInstance().parse(jFormattedTextFieldPrecoConsulta.getText()).floatValue();
                        objcons.setValorConsulta(teste);
                         float ValorDesconro = NumberFormat.getInstance().parse(jFormattedTextFieldPorcentagem.getText()).floatValue();
          
               float px = ValorDesconro/100;
               
               objcons.setLucro(px);

                        ConsultaDAO daoc = new ConsultaDAO();
                        daoc.cadastrarConsulta(objcons);
                        JOptionPane.showMessageDialog(null, "Consulta Cadastrada com Sucesso!");
                        jTextFieldNomeConsulta.setText("");
                        jFormattedTextFieldPrecoConsulta.setText(null);
                        jFormattedTextFieldPorcentagem.setText("0");
                       
                    

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar Exame!"+e);

                    }

                }

            }

            else{

                JOptionPane.showMessageDialog(null, "Você Cancelou o Cadastro do Exame");

                jTextFieldNomeConsulta.setText("");
                jFormattedTextFieldPrecoConsulta.setText(null);
                jFormattedTextFieldPorcentagem.setText("0");

            }
           
           
           
           }
            
            
          

        } 

    }//GEN-LAST:event_jButtonSalvarConsultaActionPerformed

    private void jFormattedTextFieldPrecoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPrecoConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPrecoConsultaActionPerformed

    private void jTableConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsultaMouseClicked
        // TODO add your handling code here:

        //---- Controlando Clique na tabela
  
         jTableConsulta.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel  
jTableConsulta.addMouseListener(new MouseAdapter() {  
    public void mouseClicked(MouseEvent e)  
    {  
        if (e.getClickCount() == 2)  
        {  

           //JOptionPane.showMessageDialog(null, "Você não Pode Editar! Não Insista");
        }  
    }  
});  

        jTextFieldId.setText(jTableConsulta.getValueAt(jTableConsulta.getSelectedRow(), 0).toString());
        jTextFieldNomeConsultaeEditable.setText(jTableConsulta.getValueAt(jTableConsulta.getSelectedRow(), 1).toString());
        String teste = jTableConsulta.getValueAt(jTableConsulta.getSelectedRow(), 2).toString();
        String valorDecimal = jTableConsulta.getValueAt(jTableConsulta.getSelectedRow(), 3).toString();
      
        try {
            
            
              float valor = NumberFormat.getInstance().parse(valorDecimal).floatValue();
              jFormattedTextFieldPrecoConsultaEditable1.setText(Float.toString(valor));

                NumberFormat format = NumberFormat.getCurrencyInstance();
     String valorVenda = format.parse(teste).toString();
        
        
     
        jFormattedTextFieldPrecoConsultaEditable.setText(valorVenda);

            
            
        } catch (Exception e) {
        }
        
        
        
        
      
    }//GEN-LAST:event_jTableConsultaMouseClicked

    private void jButtonBotaoPesquisarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBotaoPesquisarConsultaActionPerformed
        // TODO add your handling code here:
        if (jTextFieldBusca.getText().equals("") ){
            
            JOptionPane.showMessageDialog(rootPane, "Campo de Busca Obrigatório!");
        }else{
        
            buscarConsultaPorNome();
      
        }
        
        

    }//GEN-LAST:event_jButtonBotaoPesquisarConsultaActionPerformed

    private void jTextFieldIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdFocusGained

    private void jTextFieldIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdFocusLost

    private void jTextFieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdActionPerformed

    private void jTextFieldIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdKeyTyped

    private void jFormattedTextFieldPrecoConsultaEditableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPrecoConsultaEditableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPrecoConsultaEditableActionPerformed

    private void jButtonEditaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditaConsultaActionPerformed
        // TODO add your handling code here:

    if (jTextFieldNomeConsultaeEditable.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null, "Preecha o Nome do Exame!");
            
            } else if (jFormattedTextFieldPrecoConsultaEditable.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null, "Preencha o Valor do Exame!");
    
            } else if (jTextFieldId.getText().equals("")) {
            
                 JOptionPane.showMessageDialog(null, "Selecione Um exame ao Lado!");
        }else{
               
                
                
               float valor = 0; 
                try {
                      valor = NumberFormat.getInstance().parse(jFormattedTextFieldPrecoConsultaEditable1.getText()).floatValue();
            
        } catch (Exception e) {
        }
                
                 

           float valorLimite = 100;
           
           if (valor > valorLimite) {
        
             JOptionPane.showMessageDialog(rootPane, "Digite um valor em Porcentagem de 0 a 100, Obrigado");
       jFormattedTextFieldPorcentagem.setBorder(BorderFactory.createLineBorder(Color.red));
    } else{
           
           
               
                String editar = jTextFieldNomeConsultaeEditable.getText();
                 int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja editar " + editar, "Confirmar Edição!", dialogButton);
if(dialogResult == 0) {
           
           
       try {
                   Consulta objc = new Consulta();
                   objc.setId_consulta(Integer.parseInt(jTextFieldId.getText()));
                 objc.setNomeConsulta(jTextFieldNomeConsultaeEditable.getText());
                  float precoEditado = NumberFormat.getInstance().parse(jFormattedTextFieldPrecoConsultaEditable.getText()).floatValue();
                  
                   float ValorDesconro = NumberFormat.getInstance().parse(jFormattedTextFieldPrecoConsultaEditable1.getText()).floatValue();
          
               float px = ValorDesconro/100;
               
               objc.setLucro(px);
                  
                  objc.setValorConsulta(precoEditado);
                  
                  
                  
                  
                  ConsultaDAO daoc = new ConsultaDAO();
                  daoc.editarConsulta(objc);
                  JOptionPane.showMessageDialog(null, "Consulta Alterado Com Sucesso!");
                  jTextFieldNomeConsultaeEditable.setText("");
                  jFormattedTextFieldPrecoConsultaEditable.setText(null);
                  jFormattedTextFieldPrecoConsultaEditable1.setText("0");
              } catch (ParseException ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao Alterar Exame!"+ex);
              }
            
                    
    
    
            
            
            }else{

 JOptionPane.showMessageDialog(null, "Consulta Não Alterada!");
                  jTextFieldNomeConsultaeEditable.setText("");
                  jFormattedTextFieldPrecoConsultaEditable.setText(null);
                  jFormattedTextFieldPrecoConsultaEditable1.setText(null);

}
           
           
           
           }
                
     
        
            }
    }//GEN-LAST:event_jButtonEditaConsultaActionPerformed

    private void jTextFieldNomeConsultaeEditableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeConsultaeEditableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeConsultaeEditableFocusGained

    private void jTextFieldNomeConsultaeEditableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeConsultaeEditableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeConsultaeEditableFocusLost

    private void jTextFieldNomeConsultaeEditableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeConsultaeEditableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeConsultaeEditableActionPerformed

    private void jTextFieldNomeConsultaeEditableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeConsultaeEditableKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeConsultaeEditableKeyTyped

    private void jButtonMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizarActionPerformed
        // TODO add your handling code here:
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizarActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        listarConsulta();
    }//GEN-LAST:event_formWindowActivated

    private void jTextFieldBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaKeyPressed
        // TODO add your handling code here:
        
        buscarConsultaPorNome();
    }//GEN-LAST:event_jTextFieldBuscaKeyPressed

    private void jFormattedTextFieldPorcentagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPorcentagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPorcentagemActionPerformed

    private void jFormattedTextFieldPrecoConsultaEditable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPrecoConsultaEditable1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPrecoConsultaEditable1ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBotaoPesquisarConsulta;
    private javax.swing.JButton jButtonEditaConsulta;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JButton jButtonSalvarConsulta;
    private javax.swing.JFormattedTextField jFormattedTextFieldPorcentagem;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecoConsulta;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecoConsultaEditable;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecoConsultaEditable1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNomeConsulta;
    private javax.swing.JTextField jTextFieldNomeConsultaeEditable;
    // End of variables declaration//GEN-END:variables
}
