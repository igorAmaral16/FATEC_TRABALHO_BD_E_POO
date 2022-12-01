package telas;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import persistence.CadChefDao;
import persistence.CadRestauranteDao;

public class CadRestauranteControl {
	private StringProperty nome = new SimpleStringProperty("");
	private LongProperty cnpj = new SimpleLongProperty(0);
	private StringProperty email = new SimpleStringProperty("");
	private StringProperty senha = new SimpleStringProperty("");
	
private CadRestauranteDao cDao = new CadRestauranteDao();
	
	public CadRestaurante getEntity() {
		CadRestaurante cr = new CadRestaurante();
		
		cr.setCnpj(cnpj.get());
		cr.setNome(nome.get());
		cr.setEmail(email.get());
		cr.setSenha(senha.get());
		
		return cr;
	}
	
	public void inserir() {
		verificarDados();
		
		if(verificarDados() == false) {
			CadRestaurante cr = getEntity();
			try {
				cDao.criar(cr);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "CADASTRO FEITO COM SUCESSO!!", "",  JOptionPane.WARNING_MESSAGE );
			
			limpar();
			
		} else {
			JOptionPane.showMessageDialog(null, "COMPLETE TODOS OS CAMPOS PARA SE CADASTRAR", "CAMPOS VAZIOS",  JOptionPane.WARNING_MESSAGE );
			
			CadRestauranteBoundary cr = new CadRestauranteBoundary();

				try {
					CadChefBoundary.getStage().close();
					cr.start(new Stage());
				} catch (Exception e) {
					// TODO: handle exception
				}
		}
		
	}
	
	public void pesquisar() {
		
	}
	
	public boolean verificarDados() { 
		boolean ver = false;
		
		if((		nome.get().isEmpty()
				||	email.get().isEmpty()
				||	senha.get().isEmpty())) {
			ver = true;
			
		} else { 
			ver = false;
		}
		
		return ver;
	}

	public void cadastrar() {
		LoginBoundary lg = new LoginBoundary();
		try {
			CadRestauranteBoundary.getStage().close();
			lg.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void cadastroComum() {
		CadcomumBoundary cdc = new CadcomumBoundary();
		try {
			CadRestauranteBoundary.getStage().close();
			cdc.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}


		
	}
	public void cadastroChef() {
		CadChefBoundary cdf = new CadChefBoundary();
		try {
			CadRestauranteBoundary.getStage().close();
			cdf.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public StringProperty nomeProperty() {
		return this.nome;
	}

	public LongProperty userProperty() {
		return this.cnpj;
	}
	public StringProperty senhaProperty() {
		return this.senha;
	}		
	public StringProperty emailProperty() {
		return this.email;
	}
	
	public void  limpar() {
		nome.set("");
		cnpj.set(0);
		email.set("");
		senha.set("");
	}

}



	
	
	


