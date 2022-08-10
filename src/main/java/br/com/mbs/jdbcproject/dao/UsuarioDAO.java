package br.com.mbs.jdbcproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mbs.jdbcproject.connection.SingleConnection;
import br.com.mbs.jdbcproject.model.Usuario;

public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(Usuario usuario) {

		try {
			String sql = "insert into usuario (id, nome, email) values (?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, usuario.getId());
			insert.setString(2, usuario.getNome());
			insert.setString(3, usuario.getEmail());
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

	public List<Usuario> listar() {

		List<Usuario> lista = new ArrayList<>();

		try {

			String sql = "select * from usuario";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {

				Usuario usuario = new Usuario();
				usuario.setId(resultado.getLong("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setEmail(resultado.getString("email"));
				lista.add(usuario);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Usuario buscarPorId(Long id) {

		Usuario usuario = new Usuario();

		try {

			String sql = "select * from usuario where id = " + id;
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {
				usuario.setId(resultado.getLong("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setEmail(resultado.getString("email"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public void atualizar(Usuario usuario) {

		try {
			String sql = "update usuario set nome = ?, email = ? where id = " + usuario.getId();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getEmail());
			statement.execute();
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

}
