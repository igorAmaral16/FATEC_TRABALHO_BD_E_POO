package interfaces;

import java.sql.SQLException;

import telas.CadRestaurante;

public interface ICadRestauranteDao {
	public void criar(CadRestaurante cr) throws SQLException;
	public void excluir(CadRestaurante cr) throws SQLException;
	public void alterar(CadRestaurante cr) throws SQLException;
	public void buscar(CadRestaurante cr) throws SQLException;
}
