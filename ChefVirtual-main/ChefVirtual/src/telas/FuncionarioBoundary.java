package telas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FuncionarioBoundary extends Application {
	private TextField txtNome = new TextField();
	private TextField txtSobrenome = new TextField();
	private TextField txtEmail = new TextField();
	private PasswordField txtSenha = new PasswordField();
	private TextField txtCPF = new TextField();
	private Button btnCad = new Button("CADASTRAR");
	FuncionarioControl func = new FuncionarioControl();
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
		stage.setTitle("Cadastro Funcionario");
		setStage(stage);
			
	}
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		FuncionarioBoundary.stage = stage;
	}
	
	public void  Action(Group root) {
		btnCad.setOnAction(e -> {
			func.cadastrar();
	
		});
	
	
		
	}
	
	private void background(Group root) {
		Rectangle retangulo = new Rectangle(440, 80, 400, 500);
		retangulo.setArcHeight(20.0);
		retangulo.setArcWidth(20.0);
		retangulo.setFill(Color.rgb(255, 255, 255, 0.3));
		root.getChildren().add(retangulo);
		
		Image imgf = new Image("imgs/chefFunc.png");
		ImageView vimg = new ImageView(imgf);
		vimg.setFitHeight(500);
		vimg.setFitWidth(350);
		vimg.setLayoutX(100);
		vimg.setLayoutY(80);
		root.getChildren().add(vimg);
		
		Text titulo = new Text(490, 120, "CADASTRO FUNCIONARIO");
		Font font = new Font("Arial Black", 22);
		titulo.setFont(font);
		titulo.setFill(Color.BLUE);
		root.getChildren().add(titulo);

		// sombra do titulo
		DropShadow sombra = new DropShadow(2, 0, 0, Color.GRAY);
		titulo.setEffect(sombra);
		
	}

	private void layoutItens(Group root) {
		Label lblNome = new Label("Nome:");
		lblNome.setLayoutX(480);
		lblNome.setLayoutY(150);
		txtNome.setLayoutX(480);
		txtNome.setLayoutY(170);
		root.getChildren().addAll(lblNome, txtNome);

		Label lblSobrenome = new Label("Sobrenome:");
		lblSobrenome.setLayoutX(660);
		lblSobrenome.setLayoutY(150);
		txtSobrenome.setLayoutX(660);
		txtSobrenome.setLayoutY(170);
		root.getChildren().addAll(lblSobrenome, txtSobrenome);


		Label lblCPF = new Label("CPF:");
		lblCPF.setLayoutX(480);
		lblCPF.setLayoutY(200);
		txtCPF.setLayoutX(480);
		txtCPF.setLayoutY(220);
		txtCPF.setPrefWidth(330.0);
		root.getChildren().addAll(lblCPF, txtCPF);

		Label lblEmail = new Label("Email:");
		lblEmail.setLayoutX(480);
		lblEmail.setLayoutY(250);
		txtEmail.setLayoutX(480);
		txtEmail.setLayoutY(270);
		txtEmail.setPrefWidth(330.0);
		root.getChildren().addAll(lblEmail, txtEmail);

		Label lblSenha = new Label("Senha:");
		lblSenha.setLayoutX(480);
		lblSenha.setLayoutY(300);
		txtSenha.setLayoutX(480);
		txtSenha.setLayoutY(320);
		txtSenha.setPrefWidth(330.0);
		root.getChildren().addAll(lblSenha, txtSenha);
		
		
	}
	private void botoes(Group root) {

		DropShadow sombra = new DropShadow(10, 2, 4, Color.GRAY);


		btnCad.setLayoutX(480);
		btnCad.setLayoutY(420);
		btnCad.setPrefWidth(330.0);
		btnCad.setPrefHeight(35.0);
		btnCad.setTextFill(Color.WHITE);
		btnCad.setStyle("-fx-background-color: blue;");
		btnCad.setEffect(sombra);
		root.getChildren().add(btnCad);

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
