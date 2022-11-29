package telas;

import javafx.stage.Stage;

public class MenuControl {
	

	public void addReceita() {
		ReceitaBoundary rb = new ReceitaBoundary();
		try {
			MenuBoundary.getStage().close();
			rb.start(new Stage());
		} catch (Exception e) {
		}
	}
	public void enviarFac() {
		FAQUsuarioBoundary fq = new FAQUsuarioBoundary();
		try {
			MenuBoundary.getStage().close();
			fq.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	public void minhaConta() {
		MinhaContaBoundary mcb = new MinhaContaBoundary();
		try {
			MenuBoundary.getStage().close();
			mcb.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void minhasRec() {
		ViewReceitaBoundary rc = new ViewReceitaBoundary();
		try {
			MenuBoundary.getStage().close();
			rc.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}


