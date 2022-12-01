package telas;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import persistence.CadChefDao;
import persistence.CadFuncionarioDao;

public class FuncionarioControl {
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty sobrenome = new SimpleStringProperty("");
	private LongProperty cpf = new SimpleLongProperty(0);
	private StringProperty email = new SimpleStringProperty("");
	private StringProperty senha = new SimpleStringProperty("");
	
	private CadFuncionarioDao cDao = new CadFuncionarioDao();
	
	public Funcionario getEntity() {
		Funcionario f = new Funcionario();
		
		f.setCpf(cpf.get());
		f.setNome(nome.get());
		f.setSobrenome(sobrenome.get());
		f.setEmail(email.get());
		f.setSenha(senha.get());
		
		return f;
	}
	
	public void inserir() {
		verificarDados();
		
		if(verificarDados() == false) {
			Funcionario f = getEntity();
			try {
				cDao.criar(f);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "CADASTRO FEITO COM SUCESSO!!", "",  JOptionPane.WARNING_MESSAGE );
			
			limpar();
			
		} else {
			JOptionPane.showMessageDialog(null, "COMPLETE TODOS OS CAMPOS PARA SE CADASTRAR", "CAMPOS VAZIOS",  JOptionPane.WARNING_MESSAGE );
			
			FuncionarioBoundary fb = new FuncionarioBoundary();

				try {
					CadChefBoundary.getStage().close();
					fb.start(new Stage());
				} catch (Exception e) {
					// TODO: handle exception
				}
		}
		
	}
	
	public void pesquisar() {
		
	}
	
	public boolean verificarDados() { 
		boolean ver = false;
		
		if((		nome.get().isEmpty()
				||	sobrenome.get().isEmpty()
				||	email.get().isEmpty()
				||	senha.get().isEmpty())) {
			ver = true;
			
		} else { 
			ver = false;
		}
		
		return ver;
	}
	public void cadastrar() {
		LoginFunBoundary lf = new LoginFunBoundary();
		try {
			FuncionarioBoundary.getStage().close();
			lf.start(new Stage());			
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
	
	public void  limpar() {
		nome.set("");
		sobrenome.set("");
		cpf.set(0);
		email.set("");
		senha.set("");
	}

}
