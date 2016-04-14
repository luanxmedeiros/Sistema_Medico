package Connection;

import SistemaMedico.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PessoaDAO extends GeralDAO  {
    //Variáveis constantes para consultas e inserções    
    public final String SELECT_TODAS_PESSOAS = "select tb_pessoa.* from tb_pessoa;";
    public final String SELECT_PACIENTE_ALUNO_PORIDPESSOA = "select tb_pessoa.*, tb_paciente_aluno.* from tb_pessoa join tb_paciente_aluno on tb_pessoa.id_pessoa = tb_paciente_aluno.id_pessoa where tb_pessoa.id_pessoa=?;";
    public final String LOGIN_RECEPCIONISTA = "select tb_recepcionista.* from tb_recepcionista where tb_recepcionista.id_pessoa=? and tb_recepcionista.senha=?;";
    public final String LOGIN_NUTRICIONISTA = "select tb_nutricionista.* from tb_nutricionista where tb_nutricionista.id_pessoa=? and tb_nutricionista.senha=?;";
    public final String LOGIN_MEDICO = "select tb_medico.* from tb_medico where tb_medico.id_pessoa=? and tb_medico.senha=?;";
    public final String LOGIN_DENTISTA = "select tb_dentista.* from tb_dentista where tb_dentista.id_pessoa=? and tb_dentista.senha=?;";        
    public final String INSERIR_PESSOA = "insert into tb_pessoa (rg,cpf,email,nome,endereco) VALUES (?,?,?,?,?);";
    public final String INSERIR_MEDICO = "insert into tb_medico (id_pessoa, senha, crm) values (?,?,?);";
    public final String INSERIR_NUTRICIONISTA = "insert into tb_nutricionista (id_pessoa, senha, crn) values (?,?,?);";
    public final String INSERIR_DENTISTA = "insert into tb_dentista (id_pessoa, senha, cro) values (?,?,?);";    
    public final String INSERIR_PRONTUARIO = "insert INTO tb_prontuario (sexo, idade, observacoes,id_pessoa) VALUES (?,?,?,?);";
    public final String INSERIR_AGENDAMENTO = "insert INTO tb_prontuario (sexo, idade, observacoes,id_pessoa) VALUES (?,?,?,?);";
    
    
    public boolean loginProfissional(Pessoa p) {        
           
            
        try {
            ResultSet resultado = executarConsulta(LOGIN_NUTRICIONISTA.toString(), p.getId_pessoa(), p.getSenha());
            while(resultado.next()){return true;}            
            ResultSet resultado2 = executarConsulta(LOGIN_MEDICO, p.getId_pessoa(), p.getSenha());
            while(resultado2.next()){return true;}
            ResultSet resultado3 = executarConsulta(LOGIN_DENTISTA.toString(), p.getId_pessoa(), p.getSenha());
            while(resultado3.next()){return true;}            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

         return false;           
    }
    
    public boolean loginRecepcionista(Pessoa p) {        
           ResultSet resultado;
        try {
           resultado = executarConsulta(LOGIN_RECEPCIONISTA.toString(), p.getId_pessoa(), p.getSenha());
           while(resultado.next()){return true;}
                                     
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return false;           
    }    
    
    public void criarPessoa(Pessoa p){ 
        //matricula,rg,cpf,email,nome,endereco
           Integer idGerado = null;
           idGerado = executarComandoComRetornoID(INSERIR_PESSOA.toString(), p.getRg(), p.getCpf(), p.getEmail(),  p.getNome(),p.getEndereco());
           
           
    }
    
    public void criarMedico(Pessoa p){ 
        //matricula,rg,cpf,email,nome,endereco
        Integer idGerado = null;
           idGerado = executarComandoComRetornoID(INSERIR_PESSOA.toString(), p.getRg(), p.getCpf(), p.getEmail(),  p.getNome(),p.getEndereco());
           executarComando(INSERIR_MEDICO.toString(), idGerado, p.getSenha(), p.getNumeroConselho());
           JOptionPane.showMessageDialog(null, "Seu id para logar é o "+idGerado+", anote em algum lugar!");
           
    }

    public void criarDentista(Pessoa p){ 
        //matricula,rg,cpf,email,nome,endereco
        Integer idGerado = null;
           idGerado = executarComandoComRetornoID(INSERIR_PESSOA.toString(), p.getRg(), p.getCpf(), p.getEmail(),  p.getNome(),p.getEndereco());
           executarComando(INSERIR_MEDICO.toString(), idGerado, p.getSenha(), p.getNumeroConselho());
           JOptionPane.showMessageDialog(null, "Seu id para logar é o "+idGerado+", anote em algum lugar!");
           
    }

    public void criarNutricionista(Pessoa p){ 
        //matricula,rg,cpf,email,nome,endereco
        Integer idGerado = null;
           idGerado = executarComandoComRetornoID(INSERIR_PESSOA.toString(), p.getRg(), p.getCpf(), p.getEmail(),  p.getNome(),p.getEndereco());
           executarComando(INSERIR_NUTRICIONISTA.toString(), idGerado, p.getSenha(), p.getNumeroConselho());
           JOptionPane.showMessageDialog(null, "Seu id para logar é o "+idGerado+", anote em algum lugar!");
           
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
}
