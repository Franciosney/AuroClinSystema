/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.AmbienteMedicoDAO;
import DAO.ProntuarioDAO;
import DAO.ReceituarioDAO;

import br.auroClin.model.ControleLog;
import br.auroClin.model.FilaModelo;
import br.auroClin.model.JoinBuscarExameEMarcar;
import br.auroClin.model.ProntuarioModelo;
import br.auroClin.model.Receituario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Franciosney Souza
 */
public class TelaPrincipalMedico extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipalMedico
     * @param id_marcarExame
     * @param nomePaciente
     */
    
    
     receituarioNormal receituario;
     receituarioEspecial receituarioEspecial;
     prontuariosPorPacientesMedico pronPorPaciente;
    
    
    
    public void paginaReceituarioNormal(){
    
        int id = Integer.parseInt(jTextFieldidMarcarExame.getText());
        ReceituarioDAO daor = new ReceituarioDAO();
         List<Receituario> listaId = daor.listarIdReceituario(id);
        
        
        int id_vindo = 0;
            for(Receituario ex: listaId){
            
              id_vindo = ex.getId_prontuario();
                
            
            }
        
        System.out.println("Id -> "+id_vindo);
        
         SimpleDateFormat forData = new SimpleDateFormat("dd MMM yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
        
     
        
          
         String paciente = jTextFieldNomePaciente.getText();
         String servico = jTextFieldServico.getText();
         
        
   
     
  
                 
if (receituario == null) {
    
           //NumberFormat format = NumberFormat.getInstance();
    
            

     
            receituario = new receituarioNormal();
             receituario.setLocationRelativeTo(null);
             receituario.receber(id_vindo,paciente,servico,dataAtual);
        }
 
          //receituario.setFocusableWindowState(false); 
//pagCartao.setAlwaysOnTop(true);  
        receituario.setVisible(true);
        receituario.setState(PagamentoCartao.NORMAL);
         receituario.receber(id_vindo,paciente,servico,dataAtual);
        

    
    }
    
    
    
    
  
    
    
    
    public void paginaReceituarioEspecial(){
    
        int id = Integer.parseInt(jTextFieldidMarcarExame.getText());
        ReceituarioDAO daor = new ReceituarioDAO();
         List<Receituario> listaId = daor.listarIdReceituario(id);
        
        
        int id_vindo = 0;
            for(Receituario ex: listaId){
            
              id_vindo = ex.getId_prontuario();
                
            
            }
        
        System.out.println("Id -> "+id_vindo);
        
         SimpleDateFormat forData = new SimpleDateFormat("dd MMM yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
        
     
        
          
         String paciente = jTextFieldNomePaciente.getText();
         String servico = jTextFieldServico.getText();
         
        
   
     
  
                 
if (receituarioEspecial == null) {
    
           //NumberFormat format = NumberFormat.getInstance();
    
            

     
            receituarioEspecial = new receituarioEspecial();
             receituarioEspecial.setLocationRelativeTo(null);
             receituarioEspecial.receber(id_vindo,paciente,servico,dataAtual);
        }
 
          //receituario.setFocusableWindowState(false); 
//pagCartao.setAlwaysOnTop(true);  
        receituarioEspecial.setVisible(true);
        receituarioEspecial.setState(PagamentoCartao.NORMAL);
         receituarioEspecial.receber(id_vindo,paciente,servico,dataAtual);
        

    
    }
    
    
    
    
    
    
    
    
    
    public void cadastrarProntuario(){
    
    
        
        
   
        int idValidar = Integer.parseInt(jTextFieldidMarcarExame.getText());
        
          ProntuarioDAO daop = new ProntuarioDAO();
            

if(daop.validarProntualAtual(idValidar)){

    JOptionPane.showMessageDialog(rootPane, "Esse Prontuario Já Foi Cadastrado, Obrigado!");


}else{
    

          
        int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this,"Você deseja cadastrar Este Prontuário?", "Title on Box", dialogButton);
if(dialogResult == 0) {

      ProntuarioModelo objp = new ProntuarioModelo();
        objp.setId_marcarExame(Integer.parseInt(jTextFieldidMarcarExame.getText()));
        objp.setDiagnostico(jTextAreaDiagnostico.getText());
        objp.setSintomas(jTextAreaSintomas.getText());
        objp.setDescricao(jTextAreaDescricao.getText());
        objp.setServico(jTextFieldServico.getText());
        objp.setPrescricao(jTextAreaPrescricao.getText());
        
        
        daop.cadastrarProntuario(objp);

        
         
        JOptionPane.showMessageDialog(rootPane, "Prontuário Cadastrado Com Sucesso");
     
    jTextFieldNomePaciente.setText("");
    jTextFieldServico.setText("");
    jTextAreaDiagnostico.setText("");
    jTextAreaSintomas.setText("");
    jTextAreaDescricao.setText("");
    jTextAreaPrescricao.setText("");
    jTextFieldidMarcarExame.setText("");
    jTextFieldServico.setText("");
   
        

}else{

   JOptionPane.showMessageDialog(rootPane, "Você Cancelou");
   jTextAreaDiagnostico.setText("");
   jTextAreaSintomas.setText("");
   jTextAreaDescricao.setText("");

}      
}
 
    }
    
    
    
    
    public void buscarProntuario(int id_marcarExame){
    
        
        ProntuarioDAO daop = new ProntuarioDAO();


        try {

            
            List<ProntuarioModelo> listaProntuario = daop.listaProntuario(id_marcarExame);


            for(ProntuarioModelo objp: listaProntuario){

                jTextFieldidMarcarExame.setText(Integer.toString(objp.getId_marcarExame()));
                                jTextFieldServico.setText(objp.getServico());
                                jTextFieldServico.setEditable(false);
                              
                                jTextFieldNomePaciente.setEditable(false);
                          
                                jTextFieldidMarcarExame.setEditable(false);
                                
                                jTextAreaDiagnostico.setText(objp.getDiagnostico());
                                jTextAreaDiagnostico.setEditable(false);
                                jTextAreaDiagnostico.setBackground(new java.awt.Color(204, 204, 255));
             jTextAreaSintomas.setText(objp.getSintomas());
             jTextAreaSintomas.setEditable(false);
              jTextAreaSintomas.setBackground(new java.awt.Color(204, 204, 255));
 
             jTextAreaDescricao.setText(objp.getDescricao());
             jTextAreaDescricao.setFont(new Font("Monospaced", 0, 20));
             jTextAreaDescricao.setEditable(false);
              jTextAreaDescricao.setBackground(new java.awt.Color(204, 204, 255));
             
              jTextAreaPrescricao.setText(objp.getPrescricao());
              jTextAreaPrescricao.setFont(new Font("Monospaced", 0, 20));
            jTextAreaPrescricao.setEditable(false);
            jTextAreaPrescricao.setBackground(new java.awt.Color(204, 204, 255));
              
      
               jTextAreaSintomas.setFont(new Font("Monospaced", 0, 20));
            jTextFieldServico.setEditable(false);
            jTextFieldServico.setBackground(new java.awt.Color(204, 204, 255));
            //jTextFieldServico.setBorder(BorderFactory.createLineBorder(Color.gray));
            jTextFieldMedicoResponsavel.setText(objp.getNomeMedico());

jTextFieldFrequencia.setText("");


            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
            
            

       
    }
    
    
    
    
    
    public void buscarProntuarioAntigos(int id_marcarExame){
    
        
        ProntuarioDAO daop = new ProntuarioDAO();


        try {

            
            List<ProntuarioModelo> listaProntuario = daop.listaProntuarioAntigos(id_marcarExame);


            for(ProntuarioModelo objp: listaProntuario){

                jTextAreaDiagnostico.setText(objp.getDiagnostico());
                jTextAreaDiagnostico.setFont(new Font("Monospaced", 0, 20));
                jTextAreaDiagnostico.setEditable(false);
                jTextAreaDiagnostico.setBackground(new java.awt.Color(204, 204, 255));

                jTextAreaSintomas.setText(objp.getSintomas());
                jTextAreaSintomas.setFont(new Font("Monospaced", 0, 20));
                jTextAreaSintomas.setEditable(false);
                jTextAreaSintomas.setBackground(new java.awt.Color(204, 204, 255));

                jTextAreaDescricao.setText(objp.getDescricao());
                jTextAreaDescricao.setFont(new Font("Monospaced", 0, 20));
                jTextAreaDescricao.setEditable(false);
                jTextAreaDescricao.setBackground(new java.awt.Color(204, 204, 255));

                jTextAreaPrescricao.setText(objp.getPrescricao());
                jTextAreaPrescricao.setFont(new Font("Monospaced", 0, 20));
                jTextAreaPrescricao.setEditable(false);
                jTextAreaPrescricao.setBackground(new java.awt.Color(204, 204, 255));
                
                jTextFieldMedicoResponsavel.setText(objp.getNomeMedico());

               


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
    
    
    
    
    
    
    
    
    
    
    
    public void CorTabela(){
   
          
jTableConsultasExames.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    
     private String CLASS = "ATENDIMENTO";
     private String CLASSS = "FINALIZADO";
     private String CLASSSS = "Nº Prioridade";
     private String CLASSSSS = "CANCELADO";
     @Override
    public JLabel getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, 
            int row, int column)
    {
        
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        
        Color c = Color.WHITE;
        
        Object testo = jTableConsultasExames.getValueAt(row, 4);
        Object testoT = jTableConsultasExames.getValueAt(row, 4);
         Object testoTTT = jTableConsultasExames.getValueAt(row, 4);
         Object testoTT = jTableConsultasExames.getValueAt(row, 3);
         
          
          if (testoT != null && CLASSSS.equals(testoTT.toString())){
         
         c = new java.awt.Color(255, 102, 255);
     
             
         }
        
        if (testo != null && CLASS.equals(testo.toString())){
         
           c = new java.awt.Color(0, 255, 153);
      
            //label.setBackground(c);
        
              //label.setForeground(c);      
              //jTableCaixa.setSelectionBackground(Color.RED);
        }
   
            
           
         if (testoT != null && CLASSS.equals(testoT.toString())){
         
         c = new java.awt.Color(204, 204, 204);
     
             
         }
         
            
         if (testoT != null && CLASSSSS.equals(testoTTT.toString())){
         
         c = new java.awt.Color(255, 51, 51);
     
             
         }
         
        
        
        
                label.setBackground(c);
                jTableConsultasExames.setSelectionForeground(Color.RED);
                 
        
         return label;
    }

    
});
   
   }
    
    

    
    
    public  void  Atendimentos(){
    
        
  
        
        
        
      try {
 SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
        
        
        
            ControleLog c =new ControleLog();
            String medicoNome = ControleLog.getNomeMedico();
            
            AmbienteMedicoDAO daoA = new AmbienteMedicoDAO();
            List<FilaModelo> listaExamesFila = daoA.Atendimentos(dataAtual, medicoNome);

            DefaultTableModel modelo = (DefaultTableModel)jTableConsultasExames.getModel();
            modelo.setNumRows(0);

            int i = 0;
            for(FilaModelo objp: listaExamesFila){
                modelo.addRow(new String[i]);
                jTableConsultasExames.setValueAt(objp.getIdMarcar(), i, 0);
                jTableConsultasExames.setValueAt(objp.getNomePaciente(), i, 1);
                jTableConsultasExames.setValueAt(objp.getNomeConsulta(), i, 2);
                jTableConsultasExames.setValueAt(String.format("Nº %-3s", objp.getNumeroFicha()), i, 3);
                jTableConsultasExames.setValueAt(objp.getSituacaoFila(), i, 4);
                jTableConsultasExames.setValueAt(objp.getRetorno(), i, 5);
             
        
                
                
               

                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }

    }
    
    

    
    
    public TelaPrincipalMedico() {
        initComponents();
        
      
        jLabelNomeMedico.setText("Seja bem Vindo(a) Dr. "+ControleLog.getNomeMedico());
        System.out.println("Id Medico"+ControleLog.getId_medico());
        
        
        SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
        
        jLabeldATA.setText("    EXAMES/CONSULTAS PARA O DIA "+dataAtual);
        
jTableConsultasExames.getParent().setBackground(Color.WHITE);

  JTableHeader headerPaciente = jTableConsultasExames.getTableHeader();   
    headerPaciente.setPreferredSize(new Dimension(0, 25)); 

	headerPaciente.setPreferredSize(new Dimension(headerPaciente.getWidth(),25));
        
        
        
        
        
DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
headerRenderer.setBackground(Color.YELLOW);

for (int i = 0; i < jTableConsultasExames.getModel().getColumnCount(); i++) {
    jTableConsultasExames.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
}
jTableConsultasExames.getParent().setBackground(Color.WHITE);
    
       JTableHeader headerClic = jTableConsultasExames.getTableHeader();   
    headerClic.setPreferredSize(new Dimension(0, 25)); 
    headerClic.setFont(new Font("��������", Font.PLAIN, 14));
	headerClic.setPreferredSize(new Dimension(headerClic.getWidth(),25));  
      jTableConsultasExames.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableConsultasExames.getColumnModel().getColumn(0).setPreferredWidth(40);
jTableConsultasExames.getColumnModel().getColumn(1).setPreferredWidth(211);
jTableConsultasExames.getColumnModel().getColumn(2).setPreferredWidth(120);
jTableConsultasExames.getColumnModel().getColumn(3).setPreferredWidth(42);
jTableConsultasExames.getColumnModel().getColumn(4).setPreferredWidth(60);
jTableConsultasExames.getColumnModel().getColumn(5).setPreferredWidth(60);

jTableConsultasExames.setRowHeight(23); 
        
 jTableConsultasExames.repaint();    
 jTableConsultasExames.revalidate(); 
 
 
 
   JTableHeader headerHist = jTableHistoricoRecente.getTableHeader();   
    headerHist.setPreferredSize(new Dimension(0, 25)); 
    headerHist.setFont(new Font("��������", Font.PLAIN, 14));
	headerClic.setPreferredSize(new Dimension(headerHist.getWidth(),25));  
      jTableHistoricoRecente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableHistoricoRecente.getColumnModel().getColumn(0).setPreferredWidth(40);
jTableHistoricoRecente.getColumnModel().getColumn(1).setPreferredWidth(122);
jTableHistoricoRecente.setRowHeight(23); 




 
   JTableHeader headerHistAnt = jTableHistoricoAntigo.getTableHeader();   
    headerHistAnt.setPreferredSize(new Dimension(0, 25)); 
    headerHistAnt.setFont(new Font("��������", Font.PLAIN, 14));
	headerClic.setPreferredSize(new Dimension(headerHistAnt.getWidth(),25));  
      jTableHistoricoAntigo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableHistoricoAntigo.getColumnModel().getColumn(0).setPreferredWidth(40);
jTableHistoricoAntigo.getColumnModel().getColumn(1).setPreferredWidth(122);
jTableHistoricoAntigo.setRowHeight(23); 


jTextFieldidMarcarExame.setEditable(false);
jTextFieldNomePaciente.setEditable(false);
jTextFieldServico.setEditable(false);
jTextFieldFrequencia.setEditable(false);
jTextFieldvalidarCancelado.setEditable(false);

jTextFieldMedicoResponsavel.setEditable(false);
validarAntigos.setEditable(false);

 SwingUtilities.invokeLater(new Runnable() {//está funcionando
         @Override
         public void run() {
          repaint(); //repaint pro Frame
         }
});

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsultasExames = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabeldATA = new javax.swing.JLabel();
        jLabelNomeMedico = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButtonFechar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDiagnostico = new javax.swing.JTextArea();
        jTextFieldidMarcarExame = new javax.swing.JTextField();
        jTextFieldNomePaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFrequencia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableHistoricoRecente = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaSintomas = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableHistoricoAntigo = new javax.swing.JTable();
        jTextFieldServico = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaPrescricao = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextFieldMedicoResponsavel = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldvalidarCancelado = new javax.swing.JTextField();
        validarAntigos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableConsultasExames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Paciente", "Exame/Consulta", "Ficha", "Situação", "Frequência"
            }
        ));
        jTableConsultasExames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConsultasExamesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConsultasExames);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/AtualizarTabelaMedico.png"))); // NOI18N
        jButton2.setText("Atualizar Tabela");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabeldATA.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabeldATA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelNomeMedico.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(0, 255, 153));
        jPanel12.setPreferredSize(new java.awt.Dimension(44, 28));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 102, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Em Atendimento");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Prioridade");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Cancelado");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Atend. Finalizado");

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));
        jPanel14.setPreferredSize(new java.awt.Dimension(44, 28));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabeldATA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNomeMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 133, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabeldATA, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 70, 390, 610);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("                    SISTEMA DE GERENCIAMENTO HOMESOFT SOLUÇÕES ");
        jLabel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(315, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270)
                .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(10, 10, 1330, 50);

        jTextAreaDiagnostico.setColumns(20);
        jTextAreaDiagnostico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaDiagnostico.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDiagnostico);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Paciente");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Frêquencia");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaDescricao.setRows(5);
        jScrollPane3.setViewportView(jTextAreaDescricao);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setText("                                                    PRONTUÁRIO MÉDICO ");
        jLabel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Sintomas");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Diagnostico");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Histótico Recente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(0, 153, 51))); // NOI18N

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
        jScrollPane5.setViewportView(jTableHistoricoRecente);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTextAreaSintomas.setColumns(20);
        jTextAreaSintomas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaSintomas.setRows(5);
        jScrollPane4.setViewportView(jTextAreaSintomas);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Descrição");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Histótico Antigo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(0, 153, 51))); // NOI18N

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
        jScrollPane6.setViewportView(jTableHistoricoAntigo);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Exame / Consulta");

        jTextAreaPrescricao.setColumns(20);
        jTextAreaPrescricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaPrescricao.setRows(5);
        jScrollPane7.setViewportView(jTextAreaPrescricao);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Prescrição");

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Tranzações Médica"));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/receituarioEspecial.png"))); // NOI18N
        jButton3.setText(" Gerar Receituário Especial");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/ic-prontuario.png"))); // NOI18N
        jButton1.setText("Cadastrar Prontuário");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Receituario.png"))); // NOI18N
        jButton4.setText("  Gerar Receituário");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTextFieldMedicoResponsavel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Médico Responsável");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldidMarcarExame)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldServico, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107))
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(144, 144, 144)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextFieldMedicoResponsavel)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(256, 256, 256)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldidMarcarExame, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldServico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3))
                                .addGap(8, 8, 8)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldMedicoResponsavel)))))
                .addGap(240, 240, 240))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(410, 70, 930, 610);

        jTextFieldvalidarCancelado.setBackground(new java.awt.Color(240, 240, 240));
        getContentPane().add(jTextFieldvalidarCancelado);
        jTextFieldvalidarCancelado.setBounds(10, 20, 110, 29);
        getContentPane().add(validarAntigos);
        validarAntigos.setBounds(120, 20, 120, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/FundoPrincipal.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -20, 1350, 720);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/arquivos.png"))); // NOI18N
        jMenu4.setText("Arquivos ");
        jMenuBar2.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/prontuariosIcon.png"))); // NOI18N
        jMenu5.setText(" Prontuários   ");

        jMenuItem1.setText("Prontuário por Paciente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar2.add(jMenu5);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/ferramentas.png"))); // NOI18N
        jMenu1.setText("  Ferramentas");

        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        setSize(new java.awt.Dimension(1350, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Atendimentos();
        CorTabela();
    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Atendimentos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTableConsultasExamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsultasExamesMouseClicked
        // TODO add your handling code here:
        
               
jTableConsultasExames.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel  
jTableConsultasExames.addMouseListener(new MouseAdapter() {  
    public void mouseClicked(MouseEvent e)  
    {  
        if (e.getClickCount() == 2)  
        {  

           //JOptionPane.showMessageDialog(null, "Você não Pode Editar! Não Insista");
        }  
    }  
});  
      // ---------- Fim
      
      
      
       String situacao = jTableConsultasExames.getValueAt(jTableConsultasExames.getSelectedRow(), 4).toString();
       
        if (situacao.equals("CANCELADO")) {
            
                 
       
        jTextFieldidMarcarExame.setText(jTableConsultasExames.getValueAt(jTableConsultasExames.getSelectedRow(), 0).toString());
         jTextFieldNomePaciente.setText(jTableConsultasExames.getValueAt(jTableConsultasExames.getSelectedRow(), 1).toString());
          jTextFieldServico.setText(jTableConsultasExames.getValueAt(jTableConsultasExames.getSelectedRow(), 2).toString());
           jTextFieldFrequencia.setText(jTableConsultasExames.getValueAt(jTableConsultasExames.getSelectedRow(), 5).toString());
            
            
  
                jTextAreaDiagnostico.setEditable(false);
                jTextAreaDiagnostico.setBackground(new java.awt.Color(255,51,51));
                jTextAreaDiagnostico.setText("");
                
                jTextAreaDescricao.setEditable(false);
                jTextAreaDescricao.setBackground(new java.awt.Color(255,51,51));
                jTextAreaDescricao.setText("");
                
                 jTextAreaSintomas.setEditable(false);
                jTextAreaSintomas.setBackground(new java.awt.Color(255,51,51));
                jTextAreaSintomas.setText("");
                
                
                 jTextAreaPrescricao.setEditable(false);
                jTextAreaPrescricao.setBackground(new java.awt.Color(255,51,51));
                jTextAreaPrescricao.setText("");
                
                validarAntigos.setText("");
            
            
            
        } else{
        
            
            
            
       String nomePaciente = jTableConsultasExames.getValueAt(jTableConsultasExames.getSelectedRow(), 1).toString();
        jTextFieldidMarcarExame.setText(jTableConsultasExames.getValueAt(jTableConsultasExames.getSelectedRow(), 0).toString());
         jTextFieldNomePaciente.setText(jTableConsultasExames.getValueAt(jTableConsultasExames.getSelectedRow(), 1).toString());
          jTextFieldServico.setText(jTableConsultasExames.getValueAt(jTableConsultasExames.getSelectedRow(), 2).toString());
           jTextFieldFrequencia.setText(jTableConsultasExames.getValueAt(jTableConsultasExames.getSelectedRow(), 5).toString());
        buscarHistorioRecente(nomePaciente);
        buscarHistoricoAntigo(nomePaciente);
      

      ProntuarioDAO daop = new ProntuarioDAO();
      
      int id_idmarcarExame = Integer.parseInt(jTableConsultasExames.getValueAt(jTableConsultasExames.getSelectedRow(), 0).toString());
      
      if(daop.validarProntualAtual(id_idmarcarExame)){
  
        try {

            
            List<ProntuarioModelo> listaProntuario = daop.listaProntuario(id_idmarcarExame);


            for(ProntuarioModelo objp: listaProntuario){

                 jTextFieldidMarcarExame.setText(Integer.toString(objp.getId_marcarExame()));
                                jTextFieldServico.setText(objp.getServico());
                                jTextFieldServico.setEditable(false);
                              
                                jTextFieldNomePaciente.setEditable(false);
                          
                                jTextFieldidMarcarExame.setEditable(false);
                                
                jTextAreaDiagnostico.setText(objp.getDiagnostico());
                jTextAreaDiagnostico.setFont(new Font("Monospaced", 0, 20));
                jTextAreaDiagnostico.setEditable(false);
                jTextAreaDiagnostico.setBackground(new java.awt.Color(204, 204, 255));
                jTextAreaDiagnostico.setLineWrap(true);
                jTextAreaDiagnostico.setMargin(new Insets(10, 10, 10, 10));
        
                jTextAreaSintomas.setText(objp.getSintomas());
                jTextAreaSintomas.setFont(new Font("Monospaced", 0, 20));
                jTextAreaSintomas.setEditable(false);
                jTextAreaSintomas.setBackground(new java.awt.Color(204, 204, 255));
                jTextAreaSintomas.setLineWrap(true);
                jTextAreaSintomas.setMargin(new Insets(10, 10, 10, 10));
 
                jTextAreaDescricao.setText(objp.getDescricao());
                jTextAreaDescricao.setFont(new Font("Monospaced", 0, 20));
                jTextAreaDescricao.setEditable(false);
                jTextAreaDescricao.setBackground(new java.awt.Color(204, 204, 255));
                jTextAreaDescricao.setLineWrap(true);
                jTextAreaDescricao.setMargin(new Insets(10, 10, 10, 10));
             
                
                
                 jTextAreaPrescricao.setText(objp.getPrescricao());
                jTextAreaPrescricao.setFont(new Font("Monospaced", 0, 20));
                jTextAreaPrescricao.setEditable(false);
                jTextAreaPrescricao.setBackground(new java.awt.Color(204, 204, 255));
                jTextAreaPrescricao.setLineWrap(true);
                jTextAreaPrescricao.setMargin(new Insets(10, 10, 10, 10));
                
                jTextFieldMedicoResponsavel.setText("Dr. "+ControleLog.getNomeMedico());
      
      
               jTextAreaSintomas.setFont(new Font("Monospaced", 0, 20));
            jTextFieldServico.setEditable(false);
            jTextFieldServico.setBackground(new java.awt.Color(204, 204, 255));
     
        validarAntigos.setText("");

                
         
            


            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }
      }else{
      
          
      
 
        jTextAreaDiagnostico.setText("");
        jTextAreaDiagnostico.setEditable(true);
        jTextAreaDiagnostico.setFont(new Font("Monospaced", 0, 20));
        jTextAreaDiagnostico.setBackground(Color.white);
         jTextAreaDiagnostico.setLineWrap(true);
        jTextAreaDiagnostico.setMargin(new Insets(10, 10, 10, 10));
        
      
  
        
        jTextAreaSintomas.setText("");
        jTextAreaSintomas.setEditable(true);
        jTextAreaSintomas.setFont(new Font("Monospaced", 0, 20));
        jTextAreaSintomas.setLineWrap(true);
        jTextAreaSintomas.setMargin(new Insets(10, 10, 10, 10));
        jTextAreaSintomas.setBackground(Color.white);
        
        jTextAreaDescricao.setText("");
         jTextAreaDescricao.setEditable(true);
         jTextAreaDescricao.setFont(new Font("Monospaced", 0, 20));
         jTextAreaDescricao.setLineWrap(true);
        jTextAreaDescricao.setMargin(new Insets(10, 10, 10, 10));
        jTextAreaDescricao.setBackground(Color.white);
 
        
        jTextAreaPrescricao.setText("");
        jTextAreaPrescricao.setEditable(true);
        jTextAreaPrescricao.setFont(new Font("Monospaced", 0, 20));
        jTextAreaPrescricao.setLineWrap(true);
        jTextAreaPrescricao.setMargin(new Insets(10, 10, 10, 10));
        jTextAreaPrescricao.setBackground(Color.white);
        
         jTextFieldMedicoResponsavel.setText("Dr. "+ControleLog.getNomeMedico());
        

         
         validarAntigos.setText("");
      
      }
            
      
 
      
      
            
        
        
        
        }
      
 
      
        
         String situacaoC = jTableConsultasExames.getValueAt(jTableConsultasExames.getSelectedRow(), 4).toString(); 
        
        jTextFieldvalidarCancelado.setText(situacaoC);
      
      
        
    }//GEN-LAST:event_jTableConsultasExamesMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        
        Atendimentos();
    }//GEN-LAST:event_formMouseEntered

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        
        Atendimentos();
    }//GEN-LAST:event_formMousePressed

    private void jTableHistoricoRecenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistoricoRecenteMouseClicked
        // TODO add your handling code here:
        
          int id_marcarExame = Integer.parseInt(jTableHistoricoRecente.getValueAt(jTableHistoricoRecente.getSelectedRow(), 0).toString());
        buscarProntuario(id_marcarExame);
        
        validarAntigos.setText("RECENTES");
    
        
    }//GEN-LAST:event_jTableHistoricoRecenteMouseClicked

    private void jTableHistoricoAntigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistoricoAntigoMouseClicked
        // TODO add your handling code here:
        
        
          int id_marcarExame = Integer.parseInt(jTableHistoricoAntigo.getValueAt(jTableHistoricoAntigo.getSelectedRow(), 0).toString());
        buscarProntuarioAntigos(id_marcarExame);
        
        validarAntigos.setText("ANTIGOS");
        
        
        
    }//GEN-LAST:event_jTableHistoricoAntigoMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        
        
          String nomePaciente = jTextFieldNomePaciente.getText();

        if (validarAntigos.getText().equals("RECENTES")) {

            JOptionPane.showMessageDialog(rootPane, "Você Não Pode Gerar Receituário para Históricos Recentes do Paciente");

        } else if (validarAntigos.getText().equals("ANTIGOS")) {

            JOptionPane.showMessageDialog(rootPane, "Você Não Pode Gerar Receituário para Históricos Antigos do Paciente ");

        } else {

            if (jTextFieldvalidarCancelado.getText().equals("CANCELADO")) {

                JOptionPane.showMessageDialog(rootPane, "Você Não Pode Gerar o Receituário deste Serviço, Ele Foi Cancelado!");

            } else {

                if (jTextFieldNomePaciente.getText().equals("")) {

                    JOptionPane.showMessageDialog(rootPane, "Pesquise um Paciente na Tabela ao Lado, Obrigado!");
                    jTableConsultasExames.setBorder(BorderFactory.createLineBorder(Color.red));

                } else {

                    int idValidar = Integer.parseInt(jTextFieldidMarcarExame.getText());

                    ProntuarioDAO daop = new ProntuarioDAO();

                    if (daop.validarProntualAtual(idValidar)) {

                        paginaReceituarioEspecial();
        

                    } else {

                        String nome = jTextFieldNomePaciente.getText();

                        JOptionPane.showMessageDialog(rootPane, "O Receituário de " + nome + " So Será Gerado Após o Cadastro do Prontuário, Obrigado!");

                    }

                }

            }

        }


        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String nomePaciente = jTextFieldNomePaciente.getText();

        if (validarAntigos.getText().equals("RECENTES")) {

            JOptionPane.showMessageDialog(rootPane, "Você Não Pode Gerar Receituário para Históricos Recentes do Paciente");

        } else if (validarAntigos.getText().equals("ANTIGOS")) {

            JOptionPane.showMessageDialog(rootPane, "Você Não Pode Gerar Receituário para Históricos Antigos do Paciente ");

        } else {

            if (jTextFieldvalidarCancelado.getText().equals("CANCELADO")) {

                JOptionPane.showMessageDialog(rootPane, "Você Não Pode Gerar o Receituário deste Serviço, Ele Foi Cancelado!");

            } else {

                if (jTextFieldNomePaciente.getText().equals("")) {

                    JOptionPane.showMessageDialog(rootPane, "Pesquise um Paciente na Tabela ao Lado, Obrigado!");
                    jTableConsultasExames.setBorder(BorderFactory.createLineBorder(Color.red));

                } else {

                    int idValidar = Integer.parseInt(jTextFieldidMarcarExame.getText());

                    ProntuarioDAO daop = new ProntuarioDAO();

                    if (daop.validarProntualAtual(idValidar)) {

                        paginaReceituarioNormal();

                    } else {

                        String nome = jTextFieldNomePaciente.getText();

                        JOptionPane.showMessageDialog(rootPane, "O Receituário de " + nome + " So Será Gerado Após o Cadastro do Prontuário, Obrigado!");

                    }

                }

            }

        }


        
       
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
       
        
        if (jTextFieldvalidarCancelado.getText().equals("CANCELADO")) {
            
            JOptionPane.showMessageDialog(rootPane, "Este Serviço foi Cancelado Pela Recepção, Obrigado!");
            
        }else{
        
        
            
             
         
     if(jTextFieldNomePaciente.getText().equals("")){
    
        
   JOptionPane.showMessageDialog(rootPane, "Pesquise um Paciente na Tabela ao Lado, Obrigado!");
        jTextFieldNomePaciente.setBorder(BorderFactory.createLineBorder(Color.red));
    
        
    
    }else {
  
    if (jTextAreaDiagnostico.getText().equals("")) {
        
        JOptionPane.showMessageDialog(rootPane, "O campo Diagnostico é Obrigatório, Obrigado!");
        jTextAreaDiagnostico.setBorder(BorderFactory.createLineBorder(Color.red));
        
    } else if(jTextAreaSintomas.getText().equals("")){
     JOptionPane.showMessageDialog(rootPane, "O campo Sintomas é Obrigatório, Obrigado!");
        jTextAreaSintomas.setBorder(BorderFactory.createLineBorder(Color.red));
    
    }else if(jTextAreaDescricao.getText().equals("")){
    
        
   JOptionPane.showMessageDialog(rootPane, "O Campo Descrição é Obrigatório, Obrigado!");
        jTextAreaDescricao.setBorder(BorderFactory.createLineBorder(Color.red));
    
        
    
    }else{
    
     
        
             cadastrarProntuario();
            
   
    }
    }
        
        
            
             
            
            
        }
        
        
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
         
        if (pronPorPaciente == null) {
            
            pronPorPaciente = new prontuariosPorPacientesMedico();
            pronPorPaciente.setLocationRelativeTo(null);
        }
       // cadMed.setAlwaysOnTop(true);  
        pronPorPaciente.setVisible(true);
        
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
           TelaLogin t = new TelaLogin();
        t.setVisible(true);
        dispose();
        
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNomeMedico;
    private javax.swing.JLabel jLabeldATA;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTableConsultasExames;
    private javax.swing.JTable jTableHistoricoAntigo;
    private javax.swing.JTable jTableHistoricoRecente;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextArea jTextAreaDiagnostico;
    private javax.swing.JTextArea jTextAreaPrescricao;
    private javax.swing.JTextArea jTextAreaSintomas;
    private javax.swing.JTextField jTextFieldFrequencia;
    private javax.swing.JTextField jTextFieldMedicoResponsavel;
    private javax.swing.JTextField jTextFieldNomePaciente;
    private javax.swing.JTextField jTextFieldServico;
    private javax.swing.JTextField jTextFieldidMarcarExame;
    private javax.swing.JTextField jTextFieldvalidarCancelado;
    private javax.swing.JTextField validarAntigos;
    // End of variables declaration//GEN-END:variables
}
