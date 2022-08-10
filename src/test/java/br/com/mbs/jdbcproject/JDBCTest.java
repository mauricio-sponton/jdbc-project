package br.com.mbs.jdbcproject;

import java.util.List;

import org.junit.Test;

import br.com.mbs.jdbcproject.connection.SingleConnection;
import br.com.mbs.jdbcproject.dao.TelefoneDAO;
import br.com.mbs.jdbcproject.dao.UsuarioDAO;
import br.com.mbs.jdbcproject.model.ProjecaoTelefone;
import br.com.mbs.jdbcproject.model.Telefone;
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

		usuario.setNome("Mauricio");
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
	
	@Test
	public void atualizarUsuario() {
		var usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(1L);
		usuario.setNome("Alcione");
		usuario.setEmail("teste@gmail.com");
		usuarioDAO.atualizar(usuario);
	}
	
	@Test
	public void deletarUsuario() {
		var usuarioDAO = new UsuarioDAO();
		usuarioDAO.delete(1L);
	}
	
	@Test
	public void inserirTelefone() {
		var telefone = new Telefone();
		telefone.setNumero("(13) 9 9933 4005");
		telefone.setTipo("Celular");
		telefone.setUsuario(1L);
		
		var telefoneDAO = new TelefoneDAO();
		telefoneDAO.salvar(telefone);
	}
	
	@Test
	public void listarTelefone() {
		
		var telefoneDAO = new TelefoneDAO();
		List<Telefone> lista = telefoneDAO.listar();
		
		for(Telefone telefone : lista) {
			System.out.println(telefone);
			System.out.println("---------------------------------");
		}
	}
	
	@Test
	public void buscarTelefonePorId() {
		var telefoneDAO = new TelefoneDAO();
		Telefone telefone = telefoneDAO.buscarPorId(2L);
		System.out.println(telefone);
	}
	
	@Test
	public void listarProjecao() {
		
		var telefoneDAO = new TelefoneDAO();
		List<ProjecaoTelefone> lista = telefoneDAO.listarProjecao(2L);
		
		for(ProjecaoTelefone projecao : lista) {
			System.out.println(projecao);
			System.out.println("---------------------------------");
		}
	}
	
	@Test
	public void deletarTelefone() {
		
		var telefoneDAO = new TelefoneDAO();
		telefoneDAO.delete(1L);
	}

}
