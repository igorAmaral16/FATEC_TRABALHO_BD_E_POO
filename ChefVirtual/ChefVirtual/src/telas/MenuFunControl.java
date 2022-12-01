package telas;

import javafx.stage.Stage;

public class MenuFunControl {
	

	public void addReceita() {
		ReceitaBoundary rb = new ReceitaBoundary();
		try {
			MenuFunBoundary.getStage().close();
			rb.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
	}
		
	}
	public void addFac() {
		FAQFuncionarioBoundary fqf = new FAQFuncionarioBoundary();
		try {
			MenuFunBoundary.getStage().close();
			fqf.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void minhaConta() {
		System.out.println("foiminhaconta");
		
	}
	public void adicionarIng() {
		IngredienteBoundary igb = new IngredienteBoundary();
		try {
			MenuFunBoundary.getStage().close();
			igb.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}