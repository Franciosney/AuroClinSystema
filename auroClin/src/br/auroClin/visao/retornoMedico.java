/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.AbrirCaixaDAO;
import DAO.MarcarDAO;
import DAO.PacienteDAO;
import DAO.finalizarMarcarDAO;
import DAO.retornoDAO;
import br.auroClin.model.AbrirCaixaModel;
import br.auroClin.model.JoinBuscarExameEMarcar;
import br.auroClin.model.Marcar;
import br.auroClin.model.Paciente;
import br.auroClin.model.finalizarMarcar;
import br.auroClin.model.relatorioExame;
import br.auroClin.model.retornoModelo;
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
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Franciosney Souza
 */
public class retornoMedico extends javax.swing.JFrame {

    /**
     * Creates new form retornoMedico
     * @param nomeExame
     * @param nomePaciente
     */
    
    
    RemarcarRetorno remarcarRetorno;
    
    
    
    public void buscarExamesConsultas(String nomeExame,int id){
    
        
             SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
          
        
        

        try {
            

       // String data = jTextFieldData.getText();
            
            
          retornoDAO daor = new retornoDAO();
            
            List<JoinBuscarExameEMarcar> listaExames = daor.BuscarExameConsultasMArcarRetorno(nomeExame,id);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableDatasConsultasExames.getModel();
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

    
     
jTableDatasConsultasExames.setValueAt(ex.getId_marcarBuscar(), i, 0);
jTableDatasConsultasExames.setValueAt(ex.getExameRequerido(), i, 1);
jTableDatasConsultasExames.setValueAt(ex.getNomeMedico(), i, 2);
jTableDatasConsultasExames.setValueAt(formatoRetorno.format(date), i, 3);


    
   


          
            i++;
            
            }
             
             
             
             
        }
                
    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
      
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      
    
    
    public void retornoConsultasExames(){
    
        
             SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
       int mes,mesAtual;
        mes = cal.get(cal.MONTH);
        mesAtual = mes +1;
        
 
String mesString = Integer.toString(mesAtual);
     
    
        
        String a = Integer.toString(mesAtual);
             String d = "/";
                String b = Integer.toString(cal.get(cal.YEAR));
                     String dataBanco = a+d+b;
                       
        

        try {
            

       // String data = jTextFieldData.getText();
            
            
          retornoDAO daor = new retornoDAO();
            
            List<relatorioExame> listaExames = daor.retornoConsultasExames(dataBanco);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableRetorConsultasExamesMarcados.getModel();
            modelo.setNumRows(0);
       
            
                  
  NumberFormat nf = NumberFormat.getCurrencyInstance(); 


               int i = 0;
            for(relatorioExame ex: listaExames){
                
                
       
                
        
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

    
     
jTableRetorConsultasExamesMarcados.setValueAt(ex.getNomePAciente(), i, 0);
jTableRetorConsultasExamesMarcados.setValueAt(ex.getNomeBusca(), i, 1);
jTableRetorConsultasExamesMarcados.setValueAt(ex.getNomeMedico(), i, 2);
jTableRetorConsultasExamesMarcados.setValueAt(formatoRetorno.format(date), i, 3);
//jTableRetorConsultasExamesMarcados.setValueAt(ex.getHorarios(), i, 4);

           
    
   


          
            i++;
            
            }
             
             
             
             
        }
                
    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
      
    
    }
    
    
    
    
    
    
    
    
    
     
    public void retornoConsultasExamesBuscarMes(){
    

        
        int month,year= 0;  
                
 month = jMonthChooserMes.getMonth();
 year = jYearChooserAno.getYear();
 

 month = month + 01;

         String a = Integer.toString(month);
             String d = "/";
                String b = Integer.toString(year);
                     String c = a+d+b;
                           String dataBanco = c;
                           
        

        try {
            

       // String data = jTextFieldData.getText();
            
            
          retornoDAO daor = new retornoDAO();
            
            List<relatorioExame> listaExames = daor.retornoConsultasExames(dataBanco);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableRetorConsultasExamesMarcados.getModel();
            modelo.setNumRows(0);
       
            
                  
  NumberFormat nf = NumberFormat.getCurrencyInstance(); 


               int i = 0;
            for(relatorioExame ex: listaExames){
                
                
       
                
        
 
  
           
modelo.addRow(new String[i]);

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(ex.getDataFazer());  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");   

    
     
jTableRetorConsultasExamesMarcados.setValueAt(ex.getNomePAciente(), i, 0);
jTableRetorConsultasExamesMarcados.setValueAt(ex.getNomeBusca(), i, 1);
jTableRetorConsultasExamesMarcados.setValueAt(ex.getNomeMedico(), i, 2);
jTableRetorConsultasExamesMarcados.setValueAt(formatoRetorno.format(date), i, 3);

           
    
   


          
            i++;
            
      
             
             
             
             
        }
                
    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
      
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void buscarPorDataExamesConsultas(String dataBusca,String nomeExame){
    
        
             SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
          
        int idMarcado = Integer.parseInt(jTextFieldMarcado.getText());
        

        try {
            

       // String data = jTextFieldData.getText();
            
            
          retornoDAO daor = new retornoDAO();
            
            System.err.println(dataBusca);
            System.err.println(nomeExame);
          
            List<JoinBuscarExameEMarcar> listaExames = daor.BuscarExameConsultasMArcarRetornoPorData(dataBusca, nomeExame,idMarcado);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableDatasConsultasExames.getModel();
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

    
     
jTableDatasConsultasExames.setValueAt(ex.getId_marcarBuscar(), i, 0);
jTableDatasConsultasExames.setValueAt(ex.getExameRequerido(), i, 1);
jTableDatasConsultasExames.setValueAt(ex.getNomeMedico(), i, 2);
jTableDatasConsultasExames.setValueAt(formatoRetorno.format(date), i, 3);


    
   


          
            i++;
            
            }
             
             
             
             
        }
                
    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
        
      
    
    }
    
    
    
    
   
    
    
    public void buscarExamePorNomeData(String nomePaciente){
    
 
        try {
            
            
       
 
       // String data = jTextFieldData.getText();
            
            System.out.println(nomePaciente);     
       
            retornoDAO daor = new retornoDAO();
            
            List<JoinBuscarExameEMarcar> listaExames = daor.listaDatasExamesRetorno(nomePaciente);
            
            DefaultTableModel modelo = (DefaultTableModel)jTableRetornosExames.getModel();
            modelo.setNumRows(0);
       
            
                  
  NumberFormat nf = NumberFormat.getCurrencyInstance(); 


               int i = 0;
            for(JoinBuscarExameEMarcar ex: listaExames){
                
                
       
                
        
                  DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
             
   
           
modelo.addRow(new String[i]);

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = (Date)formatter.parse(ex.getDataRealizar());  
    SimpleDateFormat formatoRetorno = new SimpleDateFormat("dd MMM yyyy");   

    
     
jTableRetornosExames.setValueAt(ex.getId_marcarBuscar(), i, 0);
jTableRetornosExames.setValueAt(ex.getExameRequerido(), i, 1);
jTableRetornosExames.setValueAt(ex.getNomeMedico(), i, 2);
jTableRetornosExames.setValueAt(formatoRetorno.format(date), i, 3);
jTableRetornosExames.setValueAt(ex.getFormaRealizar(), i, 4);
jTableRetornosExames.setValueAt(ex.getRetorno(), i, 5);

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
    
    
    
    
    
    
    
    public void marcarConsultaDefinitivamente(){



                try {

                    finalizarMarcar fmarcar = new finalizarMarcar();
                    int idDataMarcar = Integer.parseInt(jTextField1IdRetorno.getText());
                    fmarcar.setId_dataMarcar(idDataMarcar);
                    int idPaciente = Integer.parseInt(jTextField1IdPaciente.getText());
                    fmarcar.setId_paciente(idPaciente);
                
                  
                 
                    String situacao = "RETORNO";
                   String situacaoFila = "ESPERA";
                   fmarcar.setSituacaoFila(situacaoFila);
                    fmarcar.setSituacao(situacao);
                    fmarcar.setRetorno(situacao);
                 
  
                    finalizarMarcarDAO daof= new finalizarMarcarDAO();
                    daof.efetivarCadastroExame(fmarcar);

                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                } catch (Exception e) {

                    JOptionPane.showMessageDialog(rootPane, e);
                }

           

            
   
            //---------------- Fim do Codigo
             
       
        
    
    
    
    
    }
    
    
    
    
    
    
    
    public retornoMedico() {
        initComponents();
        
         


JTableHeader headerExames = jTableRetornosExames.getTableHeader();   
    headerExames.setPreferredSize(new Dimension(0, 25)); 
   headerExames.setFont(new Font("��������", Font.PLAIN, 14));
	headerExames.setPreferredSize(new Dimension(headerExames.getWidth(),25));
                        
                 jTableRetornosExames.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableRetornosExames.getColumnModel().getColumn(0).setPreferredWidth(40);
jTableRetornosExames.getColumnModel().getColumn(1).setPreferredWidth(190);
jTableRetornosExames.getColumnModel().getColumn(2).setPreferredWidth(250);
jTableRetornosExames.getColumnModel().getColumn(3).setPreferredWidth(100);
jTableRetornosExames.getColumnModel().getColumn(4).setPreferredWidth(80);
jTableRetornosExames.getColumnModel().getColumn(5).setPreferredWidth(100);

jTableRetornosExames.setRowHeight(20); 
                
   

JTableHeader headerExamesRetornos = jTableRetorConsultasExamesMarcados.getTableHeader();   
    headerExamesRetornos.setPreferredSize(new Dimension(0, 25)); 
   headerExamesRetornos.setFont(new Font("��������", Font.PLAIN, 14));
	headerExamesRetornos.setPreferredSize(new Dimension(headerExamesRetornos.getWidth(),25));
                        
                jTableRetorConsultasExamesMarcados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(0).setPreferredWidth(200);
jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(1).setPreferredWidth(180);
jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(2).setPreferredWidth(150);
jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(3).setPreferredWidth(110);
//jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(4).setPreferredWidth(110);
//jTableRetorConsultasExamesMarcados.getColumnModel().getColumn(4).setPreferredWidth(110);

jTableRetorConsultasExamesMarcados.setRowHeight(20); 



JTableHeader headerExamesConsultas = jTableDatasConsultasExames.getTableHeader();   
    headerExamesConsultas.setPreferredSize(new Dimension(0, 25)); 
   headerExamesConsultas.setFont(new Font("��������", Font.PLAIN, 14));
	headerExamesConsultas.setPreferredSize(new Dimension(headerExamesConsultas.getWidth(),25));
                        
                jTableDatasConsultasExames.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableDatasConsultasExames.getColumnModel().getColumn(0).setPreferredWidth(40);
jTableDatasConsultasExames.getColumnModel().getColumn(1).setPreferredWidth(200);
jTableDatasConsultasExames.getColumnModel().getColumn(2).setPreferredWidth(275);
jTableDatasConsultasExames.getColumnModel().getColumn(3).setPreferredWidth(110);


jTableDatasConsultasExames.setRowHeight(20); 


JTableHeader headerPaciente =  jTablePaciente.getTableHeader();   
    headerPaciente.setPreferredSize(new Dimension(0, 25)); 
   headerPaciente.setFont(new Font("��������", Font.PLAIN, 14));
	headerPaciente.setPreferredSize(new Dimension(headerPaciente.getWidth(),25));
                        
                 jTablePaciente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(60);
jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(330);
jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(125);
jTablePaciente.setRowHeight(20); 
        


jTextField1IdPaciente.setEditable(false);
 jTextFieldNomePaciente.setEditable(false); 
jTextField1IdRetorno.setEditable(false); 
 jTextFieldNomeExame.setEditable(false); 
 jTextFieldData.setEditable(false); 
jTextFieldMarcado.setEditable(false); 
jTextFieldMarcado.setVisible(false);
 
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
        jPanelDataNAscimento = new javax.swing.JPanel();
        jTextFieldBuscarPaciente = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jButtonBuscarPaciente = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRetornosExames = new javax.swing.JTable();
        jTextFieldMarcado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonFechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1IdPaciente = new javax.swing.JTextField();
        jTextFieldNomePaciente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNomeExame = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDatasConsultasExames = new javax.swing.JTable();
        jTextField1IdRetorno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldDataBuscar = new javax.swing.JTextField();
        jButtonData = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableRetorConsultasExamesMarcados = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMonthChooserMes = new com.toedter.calendar.JMonthChooser();
        jYearChooserAno = new com.toedter.calendar.JYearChooser();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanelDataNAscimento.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDataNAscimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione um Paciente na Tabela"));

        jTextFieldBuscarPaciente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldBuscarPaciente.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldBuscarPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarPacienteKeyPressed(evt);
            }
        });

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(jTablePaciente);

        jButtonBuscarPaciente.setText("Buscar Paciente");
        jButtonBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPacienteActionPerformed(evt);
            }
        });

        jLabel16.setText("DIGITE UM NOME PARA BUSCA:");

        jTableRetornosExames.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTableRetornosExames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Consulta / Exame", "Médico", "Data", "Realização", "Retorno"
            }
        ));
        jTableRetornosExames.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableRetornosExames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRetornosExamesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRetornosExames);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("      Consultas / Exames Realizados");
        jLabel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelDataNAscimentoLayout = new javax.swing.GroupLayout(jPanelDataNAscimento);
        jPanelDataNAscimento.setLayout(jPanelDataNAscimentoLayout);
        jPanelDataNAscimentoLayout.setHorizontalGroup(
            jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataNAscimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDataNAscimentoLayout.createSequentialGroup()
                        .addComponent(jTextFieldBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
                    .addGroup(jPanelDataNAscimentoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jTextFieldMarcado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addContainerGap())
            .addGroup(jPanelDataNAscimentoLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelDataNAscimentoLayout.setVerticalGroup(
            jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataNAscimentoLayout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldMarcado)
                    .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDataNAscimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("            RETORNO DE PACIENTE");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Marcar Retorno "));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Paciente");

        jLabel4.setText("ID ");

        jLabel6.setText("Retorno");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/IconRetornarPronto.png"))); // NOI18N
        jButton2.setText("Marcar Retorno");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTableDatasConsultasExames.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableDatasConsultasExames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Consulta/Exame", "Médico", "Data"
            }
        ));
        jTableDatasConsultasExames.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableDatasConsultasExames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDatasConsultasExamesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableDatasConsultasExames);

        jLabel7.setText("ID ");

        jTextFieldDataBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDataBuscarKeyPressed(evt);
            }
        });

        jButtonData.setText("Buscar Data");
        jButtonData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDataActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("            Selecione uma data para Retorno abaixo");
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("Dia");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Etnenção!");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("\"Encaixe o retorno nas consultas diárias, Marque uma data\"");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField1IdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1IdRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldData))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(141, 141, 141))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)))
                                .addComponent(jTextFieldDataBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonData, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1IdRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1IdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDataBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)))))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableRetorConsultasExamesMarcados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome Paciente", "Exame/Consulta", "Médico", "Data Retorno"
            }
        ));
        jTableRetorConsultasExamesMarcados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane4.setViewportView(jTableRetorConsultasExamesMarcados);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("     RETORNOS MARCADOS POR MÊS");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/icon01.png"))); // NOI18N

        jButton5.setText("Remarcar Retorno");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jMonthChooserMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jYearChooserAno, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 96, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(jYearChooserAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jMonthChooserMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDataNAscimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(577, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233)
                .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDataNAscimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 20, 1330, 670);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/fundoConsulta.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1350, 800);

        setSize(new java.awt.Dimension(1350, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldBuscarPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarPacienteKeyPressed
        // TODO add your handling code here:

        buscarPAcientes();
    }//GEN-LAST:event_jTextFieldBuscarPacienteKeyPressed

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

       // jTextFieldIdIdPaciente.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0).toString());
        
        try {
            
            
            String nomePaciente = jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 1).toString();
        jTextField1IdPaciente.setText( jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0).toString());
        jTextFieldNomePaciente.setText(nomePaciente);
        buscarExamePorNomeData(nomePaciente);
        jTextField1IdPaciente.setBackground(new java.awt.Color(0, 255, 204));
        jTextFieldNomePaciente.setBackground(new java.awt.Color(0, 255, 204));
            
        } catch (Exception e) {
            
            
            
            
        }
       
       
        
    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jButtonBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPacienteActionPerformed
        // TODO add your handling code here:

        buscarPAcientes();

    }//GEN-LAST:event_jButtonBuscarPacienteActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jTableRetornosExamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRetornosExamesMouseClicked
        // TODO add your handling code here:
        
          // jTextField1IdPaciente.setText(jTableRetornosExames.getValueAt(jTableRetornosExames.getSelectedRow(), 0).toString());
        //jTextFieldValorConsulta.setText(jTableConsulta.getValueAt(jTableConsulta.getSelectedRow(), 4).toString());
        
                
jTableRetornosExames.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel  
jTableRetornosExames.addMouseListener(new MouseAdapter() {  
    public void mouseClicked(MouseEvent e)  
    {  
        if (e.getClickCount() == 2)  
        {  

           //JOptionPane.showMessageDialog(null, "Você não Pode Editar! Não Insista");
        }  
    }  
});  
        
        
    
        try {
            
                 String nomeExame =jTableRetornosExames.getValueAt(jTableRetornosExames.getSelectedRow(), 1).toString();
        jTextFieldNomeExame.setText(nomeExame);
        int id =  Integer.parseInt(jTableRetornosExames.getValueAt(jTableRetornosExames.getSelectedRow(), 0).toString());
        buscarExamesConsultas(nomeExame,id);
        
         
           jTextFieldMarcado.setText(jTableRetornosExames.getValueAt(jTableRetornosExames.getSelectedRow(), 0).toString()); 
        } catch (Exception e) {
            
         
            
        }
        
        
       //System.out.println(jTextFieldMarcado.getText()); 
        
    }//GEN-LAST:event_jTableRetornosExamesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        
        if (jTextFieldNomePaciente.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um Paciente na Tabela!");
            jTablePaciente.setBorder(BorderFactory.createLineBorder(Color.red));
            jButtonBuscarPaciente.setBorder(BorderFactory.createLineBorder(Color.red));
            
            
        } else if(jTextField1IdRetorno.getText().equals("")){
        
        JOptionPane.showMessageDialog(rootPane, "Selecione uma Data para o Paciente Retornar na Tabela!");
            jTableDatasConsultasExames.setBorder(BorderFactory.createLineBorder(Color.red));
            jButtonData.setBorder(BorderFactory.createLineBorder(Color.red));
        
        
        } else{
        
            
            
         retornoDAO daor = new retornoDAO();
     
    
         
         int idMarcado = Integer.parseInt(jTextFieldMarcado.getText());
         int idPaciente = Integer.parseInt(jTextField1IdPaciente.getText());
         
   
             
             
             String nome = jTextFieldNomePaciente.getText();
             
              int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Você deseja Marcar o Retorno de " + nome , "Title on Box", dialogButton);
            if(dialogResult == 0) {
            
                
                
                 
            MarcarDAO daom = new MarcarDAO();
        
        int idMarcar = Integer.parseInt(jTextField1IdRetorno.getText());
        int idPacienteValiodar = Integer.parseInt(jTextField1IdPaciente.getText());
        
        if (daom.ValidarCadastroDeExamesRepetido(idMarcar, idPacienteValiodar)) {
            
            JOptionPane.showMessageDialog(rootPane, "Esta Retorno Já foi Marcada");
               jTextField1IdPaciente.setText("");
          jTextField1IdRetorno.setText("");
          jTextFieldNomePaciente.setText("");
          jTextFieldNomeExame.setText("");
          jTextFieldData.setText("");
            
        }else{
       
          String validarRetorno = jTableRetornosExames.getValueAt(jTableRetornosExames.getSelectedRow(), 5).toString();
          //JOptionPane.showMessageDialog(rootPane, validarRetorno);
        
        if (validarRetorno.equals("RETORNO")) {
            
            JOptionPane.showMessageDialog(rootPane, "Esta Retorno Já foi Marcada");
               jTextField1IdPaciente.setText("");
          jTextField1IdRetorno.setText("");
          jTextFieldNomePaciente.setText("");
          jTextFieldNomeExame.setText("");
          jTextFieldData.setText("");
            
        }else{
        
         marcarConsultaDefinitivamente();
          JOptionPane.showMessageDialog(rootPane, "Retorno Marcado com Sucesso");
          jTextField1IdPaciente.setText("");
          jTextField1IdRetorno.setText("");
          jTextFieldNomePaciente.setText("");
          jTextFieldNomeExame.setText("");
          jTextFieldData.setText("");
        }

        }
            
        
                
                
             
                 
                     
                
           
               
         
                
            
            }else{
            
            
                   JOptionPane.showMessageDialog(rootPane, "Você Não Marcou o Retorno Para "+nome);  
                
            
            }
             
             
         
    
         
            
            
        
        
        }
        
     
        
      
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTableDatasConsultasExamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDatasConsultasExamesMouseClicked
        // TODO add your handling code here:
        
           //---- Controlando Clique na tabela
        
jTableDatasConsultasExames.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel  
jTableDatasConsultasExames.addMouseListener(new MouseAdapter() {  
    public void mouseClicked(MouseEvent e)  
    {  
        if (e.getClickCount() == 2)  
        {  

           //JOptionPane.showMessageDialog(null, "Você não Pode Editar! Não Insista");
        }  
    }  
});  
        
        try {
            
             jTextField1IdRetorno.setText(jTableDatasConsultasExames.getValueAt(jTableDatasConsultasExames.getSelectedRow(), 0).toString());
        jTextFieldData.setText(jTableDatasConsultasExames.getValueAt(jTableDatasConsultasExames.getSelectedRow(), 3).toString());
        jTextFieldNomeExame.setBackground(new java.awt.Color(0, 255, 204));
        jTextField1IdRetorno.setBackground(new java.awt.Color(0, 255, 204));
        jTextFieldData.setBackground(new java.awt.Color(0, 255, 204));
            
        } catch (Exception e) {
            
          
        }
  

       
    }//GEN-LAST:event_jTableDatasConsultasExamesMouseClicked

    private void jButtonDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDataActionPerformed
        // TODO add your handling code here:
  
        
        if (jTextFieldNomeExame.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um Exame/Consulta já realizado pelo Paciente");
            
              jTableRetornosExames.setBorder(BorderFactory.createLineBorder(Color.red));
            
        } else{
        
            
             
          String data = jTextFieldDataBuscar.getText();
        String nomeExame = jTextFieldNomeExame.getText();
        
        buscarPorDataExamesConsultas(data, nomeExame);
            
        
        }
        
   
       
       

        
    }//GEN-LAST:event_jButtonDataActionPerformed

    private void jTablePacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablePacienteMouseEntered

    private void jTextFieldDataBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDataBuscarKeyPressed
        // TODO add your handling code here:
        
        
        if (jTextFieldNomeExame.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um Exame/Consulta já realizado pelo Paciente");
            
              jTableRetornosExames.setBorder(BorderFactory.createLineBorder(Color.red));
            
        } else{
        
            
             
          String data = jTextFieldDataBuscar.getText();
        String nomeExame = jTextFieldNomeExame.getText();
        
        buscarPorDataExamesConsultas(data, nomeExame);
            
        
        }
        
        
       
        
    }//GEN-LAST:event_jTextFieldDataBuscarKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        retornoConsultasExames();
    }//GEN-LAST:event_formWindowActivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

     retornoConsultasExamesBuscarMes();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
           if (remarcarRetorno == null) {
            
            remarcarRetorno = new RemarcarRetorno();
            remarcarRetorno.setLocationRelativeTo(null);
        }
       // cadMed.setAlwaysOnTop(true);  
        remarcarRetorno.setVisible(true);
        
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
            java.util.logging.Logger.getLogger(retornoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(retornoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(retornoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(retornoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new retornoMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonBuscarPaciente;
    private javax.swing.JButton jButtonData;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooserMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelDataNAscimento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableDatasConsultasExames;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTable jTableRetorConsultasExamesMarcados;
    private javax.swing.JTable jTableRetornosExames;
    private javax.swing.JTextField jTextField1IdPaciente;
    private javax.swing.JTextField jTextField1IdRetorno;
    private javax.swing.JTextField jTextFieldBuscarPaciente;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldDataBuscar;
    private javax.swing.JTextField jTextFieldMarcado;
    private javax.swing.JTextField jTextFieldNomeExame;
    private javax.swing.JTextField jTextFieldNomePaciente;
    private com.toedter.calendar.JYearChooser jYearChooserAno;
    // End of variables declaration//GEN-END:variables
}
