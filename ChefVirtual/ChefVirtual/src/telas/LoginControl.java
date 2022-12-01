package telas;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class LoginControl {
	private StringProperty email = new SimpleStringProperty("");
	private StringProperty senha = new SimpleStringProperty("");
	
	public Login boundaryToLogin() {
		Login login = new Login();
		login.setEmail(email.get());
		login.setSenha(senha.get());
		return login;
	}

	public void LoginToBoundary(Login login) {
		if (login != null) {
			email.set(login.getEmail());
			senha.set(login.getSenha());
		}
		
	}
	public void entrar() {

	}
	public void cadastrar() {
		CadcomumBoundary cdc = new CadcomumBoundary();
		try {
			LoginBoundary.getStage().close();
			cdc.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
