/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adrielpessoa;
import dao.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Adriel
 */
public class AdrielPessoa {

   public static void main(String[] args) throws SQLException {
        inserir();
    }
    public static void inserir () throws SQLException 
    {
        String sql;
        sql = "INSERT INTO pessoa (NOME,SEXO)" +
              "VALUES ('Adriel','Masculino')";
                
        PreparedStatement pst
                = Conexao.getPreparedStatement(sql);
            pst.executeUpdate();
                  
        }
    } 