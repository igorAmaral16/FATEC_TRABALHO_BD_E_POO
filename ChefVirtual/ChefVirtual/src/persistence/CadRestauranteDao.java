package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import interfaces.ICadRestauranteDao;
import telas.CadRestaurante;

public class CadRestauranteDao implements ICadRestauranteDao{
	private Connection con;
	
	public CadRestauranteDao() {
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
	public void criar(CadRestaurante cr) throws SQLException {
String sql = "INSERT INTO usuariorestaurante (cnpj, nome, senha, email) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, cr.getCnpj());
			ps.setString(2, cr.getNome());
			ps.setString(3, cr.getSenha());
			ps.setString(4, cr.getEmail());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(CadRestaurante cr) throws SQLException {
		String sql = "DELETE usuariochef WHERE cpfChef = ?";
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, cr.getCnpj());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Usuario deletado  com sucesso.");
			ps.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(CadRestaurante cr) throws SQLException {
		String sql = "ALTER COLUMN usuariorestaurante SET nome = ?, senha = ?, email = ? WHERE cnpj = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, cr.getNome());
			ps.setString(2, cr.getSenha());
			ps.setString(3, cr.getEmail());
			ps.setLong(4, cr.getCnpj());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void buscar(CadRestaurante cr) throws SQLException {
		String sql = "SELECT "
				+ "SUBSTRING(ur.nome,1, LEN(ur.nome)) AS nome,"
				+ "rt.nome, rt.descricao FROM usuariorestaurante ur, receita rt, receita_restaurante rr WHERE ur.cnpj = rr.idRest AND rt.idReceita = rc.idRec AND cnpj = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setLong(1, cr.getCnpj());
		
		ResultSet rs = ps.executeQuery();
		
	}

}
