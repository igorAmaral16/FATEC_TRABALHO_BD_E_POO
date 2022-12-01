package telas;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import persistence.CadComumDao;

public class CadComumControl {
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty sobrenome = new SimpleStringProperty("");
	private StringProperty user = new SimpleStringProperty("");
	private StringProperty email = new SimpleStringProperty("");
	private StringProperty senha = new SimpleStringProperty("");
	private StringProperty nascimento = new SimpleStringProperty("");


	private CadComumDao cDao = new CadComumDao();
	
	public CadComum getEntity() {
		CadComum cc = new CadComum();

		cc.setNome(nome.get());
		cc.setSobrenome(sobrenome.get());
		cc.setUser(user.get());
		cc.setNascimento(nascimento.get());
		cc.setEmail(email.get());
		cc.setSenha(senha.get());
		
		return cc;
	}
	
	public void inserir() {
		verificarDados();
		
		if(verificarDados() == true) {
			
			CadComum cc = getEntity();
			
			try {
				cDao.criar(cc);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "CADASTRO FEITO COM SUCESSO!!", "",  JOptionPane.WARNING_MESSAGE );
			limpar();
			
		} else {
			JOptionPane.showMessageDialog(null, "COMPLETE TODOS OS CAMPOS PARA SE CADASTRAR", "CAMPOS VAZIOS",  JOptionPane.WARNING_MESSAGE );
			
			CadcomumBoundary cc = new CadcomumBoundary();
			
			try {
				CadcomumBoundary.getStage().close();
				cc.start(new Stage());			
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		

	}
	
	public boolean verificarDados() { 
		boolean ver = false;
		
		if(		nome.get().isEmpty()
				||	sobrenome.get().isEmpty()
				||	nascimento.get().isEmpty()
				||	email.get().isEmpty()
				||	senha.get().isEmpty()) {
			ver = false;
		} else {
			ver = true;
		}
		
		return ver;
	}
	
	public void cadastroChef() {
		CadChefBoundary cdf = new CadChefBoundary();
		try {
			CadcomumBoundary.getStage().close();
			cdf.start(new Stage());			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	public void cadastroRestaurante() {
		CadRestauranteBoundary cdf = new CadRestauranteBoundary();
		try {
			CadcomumBoundary.getStage().close();
			cdf.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public StringProperty nomeProperty() {
		return this.nome;
	}
	public StringProperty sobrenomeProperty() {
		return this.sobrenome;
	}
	public StringProperty userProperty() {
		return this.user;
	}
	public StringProperty senhaProperty() {
		return this.senha;
	}		
	public StringProperty emailProperty() {
		return this.email;
	}
	public StringProperty nascimentoProperty() {
		return this.nascimento;
	}
	
	public void  limpar() {
		nome.set("");
		sobrenome.set("");
		user.set("");
		email.set("");
		senha.set("");
		nascimento.set("");
	}
}
