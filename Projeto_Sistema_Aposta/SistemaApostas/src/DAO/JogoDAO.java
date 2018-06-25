package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexao.ConnectionFactory;
import pojo.Jogo;

public class JogoDAO {
	private Connection conexao;

	public JogoDAO() {

	}
	//INSERT 1
	public boolean addJogo(Jogo jogo) {
		String sql = "INSERT INTO Jogo(time1, time2, placar, id_jogo) VALUES(?, ?, ?, ?)";
		this.conexao = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, jogo.getTime1());
			stmt.setString(2, jogo.getTime2());
			stmt.setString(3, jogo.getPlacar());
			stmt.setInt(4, jogo.getId_jogo());


			int qtdLinhasAfetadas = stmt.executeUpdate();
			stmt.close();

			if (qtdLinhasAfetadas > 0)
				return true;
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
	public ArrayList<Jogo> listaJogos() {
		String sql = "SELECT * FROM Jogo";
		ArrayList<Jogo> lista_Jogos = new ArrayList<Jogo>();

		this.conexao = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id_jogo = rs.getInt("id_jogo");
				String time1 = rs.getString("time1");
				String time2 = rs.getString("time2");
				String placar = rs.getString("placar");


				Jogo jogo = new Jogo(time1,time2,placar,id_jogo);

				lista_Jogos.add(jogo);
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

		return lista_Jogos;
	}


}

