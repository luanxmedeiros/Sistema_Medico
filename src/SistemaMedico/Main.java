/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaMedico;

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
        Pessoa p = new Pessoa(1234, "Luan", "000.000.0", "080.000.070-00", "luan@luan.com", "Brasil");
      
        try {
            /*
            try {
            PessoaDAO.criarPessoa(p);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            PessoaDAO.popularPessoas();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

            
            
    }
}
