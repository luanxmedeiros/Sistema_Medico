/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class GeralDAO {
    
    public static void executarComando(String sql,Object...parametros) throws SQLException, ClassNotFoundException{

        try {            
            Connection con = FabricaConexao.getConexao();
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
    
    public static ResultSet executarConsulta(String sql, Object...parametros) throws SQLException, ClassNotFoundException{
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i=1;i<=parametros.length;i++){
            comando.setObject(i, parametros[i-1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);
        return resultado;
    }    
}
