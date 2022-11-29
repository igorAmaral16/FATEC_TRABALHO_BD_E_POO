package telas;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;

public class IngredienteControl {
	private StringProperty nome =  new SimpleStringProperty("");
	private ObservableList<Ingrediente> lista = FXCollections.observableArrayList();
	
	
	public Ingrediente boundaryToIngrediente() {
		Ingrediente ing = new Ingrediente();
		ing.setNomeing(nome.get());
		return ing;
		
	}
	
	public void IngredientetoBoundary(Ingrediente ing) {
		if (ing != null) {
			nome.set(ing.getNomeing());
			
		}
	}
	
	
	public void adicionar() {
		Ingrediente ing = boundaryToIngrediente();
		
		lista.add(ing);
		
				
		
	}
	public void editar() {
		
	} 
	public void excluir() {
		
	}
	public void pesquisar() {
		
	}
	
	public ObservableList<Ingrediente> getLista(){
		
		return this.lista;
	}
	public StringProperty nomeProperty() {
		return this.nome;
		
	}


}