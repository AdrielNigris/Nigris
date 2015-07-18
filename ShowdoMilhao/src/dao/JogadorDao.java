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

    public Boolean inserir (Jogador jogador)
    {
        Boolean retorno;
        //Monta o sql de insert da tabela
        String sql = "INSERT INTO jogador(login, senha, email, imagem)" + "VALUES (?, ?, ?, ?)";
        
        //Prepara a execução do meu sql
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try 
        {
            //insere os parâmetros
            pst.setString(1, jogador.getLogin()); //esse 1 é a ordem dos parâmetros
            pst.setString(2, jogador.getSenha());
            pst.setString(3, jogador.getEmail());
            pst.setBytes(4, jogador.getImagem());
            
            //executa o sql no banco de dados
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
        List <Jogador> lista = new ArrayList<Jogador>();
        String sql = "SELECT * FROM jogador";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try 
        { 
            //Executo o sql e jogo em um resultset
            ResultSet res = pst.executeQuery();
            //Enquanto tiver registro eu vou relacionar com minha classe Jogador e adicionar na lista
            while (res.next())
            {
                Jogador jogador = new Jogador();
                jogador.setLogin(res.getString("login"));
                jogador.setSenha(res.getString("senha"));
                jogador.setEmail(res.getString("email"));
                jogador.setImagem(res.getBytes("imagem"));
                lista.add(jogador);
            }
        }
        
        catch (SQLException ex) 
        {
            Logger.getLogger(JogadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public Boolean excluir (Jogador jogador)
    {
        Boolean retorno;
        
        String sql = "DELETE FROM jogador WHERE login = ?";
        
        //Prepara a execução do meu sql
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try 
        {
            pst.setString(1, jogador.getLogin());
            pst.executeUpdate();
            retorno = true;
        }
        
        catch (Exception ex)
        {
            retorno = false;         
        }
        
        return retorno;
    }
    
    public Boolean atualizar (Jogador jogador)
    {
        Boolean retorno;
        
        String sql = "UPDATE JOGADOR SET SENHA = ?, EMAIL = ? WHERE LOGIN = ?, imagem = ?";
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try 
        {
            pst.setString(1, jogador.getSenha());
            pst.setString(2, jogador.getEmail());
            pst.setString(3, jogador.getLogin());
            pst.setBytes(4, jogador.getImagem());
            
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
    
    public Jogador login (Jogador jogador)
    {
        Jogador retorno = null;
        String sql = "SELECT * FROM jogador WHERE login = ? and senha = ? ";
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try 
        {
            pst.setString(1, jogador.getLogin());
            pst.setString(2, jogador.getSenha());
            
            ResultSet res = pst.executeQuery();
            
            //se tiver um jogador com login e senha igual ao informado
            //preenche todos os campos
            
            if (res.next())
            {
                retorno = new Jogador();
                retorno.setEmail(res.getString("email"));
                retorno.setLogin(res.getString("login"));
                retorno.setSenha(res.getString("senha"));
                retorno.setImagem(res.getBytes("Imagem"));
            }
        } 
        catch (Exception e) 
        {
            
        }
        
        return retorno;
    }
}