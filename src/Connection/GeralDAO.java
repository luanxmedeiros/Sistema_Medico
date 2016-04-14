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
    
    public static void executarComando(String sql,Object...parametros){
        Connection con = null;
        try {            
            try {
                con = FabricaConexao.getConexao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GeralDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement comando = con.prepareStatement(sql);            
            for (int i=1;i<=parametros.length;i++){
                comando.setObject(i, parametros[i-1]);
            }            
            comando.executeUpdate();
            FabricaConexao.fecharConexao(con);
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
            Logger.getLogger(GeralDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    public static int executarComandoComRetornoID(String sql,Object...parametros){
        Integer id = null;
        Connection con = null ;
        try {                
            try {
                con = FabricaConexao.getConexao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GeralDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement comando = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i=1;i<=parametros.length;i++){
                comando.setObject(i, parametros[i-1]);
            }            
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            
            if(resultado.next()){
                id = resultado.getInt(1);
                System.out.println("ID GERADO: "+id);
            }	            
            FabricaConexao.fecharConexao(con);
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
            Logger.getLogger(GeralDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        return id;
    }    
    
    public static ResultSet executarConsulta(String sql, Object...parametros) {
        Connection con;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            con = FabricaConexao.getConexao();
            comando = con.prepareStatement(sql);
            for (int i=1;i<=parametros.length;i++){
                comando.setObject(i, parametros[i-1]);
            } 
            resultado = comando.executeQuery();
            FabricaConexao.fecharConexao(con);            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GeralDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return resultado;
    }    
    
    public static ResultSet executarConsultaSemParaMetros(String sql) throws SQLException, ClassNotFoundException{
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        
        ResultSet resultado = comando.executeQuery();
       /* int x = 1;
        while(resultado.next())
        {
            System.out.println("SUCESSO: "+x);
            x++;
        }*/
        
        FabricaConexao.fecharConexao(con);
        return resultado;
    }     
}
