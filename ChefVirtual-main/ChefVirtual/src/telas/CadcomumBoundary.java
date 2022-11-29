package telas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CadcomumBoundary extends Application {
	private TextField txtNome = new TextField();
	private TextField txtSobrenome = new TextField();
	private TextField txtNascimento = new TextField();
	private TextField txtEmail = new TextField();
	private PasswordField txtSenha = new PasswordField();
	private TextField txtUser = new TextField();
	private Button btnCad = new Button("CADASTRAR");
	private Button btnCadChef = new Button("CADASTRO CHEF");
	private Button btnCadRes = new Button("CADASTRO RESTAURANTE");
	private CadComumControl control = new CadComumControl();
	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scn = new Scene(root, 1000, 650, Color.DARKGRAY);
		Image img = new Image("imgs/chef1-2-removebg-preview.png"); // img icone

		control.clearBoundary(); 
		
		background(root);
		layoutItens(root);
		botoes(root); 
		Action(root);
		

		stage.getIcons().add(img);
		stage.setScene(scn);
		stage.show();
		stage.setTitle("Cadastro Usuário Comum");
		setStage(stage);

	}
	

	public static Stage getStage() {
		return stage;
	}


	public static void setStage(Stage stage) {
		CadcomumBoundary.stage = stage;
	}


	public void  Action(Group root) {
		btnCadChef.setOnAction(e -> {
			control.cadastroChef();
			
		});
		
		btnCad.setOnAction(e -> {
			control.cadastrar();
		});
		
		btnCadRes.setOnAction(e -> {
			control.cadastroRestaurante();
		});
		
		
	}
	private void background(Group root) {
		Rectangle retangulo = new Rectangle(440, 80, 400, 500);
		retangulo.setArcHeight(20.0);
		retangulo.setArcWidth(20.0);
		retangulo.setFill(Color.rgb(255, 255, 255, 0.3));
		root.getChildren().add(retangulo);

		Image imgCad = new Image("imgs/CadUserComun.png");
		ImageView vimg = new ImageView(imgCad);
		vimg.setFitHeight(500);
		vimg.setFitWidth(350);
		vimg.setLayoutX(100);
		vimg.setLayoutY(80);
		root.getChildren().add(vimg);

		Text titulo = new Text(500, 150, "CADASTRO USUÁRIO");
		Font font = new Font("Arial Black", 25);
		titulo.setFont(font);
		titulo.setFill(Color.BROWN);
		root.getChildren().add(titulo);

		// sombra do titulo
		DropShadow sombra = new DropShadow(2, 0, 0, Color.GRAY);
		titulo.setEffect(sombra);

	}

	private void layoutItens(Group root) {

		Label lblNome = new Label("Nome:");
		lblNome.setLayoutX(480);
		lblNome.setLayoutY(180);
		txtNome.setLayoutX(480);
		txtNome.setLayoutY(200);
		root.getChildren().addAll(lblNome, txtNome);

		Label lblSobrenome = new Label("Sobrenome:");
		lblSobrenome.setLayoutX(660);
		lblSobrenome.setLayoutY(180);
		txtSobrenome.setLayoutX(660);
		txtSobrenome.setLayoutY(200);
		root.getChildren().addAll(lblSobrenome, txtSobrenome);

		Label lblNascimento = new Label("Nascimento:");
		lblNascimento.setLayoutX(480);
		lblNascimento.setLayoutY(230);
		txtNascimento.setLayoutX(480);
		txtNascimento.setLayoutY(250);
		root.getChildren().addAll(lblNascimento, txtNascimento);

		Label lblUser = new Label("User:");
		lblUser.setLayoutX(660);
		lblUser.setLayoutY(230);
		txtUser.setLayoutX(660);
		txtUser.setLayoutY(250);
		root.getChildren().addAll(lblUser, txtUser);

		Label lblEmail = new Label("Email:");
		lblEmail.setLayoutX(480);
		lblEmail.setLayoutY(280);
		txtEmail.setLayoutX(480);
		txtEmail.setLayoutY(300);
		txtEmail.setPrefWidth(330.0);
		root.getChildren().addAll(lblEmail, txtEmail);

		Label lblSenha = new Label("Senha:");
		lblSenha.setLayoutX(480);
		lblSenha.setLayoutY(330);
		txtSenha.setLayoutX(480);
		txtSenha.setLayoutY(350);
		txtSenha.setPrefWidth(330.0);
		root.getChildren().addAll(lblSenha, txtSenha);

		Label lblmsg = new Label("É CHEF ou RESTAURANTE? Se cadastre e tenha acesso exclusivo!");
		lblmsg.setLayoutX(475);
		lblmsg.setLayoutY(470);
		root.getChildren().add(lblmsg);

	}

	private void botoes(Group root) {

		DropShadow sombra = new DropShadow(10, 2, 4, Color.GRAY);

		RadioButton rbAceito = new RadioButton("Aceito os termos de uso");
		rbAceito.setSelected(false);
		rbAceito.setLayoutX(480);
		rbAceito.setLayoutY(380);
		root.getChildren().add(rbAceito);

		btnCad.setLayoutX(480);
		btnCad.setLayoutY(420);
		btnCad.setPrefWidth(330.0);
		btnCad.setPrefHeight(35.0);
		btnCad.setTextFill(Color.WHITE);
		btnCad.setStyle("-fx-background-color: brown;");
		btnCad.setEffect(sombra);
		root.getChildren().add(btnCad);

		btnCadChef.setLayoutX(480);
		btnCadChef.setLayoutY(500);
		btnCadChef.setPrefHeight(35.0);
		btnCadChef.setPrefWidth(150.0);
		btnCadChef.setTextFill(Color.WHITE);
		btnCadChef.setStyle("-fx-background-color: brown;");
		btnCadChef.setEffect(sombra);
		root.getChildren().add(btnCadChef);

		btnCadRes.setLayoutX(650);
		btnCadRes.setLayoutY(500);
		btnCadRes.setPrefHeight(35.0);
		btnCadRes.setPrefWidth(160.0);
		btnCadRes.setTextFill(Color.WHITE);
		btnCadRes.setStyle("-fx-background-color: brown;");
		btnCadRes.setEffect(sombra);
		root.getChildren().add(btnCadRes);

	}


	public static void main(String[] args) {
		Application.launch(args);
	}

}
