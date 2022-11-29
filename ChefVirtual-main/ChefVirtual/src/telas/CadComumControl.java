package telas;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class CadComumControl {
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty sobrenome = new SimpleStringProperty("");
	private StringProperty user = new SimpleStringProperty("");
	private StringProperty email = new SimpleStringProperty("");
	private StringProperty senha = new SimpleStringProperty("");
	private StringProperty nascimento = new SimpleStringProperty("");


	public CadComum boundaryToCadComum() {
		CadComum cad = new CadComum();
		cad.setNome(nome.get());
		cad.setSobrenome(sobrenome.get());
		cad.setUser(user.get());
		cad.setNascimento(nascimento.get());
		cad.setEmail(email.get());
		cad.setSenha(senha.get());
		return cad;
				
	}
	public void CadcomumToBoundary(CadComum cad) {
		if (cad != null) {
			nome.set(cad.getNome());
			sobrenome.set(cad.getSobrenome());
			user.set(cad.getUser());
			nascimento.set(cad.getNascimento());
			email.set(cad.getEmail());
			senha.set(cad.getSenha());
		}
	}

	public void clearBoundary() {
		CadComum cad = new CadComum();
		CadcomumToBoundary(cad);		
	}
	public void cadastrar() {
		LoginBoundary lg = new LoginBoundary();
		try {
			CadcomumBoundary.getStage().close();
			lg.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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
}
