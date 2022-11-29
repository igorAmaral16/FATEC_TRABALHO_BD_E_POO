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



public class LoginBoundary extends Application {
	private TextField txtEmail = new TextField();
	private PasswordField txtSenha = new PasswordField();
	private Button btnEntrar = new Button("ENTRAR");
	private Button btncad = new Button("CADASTRAR");
	LoginControl lc = new LoginControl();
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
		stage.setTitle("LOGIN CHEF VIRTUAL");
		
		setStage(stage);
		
	}
	
	
	public static Stage getStage() {
		return stage;
	}


	public static void setStage(Stage stage) {
		LoginBoundary.stage = stage;
	}

	public void  Action(Group root) {
		btnEntrar.setOnAction(e -> {
		lc.entrar();
		
		});
		
		btncad.setOnAction(e -> {
			lc.cadastrar();
			
		});
	}
	
	private void background(Group root) {
		Rectangle retangulo = new Rectangle(440, 80, 400, 500);
		retangulo.setArcHeight(20.0);
		retangulo.setArcWidth(20.0);
		retangulo.setFill(Color.rgb(255, 255, 255, 0.3));
		root.getChildren().add(retangulo);
		
		Image imglogin = new Image("imgs/imglogin.png");
		ImageView vimg = new ImageView(imglogin);
		vimg.setFitHeight(500);
		vimg.setFitWidth(350);
		vimg.setLayoutX(100);
		vimg.setLayoutY(80);
		root.getChildren().add(vimg);
		
		Text titulo = new Text(600, 200, "LOGIN");
		Font font = new Font("Arial Black", 25);
		titulo.setFont(font);
		titulo.setFill(Color.BROWN);
		root.getChildren().add(titulo);

		// sombra do titulo
		DropShadow sombra = new DropShadow(2, 0, 0, Color.WHITE);
		titulo.setEffect(sombra);
		
	}
	private void layoutItens(Group root) {

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
		
		Label lblmsgcad = new Label("Não possui ainda cadastro? Cadastre-se");
		lblmsgcad.setLayoutX(480);
		lblmsgcad.setLayoutY(450);
		root.getChildren().addAll(lblmsgcad);
		
		Label lblmsg = new Label("*");
		lblmsg.setLayoutX(520);
		lblmsg.setLayoutY(300);
		lblmsg.setTextFill(Color.RED);
		root.getChildren().add(lblmsg);
		
		Label lblerro = new Label("Preencher campos corretamente");
		lblerro.setLayoutX(480);
		lblerro.setLayoutY(350);
		lblerro.setTextFill(Color.RED);
		lblerro.setVisible(true);
		root.getChildren().add(lblerro);
		
		
	}
	private void botoes(Group root) {

		DropShadow sombra = new DropShadow(10, 2, 4, Color.GRAY);

		btnEntrar.setLayoutX(480);
		btnEntrar.setLayoutY(370);
		btnEntrar.setPrefWidth(330.0);
		btnEntrar.setPrefHeight(35.0);
		btnEntrar.setTextFill(Color.WHITE);
		btnEntrar.setStyle("-fx-background-color: brown;");
		btnEntrar.setEffect(sombra);
		root.getChildren().add(btnEntrar);
		
		btncad.setLayoutX(480);
		btncad.setLayoutY(480);
		btncad.setPrefWidth(330.0);
		btncad.setPrefHeight(35.0);
		btncad.setTextFill(Color.WHITE);
		btncad.setStyle("-fx-background-color: brown;");
		btncad.setEffect(sombra);
		root.getChildren().add(btncad);


	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}
}
