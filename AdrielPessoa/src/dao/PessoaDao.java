/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pessoa;

/**
 *
 * @author Adriel
 */
public class PessoaDao {
       
    public Boolean inserir(Pessoa pessoa)
    {
        Boolean retorno;
        String sql = "INSERT INTO PESSOA(NOME,SEXO)" + "VALUES (?,?)";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try
        {
        pst.setString(1, pessoa.getNome());
        pst.setString(2, pessoa.getSexo());
        
        pst.executeUpdate();
        retorno = true;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            retorno = false;
        }
    return retorno;
    }


    public List<Pessoa> listar()
    {
    List<Pessoa> lista = new ArrayList<Pessoa>();
    String sql = "SELECT * FROM PESSOA";
    PreparedStatement pst = Conexao.getPreparedStatement(sql);
    
    try{
        ResultSet res = pst.executeQuery();
        
        while(res.next())
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(res.getString("NOME"));
            pessoa.setSexo(res.getString("SEXO"));
            pessoa.setCodigo(res.getInt("CODIGO"));
            lista.add(pessoa);
        }
        
    } catch (SQLException Ex) {
        Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, Ex);
    }
    return lista;
    }
    
    
    public Boolean excluir(Pessoa pessoa)
    {
        Boolean retorno;
        String sql = "DELETE FROM pessoa WHERE codigo = ?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try
        {
        pst.setInt(1, pessoa.getCodigo());
        
        pst.executeUpdate();
        retorno = true;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            retorno = false;
        }
    return retorno;
    }

    public Boolean atualizar(Pessoa pessoa)
    {
        Boolean retorno;
        String sql = "UPDATE pessoa SET nome =?, sexo = ?"
                   + "WHERE codigo=?";
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try
        {
        pst.setString(1, pessoa.getNome());
        pst.setString(2, pessoa.getSexo());
        pst.setInt(3,pessoa.getCodigo());
        
        pst.executeUpdate();
        retorno = true;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            retorno = false;
        }
    return retorno;
    }

    
    
}
    
  
