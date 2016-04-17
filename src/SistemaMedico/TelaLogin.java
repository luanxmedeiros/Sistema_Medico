/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaMedico;

import Connection.PessoaDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * 
 */
public class TelaLogin extends javax.swing.JFrame {
    private String logado = "";
    PessoaDAO pessoaDAO = new PessoaDAO();
    /** Creates new form TelaLogin */
    public TelaLogin() {
        initComponents();
        PainelNovoCadastro.setVisible(false);
        TelaRecepcionista.setVisible(false);
        TelaProfissional.setVisible(false);
        try {
            cadNovoTelefone.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("(##) ####-#####")));
            
             cadNovoCPF.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("###.###.###-##")));
             
             cadNovoRG.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("###.###.###")));       
             
             agendDataConsulta.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("##/##/####")));
             
             agendHoraConsulta.setFormatterFactory(new DefaultFormatterFactory(
                   new MaskFormatter("##:##")));
        } catch (Exception ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }

     
    }


    public void escondeTodosPaineis()
    {
        PainelLogin.setVisible(false);
        PainelNovoCadastro.setVisible(false);
        TelaRecepcionista.setVisible(false);
        TelaProfissional.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoProfissionais = new javax.swing.ButtonGroup();
        sexo = new javax.swing.ButtonGroup();
        agendamento = new javax.swing.ButtonGroup();
        PainelLogin = new javax.swing.JPanel();
        novoCadastro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logar = new javax.swing.JButton();
        matricula = new javax.swing.JTextField();
        senha = new javax.swing.JPasswordField();
        PainelNovoCadastro = new javax.swing.JPanel();
        cadNovoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cadNovoEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cadNovoEndereco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        radioMedico = new javax.swing.JRadioButton();
        radioOdontologo = new javax.swing.JRadioButton();
        radioNutricionista = new javax.swing.JRadioButton();
        numeroConselho = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cadastrarNovoProfissional = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cadNovoCPF = new javax.swing.JFormattedTextField();
        cadNovoRG = new javax.swing.JFormattedTextField();
        cadNovoTelefone = new javax.swing.JFormattedTextField();
        cadNovoSenha = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        TelaRecepcionista = new javax.swing.JPanel();
        Tabs = new javax.swing.JTabbedPane();
        Paciente = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        regPacienteID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Prontuario = new javax.swing.JPanel();
        PainelNovoCadastro1 = new javax.swing.JPanel();
        prontIDPessoa = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        prontIdade = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        radioMasculino = new javax.swing.JRadioButton();
        radioFeminino = new javax.swing.JRadioButton();
        jLabel28 = new javax.swing.JLabel();
        cadastrarProntuario = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        prontObservacoes = new javax.swing.JTextArea();
        Agendamento = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        agendCadastrar = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        agendIDProntuario = new javax.swing.JTextField();
        agendNutricionista = new javax.swing.JRadioButton();
        agendOdontologo = new javax.swing.JRadioButton();
        agendMedico = new javax.swing.JRadioButton();
        agendDataConsulta = new javax.swing.JFormattedTextField();
        agendHoraConsulta = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        TelaProfissional = new javax.swing.JPanel();
        Tabs1 = new javax.swing.JTabbedPane();
        Agendamento1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAgendamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        novoCadastro.setText("NOVO CADASTRO");
        novoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoCadastroActionPerformed(evt);
            }
        });

        jLabel2.setText("SENHA");

        jLabel1.setText("MATRÍCULA");

        logar.setText("LOGAR");
        logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logarActionPerformed(evt);
            }
        });

        matricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        matricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        matricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaActionPerformed(evt);
            }
        });
        matricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                matriculaKeyReleased(evt);
            }
        });

        senha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        senha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout PainelLoginLayout = new javax.swing.GroupLayout(PainelLogin);
        PainelLogin.setLayout(PainelLoginLayout);
        PainelLoginLayout.setHorizontalGroup(
            PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLoginLayout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addGroup(PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(novoCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(logar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(matricula)
                    .addComponent(senha))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        PainelLoginLayout.setVerticalGroup(
            PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLoginLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(novoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );

        cadNovoNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cadNovoNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cadNovoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadNovoNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("NOME");

        jLabel4.setText("RG");

        jLabel5.setText("EMAIL");

        cadNovoEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cadNovoEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("CPF");

        jLabel7.setText("TELEFONE");

        cadNovoEndereco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cadNovoEndereco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("ENDEREÇO");

        grupoProfissionais.add(radioMedico);
        radioMedico.setText("CLÍNICO GERAL");

        grupoProfissionais.add(radioOdontologo);
        radioOdontologo.setText("ODONTÓLOGO");

        grupoProfissionais.add(radioNutricionista);
        radioNutricionista.setText("NUTRICIONISTA");
        radioNutricionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNutricionistaActionPerformed(evt);
            }
        });

        numeroConselho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numeroConselho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        numeroConselho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numeroConselhoKeyReleased(evt);
            }
        });

        jLabel9.setText("N° DO CONSELHO");

        cadastrarNovoProfissional.setText("CADASTRAR");
        cadastrarNovoProfissional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarNovoProfissionalActionPerformed(evt);
            }
        });

        jButton3.setText("VOLTAR AO INÍCIO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cadNovoCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cadNovoCPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cadNovoRG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cadNovoRG.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cadNovoTelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cadNovoTelefone.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cadNovoSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cadNovoSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setText("SENHA");

        javax.swing.GroupLayout PainelNovoCadastroLayout = new javax.swing.GroupLayout(PainelNovoCadastro);
        PainelNovoCadastro.setLayout(PainelNovoCadastroLayout);
        PainelNovoCadastroLayout.setHorizontalGroup(
            PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelNovoCadastroLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PainelNovoCadastroLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cadNovoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PainelNovoCadastroLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cadNovoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PainelNovoCadastroLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cadNovoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PainelNovoCadastroLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cadNovoRG, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PainelNovoCadastroLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cadNovoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PainelNovoCadastroLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cadNovoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PainelNovoCadastroLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(numeroConselho, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PainelNovoCadastroLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelNovoCadastroLayout.createSequentialGroup()
                                .addComponent(radioMedico)
                                .addGap(10, 10, 10)
                                .addComponent(radioOdontologo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioNutricionista))
                            .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cadastrarNovoProfissional, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cadNovoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        PainelNovoCadastroLayout.setVerticalGroup(
            PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelNovoCadastroLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadNovoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cadNovoRG, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelNovoCadastroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelNovoCadastroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadNovoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadNovoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadNovoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadNovoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroConselho, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadNovoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMedico)
                    .addComponent(radioOdontologo)
                    .addComponent(radioNutricionista))
                .addGap(18, 18, 18)
                .addComponent(cadastrarNovoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );

        labelNome.setText("ID DO USUÁRIO");

        regPacienteID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        regPacienteID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regPacienteIDActionPerformed(evt);
            }
        });
        regPacienteID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                regPacienteIDKeyReleased(evt);
            }
        });

        jButton1.setText("REGISTRAR PACIENTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PacienteLayout = new javax.swing.GroupLayout(Paciente);
        Paciente.setLayout(PacienteLayout);
        PacienteLayout.setHorizontalGroup(
            PacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PacienteLayout.createSequentialGroup()
                .addComponent(labelNome)
                .addGap(18, 18, 18)
                .addGroup(PacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(regPacienteID))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        PacienteLayout.setVerticalGroup(
            PacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PacienteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regPacienteID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(417, Short.MAX_VALUE))
        );

        Tabs.addTab("Cadastrar Paciente", Paciente);

        prontIDPessoa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prontIDPessoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        prontIDPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prontIDPessoaActionPerformed(evt);
            }
        });
        prontIDPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prontIDPessoaKeyReleased(evt);
            }
        });

        jLabel20.setText("ID PESSOA");

        jLabel21.setText("IDADE");

        prontIdade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prontIdade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        prontIdade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prontIdadeKeyReleased(evt);
            }
        });

        jLabel23.setText("OBSERVAÇÕES");

        sexo.add(radioMasculino);
        radioMasculino.setText("MASCULINO");

        sexo.add(radioFeminino);
        radioFeminino.setText("FEMININO");

        jLabel28.setText("SEXO");

        cadastrarProntuario.setText("CADASTRAR");
        cadastrarProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarProntuarioActionPerformed(evt);
            }
        });

        prontObservacoes.setColumns(20);
        prontObservacoes.setLineWrap(true);
        prontObservacoes.setRows(5);
        jScrollPane2.setViewportView(prontObservacoes);

        javax.swing.GroupLayout PainelNovoCadastro1Layout = new javax.swing.GroupLayout(PainelNovoCadastro1);
        PainelNovoCadastro1.setLayout(PainelNovoCadastro1Layout);
        PainelNovoCadastro1Layout.setHorizontalGroup(
            PainelNovoCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelNovoCadastro1Layout.createSequentialGroup()
                .addGroup(PainelNovoCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelNovoCadastro1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(PainelNovoCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PainelNovoCadastro1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(prontIDPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PainelNovoCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PainelNovoCadastro1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(radioMasculino)
                                    .addGap(10, 10, 10)
                                    .addComponent(radioFeminino))
                                .addGroup(PainelNovoCadastro1Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(prontIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PainelNovoCadastro1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(PainelNovoCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PainelNovoCadastro1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cadastrarProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        PainelNovoCadastro1Layout.setVerticalGroup(
            PainelNovoCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelNovoCadastro1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PainelNovoCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prontIDPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelNovoCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prontIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelNovoCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(radioMasculino)
                    .addComponent(radioFeminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelNovoCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrarProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ProntuarioLayout = new javax.swing.GroupLayout(Prontuario);
        Prontuario.setLayout(ProntuarioLayout);
        ProntuarioLayout.setHorizontalGroup(
            ProntuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(ProntuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ProntuarioLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PainelNovoCadastro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        ProntuarioLayout.setVerticalGroup(
            ProntuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
            .addGroup(ProntuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ProntuarioLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PainelNovoCadastro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        Tabs.addTab("Prontuario", Prontuario);

        jLabel22.setText("HORA CONSULTA");

        jLabel24.setText("DATA CONSULTA");

        agendCadastrar.setText("CADASTRAR");
        agendCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendCadastrarActionPerformed(evt);
            }
        });

        jLabel25.setText("ID PRONTUARIO");

        agendIDProntuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        agendIDProntuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        agendIDProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendIDProntuarioActionPerformed(evt);
            }
        });
        agendIDProntuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                agendIDProntuarioKeyReleased(evt);
            }
        });

        agendamento.add(agendNutricionista);
        agendNutricionista.setText("NUTRICIONISTA");
        agendNutricionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendNutricionistaActionPerformed(evt);
            }
        });

        agendamento.add(agendOdontologo);
        agendOdontologo.setText("ODONTÓLOGO");

        agendamento.add(agendMedico);
        agendMedico.setText("CLÍNICO GERAL");

        agendDataConsulta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        agendDataConsulta.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        agendHoraConsulta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        agendHoraConsulta.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("COMPETÊNCIA");

        javax.swing.GroupLayout AgendamentoLayout = new javax.swing.GroupLayout(Agendamento);
        Agendamento.setLayout(AgendamentoLayout);
        AgendamentoLayout.setHorizontalGroup(
            AgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(AgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(agendHoraConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AgendamentoLayout.createSequentialGroup()
                            .addGroup(AgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel25)
                                .addComponent(jLabel24))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(AgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(agendIDProntuario, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(agendDataConsulta))))
                    .addGroup(AgendamentoLayout.createSequentialGroup()
                        .addGroup(AgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AgendamentoLayout.createSequentialGroup()
                                .addComponent(agendMedico)
                                .addGap(10, 10, 10)
                                .addComponent(agendOdontologo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(agendNutricionista))
                            .addComponent(agendCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(118, 118, 118))
        );
        AgendamentoLayout.setVerticalGroup(
            AgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(AgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agendIDProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agendDataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agendHoraConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agendMedico)
                    .addComponent(agendOdontologo)
                    .addComponent(agendNutricionista)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(agendCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );

        Tabs.addTab("Agendamento", Agendamento);

        javax.swing.GroupLayout TelaRecepcionistaLayout = new javax.swing.GroupLayout(TelaRecepcionista);
        TelaRecepcionista.setLayout(TelaRecepcionistaLayout);
        TelaRecepcionistaLayout.setHorizontalGroup(
            TelaRecepcionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
            .addGroup(TelaRecepcionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TelaRecepcionistaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        TelaRecepcionistaLayout.setVerticalGroup(
            TelaRecepcionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
            .addGroup(TelaRecepcionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TelaRecepcionistaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tabelaAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PRONTUÁRIO", "PACIENTE", "DATA / HORA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAgendamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAgendamento);

        javax.swing.GroupLayout Agendamento1Layout = new javax.swing.GroupLayout(Agendamento1);
        Agendamento1.setLayout(Agendamento1Layout);
        Agendamento1Layout.setHorizontalGroup(
            Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        Agendamento1Layout.setVerticalGroup(
            Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        Tabs1.addTab("Agendamentos", Agendamento1);

        javax.swing.GroupLayout TelaProfissionalLayout = new javax.swing.GroupLayout(TelaProfissional);
        TelaProfissional.setLayout(TelaProfissionalLayout);
        TelaProfissionalLayout.setHorizontalGroup(
            TelaProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaProfissionalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tabs1)
                .addContainerGap())
        );
        TelaProfissionalLayout.setVerticalGroup(
            TelaProfissionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaProfissionalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tabs1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PainelNovoCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TelaRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TelaProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PainelNovoCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TelaRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TelaProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadNovoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadNovoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadNovoNomeActionPerformed

    private void radioNutricionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNutricionistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNutricionistaActionPerformed

    private void novoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoCadastroActionPerformed
        escondeTodosPaineis();
        PainelNovoCadastro.setVisible(true);
    }//GEN-LAST:event_novoCadastroActionPerformed

    private void regPacienteIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regPacienteIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regPacienteIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(regPacienteID.getText().length() > 0)
        {
        pessoaDAO.inserirPaciente(Integer.parseInt(regPacienteID.getText()));
        }else JOptionPane.showMessageDialog(null, "INSIRA O ID DE USUÁRIO!");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void prontIDPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prontIDPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prontIDPessoaActionPerformed

    private void agendIDProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendIDProntuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agendIDProntuarioActionPerformed

    private void logarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logarActionPerformed
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pes =  new Pessoa();
                
        //pes.setId_pessoa(Integer.parseInt(matricula.getText().replaceAll("[^0123456789]", "")));
        if(!matricula.getText().equals("") && !senha.getText().equals(""))
        {
            pes.setSenha(senha.getText());
            pes.setId_pessoa(Integer.parseInt(matricula.getText()));
            if(pessoaDAO.loginProfissional(pes, tabelaAgendamento)==true)
            {
                escondeTodosPaineis();
                TelaProfissional.setVisible(true);            
            }
            else if(pessoaDAO.loginRecepcionista(pes)==true)
            {
                escondeTodosPaineis();
                TelaRecepcionista.setVisible(true);
                logado = "RECEPCIONISTA";
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usuário inexistente ou dados errados!");        
            }
        }        
    }//GEN-LAST:event_logarActionPerformed

    private void matriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matriculaKeyReleased
                matricula.setText(matricula.getText().replaceAll("[^0123456789]", ""));
        if (matricula.getText().length() > 16) {
           matricula.setText(matricula.getText().substring (0, 16));
            }
    }//GEN-LAST:event_matriculaKeyReleased

    private void cadastrarNovoProfissionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarNovoProfissionalActionPerformed
        
        if(cadNovoNome.getText().length() > 0 &&
           cadNovoRG.getText().replaceAll("[^0123456789]", "").length() > 0 &&
           cadNovoEndereco.getText().length() > 0 &&
           cadNovoTelefone.getText().replaceAll("[^0123456789]", "").length() > 0 &&
           numeroConselho.getText().length() > 0 &&                                         
           cadNovoCPF.getText().replaceAll("[^0123456789]", "").length() > 0 &&
           cadNovoSenha.getText().length() > 0 &&     
           cadNovoEmail.getText().length() > 0 &&
                (radioMedico.isSelected() || radioOdontologo.isSelected() || radioNutricionista.isSelected()))                            
          {
                Pessoa pessoa = new Pessoa(1, cadNovoNome.getText(), cadNovoRG.getText().replaceAll("[^0123456789]", ""), cadNovoCPF.getText().replaceAll("[^0123456789]", ""), cadNovoEmail.getText(), cadNovoEndereco.getText(), cadNovoTelefone.getText().replaceAll("[^0123456789]", ""),cadNovoSenha.getText(), numeroConselho.getText());
                if(radioMedico.isSelected())
                {
                    pessoaDAO.criarMedico(pessoa);
                }
                else if(radioOdontologo.isSelected())
                {
                    pessoaDAO.criarDentista(pessoa);
                }
                else if(radioNutricionista.isSelected())
                {
                    pessoaDAO.criarNutricionista(pessoa);
                }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!");
        }
    }//GEN-LAST:event_cadastrarNovoProfissionalActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        escondeTodosPaineis();
        PainelLogin.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void numeroConselhoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroConselhoKeyReleased
        numeroConselho.setText(numeroConselho.getText().replaceAll("[^0123456789]", ""));
    }//GEN-LAST:event_numeroConselhoKeyReleased

    private void matriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaActionPerformed

    private void cadastrarProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarProntuarioActionPerformed
        if(prontIDPessoa.getText().length() > 0 && prontObservacoes.getText().length() > 0 && prontIdade.getText().length() > 0 && (radioMasculino.isSelected() || radioFeminino.isSelected()))
        {
            Prontuario pront = new Prontuario();
            pront.setId_pessoa(Integer.parseInt(prontIDPessoa.getText()));
            pront.setIdade(Integer.parseInt(prontIdade.getText()));
            pront.setExame_fisico(prontObservacoes.getText());
            if(radioMasculino.isSelected()) pront.setSexo("MASCULINO");
            else pront.setSexo("FEMININO");
            if(pessoaDAO.inserirProntuario(pront) == false)
            {
                JOptionPane.showMessageDialog(null, "ESSE ID DE USUÁRIO NÃO EXISTE!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "PRONTUÁRIO RESGISTRADO COM SUCESSO!");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!");
        }        
    }//GEN-LAST:event_cadastrarProntuarioActionPerformed

    private void agendNutricionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendNutricionistaActionPerformed
        

    }//GEN-LAST:event_agendNutricionistaActionPerformed

    private void prontIDPessoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prontIDPessoaKeyReleased
        prontIDPessoa.setText(prontIDPessoa.getText().replaceAll("[^0123456789]", ""));
    }//GEN-LAST:event_prontIDPessoaKeyReleased

    private void prontIdadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prontIdadeKeyReleased
        prontIdade.setText(prontIdade.getText().replaceAll("[^0123456789]", ""));
    }//GEN-LAST:event_prontIdadeKeyReleased

    private void agendIDProntuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_agendIDProntuarioKeyReleased
        agendIDProntuario.setText(agendIDProntuario.getText().replaceAll("[^0123456789]", ""));
    }//GEN-LAST:event_agendIDProntuarioKeyReleased

    private void agendCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendCadastrarActionPerformed
           if(agendIDProntuario.getText().length() > 0 &&
            agendHoraConsulta.getText().length() == 5 &&
             agendDataConsulta.getText().length()== 10 &&
                   (agendNutricionista.isSelected() ||
                    agendMedico.isSelected() ||
                    agendOdontologo.isSelected() ))
                    
            {
                if(agendMedico.isSelected()) pessoaDAO.inserirAgendamento(new Agendamento(Integer.parseInt(agendIDProntuario.getText()), agendDataConsulta.getText()+" "+agendHoraConsulta.getText(), "MEDICO"));
                else if(agendNutricionista.isSelected()) pessoaDAO.inserirAgendamento(new Agendamento(Integer.parseInt(agendIDProntuario.getText()), agendDataConsulta.getText()+" "+agendHoraConsulta.getText(), "NUTRICIONISTA"));
                else if(agendOdontologo.isSelected()) pessoaDAO.inserirAgendamento(new Agendamento(Integer.parseInt(agendIDProntuario.getText()), agendDataConsulta.getText()+" "+agendHoraConsulta.getText(), "DENTISTA"));                                                                
            }
                else JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!");
    }//GEN-LAST:event_agendCadastrarActionPerformed

    private void regPacienteIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regPacienteIDKeyReleased
       regPacienteID.setText(regPacienteID.getText().replaceAll("[^0123456789]", ""));
    }//GEN-LAST:event_regPacienteIDKeyReleased

    private void tabelaAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAgendamentoMouseClicked
        System.out.println("POSICAO: "+tabelaAgendamento.getSelectedRow());
        String idProntuario = tabelaAgendamento.getValueAt(tabelaAgendamento.getSelectedRow(),0).toString().trim();        
        System.out.println("TESTANDO "+idProntuario);
        pessoaDAO.selecionaProntuario(Integer.parseInt(idProntuario));
    }//GEN-LAST:event_tabelaAgendamentoMouseClicked

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agendamento;
    private javax.swing.JPanel Agendamento1;
    private javax.swing.JPanel Paciente;
    private javax.swing.JPanel PainelLogin;
    private javax.swing.JPanel PainelNovoCadastro;
    private javax.swing.JPanel PainelNovoCadastro1;
    private javax.swing.JPanel Prontuario;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JTabbedPane Tabs1;
    private javax.swing.JPanel TelaProfissional;
    private javax.swing.JPanel TelaRecepcionista;
    private javax.swing.JButton agendCadastrar;
    private javax.swing.JFormattedTextField agendDataConsulta;
    private javax.swing.JFormattedTextField agendHoraConsulta;
    private javax.swing.JTextField agendIDProntuario;
    private javax.swing.JRadioButton agendMedico;
    private javax.swing.JRadioButton agendNutricionista;
    private javax.swing.JRadioButton agendOdontologo;
    private javax.swing.ButtonGroup agendamento;
    private javax.swing.JFormattedTextField cadNovoCPF;
    private javax.swing.JTextField cadNovoEmail;
    private javax.swing.JTextField cadNovoEndereco;
    private javax.swing.JTextField cadNovoNome;
    private javax.swing.JFormattedTextField cadNovoRG;
    private javax.swing.JPasswordField cadNovoSenha;
    private javax.swing.JFormattedTextField cadNovoTelefone;
    private javax.swing.JButton cadastrarNovoProfissional;
    private javax.swing.JButton cadastrarProntuario;
    private javax.swing.ButtonGroup grupoProfissionais;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelNome;
    private javax.swing.JButton logar;
    private javax.swing.JTextField matricula;
    private javax.swing.JButton novoCadastro;
    private javax.swing.JTextField numeroConselho;
    private javax.swing.JTextField prontIDPessoa;
    private javax.swing.JTextField prontIdade;
    private javax.swing.JTextArea prontObservacoes;
    private javax.swing.JRadioButton radioFeminino;
    private javax.swing.JRadioButton radioMasculino;
    private javax.swing.JRadioButton radioMedico;
    private javax.swing.JRadioButton radioNutricionista;
    private javax.swing.JRadioButton radioOdontologo;
    private javax.swing.JTextField regPacienteID;
    private javax.swing.JPasswordField senha;
    private javax.swing.ButtonGroup sexo;
    private javax.swing.JTable tabelaAgendamento;
    // End of variables declaration//GEN-END:variables
}
