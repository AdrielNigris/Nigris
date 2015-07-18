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
import modelo.Pergunta;

/**
 *
 * @author Adriel
 */
public class PerguntaDao {
     public Boolean Inserir(Pergunta pergunta){
        Boolean retorno;
        
        String sql = "INSERT INTO Pergunta(a,b,c,d,certa,enunciado,nivel)" + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try
        {
        pst.setString(1, pergunta.getA());
        pst.setString(2, pergunta.getB());
        pst.setString(3, pergunta.getC());
        pst.setString(4, pergunta.getD());
        pst.setString(5, pergunta.getCerta());
        pst.setString(6, pergunta.getEnunciado());
        pst.setInt(7, pergunta.getNivel());
                
                
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
     
     
     public List<Pergunta> listarNivel1()
    {
        List<Pergunta> lista = new ArrayList<Pergunta>();
        String sql = "SELECT * FROM pergunta WHERE nivel = 1 ORDER BY random() LIMIT 4 ";
          PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try
        {
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Pergunta pergunta = new Pergunta();
                pergunta.setEnunciado(res.getString("enunciado"));
                pergunta.setA(res.getString("a"));
                pergunta.setB(res.getString("b"));
                pergunta.setC(res.getString("c"));
                pergunta.setD(res.getString("d"));
                pergunta.setCerta(res.getString("certa"));
                pergunta.setNivel(res.getInt("nivel"));
                pergunta.setId(res.getInt("id"));
                lista.add(pergunta);
            }
        }
        catch (SQLException ex )
        {
            Logger.getLogger(PerguntaDao.class.getName()).log(Level.SEVERE, null,ex);
        }
        return lista;
        
    }
     
    public List<Pergunta> listarNivel2 ()
    {
        List<Pergunta> lista = new ArrayList<Pergunta>();
        String sql = "SELECT * FROM pergunta WHERE nivel = 2 ORDER BY random() LIMIT 4 ";
          PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try
        {
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Pergunta pergunta = new Pergunta();
                pergunta.setEnunciado(res.getString("enunciado"));
                pergunta.setA( res.getString("a"));
                pergunta.setB( res.getString("b"));
                pergunta.setC( res.getString("c"));
                pergunta.setD(res.getString("d"));
                pergunta.setCerta(res.getString("certa"));
                pergunta.setNivel(res.getInt("nivel"));
                pergunta.setId(res.getInt("id"));
                lista.add(pergunta);
            }
        }
        catch (SQLException ex )
        {
            Logger.getLogger(PerguntaDao.class.getName()).log(Level.SEVERE, null,ex);
        }
        return lista;
        
    }
        
     public List<Pergunta> listar()
    {
    List<Pergunta> lista = new ArrayList<Pergunta>();
    String sql = "SELECT * FROM Pergunta";
    PreparedStatement pst = Conexao.getPreparedStatement(sql);
    
    try{
        ResultSet res = pst.executeQuery();
        
        while(res.next())
        {
            Pergunta pergunta = new Pergunta();
            pergunta.setEnunciado(res.getString("enunciado"));
            pergunta.setA( res.getString("a"));
            pergunta.setB( res.getString("b"));
            pergunta.setC( res.getString("c"));
            pergunta.setD(res.getString("d"));
            pergunta.setCerta(res.getString("certa"));
            pergunta.setNivel(res.getInt("nivel"));
            pergunta.setId(res.getInt("id"));
            
            lista.add(pergunta);
            
        }
        
    } catch (SQLException Ex) {
        Logger.getLogger(JogadorDao.class.getName()).log(Level.SEVERE, null, Ex);
    }
    return lista;
    }
     
     
    public Boolean excluir(Pergunta pergunta)
    {
        Boolean retorno;
        String sql = "DELETE FROM pergunta WHERE enunciado = ?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try
        {
        pst.setString(1, pergunta.getEnunciado());
        
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

