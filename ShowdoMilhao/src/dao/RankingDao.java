package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Ranking;

public class RankingDao {
    
     public Boolean inserir(Ranking ra)
    {
        Boolean retorno;
        //monta o sql de insert da tabela
       String sql= "INSERT INTO ranking(login, pontos, data) VALUES (?, ?, ? )"; 
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try
        {
        pst.setString(1,ra.getJogador().getLogin());
        pst.setDouble(2,ra.getPontos());
        pst.setDate(3,new Date(ra.getData().getTime()));
        
        pst.executeUpdate();
        retorno = true ;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno ;
        
    }
   
     public List<Ranking> listar()
     {
         List<Ranking> lista = new ArrayList<Ranking> ();
         String sql = "SELECT * FROM ranking order by pontos desc";
         PreparedStatement pst = Conexao.getPreparedStatement(sql);
         try
         {
         ResultSet res = pst.executeQuery();
         while (res.next())
         {
             Ranking ra = new Ranking();
             ra.getJogador().setLogin(res.getString("login"));
             ra.setPontos(res.getDouble("pontos"));
             ra.setData(res.getDate("data"));
            //outro jeito
             //Jogador jog = new Jogador():
             //jog.setLogin(res.getString("login");
             //ranking.setJogador(jog);
             
             lista.add(ra);
         }
         }
         catch (SQLException ex )
         {
             Logger.getLogger(RankingDao.class.getName()).log(Level.SEVERE, null, ex);
         }
         return lista;
     }
     
}
