package telas;

import javafx.stage.Stage;

public class ViewReceitaControl {
	


	public void voltar() {
		MenuBoundary mb = new MenuBoundary();
		try {
			ViewReceitaBoundary.getStage().close();
			mb.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}


