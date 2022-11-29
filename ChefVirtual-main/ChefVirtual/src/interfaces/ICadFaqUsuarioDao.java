package interfaces;

import java.sql.SQLException;
import java.util.List;

import telas.FAQUsuario;

public interface ICadFaqUsuarioDao {
	public void criar(FAQUsuario fu) throws SQLException;
	public void excluir(FAQUsuario fu) throws SQLException;
	public void alterar(FAQUsuario fu) throws SQLException;
	public List<FAQUsuario> buscar() throws SQLException;
}
