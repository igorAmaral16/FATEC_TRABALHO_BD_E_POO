package telas;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import persistence.CadChefDao;
import persistence.CadFaqFuncionarioDao;



public class FAQFuncionarioControl {
	private StringProperty pergunta = new SimpleStringProperty("");
	private StringProperty resposta = new SimpleStringProperty("");
	private LongProperty funcionario = new SimpleLongProperty(0);
	private ObservableList<FAQFuncionario> lista = FXCollections.observableArrayList();

	private CadFaqFuncionarioDao cDao = new CadFaqFuncionarioDao();
	
	public FAQFuncionario getEntity() {
		FAQFuncionario ff = new FAQFuncionario();
		Funcionario f = new Funcionario();
		
		ff.setPergunta(pergunta.get());
		ff.setResposta(resposta.get());
		f.setCpf(funcionario.get());
		
		return ff;
	}
	
	public void inserir() {
		verificarDados();
		
		if(verificarDados() == false) {
			FAQFuncionario ff = getEntity();
			try {
				cDao.criar(ff);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "DUVIDA ENVIADA COM SUCESSO!!", "",  JOptionPane.WARNING_MESSAGE );
			
			limpar();
			
		} else {
			JOptionPane.showMessageDialog(null, "COMPLETE TODOS OS CAMPOS PARA ENVIAR A DUVIDA.", "CAMPOS VAZIOS",  JOptionPane.WARNING_MESSAGE );
			
			CadChefBoundary cf = new CadChefBoundary();

				try {
					CadChefBoundary.getStage().close();
					cf.start(new Stage());
				} catch (Exception e) {
					// TODO: handle exception
				}
		}
		
	}
	
	public void pesquisar() {
		
	}
	
	public boolean verificarDados() { 
		boolean ver = false;
		
		if((		pergunta.get().isEmpty()
				||	resposta.get().isEmpty())) {
			ver = true;
			
		} else { 
			ver = false;
		}
		
		return ver;
	}
	
	
	public ObservableList<FAQFuncionario> getLista(){
		return this.lista;
	}
	public StringProperty perguntaProperty() {
		return this.pergunta;
	}

	public StringProperty respostaProperty() {
		return this.resposta;
	}	
	
	public LongProperty cpfFuncionario() {
		return this.funcionario;
	}
	
	public void  limpar() {
		pergunta.set("");
		resposta.set("");

	}
}

