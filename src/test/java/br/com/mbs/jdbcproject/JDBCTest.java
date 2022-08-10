package br.com.mbs.jdbcproject;

import org.junit.Test;

import br.com.mbs.jdbcproject.dao.UsuarioDAO;
import br.com.mbs.jdbcproject.model.Usuario;

public class JDBCTest {
	
	@Test
	public void initBD() {
		var usuarioDAO = new UsuarioDAO();
		var usuario = new Usuario();
		
		usuario.setId(2L);
		usuario.setNome("Jordana");
		usuario.setEmail("mauricio@gmail.com");
		
		usuarioDAO.salvar(usuario);
	}

}
