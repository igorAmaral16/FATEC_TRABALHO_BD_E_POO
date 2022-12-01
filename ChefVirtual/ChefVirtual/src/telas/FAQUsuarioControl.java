package telas;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class FAQUsuarioControl {
	private StringProperty pergunta = new SimpleStringProperty("");
	private ObservableList<FAQUsuario> lista = FXCollections.observableArrayList();


	public FAQUsuario boundaryToFAQUsuario() {
		FAQUsuario cadres = new FAQUsuario();
		cadres.setPergunta(pergunta.get());
		return cadres;
	}
	public void FAQUsuarioToBoundary(FAQUsuario cadres) {
		if (cadres != null) {
			pergunta.set(cadres.getPergunta());
		}
	}
	public void clearBoundary() {
		FAQUsuario cadres = new FAQUsuario();
		FAQUsuarioToBoundary(cadres);
					
	}
	
	public void cadastrar() {
		FAQUsuario cadres = boundaryToFAQUsuario();
		lista.add(cadres);
	}
	
	public ObservableList<FAQUsuario> getLista(){
		
		return this.lista;
	}
	public StringProperty nomeProperty() {
		return this.pergunta;
	}

}

