package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import interfaces.ICadChefDao;
import telas.CadChef;

public class CadChefDao implements ICadChefDao {
	private Connection con;
	
	public CadChefDao() {
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
	public void criar(CadChef cf) {
		String sql = "INSERT INTO usuariochef (cpfChef, nome, sobrenome, dataNasc, email, senha, certificado) VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, cf.getCpf());
			ps.setString(2, cf.getNome());
			ps.setString(3, cf.getSobrenome());
			ps.setString(4, cf.getNascimento());
			ps.setString(5, cf.getEmail());
			ps.setString(6, cf.getSenha());
			ps.setString(7, cf.getCertificado());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void excluir(CadChef cf) {
		String sql = "DELETE usuariochef WHERE cpfChef = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, cf.getCpf());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Usuario deletado  com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(CadChef cf) {
		String sql = "ALTER COLUMN usuariochef SET nome = ?, sobrenome = ?, dataNasc = ?, email = ?, senha = ?, certificado = ? WHERE cpfChef = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, cf.getNome());
			ps.setString(2, cf.getSobrenome());
			ps.setString(3, cf.getNascimento());
			ps.setString(4, cf.getEmail());
			ps.setString(5, cf.getSenha());
			ps.setString(6, cf.getCertificado());
			ps.setLong(5, cf.getCpf());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void buscar(CadChef cf) throws SQLException {
		String sql = "SELECT "
				+ "SUBSTRING(uc.nome,1, LEN(uc.nome)) + ' ' + SUBSTRING(uc.sobrenome,1,LEN(uc.sobrenome) AS nomeCompleto,"
				+ "rt.nome, rt.descricao FROM usuariochef uc, receita rt, receita_chef rc WHERE uc.cpfChef = rc.idChef AND rt.idReceita = rc.idRec AND cpfChef = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setLong(1, cf.getCpf());
		
		ResultSet rs = ps.executeQuery();
		
	}

}
