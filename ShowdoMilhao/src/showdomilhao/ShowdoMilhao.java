/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showdomilhao;

import dao.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Junior
 */
public class ShowdoMilhao {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        inserir();
    }
    public static void inserir () throws SQLException 
    {
        String sql;
        sql = "INSERT INTO jogado   r(login,senha,email)" +
              "VALUES ('silviosantos','dinheiro','patrao@sbt.com')";
                
        PreparedStatement pst
                = Conexao.getPreparedStatement(sql);
            pst.executeUpdate();
                  
        }
    } 







