/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.AbrirCaixaDAO;

import DAO.JoinDAO;
import DAO.MarcarDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.finalizarMarcarDAO;
import br.auroClin.model.AbrirCaixaModel;
import br.auroClin.model.Marcar;
import br.auroClin.model.Medico;
import br.auroClin.model.Paciente;
import br.auroClin.model.finalizarMarcar;
import br.auroClin.model.joinBuscarConsultaMarcar;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Franciosney Souza
 */
public class marcarConsulta extends javax.swing.JFrame {

    /**
     * Creates new form marcarConsulta
     */
    
    ComprovanteExameConsulta compro;
    
    
    
     
    
    public void comprovante(){
    
        
         
            String nomePaciente = jTextFieldNomepPaciente.getText();
         String nomeExame = jTextFieldNomeConsultaVinda.getText();
         String valorExame = jTextFieldValorConsultaVinda.getText();
         String dataRealizar = jTextFieldDataRealizarConsultaVinda.getText();
         String cpf = jTextFieldCPF.getText();
         String forma = jTextFieldFormaVinda.getText();
         String plano = jTextFieldPlano.getText();
         String porcentagem = jTextFieldDesconto.getText();
         String medico = jTextFieldMedico.getText();
       
         float valorFinal =0;
   
   
              
        try {

        String valor = jTextFieldValorConsultaVinda.getText();

      NumberFormat format = NumberFormat.getCurrencyInstance();
       
            String valorVenda = format.parse(valor).toString();
            float valorTotal = Float.parseFloat(valorVenda);
            float valorPorcentagem = Float.parseFloat(jTextFieldDesconto.getText());
           float converterPorcentagem = valorPorcentagem/100;
           float valorDesconto = valorTotal*converterPorcentagem;
           valorFinal = valorTotal - valorDesconto;
        
             //System.out.println(valorFinal);
            
             
        
    
             // System.out.println(nf.format(valorFinal));
    
            
        } catch (Exception e) {
        }
        
         
         
         
         NumberFormat nf = NumberFormat.getCurrencyInstance();
         
  
                 
if (compro == null) {
           NumberFormat format = NumberFormat.getInstance();
    
            

     
            compro = new ComprovanteExameConsulta();
            compro.setLocationRelativeTo(null);
            compro.receber(nomePaciente,nomeExame,valorExame,dataRealizar,cpf,forma,plano,nf.format(valorFinal),porcentagem,medico);
        }
 
          compro.setFocusableWindowState(false); 
//pagCartao.setAlwaysOnTop(true);  
        compro.setVisible(true);
        compro.setState(PagamentoCartao.NORMAL);
         compro.receber(nomePaciente,nomeExame,valorExame,dataRealizar,cpf,forma,plano,nf.format(valorFinal),porcentagem,medico);
        
        
        
    
    
    }
    
    
    
     public void buscaAvancadaConsultas(){
    
        
        
        String nomeConsulta = jTextFieldConsultaBuscar.getText();
        String nomeMedico = jTextFieldMedicoBuscar.getText();
        String dataBusca = jTextFieldDataBusca.getText();
        String forma = jTextFieldFormaBusca.getText();


   SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
          

            try {

                System.out.println(nomeConsulta);
                
                MarcarDAO dao = new MarcarDAO();
                List<Marcar> listadeDatas =  dao.listaDatasConsultasPorData(nomeConsulta, nomeMedico, dataBusca, forma);

                DefaultTableModel modelo = (DefaultTableModel)jTableExames.getModel();
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
                    
                    
                    jTableExames.setValueAt(obm.getId_marcar(), i, 0);

                    // Convertendo datas para jogar na tabela

                    String dataBancoVindo = obm.getDataFazer();
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = (Date)formatter.parse(dataBancoVindo);
                    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");

                    // Finalizanto e jogando na tabela
                   jTableExames.setValueAt(obm.getNomeParaJoin(), i, 1);
jTableExames.setValueAt(obm.getNomeMedico(), i, 2);
jTableExames.setValueAt(formatoRetorno.format(date), i, 3);
jTableExames.setValueAt(obm.getValorExame(), i, 4);
jTableExames.setValueAt(obm.getAgendar(), i, 5);

                    i++;

                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(rootPane, "Erro"+e);
            }

       
    
    }
    
    
    public void buscarConsultas(){
    
        
             SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
          
        
        

        try {
            
            
            
            
           MarcarDAO dao = new MarcarDAO();
            List<Marcar> listadeDatas =  dao.listaDatasConsultas();
            
            DefaultTableModel modelo = (DefaultTableModel)jTableExames.getModel();
            modelo.setNumRows(0);
       
            
                  
  NumberFormat nf = NumberFormat.getCurrencyInstance(); 


               int i = 0;
            for(Marcar ex: listadeDatas){
                
                
       
                
        
                  DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
             
    Date dt1 = df.parse (ex.getDataFazer());
        Date dt2 = df.parse (dataAtual);
   
    //if(dt2.after(dt1))
        if(dt2.after(dt1)) {
            System.err.println("Essa Data Ja passou "+ex.getDataFazer());
        } else {
           
modelo.addRow(new String[i]);

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(ex.getDataFazer());  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");   

    
     
jTableExames.setValueAt(ex.getId_marcar(), i, 0);
jTableExames.setValueAt(ex.getNomeParaJoin(), i, 1);
jTableExames.setValueAt(ex.getNomeMedico(), i, 2);
jTableExames.setValueAt(formatoRetorno.format(date), i, 3);
jTableExames.setValueAt(nf.format(ex.getValorExame()), i, 4);
jTableExames.setValueAt(ex.getAgendar(), i, 5);            
jTableExames.setValueAt(nf.format(ex.getValorExame()), i, 4);
                
                
         
    
   


          
            i++;
            
            }
             
             
             
             
        }
                
    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
    }
        
        
    
    
    public void buscarPacientePorNome(){
    
        
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
                jTablePaciente.setValueAt(objp.getDataNascimento(), i, 3);

                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }

    
    
    }
    
    
    
    public void marcarConsultaDefinitivamente(){
    
    
    
        
         SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();

        AbrirCaixaDAO daovalidar = new AbrirCaixaDAO();
        
        
        // ---------- Validar Caixa Aberto
        
         if (daovalidar.validarCaixaAberto(dataAtual)) {
     
      
             //----------------------------- Começo do Codigo
             
             
             
           

            
            AbrirCaixaDAO daoa = new AbrirCaixaDAO();
            
            int idCaixa = 0;
       
            
            List<AbrirCaixaModel> listaCaixa = daoa.listarIdStatosCaixa();
          
            for(AbrirCaixaModel oc: listaCaixa){
            
               idCaixa = oc.getId_AbrirCAixa();
        
            }

            String Teste = jTextFieldNomepPaciente.getText();
            String Teste2 = jTextFieldNomeConsultaVinda.getText();

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Você deseja Marcar a Consulta de " + Teste2 + " para " + Teste, "Title on Box", dialogButton);
            if(dialogResult == 0) {

                try {

                    finalizarMarcar fmarcar = new finalizarMarcar();
                    int idDataMarcar = Integer.parseInt(jTextFieldIdDataConsulta.getText());
                    fmarcar.setId_dataMarcar(idDataMarcar);
                    int idPaciente = Integer.parseInt(jTextFieldIdIdPaciente.getText());
                    fmarcar.setId_paciente(idPaciente);
                
                  
                    fmarcar.setId_caixa(idCaixa);
                    String situacao = "ABERTA";
                   String situacaoFila = "ESPERA";
                   fmarcar.setSituacaoFila(situacaoFila);
                    fmarcar.setSituacao(situacao);
                     String formaPagamento = "A";
                    fmarcar.setFormaPagamento(formaPagamento);
                    String retorno = "ATIVO";
                    fmarcar.setRetorno(retorno);

                    finalizarMarcarDAO daof= new finalizarMarcarDAO();
                    daof.efetivarCadastroExame(fmarcar);

                    JOptionPane.showMessageDialog(null, "A Consulta " +jTextFieldNomeConsultaVinda.getText()+  " foi Marcada com Sucesso para o dia " +jTextFieldDataRealizarConsultaVinda.getText());
                    comprovante();
                    jTextFieldIdDataConsulta.setText("");
              
                    jTextFieldIdIdPaciente.setText("");
                    jTextFieldNomeConsultaVinda.setText("");
              
                    jTextFieldNomepPaciente.setText("");
                    jTextFieldDataRealizarConsultaVinda.setText("");
                    jTextFieldValorConsultaVinda.setText("");
                
                    jTextFieldBuscarPaciente.setText("");
            
                    jTextFieldCPF.setText("");
                   // jTextFieldDataNAscimento.setText("");

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(rootPane, e);
                }

            } else{

                JOptionPane.showMessageDialog(rootPane, "Você Cancelou a Consulta para " + Teste);

               jTextFieldIdDataConsulta.setText("");
                
                    jTextFieldIdIdPaciente.setText("");
                    jTextFieldNomeConsultaVinda.setText("");
                 
                    jTextFieldNomepPaciente.setText("");
                    jTextFieldDataRealizarConsultaVinda.setText("");
                    jTextFieldValorConsultaVinda.setText("");
                   
                    jTextFieldBuscarPaciente.setText("");
       
                    jTextFieldCPF.setText("");
                   // jTextFieldDataNAscimento.setText("");
                    

            }
            
        
            
   
            //---------------- Fim do Codigo
             
        } else{ 
         
           JOptionPane.showMessageDialog(null, "Você não Abril o Caixa! Não Insista!");
         
         }
        
    
    
    
    
    }
    
    
    
    
    
    public marcarConsulta() {
        initComponents();
        
        
        jTextFieldIdDataConsulta.setEditable(false);
           jTextFieldDataRealizarConsultaVinda.setEditable(false);
              jTextFieldNomeConsultaVinda.setEditable(false);
                 jTextFieldValorConsultaVinda.setEditable(false);
              
                 
                
                    
                    jTextFieldIdIdPaciente.setEditable(false);
                    jTextFieldNomepPaciente.setEditable(false);
                    jTextFieldCPF.setEditable(false);
                    //jTextFieldDataNAscimento.setEditable(false);
           
         


   JTableHeader headerPaciente = jTablePaciente.getTableHeader();   
    headerPaciente.setPreferredSize(new Dimension(0, 25)); 
    headerPaciente.setFont(new Font("��������", Font.PLAIN, 14));
	headerPaciente.setPreferredSize(new Dimension(headerPaciente.getWidth(),25));
 jTablePaciente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(50);
jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(330);
jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(120);
jTablePaciente.getColumnModel().getColumn(3).setPreferredWidth(100);
jTablePaciente.getColumnModel().getColumn(4).setPreferredWidth(130);
jTablePaciente.getColumnModel().getColumn(5).setPreferredWidth(80);
jTablePaciente.setRowHeight(23); 




JTableHeader headerExames = jTableExames.getTableHeader();   
    headerExames.setPreferredSize(new Dimension(0, 25)); 
   headerExames.setFont(new Font("��������", Font.PLAIN, 14));
	headerExames.setPreferredSize(new Dimension(headerExames.getWidth(),25));
                        
                 jTableExames.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableExames.getColumnModel().getColumn(0).setPreferredWidth(70);
jTableExames.getColumnModel().getColumn(1).setPreferredWidth(265);
jTableExames.getColumnModel().getColumn(2).setPreferredWidth(330);
jTableExames.getColumnModel().getColumn(3).setPreferredWidth(110);
jTableExames.getColumnModel().getColumn(4).setPreferredWidth(110);
jTableExames.getColumnModel().getColumn(5).setPreferredWidth(130);
jTableExames.setRowHeight(20); 


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
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldIdDataConsulta = new javax.swing.JTextField();
        jTextFieldNomeConsultaVinda = new javax.swing.JTextField();
        jTextFieldDataRealizarConsultaVinda = new javax.swing.JTextField();
        jTextFieldValorConsultaVinda = new javax.swing.JTextField();
        jTextFieldConsultaBuscar = new javax.swing.JTextField();
        jButtonBuscarDatConsulta = new javax.swing.JButton();
        jTextFieldFormaBusca = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldFormaVinda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableExames = new javax.swing.JTable();
        jTextFieldMedicoBuscar = new javax.swing.JTextField();
        jTextFieldDataBusca = new javax.swing.JTextField();
        jTextFieldMedico = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldIdIdPaciente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldNomepPaciente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldCPF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldBuscarPaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jTextFieldPlano = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldDesconto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonFechar = new javax.swing.JButton();
        jButtonMinimizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione uma Consulta de acordo com a data"));

        jLabel6.setText("ID:");

        jLabel4.setText("Consulta Requerida::");

        jTextFieldIdDataConsulta.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldIdDataConsulta.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldIdDataConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdDataConsultaActionPerformed(evt);
            }
        });

        jTextFieldNomeConsultaVinda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldNomeConsultaVinda.setForeground(new java.awt.Color(0, 51, 102));

        jTextFieldDataRealizarConsultaVinda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldDataRealizarConsultaVinda.setForeground(new java.awt.Color(0, 51, 102));

        jTextFieldValorConsultaVinda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldValorConsultaVinda.setForeground(new java.awt.Color(0, 51, 102));

        jTextFieldConsultaBuscar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldConsultaBuscar.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldConsultaBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldConsultaBuscarKeyPressed(evt);
            }
        });

        jButtonBuscarDatConsulta.setText("Buscar Consulta");
        jButtonBuscarDatConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarDatConsultaActionPerformed(evt);
            }
        });

        jTextFieldFormaBusca.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldFormaBusca.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldFormaBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldFormaBuscaKeyPressed(evt);
            }
        });

        jLabel10.setText("Nome da Consulta para Busca");

        jLabel19.setText("Data para Busca");

        jTextFieldFormaVinda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldFormaVinda.setForeground(new java.awt.Color(0, 51, 102));

        jTableExames.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTableExames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID:", "Exame", "Médico", "Realização:", "Preço R$", "Forma:"
            }
        ));
        jTableExames.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableExames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableExamesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableExames);

        jTextFieldMedicoBuscar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldMedicoBuscar.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldMedicoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldMedicoBuscarKeyPressed(evt);
            }
        });

        jTextFieldDataBusca.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldDataBusca.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldDataBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDataBuscaKeyPressed(evt);
            }
        });

        jTextFieldMedico.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldMedico.setForeground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldIdDataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldNomeConsultaVinda, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDataRealizarConsultaVinda, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldValorConsultaVinda, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jTextFieldFormaVinda, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldConsultaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMedicoBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDataBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldFormaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarDatConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldIdDataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldNomeConsultaVinda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldDataRealizarConsultaVinda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldValorConsultaVinda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldFormaVinda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldConsultaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldMedicoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldDataBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldFormaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButtonBuscarDatConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione um Paciente"));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("ID:");

        jTextFieldIdIdPaciente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldIdIdPaciente.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldIdIdPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdIdPacienteActionPerformed(evt);
            }
        });

        jLabel13.setText("Nome do Paciente:");

        jTextFieldNomepPaciente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldNomepPaciente.setForeground(new java.awt.Color(0, 51, 102));

        jLabel15.setText("CPF");

        jTextFieldCPF.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldCPF.setForeground(new java.awt.Color(0, 51, 102));

        jLabel16.setText("Digite um Nome para Busca:");

        jTextFieldBuscarPaciente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldBuscarPaciente.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldBuscarPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarPacienteKeyPressed(evt);
            }
        });

        jLabel3.setText("Buscar");

        jButton1.setText("Buscar Paciente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTablePaciente.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Data de Nascimento", "Plano", "Desconto"
            }
        ));
        jTablePaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTablePaciente);

        jTextFieldPlano.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPlano.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlanoActionPerformed(evt);
            }
        });

        jLabel17.setText("PLANO");

        jTextFieldDesconto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldDesconto.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescontoActionPerformed(evt);
            }
        });

        jLabel18.setText("DESC %");

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
                                .addGap(24, 24, 24)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldIdIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextFieldNomepPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addGap(68, 68, 68)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldPlano, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextFieldBuscarPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(67, 67, 67))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldIdIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNomepPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Marcar Consulta e Finalizar"));

        jButton3.setText("Marcar Exame");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpar Campos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 50, 1130, 660);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 0));
        jLabel2.setText("     MARCAR CONSULTAS");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 0, 380, 41);

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFechar);
        jButtonFechar.setBounds(1050, 0, 50, 40);

        jButtonMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (1).png"))); // NOI18N
        jButtonMinimizar.setToolTipText("Minimizar");
        jButtonMinimizar.setName(""); // NOI18N
        jButtonMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMinimizar);
        jButtonMinimizar.setBounds(1000, 0, 50, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/fundoConsulta.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 720);

        setSize(new java.awt.Dimension(1150, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIdDataConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdDataConsultaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldIdDataConsultaActionPerformed

    private void jButtonBuscarDatConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarDatConsultaActionPerformed
        // TODO add your handling code here:
     
         buscaAvancadaConsultas();
        
    }//GEN-LAST:event_jButtonBuscarDatConsultaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        
        buscarConsultas();

            try {

            PacienteDAO daop = new PacienteDAO();
            List<Paciente> listaPaciente = daop.listarTodosPacientes();

            DefaultTableModel modelo = (DefaultTableModel)jTablePaciente.getModel();
            modelo.setNumRows(0);

          

            int i = 0;
            for(Paciente objp: listaPaciente){
                modelo.addRow(new String[i]);
                jTablePaciente.setValueAt(objp.getId_paciente(), i, 0);
                 jTablePaciente.setValueAt(objp.getNome_paciente(), i, 1);
                 jTablePaciente.setValueAt(objp.getCpf(), i, 2);
                 jTablePaciente.setValueAt(objp.getDataNascimento(), i, 3);
                 jTablePaciente.setValueAt(objp.getPlano(), i, 4);
                 jTablePaciente.setValueAt(objp.getDesconto(), i, 5);
            
                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
       

        
        
      
        
        
    }//GEN-LAST:event_formWindowActivated

    private void jTextFieldIdIdPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdIdPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdIdPacienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        buscarPacientePorNome();
      
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

        jTextFieldIdIdPaciente.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0).toString());
        jTextFieldNomepPaciente.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 1).toString());
        jTextFieldCPF.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 2).toString());
        jTextFieldPlano.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 4).toString());
        jTextFieldDesconto.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 5).toString());
       // jTextFieldDataNAscimento.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 3).toString());

    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizarActionPerformed
        // TODO add your handling code here:
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

   
    
        if (jTextFieldNomeConsultaVinda.getText().equals("")) {

            JOptionPane.showMessageDialog(rootPane, "Os dados da Consulta São Obrigatórios!");
              jTextFieldIdDataConsulta.setText("");
              
                    jTextFieldIdIdPaciente.setText("");
                    jTextFieldNomeConsultaVinda.setText("");
                  
                    jTextFieldNomepPaciente.setText("");
                    jTextFieldDataRealizarConsultaVinda.setText("");
                    jTextFieldValorConsultaVinda.setText("");
           
                    jTextFieldBuscarPaciente.setText("");
               
                    jTextFieldCPF.setText("");
                   // jTextFieldDataNAscimento.setText("");


        } else if(jTextFieldNomepPaciente.getText().equals("")){

            JOptionPane.showMessageDialog(rootPane, "Os dados do Paciente São Obrigatórios");
              jTextFieldIdDataConsulta.setText("");
                 
                    jTextFieldIdIdPaciente.setText("");
                    jTextFieldNomeConsultaVinda.setText("");
                
                    jTextFieldNomepPaciente.setText("");
                    jTextFieldDataRealizarConsultaVinda.setText("");
                    jTextFieldValorConsultaVinda.setText("");
                  
                    jTextFieldBuscarPaciente.setText("");
                    
                    jTextFieldCPF.setText("");
                   // jTextFieldDataNAscimento.setText("");

            

        } else{
            
            
            
            MarcarDAO daom = new MarcarDAO();
        
        int idMarcar = Integer.parseInt(jTextFieldIdDataConsulta.getText());
        int idPaciente = Integer.parseInt(jTextFieldIdIdPaciente.getText());
        
        if (daom.ValidarCadastroDeExamesRepetido(idMarcar, idPaciente)) {
            
            JOptionPane.showMessageDialog(rootPane, "Esta Consulta Já foi Marcada");
            
        }else{
        
         
      

            
          marcarConsultaDefinitivamente();
    
         
         
         
        }
            
     
        
        }

   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        jTextFieldIdDataConsulta.setText("");

        jTextFieldIdIdPaciente.setText("");
        jTextFieldNomeConsultaVinda.setText("");

        jTextFieldNomepPaciente.setText("");
        jTextFieldDataRealizarConsultaVinda.setText("");
        jTextFieldValorConsultaVinda.setText("");
    
        jTextFieldBuscarPaciente.setText("");
   
        jTextFieldCPF.setText("");
       // jTextFieldDataNAscimento.setText("");
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldBuscarPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarPacienteKeyPressed
        // TODO add your handling code here:
        
        buscarPacientePorNome();
    }//GEN-LAST:event_jTextFieldBuscarPacienteKeyPressed

    private void jTextFieldConsultaBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldConsultaBuscarKeyPressed
        // TODO add your handling code here:
  
      buscaAvancadaConsultas();
  
    }//GEN-LAST:event_jTextFieldConsultaBuscarKeyPressed

    private void jTextFieldFormaBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFormaBuscaKeyPressed
        // TODO add your handling code here:
        
        buscaAvancadaConsultas();
      
    }//GEN-LAST:event_jTextFieldFormaBuscaKeyPressed

    private void jTableExamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableExamesMouseClicked
        // TODO add your handling code here:

        //---- Controlando Clique na tabela

        jTableExames.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel
        jTableExames.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {

                    //JOptionPane.showMessageDialog(null, "Você não Pode Editar! Não Insista");
                }
            }
        });
        // ---------- Fim

        jTextFieldIdDataConsulta.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 0).toString());
        jTextFieldNomeConsultaVinda.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 1).toString());
        jTextFieldDataRealizarConsultaVinda.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 3).toString());
        jTextFieldValorConsultaVinda.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 4).toString());
        jTextFieldFormaVinda.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 5).toString());
         jTextFieldMedico.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 2).toString());

        String forma = jTableExames.getValueAt(jTableExames.getSelectedRow(), 5).toString();
        if(forma.equals("AGENDA")){
            jTextFieldFormaVinda.setBackground(new java.awt.Color(255, 255, 51));
            jTextFieldIdDataConsulta.setBackground(new java.awt.Color(255, 255, 51));
            jTextFieldNomeConsultaVinda.setBackground(new java.awt.Color(255, 255, 51));
            jTextFieldDataRealizarConsultaVinda.setBackground(new java.awt.Color(255, 255, 51));
            jTextFieldValorConsultaVinda.setBackground(new java.awt.Color(255, 255, 51));
            jTextFieldFormaVinda.setBackground(new java.awt.Color(255, 255, 51));
            jTextFieldMedico.setBackground(new java.awt.Color(255, 255, 51));

        }
        else{

            jTextFieldFormaVinda.setBackground(Color.WHITE);
            jTextFieldIdDataConsulta.setBackground(Color.WHITE);
            jTextFieldNomeConsultaVinda.setBackground(Color.WHITE);
            jTextFieldDataRealizarConsultaVinda.setBackground(Color.WHITE);
            jTextFieldValorConsultaVinda.setBackground(Color.WHITE);
            jTextFieldFormaVinda.setBackground(Color.WHITE);
            jTextFieldMedico.setBackground(Color.WHITE);

        }

    }//GEN-LAST:event_jTableExamesMouseClicked

    private void jTextFieldMedicoBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMedicoBuscarKeyPressed
        // TODO add your handling code here:
         buscaAvancadaConsultas();
    }//GEN-LAST:event_jTextFieldMedicoBuscarKeyPressed

    private void jTextFieldDataBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDataBuscaKeyPressed
        // TODO add your handling code here:
         buscaAvancadaConsultas();
    }//GEN-LAST:event_jTextFieldDataBuscaKeyPressed

    private void jTextFieldPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlanoActionPerformed

    private void jTextFieldDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescontoActionPerformed

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
            java.util.logging.Logger.getLogger(marcarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(marcarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(marcarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(marcarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new marcarConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonBuscarDatConsulta;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableExames;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextField jTextFieldBuscarPaciente;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldConsultaBuscar;
    private javax.swing.JTextField jTextFieldDataBusca;
    private javax.swing.JTextField jTextFieldDataRealizarConsultaVinda;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldFormaBusca;
    private javax.swing.JTextField jTextFieldFormaVinda;
    private javax.swing.JTextField jTextFieldIdDataConsulta;
    private javax.swing.JTextField jTextFieldIdIdPaciente;
    private javax.swing.JTextField jTextFieldMedico;
    private javax.swing.JTextField jTextFieldMedicoBuscar;
    private javax.swing.JTextField jTextFieldNomeConsultaVinda;
    private javax.swing.JTextField jTextFieldNomepPaciente;
    private javax.swing.JTextField jTextFieldPlano;
    private javax.swing.JTextField jTextFieldValorConsultaVinda;
    // End of variables declaration//GEN-END:variables
}
