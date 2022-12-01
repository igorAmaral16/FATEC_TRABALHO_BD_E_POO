package interfaces;

import java.sql.SQLException;

import telas.Ingrediente;

public interface ICadIngredienteDao {
	public void criar(Ingrediente i) throws SQLException;
	public void excluir(Ingrediente i) throws SQLException;
	public void alterar(Ingrediente i) throws SQLException;
	public void buscar( Ingrediente i) throws SQLException;
}
