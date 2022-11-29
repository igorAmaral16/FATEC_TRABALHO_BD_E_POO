package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import interfaces.ICadFaqFuncionarioDao;
import telas.FAQFuncionario;

public class CadFaqFuncionarioDao implements ICadFaqFuncionarioDao{
	private Connection con;
	
	public CadFaqFuncionarioDao() {
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
	public void criar(FAQFuncionario ff) throws SQLException {
		String sql = "INSERT INTO faqfunc (nomeDuvida, respostaDuvida,) VALUES (?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, ff.getPergunta());
			ps.setString(2, ff.getResposta());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Pergunta efetuada com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(FAQFuncionario ff) throws SQLException {
		String sql = "DELETE faqfunc WHERE nomeDuvida = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, ff.getPergunta());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "pergunta deletada  com sucesso.");
			ps.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(FAQFuncionario ff) throws SQLException {
		String sql = "ALTER COLUMN faqfunc SET respostaDuvida = ? WHERE nomeDuvida = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, ff.getResposta());
			ps.setString(2, ff.getPergunta());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "resposta alterada com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<FAQFuncionario> buscar() throws SQLException {
		List<FAQFuncionario> lista = new ArrayList<>();
		
		String sql = "SELECT * from faqfunc WHERE nomeDuvida = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			FAQFuncionario ff = new FAQFuncionario();
			ff.setPergunta(rs.getString("nomeDuvida"));
			ff.setResposta(rs.getString("respostaDuvida"));
			
			lista.add(ff);
		}
		return lista;
	}

}
