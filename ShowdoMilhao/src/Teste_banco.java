import dao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Jogador;
public class Teste_banco {
     //psvm + tab cria automaticamente essa merdinha daqui de baixo. 
    public static void main(String[] args) throws SQLException {
    inserir();
                List <Jogador> jogadores  = listar();
        for ( Jogador jogador : jogadores) {
            System.out.println(jogador.getLogin() + "");        
            
        }
    }
       
    
    
        public static void inserir() throws SQLException{
        String login, senha, email ;
            senha = JOptionPane.showInputDialog("senha");
            login = JOptionPane.showInputDialog("Login");      
            
            email = JOptionPane.showInputDialog("email");
        String sql;
        sql = "INSERT INTO JOGADOR (LOGIN, SENHA, EMAIL)"
                + "VALUES ('"+login+"', '"+senha+"', '"+email+"')";
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        pst.executeUpdate();
                }
        
                public static List <Jogador> listar () throws SQLException
        {
            List <Jogador> jogadores  = new ArrayList<Jogador>();
            String sql = "select * from jogador";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);       
            ResultSet res = pst.executeQuery();
            while (res.next()){
                Jogador Usu = new Jogador ();
                
                Usu.setLogin(res.getString("login"));
                Usu.setSenha(res.getString("senha"));
                Usu.setEmail(res.getString("email"));
                
                jogadores.add(Usu);
            }return jogadores;
        }
}