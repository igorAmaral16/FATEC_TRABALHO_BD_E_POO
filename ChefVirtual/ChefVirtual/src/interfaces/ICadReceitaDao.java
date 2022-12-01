package interfaces;

import java.sql.SQLException;

import telas.Receita;

public interface ICadReceitaDao {
	public void criar(Receita rc) throws SQLException;
	public void excluir(Receita rc) throws SQLException;
	public void alterar(Receita rc) throws SQLException;
	public void buscar(Receita rc) throws SQLException;
}
