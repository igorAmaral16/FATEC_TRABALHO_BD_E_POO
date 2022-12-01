package telas;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LongStringConverter;

public class FAQFuncionarioBoundary  extends Application {
	private TextField txtpergunta = new TextField();
	private TextField txtresposta = new TextField();
	private TextField txtCpf = new TextField();
	private Button btnCadFAQ = new Button("CADASTAR FAQ");
	private Button btnAlterarFAQ = new Button("ALTERAR FAQ");
	private Button btnExcluirFAQ = new Button("EXCLUIR FAQ");
	private Button btnpes = new Button("PESQUISAR");
	private FAQFuncionarioControl control = new FAQFuncionarioControl();
	private static Stage stage;



	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scn = new Scene(root, 1000, 650, Color.DARKGRAY);
		Image img = new Image("imgs/chef1-2-removebg-preview.png");
		
		background(root);
		layoutItens(root);
		botoes(root);
		Action(root);

		stage.getIcons().add(img);
		stage.setScene(scn);
		stage.show();
		stage.setTitle("FAQ FUNCIONARIO");
		setStage(stage);
		

		ListView<FAQFuncionario> listafaq = new ListView<>(control.getLista());
		
		listafaq.setLayoutX(195);
		listafaq.setLayoutY(120);
		root.getChildren().add(listafaq);
	
		
	}
	
	
	
	public static Stage getStage() {
		return stage;
	}


	public static void setStage(Stage stage) {
		FAQFuncionarioBoundary.stage = stage;
	}

	public void  Action(Group root) {
		btnCadFAQ.setOnAction(e -> control.inserir());
		
		vincular();
	};
	private void background(Group root) {
		Rectangle retangulo = new Rectangle(440, 80, 400, 500);
		retangulo.setArcHeight(20.0);
		retangulo.setArcWidth(20.0);
		retangulo.setFill(Color.rgb(255, 255, 255, 0.3));
		root.getChildren().add(retangulo);

		
		Text titulo = new Text(530, 120, "FAQ FUNCIONARIO");
		Font font = new Font("Arial Black", 25);
		titulo.setFont(font);
		titulo.setFill(Color.BLUE);
		root.getChildren().add(titulo);

		// sombra do titulo
		DropShadow sombra = new DropShadow(2, 0, 0, Color.GRAY);
		titulo.setEffect(sombra);
		
	}

	private void layoutItens(Group root) {
		Label lblp = new Label("Pergunta:");
		lblp.setLayoutX(480);
		lblp.setLayoutY(150);
		txtpergunta.setLayoutX(480);
		txtpergunta.setLayoutY(170);
		txtpergunta.setPrefWidth(330.0);
		txtpergunta.setPrefHeight(50.0);
		root.getChildren().addAll(lblp, txtpergunta);
		
		Label lblC = new Label("CPF Funcionario:");
		lblC.setLayoutX(480);
		lblC.setLayoutY(230);
		txtCpf.setLayoutX(480);
		txtCpf.setLayoutY(250);
		txtCpf.setPrefWidth(330.0);
		txtCpf.setPrefHeight(50.0);
		root.getChildren().addAll(lblC, txtCpf);

		Label lblr = new Label("Resposta:");
		lblr.setLayoutX(480);
		lblr.setLayoutY(300);
		txtresposta.setLayoutX(480);
		txtresposta.setLayoutY(320);
		txtresposta.setPrefWidth(330.0);
		txtresposta.setPrefHeight(50.0);
		root.getChildren().addAll(lblr, txtresposta);

		
	}
	private void botoes(Group root) {

		DropShadow sombra = new DropShadow(10, 2, 4, Color.GRAY);

		btnCadFAQ.setLayoutX(480);
		btnCadFAQ.setLayoutY(420);
		btnCadFAQ.setPrefWidth(330.0);
		btnCadFAQ.setPrefHeight(35.0);
		btnCadFAQ.setTextFill(Color.WHITE);
		btnCadFAQ.setStyle("-fx-background-color: blue;");
		btnCadFAQ.setEffect(sombra);
		root.getChildren().add(btnCadFAQ);
		
		btnAlterarFAQ.setLayoutX(480);
		btnAlterarFAQ.setLayoutY(480);
		btnAlterarFAQ.setPrefWidth(150.0);
		btnAlterarFAQ.setPrefHeight(35.0);
		btnAlterarFAQ.setTextFill(Color.WHITE);
		btnAlterarFAQ.setStyle("-fx-background-color: blue;");
		btnAlterarFAQ.setEffect(sombra);
		root.getChildren().add(btnAlterarFAQ);
		
		btnExcluirFAQ.setLayoutX(660);
		btnExcluirFAQ.setLayoutY(480);
		btnExcluirFAQ.setPrefWidth(150.0);
		btnExcluirFAQ.setPrefHeight(35.0);
		btnExcluirFAQ.setTextFill(Color.WHITE);
		btnExcluirFAQ.setStyle("-fx-background-color: blue;");
		btnExcluirFAQ.setEffect(sombra);
		root.getChildren().add(btnExcluirFAQ);
		
		btnpes.setLayoutX(480);
		btnpes.setLayoutY(530);
		btnpes.setPrefWidth(330.0);
		btnpes.setPrefHeight(35.0);
		btnpes.setTextFill(Color.WHITE);
		btnpes.setStyle("-fx-background-color: blue;");
		btnpes.setEffect(sombra);
		root.getChildren().add(btnpes);


	}
	
	public void vincular() {
		
		StringConverter<? extends Number > converterNumber = new LongStringConverter();
		
		Bindings.bindBidirectional(txtCpf.textProperty(), control.cpfFuncionario(), (StringConverter)converterNumber);
		Bindings.bindBidirectional(control.perguntaProperty(), txtpergunta.textProperty());
		Bindings.bindBidirectional(control.respostaProperty(), txtresposta.textProperty());

	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}

