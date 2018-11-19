/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.FluxodeCaixaDAO;
import DAO.RelatorioFluxoCaixaDAO;
import DAO.relatoriosDao;
import br.auroClin.model.Exame;
import br.auroClin.model.IrreporterRelatorioFluxodeCaixa;
import br.auroClin.model.RelatorioFluxoCaixaModelo;
import br.auroClin.model.relatorioExame;
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
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
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
public class RelatorioCaixa extends javax.swing.JFrame {

    /**
     * Creates new form RelatorioCaixa
     */
    
    
    
    
    
    
     public void listarFluxoDia(){

     
   SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();  
                    
    
        try {
            
            RelatorioFluxoCaixaDAO daof = new RelatorioFluxoCaixaDAO();
            List<RelatorioFluxoCaixaModelo> listaRelatorioFluxo = daof.relatoriosDoDia(dataAtual);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableFluxo.getModel();
            modelo.setNumRows(0);
            
            
            NumberFormat format = NumberFormat.getCurrencyInstance();
          
int trazacoes = 0;
float soma = 0;
float totalLucro = 0;
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
                     
                     totalLucro = totalLucro + desconto;
                     
                     
                 }
                 
                jTextFieldLucro.setText(Float.toString(totalLucro));
                 
              
                /*
                
                    String dataBancoVindo = ex.getDataFazer();
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = (Date)formatter.parse(dataBancoVindo);
                    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");
                
                */
        
                
                
                
                
modelo.addRow(new String[i]);
jTableFluxo.setValueAt(ex.getServico(), i, 0);
jTableFluxo.setValueAt(format.format(ex.getValor()), i, 1);
jTableFluxo.setValueAt(ex.getPagamento(), i, 2);
jTableFluxo.setValueAt(ex.getVendedor(), i, 3);
jTableFluxo.setValueAt(ex.getDataVenda(), i, 4);
jTableFluxo.setValueAt(ex.getHoraVenda(), i, 5);
jTableFluxo.setValueAt(ex.getCancelar(), i, 6);

  
 

            i++;
         
            }
            
           
            jTextFieldLucro.setText(format.format(totalLucro));
            //System.out.println(soma);
            jTextFieldBruto.setText(format.format(soma));
            //String somar = Integer.toString((int) soma);
           jTextFieldTrazacoes.setText(Integer.toString(trazacoes));
           //jTextFieldBruto.setText(somar);
            
        } catch (Exception e) {
        
        
        }
        
        
        }
    
    
     
     public void listarFluxoData(String tipo, String dataBanco){

 
          
    
        try {
            
            RelatorioFluxoCaixaDAO daof = new RelatorioFluxoCaixaDAO();
            List<RelatorioFluxoCaixaModelo> listaRelatorioFluxo = daof.relatoriosCaixaPorData(tipo, dataBanco);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableFluxo.getModel();
            modelo.setNumRows(0);
            
            
            NumberFormat format = NumberFormat.getCurrencyInstance();
          
int trazacoes = 0;
float soma = 0;
float totalLucro = 0;

            int i = 0;
            for(RelatorioFluxoCaixaModelo ex: listaRelatorioFluxo){
                
              trazacoes = trazacoes + 1;
              float valorServicoMostrar =  ex.getValor();
              
                  String cancelar = ex.getCancelar();
    
                if (cancelar.equals("CANCELAR")) {
                    
                    valorServicoMostrar = 0;
                    
                }else{
                
                   valorServicoMostrar =  ex.getValor(); 
              
                      
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
                     
                     totalLucro = totalLucro + desconto;
                     
                     
                 }
                 
                jTextFieldLucro.setText(Float.toString(totalLucro));
                 
                    
                    
                    
                
                }

        
                

                
                
modelo.addRow(new String[i]);
jTableFluxo.setValueAt(ex.getServico(), i, 0);
jTableFluxo.setValueAt(format.format(valorServicoMostrar), i, 1);
jTableFluxo.setValueAt(ex.getPagamento(), i, 2);
jTableFluxo.setValueAt(ex.getVendedor(), i, 3);
jTableFluxo.setValueAt(ex.getDataVenda(), i, 4);
jTableFluxo.setValueAt(ex.getHoraVenda(), i, 5);
jTableFluxo.setValueAt(ex.getCancelar(), i, 6);

  
 

            i++;
         
            }
            
           
            jTextFieldLucro.setText(format.format(totalLucro));
            //System.out.println(soma);
            jTextFieldBruto.setText(format.format(soma));
            //String somar = Integer.toString((int) soma);
           jTextFieldTrazacoes.setText(Integer.toString(trazacoes));
           //jTextFieldBruto.setText(somar);
            
        } catch (Exception e) {
        
        
        }
        
        
        }
    
    
     
     
     
     public void listarFluxoDinheiro(String tipo, String dataBanco,String formaPaga){

 
          
    
        try {
            
            RelatorioFluxoCaixaDAO daof = new RelatorioFluxoCaixaDAO();
            List<RelatorioFluxoCaixaModelo> listaRelatorioFluxo = daof.relatoriosDinheiro(tipo, dataBanco, formaPaga);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableFluxo.getModel();
            modelo.setNumRows(0);
            
            
            NumberFormat format = NumberFormat.getCurrencyInstance();
          
int trazacoes = 0;
float soma = 0;
float totalLucro = 0;

            int i = 0;
            for(RelatorioFluxoCaixaModelo ex: listaRelatorioFluxo){
                
              trazacoes = trazacoes + 1;
              float valorServicoMostrar =  ex.getValor();
              
                  String cancelar = ex.getCancelar();
    
                if (cancelar.equals("CANCELAR")) {
                    
                    valorServicoMostrar = 0;
                    
                }else{
                
                   valorServicoMostrar =  ex.getValor(); 
              
                      
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
                     
                     totalLucro = totalLucro + desconto;
                     
                     
                 }
                 
                jTextFieldLucro.setText(Float.toString(totalLucro));
                 
                    
                    
                    
                
                }

        
                

                
                
modelo.addRow(new String[i]);
jTableFluxo.setValueAt(ex.getServico(), i, 0);
jTableFluxo.setValueAt(format.format(valorServicoMostrar), i, 1);
jTableFluxo.setValueAt(ex.getPagamento(), i, 2);
jTableFluxo.setValueAt(ex.getVendedor(), i, 3);
jTableFluxo.setValueAt(ex.getDataVenda(), i, 4);
jTableFluxo.setValueAt(ex.getHoraVenda(), i, 5);
jTableFluxo.setValueAt(ex.getCancelar(), i, 6);

  
 

            i++;
         
            }
            
           
            jTextFieldLucro.setText(format.format(totalLucro));
            //System.out.println(soma);
            jTextFieldBruto.setText(format.format(soma));
            //String somar = Integer.toString((int) soma);
           jTextFieldTrazacoes.setText(Integer.toString(trazacoes));
           //jTextFieldBruto.setText(somar);
            
        } catch (Exception e) {
        
        
        }
        
        
        }
    
     
     
     
     
     public void listarFluxoCartao(String tipo, String dataBanco,String formaPaga){

 
          
    
        try {
            
            RelatorioFluxoCaixaDAO daof = new RelatorioFluxoCaixaDAO();
            List<RelatorioFluxoCaixaModelo> listaRelatorioFluxo = daof.relatoriosCartao(tipo, dataBanco, formaPaga);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableFluxo.getModel();
            modelo.setNumRows(0);
            
            
            NumberFormat format = NumberFormat.getCurrencyInstance();
          
int trazacoes = 0;
float soma = 0;
float totalLucro = 0;

            int i = 0;
            for(RelatorioFluxoCaixaModelo ex: listaRelatorioFluxo){
                
              trazacoes = trazacoes + 1;
              float valorServicoMostrar =  ex.getValor();
              
                  String cancelar = ex.getCancelar();
    
                if (cancelar.equals("CANCELAR")) {
                    
                    valorServicoMostrar = 0;
                    
                }else{
                
                   valorServicoMostrar =  ex.getValor(); 
              
                      
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
                     
                     totalLucro = totalLucro + desconto;
                     
                     
                 }
                 
                jTextFieldLucro.setText(Float.toString(totalLucro));
                 
                    
                    
                    
                
                }

        
                

                
                
modelo.addRow(new String[i]);
jTableFluxo.setValueAt(ex.getServico(), i, 0);
jTableFluxo.setValueAt(format.format(valorServicoMostrar), i, 1);
jTableFluxo.setValueAt(ex.getPagamento(), i, 2);
jTableFluxo.setValueAt(ex.getVendedor(), i, 3);
jTableFluxo.setValueAt(ex.getDataVenda(), i, 4);
jTableFluxo.setValueAt(ex.getHoraVenda(), i, 5);
jTableFluxo.setValueAt(ex.getCancelar(), i, 6);

  
 

            i++;
         
            }
            
           
            jTextFieldLucro.setText(format.format(totalLucro));
            //System.out.println(soma);
            jTextFieldBruto.setText(format.format(soma));
            //String somar = Integer.toString((int) soma);
           jTextFieldTrazacoes.setText(Integer.toString(trazacoes));
           //jTextFieldBruto.setText(somar);
            
        } catch (Exception e) {
        
        
        }
        
        
        }
    
     
     
     
     public void listarFluxoMes(String tipo, String dataBanco){

 
          
    
        try {
            
            RelatorioFluxoCaixaDAO daof = new RelatorioFluxoCaixaDAO();
            List<RelatorioFluxoCaixaModelo> listaRelatorioFluxo = daof.relatoriosCaixaPorMes(tipo, dataBanco);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableFluxo.getModel();
            modelo.setNumRows(0);
            
            
            NumberFormat format = NumberFormat.getCurrencyInstance();
          
int trazacoes = 0;
float soma = 0;
float totalLucro = 0;

            int i = 0;
            for(RelatorioFluxoCaixaModelo ex: listaRelatorioFluxo){
                
              trazacoes = trazacoes + 1;
              float valorServicoMostrar =  ex.getValor();
              
                  String cancelar = ex.getCancelar();
    
                if (cancelar.equals("CANCELAR")) {
                    
                    valorServicoMostrar = 0;
                    
                }else{
                
                   valorServicoMostrar =  ex.getValor(); 
              
                      
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
                     
                     totalLucro = totalLucro + desconto;
                     
                     
                 }
                 
                jTextFieldLucro.setText(Float.toString(totalLucro));
                 
                    
                    
                    
                
                }

        
                

                
                
modelo.addRow(new String[i]);
jTableFluxo.setValueAt(ex.getServico(), i, 0);
jTableFluxo.setValueAt(format.format(valorServicoMostrar), i, 1);
jTableFluxo.setValueAt(ex.getPagamento(), i, 2);
jTableFluxo.setValueAt(ex.getVendedor(), i, 3);
jTableFluxo.setValueAt(ex.getDataVenda(), i, 4);
jTableFluxo.setValueAt(ex.getHoraVenda(), i, 5);
jTableFluxo.setValueAt(ex.getCancelar(), i, 6);

  
 

            i++;
         
            }
            
           
            jTextFieldLucro.setText(format.format(totalLucro));
            //System.out.println(soma);
            jTextFieldBruto.setText(format.format(soma));
            //String somar = Integer.toString((int) soma);
           jTextFieldTrazacoes.setText(Integer.toString(trazacoes));
           //jTextFieldBruto.setText(somar);
            
        } catch (Exception e) {
        
        
        }
        
        
        }
    
    
     
     
     
    
    public RelatorioCaixa() {
        initComponents();
        
        
         
         JTableHeader headerPaciente = jTableFluxo.getTableHeader();   
    headerPaciente.setPreferredSize(new Dimension(0, 25)); 
    headerPaciente.setFont(new Font("��������", Font.PLAIN, 14));
	headerPaciente.setPreferredSize(new Dimension(headerPaciente.getWidth(),25));
 jTableFluxo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableFluxo.getColumnModel().getColumn(0).setPreferredWidth(250);
jTableFluxo.getColumnModel().getColumn(1).setPreferredWidth(120);
jTableFluxo.getColumnModel().getColumn(2).setPreferredWidth(110);
jTableFluxo.getColumnModel().getColumn(3).setPreferredWidth(175);
jTableFluxo.getColumnModel().getColumn(4).setPreferredWidth(110);
jTableFluxo.getColumnModel().getColumn(5).setPreferredWidth(90);
jTableFluxo.getColumnModel().getColumn(6).setPreferredWidth(110);
jTableFluxo.getParent().setBackground(Color.WHITE);

jTableFluxo.setRowHeight(23); 
        
      
   SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();  
                    
        jLabel2.setText("         RELATORIOS DO CAIXA   "+dataAtual);
        


DefaultTableCellRenderer coluna = new DefaultTableCellRenderer();
coluna.setForeground(Color.BLACK); // fonte azul
coluna.setBackground(new java.awt.Color(204, 204, 255)); // fundo amarelo


jTableFluxo.getColumnModel().getColumn(1).setCellRenderer(coluna); 


jTextFieldBusca.setText("ATIVO");

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFluxo = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButtonFechar4 = new javax.swing.JButton();
        jTextFieldBruto = new javax.swing.JTextField();
        jTextFieldTrazacoes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButtontTodos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jMonthChooserMes = new com.toedter.calendar.JMonthChooser();
        jYearChooserAno = new com.toedter.calendar.JYearChooser();
        jButtonTodosMes = new javax.swing.JButton();
        jComboBoxBusca = new javax.swing.JComboBox<>();
        jTextFieldBusca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButtonEspecie = new javax.swing.JButton();
        jButtonCartao = new javax.swing.JButton();
        jButtonCartaoMes = new javax.swing.JButton();
        jButtonDinehroMes = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldLucro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/lucroFundo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 0));
        jLabel2.setText("      RELATÓRIO DO FLUXO DE CAIXA       ");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableFluxo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableFluxo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Serviço", "Valor Pago", "Forma Paga", "Vendedor", "Data venda", "Hora", "OBS"
            }
        ));
        jScrollPane1.setViewportView(jTableFluxo);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/icon01.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButtonFechar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar4.setToolTipText("Fechar");
        jButtonFechar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFechar4ActionPerformed(evt);
            }
        });

        jTextFieldBruto.setBackground(new java.awt.Color(204, 204, 255));
        jTextFieldBruto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("TRANZAÇÕES");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("VALOR PAGO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("RELATÓRIO POR DIA");

        jButtontTodos.setText("TODOS");
        jButtontTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtontTodosActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("RELATÓRIO POR MÊS");

        jMonthChooserMes.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N

        jButtonTodosMes.setText("TODOS");
        jButtonTodosMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTodosMesActionPerformed(evt);
            }
        });

        jComboBoxBusca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pagamentos Ativos", "Pagamentos Cancelados" }));
        jComboBoxBusca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxBuscaItemStateChanged(evt);
            }
        });

        jTextFieldBusca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("SELECIONE UMA OPÇÃO");

        jButton6.setText("Relatório Avançado do Caixa");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButtonEspecie.setText("ESPECIE");
        jButtonEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspecieActionPerformed(evt);
            }
        });

        jButtonCartao.setText("CARTÃO");
        jButtonCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCartaoActionPerformed(evt);
            }
        });

        jButtonCartaoMes.setText("CARTÃO");
        jButtonCartaoMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCartaoMesActionPerformed(evt);
            }
        });

        jButtonDinehroMes.setText("ESPECIE");
        jButtonDinehroMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDinehroMesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBoxBusca, 0, 204, Short.MAX_VALUE)
                                .addGap(116, 116, 116))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButtonCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtontTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(91, 91, 91))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jMonthChooserMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jYearChooserAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonDinehroMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCartaoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTodosMes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jTextFieldBusca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtontTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jYearChooserAno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMonthChooserMes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTodosMes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCartaoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDinehroMes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("MARGEM DE LUCRO");

        jTextFieldLucro.setBackground(new java.awt.Color(0, 255, 204));
        jTextFieldLucro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonFechar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTrazacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14, 14, 14)
                                .addComponent(jTextFieldBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonFechar4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldTrazacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(29, 29, 29)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(73, 73, 73))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1300, 700);

        setSize(new java.awt.Dimension(1300, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        
          
        String validar = jTextFieldTrazacoes.getText();
        String bruto = jTextFieldBruto.getText();
        
        if (validar.equals("")) {
            
        JOptionPane.showMessageDialog(rootPane, "Faça uma Busca para Imprimir!");
            
            
        }else{
        
            
            
        
        String tranzacoes = jTextFieldTrazacoes.getText();
        String somaLucro=  jTextFieldLucro.getText();
        
        
  
             List lista = new ArrayList();
                
                for (int i = 0; i < jTableFluxo.getRowCount(); i++) {
            
                    IrreporterRelatorioFluxodeCaixa relatorio = new IrreporterRelatorioFluxodeCaixa(jTableFluxo.getValueAt(i, 0).toString(),jTableFluxo.getValueAt(i, 1).toString(),jTableFluxo.getValueAt(i, 2).toString(),jTableFluxo.getValueAt(i, 3).toString(),jTableFluxo.getValueAt(i, 4).toString(),jTableFluxo.getValueAt(i, 5).toString(),jTableFluxo.getValueAt(i, 6).toString(),bruto);
                    lista.add(relatorio);
        }
        
                

             
               try {
                    
             
            
               
                      Map parametros = new HashMap();  
  parametros.put("Titulo", "Relatório de Consultas do Mês 0"+somaLucro);
          JasperPrint print = JasperFillManager.fillReport("C:/Users/Franciosney Souza/Documents/NetBeansProjects/auroClin/RelatoriosProntos/IreporterRelatoriodoCaixa.jasper", 
                    parametros,new JRBeanCollectionDataSource(lista));
            
            JasperViewer  vj = new JasperViewer(print,false);
            vj.setVisible(true);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
   
   
            
            
            
        
        }
        
        
        
        
        

    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        listarFluxoDia();
    }//GEN-LAST:event_formWindowActivated

    private void jButtonFechar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFechar4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFechar4ActionPerformed

    private void jButtonCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCartaoActionPerformed
        // TODO add your handling code here:
        
          
       Date dataRealizar;
        dataRealizar = jDateChooser1.getDate();

        if (dataRealizar == null) {

            JOptionPane.showMessageDialog(rootPane, "Por Favor! Digite uma Data Para Busca!");
            jDateChooser1.setBorder(BorderFactory.createLineBorder(Color.red));

        } else if(jTextFieldBusca.getText().equals("")){

            JOptionPane.showMessageDialog(rootPane, "Por Favor! Selecione um tipo de Busca!");
            jTextFieldBusca.setBorder(BorderFactory.createLineBorder(Color.red));

        } else{

            Date dataRealizarB = jDateChooser1.getDate();
            SimpleDateFormat farmato = new SimpleDateFormat("dd/MM/yyyy");
            String dataBanco = farmato.format(dataRealizarB);
            
            String formaPaga = "DINHEIRO";

            String tipo = jTextFieldBusca.getText();

            listarFluxoCartao(tipo, dataBanco, formaPaga);

            jLabel2.setText("         RELATORIOS DO CAIXA  DIA "+dataBanco);
        }
 
        
    }//GEN-LAST:event_jButtonCartaoActionPerformed

    private void jButtonEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspecieActionPerformed
        // TODO add your handling code here:
        
       Date dataRealizar;
        dataRealizar = jDateChooser1.getDate();

        if (dataRealizar == null) {

            JOptionPane.showMessageDialog(rootPane, "Por Favor! Digite uma Data Para Busca!");
            jDateChooser1.setBorder(BorderFactory.createLineBorder(Color.red));

        } else if(jTextFieldBusca.getText().equals("")){

            JOptionPane.showMessageDialog(rootPane, "Por Favor! Selecione um tipo de Busca!");
            jTextFieldBusca.setBorder(BorderFactory.createLineBorder(Color.red));

        } else{

            Date dataRealizarB = jDateChooser1.getDate();
            SimpleDateFormat farmato = new SimpleDateFormat("dd/MM/yyyy");
            String dataBanco = farmato.format(dataRealizarB);
            
            String formaPaga = "DINHEIRO";

            String tipo = jTextFieldBusca.getText();

            listarFluxoDinheiro(tipo, dataBanco, formaPaga);

            jLabel2.setText("         RELATORIOS DO CAIXA  DIA "+dataBanco);
        }
 
        
        
    }//GEN-LAST:event_jButtonEspecieActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        RelatorioMedico tela = new RelatorioMedico();
        tela.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBoxBuscaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxBuscaItemStateChanged
        // TODO add your handling code here:

        String nome = (String) jComboBoxBusca.getSelectedItem();

        if (nome.equals("Pagamentos Ativos")) {

            nome = "ATIVO";

        }else{

            nome = "CANCELAR";

        }

        jTextFieldBusca.setText(nome);

    }//GEN-LAST:event_jComboBoxBuscaItemStateChanged

    private void jButtonTodosMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTodosMesActionPerformed
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

        String tipo = jTextFieldBusca.getText();

        listarFluxoMes(tipo, dataBanco);

        jLabel2.setText("         RELATORIOS DO CAIXA  MÊS 0"+dataBanco);

    }//GEN-LAST:event_jButtonTodosMesActionPerformed

    private void jButtontTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontTodosActionPerformed
        // TODO add your handling code here:

        Date dataRealizar;
        dataRealizar = jDateChooser1.getDate();

        if (dataRealizar == null) {

            JOptionPane.showMessageDialog(rootPane, "Por Favor! Digite uma Data Para Busca!");
            jDateChooser1.setBorder(BorderFactory.createLineBorder(Color.red));

        } else if(jTextFieldBusca.getText().equals("")){

            JOptionPane.showMessageDialog(rootPane, "Por Favor! Selecione um tipo de Busca!");
            jTextFieldBusca.setBorder(BorderFactory.createLineBorder(Color.red));

        } else{

            Date dataRealizarB = jDateChooser1.getDate();
            SimpleDateFormat farmato = new SimpleDateFormat("dd/MM/yyyy");
            String dataBanco = farmato.format(dataRealizarB);

            String tipo = jTextFieldBusca.getText();

            listarFluxoData(tipo,dataBanco);

            jLabel2.setText("         RELATORIOS DO CAIXA  DIA "+dataBanco);
        }

    }//GEN-LAST:event_jButtontTodosActionPerformed

    private void jButtonCartaoMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCartaoMesActionPerformed
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

        String tipo = jTextFieldBusca.getText();
         String formaPaga = "DINHEIRO";
        listarFluxoCartao(tipo, dataBanco, formaPaga);

        jLabel2.setText("         RELATORIOS DO CAIXA  MÊS 0"+dataBanco);
        
        
    }//GEN-LAST:event_jButtonCartaoMesActionPerformed

    private void jButtonDinehroMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDinehroMesActionPerformed
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

        String tipo = jTextFieldBusca.getText();
         String formaPaga = "DINHEIRO";
        listarFluxoDinheiro(tipo, dataBanco, formaPaga);

        jLabel2.setText("         RELATORIOS DO CAIXA  MÊS 0"+dataBanco);
        
        
    }//GEN-LAST:event_jButtonDinehroMesActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonCartao;
    private javax.swing.JButton jButtonCartaoMes;
    private javax.swing.JButton jButtonDinehroMes;
    private javax.swing.JButton jButtonEspecie;
    private javax.swing.JButton jButtonFechar4;
    private javax.swing.JButton jButtonTodosMes;
    private javax.swing.JButton jButtontTodos;
    private javax.swing.JComboBox<String> jComboBoxBusca;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.toedter.calendar.JMonthChooser jMonthChooserMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFluxo;
    private javax.swing.JTextField jTextFieldBruto;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldLucro;
    private javax.swing.JTextField jTextFieldTrazacoes;
    private com.toedter.calendar.JYearChooser jYearChooserAno;
    // End of variables declaration//GEN-END:variables
}
