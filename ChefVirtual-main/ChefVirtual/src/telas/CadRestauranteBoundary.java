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

public class CadRestauranteBoundary extends Application {
	private TextField txtNome = new TextField();
	private TextField txtEmail = new TextField();
	private PasswordField txtSenha = new PasswordField();
	private TextField txtcnpj = new TextField();
	private Button btnCadRes = new Button("CADASTRAR");
	private Button btnCadC = new Button("CADASTRO COMUM");
	private Button btnCadChef = new Button("CADASTRO CHEF");
	private CadRestauranteControl control = new CadRestauranteControl();
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
		stage.setTitle("Cadastro RESTAURANTE");
		setStage(stage);
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		CadRestauranteBoundary.stage = stage;
	}

	public void Action(Group root) {
		btnCadChef.setOnAction(e -> {
			control.cadastroChef();
		});

		btnCadC.setOnAction(e -> {
			control.cadastroComum();
		});

		btnCadRes.setOnAction(e -> {
			control.cadastrar();
		});

	}

	private void background(Group root) {
		Rectangle retangulo = new Rectangle(440, 80, 400, 500);
		retangulo.setArcHeight(20.0);
		retangulo.setArcWidth(20.0);
		retangulo.setFill(Color.rgb(255, 255, 255, 0.3));
		root.getChildren().add(retangulo);

		Image imgCadRes = new Image("imgs/CadRestaurante.png");
		ImageView vimg = new ImageView(imgCadRes);
		vimg.setFitHeight(500);
		vimg.setFitWidth(350);
		vimg.setLayoutX(100);
		vimg.setLayoutY(80);
		root.getChildren().add(vimg);

		Text titulo = new Text(490, 120, "CADASTRO RESTAURANTE");
		Font font = new Font("Arial Black", 22);
		titulo.setFont(font);
		titulo.setFill(Color.BROWN);
		root.getChildren().add(titulo);

		// sombra do titulo
		DropShadow sombra = new DropShadow(2, 0, 0, Color.WHITE);
		titulo.setEffect(sombra);

	}

	private void layoutItens(Group root) {
		Label lblNome = new Label("Nome do Restaurante:");
		lblNome.setLayoutX(480);
		lblNome.setLayoutY(150);
		txtNome.setLayoutX(480);
		txtNome.setLayoutY(170);
		txtNome.setPrefWidth(330.0);
		root.getChildren().addAll(lblNome, txtNome);

		Label lblcnpj = new Label("CNPJ:");
		lblcnpj.setLayoutX(480);
		lblcnpj.setLayoutY(200);
		txtcnpj.setLayoutX(480);
		txtcnpj.setLayoutY(220);
		txtcnpj.setPrefWidth(330.0);
		root.getChildren().addAll(lblcnpj, txtcnpj);

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

		Label lblmsg = new Label("É CHEF? Se cadastre e tenha acesso exclusivo!");
		lblmsg.setLayoutX(500);
		lblmsg.setLayoutY(480);
		root.getChildren().add(lblmsg);

	}

	private void botoes(Group root) {

		DropShadow sombra = new DropShadow(10, 2, 4, Color.GRAY);

		RadioButton rbAceito = new RadioButton("Aceito os termos de uso");
		rbAceito.setSelected(false);
		rbAceito.setLayoutX(480);
		rbAceito.setLayoutY(370);
		root.getChildren().add(rbAceito);

		btnCadRes.setLayoutX(480);
		btnCadRes.setLayoutY(420);
		btnCadRes.setPrefWidth(330.0);
		btnCadRes.setPrefHeight(35.0);
		btnCadRes.setTextFill(Color.WHITE);
		btnCadRes.setStyle("-fx-background-color: brown;");
		btnCadRes.setEffect(sombra);
		root.getChildren().add(btnCadRes);

		btnCadC.setLayoutX(480);
		btnCadC.setLayoutY(500);
		btnCadC.setPrefHeight(35.0);
		btnCadC.setPrefWidth(150.0);
		btnCadC.setTextFill(Color.WHITE);
		btnCadC.setStyle("-fx-background-color: brown;");
		btnCadC.setEffect(sombra);
		root.getChildren().add(btnCadC);

		btnCadChef.setLayoutX(650);
		btnCadChef.setLayoutY(500);
		btnCadChef.setPrefHeight(35.0);
		btnCadChef.setPrefWidth(160.0);
		btnCadChef.setTextFill(Color.WHITE);
		btnCadChef.setStyle("-fx-background-color: brown;");
		btnCadChef.setEffect(sombra);
		root.getChildren().add(btnCadChef);

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
