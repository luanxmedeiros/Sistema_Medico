
package simescalonamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class SchedSimUI extends javax.swing.JFrame {
    private final static String ARQUIVO = "processos.txt";
    private final static Charset ENCODING = StandardCharsets.UTF_8;
    private final static int DELAY = 1000;
    private int quantum = 2;
    private ArrayList<Processo> filaPronto, filaTerminado;
    Timer schedulerTimer;
    Timer timer;
    private int tempoTotal = 0;
    int processoAtualInt = 0;
    private boolean removido = false;

    
    
    public void validaTerminoProcesso(Processo processoAtual)
        {
                 removido = true;
                 filaTerminado.add(processoAtual);
                 filaPronto.remove(processoAtual);              
                 if(processoAtualInt > filaPronto.size()-1 && !filaPronto.isEmpty()) processoAtualInt = 0;
        }
                
    public void atualizaTurnaroundRoundRobin()
    {
        for(int i = 0; i < filaPronto.size(); i++)
        {
            if(filaPronto.get(i).getTempoRestante() > 0) filaPronto.get(i).incTurnaroundRR();
        }
        
    }
    private void atualizaTempoEspera(Processo processoAtualizado)
    {
        for(Processo processo : filaPronto)
        {
           if(!processo.equals(processoAtualizado))               
               processo.incTempoEspera();
        }        
    }     

    public SchedSimUI() {
        filaPronto = new ArrayList<>();
        filaTerminado = new ArrayList<>();
        schedulerTimer = new Timer(DELAY, atualizaCPU);
        timer = new Timer(DELAY, atualizaCPURR);
        initComponents();
    }

    private final ActionListener atualizaCPU = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            Processo processoAtual;            
            if (!filaPronto.isEmpty()){
                tempoTotal++;
                processoAtual = filaPronto.get(0);
                if(processoAtual.getTempoRestante() > 0){
                    jLabelCPU.setText(processoAtual.getNome());
                    processoAtual.decTempoRestante();
                    
                    //atualizar os tempos de espera dos outros processos
                    Processo umProcesso;
                    Iterator itr = filaPronto.iterator();
                    //pular o processo em execução no momento
                    itr.next();
                    while (itr.hasNext()){
                        umProcesso = ((Processo) itr.next());
                        umProcesso.incTempoEspera();
                    }
                    
                }else{
                    //se o processo não precisa mais executar tempoRestante == 0
                    filaTerminado.add(filaPronto.get(0));
                    filaPronto.remove(0);
                }                
                jTxtAreaFilaPronto.setText(filaPronto.toString());
                jLabelTempoAtual.setText("Tempo AtuaL: "+Integer.toString(tempoTotal));
            }else{
                JOptionPane.showMessageDialog(null, "Fila de prontos vazia");
                jTxtAreaFilaPronto.setText("Execução Terminada. ");
                jTxtAreaFilaPronto.append(filaTerminado.toString());
                schedulerTimer.stop();                
                jButtonExec.setEnabled(true);
            }            
        }
    };
    
        private final ActionListener atualizaCPURR = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
           

       
        Processo processoAtual;
        if(!filaPronto.isEmpty())
        {                  
                removido = false;
                processoAtual = filaPronto.get(processoAtualInt);
                if(processoAtual.getTempoRestante() > 0 && processoAtual.getTempoRestante() >= quantum)
                {            
                    for(int i = 0; i < quantum; i++)
                    {
                        tempoTotal++;
                        jLabelCPU.setText(processoAtual.getNome());
                        atualizaTurnaroundRoundRobin();
                        processoAtual.decTempoRestanteRR();                        
                        atualizaTempoEspera(processoAtual);
                        
                        if(processoAtual.getTempoRestante() == 0)
                        {
                            validaTerminoProcesso(processoAtual);
                        }

                        jTxtAreaFilaPronto.setText(filaPronto.toString());
                        jLabelTempoAtual.setText("Tempo AtuaL: "+tempoTotal);                        

                    }
                    
                        if(processoAtualInt == filaPronto.size()-1 && !filaPronto.isEmpty() && removido == false)
                        {
                            processoAtualInt = 0;
                        }
                        else if(processoAtualInt < filaPronto.size()-1 &&!filaPronto.isEmpty() && removido == false)
                        {
                            processoAtualInt++;
                        }                     
                }
                else if(processoAtual.getTempoRestante() > 0)
                {   
                    int temp = processoAtual.getTempoRestante();                 
                    for(int i = 0; i < temp; i++)
                    {
                        tempoTotal++;                        
                        jLabelCPU.setText(processoAtual.getNome());
                        atualizaTurnaroundRoundRobin();
                        processoAtual.decTempoRestanteRR();                        
                        atualizaTempoEspera(processoAtual);

                        if(processoAtual.getTempoRestante() == 0)
                        {
                            validaTerminoProcesso(processoAtual);
                        }
                        jTxtAreaFilaPronto.setText(filaPronto.toString());
                        jLabelTempoAtual.setText("Tempo AtuaL: "+tempoTotal); 
                              
                    }                    
                    if(processoAtualInt == filaPronto.size()-1 && !filaPronto.isEmpty() && removido == false)
                    {
                        processoAtualInt = 0;
                    }
                    else if(processoAtualInt < filaPronto.size()-1 &&!filaPronto.isEmpty() && removido == false)
                    {
                        processoAtualInt++;
                    }                    
                }                          
                else
               {
                   validaTerminoProcesso(processoAtual);

               }
               
        }
        else{
                JOptionPane.showMessageDialog(null, "Fila de prontos vazia");
                jTxtAreaFilaPronto.setText("Execução Terminada. \n");
                jTxtAreaFilaPronto.append(filaTerminado.toString());
                timer.stop();                
                jButtonExec.setEnabled(true);              
        }
                 
        }
    };
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButFIFO = new javax.swing.JRadioButton();
        jRadioButSJF = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtAreaFilaPronto = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabelCPU = new javax.swing.JLabel();
        jLabelTempoAtual = new javax.swing.JLabel();
        jButtonCarregar = new javax.swing.JButton();
        jButtonExec = new javax.swing.JButton();
        RR = new javax.swing.JRadioButton();
        tempoquantum = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(jRadioButFIFO);
        jRadioButFIFO.setSelected(true);
        jRadioButFIFO.setText("FIFO");

        buttonGroup1.add(jRadioButSJF);
        jRadioButSJF.setText("SJF");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Fila de Pronto");

        jTxtAreaFilaPronto.setColumns(20);
        jTxtAreaFilaPronto.setRows(5);
        jTxtAreaFilaPronto.setEnabled(false);
        jScrollPane1.setViewportView(jTxtAreaFilaPronto);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("CPU");

        jLabelCPU.setForeground(new java.awt.Color(255, 0, 0));
        jLabelCPU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCPU.setText("-IDLE-");
        jLabelCPU.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 51), 1, true));
        jLabelCPU.setName("jLabelCPU"); // NOI18N

        jLabelTempoAtual.setText("Tempo Atual:");

        jButtonCarregar.setText("Carregar Processos");
        jButtonCarregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCarregarMouseClicked(evt);
            }
        });

        jButtonExec.setText("Executar");
        jButtonExec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonExecMouseClicked(evt);
            }
        });
        jButtonExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExecActionPerformed(evt);
            }
        });

        buttonGroup1.add(RR);
        RR.setText("RR");
        RR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RRActionPerformed(evt);
            }
        });

        tempoquantum.setMajorTickSpacing(1);
        tempoquantum.setMaximum(10);
        tempoquantum.setMinimum(1);
        tempoquantum.setPaintLabels(true);
        tempoquantum.setPaintTicks(true);
        tempoquantum.setSnapToTicks(true);
        tempoquantum.setValue(2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(RR)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tempoquantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jRadioButSJF)
                                    .addComponent(jRadioButFIFO)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTempoAtual)
                                .addGap(58, 58, 58))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabelCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(56, 56, 56)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCarregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExec)
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jRadioButFIFO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButSJF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RR)
                            .addComponent(tempoquantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTempoAtual)
                        .addGap(0, 146, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExec)
                    .addComponent(jButtonCarregar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCarregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCarregarMouseClicked
        File diretorioAtual = new File (".");
        File diretorioPai = new File ("..");        
        String diretorioString = System.getProperty("user.dir");
        diretorioString = diretorioString.replace("\\", "/");
        diretorioString += "/src/simescalonamento/";
        
        Path path = Paths.get(diretorioString+ARQUIVO);
        //carrega o conteudo de ARQUIVO em um ArrayList
        List <String> texto = new ArrayList<>();
        try {
            texto = Files.readAllLines(path, ENCODING);
        } catch (IOException ex) {
            Logger.getLogger(SchedSimUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Limpar as filas para uma nova execução
        filaPronto.clear();
        filaTerminado.clear();
        tempoTotal = 0;
        
        //Cria os objetos processo e adiciona em filaPronto
        Iterator itr = texto.iterator();
        int tempo, cont = 0;
        String nomeProcesso;        
        while(itr.hasNext()){         
            tempo = Integer.parseInt(itr.next().toString());
            //o nome do processo é uma letra de A a Z
            nomeProcesso = Character.toString((char)(65+cont));
            filaPronto.add(new Processo(tempo,nomeProcesso));
            cont++;
        }
        

        jTxtAreaFilaPronto.setText(filaPronto.toString());
    }//GEN-LAST:event_jButtonCarregarMouseClicked

    private void jButtonExecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExecMouseClicked
        if (buttonGroup1.getSelection().equals(jRadioButSJF.getModel())){  
            //ordenar a fila de prontos
            Collections.sort(filaPronto, new Comparator<Processo>(){
                @Override
                public int compare(Processo p1, Processo p2){
                    //compara dois processos de acordo com o tempo total 
                    //necessario para executar
                    if (p1.getTempoNecessario() == p2.getTempoNecessario())
                        return 0;
                    else 
                        if (p1.getTempoNecessario() > p2.getTempoNecessario())
                            return 1;
                        else
                            return -1;
                }
            }
            );
            jTxtAreaFilaPronto.setText(filaPronto.toString());
            tempoTotal = 0;
            schedulerTimer.start();        
            jButtonExec.setEnabled(false);
        }
            else if(RR.isSelected())
            {
            quantum = tempoquantum.getValue();
            jTxtAreaFilaPronto.setText(filaPronto.toString());
            tempoTotal = 0;
            timer.start();
            jButtonExec.setEnabled(false);
            }

        else
        {
            tempoTotal = 0;
            schedulerTimer.start();
            jButtonExec.setEnabled(false);
        }
        
        
        
       
    }//GEN-LAST:event_jButtonExecMouseClicked

    private void jButtonExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExecActionPerformed

    private void RRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RRActionPerformed

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
            java.util.logging.Logger.getLogger(SchedSimUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchedSimUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchedSimUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchedSimUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SchedSimUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RR;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCarregar;
    private javax.swing.JButton jButtonExec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCPU;
    private javax.swing.JLabel jLabelTempoAtual;
    private javax.swing.JRadioButton jRadioButFIFO;
    private javax.swing.JRadioButton jRadioButSJF;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTxtAreaFilaPronto;
    private javax.swing.JSlider tempoquantum;
    // End of variables declaration//GEN-END:variables
}
