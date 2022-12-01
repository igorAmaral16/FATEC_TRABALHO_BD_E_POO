package interfaces;

import java.sql.SQLException;

import telas.Funcionario;

public interface ICadFuncionarioDao {
	public void criar(Funcionario f) throws SQLException;
	public void excluir(Funcionario f) throws SQLException;
	public void alterar(Funcionario f) throws SQLException;
	public void buscar(Funcionario f) throws SQLException;
	
}
