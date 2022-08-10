package br.com.mbs.jdbcproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mbs.jdbcproject.connection.SingleConnection;
import br.com.mbs.jdbcproject.model.ProjecaoTelefone;
import br.com.mbs.jdbcproject.model.Telefone;

public class TelefoneDAO {

	private Connection connection;

	public TelefoneDAO() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(Telefone telefone) {

		try {
			String sql = "insert into telefone (numero, tipo, usuario_fk) values (?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, telefone.getNumero());
			insert.setString(2, telefone.getTipo());
			insert.setLong(3, telefone.getUsuario());
			insert.execute();
			connection.commit();

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public List<Telefone> listar() {

		List<Telefone> lista = new ArrayList<>();

		try {

			String sql = "select * from telefone";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {

				Telefone telefone = new Telefone();
				telefone.setId(resultado.getLong("id"));
				telefone.setNumero(resultado.getString("numero"));
				telefone.setTipo(resultado.getString("tipo"));
				telefone.setUsuario(resultado.getLong("usuario_fk"));
				lista.add(telefone);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<ProjecaoTelefone> listarProjecao(Long usuarioId) {

		List<ProjecaoTelefone> lista = new ArrayList<>();

		try {

			String sql = "select nome, numero, email from telefone as fone inner join usuario as usuario on fone.usuario_fk = usuario.id where usuario.id = " + usuarioId;
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {

				ProjecaoTelefone projecao = new ProjecaoTelefone();
				projecao.setNome(resultado.getString("nome"));
				projecao.setNumero(resultado.getString("numero"));
				projecao.setEmail(resultado.getString("email"));
				lista.add(projecao);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Telefone buscarPorId(Long id) {

		var telefone = new Telefone();

		try {

			String sql = "select * from telefone where id = " + id;
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {
				telefone.setId(resultado.getLong("id"));
				telefone.setNumero(resultado.getString("numero"));
				telefone.setTipo(resultado.getString("tipo"));
				telefone.setUsuario(resultado.getLong("usuario_fk"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return telefone;
	}

//	public void atualizar(Usuario usuario) {
//
//		try {
//			String sql = "update usuario set nome = ?, email = ? where id = " + usuario.getId();
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setString(1, usuario.getNome());
//			statement.setString(2, usuario.getEmail());
//			statement.execute();
//			connection.commit();
//
//		} catch (SQLException e) {
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
//
//	}
//
//	public void delete(Long id) {
//
//		try {
//			String sql = "delete from usuario where id = " + id;
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.execute();
//
//			connection.commit();
//		} catch (SQLException e) {
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
//	}

}
