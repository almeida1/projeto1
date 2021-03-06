package br.sceweb.servico;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public class FabricaDeConexoes {

	//String url = "jdbc:mysql://localhost/sceweb";
	//String driver = "com.mysql.jdbc.Driver";
	//String usuario = "root";
	//String senha = "";
	
	
	String url = "jdbc:mysql://mysql8.db4free.net:3307/sceweb";
	String driver = "com.mysql.jdbc.Driver";
	String usuario = "alunos";
	String senha = "alunos";

	public FabricaDeConexoes(ConfiguraDB configura) {
		this.url = configura.getUrl();
		this.driver = configura.getDriver();
		this.usuario = configura.getUsuario();
		this.senha = configura.getSenha();
	}

	public FabricaDeConexoes() {

	}

	public Connection getConnection() {
		String msg;
		try {
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(url, usuario, senha);
		} catch (CommunicationsException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException("Erro de SQL = " + e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	}
}
