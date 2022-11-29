package interfaces;

import java.sql.SQLException;

import telas.CadChef;

public interface ICadChefDao {
	
	public void criar(CadChef cf) throws SQLException;
	public void excluir(CadChef cf) throws SQLException;
	public void alterar(CadChef cf) throws SQLException;
	public void buscar(CadChef cf) throws SQLException;

}
