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

import br.auroClin.model.JoinBuscarExameEMarcar;
import br.auroClin.model.Marcar;
import br.auroClin.model.Medico;
import br.auroClin.model.Paciente;
import br.auroClin.model.finalizarMarcar;
import br.auroClin.model.joinBuscarConsultaMarcar;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


/**
 *
 * @author Franciosney Souza
 */
public class MascarExame extends javax.swing.JFrame {

    /**
     * Creates new form MascarExame
     */
    
    
    ComprovanteExameConsulta compro;
    
    
    
    public void comprovante(){
    
        
          String nomePaciente = jTextFieldNomepPaciente.getText();
         String nomeExame = jTextFieldNomeExame.getText();
         String valorExame = jTextFieldValorExame.getText();
         String dataRealizar = jTextFieldDataRealizar.getText();
         String cpf = jTextFieldIdCPF.getText();
         String data = jTextFieldForma.getText();
         String plano = jTextFieldPlano.getText();
         String desconto = jTextFieldDesconto.getText();
         String porcentagem = jTextFieldDesconto.getText();
         String medico = jTextFieldMedico.getText();
         float valorFinal =0;
   
   
              
        try {

        String valor = jTextFieldValorExame.getText();

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
    
           //NumberFormat format = NumberFormat.getInstance();
    
            

     
            compro = new ComprovanteExameConsulta();
            compro.setLocationRelativeTo(null);
            compro.receber(nomePaciente,nomeExame,valorExame,dataRealizar,cpf,data,plano,nf.format(valorFinal),porcentagem,medico);
        }
 
          compro.setFocusableWindowState(false); 
//pagCartao.setAlwaysOnTop(true);  
        compro.setVisible(true);
        compro.setState(PagamentoCartao.NORMAL);
         compro.receber(nomePaciente,nomeExame,valorExame,dataRealizar,cpf,data,plano,nf.format(valorFinal),porcentagem,medico);
        
        
        
    
    
    }
    
    
    public void buscarExamesParaMarcar(){
    
        
             SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
          
        
        

        try {
            
            
            
            
           MarcarDAO dao = new MarcarDAO();
            List<Marcar> listadeDatas =  dao.listaDatasExames();
            
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
    
    
    
    
    
    
    public void buscarExamePorNomeData(){
    
        
             SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
          
        
        

        try {
            
            
        String nomeExame = jTextFieldNomeExameBuscar.getText();
        String forma = jTextFieldFormaBusca.getText();
        String dataBusca = jTextFieldDataBusca.getText();
        String nomeMedicoBusca = jTextFieldNomeMedicoBusca.getText();
       // String data = jTextFieldData.getText();
            
            
           MarcarDAO daom = new MarcarDAO();
            
            List<JoinBuscarExameEMarcar> listaExames = daom.listaDatasExamesNomeMedicoForma(nomeExame, nomeMedicoBusca, dataBusca, forma);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableExames.getModel();
            modelo.setNumRows(0);
       
            
                  
  NumberFormat nf = NumberFormat.getCurrencyInstance(); 


               int i = 0;
            for(JoinBuscarExameEMarcar ex: listaExames){
                
                
       
                
        
                  DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
             
    Date dt1 = df.parse (ex.getDataRealizar());
        Date dt2 = df.parse (dataAtual);
   
    //if(dt2.after(dt1))
        if(dt2.after(dt1)) {
            System.err.println("Essa Data Ja passou "+ex.getDataRealizar());
        } else {
           
modelo.addRow(new String[i]);

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(ex.getDataRealizar());  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");   

    
     
jTableExames.setValueAt(ex.getId_marcarBuscar(), i, 0);
jTableExames.setValueAt(ex.getExameRequerido(), i, 1);
jTableExames.setValueAt(ex.getNomeMedico(), i, 2);
jTableExames.setValueAt(formatoRetorno.format(date), i, 3);
jTableExames.setValueAt(nf.format(ex.getValorExame()), i, 4);
jTableExames.setValueAt(ex.getFormaRealizar(), i, 5);
jTableExames.setValueAt(nf.format(ex.getValorExame()), i, 4);
                

    
   


          
            i++;
            
            }
             
             
             
             
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
                 jTablePaciente.setValueAt(objp.getDataNascimento(), i, 3);
                 jTablePaciente.setValueAt(objp.getPlano(), i, 4);
                 jTablePaciente.setValueAt(objp.getDesconto(), i, 5);
           
                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
       

        
    
    }
    
    public void listarMarcar(){
    
        try {
            
       
            JoinDAO daojoin = new JoinDAO();
            
            List<JoinBuscarExameEMarcar> listaExames = daojoin.listarExames();
            
            DefaultTableModel modelo = (DefaultTableModel)jTableExames.getModel();
            modelo.setNumRows(0);
       

           
  NumberFormat nf = NumberFormat.getCurrencyInstance(); 

            int i = 0;
            for(JoinBuscarExameEMarcar ex: listaExames){
modelo.addRow(new String[i]);



DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(ex.getDataRealizar());  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");   



jTableExames.setValueAt(ex.getId_marcarBuscar(), i, 0);
jTableExames.setValueAt(ex.getExameRequerido(), i, 1);
jTableExames.setValueAt(ex.getNomeMedico(), i, 2);
jTableExames.setValueAt(formatoRetorno.format(date), i, 3);
jTableExames.setValueAt(nf.format(ex.getValorExame()), i, 4);
jTableExames.setValueAt(ex.getFormaRealizar(), i, 5);

            i++;
            }
            
        } catch (Exception e) {}
        }
    
    
    
    
    
    
    
    
    
    public void marcarExameDefinitivo(){
        
        
        
        
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
        
        //JOptionPane.showMessageDialog(rootPane, idCaixa);
    
        
        
            
             String Teste = jTextFieldNomepPaciente.getText();
             String Teste2 = jTextFieldNomeExame.getText();
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this, "Você deseja cadastrar o exame de " + Teste2 + " para " + Teste, "Title on Box", dialogButton);
if(dialogResult == 0) {



    
            
             
        try {
            
            
        finalizarMarcar fmarcar = new finalizarMarcar();
        int idDataMarcar = Integer.parseInt(jTextFieldIdData.getText());
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

                JOptionPane.showMessageDialog(null, "O Exame " +jTextFieldNomeExame.getText()+  " foi Marcada com Sucesso para o dia " +jTextFieldDataRealizar.getText());
                comprovante();
                
                //JOptionPane.showMessageDialog(null, "Exame Marcado com Sucesso!");
                jTextFieldIdData.setText("");
 
                jTextFieldIdIdPaciente.setText("");
                jTextFieldNomeExame.setText("");
        
                jTextFieldNomepPaciente.setText("");
                jTextFieldDataRealizar.setText("");
                jTextFieldValorExame.setText("");

                jTextFieldBuscarPaciente.setText("");
                jTextFieldForma.setText("");
            
           
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, e);
        }

  
        
    
    
    


} else{
    
   JOptionPane.showMessageDialog(rootPane, "Você não Marcou o exame para " + Teste); 
    
   
     jTextFieldIdData.setText("");
   
                jTextFieldIdIdPaciente.setText("");
                jTextFieldNomeExame.setText("");
      
                jTextFieldNomepPaciente.setText("");
                jTextFieldDataRealizar.setText("");
                jTextFieldValorExame.setText("");
            
                jTextFieldBuscarPaciente.setText("");
                jTextFieldForma.setText("");
           
         
             
                
   
   
}

            
   
            
            
    
         
         
         
         
         
         
         
         
         
         
               //---------------- Fim do Codigo
             
             
        } else{ 
         
           JOptionPane.showMessageDialog(null, "Você não Abril o Caixa! Não Insista!");
         
         }
        

    }
    
    
    
    
    
    public MascarExame() {
        initComponents();
        
        jTextFieldIdData.setEditable(false);
           jTextFieldDataRealizar.setEditable(false);
              jTextFieldNomeExame.setEditable(false);
                 jTextFieldValorExame.setEditable(false);
             
          
                    
                    jTextFieldIdIdPaciente.setEditable(false);
                    jTextFieldNomepPaciente.setEditable(false);
       
                    
           
             

                    
                 
                 
 JTableHeader headerPaciente = jTablePaciente.getTableHeader();   
    headerPaciente.setPreferredSize(new Dimension(0, 25)); 
    headerPaciente.setFont(new Font("��������", Font.PLAIN, 14));
	headerPaciente.setPreferredSize(new Dimension(headerPaciente.getWidth(),25));
 jTablePaciente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(50);
jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(340);
jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(130);
jTablePaciente.getColumnModel().getColumn(3).setPreferredWidth(100);
jTablePaciente.getColumnModel().getColumn(4).setPreferredWidth(140);
jTablePaciente.getColumnModel().getColumn(5).setPreferredWidth(70);
jTablePaciente.setRowHeight(20); 
                



                 


JTableHeader headerExames = jTableExames.getTableHeader();   
    headerExames.setPreferredSize(new Dimension(0, 25)); 
   headerExames.setFont(new Font("��������", Font.PLAIN, 14));
	headerExames.setPreferredSize(new Dimension(headerExames.getWidth(),25));
                        
                 jTableExames.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableExames.getColumnModel().getColumn(0).setPreferredWidth(70);
jTableExames.getColumnModel().getColumn(1).setPreferredWidth(290);
jTableExames.getColumnModel().getColumn(2).setPreferredWidth(350);
jTableExames.getColumnModel().getColumn(3).setPreferredWidth(110);
jTableExames.getColumnModel().getColumn(4).setPreferredWidth(110);
jTableExames.getColumnModel().getColumn(5).setPreferredWidth(130);
jTableExames.setRowHeight(20); 
                
        
                URL url = this.getClass().getResource("/br/auroClin/imagens/homesoft.png");
Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
this.setIconImage(imagemTitulo);
        
        
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
        jPanelExame = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldIdData = new javax.swing.JTextField();
        jTextFieldNomeExame = new javax.swing.JTextField();
        jTextFieldDataRealizar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValorExame = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableExames = new javax.swing.JTable();
        jButtonBuscarDatExame = new javax.swing.JButton();
        jTextFieldNomeExameBuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldFormaBusca = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldForma = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldNomeMedicoBusca = new javax.swing.JTextField();
        jTextFieldDataBusca = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldMedico = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanelDataNAscimento = new javax.swing.JPanel();
        jTextFieldIdIdPaciente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldBuscarPaciente = new javax.swing.JTextField();
        jTextFieldNomepPaciente = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextFieldIdCPF = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldPlano = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldDesconto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanelExame.setBackground(new java.awt.Color(255, 255, 255));
        jPanelExame.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione um Exame na Data Equivalente"));

        jLabel6.setText("ID:");

        jLabel4.setText("EXAME REQUERIDO:");

        jTextFieldIdData.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldIdData.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldIdData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdDataActionPerformed(evt);
            }
        });

        jTextFieldNomeExame.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldNomeExame.setForeground(new java.awt.Color(0, 51, 102));

        jTextFieldDataRealizar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldDataRealizar.setForeground(new java.awt.Color(0, 51, 102));

        jLabel5.setText("DATA DE REALIZAÇÃO");

        jTextFieldValorExame.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldValorExame.setForeground(new java.awt.Color(0, 51, 102));

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

        jButtonBuscarDatExame.setText("Buscar Exame");
        jButtonBuscarDatExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarDatExameActionPerformed(evt);
            }
        });

        jTextFieldNomeExameBuscar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldNomeExameBuscar.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldNomeExameBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeExameBuscarKeyPressed(evt);
            }
        });

        jLabel10.setText("VALOR  R$:");

        jTextFieldFormaBusca.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldFormaBusca.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldFormaBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldFormaBuscaKeyPressed(evt);
            }
        });

        jLabel17.setText("Nome do Exame para Busca");

        jLabel19.setText("Data para Busca");

        jTextFieldForma.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldForma.setForeground(new java.awt.Color(0, 51, 102));

        jLabel11.setText("FORMA:");

        jTextFieldNomeMedicoBusca.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldNomeMedicoBusca.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldNomeMedicoBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeMedicoBuscaKeyPressed(evt);
            }
        });

        jTextFieldDataBusca.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldDataBusca.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldDataBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDataBuscaKeyPressed(evt);
            }
        });

        jLabel20.setText("Nome do Médico para Busca");

        jLabel21.setText("Forma:");

        jTextFieldMedico.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldMedico.setForeground(new java.awt.Color(0, 51, 102));

        jLabel7.setText("MEDICO");

        javax.swing.GroupLayout jPanelExameLayout = new javax.swing.GroupLayout(jPanelExame);
        jPanelExame.setLayout(jPanelExameLayout);
        jPanelExameLayout.setHorizontalGroup(
            jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExameLayout.createSequentialGroup()
                .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelExameLayout.createSequentialGroup()
                        .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelExameLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldIdData, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelExameLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanelExameLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(135, 135, 135)))
                        .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDataRealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldValorExame, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelExameLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldForma, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExameLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(43, 43, 43))))
                    .addGroup(jPanelExameLayout.createSequentialGroup()
                        .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelExameLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
                            .addGroup(jPanelExameLayout.createSequentialGroup()
                                .addComponent(jTextFieldNomeExameBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNomeMedicoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelExameLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelExameLayout.createSequentialGroup()
                                .addComponent(jTextFieldDataBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jTextFieldFormaBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarDatExame, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelExameLayout.setVerticalGroup(
            jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExameLayout.createSequentialGroup()
                .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelExameLayout.createSequentialGroup()
                        .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldNomeExame)
                            .addComponent(jTextFieldIdData, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelExameLayout.createSequentialGroup()
                        .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(5, 5, 5)
                        .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldValorExame, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldForma, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDataRealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeExameBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarDatExame, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFormaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeMedicoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDataBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelDataNAscimento.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDataNAscimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione um Paciente"));

        jTextFieldIdIdPaciente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldIdIdPaciente.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldIdIdPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdIdPacienteActionPerformed(evt);
            }
        });

        jLabel13.setText("NOME PACIENTE:");

        jLabel12.setText("ID:");

        jTextFieldBuscarPaciente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldBuscarPaciente.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldBuscarPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarPacienteKeyPressed(evt);
            }
        });

        jTextFieldNomepPaciente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldNomepPaciente.setForeground(new java.awt.Color(0, 51, 102));

        jTablePaciente.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Data de N", "Plano", "Desconto"
            }
        ));
        jTablePaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTablePaciente);

        jButton1.setText("Buscar Paciente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setText("DIGITE UM NOME PARA BUSCA:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Marcar Exame e Finalizar"));

        jButton2.setText("Limpar Campos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Marcar Exame");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jTextFieldIdCPF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldIdCPF.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldIdCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdCPFActionPerformed(evt);
            }
        });

        jLabel14.setText("CPF");

        jTextFieldPlano.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPlano.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlanoActionPerformed(evt);
            }
        });

        jLabel15.setText("PLANO");

        jTextFieldDesconto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldDesconto.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescontoActionPerformed(evt);
            }
        });

        jLabel18.setText("DESC %");

        javax.swing.GroupLayout jPanelDataNAscimentoLayout = new javax.swing.GroupLayout(jPanelDataNAscimento);
        jPanelDataNAscimento.setLayout(jPanelDataNAscimentoLayout);
        jPanelDataNAscimentoLayout.setHorizontalGroup(
            jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataNAscimentoLayout.createSequentialGroup()
                .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataNAscimentoLayout.createSequentialGroup()
                        .addComponent(jTextFieldBuscarPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDataNAscimentoLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDataNAscimentoLayout.createSequentialGroup()
                        .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDataNAscimentoLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(144, 144, 144)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDataNAscimentoLayout.createSequentialGroup()
                                .addComponent(jTextFieldIdIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomepPaciente)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDataNAscimentoLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDataNAscimentoLayout.createSequentialGroup()
                                .addComponent(jTextFieldIdCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataNAscimentoLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelDataNAscimentoLayout.setVerticalGroup(
            jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataNAscimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDataNAscimentoLayout.createSequentialGroup()
                        .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldIdIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNomepPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldIdCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDataNAscimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelExame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDataNAscimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 50, 1110, 660);

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("                   MARCAR EXAME");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 10, 380, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/FundoFormPaciente.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 720);

        setSize(new java.awt.Dimension(1150, 720));
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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        buscarExamesParaMarcar();
   
         
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_formWindowOpened

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
      
        jTextFieldIdData.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 0).toString());
         jTextFieldNomeExame.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 1).toString());
         jTextFieldDataRealizar.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 3).toString());
        jTextFieldValorExame.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 4).toString());
         jTextFieldForma.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 5).toString());
         jTextFieldMedico.setText(jTableExames.getValueAt(jTableExames.getSelectedRow(), 2).toString());
        
        String forma = jTableExames.getValueAt(jTableExames.getSelectedRow(), 5).toString();
    if(forma.equals("AGENDA")){
             jTextFieldForma.setBackground(new java.awt.Color(255, 255, 51));
             jTextFieldIdData.setBackground(new java.awt.Color(255, 255, 51));
                     jTextFieldNomeExame.setBackground(new java.awt.Color(255, 255, 51));
                      jTextFieldDataRealizar.setBackground(new java.awt.Color(255, 255, 51));
                            jTextFieldValorExame.setBackground(new java.awt.Color(255, 255, 51));
                              jTextFieldForma.setBackground(new java.awt.Color(255, 255, 51));
                              jTextFieldMedico.setBackground(new java.awt.Color(255, 255, 51));
            
            
        
        
        }
        else{
        
         
            jTextFieldForma.setBackground(Color.WHITE);
             jTextFieldIdData.setBackground(Color.WHITE);
                     jTextFieldNomeExame.setBackground(Color.WHITE);
                      jTextFieldDataRealizar.setBackground(Color.WHITE);
                            jTextFieldValorExame.setBackground(Color.WHITE);
                              jTextFieldForma.setBackground(Color.WHITE);
                              jTextFieldMedico.setBackground(Color.WHITE);
        
        }
         
    }//GEN-LAST:event_jTableExamesMouseClicked

    private void jTextFieldIdDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdDataActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldIdDataActionPerformed

    private void jTextFieldIdIdPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdIdPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdIdPacienteActionPerformed

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
  jTextFieldIdCPF.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 2).toString());
  jTextFieldPlano.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 4).toString());
        jTextFieldDesconto.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 5).toString());
        
    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jButtonBuscarDatExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarDatExameActionPerformed
        // TODO add your handling code here:
        
        buscarExamePorNomeData();
        
           /*
        String nome = jTextFieldNomeExameBuscar.getText();
          
        try {
            
            JoinDAO daoj = new JoinDAO();
            List<JoinBuscarExameEMarcar> listaExames = daoj.listarExamesPorNomeParaMarcar(nome);

            DefaultTableModel modelo = (DefaultTableModel)jTableExames.getModel();
            modelo.setNumRows(0);
       
            
            
               
            
            
           
  NumberFormat nf = NumberFormat.getCurrencyInstance(); 

            int i = 0;
            for(JoinBuscarExameEMarcar ex: listaExames){
modelo.addRow(new String[i]);

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(ex.getDataRealizar());  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");   



jTableExames.setValueAt(ex.getId_marcarBuscar(), i, 0);
jTableExames.setValueAt(ex.getExameRequerido(), i, 1);
jTableExames.setValueAt(formatoRetorno.format(date), i, 2);
jTableExames.setValueAt(nf.format(ex.getValorExame()), i, 3);

            i++;
            }
            
        } catch (Exception e) {}
        */
    }//GEN-LAST:event_jButtonBuscarDatExameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        buscarPAcientes();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        
          if (jTextFieldNomeExame.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Os dados do Exame São Obrigatórios!");
            
         
            jTextFieldNomepPaciente.setText("");
     
            jTextFieldIdIdPaciente.setText("");
     
            
        } else if(jTextFieldNomepPaciente.getText().equals("")){
        
          JOptionPane.showMessageDialog(rootPane, "Os dados do Paciente São Obrigatórios");
   
           
          jTextFieldIdData.setText("");
          jTextFieldNomeExame.setText("");
          jTextFieldDataRealizar.setText("");
      
          jTextFieldValorExame.setText("");
        
        
        }else{
        
           MarcarDAO daom = new MarcarDAO();
        
        int idMarcar = Integer.parseInt(jTextFieldIdData.getText());
        int idPaciente = Integer.parseInt(jTextFieldIdIdPaciente.getText());
        
        if (daom.ValidarCadastroDeExamesRepetido(idMarcar, idPaciente)) {
            
            JOptionPane.showMessageDialog(rootPane, "Esta Exame Já foi Marcada");
            
        }else{
        
       
            
        marcarExameDefinitivo();
  
  
        }
        
        }
        
        
        
     
        
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       
   
        
        
        
        /*

        jTextFieldIdData.setText("");
      
                jTextFieldIdIdPaciente.setText("");
                jTextFieldNomeExame.setText("");
             
                jTextFieldNomepPaciente.setText("");
                jTextFieldDataRealizar.setText("");
                jTextFieldValorExame.setText("");
              
                jTextFieldBuscarPaciente.setText("");
                 jTextFieldForma.setText("");
               
        
      */
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldNomeExameBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeExameBuscarKeyPressed
        // TODO add your handling code here
        
        buscarExamePorNomeData();
     
    }//GEN-LAST:event_jTextFieldNomeExameBuscarKeyPressed

    private void jTextFieldBuscarPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarPacienteKeyPressed
        // TODO add your handling code here:
        
        buscarPAcientes();
    }//GEN-LAST:event_jTextFieldBuscarPacienteKeyPressed

    private void jTextFieldFormaBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFormaBuscaKeyPressed
        // TODO add your handling code here:
        
        buscarExamePorNomeData();
    }//GEN-LAST:event_jTextFieldFormaBuscaKeyPressed

    private void jTablePacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablePacienteMouseEntered

    private void jTextFieldNomeMedicoBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeMedicoBuscaKeyPressed
        // TODO add your handling code here:
        
        buscarExamePorNomeData();
    }//GEN-LAST:event_jTextFieldNomeMedicoBuscaKeyPressed

    private void jTextFieldDataBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDataBuscaKeyPressed
        // TODO add your handling code here:
        
        buscarExamePorNomeData();
    }//GEN-LAST:event_jTextFieldDataBuscaKeyPressed

    private void jTextFieldIdCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdCPFActionPerformed

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
            java.util.logging.Logger.getLogger(MascarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MascarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MascarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MascarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MascarExame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonBuscarDatExame;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonMinimizar;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelDataNAscimento;
    private javax.swing.JPanel jPanelExame;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableExames;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextField jTextFieldBuscarPaciente;
    private javax.swing.JTextField jTextFieldDataBusca;
    private javax.swing.JTextField jTextFieldDataRealizar;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldForma;
    private javax.swing.JTextField jTextFieldFormaBusca;
    private javax.swing.JTextField jTextFieldIdCPF;
    private javax.swing.JTextField jTextFieldIdData;
    private javax.swing.JTextField jTextFieldIdIdPaciente;
    private javax.swing.JTextField jTextFieldMedico;
    private javax.swing.JTextField jTextFieldNomeExame;
    private javax.swing.JTextField jTextFieldNomeExameBuscar;
    private javax.swing.JTextField jTextFieldNomeMedicoBusca;
    private javax.swing.JTextField jTextFieldNomepPaciente;
    private javax.swing.JTextField jTextFieldPlano;
    private javax.swing.JTextField jTextFieldValorExame;
    // End of variables declaration//GEN-END:variables
}
