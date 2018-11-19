/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.relatoriosDao;
import br.auroClin.model.buscarComprovanteImprimir;
import br.auroClin.model.imprimirComprovanteModelo;
import br.auroClin.model.relatorioAvancadoModelo;
import br.auroClin.model.relatorioExame;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class RelatorioAvancadodeExames extends javax.swing.JFrame {

    /**
     * Creates new form RelatorioAvancadodeExames
     */
    
    public void buscarExamePorNomeData(){
   
        
  
        String nomeMedico = jTextFieldNomeMedico.getText();
        String nomeExame = jTextFieldNomeConsulta.getText();
        String data = jTextFieldDiaMesAno.getText();
        String hora = jTextFieldHorario.getText();
        String pacienteBuscar = jTextFieldNomeCliente.getText();
     
       // String data = jTextFieldData.getText();

        try {

            relatoriosDao daor = new relatoriosDao();
            List<relatorioExame> listaConsulta = daor.listarExamesPorMedico(nomeMedico, nomeExame, data, hora,pacienteBuscar);
            

            DefaultTableModel modelo = (DefaultTableModel)jTableRelatorioExamesAvançadas.getModel();
            modelo.setNumRows(0);

            NumberFormat nf = NumberFormat.getCurrencyInstance();

            int i = 0;
            for(relatorioExame ex: listaConsulta){
                modelo.addRow(new String[i]);

                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = (Date)formatter.parse(ex.getDataFazer());
                SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");
                System.out.println(ex.getNomePAciente());
                
                String retorno = ex.getRetorno();
                
                if (retorno.equals("RETORNO")) {
                    
                    jTableRelatorioExamesAvançadas.setValueAt(nf.format(0), i, 2);
                }else{
                
                
                jTableRelatorioExamesAvançadas.setValueAt(nf.format(ex.getValorExame()), i, 2);
                
                }
     
 jTableRelatorioExamesAvançadas.setValueAt( String.format("Dr. %-30s", ex.getNomeMedico()), i, 0);
jTableRelatorioExamesAvançadas.setValueAt(ex.getNomeBusca(), i, 1);
jTableRelatorioExamesAvançadas.setValueAt(ex.getPlano(), i, 3);
jTableRelatorioExamesAvançadas.setValueAt(String.format("%-4s %%",ex.getDesc()), i, 4);
jTableRelatorioExamesAvançadas.setValueAt(formatoRetorno.format(date), i, 5);
jTableRelatorioExamesAvançadas.setValueAt(ex.getNomePAciente(), i, 6);

jTableRelatorioExamesAvançadas.setValueAt(ex.getRetorno(), i, 7);



                i++;
            }

        } catch (Exception e) {}
        
        
    }
    
    
    
    
    public RelatorioAvancadodeExames() {
        initComponents();
        
        
         // jTableRelatorioExames.setFont(new Font("Serif", Font.PLAIN, 50));
         JTableHeader header = jTableRelatorioExamesAvançadas.getTableHeader();   
    header.setPreferredSize(new Dimension(0, 50)); 
    header.setFont(new Font("��������", Font.PLAIN, 14));
	header.setPreferredSize(new Dimension(header.getWidth(),40));
           
         jTableRelatorioExamesAvançadas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableRelatorioExamesAvançadas.getColumnModel().getColumn(0).setPreferredWidth(200);
jTableRelatorioExamesAvançadas.getColumnModel().getColumn(1).setPreferredWidth(150);
jTableRelatorioExamesAvançadas.getColumnModel().getColumn(2).setPreferredWidth(95);
jTableRelatorioExamesAvançadas.getColumnModel().getColumn(3).setPreferredWidth(120);
jTableRelatorioExamesAvançadas.getColumnModel().getColumn(4).setPreferredWidth(50);
jTableRelatorioExamesAvançadas.getColumnModel().getColumn(5).setPreferredWidth(90);
jTableRelatorioExamesAvançadas.getColumnModel().getColumn(6).setPreferredWidth(215);
jTableRelatorioExamesAvançadas.getColumnModel().getColumn(7).setPreferredWidth(90);


jTableRelatorioExamesAvançadas.setRowHeight(35); 
    

SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        //String data = forData.format(cal.getTime());
        cal.getTime();
int mes = cal.get(GregorianCalendar.MONTH);
int ano = cal.get(GregorianCalendar.YEAR);

int mesAtual = mes + 1;
String dataBusca;

        if (mes >= 10) {
            
            
              System.out.println("Teste "+mesAtual);

String barra = "/";
 dataBusca = Integer.toString(mesAtual)+barra+ano;
            
            
            
            
        }else{
        
            
            
              System.out.println("Teste "+mesAtual);

String barra = "/";
String zero = "0";
 dataBusca = zero+Integer.toString(mesAtual)+barra+ano;
            
        
        
        }

       jTextFieldDiaMesAno.setText(dataBusca);
        

       
       
        jTextFieldDesc.setEditable(false);
              jTextFieldValor.setEditable(false);
                    jTextFieldNomePessoa.setEditable(false);
                    jTextFieldNomePessoaCPF.setEditable(false);
                    jTextFieldPlano.setEditable(false);
                    jTextFieldPorcentagem.setEditable(false);

                    jTextFieldNomeExame.setEditable(false);
                    //jTextFieldDesc.setText(ex.getDesc());

                    jTextFieldData.setEditable(false);
                    jTextFieldForma.setEditable(false);
                    jTextFieldMedico.setEditable(false);
                    jTextFieldReceita.setEditable(false);

                    jTextFieldReceita.setEditable(false);

       
             
       
       
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
        jTableRelatorioExamesAvançadas = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonFechar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomePessoaCPF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldNomeExame = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldReceita = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldPlano = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldDesc = new javax.swing.JTextField();
        jTextFieldPorcentagem = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldNomePessoa = new javax.swing.JTextField();
        jTextFieldMedico = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldForma = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldNomeMedico = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNomeConsulta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldDiaMesAno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldHorario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNomeCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jTableRelatorioExamesAvançadas.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTableRelatorioExamesAvançadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome do Médico", "Consulta", "Valor", "Plano", "D %", "Data", "Nome Paciente", "Receita"
            }
        ));
        jTableRelatorioExamesAvançadas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableRelatorioExamesAvançadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRelatorioExamesAvançadasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRelatorioExamesAvançadas);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/icon01.png"))); // NOI18N
        jButton4.setText(" Imprimir Relatório");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("  RELATÓRIO AVANÇADO DE EXAMES MARCADA");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("Nome Paciente");

        jLabel9.setText("CPF");

        jLabel7.setText("Exame/Consulta");

        jLabel10.setText("Valor Bruto  R$");

        jLabel11.setText("Data ");

        jLabel12.setText("Receita");

        jLabel13.setText("Plano");

        jLabel14.setText("Valor Pagar R$");

        jTextFieldDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescActionPerformed(evt);
            }
        });

        jLabel15.setText("Desconto");

        jLabel16.setText("Médico");

        jLabel17.setText("Forma");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(132, 132, 132)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldNomePessoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel9))
                                    .addComponent(jTextFieldNomePessoaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel15)
                                .addGap(120, 120, 120)
                                .addComponent(jLabel7)
                                .addGap(113, 113, 113)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDesc))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldForma, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldValor, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jTextFieldReceita))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomePessoaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel17))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldReceita)
                            .addComponent(jTextFieldForma, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/icon01.png"))); // NOI18N
        jButton5.setText(" Imprimir Segunda Via do Comprovante");
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(jButtonFechar))
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFechar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(300, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(310, 10, 1040, 640);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldNomeMedico.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextFieldNomeMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeMedicoKeyPressed(evt);
            }
        });

        jButton1.setText("Buscar Relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Nome do Médico");

        jTextFieldNomeConsulta.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextFieldNomeConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeConsultaKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Nome do Exame");

        jTextFieldDiaMesAno.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextFieldDiaMesAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDiaMesAnoKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Dia ( Ex: 15/05/2030");

        jTextFieldHorario.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextFieldHorario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldHorarioKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Forma");

        jTextFieldNomeCliente.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextFieldNomeCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeClienteKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Nome do Paciente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                .addComponent(jTextFieldNomeMedico, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldNomeConsulta, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldHorario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                    .addComponent(jTextFieldDiaMesAno, javax.swing.GroupLayout.Alignment.LEADING)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNomeConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(11, 11, 11)
                .addComponent(jTextFieldDiaMesAno, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 10, 300, 640);

        setSize(new java.awt.Dimension(1350, 660));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableRelatorioExamesAvançadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRelatorioExamesAvançadasMouseClicked
        // TODO add your handling code here:

          String nomePaciente = jTableRelatorioExamesAvançadas.getValueAt(jTableRelatorioExamesAvançadas.getSelectedRow(), 6).toString();
        String nomeExame = jTableRelatorioExamesAvançadas.getValueAt(jTableRelatorioExamesAvançadas.getSelectedRow(), 1).toString();
        String data = jTableRelatorioExamesAvançadas.getValueAt(jTableRelatorioExamesAvançadas.getSelectedRow(), 5).toString();
String dataBusca = null;
        
        try {
            
            
             DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
                Date date = (Date)formatter.parse(data);
                SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd/MM/yyyy");
        
System.out.println(formatoRetorno.format(date));
dataBusca = formatoRetorno.format(date);
            
        } catch (Exception e) {
        }
        
        
        
        
         relatoriosDao daor = new relatoriosDao();
         List<buscarComprovanteImprimir> listaRelatorioExame = daor.imprimirComprovanteSegundaVia(nomePaciente, nomeExame,dataBusca);
         
            
    
            
      
            
          


            int i = 0;
            for(buscarComprovanteImprimir ex: listaRelatorioExame){
                
                
                  float valor = ex.getValor();
                 
                String retorno = ex.getRetorno();
                
                
                
                
             
                
                            
                                                    
                                                      try {

      


            float valorPorcentagem = Float.parseFloat(ex.getPorcentagem());
           float converterPorcentagem = valorPorcentagem/100;
           float valorDesconto = valor*converterPorcentagem;
           float valorFinal = valor - valorDesconto;
        
             NumberFormat nf = NumberFormat.getCurrencyInstance();
             
                if (retorno.equals("RETORNO")) {
                    
                   
                    
                    
                     jTextFieldDesc.setText(nf.format(0));
                      jTextFieldValor.setText(nf.format(0)); 
                      jTextFieldNomePessoa.setText(ex.getPaciente());
                jTextFieldNomePessoaCPF.setText(ex.getCpf());
                        jTextFieldPlano.setText(ex.getPlano());
                        jTextFieldPorcentagem.setText(String.format("%-4s %%",ex.getPorcentagem()));
                        
                                jTextFieldNomeExame.setText(ex.getNomeExame());
                                //jTextFieldDesc.setText(ex.getDesc());
                                        
                                        jTextFieldData.setText(ex.getData());
                                                jTextFieldForma.setText(ex.getForma());
                                                jTextFieldMedico.setText(ex.getMedico());
                                                jTextFieldReceita.setText(ex.getRetorno());
                                                                       
                              jTextFieldReceita.setText(ex.getRetorno());
                                                
                                                             
    
                } else{
                    
                 jTextFieldDesc.setText(nf.format(valorFinal));
                  jTextFieldValor.setText(nf.format(ex.getValor())); 
                  jTextFieldNomePessoa.setText(ex.getPaciente());
                jTextFieldNomePessoaCPF.setText(ex.getCpf());
                        jTextFieldPlano.setText(ex.getPlano());
                        jTextFieldPorcentagem.setText(String.format("%-4s %%",ex.getPorcentagem()));
                        
                                jTextFieldNomeExame.setText(ex.getNomeExame());
                                //jTextFieldDesc.setText(ex.getDesc());
                                        
                                        jTextFieldData.setText(ex.getData());
                                                jTextFieldForma.setText(ex.getForma());
                                                jTextFieldMedico.setText(ex.getMedico());
                                                jTextFieldReceita.setText(ex.getRetorno());
                                                                       
                              jTextFieldReceita.setText(ex.getRetorno());
                                                
                                                             
    
                
                }
             

                
                          
                                                    

             // System.out.println(nf.format(valorFinal));
    
            
        } catch (Exception e) {
        }
        
         
         
         
       
                                                    
               
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                     
                                                
                                   
  

                                                
                                                
                                                

            i++;
            }
            

    


    }//GEN-LAST:event_jTableRelatorioExamesAvançadasMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        
                List lista = new ArrayList();
                
                for (int i = 0; i <jTableRelatorioExamesAvançadas.getRowCount(); i++) {
            
                    relatorioAvancadoModelo consultas = new relatorioAvancadoModelo(jTableRelatorioExamesAvançadas.getValueAt(i, 0).toString(),jTableRelatorioExamesAvançadas.getValueAt(i, 1).toString(),jTableRelatorioExamesAvançadas.getValueAt(i, 2).toString(),jTableRelatorioExamesAvançadas.getValueAt(i, 3).toString(),jTableRelatorioExamesAvançadas.getValueAt(i, 4).toString(),jTableRelatorioExamesAvançadas.getValueAt(i, 5).toString(),jTableRelatorioExamesAvançadas.getValueAt(i, 6).toString(),jTableRelatorioExamesAvançadas.getValueAt(i, 7).toString());
                    lista.add(consultas);
        }
        

                
                try {
            
                    
                     Map parametros = new HashMap();  
  
          JasperPrint print = JasperFillManager.fillReport("C:/Users/Franciosney Souza/Documents/NetBeansProjects/auroClin/RelatoriosProntos/relatorioAvancadoExameConsulta.jasper", 
                    parametros,new JRBeanCollectionDataSource(lista));
            
            JasperViewer  vj = new JasperViewer(print,false);
            vj.setVisible(true);
            
            
                    
                    
                    
        } catch (Exception e) {
        }
                
                
                     

        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jTextFieldNomeMedicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeMedicoKeyPressed
        // TODO add your handling code here:
        buscarExamePorNomeData();
    }//GEN-LAST:event_jTextFieldNomeMedicoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       buscarExamePorNomeData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldNomeConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeConsultaKeyPressed
        // TODO add your handling code here:

        buscarExamePorNomeData();

    }//GEN-LAST:event_jTextFieldNomeConsultaKeyPressed

    private void jTextFieldDiaMesAnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiaMesAnoKeyPressed
        // TODO add your handling code here:
      buscarExamePorNomeData();
    }//GEN-LAST:event_jTextFieldDiaMesAnoKeyPressed

    private void jTextFieldHorarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHorarioKeyPressed
        // TODO add your handling code here:
      buscarExamePorNomeData();
    }//GEN-LAST:event_jTextFieldHorarioKeyPressed

    private void jTextFieldNomeClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeClienteKeyPressed
        // TODO add your handling code here:
        
        buscarExamePorNomeData();
    }//GEN-LAST:event_jTextFieldNomeClienteKeyPressed

    private void jTextFieldDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        
        if (jTextFieldNomePessoa.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um exame na Tabela Acima");
            
        }else{
        
        
            
          List lista = new ArrayList();
                
             String paciente = jTextFieldNomePessoa.getText();
             String cpf= jTextFieldNomePessoaCPF.getText();
             String nomeExame= jTextFieldNomeExame.getText();
             String data= jTextFieldData.getText();
             String forma= jTextFieldForma.getText();
             String valor = jTextFieldValor.getText();
             String plano = jTextFieldPlano.getText();
             String desc = jTextFieldDesc.getText();
             String porcentagem = jTextFieldPorcentagem.getText();
             String medico = jTextFieldMedico.getText();
             String receita = jTextFieldReceita.getText();
             
         
                    imprimirComprovanteModelo comprov = new imprimirComprovanteModelo(paciente,cpf,nomeExame,data,forma,valor,plano,desc,porcentagem,medico,receita);
                    lista.add(comprov);
                    
                    
                    try {
                        
                          
                      Map parametros = new HashMap();  

          JasperPrint print = JasperFillManager.fillReport("C:/Users/Franciosney Souza/Documents/NetBeansProjects/auroClin/RelatoriosProntos/imprimirComprovante.jasper", 
                    parametros,new JRBeanCollectionDataSource(lista));
            
            JasperViewer  vj = new JasperViewer(print,false);
            vj.setVisible(true);
    
            
        } catch (Exception e) {
            
                        JOptionPane.showMessageDialog(rootPane, e);
            
        }
                    
                  
        
        
            
            
        
        }
        
        
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
            java.util.logging.Logger.getLogger(RelatorioAvancadodeExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioAvancadodeExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioAvancadodeExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioAvancadodeExames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioAvancadodeExames().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRelatorioExamesAvançadas;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldDesc;
    private javax.swing.JTextField jTextFieldDiaMesAno;
    private javax.swing.JTextField jTextFieldForma;
    private javax.swing.JTextField jTextFieldHorario;
    private javax.swing.JTextField jTextFieldMedico;
    private javax.swing.JTextField jTextFieldNomeCliente;
    private javax.swing.JTextField jTextFieldNomeConsulta;
    private javax.swing.JTextField jTextFieldNomeExame;
    private javax.swing.JTextField jTextFieldNomeMedico;
    private javax.swing.JTextField jTextFieldNomePessoa;
    private javax.swing.JTextField jTextFieldNomePessoaCPF;
    private javax.swing.JTextField jTextFieldPlano;
    private javax.swing.JTextField jTextFieldPorcentagem;
    private javax.swing.JTextField jTextFieldReceita;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
