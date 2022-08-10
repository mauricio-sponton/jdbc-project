package br.com.mbs.jdbcproject;

import org.junit.Test;

import br.com.mbs.jdbcproject.connection.SingleConnection;

public class JDBCTest {
	
	@Test
	public void initBD() {
		SingleConnection.getConnection();
	}

}
