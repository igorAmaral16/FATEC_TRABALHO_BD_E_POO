package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import interfaces.ICadIngredienteDao;
import telas.Ingrediente;

public class CadIngredienteDao implements ICadIngredienteDao {
	private Connection con;
	
	public CadIngredienteDao() {
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
	public void criar(Ingrediente i) throws SQLException {
		String sql = "INSERT INTO ingrediente (nomeIngrediente, decricao) VALUES (?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, i.getNomeing());
			ps.setString(2, i.getDescricao());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(Ingrediente i) throws SQLException {
		String sql = "DELETE ingrediente WHERE nomeIngrediente = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, i.getNomeing());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Usuario deletado  com sucesso.");
			ps.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Ingrediente i) throws SQLException {
		String sql = "ALTER COLUMN ingrediente SET descricao = ? WHERE nomeIngrediente = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, i.getDescricao());
			ps.setString(2, i.getNomeing());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void buscar(Ingrediente i) throws SQLException {
		String sql = "SELECT * from ingrediente WHERE nomeIgredente = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, i.getNomeing());
		
		ResultSet rs = ps.executeQuery();
		
	}

}
