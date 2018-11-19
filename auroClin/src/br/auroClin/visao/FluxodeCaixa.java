/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.AbrirCaixaDAO;
import DAO.FluxodeCaixaDAO;
import DAO.VendaDAO;
import DAO.planosDAO;
import br.auroClin.model.AbrirCaixaModel;
import br.auroClin.model.ControleLog;

import br.auroClin.model.FluxoDeCaixaModelo;
import br.auroClin.model.ValorCaixaModel;
import br.auroClin.model.VendaModel;
import br.auroClin.model.formaPagamentoBuscar;
import br.auroClin.model.planoMODELO;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Franciosney Souza
 */
public class FluxodeCaixa extends javax.swing.JFrame {

    /**
     * Creates 
     * new form FluxodeCaixa
     */
    
    PagamentoCartao pagCartao;

    
    public void registrarVenda(){
    
        
        try {
            
            
              String teste = jTextFieldPagar.getText();    
      NumberFormat format = NumberFormat.getCurrencyInstance();
      String valorVenda = format.parse(teste).toString();

//pegando a hora do sistema
  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
Date hora = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
String dataFormatada = sdf.format(hora);
        System.out.println(dataFormatada);
//registrar a venda e validar o funcionario responsavel 
                VendaModel objv = new VendaModel();
                objv.setValorVenda(Float.parseFloat(valorVenda));
                objv.setHoraVenda(dataFormatada);
                String ativo = "ATIVO";
                objv.setCancelar(ativo);
                String formaPagamento = "DINHEIRO";
                objv.setFormaPagamento(formaPagamento);
                 int idVenda = Integer.parseInt(jTextFieldIdVenda.getText()); 
                 ControleLog objc = new ControleLog();
                 
                 int idFuncionario = objc.getId_funcionario();
                 objv.setId_funcionario(idFuncionario);
                objv.setId_marcar(idVenda);
                
                VendaDAO daov = new VendaDAO();
                daov.cadastrarVenda(objv);
                
                
            
            
            
            
        } catch (Exception e) {
        }
        
       
    
        
        
    
    
    }
    
    
    public void atualixaAtabelaComDadosdoBanco(){

        SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();

        FluxodeCaixaDAO dao = new FluxodeCaixaDAO();


        
        

        try {


            List<FluxoDeCaixaModelo> listaConsulta = dao.listarCaixa(dataAtual);
            
      

            DefaultTableModel modelo = (DefaultTableModel)jTableCaixa.getModel();
            modelo.setNumRows(0);

            
            
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            
            
            double somaAbertos = 0;
            

            int i = 0;
            for(FluxoDeCaixaModelo ex: listaConsulta){
                modelo.addRow(new String[i]);

                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = (Date)formatter.parse(ex.getDataRelizarServico());
                SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");

                double receberValor = ex.getPreco();
                
                     jTextFieldDescontos.setText(nf.format(ex.getDesconto()));
                       jTextFiedValorTotal.setText(nf.format(ex.getValorTotal()));
                     
               
                
                if (ex.getSituacao().equals("ABERTA")) {
                    
                     somaAbertos = somaAbertos + receberValor;
                    
                }
                
jTableCaixa.setValueAt(ex.getId_venda(), i, 0);
jTableCaixa.setValueAt(ex.getDataVenda(), i, 1);
jTableCaixa.setValueAt(ex.getNomePaciente(), i, 2);
jTableCaixa.setValueAt(ex.getServico(), i, 3);
jTableCaixa.setValueAt(nf.format(ex.getPreco()), i, 4);
jTableCaixa.setValueAt(nf.format(ex.getDescontoIndividual()), i, 5);
jTableCaixa.setValueAt(formatoRetorno.format(date), i, 6);
jTableCaixa.setValueAt(ex.getSituacao(), i, 7);
jTableCaixa.setValueAt(ex.getFormaPagamento(), i, 8);




                i++;
            }
            NumberFormat dinheiro = NumberFormat.getCurrencyInstance();
            
            double converter = somaAbertos;
            
            jTextFiedValorAberto.setText(dinheiro.format(converter));
           
        SimpleDateFormat forDataC = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calC = Calendar.getInstance();
        String dataCaixa = forData.format(cal.getTime());
        cal.getTime();
            
            List<ValorCaixaModel> listaCaixa = dao.valorCaixa(dataCaixa);
            
               for(ValorCaixaModel ex: listaCaixa){
               
              jTextFiedValorCaixa.setText(nf.format(ex.getValorCaixa()));
                   
                   
                   
               
               }
            
            

        } catch (Exception e) {}
        
   
        
        valordoCaixa();

    }
    
    
    
    public void valordoCaixa(){
        
         SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
        
            
            NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        
            FluxodeCaixaDAO dao = new FluxodeCaixaDAO();
    
     List<ValorCaixaModel> listaCaixa = dao.valorCaixa(dataAtual);
            
               for(ValorCaixaModel ex: listaCaixa){
               
              jTextFiedValorCaixa.setText(nf.format(ex.getValorCaixa()));
              jTextFiedValorCartao.setText(nf.format(ex.getValorCartao()));
    
               
               }
            
    
    
    }
    
   public void teste(){
   
          
jTableCaixa.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    
     private String CLASS = "PAGA";
     private String CLASSS = "ABERTA";
     @Override
    public JLabel getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, 
            int row, int column)
    {
        
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        
        Color c = Color.WHITE;
        
        Object testo = jTableCaixa.getValueAt(row, 7);
        Object testoT = jTableCaixa.getValueAt(row, 7);
        
        if (testo != null && CLASS.equals(testo.toString())){
         
           c = new java.awt.Color(0, 255, 204);
      
            //label.setBackground(c);
        
              //label.setForeground(c);      
              //jTableCaixa.setSelectionBackground(Color.RED);
        }
   
            
           
         if (testoT != null && CLASSS.equals(testoT.toString())){
         
         c = Color.WHITE;
     
             
         }
        
                label.setBackground(c);
                 jTableCaixa.setSelectionForeground(Color.RED);
                 
        
         return label;
    }

    
});
   
   }
   
   
   public void testePlano(){
   
       
   }
   
   
    public void controlePlanos(){

        SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();

        FluxodeCaixaDAO dao = new FluxodeCaixaDAO();


        
         
           

       {


            List<FluxoDeCaixaModelo> listaConsulta = dao.listarCaixa(dataAtual);

            DefaultTableModel modelo = (DefaultTableModel)jTableCaixa.getModel();
            modelo.setNumRows(0);

            NumberFormat nf = NumberFormat.getCurrencyInstance();
            
           try {
               
               
               
               
               
               
               
                  int i = 0;
                  float somaAbertos = 0;
                  float valorTotalAberto = 0;
                  float valorDescontos = 0;
            for(FluxoDeCaixaModelo ex: listaConsulta){
                modelo.addRow(new String[i]);
                
               
                
                  FluxodeCaixaDAO daoc = new FluxodeCaixaDAO();
            List<planoMODELO> listaplanos = daoc.BuscarPlanosValidar();
                String planosValidar = null;
                String planoPAciente = ex.getPlano();
                System.out.println(planoPAciente);
                
                
                 for(planoMODELO lm: listaplanos){
                 planosValidar = lm.getNomePlano();
          
                 
                 String planoVindo = null;
                 float descontoDoPlano = 0;
                 
                 
                     if (planoPAciente.equals(planosValidar)) {

                          planoVindo = lm.getNomePlano();
                          descontoDoPlano = lm.getDesconto();
                          float porcentagemDesconto = descontoDoPlano/100;
                          float valorTotal = ex.getValorVenda();
                          float valorVendaDesconto = valorTotal * porcentagemDesconto; 
                          
                          
                          float valorPagarFinal = valorTotal - valorVendaDesconto; 
                         
                          //float valorDesconto = 
                          
                          
                           valorTotalAberto = valorTotalAberto + valorTotal;
                           valorDescontos = valorDescontos + valorVendaDesconto;
                          
                          
                          
                                if (ex.getSituacao().equals("ABERTA")) {
                    
                     somaAbertos = somaAbertos + valorPagarFinal;
                    
                }
                          
                          
                          
                         
                          
                          
                                // jTextFiedValorAberto.setText(nf.format(somaAbertos));
                                  DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = (Date)formatter.parse(ex.getDataRelizarServico());
                SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");
            
jTableCaixa.setValueAt(ex.getId_venda(), i, 0);
jTableCaixa.setValueAt(ex.getDataVenda(), i, 1);
jTableCaixa.setValueAt(ex.getNomePaciente(), i, 2);
jTableCaixa.setValueAt(ex.getServico(), i, 3);
jTableCaixa.setValueAt(nf.format(valorPagarFinal), i, 4);
jTableCaixa.setValueAt(nf.format(valorVendaDesconto), i, 5);
jTableCaixa.setValueAt(formatoRetorno.format(date), i, 6);
jTableCaixa.setValueAt(ex.getSituacao(), i, 7);
jTableCaixa.setValueAt(ex.getFormaPagamento(), i, 8);


                     } 

                     
                     
            
                      
                     
    
                 }
  jTextFiedValorAberto.setText(nf.format(somaAbertos));
  jTextFiedValorTotal.setText(nf.format(valorTotalAberto));
  jTextFieldDescontos.setText(nf.format(valorDescontos));
 
                i++;
                   
            }
               
               
               
               
               
           } catch (Exception e) {
           }

            }
    }
   
   
    
    public FluxodeCaixa() {
        initComponents();
        
        
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 18)));
        
         JTableHeader header = jTableCaixa.getTableHeader();   
    header.setPreferredSize(new Dimension(0, 50)); 
    header.setFont(new Font("��������", Font.PLAIN, 16));
	header.setPreferredSize(new Dimension(header.getWidth(),40));
        
            jTableCaixa.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableCaixa.getColumnModel().getColumn(0).setPreferredWidth(70);
jTableCaixa.getColumnModel().getColumn(1).setPreferredWidth(120);
jTableCaixa.getColumnModel().getColumn(2).setPreferredWidth(380);
jTableCaixa.getColumnModel().getColumn(3).setPreferredWidth(220);
jTableCaixa.getColumnModel().getColumn(4).setPreferredWidth(110);
jTableCaixa.getColumnModel().getColumn(5).setPreferredWidth(100);
jTableCaixa.getColumnModel().getColumn(6).setPreferredWidth(110);
jTableCaixa.getColumnModel().getColumn(7).setPreferredWidth(105);
jTableCaixa.getColumnModel().getColumn(8).setPreferredWidth(60);

jTableCaixa.setRowHeight(35); 

 SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
        jLabel3.setText("Dia: "+dataAtual);
           jLabel8.setText("Dia: "+dataAtual);
           
           
          teste();
       
        jTextFiedValorCaixa.setEditable(false);
        jTextFiedValorCartao.setEditable(false);
        jTextFiedValorAberto.setEditable(false);
        jTextFiedValorTotal.setEditable(false);
        jTextFieldDescontos.setEditable(false);
        jTextFieldIdVenda.setEditable(false);
        jTextFieldNomePaciente.setEditable(false);
        jTextFieldServico.setEditable(false);
        jTextFieldPagar.setEditable(false);
        jTextFieldValorDesconto.setEditable(false);
        jTextFieldSituacao.setEditable(false);
        jTextFieldValorDesconto.setEditable(false);
          
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTextFiedValorCaixa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFiedValorCartao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCaixa = new javax.swing.JTable();
        jTextFieldNomePaciente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldServico = new javax.swing.JTextField();
        jTextFieldPagar = new javax.swing.JTextField();
        jTextFieldSituacao = new javax.swing.JTextField();
        jTextFieldValorDesconto = new javax.swing.JTextField();
        jTextFieldIdVenda = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextFiedValorTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDescontos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFiedValorAberto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButtonFechar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextFiedValorCaixa.setBackground(new java.awt.Color(0, 255, 204));
        jTextFiedValorCaixa.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("Valor no Caixa");

        jTextFiedValorCartao.setBackground(new java.awt.Color(0, 204, 204));
        jTextFiedValorCartao.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Cartão:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Dia");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFiedValorCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFiedValorCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFiedValorCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFiedValorCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 70, 590, 150);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTableCaixa.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTableCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Data da Venda", "Nome do Paciente", "Serviço", "Valor", "Desconto", "Data-Fazer", "Fatura:", "Com:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCaixaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCaixa);

        jTextFieldNomePaciente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Nome do Paciente Selecionado:");

        jTextFieldServico.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTextFieldPagar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPagarActionPerformed(evt);
            }
        });

        jTextFieldSituacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSituacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSituacaoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSituacaoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSituacaoKeyTyped(evt);
            }
        });

        jTextFieldValorDesconto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTextFieldIdVenda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("ID da Venda");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Serviço:");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Valor a Pagar:");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Desconto:");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Situação:");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 153, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/CaixaPagamento.png"))); // NOI18N
        jButton2.setText("  Pagar Fatura em Dinheiro");
        jButton2.setToolTipText("");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Cartao.png"))); // NOI18N
        jButton3.setText("  Pagar Fatura Com Cartão");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 51));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/CancelarPagamento.png"))); // NOI18N
        jButton4.setText("   Cancelar Pagamento");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204)));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldServico, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldValorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jTextFieldSituacao)
                        .addContainerGap())))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17)
                        .addComponent(jLabel19)
                        .addComponent(jLabel18)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldServico, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldSituacao, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldPagar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldValorDesconto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 230, 1280, 480);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTextFiedValorTotal.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Valor Total");

        jTextFieldDescontos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Valos em Aberto:");

        jTextFiedValorAberto.setBackground(new java.awt.Color(204, 204, 255));
        jTextFiedValorAberto.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextFiedValorAberto.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTextFiedValorAbertoComponentAdded(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("    - 30%");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Dia");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 91, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextFiedValorAberto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFiedValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDescontos)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFiedValorTotal, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFiedValorAberto, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDescontos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(610, 70, 680, 150);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 0));
        jLabel9.setText("         FLUXO DE CAIXA");
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(482, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338)
                .addComponent(jButtonFechar))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(10, 10, 1280, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/fundoCaixateste.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 20, 1300, 700);

        setSize(new java.awt.Dimension(1300, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

  
        

 
     
        // TODO add your handling code here:

        
        if (jTextFieldNomePaciente.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um pagamento na Tabela!");
            
        } 
        else{
        
            
            
            
            
         SimpleDateFormat forDataValidar = new SimpleDateFormat("dd/MM/yyyy");
        Calendar call = Calendar.getInstance();
        String dataAtualV = forDataValidar.format(call.getTime());
        call.getTime();

        AbrirCaixaDAO daovalidar = new AbrirCaixaDAO();
        
         if (daovalidar.validarCaixaAberto(dataAtualV)) {
     
        int idVenda = Integer.parseInt(jTextFieldIdVenda.getText()); 
        String situacaoVenda = jTextFieldSituacao.getText();
 
try {
            FluxodeCaixaDAO daof = new FluxodeCaixaDAO();
            List<FluxoDeCaixaModelo> listaValidarCaixa = daof.validarPagamento(idVenda, situacaoVenda);
            
  
            String validar = null;
          
            for(FluxoDeCaixaModelo ex: listaValidarCaixa){

                validar = ex.getSituacao();
            
                
            }
            
            
          
            
            
            if (validar.equals("PAGA")) {
                 
                  String valor  = jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 4).toString();
                  String nome = jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 2).toString();
               
     
   
                  UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 18)));
                  //UIManager.put("OptionPane.messageForeground", Color.black);
                  //UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 35)));
                  //UIManager.put("OptionPane.background", Color.WHITE);
                  JOptionPane.showMessageDialog(rootPane, "A fatura no valor de "+valor+" para "+nome+" ja foi paga  ");
                  
                  jTextFieldIdVenda.setText("");
                  jTextFieldNomePaciente.setText("");
                  jTextFieldServico.setText("");
                  jTextFieldPagar.setText("");
                  jTextFieldValorDesconto.setText("");
                  jTextFieldSituacao.setText("");
        
    } else{
            
                
      
                 String nomePaciente = jTextFieldNomePaciente.getText();
                
                
                 
                 int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Você deseja Realizar o Pagamento Para "+nomePaciente+"?", "Confirme", dialogButton);
            if(dialogResult == 0) {
                
 
                
                 SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
                
            
            List<AbrirCaixaModel> lista = daof.buscarCaixaParaPagamento(dataAtual);
            
            int idCaixa = 0; 
            float valorNoCaixa = 0;

            for(AbrirCaixaModel ex: lista){

                idCaixa = ex.getId_AbrirCAixa();
                valorNoCaixa = (float) ex.getValorCaixa();
    
            }  
                
            
            
            
              // Pegando o valor da Venda e Convertendo
            String teste = jTextFieldPagar.getText();    
      NumberFormat format = NumberFormat.getCurrencyInstance();
      String valorVenda = format.parse(teste).toString();
      
      
      // Salvando a venda no caixa do ultimo id Selecionado, salva o valor que esta no caixa mais a venda
      
 float valorSomado = valorNoCaixa + Float.parseFloat(valorVenda);
daof.pagamentoFaturas(valorSomado, idCaixa);

 // Coloca no id selecionado da venda que ela esta paga
 
   
                  

String situacao = "PAGA";
String formaPagamento = "D";
daof.validarMarcarComoPAGO(situacao,formaPagamento,idVenda);

 registrarVenda();
                
                
                

   UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 18)));
                JOptionPane.showMessageDialog(rootPane, "Pagamento Realizado Com Sucesso!");
              
//atualizar o valor na tela do caixa
 valordoCaixa();
 //atualizar a tabela
 atualixaAtabelaComDadosdoBanco();
            
             jTextFieldIdVenda.setText("");
                  jTextFieldNomePaciente.setText("");
                  jTextFieldServico.setText("");
                  jTextFieldPagar.setText("");
                  jTextFieldValorDesconto.setText("");
                  jTextFieldSituacao.setText("");
                
                
                
                
                
                
                
                
                
                
          
            } else{
               
                JOptionPane.showMessageDialog(rootPane, "Você Não Efetuou o Pagamento de " + nomePaciente);
                
                
            }
       
            
            }
            
            
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
    
             
        } else{ 
         
           JOptionPane.showMessageDialog(null, "O Caixa esta fechado, você não pode realizar esta operação!");
         
         }
        
        

        
        
        
        
        
        
        
        
        
        
        
        
            
            
            
            
        
        }
       
        
 
        
        
          
           
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
      //atualixaAtabelaComDadosdoBanco();
      //testePlano();
     controlePlanos();
     valordoCaixa();
        
    }//GEN-LAST:event_formWindowActivated

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jTextFiedValorAbertoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTextFiedValorAbertoComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFiedValorAbertoComponentAdded

    private void jTableCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCaixaMouseClicked
        // TODO add your handling code here:
        
          
              
jTableCaixa.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel  
jTableCaixa.addMouseListener(new MouseAdapter() {  
    public void mouseClicked(MouseEvent e)  
    {  
        if (e.getClickCount() == 2)  
        {  

           
        }  
    }  
});  
      // ---------- Fim
      
      
      
      
        jTextFieldIdVenda.setText(jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 0).toString());
        jTextFieldNomePaciente.setText(jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 2).toString());
         jTextFieldServico.setText(jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 3).toString());
         jTextFieldPagar.setText(jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 4).toString());
           jTextFieldValorDesconto.setText(jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 5).toString());
           
           String teste = jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 7).toString();
           if (teste.equals("PAGA")) {
               
                jTextFieldSituacao.setBackground(new java.awt.Color(0, 255, 204));
                jTextFieldIdVenda.setBackground(new java.awt.Color(0, 255, 204));
                         jTextFieldNomePaciente.setBackground(new java.awt.Color(0, 255, 204));
                        jTextFieldServico.setBackground(new java.awt.Color(0, 255, 204));
                                 jTextFieldPagar.setBackground(new java.awt.Color(0, 255, 204));
                                jTextFieldValorDesconto.setBackground(new java.awt.Color(0, 255, 204));
            
        } else{
           
           jTextFieldSituacao.setBackground(Color.WHITE);
           jTextFieldSituacao.setBackground(Color.WHITE);
                jTextFieldIdVenda.setBackground(Color.WHITE);
                         jTextFieldNomePaciente.setBackground(Color.WHITE);
                        jTextFieldServico.setBackground(Color.WHITE);
                                 jTextFieldPagar.setBackground(Color.WHITE);
                                jTextFieldValorDesconto.setBackground(Color.WHITE);
           
           }
           System.out.println(teste);
           
          jTextFieldSituacao.setText(jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 7).toString());
      
        
        
    }//GEN-LAST:event_jTableCaixaMouseClicked

    private void jTextFieldPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPagarActionPerformed

    private void jTextFieldSituacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSituacaoKeyPressed
        // TODO add your handling code here:
        
      
        
        
    }//GEN-LAST:event_jTextFieldSituacaoKeyPressed

    private void jTextFieldSituacaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSituacaoKeyReleased
        // TODO add your handling code here:
        
     
    }//GEN-LAST:event_jTextFieldSituacaoKeyReleased

    private void jTextFieldSituacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSituacaoKeyTyped
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTextFieldSituacaoKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
 
    }//GEN-LAST:event_formWindowOpened

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
Date hora = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
String dataFormatada = sdf.format(hora);
        System.out.println(dataFormatada);
          AbrirCaixaDAO daovalidar = new AbrirCaixaDAO();
        
                          
         SimpleDateFormat forDataValidar = new SimpleDateFormat("dd/MM/yyyy");
        Calendar call = Calendar.getInstance();
        String dataAtualV = forDataValidar.format(call.getTime());
        call.getTime();
        
        
        if (jTextFieldNomePaciente.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um pagamento na Tabela!");
            
        }else if (daovalidar.validarCaixaAberto(dataAtualV)) {
     
        int idVenda = Integer.parseInt(jTextFieldIdVenda.getText()); 
        String situacaoVenda = jTextFieldSituacao.getText();
 

            FluxodeCaixaDAO daof = new FluxodeCaixaDAO();
            List<FluxoDeCaixaModelo> listaValidarCaixa = daof.validarPagamento(idVenda, situacaoVenda);
            
  
            String validar = null;
          
            for(FluxoDeCaixaModelo ex: listaValidarCaixa){

                validar = ex.getSituacao();
            
                
            }
            
            
          
            
            
            if (validar.equals("PAGA")) {
                 
                  String valor  = jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 4).toString();
                  String nome = jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 2).toString();
               
     
   
                  UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 18)));
                  //UIManager.put("OptionPane.messageForeground", Color.black);
                  //UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 35)));
                  //UIManager.put("OptionPane.background", Color.WHITE);
                  JOptionPane.showMessageDialog(rootPane, "A fatura no valor de "+valor+" para "+nome+" ja foi paga  ");
                  
                  jTextFieldIdVenda.setText("");
                  jTextFieldNomePaciente.setText("");
                  jTextFieldServico.setText("");
                  jTextFieldPagar.setText("");
                  jTextFieldValorDesconto.setText("");
                  jTextFieldSituacao.setText("");
        
    } else{
            
              if (pagCartao == null) {
            
            pagCartao = new PagamentoCartao();
            pagCartao.setLocationRelativeTo(null);
            pagCartao.receber(jTextFieldIdVenda.getText(),jTextFieldNomePaciente.getText(),jTextFieldPagar.getText());
        }
        
          pagCartao.setFocusableWindowState(false); 
//pagCartao.setAlwaysOnTop(true);  
        pagCartao.setVisible(true);
        pagCartao.setState(PagamentoCartao.NORMAL);
         pagCartao.receber(jTextFieldIdVenda.getText(),jTextFieldNomePaciente.getText(),jTextFieldPagar.getText());
         
      
         
         
         
         
           jTextFieldIdVenda.setText("");
                  jTextFieldNomePaciente.setText("");
                  jTextFieldServico.setText("");
                  jTextFieldPagar.setText("");
                  jTextFieldValorDesconto.setText("");
                  jTextFieldSituacao.setText("");
         
         
            
            }
   } 
        
  
        
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

          int idCancelar = Integer.parseInt(jTextFieldIdVenda.getText());
        
        
        if (jTextFieldNomePaciente.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um pagamento na Tabela!");
            
        } 
        else{
        
            
           
            
            
         SimpleDateFormat forDataValidar = new SimpleDateFormat("dd/MM/yyyy");
        Calendar call = Calendar.getInstance();
        String dataAtualV = forDataValidar.format(call.getTime());
        call.getTime();

        AbrirCaixaDAO daovalidar = new AbrirCaixaDAO();
        
         if (daovalidar.validarCaixaAberto(dataAtualV)) {
     
        int idVenda = Integer.parseInt(jTextFieldIdVenda.getText()); 
        String situacaoVenda = jTextFieldSituacao.getText();
 
try {
            FluxodeCaixaDAO daof = new FluxodeCaixaDAO();
            List<FluxoDeCaixaModelo> listaValidarCaixa = daof.validarPagamento(idVenda, situacaoVenda);
            
  
            String validar = null;
          
            for(FluxoDeCaixaModelo ex: listaValidarCaixa){

                validar = ex.getSituacao();
            
                
            }
            
            
          
            
            
            if (validar.equals("ABERTA")) {
                 
                  String valor  = jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 4).toString();
                  String nome = jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 2).toString();
               
     
   
                  UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 18)));
                  //UIManager.put("OptionPane.messageForeground", Color.black);
                  //UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 35)));
                  //UIManager.put("OptionPane.background", Color.WHITE);
                  JOptionPane.showMessageDialog(rootPane, "A fatura no valor de "+valor+" para "+nome+" Esta Aberta!  ");
                  
                  jTextFieldIdVenda.setText("");
                  jTextFieldNomePaciente.setText("");
                  jTextFieldServico.setText("");
                  jTextFieldPagar.setText("");
                  jTextFieldValorDesconto.setText("");
                  jTextFieldSituacao.setText("");
        
    } else{
            
                
      
                 String nomePaciente = jTextFieldNomePaciente.getText();
                
                
                 
                 int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Você deseja Cancelar o Pagamento Para "+nomePaciente+"?", "Confirme", dialogButton);
            if(dialogResult == 0) {
                
   
                
                String saberFormaPagamento  = jTableCaixa.getValueAt(jTableCaixa.getSelectedRow(), 8).toString();
                
                   SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal = Calendar.getInstance();
                String dataAtual = forData.format(cal.getTime());
                cal.getTime();
                
                    int idCaixa = 0;
                float valorNoCaixa = 0;
                float valorCartao = 0;
                
                if (saberFormaPagamento.equals("D")) {
                    
                    
                                 

                List<AbrirCaixaModel> lista = daof.buscarCaixaParaPagamento(dataAtual);

            

                for (AbrirCaixaModel ex : lista) {

                    idCaixa = ex.getId_AbrirCAixa();
                    valorNoCaixa = (float) ex.getValorCaixa();
                    valorCartao = (float) ex.getValorCartao();

                }
                
                

                // Pegando o valor da Venda e Convertendo
                String teste = jTextFieldPagar.getText();
                NumberFormat format = NumberFormat.getCurrencyInstance();
                String valorVenda = format.parse(teste).toString();

                // Salvando a venda no caixa do ultimo id Selecionado, salva o valor que esta no caixa mais a venda
                float valorSomado = valorNoCaixa - Float.parseFloat(valorVenda);
                daof.pagamentoFaturas(valorSomado, idCaixa);

                String situacao = "ABERTA";
                String formaPagamento = "A";
                daof.validarMarcarComoPAGO(situacao, formaPagamento, idVenda);

                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 18)));
                JOptionPane.showMessageDialog(rootPane, "Pagamento Cancelado Com Sucesso!");

//atualizar o valor na tela do caixa
                valordoCaixa();
                //atualizar a tabela
                atualixaAtabelaComDadosdoBanco();

                jTextFieldIdVenda.setText("");
                jTextFieldNomePaciente.setText("");
                jTextFieldServico.setText("");
                jTextFieldPagar.setText("");
                jTextFieldValorDesconto.setText("");
                jTextFieldSituacao.setText("");
                    
                         String cancelar = "CANCELAR";
                    ControleLog objc = new ControleLog();
                    int idFuncionario = objc.getId_funcionario();

                    VendaDAO daoD = new VendaDAO();
                    daoD.CancelarPagamento(cancelar, idFuncionario, idCancelar);
                
                    
                    
                } else {
                
                
                    
                      
               
                List<AbrirCaixaModel> lista = daof.buscarCaixaParaPagamento(dataAtual);

            

                for (AbrirCaixaModel ex : lista) {

                    idCaixa = ex.getId_AbrirCAixa();
                    valorCartao = (float) ex.getValorCartao();

                }
                
                

                // Pegando o valor da Venda e Convertendo
                String teste = jTextFieldPagar.getText();
                NumberFormat format = NumberFormat.getCurrencyInstance();
                String valorVenda = format.parse(teste).toString();

                // Salvando a venda no caixa do ultimo id Selecionado, salva o valor que esta no caixa mais a venda
                float valorSomadoCartao = valorCartao - Float.parseFloat(valorVenda);
                daof.pagamentoCartao(valorSomadoCartao, idCaixa);

                String situacao = "ABERTA";
                String formaPagamento = "A";
                 
                  
                daof.validarMarcarComoPAGO(situacao, formaPagamento, idVenda);

                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 18)));
                JOptionPane.showMessageDialog(rootPane, "Pagamento Cancelado Com Sucesso!");

//atualizar o valor na tela do caixa
           
                //atualizar a tabela
                atualixaAtabelaComDadosdoBanco();

                jTextFieldIdVenda.setText("");
                jTextFieldNomePaciente.setText("");
                jTextFieldServico.setText("");
                jTextFieldPagar.setText("");
                jTextFieldValorDesconto.setText("");
                jTextFieldSituacao.setText("");
                    
                
                    String cancelar = "CANCELAR";
                    ControleLog objc = new ControleLog();
                    int idFuncionario = objc.getId_funcionario();

                    VendaDAO daoD = new VendaDAO();
                    daoD.CancelarPagamento(cancelar, idFuncionario, idCancelar);
                

    
                      FluxodeCaixa t = new FluxodeCaixa();
      t.valordoCaixa();
                    
                    
                    
                    
                
                }
                
                
                
                
             
                
   
                
                
          
            } else{
               
                JOptionPane.showMessageDialog(rootPane, "Você Não Cancelou o Pagamento de " + nomePaciente);
                
                
            }
       
            
            }
            
            
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
    
             
        } else{ 
         
           JOptionPane.showMessageDialog(null, "O Caixa esta fechado, você não pode realizar esta operação!");
         
         }
        
        

        
        
        
        
        
        
        
        
        
        
        
        
            
            
            
            
        
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(FluxodeCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FluxodeCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FluxodeCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FluxodeCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FluxodeCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCaixa;
    private javax.swing.JTextField jTextFiedValorAberto;
    private javax.swing.JTextField jTextFiedValorCaixa;
    private javax.swing.JTextField jTextFiedValorCartao;
    private javax.swing.JTextField jTextFiedValorTotal;
    private javax.swing.JTextField jTextFieldDescontos;
    private javax.swing.JTextField jTextFieldIdVenda;
    private javax.swing.JTextField jTextFieldNomePaciente;
    private javax.swing.JTextField jTextFieldPagar;
    private javax.swing.JTextField jTextFieldServico;
    private javax.swing.JTextField jTextFieldSituacao;
    private javax.swing.JTextField jTextFieldValorDesconto;
    // End of variables declaration//GEN-END:variables
}
