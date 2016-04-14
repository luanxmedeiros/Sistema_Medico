/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaMedico;

import static Connection.GeralDAO.executarConsultaSemParaMetros;
import Connection.PessoaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rosemberg Filho
 */
public class Main {
    public static void main(String[] args){
       // Pessoa p = new Pessoa(1234, "Luan", "000.000.0", "080.000.070-00", "luan@luan.com", "Brasil");
       PessoaDAO pessoa = new PessoaDAO();
        try {
            /*
            try {
            PessoaDAO.criarPessoa(p);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            System.out.println("TOTAL \n"+pessoa.popularPessoas(executarConsultaSemParaMetros(pessoa.SELECT_TODAS_PESSOAS.toString())).toString());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

            
            
    }
}
