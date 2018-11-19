/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;


import Controler.ValidarCampos;
import DAO.ExameDAO;
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
public class CadastrarExames extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarExames
     */
    
    
    
    public void examesPorNome(){
    
        
         String nome = jTextFieldBusca.getText();
        try {
            
            ExameDAO daoex = new ExameDAO();
            List<Exame> listaExames = daoex.listarExamesPorNome(nome);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableExames.getModel();
            modelo.setNumRows(0);
            
             NumberFormat nf = NumberFormat.getCurrencyInstance();
              NumberFormat nfporcentagem = NumberFormat.getPercentInstance();
            
               int i = 0;
            for(Exame ex: listaExames){
modelo.addRow(new String[i]);
jTableExames.setValueAt(ex.getId_exame(), i, 0);
jTableExames.setValueAt(ex.getNomeExame(), i, 1);
jTableExames.setValueAt(nf.format(ex.getValorExame()), i, 2);
jTableExames.setValueAt(nfporcentagem.format(ex.getLucro()), i, 3);
            i++;
            
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
    
    
    }
    
    
     public void listarExames(){
    
        try {
            
            ExameDAO daoex = new ExameDAO();
            List<Exame> listaExames = daoex.listarExames();
            
            DefaultTableModel modelo = (DefaultTableModel)jTableExames.getModel();
            modelo.setNumRows(0);
            
            NumberFormat nf = NumberFormat.getCurrencyInstance();  
            NumberFormat nfporcentagem = NumberFormat.getPercentInstance();


            int i = 0;
            for(Exame ex: listaExames){
modelo.addRow(new String[i]);
jTableExames.setValueAt(ex.getId_exame(), i, 0);
jTableExames.setValueAt(ex.getNomeExame(), i, 1);
jTableExames.setValueAt(nf.format(ex.getValorExame()), i, 2);
jTableExames.setValueAt(nfporcentagem.format(ex.getLucro()), i, 3);
            i++;
            }
            
        } catch (Exception e) {}
        }
    
    
    public CadastrarExames() {
        initComponents();
      
        jTextFieldNomeExame.setDocument(new ValidarCampos());
         jTextFieldNomeExameEditable.setDocument(new ValidarCampos());
         jTextFieldBusca.setDocument(new ValidarCampos());
        
             URL url = this.getClass().getResource("/br/auroClin/imagens/homesoft.png");
Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
this.setIconImage(imagemTitulo);




 DecimalFormat decimal = new DecimalFormat("#,###,###.00");
         NumberFormatter numFormatter = new NumberFormatter(decimal);
         numFormatter.setFormat(decimal);
         numFormatter.setAllowsInvalid(false);
         DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatter);
         jFormattedTextFieldPrecoExame.setFormatterFactory(dfFactory);
         //jFormattedTextFieldPorcentagem.setFormatterFactory(dfFactory);
         
          
 
 DecimalFormat decimalDesconto = new DecimalFormat("#,###,###.00");
         NumberFormatter numFormatterd = new NumberFormatter(decimalDesconto);
         numFormatterd.setFormat(decimal);
         numFormatterd.setAllowsInvalid(false);
         DefaultFormatterFactory dfFactoryD = new DefaultFormatterFactory(numFormatterd);
         //jFormattedTextFieldPrecoExame.setFormatterFactory(dfFactoryD);
          jFormattedTextFieldPorcentagem.setFormatterFactory(dfFactory);

           JTableHeader header = jTableExames.getTableHeader();   
    header.setPreferredSize(new Dimension(0, 50)); 

    	header.setFont(new Font("��������", Font.PLAIN, 14));
	header.setPreferredSize(new Dimension(header.getWidth(),40));
    

        
         jTableExames.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableExames.getColumnModel().getColumn(0).setPreferredWidth(50);
jTableExames.getColumnModel().getColumn(1).setPreferredWidth(200);
jTableExames.getColumnModel().getColumn(2).setPreferredWidth(100);
jTableExames.getColumnModel().getColumn(3).setPreferredWidth(65);
jTableExames.setRowHeight(35); 
         

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
        jTextFieldNomeExame = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldPrecoExame = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextFieldPorcentagem = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableExames = new javax.swing.JTable();
        jButtonBotaoPesquisarExame = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jFormattedTextFieldPrecoExameEditable = new javax.swing.JFormattedTextField();
        jButton4 = new javax.swing.JButton();
        jTextFieldNomeExameEditable = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextFieldPorcentagemParaEditar = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonMinimizar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
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
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações Sobre o Exame"));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldNomeExame.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNomeExame.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNomeExameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNomeExameFocusLost(evt);
            }
        });
        jTextFieldNomeExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeExameActionPerformed(evt);
            }
        });
        jTextFieldNomeExame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeExameKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Valor R$:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/salvarB.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Salvar/Exame");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nome do Exame:");

        jFormattedTextFieldPrecoExame.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldPrecoExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldPrecoExameActionPerformed(evt);
            }
        });
        jFormattedTextFieldPrecoExame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldPrecoExameKeyPressed(evt);
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
        jFormattedTextFieldPorcentagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldPorcentagemKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldPorcentagemKeyTyped(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel6)
                        .addGap(155, 155, 155)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldNomeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldPrecoExame, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedTextFieldPorcentagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel6)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldNomeExame)
                    .addComponent(jFormattedTextFieldPorcentagem)
                    .addComponent(jFormattedTextFieldPrecoExame, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jTableExames.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableExames.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableExames.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableExames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableExamesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableExames);

        jButtonBotaoPesquisarExame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/buscar.png"))); // NOI18N
        jButtonBotaoPesquisarExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBotaoPesquisarExameActionPerformed(evt);
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

        jFormattedTextFieldPrecoExameEditable.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldPrecoExameEditable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldPrecoExameEditableActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/editar.png"))); // NOI18N
        jButton4.setText("   Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextFieldNomeExameEditable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNomeExameEditable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNomeExameEditableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNomeExameEditableFocusLost(evt);
            }
        });
        jTextFieldNomeExameEditable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeExameEditableActionPerformed(evt);
            }
        });
        jTextFieldNomeExameEditable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeExameEditableKeyTyped(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Atenção! Ative as letras Maiúsculas");

        jFormattedTextFieldPorcentagemParaEditar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldPorcentagemParaEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldPorcentagemParaEditarActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Editar Nome:");

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("Editar Preço:");

        jLabel12.setBackground(new java.awt.Color(255, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Editar Lucro: 35,5 %");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldBusca, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel12)))
                        .addContainerGap(94, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel10))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldPrecoExameEditable)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldNomeExameEditable, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldId, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonBotaoPesquisarExame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldPorcentagemParaEditar)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeExameEditable, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldPrecoExameEditable, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldPorcentagemParaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 28, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonBotaoPesquisarExame, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(60, 80, 730, 600);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("       Cadastrar Exames");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 30, 380, 41);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/FundoFormPaciente.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 700);

        setSize(new java.awt.Dimension(850, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeExameActionPerformed

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
            
           
             if (jTextFieldNomeExame.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null, "Preecha o Nome do Exame!");
            
            } else if (jFormattedTextFieldPrecoExame.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null, "Preencha o Valor do Exame!");
            
  
            
            } else{
                
                 try {
                      float valor = NumberFormat.getInstance().parse(jFormattedTextFieldPorcentagem.getText()).floatValue();

           float valorLimite = 100;
           
           if (valor > valorLimite) {
        
             JOptionPane.showMessageDialog(rootPane, "Digite um valor em Porcentagem de 0 a 100, Obrigado");
       jFormattedTextFieldPorcentagem.setBorder(BorderFactory.createLineBorder(Color.red));
    } 
 
           else{
           
           
               
               
                       
              
                
                
            
               int dialogButton = JOptionPane.YES_NO_OPTION;
   int dialogResult = JOptionPane.showConfirmDialog (null, "Você tem Certeza que Deseja Cadastrar um Novo Exame","Warning",dialogButton);
if(dialogResult == JOptionPane.YES_OPTION){
  // Saving code here

    String nomeExame;
        
        nomeExame = jTextFieldNomeExame.getText();
        
        
        ExameDAO daol = new ExameDAO();
        
        if (daol.validarExame(nomeExame)) {
         
             JOptionPane.showMessageDialog(null, "Exame Existente");
               jTextFieldNomeExame.setText("");
           jFormattedTextFieldPrecoExame.setText("0");
         
        } else {
                    
   
            try {
            
            
            Exame objex = new Exame();
            objex.setNomeExame(jTextFieldNomeExame.getText());
             float teste = NumberFormat.getInstance().parse(jFormattedTextFieldPrecoExame.getText()).floatValue();
                System.out.println(teste);
            objex.setValorExame(teste);
            
            ExameDAO daoex = new ExameDAO();
               float ValorDesconro = NumberFormat.getInstance().parse(jFormattedTextFieldPorcentagem.getText()).floatValue();
          
               float px = ValorDesconro/100;
               
               objex.setLucro(px);
               daoex.cadastrarExame(objex);
            JOptionPane.showMessageDialog(null, "Exame Cadastrado com Sucesso!");
            jTextFieldNomeExame.setText("");
           jFormattedTextFieldPrecoExame.setText("0");
            
            } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Exame!"+e);
            
            
            }

            }  
 
}
   
    else{
    
    
      JOptionPane.showMessageDialog(null, "Você Cancelou o Cadastro do Exame");
      
      jTextFieldNomeExame.setText("");
      jFormattedTextFieldPrecoExame.setText("0");
    
    
    
    
    }
    
               
               
               
           
           
           }
                
                
                
                 
                 } catch (Exception e) {
                 }
                
      
              
    
    
    
    
    
            }
            
            
           
        
        
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldNomeExameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameFocusGained
        // TODO add your handling code here:
        
   
    }//GEN-LAST:event_jTextFieldNomeExameFocusGained

    private void jTextFieldNomeExameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeExameFocusLost

    private void jTextFieldNomeExameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameKeyTyped
        // TODO add your handling code here:
        
        int numeroCaracteres = 30;
        if (jTextFieldNomeExame.getText().length() > numeroCaracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Texto muito grande! Abrevie Algumas Palavras");
        }
    }//GEN-LAST:event_jTextFieldNomeExameKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Listando Dados da Tabela Exame
        
        
        
    }//GEN-LAST:event_formWindowOpened

    private void jButtonBotaoPesquisarExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBotaoPesquisarExameActionPerformed
        // TODO add your handling code here:
      
        if (jTextFieldBusca.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Campo de Pesquisa Obrigatório!");
        } else{
        
       examesPorNome();
        
            
        }
        
        
        
        
    }//GEN-LAST:event_jButtonBotaoPesquisarExameActionPerformed

    private void jFormattedTextFieldPrecoExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPrecoExameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPrecoExameActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
  
        listarExames();
        
    
 
    }//GEN-LAST:event_formWindowActivated

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

    private void jFormattedTextFieldPrecoExameEditableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPrecoExameEditableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPrecoExameEditableActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
          if (jTextFieldNomeExameEditable.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null, "Preecha o Nome do Exame!");
            
            } else if (jFormattedTextFieldPrecoExameEditable.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null, "Preencha o Valor do Exame!");
    
            } else if (jTextFieldId.getText().equals("")) {
            
                 JOptionPane.showMessageDialog(null, "Selecione Um exame ao Lado!");
        }else{
            
                try {
                    
                    
                        
                  float valor = NumberFormat.getInstance().parse(jFormattedTextFieldPorcentagemParaEditar.getText()).floatValue();

           float valorLimite = 100;
           
           if (valor > valorLimite) {
        
             JOptionPane.showMessageDialog(rootPane, "Digite um valor em Porcentagem de 0 a 100, Obrigado");
       jFormattedTextFieldPorcentagemParaEditar.setBorder(BorderFactory.createLineBorder(Color.red));
    } else{
           
             
               
               
                
               int dialogButton = JOptionPane.YES_NO_OPTION;
   int dialogResult = JOptionPane.showConfirmDialog (null, "Você Deseja Alterar Este Exame?","Warning",dialogButton);
if(dialogResult == JOptionPane.YES_OPTION){



              try {
                   Exame objex = new Exame();
                   objex.setId_exame(Integer.parseInt(jTextFieldId.getText()));
                 objex.setNomeExame(jTextFieldNomeExameEditable.getText());
                  float precoEditado = NumberFormat.getInstance().parse(jFormattedTextFieldPrecoExameEditable.getText()).floatValue();
                  objex.setValorExame(precoEditado);
                    float ValorDesconro = NumberFormat.getInstance().parse(jFormattedTextFieldPorcentagemParaEditar.getText()).floatValue();
          
               float px = ValorDesconro/100;
                  
                  objex.setLucro(px);
                  ExameDAO daoalterar = new ExameDAO();
                  daoalterar.editarExame(objex);
                  JOptionPane.showMessageDialog(null, "Exame Alterado Com Sucesso!");
                  jTextFieldNomeExameEditable.setText("");
                  jFormattedTextFieldPrecoExameEditable.setText("0");
              } catch (ParseException ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao Alterar Exame!"+ex);
              }
            
           



}else{

    
    JOptionPane.showMessageDialog(null, "Você Não Alterou o Exame!");
    

}
               
               
               
               
               
               
               
                
           
           
           }
                
                    
                    
                  
              } catch (Exception e) {
              }
            
                
                
              
            
            
            
            
            }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextFieldNomeExameEditableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameEditableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeExameEditableFocusGained

    private void jTextFieldNomeExameEditableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameEditableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeExameEditableFocusLost

    private void jTextFieldNomeExameEditableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameEditableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeExameEditableActionPerformed

    private void jTextFieldNomeExameEditableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameEditableKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeExameEditableKeyTyped

    private void jTableExamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableExamesMouseClicked
        // TODO add your handling code here:
        
         //---- Controlando Clique na tabela
        
jTableExames.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel  
jTableExames.addMouseListener(new MouseAdapter() {  
    public void mouseClicked(MouseEvent e)  
    {  
        if (e.getClickCount() == 2)  
        {  

  
        }  
    }  
});  
      // ---------- Fim
      
        
        
        jTextFieldId.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 0).toString());
         jTextFieldNomeExameEditable.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 1).toString());
         String teste = jTableExames.getValueAt(jTableExames.getSelectedRow(), 2).toString();

         
         String testeDecimal = jTableExames.getValueAt(jTableExames.getSelectedRow(), 3).toString();
        
         
      
         
          
          
          
         try {
             
              float valor = NumberFormat.getInstance().parse(testeDecimal).floatValue();
             
           
           
                NumberFormat format = NumberFormat.getCurrencyInstance();
     String valorVenda = format.parse(teste).toString();
      
 
            jFormattedTextFieldPorcentagemParaEditar.setText(Float.toString(valor));
         jFormattedTextFieldPrecoExameEditable.setText(valorVenda);
            
            
        } catch (Exception e) {
        }
 
    
    }//GEN-LAST:event_jTableExamesMouseClicked

    private void jFormattedTextFieldPrecoExameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPrecoExameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPrecoExameKeyPressed

    private void jFormattedTextFieldPorcentagemParaEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPorcentagemParaEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPorcentagemParaEditarActionPerformed

    private void jFormattedTextFieldPorcentagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPorcentagemKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPorcentagemKeyTyped

    private void jFormattedTextFieldPorcentagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPorcentagemKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPorcentagemKeyPressed

    private void jFormattedTextFieldPorcentagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPorcentagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldPorcentagemActionPerformed

    private void jTextFieldBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaKeyPressed
        // TODO add your handling code here:
        
        examesPorNome();
    }//GEN-LAST:event_jTextFieldBuscaKeyPressed

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
            java.util.logging.Logger.getLogger(CadastrarExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarExames().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonBotaoPesquisarExame;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JFormattedTextField jFormattedTextFieldPorcentagem;
    private javax.swing.JFormattedTextField jFormattedTextFieldPorcentagemParaEditar;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecoExame;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecoExameEditable;
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
    private javax.swing.JTable jTableExames;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNomeExame;
    private javax.swing.JTextField jTextFieldNomeExameEditable;
    // End of variables declaration//GEN-END:variables
}
