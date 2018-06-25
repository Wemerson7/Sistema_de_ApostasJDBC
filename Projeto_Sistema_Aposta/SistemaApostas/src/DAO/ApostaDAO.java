package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Conexao.ConnectionFactory;
import pojo.Aposta;

public class ApostaDAO {
    private Connection conexao;
    
    public ApostaDAO() {
        conexao = new ConnectionFactory().getConnection();
    }
    
    public boolean realizarAposta(Aposta a) {
    	 
    	String sql = "INSERT INTO Aposta(id_aposta, gols,resultado,total_pontos,id_jogo,id_apostador)"
    			+ " VALUES(?,?,?,?,?,?)";
        
        this.conexao = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, a.getId_aposta());
            stmt.setString(2, a.getGols());
            stmt.setString(3, a.getResultado());
            stmt.setInt(4, a.getTotalPontos());
            stmt.setInt(5, a.getId_jogo());
            stmt.setInt(6, a.getId_apostador());
            
            
            int qtdLinhasAfetadas = stmt.executeUpdate();
           
            stmt.close();
            if(qtdLinhasAfetadas > 0)
                return true;
            System.out.println("aqui 1");
            return false;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                this.conexao.close();
            } catch (SQLException e) {
                //e.printStackTrace();
            }
        }
        return false;
    }
    
  //SELECT  2
    public ArrayList<Aposta> listaApostas() {
        String sql = "SELECT * FROM Aposta";
        ArrayList<Aposta> lista_Apostas = new ArrayList<Aposta>();
        
        this.conexao = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id_aposta = rs.getInt("id_aposta");
                String gols = rs.getString("gols");
                String resultado = rs.getString("resultado");
                int id_jogo = rs.getInt("id_jogo");
                int id_apostador = rs.getInt("id_apostador");
                
               
                Aposta aposta = new Aposta(id_aposta, gols, resultado, id_jogo, id_apostador);
                
                lista_Apostas.add(aposta);
            }
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                this.conexao.close();
            } catch (SQLException e) {
               // e.printStackTrace();
            }
        }
        return lista_Apostas;
    }
    
    
    
}

