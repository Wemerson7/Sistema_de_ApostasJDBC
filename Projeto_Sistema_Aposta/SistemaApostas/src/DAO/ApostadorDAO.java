package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexao.ConnectionFactory;

import pojo.Apostador;

public class ApostadorDAO {
	private Connection conexao;

	public ApostadorDAO() {

	}
	//INSERT 1
	public boolean addApostador(Apostador apd) {
		String sql = "INSERT INTO Apostador(id_apostador, nome_apostador, ganho, pontos) VALUES(?, ?, ?, ?)";
		this.conexao = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, apd.getId_apostador());
			stmt.setString(2, apd.getNome_apostador());
			stmt.setDouble(3, apd.getGanho());
			stmt.setInt(4, apd.getPontos());


			int qtdLinhasAfetadas = stmt.executeUpdate();
			stmt.close();

			if (qtdLinhasAfetadas > 0)
				return true;
			return false;
		} catch (SQLException e) {
			//System.err.println(e.getMessage());
		} finally {
			try {
				this.conexao.close();
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		}

		return false;
	}
	//DELETE 3
	//remover apostador
	public boolean deleteApostador(int id) {
		
		this.conexao = new ConnectionFactory().getConnection();
		String sql = "DELETE FROM Apostador WHERE id_apostador = "+id+"";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			int qtdLinhasAfetadas = stmt.executeUpdate();
			stmt.close();
			if (qtdLinhasAfetadas > 0)
				return true;
			return false;
		} catch (SQLException e) {
			System.out.println("Erro ao remover | id nao encontrada!!!");
			//System.err.println(e.getMessage());
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
	public ArrayList<Apostador> listaApostadores() {
		String sql = "SELECT * FROM Apostador";
		ArrayList<Apostador> lista_Apostadores = new ArrayList<Apostador>();
		this.conexao = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id_apostador = rs.getInt("id_apostador");
				String nome_apostador = rs.getString("nome_apostador");
				double ganho = rs.getDouble("ganho");
				int pontos = rs.getInt("pontos");

				Apostador apostador = new Apostador(id_apostador,nome_apostador,ganho,pontos);

				lista_Apostadores.add(apostador);
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

		return lista_Apostadores;
	}
	//UPTADE 4
	public boolean atualizarApostador(Apostador apostador) {

		String sql = "UPDATE Apostador SET nome_apostador = ?, ganho = ?, pontos = ? WHERE id_apostador = ?";

		this.conexao = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, apostador.getNome_apostador());
			stmt.setDouble(2, apostador.getGanho());
			stmt.setInt(3, apostador.getPontos());
			stmt.setInt(4, apostador.getId_apostador());

			int qtdLinhasAfetadas = stmt.executeUpdate();
			stmt.close();

			if (qtdLinhasAfetadas > 0)
				return true;
			return false;
		} catch (SQLException e) {
			//System.err.println(e.getMessage());
		} finally {
			try {
				this.conexao.close();
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		}

		return false;
	}
	//Buscar Apostador 6
	public Apostador buscarApostador(int id) {
		String sql = "SELECT * FROM Apostador WHERE id_apostador = ?;";

		this.conexao = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);

			//stmt.execute();

			ResultSet rs =  stmt.executeQuery();
			rs.next();

			Apostador apostador = new Apostador(id, rs.getString("nome_apostador"), rs.getDouble("ganho"), rs.getInt("pontos"));

			stmt.close();
			return apostador;
		} catch (SQLException e) {
			//System.err.println(e.getMessage());
		} finally {
			try {
				this.conexao.close();
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		}

		return null;

	}



}
