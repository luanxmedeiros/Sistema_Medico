/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class GeralDAO {
    public static Connection con;
    public static void executarComando(String sql,Object...parametros) throws Exception{
            Connection con = null;
            con = FabricaConexao.getConexao();
            PreparedStatement comando = con.prepareStatement(sql);            
            for (int i=1;i<=parametros.length;i++){
                comando.setObject(i, parametros[i-1]);
            }            
            comando.executeUpdate();
            FabricaConexao.fecharConexao(con);            

    }
    
    public static int executarComandoComRetornoID(String sql,Object...parametros) throws Exception {
        Integer id = null;
        Connection con = null ;
                con = FabricaConexao.getConexao();

            PreparedStatement comando = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i=1;i<=parametros.length;i++){
                comando.setObject(i, parametros[i-1]);
            }            
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            
            
            FabricaConexao.fecharConexao(con);
           // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");


  
        return id;
    }    
    
    public static ResultSet executarConsulta(String sql, Object...parametros) throws Exception {
        //Connection con;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        con = FabricaConexao.getConexao();
        comando = con.prepareStatement(sql);
        for (int i=1;i<=parametros.length;i++){
            comando.setObject(i, parametros[i-1]);
        } 
        resultado = comando.executeQuery();
        //FabricaConexao.fecharConexao(con);            



        return resultado;
    }    
    
    public static ResultSet executarConsultaSemParaMetros(String sql) throws Exception{
        Connection con;
        ResultSet resultado = null;
        con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);        
        resultado = comando.executeQuery();            


       /* int x = 1;
        while(resultado.next())
        {
            System.out.println("SUCESSO: "+x);
            x++;
        }*/
        
       // FabricaConexao.fecharConexao(con);
        return resultado;
    }     
}
