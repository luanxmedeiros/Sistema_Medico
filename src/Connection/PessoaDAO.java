package Connection;

import SistemaMedico.Agendamento;
import SistemaMedico.Pessoa;
import SistemaMedico.Prontuario;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PessoaDAO extends GeralDAO  {
    
    private static SimpleDateFormat formatDataBrasilEHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    //Variáveis constantes para consultas e inserções    
    public static final String SELECT_TODAS_PESSOAS = "select tb_pessoa.* from tb_pessoa;";
    public static final String SELECT_PACIENTE_ALUNO_PORIDPESSOA = "select tb_pessoa.*, tb_paciente_aluno.* from tb_pessoa join tb_paciente_aluno on tb_pessoa.id_pessoa = tb_paciente_aluno.id_pessoa where tb_pessoa.id_pessoa=?;";
    public static final String LOGIN_RECEPCIONISTA = "select tb_recepcionista.* from tb_recepcionista where tb_recepcionista.id_pessoa=? and tb_recepcionista.senha=?;";
    public static final String LOGIN_NUTRICIONISTA = "select tb_nutricionista.* from tb_nutricionista where tb_nutricionista.id_pessoa=? and tb_nutricionista.senha=?;";
    public static final String LOGIN_MEDICO = "select tb_medico.* from tb_medico where tb_medico.id_pessoa=? and tb_medico.senha=?;";
    public static final String LOGIN_DENTISTA = "select tb_dentista.* from tb_dentista where tb_dentista.id_pessoa=? and tb_dentista.senha=?;";        
    public static final String INSERIR_PESSOA = "insert into tb_pessoa (rg,cpf,email,nome,endereco) VALUES (?,?,?,?,?);";
    public static final String INSERIR_MEDICO = "insert into tb_medico (id_pessoa, senha, crm) values (?,?,?);";
    public static final String INSERIR_NUTRICIONISTA = "insert into tb_nutricionista (id_pessoa, senha, crn) values (?,?,?);";
    public static final String INSERIR_DENTISTA = "insert into tb_dentista (id_pessoa, senha, cro) values (?,?,?);";    
    public static final String INSERIR_PRONTUARIO = "insert INTO tb_prontuario (sexo, idade, observacoes,id_pessoa) VALUES (?,?,?,?);";
    public static final String INSERIR_AGENDAMENTO = "insert into tb_agendamento (data_hora,id_prontuario, para) values(STR_TO_DATE(?, \"%d/%m/%Y %r\"), ?, ?);";
    public static final String INSERIR_TELEFONE = "insert into tb_telefone (id_pessoa,telefone) value (?,?);";    
    public static final String INSERIR_PACIENTE = "insert into tb_paciente (id_pessoa) VALUE (?);";
    public static final String SELECIONA_AGENDAMENTOS_MEDICO = "select tb_pessoa.nome, tb_agendamento.id_prontuario, tb_agendamento.data_hora from tb_agendamento join tb_prontuario on tb_agendamento.id_prontuario = tb_prontuario.id_prontuario join tb_pessoa on tb_pessoa.id_pessoa = tb_prontuario.id_pessoa where tb_agendamento.para=\"MEDICO\" ORDER BY tb_agendamento.data_hora;";
    public static final String SELECIONA_AGENDAMENTOS_DENTISTA = "select tb_pessoa.nome, tb_agendamento.id_prontuario, tb_agendamento.data_hora from tb_agendamento join tb_prontuario on tb_agendamento.id_prontuario = tb_prontuario.id_prontuario join tb_pessoa on tb_pessoa.id_pessoa = tb_prontuario.id_pessoa where tb_agendamento.para=\"DENTISTA\" ORDER BY tb_agendamento.data_hora;";
    public static final String SELECIONA_AGENDAMENTOS_NUTRICIONISTA = "select tb_pessoa.nome, tb_agendamento.id_prontuario, tb_agendamento.data_hora from tb_agendamento join tb_prontuario on tb_agendamento.id_prontuario = tb_prontuario.id_prontuario join tb_pessoa on tb_pessoa.id_pessoa = tb_prontuario.id_pessoa where tb_agendamento.para=\"NUTRICIONISTA\" ORDER BY tb_agendamento.data_hora;";
    public static final String SELECIONA_UMA_PESSOA_POR_ID = "select tb_pessoa.id_pessoa from tb_pessoa WHERE tb_pessoa.id_pessoa=?;";
    public static final String SELECIONA_PRONTUARIO_ESPECIFICO = "select tb_prontuario.idade, tb_prontuario.sexo, tb_prontuario.observacoes, tb_prontuario.idade, tb_pessoa.nome from tb_prontuario join tb_pessoa on tb_prontuario.id_pessoa=tb_pessoa.id_pessoa where tb_prontuario.id_prontuario=?;";
    public boolean loginProfissional(Pessoa p, JTable tabela) {                   
            
        try {
            ResultSet resultado2 = executarConsulta(LOGIN_MEDICO, p.getId_pessoa(), p.getSenha());
            while(resultado2.next())
            {
                preencheAgendamentos(executarConsultaSemParaMetros(SELECIONA_AGENDAMENTOS_MEDICO.toString()), tabela);
                FabricaConexao.fecharConexao(con);
                return true;
            }            
            ResultSet resultado = executarConsulta(LOGIN_NUTRICIONISTA.toString(), p.getId_pessoa(), p.getSenha());
            while(resultado.next())
            {
                preencheAgendamentos(executarConsultaSemParaMetros(SELECIONA_AGENDAMENTOS_NUTRICIONISTA.toString()), tabela);
                FabricaConexao.fecharConexao(con);
                return true;
            }            
            ResultSet resultado3 = executarConsulta(LOGIN_DENTISTA.toString(), p.getId_pessoa(), p.getSenha());
            while(resultado3.next())
            {
                preencheAgendamentos(executarConsultaSemParaMetros(SELECIONA_AGENDAMENTOS_DENTISTA.toString()), tabela);
                FabricaConexao.fecharConexao(con);
                return true;
            } 
            //FabricaConexao.fecharConexao(con);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO INEXISTENTE OU SENHA OU O LOGIN ESTÁ ERRADO!");
        }

         return false;           
    }
    
    public boolean loginRecepcionista(Pessoa p) {        
           ResultSet resultado;
        try {
           resultado = executarConsulta(LOGIN_RECEPCIONISTA.toString(), p.getId_pessoa(), p.getSenha());
           while(resultado.next()){return true;}
                                     
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO INEXISTENTE OU SENHA OU O LOGIN ESTÁ ERRADO!");
        }
        
         return false;           
    }    
    
   public void criarPessoa(Pessoa p){ 
        //matricula,rg,cpf,email,nome,endereco
           Integer idGerado = null;
           
        try {                     
            idGerado = executarComandoComRetornoID(INSERIR_PESSOA.toString(), p.getRg(), p.getCpf(), p.getEmail(),  p.getNome(),p.getEndereco());
            executarComando(INSERIR_TELEFONE.toString(), idGerado, p.getTelefone());
            JOptionPane.showMessageDialog(null, "PESSOA INSERIDA COM SUCESSO!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ALGUM CAMPO ENCONTRA-SE ERRADO, POR FAVOR VERIFIQUE!");            
        }
    }
    
    public void criarMedico(Pessoa p){ 
        //matricula,rg,cpf,email,nome,endereco
        Integer idGerado = null;
           
        try {
            idGerado = executarComandoComRetornoID(INSERIR_PESSOA.toString(), p.getRg(), p.getCpf(), p.getEmail(),  p.getNome(),p.getEndereco());
            executarComando(INSERIR_MEDICO.toString(), idGerado, p.getSenha(), p.getNumeroConselho());
            executarComando(INSERIR_TELEFONE.toString(), idGerado, p.getTelefone());
           JOptionPane.showMessageDialog(null, "DENTISTA CADASTRADA COM SUCESSO!\n SEU ID PARA LOGAR É O "+idGerado+", ANOTE EM ALGUM LUGAR!");           
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
    }

    public void criarDentista(Pessoa p){ 
        //matricula,rg,cpf,email,nome,endereco
        Integer idGerado = null;
           
        try {
            idGerado = executarComandoComRetornoID(INSERIR_PESSOA.toString(), p.getRg(), p.getCpf(), p.getEmail(),  p.getNome(),p.getEndereco());
            executarComando(INSERIR_MEDICO.toString(), idGerado, p.getSenha(), p.getNumeroConselho());
            executarComando(INSERIR_TELEFONE.toString(), idGerado, p.getTelefone());
            JOptionPane.showMessageDialog(null, "MEDICO CADASTRADA COM SUCESSO!\n SEU ID PARA LOGAR É O "+idGerado+", ANOTE EM ALGUM LUGAR!");
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }                      
           
    }

    public void criarNutricionista(Pessoa p){ 
        //matricula,rg,cpf,email,nome,endereco
        Integer idGerado = null;
           
        try {
            idGerado = executarComandoComRetornoID(INSERIR_PESSOA.toString(), p.getRg(), p.getCpf(), p.getEmail(),  p.getNome(),p.getEndereco());
            executarComando(INSERIR_NUTRICIONISTA.toString(), idGerado, p.getSenha(), p.getNumeroConselho());
            executarComando(INSERIR_TELEFONE.toString(), idGerado, p.getTelefone());
            JOptionPane.showMessageDialog(null, "NUTRICIONISTA CADASTRADA COM SUCESSO!\n SEU ID PARA LOGAR É O "+idGerado+", ANOTE EM ALGUM LUGAR!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ALGUMA INFORMAÇÃO FORNECIDA ESTÁ ERRADA!");
        }                   
           
    }    
    
    public void preencheAgendamentos(ResultSet resultado, JTable tabela) throws SQLException
    {
        DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
        int i = 0;
        while(resultado.next())
        {
            Timestamp dataSolicitacao = resultado.getTimestamp("data_hora");
            //Timestamp horario = resultado.getTimestamp("hora");
            modeloTabela.addRow(new String[]{"","","",""});
            tabela.setValueAt(resultado.getString("id_prontuario"), i, 0);
            tabela.setValueAt(resultado.getString("nome"), i, 1);      
            tabela.setValueAt(formatDataBrasilEHora.format(dataSolicitacao), i, 2);           
            i++;
        }
    }
         
    public boolean inserirProntuario(Prontuario pront)
    {                
        try {
            ResultSet resultado = executarConsulta(SELECIONA_UMA_PESSOA_POR_ID.toString(), pront.getId_pessoa());
            while(resultado.next())
            {
                try {
                    executarComando(INSERIR_PRONTUARIO.toString(), pront.getSexo(),pront.getIdade(),pront.getExame_fisico(),pront.getId_pessoa());
                    JOptionPane.showMessageDialog(null, "PRONTUARIO CADASTRADO COM SUCESSO!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ALGUMA INFORMAÇÃO ESTÁ ERRADA, CONFIRA!");
                }
                return true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ESSE PACIENTE NÃO ECONTRA-SE CADASTRADO NO MOMENTO!");
        }
        return false;
    }
           
    public  List<Pessoa> popularPessoas(ResultSet resultado) throws SQLException, ClassNotFoundException{
        /*ResultSet resultado = null;    
        resultado = executarConsulta(SELECT_TODAS_PESSOAS.toString());    */
        List<Pessoa> pessoasLista = new ArrayList<>();
                       
        while(resultado.next()){
            Pessoa pessoa = new Pessoa();
            pessoa.setId_pessoa(resultado.getInt("id_pessoa"));
            pessoa.setNome(resultado.getString("nome"));
            pessoa.setRg(resultado.getString("rg"));
            pessoa.setCpf(resultado.getString("cpf"));
            pessoa.setEmail(resultado.getString("email"));
            pessoa.setEndereco(resultado.getString("endereco"));
            pessoasLista.add(pessoa);
            System.out.println(pessoa.toString());
        }    
        return pessoasLista;
    }
    
    public void inserirPaciente(int id_paciente)
    {        
        try {
            executarComando(INSERIR_PACIENTE.toString(), id_paciente);
            JOptionPane.showMessageDialog(null, "PACIENTE CADASTRADO COM SUCESSO!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ESSA PESSOA NÃO EXISTE OU JÁ ESTÁ CADASTRADA!");
        }
    }
    
    public void inserirAgendamento(Agendamento agend)
    {
        try {
            executarComando(INSERIR_AGENDAMENTO.toString(), agend.getData_hora(), agend.getId_prontuario(),agend.getPara());
            JOptionPane.showMessageDialog(null, "AGENDAMENTO EFETUADO COM SUCESSO!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ALGUMA INFORMAÇÃO ESTÁ INCORRETA, TENTE NOVAMENTE!");
        }
    }
    
    public void selecionaProntuario(int idProntuario)
    {
        ResultSet resultado = null;
        try {
                resultado = executarConsulta(SELECIONA_PRONTUARIO_ESPECIFICO.toString(), idProntuario);
                while(resultado.next())
                {
                JOptionPane.showMessageDialog(null, "NOME: "+resultado.getString("nome").toUpperCase()+"\n IDADE: "+resultado.getString("idade")+"\n SEXO: "+resultado.getString("sexo")+"\n OBSERVAÇÕES: "+resultado.getString("observacoes")+" ALGUMA INFORMAÇÃO ESTÁ INCORRETA, TENTE NOVAMENTE!");        
                }
            } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
}
