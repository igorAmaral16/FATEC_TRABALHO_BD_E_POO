package telas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MinhaContaBoundary extends Application {
	private static Stage stage;
	private TextField txtNome = new TextField();
	private TextField txtSobrenome = new TextField();
	private TextField txtemail = new TextField();
	private TextField txtsenha = new TextField();
	private Button btnSalvar = new Button("SALVAR ALTERAÇÕES");
	private Button btnExcluir = new Button("EXCLUIR CONTA");
	MinhaContaControl mcc = new MinhaContaControl();
	
	
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scn = new Scene(root, 1000, 650, Color.DARKGRAY);
		stage.setScene(scn);
		stage.show();
		stage.setTitle("Minha Conta");
		background(root);
		layoutItens(root);
		botoes(root);
		Action(root);
		setStage(stage);

	}
	
	

	public static Stage getStage() {
		return stage;
	}


	public static void setStage(Stage stage) {
		MinhaContaBoundary.stage = stage;
	}

	
	
	


	

	
	private void Action(Group root) {
		btnSalvar.setOnAction(e -> {
			mcc.salvar();
		});
		
		btnExcluir.setOnAction(e -> {
			mcc.excluir();
		});
		
		
	}

	
	private void background(Group root) {
		Rectangle retangulo = new Rectangle(320, 80, 400, 500);
		retangulo.setArcHeight(20.0);
		retangulo.setArcWidth(20.0);
		retangulo.setFill(Color.rgb(255, 255, 255, 0.3));
		root.getChildren().add(retangulo);
		
		
		Text titulo = new Text(440, 120, "Minha Conta");
		Font font = new Font("Arial Black", 25);
		titulo.setFont(font);
		titulo.setFill(Color.BROWN);
		root.getChildren().add(titulo);

		DropShadow sombra = new DropShadow(2, 0, 0, Color.GRAY);
		titulo.setEffect(sombra);
		
	
		
	}
	private void layoutItens(Group root) {		
		
		Label lblNome = new Label("Nome:");
		lblNome.setLayoutX(380);
		lblNome.setLayoutY(180);
		txtNome.setLayoutX(380);
		txtNome.setLayoutY(200);
		txtNome.setPrefWidth(250.0);
		root.getChildren().addAll(lblNome, txtNome);

		Label lblSobrenome = new Label("Sobrenome:");
		lblSobrenome.setLayoutX(380);
		lblSobrenome.setLayoutY(230);
		txtSobrenome.setLayoutX(380);
		txtSobrenome.setLayoutY(250);
		txtSobrenome.setPrefWidth(250.0);
		root.getChildren().addAll(lblSobrenome, txtSobrenome);
		
		Label lblsenha = new Label("Senha:");
		lblsenha.setLayoutX(380);
		lblsenha.setLayoutY(280);
		txtsenha.setLayoutX(380);
		txtsenha.setLayoutY(300);
		txtsenha.setPrefWidth(250.0);
		root.getChildren().addAll(lblsenha, txtsenha);
		
		
		
		Label lblem = new Label("EMAIL:");
		lblem.setLayoutX(380);
		lblem.setLayoutY(330);
		txtemail.setLayoutX(380);
		txtemail.setLayoutY(350);
		txtemail.setPrefWidth(250.0);
		root.getChildren().addAll(lblem, txtemail);



	}
	
	private void botoes(Group root) {

		DropShadow sombra = new DropShadow(10, 2, 4, Color.GRAY);
		btnSalvar.setLayoutX(350);
		btnSalvar.setLayoutY(500);
		btnSalvar.setPrefHeight(35.0);
		btnSalvar.setPrefWidth(150.0);
		btnSalvar.setTextFill(Color.WHITE);
		btnSalvar.setStyle("-fx-background-color: brown;");
		btnSalvar.setEffect(sombra);
		root.getChildren().add(btnSalvar);
		
		btnExcluir.setLayoutX(540);
		btnExcluir.setLayoutY(500);
		btnExcluir.setPrefHeight(35.0);
		btnExcluir.setPrefWidth(150.0);
		btnExcluir.setTextFill(Color.WHITE);
		btnExcluir.setStyle("-fx-background-color: brown;");
		btnExcluir.setEffect(sombra);
		root.getChildren().add(btnExcluir);


	}
	
		public static void main(String[] args) {
		Application.launch(MinhaContaBoundary.class, args);
	}
}