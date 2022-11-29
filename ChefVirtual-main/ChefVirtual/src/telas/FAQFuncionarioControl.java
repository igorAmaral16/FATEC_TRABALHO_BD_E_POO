package telas;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class FAQFuncionarioControl {
	private StringProperty pergunta = new SimpleStringProperty("");
	private StringProperty resposta = new SimpleStringProperty("");
	private ObservableList<FAQFuncionario> lista = FXCollections.observableArrayList();


	public FAQFuncionario boundaryToFAQFuncionario() {
		FAQFuncionario cadres = new FAQFuncionario();
		cadres.setPergunta(pergunta.get());
		cadres.setResposta(resposta.get());
		return cadres;
	}
	public void FAQFuncionarioToBoundary(FAQFuncionario cadres) {
		if (cadres != null) {
			pergunta.set(cadres.getPergunta());
			resposta.set(cadres.getResposta());
		}
	}
	public void clearBoundary() {
		FAQFuncionario cadres = new FAQFuncionario();
		FAQFuncionarioToBoundary(cadres);
					
	}
	
	public void cadastrar() {
		FAQFuncionario cadres = boundaryToFAQFuncionario();
		lista.add(cadres);
	}
	
	public ObservableList<FAQFuncionario> getLista(){
		
		return this.lista;
	}
	public StringProperty nomeProperty() {
		return this.pergunta;
	}

	public StringProperty userProperty() {
		return this.resposta;
	}

}

