package interfaces;

import java.sql.SQLException;
import java.util.List;

import telas.FAQFuncionario;

public interface ICadFaqFuncionarioDao {
	public void criar(FAQFuncionario ff) throws SQLException;
	public void excluir(FAQFuncionario ff) throws SQLException;
	public void alterar(FAQFuncionario ff) throws SQLException;
	public List<FAQFuncionario> buscar() throws SQLException;
}
