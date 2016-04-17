package gerenciadordememoria;    
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


//
/**
 *
 * @author Luan Medeiros
 */
public class Gerenciador extends javax.swing.JFrame {
    private ArrayList<Processo> memoriaArray = new ArrayList<>();
    private ArrayList<Processo> hdArray = new ArrayList<>();
    private ArrayList<Processo> backupProcessos = new ArrayList<>();
    private int memoriaMaxima = 50;
    private int hdMaximo = 250;    
    private final static Charset ENCODING = StandardCharsets.UTF_8; 
    private Processo processoAtualObjeto = new Processo();    
    int tamanhoVetorProcessos = 0;
    private MelhorPosicao melhorFinal = null;
    
    
    //Recebe um endereço de memória e verifica se existe algum processos fazendo uso desse endereço.
    public boolean ocupado (int pos)
    {
        for(Processo proc : memoriaArray)
        {
            //Caso o endereço esteja entre a base e o limite do processo, ele retorna true.
            if(proc.getBase() <= pos && proc.getLimite() >= pos) return true;
        }
        return false;
    }
    
    /* Método que busca se há algum espaço disponível para encaixe do processo 
      que vem do HD e se hover, dá preferencia ao melhor espaço. Evitando desperdício de memória.
    */
    public boolean melhorTrocaPossivel()
    {
        MelhorPosicao melhor = null;
        melhorFinal = null;
        for(int y = 0; y < memoriaMaxima; y++)
        {
            if(ocupado(y) == false)
            {                
                if(melhor == null) melhor = new MelhorPosicao(y);
                else melhor.incrimentaLimite();
                melhor.incrimentaTamanho();
                if(y == memoriaMaxima-1)
                {                    
                    if(melhorFinal == null && melhor != null) 
                    {
                        if(melhor.getTamanho() == processoAtualObjeto.getTamanho())
                        {
                            melhorFinal = melhor;                            
                            return true;
                        }                                                
                        if(melhor.getTamanho() > processoAtualObjeto.getTamanho()) melhorFinal = melhor;
                    }
                    else if(melhorFinal != null && melhor != null)
                    {
                        if(melhor.getTamanho() == processoAtualObjeto.getTamanho())
                        {
                            melhorFinal = melhor;
                            return true;
                        }                                                
                        if(melhor.getTamanho() > processoAtualObjeto.getTamanho() && melhor.getTamanho() < melhorFinal.getTamanho())
                            melhorFinal = melhor;
                    }                    
                    break;
                }
            }
            else
            {
                if(melhorFinal == null && melhor != null) 
                {
                    if(melhor.getTamanho() == processoAtualObjeto.getTamanho())
                    {
                        melhorFinal = melhor;
                        return true;
                    }
                    else if(melhor.getTamanho() > processoAtualObjeto.getTamanho()) melhorFinal = melhor;
                }
                else if(melhorFinal != null && melhor != null)
                {
                    if(melhor.getTamanho() == processoAtualObjeto.getTamanho())
                    {
                        melhorFinal = melhor;
                        return true;
                    }                    
                    else if(melhor.getTamanho() > processoAtualObjeto.getTamanho() && melhor.getTamanho() < melhorFinal.getTamanho())
                        melhorFinal = melhor;
                }
                melhor = null;
            }
        }
        if(melhorFinal != null) return true;
        else return false;        
    }
    
    //Método que apaga o conteúdos de todas as linhas das duas tabelas.
    public void limpaTabelas()
    {
        for (int i = 0; i < memoriaMaxima; i++) {
            tabelaMemoria.setValueAt("", i, 1);
        }
        for (int h = 0; h < hdMaximo; h++) {
            tabelaHD.setValueAt("", h, 1);
        }
    }

    /*Reinsere nas tabelas as informações gravadas pelos processos, sendo usado quando
    ouver um desfragementação da swap, swap-in ou swap-ou*/
    public void atualizaTabelas()
    {
        limpaTabelas();//Chama esse método para apagar todos os valores das duas tabelas
        for(Processo procHD : hdArray)
        {
            procHD.realocaEspacoMemoria(tabelaHD);
        }
        for(Processo procMemoria : memoriaArray)
        {
            procMemoria.realocaEspacoMemoria(tabelaMemoria);
        }
    }
    
    //Realoca os professos para um estado funcional usando o array backupprocesos.
    public void restauraBackup()
    {           
        memoriaArray.clear();
        hdArray.clear();
        for(Processo processo : backupProcessos)
        {   
            if(processo.getLocal().equals("MEMORIA"))            
            {   
                memoriaArray.add(processo.clone());                
            }
            else if(processo.getLocal().equals("HD"))
            {                
                hdArray.add(processo.clone());                            
            }
        }
        atualizaTabelas();
    }
    
    /* 
        Método que guarda todos os processos de hdArray e memoriaArray no arrayList backuprocessos.
        Caso ocorra alguma troca indevida, é possível restaurar as posições corretas usando o método
        restauraBackup.
    */
    public void fazBackup()
    {
        backupProcessos.clear();
        for(Processo procMemoria : memoriaArray) backupProcessos.add(procMemoria.clone());
        for(Processo procHD : hdArray) backupProcessos.add(procHD.clone());            
    }
    
    //Método que realoca os processos do HD, eliminando os espaços vazios entre eles.
    public void desfragmentaMemoriaSwap()
    {   if(!hdArray.isEmpty())
        {   
            hdArray.get(0).setBase(0);
            hdArray.get(0).setLimite(hdArray.get(0).getTamanho()-1);            
            if(hdArray.size() > 1)
            {
                for(int y = 1; y < hdArray.size(); y++)
                {
                    int b = y-1;
                    hdArray.get(y).setBase(hdArray.get(b).getLimite()+1);
                    hdArray.get(y).setLimite(hdArray.get(b).getLimite()+hdArray.get(y).getTamanho());                                                          
                }
            }
            atualizaTabelas();
        }        
    }
    
    //Método que tira o processo da memória e traz para a hd
    public boolean swapOut(int memoria)
    {        
        Processo processoOut = null;
        for(Processo procSaida : memoriaArray)
        {
            if(procSaida.getBase() <= memoria && procSaida.getLimite() >= memoria)
            {   
                procSaida.setLocal("HD");
                procSaida.setBase(hdArray.get(hdArray.size()-1).getLimite()+1);
                procSaida.setLimite(hdArray.get(hdArray.size()-1).getLimite()+procSaida.getTamanho());               
                if(procSaida.getLimite() > hdMaximo-1) return false;
                else
                {
                    processoOut = procSaida;
                    hdArray.add(procSaida);                    
                }
                break;
            }
        }              
        if(processoOut != null)memoriaArray.remove(processoOut);       
        return true;
    }
    
    //Método que tira o processo do hd e traz para a memória
    public void swapIn()
    {
        boolean trocaDeveSerFeita = true;      
        if(processoAtualObjeto.getTamanho() > memoriaMaxima)
        {
            aviso.setText("PROCESSO DA SWAP NÃO CABE NA MEMÓRIA PRINCIPAL");
            restauraBackup();
        }
        else if(melhorTrocaPossivel() == true)
        {
            processoAtualObjeto.setLocal("MEMORIA");
            processoAtualObjeto.setBase(melhorFinal.getBase());
            processoAtualObjeto.setLimite(processoAtualObjeto.getBase()+processoAtualObjeto.getTamanho()-1);            
            memoriaArray.add(processoAtualObjeto); 
            hdArray.remove(processoAtualObjeto);            
            registroBaseLabel.setText(processoAtualObjeto.getBase()+"");
            registroLimiteLabel.setText(processoAtualObjeto.getLimite()+"");                        
            desfragmentaMemoriaSwap();
            fazBackup();            
        }
 /*       else if(memoriaMaxima-(memoriaArray.get(memoriaArray.size()-1).getLimite()+1) >= processoAtualObjeto.getTamanho())
        {
            processoAtualObjeto.setLocal("MEMORIA");
            processoAtualObjeto.setBase(memoriaArray.get(memoriaArray.size()-1).getLimite()+1);
            processoAtualObjeto.setLimite(memoriaArray.get(memoriaArray.size()-1).getLimite()+processoAtualObjeto.getTamanho());            
            memoriaArray.add(processoAtualObjeto); 
            hdArray.remove(processoAtualObjeto);            
            registroBaseLabel.setText(processoAtualObjeto.getBase()+"");
            registroLimiteLabel.setText(processoAtualObjeto.getLimite()+"");            
            desfragmentaMemoriaSwap();
            fazBackup();            
        } */
        else
        {            
            for(int j = 0; j < processoAtualObjeto.getTamanho(); j++)
            {
                boolean testeSwapOut = swapOut(j);                
                if(testeSwapOut == false)
                {                    
                    aviso.setText("NÃO É POSSÍVEL FAZER SWAP-OUT, A SWAP ESTÁ CHEIA");
                    gravarBotao.setEnabled(false);
                    trocaDeveSerFeita = false;
                    restauraBackup();                    
                    break;
                }                
            }
            if(trocaDeveSerFeita == true)
            {
                processoAtualObjeto.setLocal("MEMORIA");
                processoAtualObjeto.setBase(0);
                processoAtualObjeto.setLimite(processoAtualObjeto.getTamanho()-1);
                memoriaArray.add(0, processoAtualObjeto);
                hdArray.remove(processoAtualObjeto);
                registroBaseLabel.setText(processoAtualObjeto.getBase()+"");
                registroLimiteLabel.setText(processoAtualObjeto.getLimite()+"");                                 
                desfragmentaMemoriaSwap();
                fazBackup();
            }            
        }
    }

    /* Inserindo no hdArray todos os objetos processos com tamanho a partir do arquivo TXT, até que o 
    tamanho da soma dos processos exceda o tamanho do HD */
    public void preencheHD(int posicaoInterrompida, List<String> processos)
    {
        int cont = posicaoInterrompida;
        int espacoGastoHD = 0;
        int hdConsumidoProcesso = 0;
        String nomeProcesso = "";
        System.out.println("INDEX "+posicaoInterrompida);
        for(int y = posicaoInterrompida; y < processos.size(); y++)
        {
            //Pegando o tamanho do processo
            hdConsumidoProcesso = Integer.parseInt(processos.get(y));            
            //Nome gerado dinamicamente
            nomeProcesso = Character.toString((char)(65+cont));
            espacoGastoHD += hdConsumidoProcesso;
            
            //Verificando se ainda pode inserir mais processos na memória swap
            if(hdMaximo < espacoGastoHD)
            {
                aviso.setText("MEMÓRIA E HD CHEIOS!");                                
                break;
            }   
            
            //o nome do processo é uma letra de A a Z
            
            
            //Criando novos processos e inserindo no hdArray, têm como base 0 e limite o seu tamanho -1
            else if(hdArray.isEmpty())
            {
                Processo processoTemp = new Processo(nomeProcesso, hdConsumidoProcesso, "HD");
                processoTemp.setBase(0);
                processoTemp.setLimite(hdConsumidoProcesso-1);
                processoTemp.alocaEspacoMemoria();                
                hdArray.add(processoTemp);
                tamanhoVetorProcessos++;
            }
            else
            {
                Processo processoTemp = new Processo(nomeProcesso, hdConsumidoProcesso, "HD");
                processoTemp.setBase(hdArray.get(hdArray.size()-1).getLimite()+1);
                processoTemp.setLimite(hdArray.get(hdArray.size()-1).getLimite()+hdConsumidoProcesso);
                processoTemp.alocaEspacoMemoria();                
                hdArray.add(processoTemp);
                tamanhoVetorProcessos++;
            }            
            cont++;
        }
    }
        
    /* Inserindo no memoriaArray todos os objetos processos com tamanho a partir do arquivo TXT, até que o 
    tamanho da soma dos processos exceda o tamanho da memória */
    public void preencheMemoria(List<String> texto)
    {
        //Cria os objetos processo e adiciona em filaPronto        
        Iterator itr = texto.iterator();
        int memoriaConsumidaProcesso, cont = 0;        
        int espacoGastoMemoria = 0;
        String nomeProcesso;        
        while(itr.hasNext()){         
            memoriaConsumidaProcesso = Integer.parseInt(itr.next().toString());            
            espacoGastoMemoria += memoriaConsumidaProcesso;
            
            //Verificando se ainda pode inserir mais processos na memória
            if(memoriaMaxima < espacoGastoMemoria)
            {   aviso.setText("MEMÓRIA CHEIA!");
                preencheHD(cont, texto);                
                break;
            }
            
            //o nome do processo é uma letra de A a Z
            nomeProcesso = Character.toString((char)(65+cont));
            
            //Criando novos processos e inserindo no array
            if(memoriaArray.isEmpty())
            {
                Processo processoTemp = new Processo(nomeProcesso, memoriaConsumidaProcesso, "MEMORIA");
                processoTemp.setBase(0);
                processoTemp.setLimite(memoriaConsumidaProcesso-1);
                processoTemp.alocaEspacoMemoria();
                memoriaArray.add(processoTemp);
                tamanhoVetorProcessos++;
            }
            else
            {
                Processo processoTemp = new Processo(nomeProcesso, memoriaConsumidaProcesso, "MEMORIA");
                processoTemp.setBase(memoriaArray.get(memoriaArray.size()-1).getLimite()+1);
                processoTemp.setLimite(memoriaArray.get(memoriaArray.size()-1).getLimite()+memoriaConsumidaProcesso);
                processoTemp.alocaEspacoMemoria();
                memoriaArray.add(processoTemp);
                tamanhoVetorProcessos++;
            }            
            cont++;
        }
        fazBackup();
    }
    
    //Método que resgata o processo selecionado de acordo com o arraylist que ele esteja
    public void alteraProcessoAtual(String processoAtual)
    {
        boolean achou = false;
        String processoString = processoAtual.replace("Processo ", "");
        
        if(!processoString.equals("")) gravarBotao.setEnabled(true);
        else gravarBotao.setEnabled(false);
        
        //Procura o processo no memoriaArray
        for(Processo processo : memoriaArray)
        {
            if(processo.getNome().equalsIgnoreCase(processoString) && processo.getLocal().equals("MEMORIA"))
            {
                processoAtualObjeto = processo;                
                registroBaseLabel.setText(processo.getBase()+"");
                registroLimiteLabel.setText(processo.getLimite()+"");                                
                achou = true;
                break;
            }
        }
        //Se o processo não foi achado na memoriaArray, ele será procurado no hdArray
        if(achou == false)
        {
            for(Processo processo : hdArray)
            {
                if(processo.getNome().equalsIgnoreCase(processoString) && processo.getLocal().equals("HD"))
                {
                    processoAtualObjeto = processo;                                                                                
                    //Chamando o swapIn para trazer o processo para do HD para a Mem´ória
                    swapIn();                                                   
                    break;
                }
            }            
        }        
    }
    
    //Procura a qual processo pertence o endereço de memória, ou se excede a memória ou se não está alocado a nenhum processo.
    public String buscaProcessoDono(int endereco)
    {
        for(Processo processo: memoriaArray)
        {
        if(processo.getBase() <= endereco && 
               processo.getLimite() >= endereco)
            return "O ENDEREÇO DE MEMÓRIA "+endereco+" PERTENCE AO PROCESSO "+processo.getNome()+"!";
        
        }        
        return "<HTML>O ENDEREÇO DE MEMÓRIA "+endereco+" NÃO<br> POSSUI NENHUMA ALOCAÇÃO!<HTML>";
    }
    
    //Preenchendo o select com os nomes dos processos.
    public void preencheSelect()
    {
        //Criando vetor com os nomes dos processos para inserir no select
        String[] processosVetor = new String[tamanhoVetorProcessos+1];
        int cont2 = 0;
        processosVetor[0] = "";
        ArrayList<String> teste = new ArrayList<>();
        for(int x = 1; x < processosVetor.length; x++)
        {
            processosVetor[x] = "Processo "+Character.toString((char)(65+cont2));
            cont2++;
        }
        
        configuraTabela(memoriaMaxima, tabelaMemoria);
        configuraTabela(hdMaximo, tabelaHD);
        
        //Aplicando valores ao select         
        processosSelect.setModel(new javax.swing.DefaultComboBoxModel(processosVetor)); 
    }
    
    public void configuraTabela(int quanTlinhas, JTable tabela)
    {
        ////////////////////   Configurando a tabela  ///////////////////////
        DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();  //Pega o modelo padrão da tabela
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer(); // Criando uma célula de redenrizar para poder centralizar
        centralizado.setHorizontalAlignment(SwingConstants.CENTER); //Setando o alinhamento horizontal centralizado
        
        //Aplicando o alinhamento centralizado nas duas colunas
        tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado); 
        tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        
        //Adicionando linhas com os espações de memória no modelo da tabela
        
        for(int i = 0; i < quanTlinhas; i++)
        {
           modeloTabela.addRow(new String[]{i+"",""});
        }   
    }
    
    /*Método que pega o conteúdo e endereço escolhido e tenta gravar no endereço do processo
    selecionado, desde que o endereço inserido pertença ao processo selecionado.*/
    public void gravarNaMemoria()
    {
        aviso.setText("");
        int enderecoInt = 0;
        if(!valorTexto.getText().equals("") && !enderecoTexto.equals(""))
        {
            enderecoInt = Integer.parseInt(enderecoTexto.getText());            
            if(enderecoInt > memoriaMaxima-1 || enderecoInt < 0) aviso.setText("NÃO EXISTE ESSE ENDEREÇO NA MEMÓRIA!");            
            else if(processoAtualObjeto.getBase() <= enderecoInt && processoAtualObjeto.getLimite() >= enderecoInt && processoAtualObjeto.getLocal().equals("MEMORIA"))               
            {                                                              
                processoAtualObjeto.replaceInformacao(valorTexto.getText(), enderecoInt);
                tabelaMemoria.setValueAt(valorTexto.getText(), enderecoInt, 1);
                fazBackup();
            }
            else
            {
                String dono = buscaProcessoDono(enderecoInt);
                aviso.setText(dono);
            }
        }
        else
        {
            aviso.setText("PREENCHA TODOS OS CAMPOS");
        } 
    }
    
    /** Creates new form GerenciadorDeMemoria */
    public Gerenciador() 
    {
        initComponents();
      
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registroLimite = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMemoria = new javax.swing.JTable();
        aviso = new javax.swing.JLabel();
        carregar = new javax.swing.JButton();
        areaProcesso = new javax.swing.JPanel();
        gravarBotao = new javax.swing.JButton();
        enderecoTexto = new javax.swing.JTextField();
        valorTexto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        processosSelect = new javax.swing.JComboBox<>();
        registroBaseLabel = new javax.swing.JLabel();
        registroLimiteLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaHD = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Memória");
        setResizable(false);

        registroLimite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabelaMemoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Endereço", "Conteúdo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaMemoria.setToolTipText("");
        tabelaMemoria.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tabelaMemoria);
        tabelaMemoria.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabelaMemoria.getColumnModel().getColumnCount() > 0) {
            tabelaMemoria.getColumnModel().getColumn(0).setResizable(false);
            tabelaMemoria.getColumnModel().getColumn(1).setResizable(false);
        }

        aviso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        aviso.setForeground(new java.awt.Color(255, 0, 0));
        aviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aviso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        carregar.setText("CARREGAR");
        carregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarActionPerformed(evt);
            }
        });

        areaProcesso.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        gravarBotao.setText("GRAVAR");
        gravarBotao.setEnabled(false);
        gravarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gravarBotaoActionPerformed(evt);
            }
        });

        enderecoTexto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        enderecoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enderecoTextoActionPerformed(evt);
            }
        });
        enderecoTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enderecoTextoKeyReleased(evt);
            }
        });

        valorTexto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setText("Endereço");

        jLabel2.setText("Valor");

        jLabel3.setText("Registro Limite");

        jLabel4.setText("Registro Base");

        processosSelect.setAutoscrolls(true);
        processosSelect.setEnabled(false);
        processosSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processosSelectActionPerformed(evt);
            }
        });

        registroBaseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registroBaseLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        registroLimiteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registroLimiteLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout areaProcessoLayout = new javax.swing.GroupLayout(areaProcesso);
        areaProcesso.setLayout(areaProcessoLayout);
        areaProcessoLayout.setHorizontalGroup(
            areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(areaProcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(processosSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(areaProcessoLayout.createSequentialGroup()
                        .addGroup(areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enderecoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)))
                .addGroup(areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(areaProcessoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registroBaseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registroLimiteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(areaProcessoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(gravarBotao)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        areaProcessoLayout.setVerticalGroup(
            areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(areaProcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registroBaseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(processosSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(areaProcessoLayout.createSequentialGroup()
                        .addComponent(registroLimiteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(valorTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gravarBotao))
                        .addGap(12, 12, 12))
                    .addGroup(areaProcessoLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addGroup(areaProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enderecoTexto))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Disco");

        tabelaHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Endereço", "Conteúdo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaHD.setToolTipText("");
        jScrollPane2.setViewportView(tabelaHD);
        tabelaHD.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabelaHD.getColumnModel().getColumnCount() > 0) {
            tabelaHD.getColumnModel().getColumn(0).setResizable(false);
            tabelaHD.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("RAM");

        javax.swing.GroupLayout registroLimiteLayout = new javax.swing.GroupLayout(registroLimite);
        registroLimite.setLayout(registroLimiteLayout);
        registroLimiteLayout.setHorizontalGroup(
            registroLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroLimiteLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(registroLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registroLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(areaProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(carregar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(registroLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registroLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        registroLimiteLayout.setVerticalGroup(
            registroLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroLimiteLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(registroLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(carregar)
                    .addGroup(registroLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registroLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addGroup(registroLimiteLayout.createSequentialGroup()
                        .addComponent(areaProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registroLimite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registroLimite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarActionPerformed
        memoriaArray.clear();
        processosSelect.setEnabled(true);
        gravarBotao.setEnabled(true);
        carregar.setEnabled(false);

        //Pegando caminho relativo
        String diretorioString = System.getProperty("user.dir");
        System.out.println("CAMINHO ABSOLUTO DO PROJETO "+diretorioString);
        diretorioString = diretorioString.replace("\\", "/");
        diretorioString += "/src/gerenciadordememoria/";        
        Path path = Paths.get(diretorioString+"processos.txt");
        
        List <String> texto = new ArrayList<>();
        try {
            texto = Files.readAllLines(path, ENCODING);
        } catch (IOException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }

        preencheMemoria(texto);
        preencheSelect();
        atualizaTabelas();
    }//GEN-LAST:event_carregarActionPerformed

    private void processosSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processosSelectActionPerformed
        melhorFinal = null;
        aviso.setText("");
        gravarBotao.setEnabled(true);
        registroBaseLabel.setText("");
        registroLimiteLabel.setText("");
        alteraProcessoAtual(processosSelect.getSelectedItem().toString());
    }//GEN-LAST:event_processosSelectActionPerformed

    private void enderecoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enderecoTextoActionPerformed
        
    }//GEN-LAST:event_enderecoTextoActionPerformed

    private void gravarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gravarBotaoActionPerformed
        gravarNaMemoria();
    }//GEN-LAST:event_gravarBotaoActionPerformed

    private void enderecoTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enderecoTextoKeyReleased
        enderecoTexto.setText(enderecoTexto.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_enderecoTextoKeyReleased

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
            java.util.logging.Logger.getLogger(Gerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerenciador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaProcesso;
    private javax.swing.JLabel aviso;
    private javax.swing.JButton carregar;
    private javax.swing.JTextField enderecoTexto;
    private javax.swing.JButton gravarBotao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> processosSelect;
    private javax.swing.JLabel registroBaseLabel;
    private javax.swing.JPanel registroLimite;
    private javax.swing.JLabel registroLimiteLabel;
    private javax.swing.JTable tabelaHD;
    private javax.swing.JTable tabelaMemoria;
    private javax.swing.JTextField valorTexto;
    // End of variables declaration//GEN-END:variables
}
