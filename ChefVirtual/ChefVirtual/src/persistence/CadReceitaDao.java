package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import interfaces.ICadReceitaDao;
import telas.Receita;

public class CadReceitaDao implements ICadReceitaDao{
	private Connection con;
	
	public CadReceitaDao() {
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
	public void criar(Receita rc) throws SQLException {
		String sql = "INSERT INTO receita (nomeIngrediente, nomeReceita, decricao,) VALUES (?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, rc.getNomeing());
			ps.setString(2, rc.getNomerec());
			ps.setString(3, rc.getDescricaorec());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(Receita rc) throws SQLException {
		String sql = "DELETE receita WHERE nomeReceita = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, rc.getNomerec());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Usuario deletado  com sucesso.");
			ps.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Receita rc) throws SQLException {
		String sql = "ALTER COLUMN receita SET descricao = ? WHERE nomeReceita = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, rc.getDescricao());
			ps.setString(2, rc.getNomerec());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void buscar(Receita rc) throws SQLException {
		String sql = "SELECT * from receita WHERE nomeReceita = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, rc.getNomerec());
		
		ResultSet rs = ps.executeQuery();
		
	}

}
