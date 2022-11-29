package telas;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class CadRestauranteControl {
	private StringProperty nome = new SimpleStringProperty("");
	private LongProperty cnpj = new SimpleLongProperty(0);
	private StringProperty email = new SimpleStringProperty("");
	private StringProperty senha = new SimpleStringProperty("");

	public CadRestaurante boundaryToCadRestaurante() {
		CadRestaurante cadres = new CadRestaurante();
		cadres.setNome(nome.get());
		cadres.setCnpj(cnpj.get());
		cadres.setEmail(email.get());
		cadres.setSenha(senha.get());
		return cadres;
	}
	public void CadRestauranteToBoundary(CadRestaurante cadres) {
		if (cadres != null) {
			nome.set(cadres.getNome());
			cnpj.set(cadres.getCnpj());
			email.set(cadres.getEmail());
			senha.set(cadres.getSenha());
		}
	}
	public void clearBoundary() {
		CadRestaurante cadres = new CadRestaurante();
		CadRestauranteToBoundary(cadres);
					
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

}



	
	
	


