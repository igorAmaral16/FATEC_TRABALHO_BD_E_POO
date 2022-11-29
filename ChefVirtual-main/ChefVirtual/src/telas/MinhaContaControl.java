package telas;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class MinhaContaControl {
	
	private StringProperty sobrenome = new SimpleStringProperty("");
	private StringProperty senha = new SimpleStringProperty("");
	private StringProperty email = new SimpleStringProperty("");
	private StringProperty nome = new SimpleStringProperty("");
	
	public MinhaConta boundaryToMinhaConta() {
		MinhaConta mc = new MinhaConta();
		mc.setNome( nome.get());
		mc.setSobrenome(sobrenome.get());
		mc.setEmail(email.get());
		return mc;
	}

	public void MinhaContaToBoundary(MinhaConta mc) {
		if (mc != null) {
			nome.set(mc.getNome());
			senha.set(mc.getSenha());
			sobrenome.set(mc.getSobrenome());
			email.set(mc.getEmail());
			
		}
		
	}
	public void salvar() {
		//msg de dados atualizados

	}
	public void excluir() {
		CadcomumBoundary cdc = new CadcomumBoundary();
		try {
			MinhaContaBoundary.getStage().close();
			cdc.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
