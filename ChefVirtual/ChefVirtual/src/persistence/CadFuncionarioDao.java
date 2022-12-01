package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import interfaces.ICadFuncionarioDao;
import telas.Funcionario;

public class CadFuncionarioDao implements ICadFuncionarioDao{
	private Connection con;
	
	public CadFuncionarioDao() {
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
	public void criar(Funcionario f) throws SQLException {
		String sql = "INSERT INTO funcionario (cpfFunc, nome, sobrenome, email, senha) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, f.getCpf());
			ps.setString(2, f.getNome());
			ps.setString(3, f.getSobrenome());
			ps.setString(4, f.getEmail());
			ps.setString(5, f.getSenha());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(Funcionario f) throws SQLException {
		String sql = "DELETE funcionario WHERE cpfFunc = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, f.getCpf());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Usuario deletado  com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Funcionario f) throws SQLException {
		String sql = "ALTER COLUMN funcionario SET nome = ?, sobrenome = ?, email = ?, senha = ? WHERE cpfFunc = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, f.getNome());
			ps.setString(2, f.getSobrenome());
			ps.setString(3, f.getEmail());
			ps.setString(4, f.getSenha());
			ps.setLong(5, f.getCpf());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void buscar(Funcionario f) throws SQLException {
		String sql = "SELECT "
				+ "SUBSTRING(f.nome,1, LEN(f.nome)) + ' ' + SUBSTRING(f.sobrenome,1,LEN(f.sobrenome) AS nomeCompleto,"
				+ "rt.nome, rt.descricao FROM funcionario f, receita rt, receita_funcionario rf WHERE f.cpfFunc = rf.idFunc AND rt.idReceita = rf.idRec AND cpfFunc = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setLong(1, f.getCpf());
		
		ResultSet rs = ps.executeQuery();
	}

}
