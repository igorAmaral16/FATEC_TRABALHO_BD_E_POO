package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import interfaces.ICadComumDao;
import telas.CadComum;

public class CadComumDao implements ICadComumDao {
	
	private Connection con;
	
	public CadComumDao() {
		String hostName = "localhost";
		String dbName = "chefvirtual";
		String user = "sa";
		String senha = "123456";
		
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection(String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s",hostName, dbName, user, senha));
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

	@Override
	public void criar(CadComum cc) throws SQLException {
		String sql = "INSERT INTO usuariocomum (apelido, nome, sobrenome, dataNasc, senha, email) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, cc.getUser());
			ps.setString(2, cc.getNome());
			ps.setString(3, cc.getSobrenome());
			ps.setString(4, cc.getNascimento());
			ps.setString(5, cc.getSenha());
			ps.setString(6, cc.getEmail());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(CadComum cc) throws SQLException {
		String sql = "DELETE usuariocomum WHERE cpfChef = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, cc.getUser());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Usuario deletado  com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(CadComum cc) throws SQLException {
		String sql = "ALTER COLUMN usuariocomum SET nome = ?, sobrenome = ?, dataNasc = ?, email = ?, senha = ? WHERE apelido = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, cc.getNome());
			ps.setString(2, cc.getSobrenome());
			ps.setString(3, cc.getNascimento());
			ps.setString(4, cc.getEmail());
			ps.setString(5, cc.getSenha());
			ps.setString(5, cc.getUser());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void buscar(CadComum cc) throws SQLException {
		String sql = "SELECT "
				+ "SUBSTRING(nome,1, LEN(nome)) + ' ' + SUBSTRING(sobrenome,1,LEN(sobrenome) AS nomeCompleto FROM usuariocomum WHERE apelido = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, cc.getUser());
		
		ResultSet rs = ps.executeQuery();
		
	}

}
