package telas;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class FuncionarioControl {
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty sobrenome = new SimpleStringProperty("");
	private StringProperty cpf = new SimpleStringProperty("");
	private StringProperty email = new SimpleStringProperty("");
	private StringProperty senha = new SimpleStringProperty("");
	
	
	public void cadastrar() {
		LoginFunBoundary lf = new LoginFunBoundary();
		try {
			FuncionarioBoundary.getStage().close();
			lf.start(new Stage());			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
