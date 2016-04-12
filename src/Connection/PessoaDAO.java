package Connection;

import SistemaMedico.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PessoaDAO extends GeralDAO  {
    //Variáveis constantes para consultas e inserções
    public static final String INSERT_PESSOA = "INSERT INTO tb_pessoa(nome, rg, cpf, email, endereco) VALUES(?, ?, ?, ?, ?);";
    public static final String SELECT_TODAS_PESSOAS = "select tb_pessoa.* from tb_pessoa;";
    
    
    public static void criarPessoa(Pessoa p) throws ClassNotFoundException, SQLException{        
           executarComando(INSERT_PESSOA.toString(), p.getNome(), p.getRg(), p.getCpf(), p.getEmail(), p.getEndereco());
    }
    
         
           
    public static List<Pessoa> popularPessoas() throws SQLException, ClassNotFoundException{
        ResultSet resultado = null;    
        resultado = executarConsulta(SELECT_TODAS_PESSOAS.toString());    
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
