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
import modelo.Jogador;


/**
 *
 * @author Adriel
 */
public class JogadorDao {

    public Boolean inserir(Jogador jogador)
    {
        Boolean retorno;
        String sql = "INSERT INTO jogador(login,senha,email)" + "VALUES (?,?,?)";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try
        {
        pst.setString(1, jogador.getLogin());
        pst.setString(2, jogador.getSenha());
        pst.setString(3, jogador.getEmail());
        
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


    public List<Jogador> listar()
    {
    List<Jogador> lista = new ArrayList<Jogador>();
    String sql = "SELECT * FROM jogador";
    PreparedStatement pst = Conexao.getPreparedStatement(sql);
    
    try{
        ResultSet res = pst.executeQuery();
        
        while(res.next())
        {
            Jogador jogador = new Jogador();
            jogador.setLogin(res.getString("login"));
            jogador.setSenha(res.getString("senha"));
            jogador.setEmail(res.getString("email"));
            lista.add(jogador);
        }
        
    } catch (SQLException Ex) {
        Logger.getLogger(JogadorDao.class.getName()).log(Level.SEVERE, null, Ex);
    }
    return lista;
    }
    
    
    public Boolean excluir(Jogador jogador)
    {
        Boolean retorno;
        String sql = "DELETE FROM jogador WHERE login = ?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try
        {
        pst.setString(1, jogador.getLogin());
        
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