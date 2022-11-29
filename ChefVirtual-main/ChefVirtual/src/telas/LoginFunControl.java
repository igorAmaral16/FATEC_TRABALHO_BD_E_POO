package telas;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class LoginFunControl {
		private StringProperty email = new SimpleStringProperty("");
		private StringProperty senha = new SimpleStringProperty("");
		
		public LoginFun boundaryTologinfun() {
			LoginFun func = new LoginFun();
			func.setEmail(email.get());
			func.setSenha(senha.get());
			return func;
		}

		public void LoginFunToBoundary(LoginFun func) {
			if (func != null) {
				email.set(func.getEmail());
				senha.set(func.getSenha());
			}
			
		}
		public void entrar() {
			MenuFunBoundary mfb = new MenuFunBoundary();
			try {
				LoginFunBoundary.getStage().close();
				mfb.start(new Stage());
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		public void cadastrar() {
			FuncionarioBoundary fb = new FuncionarioBoundary();
			try {
				LoginFunBoundary.getStage().close();
				fb.start(new Stage());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}


