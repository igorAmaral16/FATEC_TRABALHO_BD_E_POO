package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import interfaces.ICadFaqUsuarioDao;
import telas.FAQFuncionario;
import telas.FAQUsuario;

public class CadFaqUsuario implements ICadFaqUsuarioDao{
	private Connection con;
	
	public CadFaqUsuario() {
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
	public void criar(FAQUsuario fu) throws SQLException {
		String sql = "INSERT INTO faqusuario (nomeDuvida) VALUES (?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, fu.getPergunta());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "Pergunta efetuada com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(FAQUsuario fu) throws SQLException {
		String sql = "DELETE faqusuario WHERE nomeDuvida = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, fu.getPergunta());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "pergunta deletada  com sucesso.");
			ps.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(FAQUsuario fu) throws SQLException {
		String sql = "ALTER COLUMN faqusuario SET nomeDuvidaUsuario = ? WHERE nomeDuvidaUsuario = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, fu.getPergunta());
			ps.execute();
			JOptionPane.showMessageDialog(null, "resposta alterada com sucesso.");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<FAQUsuario> buscar() throws SQLException {
		List<FAQUsuario> lista = new ArrayList<>();
		
		String sql = "SELECT * from faqusuario WHERE nomeDuvida = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			FAQUsuario fu = new FAQUsuario();
			fu.setPergunta(rs.getString("nomeDuvida"));
			
			lista.add(fu);
		}
		return lista;
	}

}
