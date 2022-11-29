package telas;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import persistence.CadChefDao;

public class CadChefControl {
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty sobrenome = new SimpleStringProperty("");
	private LongProperty cpf = new SimpleLongProperty();
	private StringProperty email = new SimpleStringProperty("");
	private StringProperty senha = new SimpleStringProperty("");
	private StringProperty certificado = new SimpleStringProperty("");	
	private StringProperty nascimento = new SimpleStringProperty("");
	
	private CadChefDao cDao = new CadChefDao();
	
	public CadChef getEntity() {
		CadChef cf = new CadChef();
		
		cf.setCpf(cpf.get());
		cf.setNome(nome.get());
		cf.setSobrenome(sobrenome.get());
		cf.setNascimento(nascimento.get());
		cf.setEmail(email.get());
		cf.setSenha(senha.get());
		cf.setCertificado(certificado.get());
		
		return cf;
	}
	
	public void inserir() {
		verificarDados();
		CadChef cf = getEntity();
		cDao.criar(cf);
		limpar();
	}
	
	public void pesquisar() {
		
	}
	
	public void verificarDados() { 
		
		if((		nome.get().isEmpty()
				||	sobrenome.get().isEmpty()
				||	nascimento.get().isEmpty()
				||	email.get().isEmpty()
				||	senha.get().isEmpty()
				||	certificado.get().isEmpty())) {
			
			JOptionPane.showMessageDialog(null, "COMPLETE TODOS OS CAMPOS PARA SE CADASTRAR", "CAMPOS VAZIOS",  JOptionPane.WARNING_MESSAGE );
		}
	}
	public void verificarDados1() {
		LoginBoundary lg = new LoginBoundary();
		try {
			CadChefBoundary.getStage().close();
			lg.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void abrirCadastroComum() {
		CadcomumBoundary cdc = new CadcomumBoundary();

		try {
			CadChefBoundary.getStage().close();
			cdc.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void abrirCadastroRestaurante() {
		CadRestauranteBoundary cdr = new CadRestauranteBoundary();
		try {
			CadChefBoundary.getStage().close();
			cdr.start(new Stage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public StringProperty nomeProperty() {
		return this.nome;
	}
	public StringProperty sobrenomeProperty() {
		return this.sobrenome;
	}
	public LongProperty cpfProperty() {
		return this.cpf;
	}
	public StringProperty senhaProperty() {
		return this.senha;
	}		
	public StringProperty emailProperty() {
		return this.email;
	}
	public StringProperty certificadoProperty() {
		return this.certificado;
	}
	public StringProperty nascimentoProperty() {
		return this.nascimento;
	}
	
	public void  limpar() {
		nome.set("");
		sobrenome.set("");
		cpf.set(0);
		email.set("");
		senha.set("");
		certificado.set("");
		nascimento.set("");
	}
}



	
	
	

