/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auroClin.visao;

import DAO.FilaDAO;
import br.auroClin.model.BuscarFicha;
import br.auroClin.model.FilaModelo;
import br.auroClin.model.InserirNafila;
import br.auroClin.model.finalizarMarcar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Franciosney Souza
 */
public class Atendimentos extends javax.swing.JFrame {

    /**
     * Creates new form Atendimentos
     * 
     * 
     */
    
public void CorTabela(){
   
          
jTableFilaExames.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    
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
        
        Object testo = jTableFilaExames.getValueAt(row, 5);
        Object testoT = jTableFilaExames.getValueAt(row, 5);
         Object testoTTT = jTableFilaExames.getValueAt(row, 5);
         Object testoTT = jTableFilaExames.getValueAt(row, 4);
         
          
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
                 jTableFilaExames.setSelectionForeground(Color.RED);
                 
        
         return label;
    }

    
});
   
   }
    
    
     public void  ExamesDaFila(){
    
      try {
 SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
        
            FilaDAO daof = new FilaDAO();
            List<FilaModelo> listaExamesFila = daof.listarExames(dataAtual);

            DefaultTableModel modelo = (DefaultTableModel)jTableFilaExames.getModel();
            modelo.setNumRows(0);

            int i = 0;
            for(FilaModelo objp: listaExamesFila){
                modelo.addRow(new String[i]);
                jTableFilaExames.setValueAt(objp.getIdMarcar(), i, 0);
                jTableFilaExames.setValueAt(objp.getNomeConsulta(), i, 1);
                 jTableFilaExames.setValueAt(objp.getMedico(), i, 2);
                 jTableFilaExames.setValueAt(objp.getNomePaciente(), i, 3);
                 jTableFilaExames.setValueAt(String.format("Nº %-3s", objp.getNumeroFicha()), i, 4);
                 jTableFilaExames.setValueAt(objp.getSituacaoFila(), i, 5);
             
        
                
                
               

                i++;

            }
            
            jTableFilaClic.revalidate();
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }

    }
     
     
     
     
     
     public void  ExamesPorCategoriodaDia(String nomeExame,String nomeMedico){
    
      try {
 SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
        
  
        
            FilaDAO daof = new FilaDAO();
            List<FilaModelo> listaExamesFila = daof.listarExamesPorCategoriasdoDia(dataAtual, nomeExame, nomeMedico);

            DefaultTableModel modelo = (DefaultTableModel)jTableFilaExames.getModel();
            modelo.setNumRows(0);

            int i = 0;
            for(FilaModelo objp: listaExamesFila){
                modelo.addRow(new String[i]);
                jTableFilaExames.setValueAt(objp.getIdMarcar(), i, 0);
                jTableFilaExames.setValueAt(objp.getNomeConsulta(), i, 1);
                 jTableFilaExames.setValueAt(objp.getMedico(), i, 2);
                 jTableFilaExames.setValueAt(objp.getNomePaciente(), i, 3);
                 jTableFilaExames.setValueAt(String.format("Nº %-3s", objp.getNumeroFicha()), i, 4);
                 jTableFilaExames.setValueAt(objp.getSituacaoFila(), i, 5);
             
        
                
                
               

                i++;

            }
            
            jTableFilaClic.revalidate();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }

    }
     
     
     
    
    
    public void  EamesPorClic(){
    
      try {
 SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
            FilaDAO daof = new FilaDAO();
            List<FilaModelo> listaExamesFila = daof.examesParClic(dataAtual);

            DefaultTableModel modelo = (DefaultTableModel)jTableFilaClic.getModel();
            modelo.setNumRows(0);

            int i = 0;
            for(FilaModelo objp: listaExamesFila){
                modelo.addRow(new String[i]);
                jTableFilaClic.setValueAt(objp.getNomeConsulta(), i, 0);
               jTableFilaClic.setValueAt(objp.getMedico(), i, 1);
               
                
                
               

                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }

    }
    
    
    
    public void  ExamesMarcadosParaODia(){
    
      try {
 SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
            FilaDAO daof = new FilaDAO();
            List<FilaModelo> listaExamesFila = daof.listarExamesMArcados(dataAtual);

            DefaultTableModel modelo = (DefaultTableModel) jTableExamesMarcados.getModel();
            modelo.setNumRows(0);

            int i = 0;
            for(FilaModelo objp: listaExamesFila){
                modelo.addRow(new String[i]);
                
           
                      jTableExamesMarcados.setValueAt(objp.getIdMarcar(), i, 0);
                jTableExamesMarcados.setValueAt(objp.getNomePaciente(), i, 1);
                 jTableExamesMarcados.setValueAt(objp.getNomeConsulta(), i, 2);
                 jTableExamesMarcados.setValueAt(objp.getMedico(), i, 3);
                  jTableExamesMarcados.setValueAt(objp.getSituacaoFila(), i, 4);
                   jTableExamesMarcados.setValueAt(objp.getRetorno(), i, 5);
           
              
           
                
               

                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }

    }
    
    
    
    
     public void  ExamesMarcadosPorNome(){
    
      try {
 SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
            FilaDAO daof = new FilaDAO();
            
            String nomePaciente = jTextFieldNomePaciente.getText();
            String nomeExame = jTextFieldTipoExame.getText();
            String nomeMedico = jTextFielNomeMedico.getText();
            
            
            List<FilaModelo> listaExamesFila = daof.listarExamesMArcadosNome(nomePaciente, nomeExame, nomeMedico, dataAtual);

            DefaultTableModel modelo = (DefaultTableModel) jTableExamesMarcados.getModel();
            modelo.setNumRows(0);

            int i = 0;
            for(FilaModelo objp: listaExamesFila){
                modelo.addRow(new String[i]);
                
           
                      jTableExamesMarcados.setValueAt(objp.getIdMarcar(), i, 0);
                jTableExamesMarcados.setValueAt(objp.getNomePaciente(), i, 1);
                 jTableExamesMarcados.setValueAt(objp.getNomeConsulta(), i, 2);
                 jTableExamesMarcados.setValueAt(objp.getMedico(), i, 3);
                  jTableExamesMarcados.setValueAt(objp.getSituacaoFila(), i, 4);
                  jTableExamesMarcados.setValueAt(objp.getRetorno(), i, 5);
           
              
           
                
               

                i++;

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Erro"+e);
        }

    }
     
     
     public void colocarNaFila(){

              
         SimpleDateFormat forData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dataAtual = forData.format(cal.getTime());
        cal.getTime();
        
   
     FilaDAO f = new FilaDAO();
     
     String exame = jTextFieldExameNome.getText();
     String nomeMedico = jTextFieldMedicoNome.getText();
                    
         if (f.validareExameOuConsulta(exame)) {
             
                 
                  List<BuscarFicha> lista = f.examesParFicha(dataAtual, exame, nomeMedico);
             int fichasExistentes = 0;
             for (BuscarFicha ex : lista) {
                 fichasExistentes = fichasExistentes + 1;
             }
             fichasExistentes = fichasExistentes + 1;

             //JOptionPane.showMessageDialog(rootPane, fichasExistentes);
             InserirNafila fila = new InserirNafila();
             fila.setFicha(String.valueOf(fichasExistentes));
             fila.setId_exame(Integer.parseInt(jTextFieldIdFila.getText()));
             f.inserirnaFila(fila);
             finalizarMarcar fmarcar = new finalizarMarcar();
             String situacao = "NA FILA";
             fmarcar.setIdMarcar(Integer.parseInt(jTextFieldIdFila.getText()));
             fmarcar.setSituacaoFila(situacao);
             f.atualizarSituacaoNaFila(fmarcar);

             JOptionPane.showMessageDialog(rootPane, "Paciente na Fila!");
             jTextFieldIdFila.setText("");
             jTextFieldNomeFila.setText("");

             
         } else{
         
          
          
             List<BuscarFicha> lista = f.ConsultasParFicha(dataAtual, exame, nomeMedico);
             int fichasExistentes = 0;
             for (BuscarFicha ex : lista) {
                 fichasExistentes = fichasExistentes + 1;
             }
             fichasExistentes = fichasExistentes + 1;

             //JOptionPane.showMessageDialog(rootPane, fichasExistentes);
             InserirNafila fila = new InserirNafila();
             fila.setFicha(String.valueOf(fichasExistentes));
             fila.setId_exame(Integer.parseInt(jTextFieldIdFila.getText()));
             f.inserirnaFila(fila);
             finalizarMarcar fmarcar = new finalizarMarcar();
             String situacao = "NA FILA";
             fmarcar.setIdMarcar(Integer.parseInt(jTextFieldIdFila.getText()));
             fmarcar.setSituacaoFila(situacao);
             f.atualizarSituacaoNaFila(fmarcar);

             JOptionPane.showMessageDialog(rootPane, "Paciente na Fila!");

         }
     
     

      
         
     
     }
    
    
    
    public Atendimentos() {
        initComponents();
        
 
DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
headerRenderer.setBackground(Color.YELLOW);

for (int i = 0; i < jTableFilaClic.getModel().getColumnCount(); i++) {
    jTableFilaClic.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
}
jTableFilaClic.getParent().setBackground(Color.WHITE);
    
       JTableHeader headerClic = jTableFilaClic.getTableHeader();   
    headerClic.setPreferredSize(new Dimension(0, 25)); 
    headerClic.setFont(new Font("��������", Font.PLAIN, 14));
	headerClic.setPreferredSize(new Dimension(headerClic.getWidth(),25));  
      jTableFilaClic.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableFilaClic.getColumnModel().getColumn(0).setPreferredWidth(165);
jTableFilaClic.getColumnModel().getColumn(1).setPreferredWidth(260);

jTableFilaClic.setRowHeight(23); 



        
       JTableHeader headerExames = jTableExamesMarcados.getTableHeader();   
    headerExames.setPreferredSize(new Dimension(0, 25)); 
    headerExames.setFont(new Font("��������", Font.PLAIN, 14));
	headerExames.setPreferredSize(new Dimension(headerExames.getWidth(),25));  
       jTableExamesMarcados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableExamesMarcados.getColumnModel().getColumn(0).setPreferredWidth(70);
jTableExamesMarcados.getColumnModel().getColumn(1).setPreferredWidth(312);
jTableExamesMarcados.getColumnModel().getColumn(2).setPreferredWidth(210);
jTableExamesMarcados.getColumnModel().getColumn(3).setPreferredWidth(210);
jTableExamesMarcados.getColumnModel().getColumn(4).setPreferredWidth(80);
jTableExamesMarcados.getColumnModel().getColumn(5).setPreferredWidth(100);
jTableExamesMarcados.setRowHeight(23); 
        
        




jTableFilaExames.getParent().setBackground(Color.WHITE);

  JTableHeader headerPaciente = jTableFilaExames.getTableHeader();   
    headerPaciente.setPreferredSize(new Dimension(0, 25)); 
    headerPaciente.setFont(new Font("��������", Font.PLAIN, 14));
	headerPaciente.setPreferredSize(new Dimension(headerPaciente.getWidth(),25));
 jTableFilaExames.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableFilaExames.getColumnModel().getColumn(0).setPreferredWidth(60);
jTableFilaExames.getColumnModel().getColumn(1).setPreferredWidth(170);
jTableFilaExames.getColumnModel().getColumn(2).setPreferredWidth(212);
jTableFilaExames.getColumnModel().getColumn(3).setPreferredWidth(200);
jTableFilaExames.getColumnModel().getColumn(4).setPreferredWidth(100);
jTableFilaExames.getColumnModel().getColumn(5).setPreferredWidth(110);
jTableFilaExames.setRowHeight(23); 


jTextFieldFinalizarExame.setEditable(false);
      jTextFieldNomeFinalizarExame.setEditable(false);
      jTextFieldExameNome.setEditable(false);
              jTextFieldMedicoNome.setEditable(false);
              jTextFieldIdFila.setEditable(false);
                      jTextFieldNomeFila.setEditable(false);

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
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNomePaciente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTipoExame = new javax.swing.JTextField();
        jTextFielNomeMedico = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldIdFila = new javax.swing.JTextField();
        jTextFieldNomeFila = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonFechar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableExamesMarcados = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFilaExames = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFilaClic = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldFinalizarExame = new javax.swing.JTextField();
        jTextFieldNomeFinalizarExame = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jTextFieldExameNome = new javax.swing.JTextField();
        jTextFieldMedicoNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1300, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Buscar Paciente");

        jTextFieldNomePaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomePacienteKeyPressed(evt);
            }
        });

        jLabel5.setText("Buscar Medico");

        jTextFieldTipoExame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTipoExameKeyPressed(evt);
            }
        });

        jTextFielNomeMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFielNomeMedicoKeyPressed(evt);
            }
        });

        jLabel6.setText("Buscar Consulta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFielNomeMedico))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldTipoExame))))
                .addGap(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jTextFieldTipoExame))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFielNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Colocar Paciente na Fila");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Inserir na Fila");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldIdFila, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeFila, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldIdFila)
                    .addComponent(jTextFieldNomeFila, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/Minimizar (2).png"))); // NOI18N
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jTableExamesMarcados.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTableExamesMarcados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Paciente", "Consulta", "Medico", "S. Fila", "Realização"
            }
        ));
        jTableExamesMarcados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableExamesMarcadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableExamesMarcados);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableFilaExames.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTableFilaExames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Exame", "Médico", "Papciente", "Nº Ficha", "Situacao"
            }
        ));
        jTableFilaExames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFilaExamesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFilaExames);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("     FILAS PARA REALIZAR EXAMES/CONSULTAS");
        jLabel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableFilaClic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableFilaClic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Consulta", "Médico"
            }
        ));
        jTableFilaClic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFilaClicMouseClicked(evt);
            }
        });
        jTableFilaClic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableFilaClicKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTableFilaClic);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("   FILA POR EXAMES/CONSULTAS");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("        EXAMES E CONSULTAS PARA HOJE");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextFieldFinalizarExame.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldNomeFinalizarExame.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setText("ID");

        jLabel9.setText("Paciente Selecionado");

        jButton10.setBackground(new java.awt.Color(255, 51, 51));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton10.setText("Cancelar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 255, 153));
        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setText("Atender");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(204, 204, 204));
        jButton12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton12.setText("Finalizar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 102, 255));
        jButton13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton13.setText("Prioridade");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(231, 231, 231))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextFieldFinalizarExame, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldNomeFinalizarExame))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel7)
                                        .addGap(139, 139, 139)
                                        .addComponent(jLabel9)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldFinalizarExame, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jTextFieldNomeFinalizarExame))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 1330, 700);
        getContentPane().add(jTextFieldExameNome);
        jTextFieldExameNome.setBounds(269, 10, 180, 40);
        getContentPane().add(jTextFieldMedicoNome);
        jTextFieldMedicoNome.setBounds(480, 10, 210, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/auroClin/imagens/FundoPrincipal.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1350, 720);

        setSize(new java.awt.Dimension(1350, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    
           
        if (jTextFieldIdFila.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um paciente para colocar na Fila!");
            
        } else{
        

       int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Colocar Paciente Fila? ", "Title on Box", dialogButton);
            if(dialogResult == 0) {
            
                
                
                
                
                colocarNaFila();
                
                

            
            } else{

                    JOptionPane.showMessageDialog(rootPane, "Paciente Não esta  Fila!");
                    
                    }
     
            
            
            
        
        }
        
        
       
     
     
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
          ExamesMarcadosParaODia();
          ExamesDaFila();
            EamesPorClic();
            CorTabela();
    }//GEN-LAST:event_formWindowActivated

    private void jTextFieldNomePacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomePacienteKeyPressed
        // TODO add your handling code here:
  ExamesMarcadosPorNome();
         
    }//GEN-LAST:event_jTextFieldNomePacienteKeyPressed

    private void jTextFieldTipoExameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTipoExameKeyPressed
        // TODO add your handling code here:
        
          ExamesMarcadosPorNome();

    }//GEN-LAST:event_jTextFieldTipoExameKeyPressed

    private void jTextFielNomeMedicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielNomeMedicoKeyPressed
        // TODO add your handling code here:
          ExamesMarcadosPorNome();
        
    }//GEN-LAST:event_jTextFielNomeMedicoKeyPressed

    private void jTableExamesMarcadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableExamesMarcadosMouseClicked
        // TODO add your handling code here:
        
        
          //---- Controlando Clique na tabela
        
jTableExamesMarcados.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel  
jTableExamesMarcados.addMouseListener(new MouseAdapter() {  
    public void mouseClicked(MouseEvent e)  
    {  
        if (e.getClickCount() == 2)  
        {  

           //JOptionPane.showMessageDialog(null, "Você não Pode Editar! Não Insista");
        }  
    }  
});  
      // ---------- Fim
      
        jTextFieldIdFila.setText(jTableExamesMarcados.getValueAt(jTableExamesMarcados.getSelectedRow(), 0).toString());
         jTextFieldNomeFila.setText(jTableExamesMarcados.getValueAt(jTableExamesMarcados.getSelectedRow(), 1).toString());
       jTextFieldExameNome.setText(jTableExamesMarcados.getValueAt(jTableExamesMarcados.getSelectedRow(), 2).toString());
  jTextFieldMedicoNome.setText(jTableExamesMarcados.getValueAt(jTableExamesMarcados.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_jTableExamesMarcadosMouseClicked

    private void jTableFilaExamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFilaExamesMouseClicked
        // TODO add your handling code here:
                
jTableFilaExames.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel  
jTableFilaExames.addMouseListener(new MouseAdapter() {  
    public void mouseClicked(MouseEvent e)  
    {  
        if (e.getClickCount() == 2)  
        {  

           //JOptionPane.showMessageDialog(null, "Você não Pode Editar! Não Insista");
        }  
    }  
});  
      // ---------- Fim
      
        jTextFieldFinalizarExame.setText(jTableFilaExames.getValueAt(jTableFilaExames.getSelectedRow(), 0).toString());
         jTextFieldNomeFinalizarExame.setText(jTableFilaExames.getValueAt(jTableFilaExames.getSelectedRow(), 3).toString());
     
    }//GEN-LAST:event_jTableFilaExamesMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
        
           if (jTextFieldFinalizarExame.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um paciente na fila");
            
        }else{
           
            
         FilaDAO daofila = new FilaDAO();
         String situacao = "FINALIZADO";
         String situacaoFinal = "CANCELADO";
        
         int idMarcar = Integer.parseInt(jTextFieldFinalizarExame.getText());
        
        if (daofila.validarFila(idMarcar,situacao)) {
            
     JOptionPane.showMessageDialog(rootPane, "Este Exame ja foi finalizado, você não pode cancelar!");
     
     jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
        
    
            
        } else if(daofila.validarFila(idMarcar,situacaoFinal)){
        
        
             JOptionPane.showMessageDialog(rootPane, "Este Exame ja foi cancelado!");
     
     jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
        
        
        
        } else{
        
        
             int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Cancelar Exame ? ", "Title on Box", dialogButton);
            if(dialogResult == 0) {
            
                  finalizarMarcar fm = new finalizarMarcar();
        
        fm.setIdMarcar(idMarcar);
        fm.setSituacaoFila(situacaoFinal);
        daofila.atualizarSituacaoNaFila(fm);
        
        
        JOptionPane.showMessageDialog(rootPane, "O exame foi Cancelado!");
        
        jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
            
            
            }

            
        
        }
        
           
           }
        
        
        
        
       
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        
     
        
        
        if (jTextFieldFinalizarExame.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um paciente na fila");
            
        } else{
        
        
          FilaDAO daofila = new FilaDAO();
         String situacao = "ATENDIMENTO";
         String situacaoA = "FINALIZADO";
         int idMarcar = Integer.parseInt(jTextFieldFinalizarExame.getText());
        
        if (daofila.validarFila(idMarcar,situacao)) {
            
     JOptionPane.showMessageDialog(rootPane, "Este paciente esta em atendimento!");
     
     jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
        
    
            
        } else if(daofila.validarFila(idMarcar,situacaoA)){
        
        JOptionPane.showMessageDialog(rootPane, "Este paciente ja foi atendido");
        
         jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
        
        } else {
        
              int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Colocar Paciente em Atendimento? ", "Title on Box", dialogButton);
            if(dialogResult == 0) {
            
                  finalizarMarcar fm = new finalizarMarcar();
        
        fm.setIdMarcar(idMarcar);
        fm.setSituacaoFila(situacao);
        daofila.atualizarSituacaoNaFila(fm);

        JOptionPane.showMessageDialog(rootPane, "O paciente foi colocado para atendimento!");
        
  //TelaPrincipalMedico t = new TelaPrincipalMedico();
  //t.Atendimentos();
        
        jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
            
            
            }
            
                jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
 
        }
        
        
        
        }
        

        
   
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        
       
           if (jTextFieldFinalizarExame.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um paciente na fila");
            
        }else{
           
           
            FilaDAO daofila = new FilaDAO();
         String situacao = "FINALIZADO";
         String situacaoF = "NA FILA"; 
         String situacaoFF = "CANCELADO"; 
         int idMarcar = Integer.parseInt(jTextFieldFinalizarExame.getText());
        
        if (daofila.validarFila(idMarcar,situacao)) {
            
     JOptionPane.showMessageDialog(rootPane, "Este Exame ja foi finalizado!");
     
     jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
        
    
            
        } else if(daofila.validarFila(idMarcar,situacaoF)){
        
        JOptionPane.showMessageDialog(rootPane, "Paciente na fila, você não pode finalizar este Exame!");
         jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
        
        
        }else if(daofila.validarFila(idMarcar,situacaoFF)){
        
        JOptionPane.showMessageDialog(rootPane, "Não pode finalizar um exame CANCELADO!");
         jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
        
        
        } 
        else{
        
              int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Finalizar Atendimento? ", "Title on Box", dialogButton);
            if(dialogResult == 0) {
            
                  finalizarMarcar fm = new finalizarMarcar();
        
        fm.setIdMarcar(idMarcar);
        fm.setSituacaoFila(situacao);
        daofila.atualizarSituacaoNaFila(fm);
        
        
        
        JOptionPane.showMessageDialog(rootPane, "O atendimento foi finalizado!");
        
        jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
            
            
            }
            
                jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
 
        }
        
           
           
           
           }
        
        
         
     
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        
        
           if (jTextFieldFinalizarExame.getText().equals("")) {
            
            JOptionPane.showMessageDialog(rootPane, "Selecione um paciente na fila");
            
        }else{
           
             int idMarcar = Integer.parseInt(jTextFieldFinalizarExame.getText());

        FilaDAO daof = new FilaDAO();

       List<FilaModelo> lista =  daof.buscarIdFila(idMarcar);

             int idFila = 0;
             String prioridadeAtual = null;

                for (FilaModelo ex : lista) {

                    idFila = ex.getIdFila();
                    prioridadeAtual = ex.getPrioridade();
             

                }
                System.out.println("Tem "+prioridadeAtual);
                
                if (prioridadeAtual.equals("Prioridade")) {
                    
                    JOptionPane.showMessageDialog(rootPane, "Este paciente ja tem prioridade");
                     jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");
            
        } else{
                
                
                    
         int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Paciente com prioridade? ", "Title on Box", dialogButton);
            if(dialogResult == 0) {
            
        
                
                String prioridade = "Prioridade";
              
                daof.atualizarProridadeFila(idFila, prioridade);
        
                
            
            }
                    
               jTextFieldFinalizarExame.setText("");
      jTextFieldNomeFinalizarExame.setText("");  
                }
        
        
        
       
        
           
           
           
           }
                 
      
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTableFilaClicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableFilaClicKeyPressed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_jTableFilaClicKeyPressed

    private void jTableFilaClicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFilaClicMouseClicked
        // TODO add your handling code here:
        
           
          //---- Controlando Clique na tabela
        
jTableFilaClic.setDefaultEditor(Object.class, null);  // ou usar um TableModel nao  editavel  
jTableFilaClic.addMouseListener(new MouseAdapter() {  
    public void mouseClicked(MouseEvent e)  
    {  
        if (e.getClickCount() == 2)  
        {  

           //JOptionPane.showMessageDialog(null, "Você não Pode Editar! Não Insista");
        }  
    }  
});  
      // ---------- Fim
      
        String nomeExame = jTableFilaClic.getValueAt(jTableFilaClic.getSelectedRow(), 0).toString();
         String nomeMedico = jTableFilaClic.getValueAt(jTableFilaClic.getSelectedRow(), 1).toString();

         ExamesPorCategoriodaDia(nomeExame, nomeMedico);
     
        
    }//GEN-LAST:event_jTableFilaClicMouseClicked

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
            java.util.logging.Logger.getLogger(Atendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Atendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Atendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Atendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Atendimentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableExamesMarcados;
    private javax.swing.JTable jTableFilaClic;
    private javax.swing.JTable jTableFilaExames;
    private javax.swing.JTextField jTextFielNomeMedico;
    private javax.swing.JTextField jTextFieldExameNome;
    private javax.swing.JTextField jTextFieldFinalizarExame;
    private javax.swing.JTextField jTextFieldIdFila;
    private javax.swing.JTextField jTextFieldMedicoNome;
    private javax.swing.JTextField jTextFieldNomeFila;
    private javax.swing.JTextField jTextFieldNomeFinalizarExame;
    private javax.swing.JTextField jTextFieldNomePaciente;
    private javax.swing.JTextField jTextFieldTipoExame;
    // End of variables declaration//GEN-END:variables
}
