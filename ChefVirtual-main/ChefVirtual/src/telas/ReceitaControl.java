package telas;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReceitaControl {
	private StringProperty nome =  new SimpleStringProperty("");
	private ObservableList<Receita> lista = FXCollections.observableArrayList();
	
	
	public Receita boundaryToReceita() {
		Receita rec = new Receita();
		rec.setNomerec(nome.get());
		return rec;
		
	}
	
	public void ReceitaToBoundary(Receita rec) {
		if (rec != null) {
			nome.set(rec.getNomerec());
			
		}
	}
	
	
	public void adicionar() {
		Receita rec = boundaryToReceita();		
		lista.add(rec);
		
				
		
	}
	public void editar() {
		
	} 
	public void excluir() {
		
	}
	public void pesquisar() {
		
	}
	
	public ObservableList<Receita> getLista(){
		
		return this.lista;
	}
	public StringProperty nomeProperty() {
		return this.nome;
		
	}


}

