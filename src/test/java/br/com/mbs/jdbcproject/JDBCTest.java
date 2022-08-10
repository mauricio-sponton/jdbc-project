package br.com.mbs.jdbcproject;

import java.util.List;

import org.junit.Test;

import br.com.mbs.jdbcproject.connection.SingleConnection;
import br.com.mbs.jdbcproject.dao.UsuarioDAO;
import br.com.mbs.jdbcproject.model.Usuario;

public class JDBCTest {

	@Test
	public void initBD() {
		SingleConnection.getConnection();
	}

	@Test
	public void inserirUsuario() {

		var usuarioDAO = new UsuarioDAO();
		var usuario = new Usuario();

		usuario.setId(2L);
		usuario.setNome("Jordana");
		usuario.setEmail("mauricio@gmail.com");

		usuarioDAO.salvar(usuario);
	}
	
	@Test
	public void listarUsuario() {
		
		var usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.listar();
		
		for(Usuario usuario : lista) {
			System.out.println(usuario);
			System.out.println("---------------------------------");
		}
	}
	
	@Test
	public void buscarUsuarioPorId() {
		var usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(2L);
		System.out.println(usuario);
	}

}
