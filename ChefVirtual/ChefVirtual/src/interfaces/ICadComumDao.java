package interfaces;

import java.sql.SQLException;
import telas.CadComum;

public interface ICadComumDao {
	public void criar(CadComum cc) throws SQLException;
	public void excluir(CadComum cf) throws SQLException;
	public void alterar(CadComum cf) throws SQLException;
	public void buscar(CadComum cf) throws SQLException;

}
